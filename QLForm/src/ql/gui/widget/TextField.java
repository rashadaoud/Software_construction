package ql.gui.widget;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComponent;

import ql.visiting.EvaluationContext;
import ql.visiting.value.Value;
import ql.ast.statement.Question;


public class TextField extends QLWidget {

	private JPanel panel;
	private JTextField input;

	// configuration
	private WidgetConfiguration config = new WidgetConfiguration(
			UIManager.getDefaults().getFont("TextField.font"), Color.BLACK, new Dimension(150,40));
	
	// credit to http://www.java2s.com/Code/Java/Swing-JFC/AddkeylistenereventhandlertoJTextField.htm
	private KeyAdapter adapter = new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			setValue(getValueFromUI()); //default value which is mostly ""
		} 
	};

	
	// constructor
	public TextField(Question question, Value defaultValue, EvaluationContext ctx) {
		super(question.getIdentifier().toString(), defaultValue, ctx);
		panel = new JPanel();
		input = new JTextField();
		input.setEditable(true);
		input.addKeyListener(adapter);
		panel.add(input);
		
		setConfiguration(config);
	}


	@Override
	public WidgetConfiguration getConfiguration() {
		return config;
	}

	// set input styling from configuration object
	@Override
	public void setConfiguration(WidgetConfiguration config) {
		input.setMinimumSize(new Dimension(4,2));
		input.setPreferredSize(new Dimension(config.getWidth(), config.getHeight()));
		input.setFont(config.getFont());
		input.setForeground(config.getColor());
	}

	@Override
	public Value getValueFromUI() {
		return getDefaultValue().translate(input.getText());
	}

	
	@Override
	public JComponent getJComponent() {
		return panel;
	}

	@Override
	public void setVisibility(boolean visible) {
		input.setVisible(visible);
		input.invalidate();
		//render again
		panel.repaint();
	}

	@Override
	public void setEditability(boolean editable) {
		input.setEditable(editable);
	}
	
	@Override
	public void setValueToUI(Value value) {
		if (value != null) {
			input.setText(value.getValueString()); //set text representation of Value
		} else {
			input.setText(""); //no default value, empty string
		}
	}
}