package spec;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import src.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TownTest.class,
        TrackTest.class,
        RouteTest.class,
        RouteCalculatorTest.class,
        GraphTest.class
})

public class TestSuite {

}