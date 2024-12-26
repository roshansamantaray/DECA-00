package analysis;


import sootup.core.jimple.common.stmt.JAssignStmt;
import sootup.core.jimple.common.stmt.JInvokeStmt;
import sootup.core.jimple.common.stmt.Stmt;
import sootup.java.core.JavaSootMethod;

import javax.annotation.Nonnull;
import java.util.List;

public class StatementClassifier {

    public static void classify(@Nonnull JavaSootMethod method) {
        System.out.println("Method: " + method.getSignature().getName());
        List<Stmt> stmtList = method.getBody().getStmts();
        for(Stmt stmt: stmtList){
            if(stmt instanceof JInvokeStmt){
                JInvokeStmt invoke = (JInvokeStmt) stmt;
                System.out.println(invoke.toString() + " is an InvokeStmt");
            }else if(stmt instanceof JAssignStmt){
                System.out.println(stmt + " is an AssignStmt");
            }
            // TODO: what other types of statements can you find?
        }
    }
}
