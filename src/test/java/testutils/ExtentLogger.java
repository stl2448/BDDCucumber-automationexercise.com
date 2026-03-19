package testutils;

import com.aventstack.extentreports.Status;
import stepdefinitions.Hooks;

public class ExtentLogger {

    // ✅ Get current method name automatically
    private static String getMethodName() {
        return Thread.currentThread()
                .getStackTrace()[3]   // 3 = caller method
                .getMethodName()
                .replace("_", " ");  // make readable
    }

    public static void logStep() {
        Hooks.tlTest.get().log(Status.INFO, getMethodName());
    }

    public static void logPass() {
        Hooks.tlTest.get().log(Status.PASS, getMethodName() + " - PASSED");
    }

    public static void logFail(String message) {
        Hooks.tlTest.get().log(Status.FAIL, getMethodName() + " - FAILED: " + message);
    }
}