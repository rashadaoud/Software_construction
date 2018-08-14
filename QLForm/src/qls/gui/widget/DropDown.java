package qls.gui.widget;

import java.util.Map;
import java.util.HashMap;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JComponent;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.UIManager;

import ql.ast.statement.Question;
import ql.gui.widget.FieldOption;
import ql.gui.widget.FieldOptions;
import ql.gui.widget.QLWidget;
import ql.gui.widget.WidgetConfiguration;
import ql.visiting.EvaluationContext;
import ql.visiting.value.Value;


public class DropDown extends QLWidget {
	private JPanel panel;
	private JComboBox<String> comboBox; // for adding labels of all options
	private FieldOptions options;
	private Map<String, FieldOption> optionsMap; // key = label, val = option

	// configuration
	private WidgetConfiguration config = new WidgetConfiguration(
				UIManager.getDefaults().getFont("ComboBox.font"),
				Color.BLACK, new Dimension(120, 15));

	//constructor
	public DropDown(Question question, FieldOptions options, EvaluationContext ctx) {
		super(question.getIdentifier().toString(), options.getDefaultOption().getValue(), ctx);
		optionsMap = new HashMap<>();
		comboBox = new JComboBox<>();
		
		//add options to the combo
		comboBox.addActionListener(e -> {
			setValue(optionsMap.get(comboBox.getSelectedItem()).getValue());
		});
		for (FieldOption option : options.getOptions()) {
			optionsMap.put(option.getLabel(), option);
			comboBox.addItem(option.getLabel());
		}
		panel = new JPanel(new BorderLayout());
		panel.add(comboBox, BorderLayout.CENTER);
		setValueToUI(getDefaultValue()); // default value
		this.options = options;
		setConfiguration(config);
	}

	@Override
	public WidgetConfiguration getConfiguration() {
		return config;
	}

	@Override
	public void setConfiguration(WidgetConfiguration config) {
		comboBox.setPreferredSize(new Dimension(config.getWidth(), config.getHeight()));
		comboBox.setFont(config.getFont());
		comboBox.setForeground(config.getColor());
		panel.setPreferredSize(new Dimension(120, 30));
	}

	@Override
	public Value getValueFromUI() {
		return optionsMap.get(comboBox.getSelectedItem()).getValue();
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
		comboBox.setEditable(editable);
	}
	
	@Override
	public void setValueToUI(Value value) {
		FieldOption option = options.getOptionByValue(value);
		comboBox.setSelectedIndex(options.optionIndexOf(option));
	}
}