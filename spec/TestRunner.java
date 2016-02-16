package spec;
import src.*;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.hamcrest.*;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestSuite.class);
        for (Failure failure : result.getFailures()) {
        		System.out.print("Test that failed:\n");
            System.out.println(failure.toString()+"\n");
        }
        System.out.println("Were the tests successful?");
        System.out.println(result.wasSuccessful());
    }
}
