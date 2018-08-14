package test.ql;
/**
 * Test Parsing QL program and generating right ast
 */

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import ql.ast.Form;
import ql.ast.literal.Identifier;
import ql.ast.statement.IfThenElseStatement;
import org.junit.Assert.assertTrue;
import org.junit.Assert.assertEquals;

public class ParseFormTest {
    @Test
    public void checkForm(String[] args) throws IOException {
    	String qlPath = "";
		if (args.length != 0){
			qlPath = args[0];  	
		} else {
			qlPath = "resources/questionnaire.ql";
		}
		
	    File qlFile = new File(qlPath);
	    if (qlFile != null) {
	    	 try {
		    	Form form = Form.parseFileToForm(qlFile);
		    	Identifier id = form.getId();
		    	String expectedId = "Box1HouseOwning";
		    	String extractedId = id.toString(); 
	
		        assertTrue(form != null);
		        assertEquals(expectedName, extractedId);
		        
		        int expectedSize = 4;
		        int extractedSize = form.getBlock().getStatements().size();

		        assertEquals(expectedSize, extractedSize);
		    	
	    	 } catch (Exception e) {
		        e.printStackTrace();
		    }
 	    }
    }
}
