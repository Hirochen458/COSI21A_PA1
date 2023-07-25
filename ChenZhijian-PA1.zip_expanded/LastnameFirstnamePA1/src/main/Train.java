/**
* This class is used to create a train object with current station and direction.
* Known Bugs: <none>
*
* @author Zhijian Chen
* <chen5340@brandeis.edu>
* <Mar 2th 2022>
* COSI 21A PA1
*/


package main;

public class Train {

	public static final int TOTAL_PASSENGERS = 10;
	public Rider[] passengers;
	public int passengerIndex;
	public String currentStation;
	public int direction;
	public String headingWay;
	public boolean north;
	//public Rider[] t;
	
	
	/**
	 * This method is used to construct a new empty train object
	 * @param currentStation the current station that the train at.
	 * @param direction the direction that the train running to.
	 * Running time: constant
	 */
	public Train(String currentStation, int direction) {
		//this.passengers =  (Rider[]) new Object[TOTAL_PASSENGERS];
		this.passengers = new Rider[TOTAL_PASSENGERS];
		this.currentStation = currentStation;
		this.direction = direction;
		//this.north = false;
	}
	
	
	/**
	 * This method is used to detect if the train is heading north.
	 * @return return true if heading north false if not
	 * Running time: O of n
	 */
	public boolean goingNorth() {
		if(direction == 0) {
			headingWay = "North";
			north = true;
			return true;
		}else {
			headingWay = "South";
			north = false;
			return false;
		}
		
	}
	
	
	/**
	 * This method is used to change the direction of train from north to south or from south to north
	 * Running time: O of n
	 */
	public void swapDirection() {
		if(direction == 0) {
			direction = 1;
		}else {
			direction = 0;
		}
		
	}
	
	
	/**
	 * This method is used to print out all passengers in train.
	 * @return return a string with all passenger.
	 * Running time: O of n
	 */
	public String currentPassengers() {
		String pass = "";
		for (int i = 0; i < passengers.length; i++) {
			if(passengers[i] == null) {
				pass += "";
			}else {
				pass += passengers[i].toString() + "\n";
			}
			
		}
		
		return pass;
	}
	
	public boolean addPassenger(Rider r) {
		//heading north checkpoint may need to change
		
		if(r.getStarting().equals(currentStation) && passengerIndex < 10) {
			
			int i = 0;
			while(i < passengers.length) {
				if(passengers[i] == null) {
					passengers[i] = r;
					passengerIndex++;
					return true;
					
					
				}else {
					i++;
				}
			}
			
		}
		
		return false;
		
	}
	
	
	/**
	 * This method is used to check if there is still a empty spot for passenger.
	 * @return return true if yes false if not.
	 * Runing time: O of n
	 */
	public boolean hasSpaceForPassengers() {
		if(passengerIndex < 10) {
			return true;
		}else {
			return false;
		}
	}
	
	
	/**
	 * This method is used to let passengers who arrived to get off the bus.
	 * Running time: O of n
	 */
	public String disembarkPassengers() {
		int numDisembark = 0;
		String disembarkedPassenger = "";
		for(int i = 0; i < passengers.length; i++) {
			if (passengers[i] == null) {
				disembarkedPassenger += "";
				
			}else if(passengers[i].getDestination().equals(currentStation)){
				disembarkedPassenger = disembarkedPassenger + passengers[i].getRiderID() + "\n";
				passengers[i] = null;
				passengerIndex--;
				numDisembark ++;
				
			}
		}
		if(numDisembark == 0) {
			return "";
		}else {
			return disembarkedPassenger;
		}
		
		
	}
	
	
	/**
	 * This method is used to update the station when train is moving.
	 * @param s the station name
	 * Running time: constant
	 */
	public void updateStation(String s) {
		currentStation = s;
		
	}
	
	
	/**
	 * This method is used to get current station
	 * @return the name of current station
	 * Running time: constant
	 */
	public String getStation() {
		return currentStation;
	}
	
	
	/**
	 * This method is used to convert the train object into printable string
	 * Running time: O of n
	 */
	@Override
	public String toString() {
		return "Train" + " " + headingWay +" "+ passengerIndex;
	}
}
