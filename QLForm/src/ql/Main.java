import java.io.File;
import java.io.IOException;


import ql.checking.TypeChecker;
import ql.gui.FormGUI;
import ql.gui.QlPageGenerator;
import ql.ast.Form;


public class Main {
	
	public static void main(String[] args) throws IOException {

		String qlPath = "";
	
		if (args.length != 0){
			qlPath = args[0];  	
		} else {
			qlPath = "resources/questionnaire.ql";
		}
	
	    File qlFile = new File(qlPath);
	    
	    try {
	    	// 1- Generate ast tree
	    	Form form = Form.parseFileToForm(qlFile);
	   
	    	// 2- Run type checker on generated ql form 
	        TypeChecker checker = new TypeChecker();
	        if (checker.runChecker(form)) { // only if checker didn't detect issues, render
		        // 3- Generate gui for the ql form
		        FormGUI qlform = new QlPageGenerator().createFormGUI(form);
		        qlform.render();
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	
	  }
}
