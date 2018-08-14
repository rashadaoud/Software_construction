package test.ql;
/**
 * Test TypeChecker methods such as:
 * 	detectDuplicatedQuestions
 * 	detectCyclicDependencies
 * 	detectReferenceToUndefinedQuestion
 * 	detectInvalidTypesAndConditions
 */

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import ql.ast.Form;
import ql.ast.literal.Identifier;
import ql.ast.statement.IfThenElseStatement;
import qls.Main;

import org.junit.Assert.assertTrue;
import org.junit.Assert.assertEquals;

public class TypeCheckTest {
    @Test
    public void testTypeChecker() throws IOException {
    	List<String> qlPrograms = new ArrayList<>();
    	
    	qlPrograms.add("resources/questionnaire_duplicatedQuestions.ql");
    	qlPrograms.add("resources/questionnaire_cyclicDependency.ql");
    	qlPrograms.add("resources/questionnaire_undefinedQuestion.ql");
    	qlPrograms.add("resources/questionnaire_invalidTypesAndConditions.ql");

    	for (String qlPath: qlProgams) {
    		File qlFile = new File(qlPath);
    	    if (qlFile != null) {
    	    	 try {
    		    	Main qlMain = new Main();
    		    	// checker will abort in case of error, and it will display issues
    		    	qlMain.main([qlPath]);
    	    	 } catch (Exception e) {
    		        e.printStackTrace();
    		    }
     	    }
    	}
    }
}
