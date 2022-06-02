package exercise1;

public class Health extends Insurance {
	protected final double COST_HEALTH_INS = 200;

	//Constructor of Health
	public Health() {
		super("Health");
	}

	//Set monthly cost of insurance
	public void setInsuranceCost() {
		monthlyCost = COST_HEALTH_INS;
	}

	public void displayInfo() {
		System.out.println("Insurance Type: " + getInsuranceType() + "\nMonthly Cost: $" + getMonthlyCost());
	}
}
