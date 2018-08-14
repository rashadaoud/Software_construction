package ql.visiting;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.List;

import ql.visiting.value.Value;
import ql.ast.expression.Expression;

public class EvaluationContext {

	private Map<String, Value> values;
	private Map<String, Expression> calculatedValues;
	private List<ContextListener> listeners;

	public EvaluationContext() {
		values = new HashMap<String, Value>();
		calculatedValues = new HashMap<String, Expression>();
		listeners = new ArrayList<>();
	}
	
	// for GUI
	@FunctionalInterface
	public static interface ContextListener {
		public void contextChanged(EvaluationContext context);
	}
	

	public void addListener(ContextListener listener) {
		listeners.add(listener);
	}
	
	private void informContextListener() {
		for (ContextListener listener : listeners) {
			listener.contextChanged(this);
		}
	}


	public void compute() {
		boolean changeExists = false;
		for (Map.Entry<String, Expression> entry : calculatedValues.entrySet()) {
			Expression expr = entry.getValue();
			Value newValue = EvaluationVisitor.evaluate(expr, this);
			Value oldValue = values.put(entry.getKey(), newValue);

			// value changed, change flag
			if (!Objects.equals(oldValue, newValue)){
				changeExists = true;
			}
		}
		// at least one value changed, re-compute all
		if (changeExists) {
			compute();
		}
	}
	
	public void insertCalculatedValue(String key, Expression expr) {
		calculatedValues.put(key, expr);
	}
	

	public Value getValue(String key) {
		return values.get(key);
	}


	public void setValue(String key, Value newValue) {
		Value oldValue =  values.put(key, newValue);
		
		// if there is a change, compute and inform listener about the change
		if (!Objects.equals(oldValue, newValue)) {
			compute();
			informContextListener();
		}
	}
}
