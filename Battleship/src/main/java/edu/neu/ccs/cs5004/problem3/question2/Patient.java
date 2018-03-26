package edu.neu.ccs.cs5004.problem3.question2;

import java.util.Objects;

/**
 * Represents a patient.
 */
public class Patient implements Comparable<Patient> {
  private Name name;
  private Urgency urgency;
  private int arrivalOrder;

  /**
   * Constructor for Patient objects.
   *
   * @param name    the patient's name.
   * @param urgency the patient's urgency.
   * @param arrivalOrder the patient's arrival order.
   */
  public Patient(Name name, Urgency urgency, int arrivalOrder) {
    this.name = name;
    this.urgency = urgency;
    this.arrivalOrder = arrivalOrder;
  }

  /**
   * Getter for the field 'name'.
   *
   * @return the patient's name.
   */
  public Name getName() {
    return name;
  }

  /**
   * Setter for the field 'name'.
   *
   * @param name the input name.
   */
  public void setName(Name name) {
    this.name = name;
  }

  /**
   * Getter for the field 'urgency'.
   *
   * @return the patient's urgency.
   */
  public Urgency getUrgency() {
    return urgency;
  }

  /**
   * Setter for the field 'urgency'.
   *
   * @param urgency the input urgency.
   */
  public void setUrgency(Urgency urgency) {
    this.urgency = urgency;
  }

  /**
   * Getter for the field 'arrivalOrder'.
   *
   * @return the arrival order of this patient.
   */
  public int getArrivalOrder() {
    return arrivalOrder;
  }

  /**
   * Setter for the field 'arrivalOrder'.
   *
   * @param arrivalOrder the input arrival order.
   */
  public void setArrivalOrder(int arrivalOrder) {
    this.arrivalOrder = arrivalOrder;
  }

  @Override
  public int compareTo(Patient that) {
    return this.urgency.compareTo(that.urgency);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Patient patient = (Patient) obj;
    return arrivalOrder == patient.arrivalOrder
        && Objects.equals(name, patient.name)
        && Objects.equals(urgency, patient.urgency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, urgency, arrivalOrder);
  }
}
