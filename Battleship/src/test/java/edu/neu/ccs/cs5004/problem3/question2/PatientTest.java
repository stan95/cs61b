package edu.neu.ccs.cs5004.problem3.question2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PatientTest {
  private Patient p1;
  private Name name;
  private Urgency urgency;
  private Patient sameRefAsP1;
  private Patient sameStateAsP1;
  private Patient anotherSameP1;
  private Patient nullP1;

  @Before
  public void setUp() throws Exception {
    name = new Name("James","White");
    urgency = new Urgency(1);
    p1 = new Patient(name,urgency,1);
    sameRefAsP1 = p1;
    sameStateAsP1 = new Patient(name,urgency,1);
    anotherSameP1 = new Patient(name,urgency,1);
    nullP1 = null;
  }

  @Test
  public void getName() {
    assertEquals(p1.getName(),name);
  }

  @Test
  public void setName() {
    p1.setName(new Name("Zach","Lewis"));
    assertEquals(p1.getName(),new Name("Zach","Lewis"));
  }

  @Test
  public void getUrgency() {
    assertEquals(p1.getUrgency(),urgency);
  }

  @Test
  public void setUrgency() {
    p1.setUrgency(new Urgency(10));
    assertEquals(p1.getUrgency(),new Urgency(10));
  }

  @Test
  public void getArrivalOrder() {
    assertTrue(p1.getArrivalOrder() == 1);
  }

  @Test
  public void setArrivalOrder() {
    p1.setArrivalOrder(3);
    assertTrue(p1.getArrivalOrder() == 3);
  }

  @Test
  public void compareTo() {
    Patient test1 = new Patient(name,new Urgency(0),1);
    Patient test2 = new Patient(name,new Urgency(1),1);
    Patient test3 = new Patient(name,new Urgency(2),1);
    assertTrue(p1.compareTo(test1) > 0);
    assertTrue(p1.compareTo(test2) == 0);
    assertTrue(p1.compareTo(test3) < 0);
  }

  @Test
  public void testEquals() {
    assertEquals(p1,sameRefAsP1);
    assertEquals(p1,sameStateAsP1);
    assertEquals(p1.equals(anotherSameP1),
        anotherSameP1.equals(sameStateAsP1) && sameStateAsP1.equals(p1));
    assertFalse(p1.equals("patient"));
    assertFalse(p1.equals(nullP1));
  }

  @Test
  public void testHashCode() {
    assertTrue(p1.equals(sameRefAsP1) && p1.hashCode() == sameRefAsP1.hashCode());
    assertTrue(p1.equals(sameStateAsP1) && p1.hashCode() == sameStateAsP1.hashCode());
  }
}