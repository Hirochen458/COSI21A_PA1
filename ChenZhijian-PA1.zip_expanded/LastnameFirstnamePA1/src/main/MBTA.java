/**
* This class is used to intialize train, rider, and station and start to simulate.
* Known Bugs: <none>
*
* @author Zhijian Chen
* <chen5340@brandeis.edu>
* <Mar 2th 2022>
* COSI 21A PA1
*/


package main;


import java.io.File;	 // for File, PrintStream
import java.util.Scanner;   // for Scanner, Arrays
import java.io.FileNotFoundException;
//import java.util.NoSuchElementException;


public class MBTA {

	public static final int SOUTHBOUND = 1;
	public static final int NORTHBOUND = 0;
	
	static final int TIMES = 6;
	static Railway r;
	
	/**
	 * This is the main method to run the whole file
	 * @param args 
	 * @throws Exception throw some exception such as file not found and no such element.
	 * Running time: O of n^3
	 */
	public static void main(String[] args) throws Exception {
		r = new Railway();
		initStations("redLine.txt");
		initTrains("trains.txt");
		initRiders("riders.txt");

		System.out.println(r.toString());
		
		runSimulation();
		
	}
	
	
	/**
	 * This method is used to run the simulation for given times.
	 * @throws Exception throw some exception such as file not found and no such element.
	 * Running time: O of n^3
	 */
	public static void runSimulation() throws Exception {
		for (int i = 0; i < TIMES; i++) {
			//r.simulate();
			System.out.println("\n"+"\n"+(i+1)+"\n"+"\n");
			System.out.println(r.simulate());
			
		}
	}
	
	
	/**
	 * This method is used to initialize the trains objects.
	 * @param trainsFile this is the string of file name.
	 * @throws FileNotFoundException if file not found throw exception.
	 * Running time: O of n
	 */
	public static void initTrains(String trainsFile) throws FileNotFoundException {
		//Railway r = new Railway();
		Scanner trainF = new Scanner(new File(trainsFile));
		
		while(trainF.hasNextLine()) {
			String textStation = trainF.nextLine();
			int headDirection = trainF.nextInt();
			trainF.nextLine();
			
			Train t = new Train(textStation, headDirection);
			r.addTrain(t);
			
		}
		trainF.close();
		
	}
	
	
	/**
	 * This method is used to initialize the rider objects.
	 * @param ridersFile this is the string of file name
	 * @throws FileNotFoundException if file not found throw exception.
	 * Running time: O of n
	 */
	public static void initRiders(String ridersFile) throws FileNotFoundException {
		//Railway r = new Railway();
		Scanner riderF = new Scanner(new File(ridersFile));
		while(riderF.hasNextLine()) {
			String textId = riderF.nextLine();
			String textStart = riderF.nextLine();
			String textEnd = riderF.nextLine();
		
			Rider rider = new Rider(textId, textStart, textEnd);
			r.addRider(rider);
		}
		riderF.close();
		
		
		
	}
	
	
	/**
	 * This method is used to initialize the station objects.
	 * @param ridersFile this is the string of file name
	 * @throws FileNotFoundException if file not found throw exception.
	 * Running time: O of n
	 */

	public static void initStations(String stationsFile) throws FileNotFoundException {
		//Railway r = new Railway();
		Scanner stationF = new Scanner(new File(stationsFile));
		
		while(stationF.hasNextLine()) {
			String stationName = stationF.nextLine();
			
			Station s = new Station(stationName);
			r.addStation(s);
		}
		stationF.close();
		
	}
}
