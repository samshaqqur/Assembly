package project6.common;
import java.io.Serializable;
import java.text.DecimalFormat;

public class Reservation implements Serializable
{
	// Instance Variables
	long hotelId;
	int startMonth;
	int endMonth;
	int startDay;
	int endDay;
	
	// Constructors
	public Reservation(long hotId, int inMonth, int outMonth, int inDay, int outDay)
	{
		hotelId = hotId;
		startMonth = inMonth;
		endMonth = outMonth;
		startDay = inDay;
		endDay = outDay;
	}
	public Reservation(long hotId, int month, int inDay, int outDay)
	{
		hotelId = hotId;
		startMonth = month;
		endMonth = month;
		startDay = inDay;
		endDay = outDay;
	}
	
	// Getters/Setters
	public long getHotelId() { return hotelId;	}
	public void setHotelId(long hotId) { hotelId = hotId; }
	public int getStartMonth() { return startMonth;	}
	public void setStartMonth(int inMonth) { startMonth = inMonth; }
	public int getEndMonth() { return endMonth;	}
	public void setEndMonth(int outMonth) { endMonth = outMonth; }
	public int getStartDay() { return startDay;	}
	public void setStartDay(int inDay) { startDay = inDay; }
	public int getEndDay() { return endDay;	}
	public void setEndDay(int outDay) {	endDay = outDay; }	
	
	// Member Methods
	public String getFormattedDisplayString()
	{
		String str = "";
		str += startMonth + "/" + startDay + " - " + endMonth + "/" + endDay;
		return str;
	}
	
	public String getFormattedDisplayString(double currentPrice)
	{
		DecimalFormat df = new DecimalFormat("$0.00");
		String str = getFormattedDisplayString();
		str += " @ " + df.format(currentPrice) + " per night";
		return str;
	}
}
