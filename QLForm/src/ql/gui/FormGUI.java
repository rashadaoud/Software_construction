package ql.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.util.Collections;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.BoxLayout;

public class FormGUI {
	
	//list of questions
	private List<QuestionGUI> questions;

	// constructor
	public FormGUI(List<QuestionGUI> questions) {
		this.questions = questions;
	}

	public List<QuestionGUI> getQuestions() {
		return Collections.unmodifiableList(questions);
	}

	// rendering method
	public void render() {
		JFrame frame = new JFrame();
		JPanel mainPanel = new JPanel();
		JComponent formPane;
		
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		for (QuestionGUI q : getQuestions()){
			JComponent questionPanel = q.getJComponent();
			mainPanel.add(questionPanel);
			mainPanel.add(Box.createRigidArea(new Dimension(0,2)));
		}
		JScrollPane scrollPane = new JScrollPane(mainPanel);
		scrollPane.setPreferredSize(new Dimension(500, 800));

		formPane = Box.createHorizontalBox();
		formPane.add(Box.createHorizontalGlue());
		formPane.add(scrollPane);
		formPane.add(Box.createHorizontalGlue());

		frame.setSize(700, 900);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setContentPane(formPane);
		frame.setAutoRequestFocus(true);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Tax return form");
		frame.setVisible(true);
	}
}