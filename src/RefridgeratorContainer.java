
public class RefridgeratorContainer extends Container {
	private int power;
	
	public RefridgeratorContainer(String code, String destination, int power) {
		super(code, destination);
		this.power = power;
	}
	
	public int calculateCost() {
		return 2000*this.power;
	}

}
