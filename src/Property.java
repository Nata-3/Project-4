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
public class Property {
	// attributes
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot; // plot will hold refernece to a Plot object soon
	
	// constructors
	public Property() {
		propertyName = "";
		city = "";
		rentAmount = 0.0;
		owner = "";
		plot = new Plot();
	}
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
	    this.city = city;
	    this.rentAmount = rentAmount;
	    this.owner = owner;
	    this.plot = new Plot();
	}
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		 this.propertyName = propertyName;
		 this.city = city;
		 this.rentAmount = rentAmount;
		 this.owner = owner;
		 this.plot = new Plot(x, y, width, depth);
	} 
	public Property(Property otherProperty){
		this.propertyName = otherProperty.propertyName;
	    this.city = otherProperty.city;
	    this.rentAmount = otherProperty.rentAmount;
	    this.owner = otherProperty.owner;
	    this.plot = new Plot(otherProperty.plot);
	}
	
	
	// Methods
	public void setPropertyName(String propertyName) {
	    this.propertyName = propertyName;
	}

	public void setCity(String city) {
	    this.city = city;
	}

	public void setRentAmount(double rentAmount) {
	    this.rentAmount = rentAmount;
	}

	public void setOwner(String owner) {
	    this.owner = owner;
	}
	
	public Plot getPlot() {
		return new Plot(plot); // return the copy of the plot 
	}
	public String getPropertyName() {
		return propertyName;
	}

	public String getCity() {
    return city;
	}

	public double getRentAmount() {
    return rentAmount;
	}

	public String getOwner() {
    return owner;
	}
	public String toString() {
	    return "Property Name: " + propertyName + "\n" + "Located in " + city + "\n" + "Belonging to: " + owner + "\n" + "Rent Amount: " + rentAmount + " USD";
	}
	
	
	

    
	
	
	
}
