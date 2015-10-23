package payableSystem;

public class PieceWorker extends Employee {
	private double wagePerPiece;
	private double piece;

	public PieceWorker(String first, String last, String ssn,
			Date birthDate, Date hireDate, double pricePerPiece, double piece) {
		super(first, last, ssn, birthDate, hireDate);
		setWage(pricePerPiece);
		setPiece(piece);
	}
	public double getWage() {
		return wagePerPiece;
	}
	public double getPiece() {
		return piece;
	}

	public void setWage(double pricePerPiece) {
		if (pricePerPiece >= 0.0) {
			this.wagePerPiece = pricePerPiece;
		} 
		else {
			throw new IllegalArgumentException("wage per piece must be >= 0.0");
		}
	}
	public void setPiece(double piece) {
		if (piece >= 0.0) {
			this.piece = piece;
		} 
		else {
			throw new IllegalArgumentException("wage per piece must be >= 0.0");
		}
	}

	@Override
	public double earnings() {
		return wagePerPiece * piece;
	}

	@Override
	public String toString() {
		return String.format("Hourly Employee: %s\n%s: $%,.2f\n%s: $%,.2f",
				super.toString(), "Wage/Piece", getWage(), "Piece/s",
				getPiece());
	}
}
