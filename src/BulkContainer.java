
public class BulkContainer extends Container {
	private int weight;
	
	public BulkContainer(String code, String destination, int weight) {
		super(code, destination);
		this.weight = weight;
	}
	
	public int calculateCost() {
		return 10*this.weight;
	}

}
