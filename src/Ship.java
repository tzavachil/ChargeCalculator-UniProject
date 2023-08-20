import java.util.ArrayList;

public class Ship {
	private String name;
	private int capacity;
	private ArrayList<Container> containers;
	
	public Ship(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
		containers = new ArrayList<>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addContainer(Container c) {
		if(this.containers.size() < this.capacity)
			this.containers.add(c);
		else
			System.out.println("Ship full");
	}
	
	public int calculateTotalCost() {
		int cost = 0;
		for(Container aContainer : containers) {
			cost += aContainer.calculateCost();
		}
		return cost;
	}
}
