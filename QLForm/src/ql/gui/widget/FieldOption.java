package ql.gui.widget;

import ql.visiting.value.Value;

public class FieldOption {
	private String label;
	private Value value;

	// constructor
	public FieldOption(String label, Value value) {
		this.label = label;
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public Value getValue() {
		return value;
	}
	
	public boolean equals(FieldOption option) {
		return (label == option.label) && value.eq(option.value).getValue();
	}
	
	@Override
	public String toString() {
		return "Field option: " + label + ": " + value;
	}
}
