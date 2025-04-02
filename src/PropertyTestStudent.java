import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {

	private Property property1;

    @BeforeEach
    public void setUp() {
        property1 = new Property("Test Property", "Rockville", 1500.0, "Owner");
    }

    @Test
    public void testPropertyValues() {
        assertEquals("Test Property", property1.getPropertyName());
        assertEquals("Rockville", property1.getCity());
        assertEquals(1500.0, property1.getRentAmount());
        assertEquals("Owner", property1.getOwner());
    }

    @Test
    public void testPlotDefault() {
        Plot p = property1.getPlot();
        assertEquals(0, p.getX());
        assertEquals(0, p.getY());
        assertEquals(1, p.getWidth());
        assertEquals(1, p.getDepth());
    }
}