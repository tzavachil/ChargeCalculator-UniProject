import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class ChargeCalculator extends JFrame {
	JPanel mainPanel;
	JButton calculateButton;
	JButton createContainerButton;
	JTextField chargeField;
	
	JList<String> shipList;
	
	ArrayList<Ship> myShips = new ArrayList<>();
	
	public ChargeCalculator(ArrayList<Ship> ships) {
		myShips = ships;
		
		calculateButton = new JButton("Calculate Chrage");
		createContainerButton = new JButton("Create Container");
		chargeField = new JTextField("Total chrage for all containers");
		chargeField.setEditable(false);
		
		shipList = new JList<>();
		DefaultListModel<String> model = new DefaultListModel<>();
		for(Ship aShip : myShips) {
			model.addElement(aShip.getName());
		}
		shipList.setModel(model);
		
		mainPanel = new JPanel();
		
		mainPanel.add(calculateButton);
		mainPanel.add(createContainerButton);
		mainPanel.add(shipList);
		mainPanel.add(chargeField);
		
		ButtonListener listener = new ButtonListener();
		calculateButton.addActionListener(listener);
		createContainerButton.addActionListener(listener);
		
		this.setContentPane(mainPanel);
		
		this.setVisible(true);
		this.setTitle("Charge Calculator");
		this.setSize(400,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(calculateButton)) {
				String shipText = shipList.getSelectedValue();
				Ship selectedShip = null;
				for(Ship aShip : myShips) {
					if(aShip.getName().equals(shipText)) {
						selectedShip = aShip;
					}
				}
				if(selectedShip!=null) {
					chargeField.setText(Integer.toString(selectedShip.calculateTotalCost()));
				}
				else {
					JOptionPane.showMessageDialog(null, "No ship selected");
				}
			}
			else
				new ContainerFrame(myShips);
		}
		
	}
}
