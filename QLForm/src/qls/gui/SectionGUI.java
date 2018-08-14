package qls.gui;

import java.util.List;
import java.awt.ComponentOrientation;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.border.TitledBorder;

import ql.gui.QuestionGUI;
import qls.ast.Section;

public class SectionGUI {
	
	private JComponent component;
	private Section section;
	private List<QuestionGUI> questions; //TODO review, might not be needed as property

	//construction
	public SectionGUI(Section section, List<QuestionGUI> questions) {
		component = Box.createVerticalBox();
		TitledBorder sectionTitle =  BorderFactory.createTitledBorder(section.getName());
		sectionTitle.setTitleJustification(TitledBorder.LEFT);
		component.setBorder(sectionTitle);
		component.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		for (QuestionGUI question : questions) {
			component.add(question.getJComponent());
			component.add(Box.createRigidArea(new Dimension(0, 2)));
		}
		this.section = section;
		this.questions = questions;
	}
	
	public JComponent getJComponent() {
		return component;
	}
}