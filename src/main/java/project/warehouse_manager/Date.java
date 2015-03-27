package project.warehouse_manager;


public class Date {
	private int day;
	private int month;
	private int year;
	
	/**
	 * @param 
	 * @param 
	 * @param 
	 */
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	/**
	 * @return
	 */
	public int getDay() {
		return day;
	}
	
	/**
	 * @param 
	 */
	public void setDay(int day) {
		this.day = day;
	}
	
	/**
	 * @return
	 */
	public int getMonth() {
		return month;
	}
	
	/**
	 * @param 
	 */
	public void setMonth(int month) {
		this.month = month;
	}
	
	/**
	 * @return
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * @param 
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * @return
	 */
	public int getDateInDays() {
		int yearInDays = year*365;
		int monthInDays = 0;
		
		if (month == 1)
			monthInDays = 0;
		if (month == 2)
			monthInDays = 31;
		if (month == 3)
			monthInDays = 31+28;
		if (month == 4)
			monthInDays = 31+28+31;
		if (month == 5)
			monthInDays = 31+28+31+30;
		if (month == 6)
			monthInDays = 31+28+31+30+31;
		if (month == 7)
			monthInDays = 31+28+31+30+31+30;
		if (month == 8)
			monthInDays = 31+28+31+30+31+30+31;
		if (month == 9)
			monthInDays = 31+28+31+30+31+30+31+31;
		if (month == 10)
			monthInDays = 31+28+31+30+31+30+31+31+30;
		if (month == 11)
			monthInDays = 31+28+31+30+31+30+31+31+30+31;
		if (month == 12)
			monthInDays = 31+28+31+30+31+30+31+31+30+31+30;
		
		return yearInDays+monthInDays+day;
	}
	
	/**
	 * @return
	 */
	public String getDateAsString() {
		return String.format("%d/%d/%d", month, day, year);
	}

}