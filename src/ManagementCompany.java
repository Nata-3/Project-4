/*
 * Class: CMSC203 
 * Instructor: Prof. Ahmed Tarek
 * Description: Managment company
 * Due: 4/1/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: __Natnael Tenagashaw________
*/
public class ManagementCompany {
	// fields
	public static final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;

	private String name;
	private String taxID;
	private double mgmFeePer;
	private Property[] properties; // array of property objects
	private Plot plot;
	private int numberOfProperties;
	
	
	// constructors
	public ManagementCompany() {
		 this.name = "";
		 this.taxID = "";
		 this.mgmFeePer = 0.0;
		 this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		 this.properties = new Property[MAX_PROPERTY];
	}
	public ManagementCompany(String name, String taxID, double mgmFeePer) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;  
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
	}
	public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth) {
		this(name, taxID, mgmFeePer);
		this.plot = new Plot(x, y, width, depth);
		this.properties = new Property[MAX_PROPERTY];
	}
	public ManagementCompany(ManagementCompany otherCompany) {
	    this(otherCompany.name, otherCompany.taxID, otherCompany.mgmFeePer,
	         otherCompany.plot.getX(), otherCompany.plot.getY(),
	         otherCompany.plot.getWidth(), otherCompany.plot.getDepth());

	    this.properties = new Property[MAX_PROPERTY]; 
	    for (int i = 0; i < MAX_PROPERTY; i++) {
	        if (otherCompany.properties[i] != null) {
	            this.properties[i] = new Property(otherCompany.properties[i]);
	        } 
	    }
	}
	 
	// Methods
	public int addProperty(Property property) {
	    if (property == null) 
	    	return -2; 
	    Plot p = property.getPlot(); 

	    // Check if management company encompasses it 
	    if (!plot.encompasses(p)) 
	    	return -3;

	    // Check for overlap with existing properties
	    for (int i = 0; i < MAX_PROPERTY; i++) {
	        if (properties[i] != null && properties[i].getPlot().overlaps(p)) 
	        return -4; 
	    }

	    // Add property to first available slot
	    for (int i = 0; i < MAX_PROPERTY; i++) {
	        if (properties[i] == null) {
	            properties[i] = new Property(property); // deep copy
	            return i;
	        }
	    }

	    return -1; // array full
	}
	
	public int addProperty(String name, String city, double rent, String owner) {
	    Property property = new Property(name, city, rent, owner);
	    return addProperty(property);  
	}
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
	    Property property = new Property(name, city, rent, owner, x, y, width, depth);
	    return addProperty(property); 
	}
	  public void removeLastProperty() {
	        for (int i = MAX_PROPERTY - 1; i >= 0; i--) { 
	            if (properties[i] != null) {
	                properties[i] = null;
	                break;
	            }
	        }
	    }
	  public boolean isPropertiesFull() {
	        for (int i = 0; i < MAX_PROPERTY; i++) {
	            if (properties[i] == null) 
	            	return false; 
	        }
	        return true;
	    }
	  public int getPropertiesCount() {
	        int count = 0;
	        for (int i = 0; i < MAX_PROPERTY; i++) {
	            if (properties[i] != null) 
	            	count++;
	        }
	        return count;
	    }

	    public double getTotalRent() {
	        double total = 0;
	        for (int i = 0; i < MAX_PROPERTY; i++) {
	            if (properties[i] != null) {
	                total += properties[i].getRentAmount(); 
	            }
	        }
	        return total;
	    }

	    public Property getHighestRentPropperty() {
	        if (getPropertiesCount() == 0)
	        	return null;
 
	        Property highest = properties[0];
	        for (int i = 1; i < MAX_PROPERTY; i++) {
	            if (properties[i] != null && properties[i].getRentAmount() > highest.getRentAmount()) {
	                highest = properties[i];
	            }
	        }
	        return highest;
	    }

	    public boolean isManagementFeeValid() {
	        return mgmFeePer >= 0 && mgmFeePer <= 100;
	    }



	    public String getName() {
	        return name;
	    }

	    public String getTaxID() {
	        return taxID;
	    }

	    public Property[] getProperties() {
	        return properties;
	    }

	    public double getMgmFeePer() {
	        return mgmFeePer;
	    }

	    public Plot getPlot() {
	        return plot;
	    }

	

	    public String toString() {
	        String result = "List of the properties for " + name + ", taxID: " + taxID + "\n";
	        result += "______________________________________________________\n";

	        for (int i = 0; i < properties.length; i++) {
	            if (properties[i] != null) {
	                result += properties[i].getPropertyName() + "," +
	                          properties[i].getCity() + "," +
	                          properties[i].getOwner() + "," +
	                          properties[i].getRentAmount() + "\n";
	                result += "______________________________________________________\n";
	            }
	        }

	        result += "\n total management Fee: " + (getTotalRent() * (mgmFeePer / 100));
	        return result;
	    }
	    
	    
	    
	    
	    
	}
 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

