package ql.gui.widget;

import java.util.Collections;
import java.util.List;

import ql.visiting.value.Value;

public class FieldOptions {
	
	private List<FieldOption> options;
	private FieldOption defaultOption;

	// constructor
	public FieldOptions(List<FieldOption> options, FieldOption defaultValue) {
		this.options = options;
		this.defaultOption = defaultValue;
	}

	public List<FieldOption> getOptions() {
		return Collections.unmodifiableList(options);
	}
	
	public FieldOption getDefaultOption() {
		return defaultOption;
	}
	
	public FieldOption getOptionByLabel(String label) {
		for (FieldOption option : options) {
			if (option.getLabel() == label) {
				return option;
			}
		}
		return null;
	}

	public FieldOption getOptionByValue(Value value) {
		for (FieldOption option : options) {
			if (option.getValue().eq(value).getValue()){
				return option;
			}
		}
		return null;
	}

	public int optionIndexOf(FieldOption option) {
		return options.indexOf(option);
	}
	
}