package analysis;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import javax.annotation.Nonnull;
import sootup.core.jimple.common.stmt.JInvokeStmt;
import sootup.core.jimple.common.stmt.Stmt;
import sootup.core.model.SootMethod;
import sootup.core.signatures.MethodSignature;
import sootup.java.core.JavaSootMethod;
import sootup.java.core.views.JavaView;

public class ForbiddenMethodDetectionTransformer implements Consumer<JavaSootMethod> {

    private final JavaView view;
    String methodName;
    String returnType;

    public ForbiddenMethodDetectionTransformer(JavaView view, String methodName, String returnType){
        this.view = view;
        this.methodName = methodName;
        this.returnType = returnType;
    }

    @Override
    public void accept(@Nonnull JavaSootMethod method) {
    // TODO: modify this method to make it more precise, so that it only finds a call to the actual
    // forbiddenMethod()
    List<Stmt> stmtList = method.getBody().getStmts();
        for(Stmt u : stmtList){
            if(u instanceof JInvokeStmt){
                JInvokeStmt invoke = (JInvokeStmt) u;
                final MethodSignature invokeMethodSignature = invoke.getInvokeExpr().getMethodSignature();
                String invokeName = invokeMethodSignature.getName();
                if(!invokeName.equals(methodName)) {
                    continue;
                }
                final Optional<? extends SootMethod> methodOpt = view.getMethod(invokeMethodSignature);
                if (!methodOpt.isPresent()) {
                    continue;
                }
                String invokeReturnType = methodOpt.get().getReturnType().toString();
                if (invokeReturnType.equals(returnType)) {
                  System.out.println(
                      "Found a call to forbidden method! in " + method.getSignature().getName());
                  System.out.println(invoke);
                }
            }
        }
    }
}
