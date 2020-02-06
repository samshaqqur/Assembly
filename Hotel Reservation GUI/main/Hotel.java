package project6.common;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Hotel
{
	/////////////////////////////////////////////////////////////////////////////////////////
	// Instance Variables
	/////////////////////////////////////////////////////////////////////////////////////////
	private long uniqueId;
	private String hotelName;
	private String address;
	private String city;
	private String stateAbbrev;
	private double pricePerNight;
	private ArrayList<Reservation> reservations;
	
	/////////////////////////////////////////////////////////////////////////////////////////
	// Overloaded Constructor
	/////////////////////////////////////////////////////////////////////////////////////////
	public Hotel(long id, String name, String addr, String cityName, String stAbbrev, double price)
	{
		uniqueId = id;
		hotelName = name;
		address = addr;
		city = cityName;
		stateAbbrev = stAbbrev;
		pricePerNight = price;
		reservations = new ArrayList<Reservation>();
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////
	// Default constructor
	/////////////////////////////////////////////////////////////////////////////////////////
	public Hotel()
	{
		uniqueId = -1;
		hotelName = "N/A";
		address = "N/A";
		city = "N/A";
		stateAbbrev = "N/A";
		pricePerNight = 0;
		reservations = new ArrayList<Reservation>();
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////
	// Class Methods
	/////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////
	// This method takes in a new reservation and compares it against 
	// all other reservations in this hotels reservations ArrayList.
	// Returns true if the new reservation can be made; returns false
	// if the new reserveration (newRes) will conflict with an old
	// reservation.
	/////////////////////////////////////////////////////////////////////////////////////////
	public boolean canBook(Reservation newRes)
	{
		// If reservation is not for hotel, cannot book
		if (uniqueId != newRes.getHotelId())
			return false;
				
		// Else, check all reservations for this hotel; if we get one issue, then must return
		// false to say can NOT book; if we make it all the way, through, then we can return
		// true to say we checked all reservations and did not have an issue
		for (Reservation r : reservations)
			if (newRes.startMonth == r.startMonth)
				if (!(newRes.getEndDay() <= r.getStartDay() || newRes.getStartDay() >= r.getEndDay()) )
					return false;
		return true;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////
	// Adds the new reservation (newRes) to the ArrayList of reservations
	// (instance variables)
	/////////////////////////////////////////////////////////////////////////////////////////
	public void addReservation(Reservation newRes)
	{
		reservations.add(newRes);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////
	//
	/////////////////////////////////////////////////////////////////////////////////////////
	public boolean addResIfCanBook(Reservation newRes)
	{
		if (canBook(newRes))
		{
			addReservation(newRes);
			return true;
		}
		else
			return false;
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////
	// Generating display String for printout.
	/////////////////////////////////////////////////////////////////////////////////////////
	public String toDisplayString()
	{
		DecimalFormat df = new DecimalFormat("$0.00");
		
		String disp = "";
		disp += uniqueId + ") " + hotelName + " (" + address + ", " + city + ", " + stateAbbrev + ") @ " + df.format(pricePerNight) + "/night";
		
		return disp;
	}
	

	/////////////////////////////////////////////////////////////////////////////////////////
	// Getters/Setters
	/////////////////////////////////////////////////////////////////////////////////////////
	public long getUniqueId() { return uniqueId; }
	public void setUniqueId(long id) { uniqueId = id; }
	public String getHotelName() { return hotelName; }
	public void setHotelName(String name) {	hotelName = name; }
	public String getAddress() { return address; }
	public void setAddress(String addr) { address = addr; }
	public String getCity() { return city; }
	public void setCity(String cityName) { city = cityName;	}
	public String getStateAbbrev() { return stateAbbrev; }
	public void setStateAbbrev(String stAbbrev) { stateAbbrev = stAbbrev; }
	public double getPricePerNight() { return pricePerNight; }
	public void setPricePerNight(double price) { pricePerNight = price;	}
	public ArrayList<Reservation> getReservations() { return reservations; }	
}
