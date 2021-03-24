import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                TestCalculator.class,
                TestCalculator2.class
        }
)

// Test Case - Individual Test Case
// Test Class - Comprised of multiple test cases
// Test Suite - A group of test classes, grouped by a certain method or function

public class SmokeRunner {
}
