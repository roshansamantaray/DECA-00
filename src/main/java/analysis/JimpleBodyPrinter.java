package analysis;

import sootup.java.core.JavaSootMethod;

import javax.annotation.Nonnull;

public class JimpleBodyPrinter {
    public static void print(@Nonnull JavaSootMethod method) {
        System.out.println("Method name:" + method.getSignature().getName());
        System.out.println(method.getBody());
    }
}
