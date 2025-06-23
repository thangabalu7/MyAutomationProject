package Demo.ReusableFuction;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class RetryAnalyzer  implements IRetryAnalyzer{

	int count =0;
	int maximum=3;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<maximum)
		{
			count++;
			return true;  // Tells TestNG to RETRY the test again
		}
		return false;  // Tell TestNG to STOP retrying
	}
}
