package edu.neu.ccs.cs5004.problem3.question2;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Represents a comparator based on patients' arrival order.
 */
public class ArrivalOrderOfPatients implements Comparator<Patient>, Serializable {

  @Override
  public int compare(Patient patient1, Patient patient2) {
    return patient2.getArrivalOrder() - patient1.getArrivalOrder();
  }
}
