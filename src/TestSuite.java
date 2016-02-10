import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TownTest.class,
        TrackTest.class,
        RouteTest.class,
        RouteCalculatorTest.class
})

public class TestSuite {
}