package exercises;

import analysis.StatementClassifier;
import base.TestSetup;
import org.junit.Test;

import target.exercise1.SampleClass;

public class Exercise3 extends TestSetup {

    @Test
    public void testStatementCount(){
        executeStaticAnalysis(SampleClass.class, StatementClassifier::classify);
    }

}