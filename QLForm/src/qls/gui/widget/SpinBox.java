package qls.gui.widget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.UIManager;
import javax.swing.SpinnerListModel;

import ql.ast.statement.Question;
import ql.gui.widget.FieldOption;
import ql.gui.widget.FieldOptions;
import ql.gui.widget.QLWidget;
import ql.gui.widget.WidgetConfiguration;
import ql.visiting.EvaluationContext;
import ql.visiting.value.Value;


public class SpinBox extends QLWidget {
	private JPanel panel;
	private JSpinner spinbox;
	private FieldOptions options;
	private Map<String, FieldOption> optionsMap; // key = label, val = option

	// configuration
	private WidgetConfiguration config = new WidgetConfiguration(
			UIManager.getDefaults().getFont("Spinner.font"),
			Color.BLACK, new Dimension(120, 15));

	//constructor
	public SpinBox(Question question, FieldOptions options, EvaluationContext ctx) {
		super(question.getIdentifier().toString(), options.getDefaultOption().getValue(), ctx);
		
		List<String> labels = new ArrayList<>();
		optionsMap = new HashMap<>();
		for (FieldOption option : options.getOptions()) {
			optionsMap.put(option.getLabel(), option);
		}
		
		// collect labels of options to create spinner
		for (String val:  optionsMap.keySet()) {
			labels.add(val);
		}
		spinbox = new JSpinner(new SpinnerListModel(labels));
		spinbox.addChangeListener(e -> {
			//set option value
			setValue(optionsMap.get(spinbox.getValue()).getValue());
		});
		panel = new JPanel(new BorderLayout());
		panel.add(spinbox, BorderLayout.CENTER);
		this.options = options;
		setValueToUI(getDefaultValue()); // default value
		setConfiguration(config);
	}

	@Override
	public WidgetConfiguration getConfiguration() {
		return config;
	}

	@Override
	public void setConfiguration(WidgetConfiguration config) {
		spinbox.setPreferredSize(new Dimension(config.getWidth(), config.getHeight()));
		spinbox.setFont(config.getFont());
		spinbox.setForeground(config.getColor());
		panel.setPreferredSize(new Dimension(160, 30));
	}

	@Override
	public JComponent getJComponent() {
		return panel;
	}

	@Override
	public Value getValueFromUI() {
		return optionsMap.get(spinbox.getValue()).getValue();
	}

	@Override
	public void setVisibility(boolean visible) {
		panel.setVisible(visible);
	}

	@Override
	public void setEditability(boolean editable) {
		spinbox.setEnabled(editable);
	}
	
	@Override
	public void setValueToUI(Value value) {
		spinbox.setValue(options.getOptionByValue(value).getLabel());
	}
}