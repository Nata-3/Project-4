import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTestStudent {
	private Plot plot1, plot2;

    @BeforeEach
    public void setUp() {
        plot1 = new Plot(1, 2, 3, 4);
        plot2 = new Plot(plot1);
    }

    @Test
    public void testGetters() {
        assertEquals(1, plot1.getX());
        assertEquals(2, plot1.getY());
        assertEquals(3, plot1.getWidth());
        assertEquals(4, plot1.getDepth());
    }

    @Test
    public void testOverlaps() {
        Plot overlapPlot = new Plot(2, 3, 3, 3);
        assertTrue(plot1.overlaps(overlapPlot));
    }

    @Test
    public void testEncompasses() {
        Plot smallPlot = new Plot(1, 2, 2, 2);
        assertTrue(plot1.encompasses(smallPlot));
    }
}
