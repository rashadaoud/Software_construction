package qls.ast.widget;

import java.util.Collections;
import java.util.List;


public abstract class AstSelectionWidget extends AstWidget {
	private List<String> options;
	private String defaultOption;

	//constructor
	public AstSelectionWidget(List<String> options, String defaultOption) {
		this.options = options;
		this.defaultOption = defaultOption;
	}

	public List<String> getOptions() {
		return Collections.unmodifiableList(options);
	}

	public String getDefaultOption() {
		return defaultOption;
	}
}