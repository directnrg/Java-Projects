package exercise1;

public  abstract class Insurance {
	
	protected String insuranceType;
	protected double monthlyCost;
	

	public String getInsuranceType() {
		return insuranceType;
	}

	public double getMonthlyCost() {
		return monthlyCost;
	}
	
	//Constructor of Insurance
	public Insurance(String insurance) {
		this.insuranceType = insurance;
	}

	 //abstract method insurance cost
	public abstract void setInsuranceCost();
	
	//abstract method display information
	public abstract void displayInfo();

}
