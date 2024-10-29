package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtenetReport implements ITestListener {
	ExtentSparkReporter sparkReporter;  //This class handles the creation and configuration of an HTML report
	ExtentReports reports; //Main report manager class, managing the lifecycle of the report.
	ExtentTest test;  // Represents each test case that is added to the report.

	public void configureReport() {
		Date date = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy_hhmmss");   //Sets a timestamp to create a unique report file each time by using SimpleDateFormat.
		String strDate = formatter.format(date);  //formatter is an instance of SimpleDateFormat, which formats the date object (current date and time).

		File reportPath = new File(System.getProperty("user.dir") + "//ExtentReport"); //to get project directory(ExtentReport-folder to store the generated reports) 

		if (!reportPath.exists()) {    //check if the folder exist
			reportPath.mkdir();
		}
		sparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "//ExtentReport//" + "ExtentReport_" + strDate + ".html");
		reports = new ExtentReports();   //ExtentReports is initialized to manage the reporting lifecycle, adding tests, and logging results.
		reports.attachReporter(sparkReporter);  // associates the ExtentReports instance with sparkReporter, specifying that sparkReporter will handle the HTML report generation.

		reports.setSystemInfo("Project", "GroceryApplication");  //adding project details
		reports.setSystemInfo("PC Name", "Sreekutty K V");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("Test Done By", "Sreekutty");		
		sparkReporter.config().setDocumentTitle("Obsqura GroceryApplication ");
		sparkReporter.config().setReportName("Report Summary");
		sparkReporter.config().setTheme(Theme.STANDARD);
	}	

	public void onTestSuccess(ITestResult result) {    // Logs successful test cases.
		test = reports.createTest(result.getName());  ////Creates a new test in the report with the test name and logs it as PASS with a green label.
		test.log(Status.PASS,
				MarkupHelper.createLabel("Name of the Passed Test Case is : " + result.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {   // Logs failed test cases.
		test = reports.createTest(result.getName());
		test.log(Status.FAIL,
				MarkupHelper.createLabel("Name of the Failed Test Case is : " + result.getName(), ExtentColor.RED));
		if (result.getStatus() == ITestResult.FAILURE) {
			test.fail("Test failed");
			String failureReason = result.getThrowable().getMessage();  //Logs the failure reason and stack trace.
			test.log(Status.FAIL, "Failure Reason: " + failureReason);
			test.fail(result.getThrowable());
			//test.addScreenCaptureFromPath(
			//System.getProperty("user.dir") + "\\OutputScreenshots\\" + result.getName() + ".png");
		}
	}

	public void onTestSkipped(ITestResult result) {   //Logs skipped test cases.
		test = reports.createTest(result.getName());
		test.log(Status.SKIP,
				MarkupHelper.createLabel("Name of the skipped test case is : " + result.getName(), ExtentColor.YELLOW));  //Creates a test entry and marks it as SKIP with a yellow label.
	}
	
	public void onStart(ITestContext context) {  //Configures the report before the suite starts.
		configureReport();   //Calls configureReport() to set up the report.
		// Delete the testoutput folder before the suite starts
        File testOutputFolder = new File("target/testoutput");
        if (testOutputFolder.exists()) {
            deleteFolder(testOutputFolder);
        }
	}
	private void deleteFolder(File folder) {   //Deletes files and subfolders recursively within the specified folder.
        File[] files = folder.listFiles();     //Useful for clearing old reports before new tests run.
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteFolder(file);
                } else {
                    file.delete();
                }
            }
        }
        folder.delete();
    }

	public void onFinish(ITestContext context) {
		reports.flush(); //to finalize and save the report. closes the report stream, ensuring all the logs, test statuses, screenshots, and details collected during the test run are saved.
	}

}
