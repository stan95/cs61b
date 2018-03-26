package edu.neu.ccs.cs5004.problem3.question2;

import java.util.Objects;

/**
 * Represents the name.
 */
public class Name {
  private String first;
  private String last;

  /**
   * Constructor for Name objects.
   *
   * @param first the first name.
   * @param last  the last name.
   */
  public Name(String first, String last) {
    this.first = first;
    this.last = last;
  }

  /**
   * Getter for the field 'first'.
   *
   * @return the first name.
   */
  public String getFirst() {
    return first;
  }

  /**
   * Setter for the field 'first'.
   *
   * @param first the input first name.
   */
  public void setFirst(String first) {
    this.first = first;
  }

  /**
   * Getter for the field 'last'.
   *
   * @return the last name.
   */
  public String getLast() {
    return last;
  }

  /**
   * Setter for the field 'last'.
   *
   * @param last the input last name.
   */
  public void setLast(String last) {
    this.last = last;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Name name = (Name) obj;
    return Objects.equals(first, name.first)
        && Objects.equals(last, name.last);
  }

  @Override
  public int hashCode() {
    return Objects.hash(first, last);
  }
}
