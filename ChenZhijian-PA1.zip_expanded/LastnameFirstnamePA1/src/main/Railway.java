/**
* This class is used to create a Railway object that can interact with train and rider.
* Known Bugs: <none>
*
* @author Zhijian Chen
* <chen5340@brandeis.edu>
* <Mar 2th 2022>
* COSI 21A PA1
*/


package main;
/*
import java.io.File;	 // for File, PrintStream
import java.util.Scanner;   // for Scanner, Arrays
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
*/
public class Railway {

	public DoubleLinkedList<Station> railway;
	public String[] stationNames;
	
	
	/**
	 * This method is used to construct a railway instance.
	 * Running time: constant
	 */
	public Railway() {
		this.railway = new DoubleLinkedList<Station> (); 
		this.stationNames = new String[18];
	}
	
	
	/**
	 * This method is used to add station to the railway.
	 * @param s s is the station object.
	 * Running time: O of n
	 */
	public void addStation(Station s) {
		railway.insert(s);
	}
	
	
	/**
	 * This method is used to add rider into correct station with direction.
	 * @param r r is the rider object.
	 * Running time: O of n^2
	 */
	public void addRider(Rider r) {
		String tmpStart = r.getStarting();
		String tmpEnd = r.getDestination();
		Node<Station> tmpStation = railway.getFirst();
		int start = 0;
		int end = 0;
		
		boolean greenFlag = false;
		while(tmpStation != null && greenFlag == false) {
			end++;
			if(tmpStation.getData().stationName().equals(tmpEnd) || tmpStation.getNext() == null) {
				greenFlag = true;
			}
			tmpStation = tmpStation.getNext();
		}
		
		boolean redFlag = false;
		tmpStation = railway.getFirst();
		while(tmpStation != null && redFlag == false) {
			start++;
			if(tmpStation.getData().stationName().equals(tmpStart)|| tmpStation.getNext() == null) {
				redFlag = true;
				if (start < end) {
					tmpStation.getData().addRider(r);
				}else {
					r.swapDirection();
					tmpStation.getData().addRider(r);
				}
			}
			tmpStation = tmpStation.getNext();
		}
	}
	
	
	/**
	 * This method is used to add train object in to station
	 * @param t t is  a train object
	 * Running time: O of n
	 */
	public void addTrain(Train t) {
		String startStation = t.getStation();
		Node<Station> tmpStation = railway.getFirst();
		boolean flag = false;
		if(tmpStation != null) {
			while(tmpStation.getNext() != null && flag == false) {
				//System.out.println(tmpStation.getData().stationName());
				if(tmpStation.getData().stationName().equals(startStation)) {
					tmpStation.getData().addTrain(t);
					flag = true;
				}
				if(tmpStation.getNext() != null) {
					tmpStation = tmpStation.getNext();
				}else {
					flag = true;
				}
			
			}
		}
		
		
	}
	
	
	/**
	 * This method is used to decided the rider's direction.
	 * @param r r is the rider object
	 * Running time: O of n
	 */
	public void setRiderDirection(Rider r) {
		String tmpStart = r.getStarting();
		String tmpEnd = r.getDestination();
		Node<Station> tmpStation = railway.getFirst();
		int start = 0;
		int end = 0;
	
		boolean greenFlag = false;
		while(tmpStation != null && greenFlag == false) {
			end++;
			if(tmpStation.getData().stationName() == tmpEnd || tmpStation.getNext() == null) {
				greenFlag = true;
			}
			tmpStation = tmpStation.getNext();
		}
		
		boolean redFlag = false;
		while(tmpStation != null && redFlag == false) {
			start++;
			if(tmpStation.getData().stationName() == tmpStart || tmpStation.getNext() == null) {
				redFlag = true;
				if (start > end) {
					r.swapDirection();
					tmpStation.getData().addRider(r);
				}
					
			}
			tmpStation = tmpStation.getNext();
		}
	}
	
	
	/**
	 * This method is used to run the simulate the running of train to station to the end, riders get in and get off train during station.
	 * @return return a running log
	 * @throws Exception NoSuchFIle exception.
	 * Running time: O of n^3
	 */
	public String simulate() throws Exception {
		
		String log = "";
		String disembark = "";
		
		//access the first station
		Node<Station> tmpF = railway.getFirst();
		//System.out.println(tmpF.toString()+158);
		log += tmpF.getData().toString();
		
		Train tmpTF = tmpF.getData().southBoardTrain();
		//System.out.println(tmpF.toString()+161);
		
		
		if(tmpTF != null) {
			//System.out.println(tmpTF.toString()+165);
			//System.out.println(tmpF.toString() +166);
			disembark = tmpF.getNext().getData().addTrain(tmpTF);
			tmpTF.updateStation(tmpF.getNext().getData().stationName());
			
			log += tmpF.getNext().getData().stationName() + " Disembarking Passengers: " + "\n";
			if(disembark != "") {
				log += disembark + "\n";
			}
			//direction
			if(tmpTF.goingNorth() == true) {
				log += "Direction: Northbound" + "\n";
			}else {
				log += "Direction: Southbound" + "\n";
			}
			//System.out.println(tmpTF.currentPassengers()+ 178);
			log += "passengers: " + "\n"+ tmpTF.currentPassengers();
			log += "Current Station: " + tmpF.getNext().getData().stationName() + "\n";
			log += "\n";
			
		}
		tmpF.getData().moveTrainNorthToSouth();
		
		//access the stations from second to last
		Node<Station> tmp = railway.getFirst().getNext();
		while (tmp.getNext() != null) {
			log += tmp.getData().toString();
			
			//move north bound train
			Train tmpTn = tmp.getData().northBoardTrain();
			
			if(tmpTn != null) {
				disembark = tmp.getPrev().getData().addTrain(tmpTn);
				tmpTn.updateStation(tmp.getPrev().getData().stationName());
				
				log += tmp.getPrev().getData().stationName() + " Disembarking Passengers: " + "\n";
				if(disembark != "") {
					log += disembark;
				}
				//direction
				if(tmpTn.goingNorth() == true) {
					log += "Direction: Northbound" + "\n";
				}else {
					log += "Direction: Southbound" + "\n";
				}
				log += "passengers: " + "\n"+ tmpTn.currentPassengers();
				log += "Current Station: " + tmp.getPrev().getData().stationName() + "\n";
				log +="\n";
				
			}
			
			//move sound bound train
			Train tmpTs = tmp.getData().southBoardTrain();
			if(tmpTs != null) {
				disembark = tmp.getNext().getData().addTrain(tmpTs);
				tmpTs.updateStation(tmp.getNext().getData().stationName());
				
				log += tmp.getNext().getData().stationName() + " Disembarking Passengers: " + "\n";
				if(disembark != "") {
					log += disembark;
				}
				//direction
				if(tmpTs.goingNorth() == true) {
					log += "Direction: Northbound" + "\n";
				}else {
					log += "Direction: Southbound" + "\n";
				}
				log += "passengers: " + "\n"+ tmpTs.currentPassengers();
				log += "Current Station: " + tmp.getNext().getData().stationName() + "\n";
				log += "\n";
			}
			tmp = tmp.getNext();
		}
		//access the last station
		if(tmp.getNext() == null) {
			log += tmp.getData().toString();
			Train tmpTL = tmp.getData().northBoardTrain();
			if(tmpTL != null) {
				disembark = tmp.getPrev().getData().addTrain(tmpTL);
				tmpTL.updateStation(tmp.getPrev().getData().stationName());
				//tmpTL.updateStation(tmp.getPrev().getData().stationName());
					
				log += tmp.getPrev().getData().stationName() + " Disembarking Passengers: " + "\n";
				if(disembark != "") {
					log += disembark + "\n";
				}
				//direction
				if(tmpTL.goingNorth() == true) {						
					log += "Direction: Northbound" + "\n";
				}else {
					log += "Direction: Southbound" + "\n";
				}
					
				log += "passengers: " + "\n"+ tmpTL.currentPassengers();
				log += "Current Station: " + tmp.getPrev().getData().stationName() + "\n";
				log += "\n";
			}
			tmp.getData().moveTrainSouthToNorth();
		}
		return log;
		
	}
	
	
	/**
	 * This method is used to convert the Railway object into printable string.
	 * Running time: O of n
	 */
	@Override
	public String toString() {
		Node<Station> tmp = railway.getFirst();
		String word = "";
		//Queue<Rider> tmpR = tmp.southBoundRiders;
		while(tmp != null) {
			word += tmp.toString();
			tmp = tmp.getNext();
			
		}
		return word;
	}
}
