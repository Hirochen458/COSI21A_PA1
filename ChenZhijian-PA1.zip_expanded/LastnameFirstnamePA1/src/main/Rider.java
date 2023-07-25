/**
* This class is used to create a rider object with ID and starting&destination.
* Known Bugs: <none>
*
* @author Zhijian Chen
* <chen5340@brandeis.edu>
* <Mar 2th 2022>
* COSI 21A PA1
*/


package main;

public class Rider {
	public String ID;
	public String departure;
	public String destionation;
	public String direction;
	

	/**
	 * This method is used to construct a new object rider with ID,startStation and destination station.
	 * @param riderID The rider unique ID
	 * @param startingStation The starting station with that object/rider
	 * @param destinationStation The destination station with that object/rider
	 * Running time: constant
	 */
	public Rider(String riderID, String startingStation, String destinationStation) {
		this.ID = riderID;
		this.departure = startingStation;
		this.destionation = destinationStation;
		this.direction = "South";
	}
	
	
	/**
	 * This method is used to get the starting station.
	 * @return return the starting station
	 * Running time: constant
	 */
	public String getStarting() {
		return departure;
	}
	
	
	/**
	 * This method is used to get the arriving station
	 * @return return the destination station
	 * Running time: constant
	 */
	public String getDestination() {
		return destionation;
	}
	
	
	/**
	 * This method is used to get rider's ID
	 * @return the rider's ID
	 * Running time: constant
	 */
	public String getRiderID() {
		return ID;
	}
	
	
	/**
	 * This method is used to detect if the rider is going north.
	 * @return return true if going north false if not
	 * Running time: O of n
	 */
	public boolean goingNorth() {
		if(direction == "North") {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	/**
	 * This method is used to swap the direction, from north to south or from south to north.
	 * Running time: O of n
	 */
	public void swapDirection() {
		if(direction == "North") {
			direction = "South";
			
		}else {
			direction = "North";
		}
	}
	
	
	/**
	 * This method is used to convery the rider object to printable string
	 * @return return the printable string with the rider
	 * Running time: O of n
	 */
	@Override
	public String toString() {
		return ID + ", " + destionation;
	}
	
	
	/**
	 * This method is used to compare another object with rider object with unique ID
	 * @return return true if same not same if not
	 * Running time: O of n
	 */
	@Override
	public boolean equals(Object s) {
		//s.getRIderID();
		if(s instanceof Rider) {
			Rider instance = (Rider) s;
			if(ID == instance.getRiderID()) {
				return true;
			}
		}
		return false;
	}
}
