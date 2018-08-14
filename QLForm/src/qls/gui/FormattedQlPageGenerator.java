package qls.gui;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.awt.Dimension;
import java.math.BigDecimal;

import ql.ast.Form;
import ql.ast.statement.Question;
import ql.ast.type.*;
import ql.gui.QlPageGenerator;
import ql.gui.widget.*;
import ql.visiting.EvaluationContext;
import ql.visiting.TypeVisitor;
import ql.visiting.value.*;
import qls.ast.StyleSheet;
import qls.ast.rule.Item;
import qls.ast.rule.QuestionItem;
import qls.ast.style.*;
import qls.ast.widget.*;
import qls.gui.widget.*;
import qls.visiting.StyleVisitor;
import qls.visiting.WidgetVisitor;


public class FormattedQlPageGenerator extends QlPageGenerator {
	private StyleSheet styleSheet;

	//constructor
	public FormattedQlPageGenerator(StyleSheet styleSheet) {
		this.styleSheet = styleSheet;
	}


	@Override
	public FormattedFormGUI createFormGUI(Form form) {
		return new FormattedFormGUI(super.createFormGUI(form), styleSheet);
	}
	

	@Override
	public Widget createValueWidget(Question question, EvaluationContext ctx) {
		Widget widget;
		WidgetConfiguration config;
		// get the item from style sheet formatting question
		QuestionItem item = styleSheet.getQuestionItem(question);
		if (item != null) {
			//create widget-ui for the question
			widget = createWidgetGUI(item, question, ctx);
			
			//pass default config for widget of the question, and
			//generate new config with styles from styling properties linked to the item
			config = setStyling(item, widget.getConfiguration());
			
			// style widget with the new configuration properties
			widget.setConfiguration(config);
			return widget;
		}
		throw new IllegalStateException("Found question without item in stylesheet!");
	}

	private Widget createWidgetGUI(Item item, Question question, EvaluationContext ctx) {
		Type type;
		AstWidget widget = item.getWidget();
		type = question.getType();

		return widget.accept(new WidgetVisitor<Widget, Void>() {

			/* text input for all types */
			@Override
			 public Widget visit(AstTextField widget, Void ctx2) {
				 return type.accept(new TypeVisitor<Widget, Void>() {
					 
					 // type visitor found undefined type, no widget is created
					@Override
					public Widget visit(UndefinedType type, Void ctx2) {
						throw new IllegalStateException("Error WidgetInterface: Value type is undefined!");
					}

					@Override
					public Widget visit(BooleanType type, Void ctx2) {
						//default false, no radio button, text instead
						return new TextField(question, BooleanValue.FALSE, ctx);
					}
					
					@Override
					public Widget visit(StringType type, Void ctx2) {
						//default empty string
						return new TextField(question, new StringValue(""), ctx);
					}
					
					@Override
					public Widget visit(MoneyType type, Void ctx2) {
						//default 0.0
						return new TextField(question, new MoneyValue(BigDecimal.valueOf(0.0)), ctx);
					}

					@Override
					public Widget visit(IntegerType type, Void ctx2) {
						//default 0
						return new TextField(question,new IntegerValue(0), ctx);
					}

					@Override
					public Widget visit(DecimalType type, Void ctx2) {
						//default 0.0
						return new TextField(question, new DecimalValue(0.0), ctx);
					}

					@Override
					public Widget visit(DateType type, Void ctx2) {
						//default today
						return new TextField(question, new DateValue(new Date()), ctx);
					}
				},
				null);
			 }
			
			/* radio */
			 @Override
			 public Widget visit(AstRadioBtn widget, Void ctx2) {
				 return new RadioBtn(question, createOptionsForWidget(type, widget), ctx);
			 }

			 /* checkbox */
			 @Override
			 public QLWidget visit(AstCheckBox widget, Void ctx2) {
				 return new CheckBox(question, createOptionsForWidget(type, widget), ctx);
			 }
			 
			 /* drop-down list */
			 @Override
			 public Widget visit(AstDropDown widget, Void ctx2) {
				 return new DropDown(question, createOptionsForWidget(type, widget), ctx);
			 }

			 /* slider */
			 @Override
			 public Widget visit(AstSlider widget, Void ctx2) {
				 return new Slider(question, createOptionsForWidget(type, widget), ctx);
			 }

			 /* spin-box */
			 @Override
			 public Widget visit(AstSpinbox widget, Void ctx2) {
				 return new SpinBox(question, createOptionsForWidget(type, widget), ctx);
			 }

			/* no widget specified in stylesheet, use ql */
			@Override
			public Widget visit(AstWidgetDefault widget, Void ctx2) {
                return FormattedQlPageGenerator.super.createValueWidget(question, ctx);
			}
		 },
		 null);
	}


