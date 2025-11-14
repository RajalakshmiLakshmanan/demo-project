package test.demo;

import java.util.HashMap;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class TestRunner {
	
	
	public static void main(String[] args) {
		TestNG testng = new TestNG();
        String driverPath = args[0];
        String filePath = args[1];
		
		
        // Create an XML suite and test
        XmlSuite suite = new XmlSuite();
        suite.setName("Suite");

        XmlTest test = new XmlTest(suite);
        test.setName("Test");

        // Add the class to the test
        XmlClass testClass = new XmlClass("test.demo.SubmitForm");
        test.getClasses().add(testClass);

        // Define parameters for the test
        Map<String, String> parameters = new HashMap<>();
        parameters.put("chromeDriverPath",driverPath);
        parameters.put("filePath",filePath);
        test.setParameters(parameters);

        // Add the suite to the list of suites to be run
        testng.setXmlSuites(java.util.Collections.singletonList(suite));

        // Run TestNG
        testng.run();
    } 
         
	}


