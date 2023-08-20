import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class ContainerFrame extends JFrame {
	private JPanel mainPanel;
	private JPanel ships;
	private JPanel data;
	
	private JList<String> shipList;
	
	private JTextField codeField;
	private JTextField destinationField;
	private JTextField weightField;
	private JTextField powerField;
	
	private JButton createBulkButton;
	private JButton createRefrodheratorButton;
	
	private ArrayList<Ship> myShips;
	
	public ContainerFrame(ArrayList<Ship> createdShips) {
		this.myShips = createdShips;
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		ships = new JPanel();
		shipList = new JList<String>();
		DefaultListModel<String> model = new DefaultListModel<>();
		for(Ship aShip : myShips) {
			model.addElement(aShip.getName());
		}
		shipList.setModel(model);
		ships.add(shipList);
		
		data = new JPanel();
		data.setLayout(new GridLayout(3,2));
		codeField = new JTextField("Code*");
		destinationField = new JTextField("Destination*");
		weightField =  new JTextField("Weight(for Bulk)");
		powerField = new JTextField("Power(for refidgerator)");
		createBulkButton = new JButton("Create Bulk");
		createRefrodheratorButton = new JButton("Create Refridgerator");
		data.add(codeField);
		data.add(destinationField);
		data.add(weightField);
		data.add(powerField);
		data.add(createBulkButton);
		data.add(createRefrodheratorButton);
		
		mainPanel.add(ships);
		mainPanel.add(data);
		
		ButtonListener listener = new ButtonListener();
		createBulkButton.addActionListener(listener);
		createRefrodheratorButton.addActionListener(listener);

		this.setContentPane(mainPanel);
		
		this.setSize(400,200);
		this.setTitle("Container Frame");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String shipText = shipList.getSelectedValue();
			Ship selectedShip = null;
			for(Ship aShip : myShips) {
				if(aShip.getName().equals(shipText)) {
					selectedShip = aShip;
				}
			}
			if(selectedShip!=null) {
				Container r;
				if(e.getSource().equals(createBulkButton)) {
					r = new BulkContainer(codeField.getText(),destinationField.getText(),Integer.parseInt(weightField.getText()));
					System.out.println("Creating container : " + codeField.getText() + " " + destinationField.getText() + " " +  Integer.parseInt(weightField.getText()));
					selectedShip.addContainer(r);
				}
				else {
					r = new RefridgeratorContainer(codeField.getText(),destinationField.getText(),Integer.parseInt(powerField.getText()));
					System.out.println("Creating container : " + codeField.getText() + " " + destinationField.getText() + " " +  Integer.parseInt(powerField.getText()));
					selectedShip.addContainer(r);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "No ship selected");
			}
			
		}
		
	}
}
