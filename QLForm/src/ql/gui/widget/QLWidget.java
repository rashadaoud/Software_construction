package ql.gui.widget;

import javax.swing.SwingUtilities;

import ql.visiting.value.Value;
import ql.visiting.EvaluationContext;


public abstract class QLWidget implements Widget {
	
	private String variable;
	private Value defaultValue;
	private EvaluationContext ctx;
	
	//preparation for interactive gui & qls
	public abstract Value getValueFromUI();
	public abstract void setValueToUI(Value value);

	// constructor
	public QLWidget(String variable, Value defaultValue, EvaluationContext ctx) {
		this.variable = variable;
		this.defaultValue = defaultValue;
		ctx.setValue(this.variable, this.defaultValue);
		this.ctx = ctx;
	}

	public Value getDefaultValue() {
		return defaultValue;
	}
	
	@Override
	public Value getValue() {
		return getValueFromUI();
	}
	
	@Override
	public void setValue(Value value) {
		ctx.setValue(variable, value);
		// threading, value changed
		SwingUtilities.invokeLater(() -> {
			if (!getValueFromUI().equals(value)){
				setValueToUI(value);
			}
		});
	}
}