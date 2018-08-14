package ql.gui;

import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;

import ql.visiting.EvaluationContext;
import ql.visiting.EvaluationContext.ContextListener;
import ql.visiting.EvaluationVisitor;
import ql.visiting.value.BooleanValue;
import ql.ast.expression.Expression;
import ql.ast.statement.Question;
import ql.gui.widget.Widget;


public class QuestionGUI implements ContextListener {
	
	private JPanel panel;
	private Widget label;
	private Widget value;
	
	private Question question;
	private Expression enableExpression;
	private Expression computableExpression;

	// constructor
	public QuestionGUI(
					EvaluationContext ctx,
					Question question,
					Widget label,
					Widget value,
					Expression enableExpression,
					Expression computableExpression) {
		
		panel = new JPanel(new BorderLayout());
		panel.setMinimumSize(new Dimension(250, 50));
		panel.setMaximumSize(new Dimension(800, 200));
		panel.setPreferredSize(new Dimension(700, 200));
		panel.add(label.getJComponent(), BorderLayout.CENTER);
		panel.add(value.getJComponent(), BorderLayout.EAST);
	
		this.label = label;
		this.value = value;
		this.question = question;
		this.enableExpression = enableExpression;
		this.computableExpression = computableExpression;

		if (computableExpression != null) {
			this.value.setEditability(false);
			ctx.insertCalculatedValue(question.getIdentifier().toString(), computableExpression);
		}

		// evaluate expression and checks if result is equal to true
		boolean visible = EvaluationVisitor.evaluate(enableExpression, ctx).equals(BooleanValue.TRUE);
		setVisibility(visible);
			
		ctx.addListener(this);
	}
	

	public Question getQuestion() {
		return question;
	}

	public String getName() {
		return question.getIdentifier().toString();
	}
	
	public JComponent getJComponent() {
		return panel;
	}


	private void setVisibility(boolean visible) {
		SwingUtilities.invokeLater(() -> {
			label.setVisibility(visible);
			value.setVisibility(visible);
		});
	}
	
	// set value & visibility of the widget in case of change
	@Override
	public void contextChanged(EvaluationContext ctx) {
		// evaluate expression and checks if result is equal to true
		boolean visible = EvaluationVisitor.evaluate(enableExpression, ctx).equals(BooleanValue.TRUE);
		setVisibility(visible);
		if (computableExpression != null) {
			value.setValue(ctx.getValue(question.getIdentifier().toString())); // for evaluator
		}
	}
}