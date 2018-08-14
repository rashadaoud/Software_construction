package ql.checking.cyclicDependency;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Collections;

import ql.ast.expression.Expression;
import ql.ast.statement.ComputedQuestion;

public class QuestionDependencyData {
	
	private Map<String, QuestionDependency> dependencyMap; // <id, dependency>
  
	public QuestionDependencyData() {
		dependencyMap = new HashMap<>(); // empty map at the beginning
	}

	public Set<QuestionDependency> getDependencies() {
		return Collections.unmodifiableSet(new HashSet<QuestionDependency>(dependencyMap.values()));
	}
	
	public void setDependencies(Map<String, QuestionDependency> dependencyMap) {
		this.dependencyMap = dependencyMap;
	}
	
	public QuestionDependency getDependency(String id) {
		return dependencyMap.computeIfAbsent(id, qd -> new QuestionDependency(id));
	}

	public void add(ComputedQuestion question) {
		Expression expression = question.getExpression();
		QuestionDependency dependency = getDependency(question.getIdentifier().toString());
		for (String var:expression.collectVariables()) {
			dependency.addDependency(var);
		}
	}


	// inner-class
	public class QuestionDependency {
		
		private String id;
	    private List<QuestionDependency> dependencies = new ArrayList<>();

	    QuestionDependency(String id) { this.id = id; }
	    
	    public String toString(){ return id; }

	    public void addDependency(String id) {
	    	dependencies.add(getDependency(id));
	    }

	    public List<QuestionDependencyData.DependencyPath> getCirclePaths() {
	    	List<QuestionDependencyData.DependencyPath> circlePaths;
	    	circlePaths = new ArrayList<>();
	    	// check for each circle add it to paths
	    	getPaths().forEach(path -> {
	    		if (path.hasCircle()) {circlePaths.add(path); }
	    	});
	    	return Collections.unmodifiableList(circlePaths);
	    }

	    private List<QuestionDependencyData.DependencyPath> getPaths() {
	    	return getPaths(new DependencyPath());
	    }
	    

	    public List<QuestionDependencyData.DependencyPath> getPaths(QuestionDependencyData.DependencyPath parentPath){
	    	List<QuestionDependencyData.DependencyPath> paths;
	    	QuestionDependencyData.DependencyPath currentPath;
	    	// extend path with the new dependency
	    	currentPath = parentPath.extend(this);
	    	// reached end of path
	    	if (isLeaf()){
	    		return Collections.singletonList(currentPath);
	    	}
	    	// circle found, exit to avoid inf
	    	if (currentPath.hasCircle(this)){
	    		return Collections.singletonList(currentPath);
	    	}
	    	paths = new ArrayList<>();
	    	for (QuestionDependency qd : dependencies){
	    		paths.addAll(qd.getPaths(currentPath));
	    	}
	    	// return all dependency paths for current dependency
	    	return Collections.unmodifiableList(paths);
	    }
	    

	    public boolean hasDependencies(){
	    	return dependencies.isEmpty();
	    }

	    public boolean isLeaf() {
	    	return hasDependencies();
	    }
	}
			
	// inner-class
	public static class DependencyPath {
		
		private List<QuestionDependency> dependencies;
	
		public DependencyPath() {
			dependencies = new ArrayList<>();
		}
		
		public DependencyPath(QuestionDependencyData.DependencyPath path) {
			dependencies = new ArrayList<>(path.dependencies);
	    }
		
		public String toString() {
	    	StringBuilder builder;
	    	builder = new StringBuilder();
	    	dependencies.stream().forEachOrdered(qd -> {
		        if (builder.length() > 0) {
		        	builder.append(" --> ");
		        }
		        builder.append(qd.id);
	    	});
	    	return builder.toString();  //"A --> B --> C"
	    }
		

		public boolean hasCircle() {
	    	for (QuestionDependency qd : dependencies) {
		    	// current path has a circle?
		        if (hasCircle(qd)) {
		        	return true;
		        }
	    	}
	    	return false;
	    }
	
	    public boolean hasCircle(QuestionDependency qd) {
	    	if (frequency(qd) > 1)
	    		return true;
	    	return false;
	    }
	
		public QuestionDependencyData.DependencyPath extend(QuestionDependency qd) {
			QuestionDependencyData.DependencyPath path = new DependencyPath(this);
			path.dependencies.add(qd); // extend the list of current with the extra dependency
			return path;
	    }
	
		public int frequency(QuestionDependency qd) {
	    	// return of frequency of a certain qd to happen in current dependency path
	    	return Collections.frequency(dependencies, qd);
	    }
	}

}
