package exercises;

import analysis.ForbiddenMethodDetectionTransformer;
import base.TestSetup;
import org.junit.Test;

import target.exercise1.SampleClass;

public class Exercise4 extends TestSetup {

    @Test
    public void testStatementCount(){
        executeStaticAnalysis(SampleClass.class, new ForbiddenMethodDetectionTransformer(view, "forbiddenMethod", "void"));
    }

}