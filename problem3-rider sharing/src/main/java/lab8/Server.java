package lab8;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;


public class Server extends Observable implements Observer {
  Set<Customer> customerSet;
  Set<Driver> drivers;
  List<Ride> rideList;


  @Override
  public void update(Observable o, Object arg) {

  }

  public List<Ride> searchRide(Customer customer) {
    return rideList;
  }
}
