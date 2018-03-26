package edu.neu.ccs.cs5004.problem3.question2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UrgencyTest {
  private Urgency urgency;
  private Urgency sameRefAsUrgency;
  private Urgency sameStateAsUrgency;
  private Urgency anotherSameUrgency;
  private Urgency nullUrgency;

  @Before
  public void setUp() throws Exception {
    urgency = new Urgency(1);
    sameRefAsUrgency = urgency;
    sameStateAsUrgency = new Urgency(1);
    anotherSameUrgency = new Urgency(1);
    nullUrgency = null;
  }

  @Test
  public void getValue() {
    assertTrue(urgency.getValue() == 1);
  }

  @Test
  public void setValue() {
    urgency.setValue(10);
    assertTrue(urgency.getValue() == 10);
  }

  @Test
  public void compareTo() {
    Urgency test1 = new Urgency(0);
    Urgency test2 = new Urgency(1);
    Urgency test3 = new Urgency(2);

    assertTrue(urgency.compareTo(test1) > 0);
    assertTrue(urgency.compareTo(test2) == 0);
    assertTrue(urgency.compareTo(test3) < 0);
  }

  @Test
  public void testEquals() {
    assertEquals(urgency,sameRefAsUrgency);
    assertEquals(urgency,sameStateAsUrgency);
    assertEquals(urgency.equals(anotherSameUrgency),
        anotherSameUrgency.equals(sameStateAsUrgency) && sameStateAsUrgency.equals(urgency));
    assertFalse(urgency.equals("urgency"));
    assertFalse(urgency.equals(nullUrgency));
  }

  @Test
  public void testHashCode() {
    assertTrue(urgency.equals(sameRefAsUrgency)
        && urgency.hashCode() == sameRefAsUrgency.hashCode());
    assertTrue(urgency.equals(sameStateAsUrgency)
        && urgency.hashCode() == sameStateAsUrgency.hashCode());
  }
}