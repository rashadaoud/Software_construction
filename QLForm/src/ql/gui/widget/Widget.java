package ql.gui.widget;

import javax.swing.JComponent;

import ql.visiting.value.Value;


public interface Widget {

	public JComponent getJComponent();
	public WidgetConfiguration getConfiguration();
	public void setConfiguration(WidgetConfiguration style);
	public Value getValue();
	public void setValue(Value value);

	public void setEditability(boolean editable);
	public void setVisibility(boolean visible);
}
