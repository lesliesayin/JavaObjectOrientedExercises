package payableSystem;

public abstract class Employee implements Payable {
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	private Date birthDate;
	private Date hireDate;

	public Employee(String first, String last, String ssn, Date dateOfBirth,
			Date dateOfHire) {
		firstName = first;
		lastName = last;
		socialSecurityNumber = ssn;
		setBirthDate(dateOfHire);
		setHireDate(dateOfHire);
	}

	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	public int getBirthMonth() {
		return birthDate.getMonth();
	}
	public Date getHireDate() {
		return hireDate;
	}
	
	public void setFirstName(String first) {
		firstName = first;
	}
	public void setLastName(String last) {
		lastName = last;
	}
	public void setSocialSecurityNumber(String ssn) {
		socialSecurityNumber = ssn;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return String.format("%s %s \nsocial Security Number: %s \nBirth Date: %s \nHire Date: %s",
				getFirstName(), getLastName(), getSocialSecurityNumber(), birthDate, hireDate);
	}
	
	public double getPaymentAmount() {
		return earnings();
	}
	
	public abstract double earnings();
}
