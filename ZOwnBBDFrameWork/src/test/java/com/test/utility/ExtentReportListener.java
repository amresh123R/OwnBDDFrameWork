package com.test.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.Scenario;

import java.util.HashMap;
import java.util.Map;

public class ExtentReportListener {

    private static ExtentReports extentReports;
    private static Map<String, ExtentTest> scenarioTestMap = new HashMap<>();

    // Initialize Extent Reports
    public static void initializeExtentReport() {
        String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

        // Optional: Add report configurations
        sparkReporter.config().setReportName("BDD Test Execution Report");
        sparkReporter.config().setDocumentTitle("Test Report");

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);

        // Add system or environment info to the report
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
        extentReports.setSystemInfo("Browser", "Chrome");
    }

    // Log failed scenarios with screenshots
    public static void logFailedScenario(Scenario scenario, String screenshotPath) {
        String scenarioName = scenario.getName();
        ExtentTest test = scenarioTestMap.getOrDefault(scenarioName, extentReports.createTest(scenarioName));
        test.fail("Test Failed");

        if (screenshotPath != null) {
            test.addScreenCaptureFromPath(screenshotPath, "Screenshot on Failure");
        }

        scenarioTestMap.put(scenarioName, test);
    }

    // Flush Extent Reports after all tests are done
    public static void flushExtentReports() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }
}