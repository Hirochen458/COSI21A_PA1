/**
* This class is used to create a Station object with current station name, passengers and train.
* Known Bugs: <none>
*
* @author Zhijian Chen
* <chen5340@brandeis.edu>
* <Mar 2th 2022>
* COSI 21A PA1
*/


package main;

public class Station {

	public Queue<Rider> northBoundRiders;
	public Queue<Rider> southBoundRiders;
	public Queue<Train> northBoundTrains;
	public Queue<Train> southBoundTrains;
	public String name;
	//public Train[] train;
	
	
	/**
	 * This method is used to construct a new station object with given name.
	 * @param name the name will be given to the station.
	 * Running time: constant
	 */
	public Station(String name) {
		this.name = name;
		this.northBoundRiders = new Queue<Rider>(20);
		this.southBoundRiders = new Queue<Rider>(20);
		this.northBoundTrains = new Queue<Train>(20);
		this.southBoundTrains = new Queue<Train>(20);
	}
	
	
	/**
	 * This method is used to check if the passenger should be waiting for train here.
	 * @param r the rider.
	 * @return return true if correct false if not.
	 * Running time: O of n
	 */
	public boolean addRider(Rider r) { 
		if(r.getStarting().equals(name)) {
			if(r.goingNorth() == true) {
				northBoundRiders.enqueue(r);
			}else {
				southBoundRiders.enqueue(r);
			}
			return true;
		}else {
			return false;
		}
		
	}
	
	
	/**
	 * This method is used to let train get into station going toward correct queue and unload passengers.
	 * @param t the train object.
	 * @return return  a string with disembarked passengers.
	 * Running time: O of n
	 */
	public String addTrain(Train t) {
		t.updateStation(name);
		
		if(t.goingNorth() == true) {
			northBoundTrains.enqueue(t);
		}else {
			southBoundTrains.enqueue(t);
		}
		
		return t.disembarkPassengers();
	}
	
	
	/**
	 * This method is used to get ready for one sound bound train out of waiting area, let passengers get in and ready for departure
	 * @return return a train with full capacity
	 * @throws Exception when there is no train in waiting area queue.
	 * Running time: O of n
	 */
	public Train southBoardTrain() throws Exception {
		if(southBoundTrains.size() == 0) {
			return null;
		}else {
			Train tmpT = southBoundTrains.front();
			
			while(tmpT.hasSpaceForPassengers() == true && southBoundRiders.size() != 0) {
				Rider tmpR = southBoundRiders.front();
				southBoundRiders.dequeue();
				tmpT.addPassenger(tmpR);
				
			}
			
			
			southBoundTrains.dequeue();
			return tmpT;
		}
		
	}
	
	
	/**
	 * This method is used to get ready for one sound north train out of waiting area, let passengers get in and ready for departure
	 * @return return a train with full capacity
	 * @throws Exception when there is no train in waiting area queue.
	 * Running time: O of n
	 */
	public Train northBoardTrain() throws Exception {
		if(northBoundTrains.size() == 0) {
			return null;
		}else {
			Train tmpT = northBoundTrains.front();
			
			while(tmpT.hasSpaceForPassengers() == true && northBoundRiders.size() != 0) {
				Rider tmpR = northBoundRiders.front();
				northBoundRiders.dequeue();
				tmpT.addPassenger(tmpR);
			}
			
			
			northBoundTrains.dequeue();
			return tmpT;
		}
		
	}
	
	
	/**
	 * This method is used to move a south bound train to north bound
	 * @throws Exception when there is no train in waiting area queue
	 * Running time: O of n
	 */
	public void moveTrainNorthToSouth() throws Exception {
		if(northBoundTrains.size() != 0) {
			Train tmp = northBoundTrains.front();
			tmp.swapDirection();
			southBoundTrains.enqueue(tmp);
			northBoundTrains.dequeue();
		}
		
		
	}
	
	
	/**
	 * This method is used to move a nroth bound train to south bound
	 * @throws Exception when there is no train in waiting area queue
	 * Running time: O of n
	 */
	public void moveTrainSouthToNorth() throws Exception {
		if(southBoundTrains.size() != 0) {
			Train tmp = southBoundTrains.front();
			tmp.swapDirection();
			northBoundTrains.enqueue(tmp);
			southBoundTrains.dequeue();
		}
		
		
	}
	
	
	/**
	 * This method is used to convert the train in to printable string
	 * Running time: O of n
	 */
	@Override
	public String toString() {
		int nT = northBoundTrains.size();
		int sT = southBoundTrains.size();
		int nR = northBoundRiders.size();
		int sR = southBoundRiders.size();
		
		return "Station: " + name + "\n" + nT + " north-bound trains waiting" + "\n" + sT + " south-bound trains waiting" + "\n" + nR + " north-bound passengers waiting" + "\n" + sR + " south-bound passengers watiting" + "\n" + "\n";
	}
	
	
	/**
	 * This method is used to record the station name
	 * @return return the station name
	 * Running time: constant
	 */
	public String stationName() {
		return name;
	}
	
	
	/**
	 * This method is used to compare another object with train object to see if they are the same.
	 * Running time: O of n
	 */
	@Override
	public boolean equals(Object o) {
		if(o instanceof Station) {
			Station instance = (Station) o;
			if(name == instance.stationName()) {
				return true;
			}
		}
		return false;
	}
}
