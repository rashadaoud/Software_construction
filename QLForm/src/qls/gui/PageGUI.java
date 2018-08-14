package qls.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JComponent;
import javax.swing.Box;

import ql.gui.QuestionGUI;
import qls.ast.Page;
import qls.ast.Section;

public class PageGUI {
	private JComponent component;
	private Page page;
	private List<SectionGUI> sections = new ArrayList<>();

	public PageGUI(Page page, List<QuestionGUI> questions) {
		JLabel label = new JLabel(page.getName());
		label.setFont(new Font("TimesRoman", Font.BOLD, 20));
		Box box = Box.createHorizontalBox();
		box.add(label);
		box.add(Box.createHorizontalGlue());
		component = Box.createVerticalBox();
		component.add(box);

		//for each section, prepare component and create object with all questions mentioned in stylesheet
		for (Section section : page.getSections()) {
			SectionGUI sectionGUI = 
					new SectionGUI(section, section.getFilteredQuestionsGui(questions));
			sections.add(sectionGUI);
			component.add(sectionGUI.getJComponent());
			component.add(Box.createRigidArea(new Dimension(0, 2)));
		}
		this.page = page;
	}

	public JComponent getJComponent() {
		return component;
	}

	public String pageLabel() {
		return page.getName();
	}
}