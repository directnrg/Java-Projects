package exercise1;

public class Life extends Insurance {

	protected final double COST_LIFE_INS = 120;

	//Constructor of Life
	public Life() {
		super("Life");
	}

	//Set monthly cost of insurance
	public void setInsuranceCost() {

		monthlyCost = COST_LIFE_INS;
	}

	public void displayInfo() {
		System.out.println("Insurance Type: " + getInsuranceType() + "\nMonthly Cost: $" + getMonthlyCost());
	}
}
