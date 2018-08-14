package ql.gui.widget;

import java.util.Map;
import java.util.LinkedHashMap;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

import ql.visiting.EvaluationContext;
import ql.ast.statement.Question;
import ql.visiting.value.Value;


public class RadioBtn extends QLWidget implements ActionListener {
	
	private JPanel panel;
	private FieldOptions options;
	private Map<FieldOption, JRadioButton> radioButtons;

	// configuration
	private WidgetConfiguration config = new WidgetConfiguration(
			UIManager.getDefaults().getFont("RadioButton.font"), Color.BLACK, new Dimension(60, 40));

	// constructor
	public RadioBtn(Question question, FieldOptions options, EvaluationContext ctx) {
		// widget (question id, default value, context)
		super(question.getIdentifier().toString(), options.getDefaultOption().getValue(), ctx);
		radioButtons = new LinkedHashMap<>();
		panel = new JPanel();
	    ButtonGroup group = new ButtonGroup();

		for (FieldOption option : options.getOptions()) {
			JRadioButton radioBtn = new JRadioButton(option.getLabel());
			radioBtn.setActionCommand(option.getLabel());
			radioBtn.addActionListener(this);
			group.add(radioBtn);
			radioButtons.put(option, radioBtn); //key = option, val= radioBtn
			panel.add(radioBtn);
		}
		this.options = options;
		//default option selected
		setValueToUI(getDefaultValue());
		setConfiguration(config);
	}

	@Override
	public WidgetConfiguration getConfiguration() {
		return config;
	}

	// set radio & panel styling from configuration object
	@Override
	public void setConfiguration(WidgetConfiguration config) {
		for (JRadioButton radio : radioButtons.values()) {
			radio.setPreferredSize(new Dimension(config.getWidth(), config.getHeight()));
			radio.setFont(config.getFont());
			radio.setForeground(config.getColor());
		}
		panel.setPreferredSize(new Dimension(150, 30));
	}

	@Override
	public JComponent getJComponent() {
		return panel;
	}

	@Override
	public Value getValueFromUI() {
		for (FieldOption option : options.getOptions()) {
			if (radioButtons.get(option).isSelected()) {
				return option.getValue(); // return value of selected option
			}
		}
		return null; // nothing is selected
	}


	@Override
	public void setVisibility(boolean visible) {
		for (JRadioButton radio : radioButtons.values()) {
			radio.setVisible(visible);
			radio.validate();
		}
		panel.setVisible(visible);
	}

	@Override
	public void setEditability(boolean editable) {
		for (JRadioButton radio : radioButtons.values()) {
			radio.setEnabled(editable);
		}
		panel.setEnabled(editable);
	}
	
	@Override
	public void setValueToUI(Value value) {
		FieldOption option = options.getOptionByValue(value);
		radioButtons.get(option).setSelected(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setValue(options.getOptionByLabel(e.getActionCommand()).getValue());
	}
}