package payableSystem;

public class Invoice implements Payable {
	private String partNumber;
	private String partDescription;
	private int quantity;
	private double pricePerItem;

	public Invoice( String part, String description, int count, double price ) {
		partNumber = part;
		partDescription = description;
		setQuantity( count ); 
		setPricePerItem( price );
	}
	
	public String getPartNumber() {
		return partNumber;
	} 
	public String getPartDescription() {
		return partDescription;
	}
	public int getQuantity()
	{
	return quantity;
	}
	public double getPricePerItem()
	{
	return pricePerItem;
	}

	public void setPartNumber( String part ) {
	partNumber = part; 
	} 
	public void setPartDescription( String description ) {
		partDescription = description;
	}
	public void setQuantity( int count ) {
		if ( count >= 0 ) {
			quantity = count;
		}
		else {
			throw new IllegalArgumentException( "Quantity must be >= 0" );
		}
	}
	public void setPricePerItem( double price ) {
		if ( price >= 0.0 ) {
			pricePerItem = price;
		}
		else {
			throw new IllegalArgumentException(
			"Price per item must be >= 0" );
		}
	} 
	
	@Override
	public String toString() {
		return String.format( "%s: \n%s: %s (%s) \n%s: %d \n%s: $%,.2f",
		"Invoice", "Part Number", getPartNumber(), getPartDescription(),
		"Quantity", getQuantity(), "Price per Item", getPricePerItem() );
	} 

	@Override
	public double getPaymentAmount() {
		return (getQuantity() * getPricePerItem());
	}
}

