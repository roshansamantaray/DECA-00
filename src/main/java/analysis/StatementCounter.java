package analysis;

import sootup.java.core.JavaSootMethod;

import javax.annotation.Nonnull;

public class StatementCounter {

    public static void countStmts(@Nonnull JavaSootMethod method) {
        long count = method.getBody().getStmts().size();
        System.out.println("Method: " + method.getSignature().getName());
        System.out.println("has " + count + " statements");

    }
}
