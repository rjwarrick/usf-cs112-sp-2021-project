package dataanalytics;

import javax.swing.*;    // all of the Swing objects
import java.awt.*;       // more windowing components, including Container
import java.io.*;
import java.util.ArrayList;

public class DataPointDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Predictor1D predictor = new Predictor1D();
		ArrayList<DataPoint> data = new ArrayList<DataPoint>(4);
		data.add(new DataPoint(2.0, "Good"));
		data.add(new DataPoint(4.0, "Good"));
		data.add(new DataPoint(9.0, "Bad"));
		data.add(new DataPoint(11.0, "Bad"));
		data.add(new DataPoint(13.0, "Bad"));
		//
//		DataPoint testData1 = new DataPoint(9.0);
//		DataPoint testData2 = new DataPoint(1.0);
//		
//		predictor.readData(data);
		
		// write a method to put testData into a test file
		// create dummy predictor object in driver
		// call object.readData() and put the file name into readData
		// ex: DummyPredictor D1 = new DummyPredictor();
		// use D1.readData(filename)
//		System.out.println(predictor.test(testData1));
//		System.out.println(predictor.test(testData2));
//		
		// store D1.readData in ArrayList Al; ArrayList<DataPoint> al = D1.readData(filename)
//		System.out.println("This is a test");
		DummyPredictor D1 = new DummyPredictor();
		ArrayList<DataPoint> newData = new ArrayList<DataPoint>();
		newData = D1.readData("TestData.txt");
//		newData = D1.getAccuracy(newData);
//		System.out.println("Test");
		
//		D1.readData();
		
//		System.out.println(D1.)

		
		 SwingUtilities.invokeLater(
		          new Runnable() { public void run() { initAndShowGUI(); } }
		        );
		    }
	
	private static void initAndShowGUI() {
		
		JFrame myFrame = new JFrame("Project 1 Test Data");
		
		Container contentPane = myFrame.getContentPane();
		
		contentPane.setLayout(new FlowLayout());
		
		contentPane.add(new JButton());
		contentPane.add(new JButton("A Better Button?"));
		contentPane.add(new JButton("3"));


		myFrame.pack();
		myFrame.setVisible(true);
	    }
		}
	

