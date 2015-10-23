package payableSystem;

public class CommissionEmployee extends Employee {
	private double grossSales; 
	private double commissionRate;
	
	public CommissionEmployee( String first, String last, String ssn, Date birthDate, Date hireDate,
	double sales, double rate ) {
	super( first, last, ssn, birthDate, hireDate);
	setGrossSales( sales );
	setCommissionRate( rate );
	}
	
	public double getCommissionRate() {
		return commissionRate;
	}
	public double getGrossSales() {
		return grossSales;
	} 
	public int getBirthMonth() {
		return super.getBirthMonth();
	}
	
	public void setCommissionRate( double rate ) {
		if ( rate > 0.0 && rate < 1.0 ) {
			commissionRate = rate;
		}
		else {
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0" );
		}
	} 
	public void setGrossSales( double sales ) {
		if ( sales >= 0.0 ) {
			grossSales = sales;
		}
		else {
			throw new IllegalArgumentException(
			"Gross sales must be >= 0.0" );
		}
	} 
	
	@Override
	public double earnings() {
	return getCommissionRate() * getGrossSales();
	} 

	@Override
	public String toString() {
		return String.format( "%s: %s\n%s: $%,.2f; %s: %.2f",
		"Commission Employee", super.toString(),
		"Gross Sales", getGrossSales(),
		"Commission Rate", getCommissionRate() );
	}
}

