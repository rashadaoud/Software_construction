package qls.gui;

import java.awt.Component;
import java.awt.Font;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;


public class SideMenuGUI extends JList<PageGUI> {
	//constructor
	public SideMenuGUI(List<PageGUI> pages) {
		super(pages.toArray(new PageGUI[pages.size()]));
		setCellRenderer(new CellRenderer());
	}

	//javax.swing.ListCellRenderer
	private class CellRenderer extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(
				JList<?> pagesList,
				Object obj,
				int index,
				boolean isSelected,
				boolean cellHasFocus) {
			
			JLabel cellTitle =  (JLabel) super.getListCellRendererComponent(
					pagesList, obj, index, isSelected, cellHasFocus);
			cellTitle.setText(((PageGUI) obj).pageLabel());
			cellTitle.setFont(new Font("TimesRoman", Font.BOLD +  Font.ITALIC, 20));
			return cellTitle;
		}
	}
}
