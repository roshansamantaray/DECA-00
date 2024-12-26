package exercises;

import analysis.JimpleBodyPrinter;
import base.TestSetup;
import org.junit.Test;
import target.exercise1.SampleClass;


public class Exercise1 extends TestSetup {

    @Test
    public void testJimplePrint(){
        executeStaticAnalysis(SampleClass.class, JimpleBodyPrinter::print);
    }

}
