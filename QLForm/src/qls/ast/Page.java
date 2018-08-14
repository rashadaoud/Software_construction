package qls.ast;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import ql.ast.AstNode;
import ql.gui.QuestionGUI;


public class Page extends AstNode {
	
	private final String name;
	private final List<Section> sections;

	// constructor
	public Page(String name, List<Section> sections) {
		this.name = name;
		this.sections = sections;
	}
	
	public String getName() {
		return name;
	}

	public List<Section> getSections() {
		return Collections.unmodifiableList(sections);
	}

	public List<QuestionGUI> getFilteredQuestionsGui(List<QuestionGUI> questions) {
		List<QuestionGUI> filteredQuestionsGui = new ArrayList<>();
		sections.stream().forEach(section ->
			filteredQuestionsGui.addAll(section.getFilteredQuestionsGui(questions)));
		return Collections.unmodifiableList(filteredQuestionsGui);
	}
	
}
