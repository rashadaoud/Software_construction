package qls.gui.widget;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.UIManager;

import ql.ast.statement.Question;
import ql.gui.widget.FieldOption;
import ql.gui.widget.FieldOptions;
import ql.gui.widget.QLWidget;
import ql.gui.widget.WidgetConfiguration;
import ql.visiting.EvaluationContext;
import ql.visiting.value.Value;


public class CheckBox extends QLWidget {
	private JPanel panel;
	private JCheckBox checkBox;
	private FieldOptions options;
	
	// configuration
	private WidgetConfiguration config = new WidgetConfiguration(
				UIManager.getDefaults().getFont("CheckBox.font"),
				Color.BLACK, new Dimension(100, 10));

	//constructor
	public CheckBox(Question question, FieldOptions options, EvaluationContext ctx) {
		super(question.getIdentifier().toString(), options.getDefaultOption().getValue(), ctx);
		checkBox = new JCheckBox();
		checkBox.addChangeListener(e -> {
			if (checkBox.isSelected()) {
				setValue(options.getOptions().get(0).getValue());
			} else {
				setValue(options.getOptions().get(1).getValue());
			}
		});
		this.options = options;
		panel = new JPanel(new BorderLayout());
		panel.add(checkBox);
		setValueToUI(getDefaultValue()); // default value
		setConfiguration(config);
	}

	@Override
	public WidgetConfiguration getConfiguration() {
		return config;
	}

	@Override
	public void setConfiguration(WidgetConfiguration config) {
		checkBox.setPreferredSize(new Dimension(config.getWidth(), config.getHeight()));
		checkBox.setFont(config.getFont());
		checkBox.setForeground(config.getColor());
		panel.setPreferredSize(new Dimension(120, 20));
	}

	@Override
	public Value getValueFromUI() {
		if (checkBox.isSelected()) {
			return options.getOptions().get(0).getValue();
		}
		return options.getOptions().get(1).getValue();
	}

	@Override
	public JComponent getJComponent() {
		return panel;
	}
	
	@Override
	public void setVisibility(boolean visible) {
		panel.setVisible(visible);
	}

	@Override
	public void setEditability(boolean editable) {
		checkBox.setEnabled(editable);
	}
	
	@Override
	public void setValueToUI(Value value) {
		FieldOption option = options.getOptionByValue(value);
		if (options.optionIndexOf(option)== 0) {
			checkBox.setSelected(true);
			return;
		} 
		checkBox.setSelected(false);
	}
}