package listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer {
	@Override
	public void transform(final ITestAnnotation annotation, final Class testClass, final Constructor testConstructor,
			final Method testMethod) {
		annotation.setRetryAnalyzer(Retry.class);
	}
}



/*ITestAnnotation annotation: Represents the annotation of the current test method. By modifying this, you can set properties dynamically.
Class testClass: The class in which the test method is declared.
Constructor testConstructor: The constructor of the test method (if applicable).
Method testMethod: The actual test method being executed.  
annotation.setRetryAnalyzer(Retry.class); This line tells TestNG to use the Retry class (defined previously) as the retry analyzer for the test method. As a result, if the test method fails, the retry logic defined in the Retry class will automatically apply   */