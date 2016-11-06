/////////////////////////////////////////////////////////////////////////////////////////////
//		Created By: Jacob Cassady
//		Date first created: 03/24/2016
//		Date last updated: 06/26/2016
//		Class: CECS 220-01 (Object Oriented Program Design with Java)
////////////////////////////////////////////////////////////////////////////////////////////

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Calculator extends JFrame{
	private JPanel inputPanel, NPanel, outputPanel, buttonPanel;
	private JLabel inputLabel,sSDLabel, sVLabel, pSDLabel, pVLabel, meanLabel;
	private JTextArea inputTextArea, inputNArea;
	private JButton compute;
	private int n;
	private double sVariance, sStandardDeviation, pVariance, pStandardDeviation;
	private DecimalFormat dfm;
	private double[] dataSet;
	
	public static void main(String args[]){
		JFrame frame = new JFrame("Standard Deviation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new Calculator());
		frame.pack();
		frame.setVisible(true);
	}

	public Calculator(){
		dfm = new DecimalFormat("0.00000000");
		
		inputPanel = new JPanel();
		NPanel = new JPanel();
		inputLabel = new JLabel("Input size of data set:" );
		inputNArea = new JTextArea(1,2);
		NPanel.add(inputLabel);
		NPanel.add(inputNArea);
		
		inputTextArea = new JTextArea("Enter a set of n integers, each separated by a space and I will return the standard deviation for the data set.",3,75);
		inputTextArea.setLineWrap(true);
		inputTextArea.setWrapStyleWord(true);
		
		inputPanel.setLayout(new BorderLayout());
		inputPanel.add(NPanel, BorderLayout.NORTH);
		inputPanel.add(inputTextArea, BorderLayout.CENTER);
		inputPanel.setPreferredSize(new Dimension(300,75));
		
		buttonPanel = new JPanel();
		compute = new JButton("Compute");
		compute.addActionListener(new ButtonListener());
		buttonPanel.setLayout(new BorderLayout());
		buttonPanel.add(compute,BorderLayout.CENTER);
		buttonPanel.setPreferredSize(new Dimension(300,25));
		
		
		outputPanel = new JPanel();
		meanLabel = new JLabel("The mean is: " + dfm.format(0));
		sVLabel = new JLabel("The sample variance is: " + dfm.format(sVariance));
		sSDLabel = new JLabel("The sample standard deviation is: " + dfm.format(sStandardDeviation));
		pVLabel = new JLabel("The population variance is: " + dfm.format(pVariance));
		pSDLabel = new JLabel("The population standard deviation is: " + dfm.format(pStandardDeviation));
		
		outputPanel.setLayout(new BoxLayout(outputPanel, BoxLayout.Y_AXIS));
		outputPanel.add(meanLabel);
		outputPanel.add(sVLabel);
		outputPanel.add(sSDLabel);
		outputPanel.add(pVLabel);
		outputPanel.add(pSDLabel);
		outputPanel.setPreferredSize(new Dimension(300,100));
		
		
		add(inputPanel);
		add(buttonPanel);
		add(outputPanel);
		setPreferredSize(new Dimension(310,200));
	}
	
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			String text = "";
			int count=0;
			
			text = inputNArea.getText();
			Scanner scan = new Scanner(text);
			
			if(scan.hasNext()){ //retrieve data from inputNArea to find number of terms
				n = scan.nextInt();
				dataSet = new double[n];
			}
			scan.close();

			text = inputTextArea.getText();
			scan = new Scanner(text);
			
			while(scan.hasNext() && (count < n)){ //Retrieve data input and fill in array dataSet
				dataSet[count] = scan.nextFloat();
				count++;
			}

			sVariance = JMath.sampleVariance(dataSet);
			sStandardDeviation = JMath.sampleStandardDeviation(dataSet);
			pVariance = JMath.populationVariance(dataSet);
			pStandardDeviation = JMath.populationStandardDeviation(dataSet);
			
			sVLabel.setText("The sample variance is: " + dfm.format(sVariance));
			sSDLabel.setText("The sample standard deviation is: " + dfm.format(sStandardDeviation));
			pVLabel.setText("The population variance is: " + dfm.format(pVariance));
			pSDLabel.setText("The population standard deviation is: " + dfm.format(pStandardDeviation));
			meanLabel.setText("The mean is: " + dfm.format(JMath.mean(dataSet)));
			
			scan.close();
		}
		
	}
}
