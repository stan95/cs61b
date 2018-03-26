package edu.neu.ccs.cs5004.problem3.question2;

import java.util.Objects;

/**
 * Represents the urgency of a patient.
 */
public class Urgency implements Comparable<Urgency> {
  private int value;

  /**
   * Constructor for Urgency objects.
   *
   * @param urgency the urgency value.
   */
  public Urgency(int urgency) {
    value = urgency;
  }

  /**
   * Getter for the field 'value'.
   *
   * @return the urgency value.
   */
  public int getValue() {
    return value;
  }

  /**
   * Setter for the field 'value'.
   * @param value the input urgency value.
   */
  public void setValue(int value) {
    this.value = value;
  }

  @Override
  public int compareTo(Urgency that) {
    return this.value - that.value;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Urgency urgency = (Urgency) obj;
    return value == urgency.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
