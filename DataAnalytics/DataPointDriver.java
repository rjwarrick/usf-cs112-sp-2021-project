package dataanalytics;

import javax.swing.*;    // all of the Swing objects
import java.awt.*;       // more windowing components, including Container
import java.io.*;
import java.util.ArrayList;

public class DataPointDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// write a method to put testData into a test file
		// create dummy predictor object in driver
		// call object.readData() and put the file name into readData
		// ex: DummyPredictor D1 = new DummyPredictor();
		// use D1.readData(filename)

		DummyPredictor D1 = new DummyPredictor();
		
		ArrayList<DataPoint> newData1 = new ArrayList<DataPoint>();
		newData1 = D1.readData("TestData.txt");
		
		Double newData2;
		newData2 = D1.getAccuracy(newData1);
		
		String newData3;
		newData3 = D1.getPrecision(newData1);
		
		// Display Data on a JFrame
		JFrame frame = new JFrame();
	
		JButton showNewData1 = new JButton();
		JButton showNewData2 = new JButton();
		JButton showNewData3 = new JButton(newData3);
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(showNewData1);
		panel.add(showNewData2);
		panel.add(showNewData3);
		
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Project 1 Test Data");
		frame.pack();
		frame.setVisible(true);
		
//		Container contentPane = frame.getContentPane();
//		
//		contentPane.setLayout(new FlowLayout());
//		
//		contentPane.add(new JButton());
//		contentPane.add(new JButton("A Better Button?"));
//		contentPane.add(new JButton("3"));


//		frame.pack();
//		frame.setVisible(true);
//		
		
//		 SwingUtilities.invokeLater(
//		          new Runnable() { public void run() { initAndShowGUI(); } }
//		        );
//		    }
//	
//	private static void initAndShowGUI() {
//		
//		JFrame myFrame = new JFrame("Project 1 Test Data");
//		
//		Container contentPane = myFrame.getContentPane();
//		
//		contentPane.setLayout(new FlowLayout());
//		
//		contentPane.add(new JButton());
//		contentPane.add(new JButton("A Better Button?"));
//		contentPane.add(new JButton("3"));
//
//
//		myFrame.pack();
//		myFrame.setVisible(true);
	    }
	}
	

