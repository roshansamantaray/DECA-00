package base;

import org.junit.Before;
import sootup.core.inputlocation.AnalysisInputLocation;
import sootup.core.types.ClassType;
import sootup.java.bytecode.inputlocation.JavaClassPathAnalysisInputLocation;
import sootup.java.core.JavaProject;
import sootup.java.core.JavaSootClass;
import sootup.java.core.JavaSootMethod;
import sootup.java.core.language.JavaLanguage;
import sootup.java.core.views.JavaView;

import java.io.File;
import java.util.Optional;
import java.util.function.Consumer;

public abstract class TestSetup {

	protected JavaView view;

	@Before
	final public void setUp() throws Exception {

		String classPath = System.getProperty("user.dir") + File.separator + "target" + File.separator + "test-classes";
		AnalysisInputLocation<JavaSootClass> inputLocation = new JavaClassPathAnalysisInputLocation(classPath);
		JavaLanguage language = new JavaLanguage(8);

		JavaProject project = JavaProject.builder(language).addInputLocation(inputLocation).build();
		view = project.createView();
	}


	public final void executeStaticAnalysis(Class<?> clazz, Consumer<JavaSootMethod> consumer) {

		final ClassType classType = view.getIdentifierFactory().getClassType(clazz.getName());

		final Optional<JavaSootClass> classOpt = view.getClass(classType);
		if(!classOpt.isPresent()){
			throw new IllegalArgumentException( classType + " not found.");
		}

		// iterate over all methods in that class
		for (JavaSootMethod method : classOpt.get().getMethods()) {
			consumer.accept(method);
		}

	}

}
