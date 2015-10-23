package payableSystem;

public class HourlyEmployee extends Employee {
	private double wage;
	private double hours;

	public HourlyEmployee(String first, String last, String ssn,
			Date birthDate, Date hireDate, double hourlyWage, double hoursWorked) {
		super(first, last, ssn, birthDate, hireDate);
		setWage(hourlyWage);
		setHours(hoursWorked);
	}

	public double getWage() {
		return wage;
	}
	public double getHours() {
		return hours;
	}
	
	public void setWage(double hourlyWage) {
		if (hourlyWage >= 0.0) {
			wage = hourlyWage;
		} 
		else {
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");
		}
	}
	public void setHours(double hoursWorked) {
		if ((hoursWorked >= 0.0) && (hoursWorked <= 744.0)) {
			hours = hoursWorked;
		} 
		else {
			throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 744.0");
		}
	}

	@Override
	public double earnings() {
		if (getHours() <= 248) {
			return getWage() * getHours();
		} 
		else {
			return (248 * getWage() + (getHours() - 248) * getWage() * 1.5);
		}
	}

	@Override
	public String toString() {
		return String.format("Hourly Employee: %s\n%s: $%,.2f\n%s: $%,.2f",
				super.toString(), "Hourly Wage", getWage(), "Hours Worked",
				getHours());
	}
}

