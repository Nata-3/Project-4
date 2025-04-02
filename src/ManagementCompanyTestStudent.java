import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagementCompanyTestStudent {

	private ManagementCompany company;

    @BeforeEach
    void setUp() throws Exception {
        company = new ManagementCompany("TestMgmt", "12345", 10);
    }

    @AfterEach
    void tearDown() throws Exception {
        company = null;
    }

    @Test
    void testManagementCompany() {
        ManagementCompany c = new ManagementCompany();
        assertNotNull(c);
    }

    @Test
    void testManagementCompanyStringStringDouble() {
        ManagementCompany c = new ManagementCompany("Alpha", "67890", 15);
        assertEquals("Alpha", c.getName());
        assertEquals("67890", c.getTaxID());
        assertEquals(15, c.getMgmFeePer());
    }

    @Test
    void testManagementCompanyStringStringDoubleIntIntIntInt() {
        ManagementCompany c = new ManagementCompany("Beta", "54321", 20, 1, 1, 5, 5);
        assertEquals("Beta", c.getName());
        assertEquals("54321", c.getTaxID());
        assertEquals(20, c.getMgmFeePer());
    }

    @Test
    void testManagementCompanyManagementCompany() {
        ManagementCompany copy = new ManagementCompany(company);
        assertEquals(company.getName(), copy.getName());
        assertEquals(company.getTaxID(), copy.getTaxID());
        assertEquals(company.getMgmFeePer(), copy.getMgmFeePer());
    }

    @Test
    void testAddPropertyProperty() {
        Property p = new Property("Prop1", "City", 1000, "Owner", 1, 1, 2, 2);
        assertEquals(0, company.addProperty(p));
    }

    @Test
    void testAddPropertyStringStringDoubleString() {
        assertEquals(0, company.addProperty("Prop2", "City", 1200, "Owner"));
    }

    @Test
    void testAddPropertyStringStringDoubleStringIntIntIntInt() {
        assertEquals(0, company.addProperty("Prop3", "City", 1500, "Owner", 2, 2, 2, 2));
    }

    @Test
    void testRemoveLastProperty() {
        company.addProperty("Prop4", "City", 2000, "Owner", 1, 1, 2, 2);
        company.removeLastProperty();
        assertEquals(0, company.getPropertiesCount());
    }

    @Test
    void testIsPropertiesFull() {
        for (int i = 0; i < company.MAX_PROPERTY; i++) {
            company.addProperty("P" + i, "City", 500, "Owner", i, i, 1, 1);
        }
        assertTrue(company.isPropertiesFull());
    }

    @Test
    void testGetPropertiesCount() {
        company.addProperty("Prop5", "City", 1000, "Owner", 1, 1, 2, 2);
        assertEquals(1, company.getPropertiesCount());
    }


    @Test
    void testGetName() {
        assertEquals("TestMgmt", company.getName());
    }

    @Test
    void testGetTaxID() {
        assertEquals("12345", company.getTaxID());
    }

    @Test
    void testGetProperties() {
        Property[] props = company.getProperties();
        assertNotNull(props);
    }

    @Test
    void testGetMgmFeePer() {
        assertEquals(10, company.getMgmFeePer());
    }

    @Test
    void testGetPlot() {
        Plot p = company.getPlot();
        assertNotNull(p);
    }

    @Test
    void testToString() {
        company.addProperty("Prop10", "City", 1000, "Owner", 1, 1, 2, 2);
        String output = company.toString();
        assertTrue(output.contains("Prop10"));
    }
}