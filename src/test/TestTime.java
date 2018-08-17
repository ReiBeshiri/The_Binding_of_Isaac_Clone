package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import controller.time.Time;
import controller.time.TimeAgent;

class TestTime {

    @Test
    public void testTimeThread() {
        final Time time = new Time(0, 0);
        final TimeAgent timeAgent = new TimeAgent(time);
        assertTrue(timeAgent.isRunning());
        timeAgent.interrupt();
        final int finish = time.getTimeInSeconds();
        assertFalse(timeAgent.isRunning());
        assertEquals(finish, time.getTimeInSeconds());
    }

    @Test
    public void testTimeToString() {
        final Time time = new Time(0, 0);
        final String timeToString = time.toString();
        final List<String> times = Arrays.asList(timeToString.split(":"));
        times.forEach(x -> assertTrue(x.length() == 2));
    }
}
