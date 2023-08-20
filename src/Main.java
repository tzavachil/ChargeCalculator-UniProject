import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		
		//Creating ship
		Ship myShip = new Ship("Achilleas", 450);
		
		//Creating Containers
		Container container1 = new BulkContainer("AAAAA","Greece",10);
		Container container2 = new BulkContainer("BBBBB","Germany",20);
		Container container3 = new BulkContainer("CCCCC","Russia",30);
		
		Container container4 = new RefridgeratorContainer("DDDDD","Finland",1);
		Container container5 = new RefridgeratorContainer("EEEEE","France",2);
		Container container6 = new RefridgeratorContainer("FFFFF","Italy",3);
		
		//Adding Containers
		myShip.addContainer(container1);
		myShip.addContainer(container2);
		myShip.addContainer(container3);
		myShip.addContainer(container4);
		myShip.addContainer(container5);
		myShip.addContainer(container6);
		
		ArrayList<Ship> ships = new ArrayList<>();
		
		Ship ship1 = new Ship("Hercules",350);
		Ship ship2 = new Ship("Copacabana",350);
		Ship ship3 = new Ship("Hermes",350);
		Ship ship4 = new Ship("Zeus",350);
		
		ships.add(myShip);
		ships.add(ship1);
		ships.add(ship2);
		ships.add(ship3);
		ships.add(ship4);
		
		new ChargeCalculator(ships);
	}

}
