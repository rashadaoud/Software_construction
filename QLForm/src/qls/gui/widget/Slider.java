package qls.gui.widget;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Map;
import java.util.HashMap;
import java.util.Hashtable;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.UIManager;

import ql.ast.statement.Question;
import ql.gui.widget.FieldOption;
import ql.gui.widget.FieldOptions;
import ql.gui.widget.QLWidget;
import ql.gui.widget.WidgetConfiguration;
import ql.visiting.EvaluationContext;
import ql.visiting.value.Value;


public class Slider extends QLWidget {
	private JPanel panel;
	private JSlider slider;
	private Hashtable<Integer, JLabel> labels; // labels to be rendered
	private FieldOptions options;
	private Map<Integer, FieldOption> optionsMap; // key = slider-value, val = option

	// configuration
	private WidgetConfiguration config = new WidgetConfiguration(
				UIManager.getDefaults().getFont("Label.font"),
				Color.BLACK, new Dimension(150, 20) );

	//constructor
	public Slider(Question question, FieldOptions options, EvaluationContext ctx) {
		super(question.getIdentifier().toString(), options.getDefaultOption().getValue(), ctx);
		int min = 0;
		int max = options.getOptions().size() - 1;
		int val = options.optionIndexOf(options.getDefaultOption());
		slider = new JSlider(min, max, val);
		//inspired by https://docs.oracle.com/javase/tutorial/uiswing/components/slider.html
		slider.addChangeListener(e -> { 
				if (!slider.getValueIsAdjusting()) { //sliding is done, get UI value
					setValue(getValueFromUI());
				}
			});
		optionsMap = new HashMap<>();
		labels = new Hashtable<>();
		for (FieldOption option : options.getOptions()) {
			int index = options.optionIndexOf(option);
			optionsMap.put(index,  option);
			labels.put(index, new JLabel(option.getLabel()));
		}
		slider.setLabelTable(labels);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(1);
		panel = new JPanel(new BorderLayout());
		panel.add(slider, BorderLayout.CENTER);
		this.options = options;
		setConfiguration(config);
	}

	@Override
	public void setVisibility(boolean visible) {
		slider.setVisible(visible);
	}

	@Override
	public void setEditability(boolean editable) {
		slider.setEnabled(editable);
	}

	@Override
	public void setConfiguration(WidgetConfiguration config) {
		slider.setPreferredSize(new Dimension(config.getWidth(), config.getHeight()));
		slider.setFont(config.getFont());
		for (JLabel label: labels.values()) {
			label.setForeground(config.getColor());
		}
		panel.setPreferredSize(new Dimension(120, 30));
	}

	@Override
	public WidgetConfiguration getConfiguration() {
		return config;
	}

	@Override
	public JComponent getJComponent() {
		return panel;
	}
	
	@Override
	public Value getValueFromUI() {
		// get value of selected option
		return optionsMap.get(slider.getValue()).getValue();
	}

	@Override
	public void setValueToUI(Value value) {
		int index = options.optionIndexOf(options.getOptionByValue(value));
		slider.setValue(index); // select option
	}
}
