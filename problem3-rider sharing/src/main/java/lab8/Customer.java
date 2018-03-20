package lab8;

import java.util.List;
import java.util.Observable;


public class Customer extends Observable {
  Name name;
  Posn posn;


  void register(){

  }

  List<Ride> searchRide(){
    notify();
    return ;
  }

  Ride chooseRide(List<Ride> listOfRides){
    return ;
  }

  void confirm(Ride ride){

  }

  void payRide(Ride ride){

  }

  void review(Ride ride){

  }

  void cancel(Ride ride){

  }

}