	// create value from text, all types
	private Value createValueGUI(Type type, String text) {
		return type.accept(new TypeVisitor<Value, Void>() {
			
			// type visitor found undefined type, no widget is created
			 @Override
			 public Value visit(UndefinedType type, Void ctx) {
				 throw new UnsupportedOperationException(
							"Error WidgetInterface: Value type is undefined!");
			 }

			 @Override
			 public Value visit(BooleanType type, Void ctx) {
				 return new BooleanValue(text);
			 }


			 @Override
			 public Value visit(StringType type, Void ctx) {
				 return new StringValue(text);
			 }
			 
			 @Override
			 public Value visit(DecimalType type, Void ctx) {
				 return new MoneyValue(new BigDecimal(text));
			 }

			 @Override
			 public Value visit(DateType type, Void ctx) {
				 DateFormat format = new SimpleDateFormat("dd-mm-yyyy");
				 Date date = null;
				 try {
					 date = format.parse(text);
				 } catch (ParseException e) {
					 e.printStackTrace();
				 }
				 return new DateValue(date);
			 }

			 @Override
			 public Value visit(IntegerType type, Void ctx) {
				 return new IntegerValue(Integer.parseInt(text));
			 }
			 
			 @Override
			 public Value visit(MoneyType type, Void ctx) {
				 return new MoneyValue(new BigDecimal(text));
			 }
		 },
		 null);
	}
	
	// for multi-options widgets, such as checkbox, radiobtn
	private FieldOptions createOptionsForWidget(Type type, AstSelectionWidget widget) {
		FieldOption defaultOption = null;
		List<FieldOption> options = new ArrayList<>();
		
		//for every option
		for (String value : widget.getOptions()) {
			options.add(new FieldOption(value, createValueGUI(type, value)));
		}

		//create default option
		if (widget.getDefaultOption() != null) {
			defaultOption = new FieldOption(
					widget.getDefaultOption(), createValueGUI(type, widget.getDefaultOption()));
		}
		return new FieldOptions(options, defaultOption);
	}

	private WidgetConfiguration setStyling(Item item, WidgetConfiguration defaultConfig) {
		//create new configuration from default one,
		//in case some styling properties or all of them are not present in QLS stylesheet
		WidgetConfiguration newConfig = new WidgetConfiguration(
				defaultConfig.getFont(), defaultConfig.getColor(), new Dimension(defaultConfig.getWidth(), defaultConfig.getHeight()));

		//go through all properties, visit and set found formatting
		for (StyleProperty prop : item.getProperties()) {
			prop.accept(new StyleVisitor<Void, Void>() {
				@Override
				public Void visit(Height h, Void ctx2) {
					newConfig.setHeight(h.getHeightVal());
					return null;
				}

				@Override
				public Void visit(Width w, Void ctx2) {
					newConfig.setWidth(w.getWidthVal());
					return null;
				}

				@Override
				public Void visit(FontName fn, Void ctx2) {
					newConfig.setFontName(fn.getName());
					return null;
				}

				@Override
				public Void visit(FontSize fs, Void ctx2) {
					newConfig.setFontSize(fs.getSize());
					return null;
				}
				
				@Override
				public Void visit(FontColor fc, Void ctx2) {
					newConfig.setFontColor(fc.getColor());
					return null;
				}
			},
			null);
		}
		//return new configuration to style the question
		return newConfig;
	}
}
