package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.example.BaseTest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        // Obtain driver instance from test class
        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).getDriver();

        if (driver != null) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File("./screenshots/FAILED_" + result.getName() + ".png");
            
            try {
                FileUtils.copyFile(src, dest);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}