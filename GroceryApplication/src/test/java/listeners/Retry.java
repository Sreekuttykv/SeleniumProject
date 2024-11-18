package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Retry implements IRetryAnalyzer {

	private static final Logger LOG = LogManager.getLogger("Retry.class"); // .getLogger ("Retry.class"); this logger is initialized to track and log test retry attempts Using Log4j (LogManager.getLogger), it outputs details about each retry attempt in the logs.
	private static final int maxTry = 3;   // max number of retry attempts
	private int count = 0;               // keeps track of how many times the retry has been attempted for the current test case.

	@Override
	public boolean retry(final ITestResult iTestResult) {
		if (!iTestResult.isSuccess()) {      //if the test fails
			if (this.count < maxTry) {       // and the retry count is less than max try
				LOG.info("Retrying test " + iTestResult.getName() + " with status "
						+ getResultStatusName(iTestResult.getStatus()) + " for the " + (this.count + 1) + " time(s).");
				this.count++;
				return true; //indicates a retry attempt
			}
		}
		return false;  //no more retries, so the test will not rerun
	}

	public String getResultStatusName(final int status) {
		String resultName = null;
		if (status == 1) {
			resultName = "SUCCESS";
		}
		if (status == 2) {
			resultName = "FAILURE";
		}
		if (status == 3) {
			resultName = "SKIP";
		}
		return resultName;
	}
}
