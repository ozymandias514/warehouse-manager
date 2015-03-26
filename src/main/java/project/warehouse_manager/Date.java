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
		if (month == 1)
			return day;
		if (month == 2)
			return 31+day;
		if (month == 3)
			return 31+28+day;
		if (month == 4)
			return 31+28+31+day;
		if (month == 5)
			return 31+28+31+30+day;
		if (month == 6)
			return 31+28+31+30+31+day;
		if (month == 7)
			return 31+28+31+30+31+30+day;
		if (month == 8)
			return 31+28+31+30+31+30+31+day;
		if (month == 9)
			return 31+28+31+30+31+30+31+31+day;
		if (month == 10)
			return 31+28+31+30+31+30+31+31+30+day;
		if (month == 11)
			return 31+28+31+30+31+30+31+31+30+31+day;
		if (month == 12)
			return 31+28+31+30+31+30+31+31+30+31+30+day;
		else
			return 0;
	}
	
	/**
	 * @return
	 */
	public String getDateAsString() {
		return String.format("%i/%i/%i", month, day, year);
	}

}