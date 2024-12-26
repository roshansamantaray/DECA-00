package exercises;

import analysis.StatementCounter;
import base.TestSetup;
import org.junit.Test;
import target.exercise1.SampleClass;

public class Exercise2 extends TestSetup {

    @Test
    public void testStatementCount(){
        executeStaticAnalysis(SampleClass.class, StatementCounter::countStmts);
    }

}
