/////////////////////////////////////////////////////////////////////////////////////////////
//Created By: Jacob Cassady
//Date first created: 03/24/2016
//Project: CECS 220-01; Assignment 5
//Description: Write a program that computes and prints the mean and standard deviation
//of a list of integers x1 through xn.  Assume that there will be no more
//than 50 input values.  Compute both the mean and standard deviation as
//floating point values.
////////////////////////////////////////////////////////////////////////////////////////////

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Calculator extends JPanel{
	private JPanel inputPanel, outputPanel, buttonPanel;
	private JLabel inputLabel, standardDeviationLabel, meanLabel;
	private JTextArea inputTextArea;
	private JButton compute;
	private int arrayLength;
	private float standardDeviation;
	private DecimalFormat dfm;
	private int[] dataSet;

	public Calculator(){
	standardDeviation = 0;
	Random randomNumberGenerator = new Random();
	dfm = new DecimalFormat("0.00");
	arrayLength = randomNumberGenerator.nextInt(50);
	dataSet = new int[arrayLength];
	
	inputPanel = new JPanel();
	inputLabel = new JLabel("Input " + arrayLength + " integers:");
	inputTextArea = new JTextArea("Enter a set of " + arrayLength + " integers, each separated by a space and I will return the standard deviation for the data set.",3,75);
	inputTextArea.setLineWrap(true);
	inputTextArea.setWrapStyleWord(true);
	inputPanel.setLayout(new BorderLayout());
	inputPanel.add(inputLabel, BorderLayout.NORTH);
	inputPanel.add(inputTextArea, BorderLayout.CENTER);
	inputPanel.setPreferredSize(new Dimension(300,75));
	
	buttonPanel = new JPanel();
	compute = new JButton("Compute");
	compute.addActionListener(new ButtonListener());
	buttonPanel.setLayout(new BorderLayout());
	buttonPanel.add(compute,BorderLayout.CENTER);
	buttonPanel.setPreferredSize(new Dimension(300,25));
	
	outputPanel = new JPanel();
	standardDeviationLabel = new JLabel("The standard deviation is: " + dfm.format(standardDeviation));
	meanLabel = new JLabel("The mean is: " + dfm.format(0));
	
	//outputPanel.setLayout(new BorderLayout());
	outputPanel.add(standardDeviationLabel);
	outputPanel.add(meanLabel);
	outputPanel.setPreferredSize(new Dimension(300,50));
	
	
	
	add(inputPanel);
	add(buttonPanel);
	add(outputPanel);
	setPreferredSize(new Dimension(310,160));
	}
	
	public static void main(String args[]){
		JFrame frame = new JFrame("Standard Deviation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new Calculator());
		frame.pack();
		frame.setVisible(true);
	}	

	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
		String text = "";
		int count=0;
		
		text = inputTextArea.getText();
		
		Scanner scan = new Scanner(text);
		while(scan.hasNext() && (count < arrayLength)){
		dataSet[count] = scan.nextInt();
		count++;
		}
		
		standardDeviation = JMath.standardDeviation(dataSet);
		
		standardDeviationLabel.setText("The standard deviation is: " + dfm.format(standardDeviation));
		meanLabel.setText("The mean is: " + dfm.format(JMath.mean(dataSet)));
		
		scan.close();
		}
	}
}