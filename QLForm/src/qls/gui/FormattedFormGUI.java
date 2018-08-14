package qls.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import ql.gui.FormGUI;
import ql.gui.QuestionGUI;
import qls.ast.StyleSheet;
import qls.ast.Page;


public class FormattedFormGUI extends FormGUI {
	
	private JPanel panel;
	private JList<PageGUI> pages;

	// QL form with formatting from QLS
	public FormattedFormGUI(FormGUI form, StyleSheet styleSheet) {
		super(form.getQuestions());
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		List<PageGUI> pagesgui = createPagesGUI(styleSheet.getPages());
		
		//create side-menu as list of pages
		pages = new SideMenuGUI(pagesgui);
		
		//get selected page from side-menu and re-paint
		pages.addListSelectionListener(e -> renderPage(pages.getSelectedValue()));
		
	    pages.setBackground(Color.LIGHT_GRAY);
	}


	private List<PageGUI> createPagesGUI(List<Page> pages) {
		List<PageGUI> pagesgui = new ArrayList<>();
		//for every page, get questions, and create gui
		for (Page page : pages) {
			List<QuestionGUI> questions = page.getFilteredQuestionsGui(getQuestions());
			pagesgui.add(new PageGUI(page, questions));
		}
		return pagesgui;
	}
	
	//each time the user selects different page from side-menu, remove content from box,re-add and re-paint
	private void renderPage(PageGUI page) {
		SwingUtilities.invokeLater(() -> {
			panel.removeAll();
			panel.add(page.getJComponent());
			panel.validate();
			panel.repaint();
		});
	}
	
	// override of FormGUI.render()
	@Override
	public void render() {
		JScrollPane sideMenuScrollPane = new JScrollPane(pages);
		sideMenuScrollPane.setMaximumSize(new Dimension(100, 600));
		sideMenuScrollPane.setPreferredSize(new Dimension(100, 600));

		JScrollPane contentScrollPane = new JScrollPane(panel);
		sideMenuScrollPane.setMaximumSize(new Dimension(500, 800));
		contentScrollPane.setPreferredSize(new Dimension(400, 600));
		
		JComponent contentPane = Box.createHorizontalBox();
		//add side-menu list
		contentPane.add(sideMenuScrollPane);
		//add content pane
		contentPane.add(contentScrollPane);

		//create the main frame
		JFrame frame = new JFrame();
		frame.setSize(700, 900);
		frame.setAutoRequestFocus(true);
		frame.setLocationRelativeTo(null);
		frame.setContentPane(contentPane);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setTitle("Formatted tax return form");
		frame.setVisible(true);
		
		//set selection to first page-gui generated
		pages.setSelectedIndex(0);
	}
}