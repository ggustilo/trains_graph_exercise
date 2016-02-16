package spec;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.hamcrest.*;

import src.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
				Fixtures.class,
        TownTest.class,
        TrackTest.class,
        RouteTest.class,
        RouteCalculatorTest.class,
        GraphTest.class
})

public class TestSuite {

}