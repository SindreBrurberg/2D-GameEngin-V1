package Engin;

/**
 * Created by Dethsanius on 06.04.2014, project is GameEngin-V1 package are Engin.
 * Date formats date strings.
 */
public class Date {
	private int day, month, year;

	public Date() {
		this(0, 0, 0);
	}

	public Date(int d) {
		this(d, 0, 0);
	}

	public Date(int d, int m) {
		this(d, m, 0);
	}

	public Date(int d, int m, int y) {
		setDate(d, m, y);
	}

	public void setDate(int d, int m, int y) {
		setYear(y);
		setMonth(m);
		setDay(d);
	}

	public int getYear() {
		return year;
	}

	public void setYear(int y) {
		year = ((y >= 0) ? y : 0);
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int m) {
		month = ((m >= 0 && m < 12) ? m : 0);
	}

	public int getDay() {
		return day;
	}

	public void setDay(int d) {
		day = ((d >= 0 && d < 365) ? d : 0);
	}

	public String toStandard() {
		return String.format("%d:%d:%d", getDay(), getMonth(), getYear());
	}

	public String toUSStandard() {
		return String.format("%d:%d:%d", getMonth(), getDay(), getYear());
	}
}
