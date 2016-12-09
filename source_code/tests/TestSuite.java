package tests;

//A Test Suite is a collection of tests, and can run a TestRunner on an entire TestSuite
//Rather than on individual Tests

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        EventTest.class,
        LocationTest.class,
        RangeTest.class,
        TicketTest.class,
        WorldTest.class
})

public class TestSuite {
    // the class remains empty,
    // used only as a holder for the above annotations
}
