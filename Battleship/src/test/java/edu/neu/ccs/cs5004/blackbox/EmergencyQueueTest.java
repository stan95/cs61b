package edu.neu.ccs.cs5004.blackbox;

import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.problem3.question2.EmergencyQueue;
import edu.neu.ccs.cs5004.problem3.question2.Name;
import edu.neu.ccs.cs5004.problem3.question2.Patient;
import edu.neu.ccs.cs5004.problem3.question2.Urgency;

import static org.junit.Assert.*;

public class EmergencyQueueTest {
  EmergencyQueue eq;
  EmergencyQueue eq3;
  EmergencyQueue sameRefAsEq3;
  EmergencyQueue sameStateAsEq3;
  EmergencyQueue anotherSameEq3;
  EmergencyQueue nullEq;

  EmergencyQueue ucq;
  EmergencyQueue ucq3;
  EmergencyQueue sameRefAsUcq3;
  EmergencyQueue sameStateAsUcq3;
  EmergencyQueue anotherSameUcq3;
  EmergencyQueue nullUcq;

  Patient p1;
  Patient p2;
  Patient p3;
  Patient p4;

  @Before
  public void setUp() throws Exception {
    p1 = new Patient(new Name("James","White"),new Urgency(10),1);
    p2 = new Patient(new Name("Zach","Lewis"),new Urgency(100),2);
    p3 = new Patient(new Name("Dickson","Cater"),new Urgency(100),3);
    p4 = new Patient(new Name("Anthony","Green"),new Urgency(1),4);

    eq = EmergencyQueue.createEmptyEmergencyQueue();
    eq.add(p1);
    eq.add(p2);
    eq.add(p3);
    eq.add(p4);

    ucq = EmergencyQueue.createEmptyUrgentCareQueue();
    ucq.add(p1);
    ucq.add(p2);
    ucq.add(p3);
    ucq.add(p4);

    eq3 = EmergencyQueue.createEmptyEmergencyQueue();
    sameRefAsEq3 = eq3;
    sameStateAsEq3 = EmergencyQueue.createEmptyEmergencyQueue();
    anotherSameEq3 = EmergencyQueue.createEmptyEmergencyQueue();
    nullEq = null;

    ucq3 = EmergencyQueue.createEmptyUrgentCareQueue();
    sameRefAsUcq3 = ucq3;
    sameStateAsUcq3 = EmergencyQueue.createEmptyUrgentCareQueue();
    anotherSameUcq3 = EmergencyQueue.createEmptyUrgentCareQueue();
    nullUcq = null;

  }

  @Test
  public void createEmptyEmergencyQueue() {
    assertTrue(EmergencyQueue.createEmptyEmergencyQueue().isEmpty());
  }

  @Test
  public void createEmptyUrgentCareQueue() {
    assertTrue(EmergencyQueue.createEmptyUrgentCareQueue().isEmpty());
  }

  @Test
  public void nextPatient() {
    // Test normal emergency queue
    assertEquals(eq.nextPatient(),p1);

    // Test urgent care queue
    assertEquals(ucq.nextPatient(),p1);
  }

  @Test
  public void removeNext() {
    // Test normal emergency queue
    EmergencyQueue eq1 = EmergencyQueue.createEmptyEmergencyQueue();
    eq1.add(p2);
    eq1.add(p3);
    eq1.add(p4);

    eq.removeNext();
    assertEquals(eq,eq1);

    // Test urgent care queue
    EmergencyQueue ucq1 = EmergencyQueue.createEmptyUrgentCareQueue();
    ucq1.add(p2);
    ucq1.add(p3);
    ucq1.add(p4);
    ucq.removeNext();
    assertEquals(ucq,ucq1);
  }

  @Test
  public void nextMostUrgent() {
    // Test normal emergency queue
    assertEquals(eq.nextMostUrgent(),p2);

    // Test urgent care queue
    assertEquals(ucq.nextMostUrgent(),p2);
  }

  @Test
  public void removeMostUrgent() {
    // Test normal emergency queue
    EmergencyQueue eq1 = EmergencyQueue.createEmptyEmergencyQueue();
    eq1.add(p1);
    eq1.add(p3);
    eq1.add(p4);
    eq.removeMostUrgent();
    assertEquals(eq,eq1);

    // Test urgent care queue
    EmergencyQueue ucq1 = EmergencyQueue.createEmptyUrgentCareQueue();
    ucq1.add(p1);
    ucq1.add(p3);
    ucq1.add(p4);
    ucq.removeMostUrgent();
    assertEquals(ucq,ucq1);
  }

  @Test
  public void add() {
    // Test normal emergency queue
    EmergencyQueue eq1 = EmergencyQueue.createEmptyEmergencyQueue();
    eq1.add(p1);
    eq1.add(p2);
    eq1.add(p3);
    eq1.add(p4);
    assertEquals(eq,eq1);

    // Test urgent care queue
    EmergencyQueue ucq1 = EmergencyQueue.createEmptyUrgentCareQueue();
    ucq1.add(p1);
    ucq1.add(p2);
    ucq1.add(p3);
    ucq1.add(p4);
    assertEquals(ucq,ucq1);
  }

  @Test
  public void isEmpty() {
    // Test normal emergency queue
    assertFalse(eq.isEmpty());
    assertTrue(EmergencyQueue.createEmptyEmergencyQueue().isEmpty());

    // Test urgent care queue
    assertFalse(ucq.isEmpty());
    assertTrue(EmergencyQueue.createEmptyUrgentCareQueue().isEmpty());
  }

  @Test
  public void size() {
    // Test normal emergency queue
    assertTrue(eq.size() == 4);

    // Test urgent care queue
    assertTrue(ucq.size() == 4);
  }

  @Test
  public void testEquals() {
    // Test normal emergency queue
    assertEquals(eq3,sameRefAsEq3);
    assertEquals(eq3,sameStateAsEq3);
    assertEquals(eq3.equals(anotherSameEq3),
        anotherSameEq3.equals(sameStateAsEq3) && sameStateAsEq3.equals(anotherSameEq3));
    assertFalse(eq3.equals(eq));
    assertFalse(eq3.equals(ucq3));
    assertFalse(eq3.equals(nullEq));

    // Test urgent care queue
    assertEquals(ucq3,sameRefAsUcq3);
    assertEquals(ucq3,sameStateAsUcq3);
    assertEquals(ucq3.equals(anotherSameUcq3),
        anotherSameUcq3.equals(sameStateAsUcq3) && sameStateAsUcq3.equals(anotherSameUcq3));
    assertFalse(ucq3.equals(ucq));
    assertFalse(ucq3.equals(eq3));
    assertFalse(ucq3.equals(nullUcq));
  }

  @Test
  public void testHashCode() {
    // Test normal emergency queue
    assertTrue(eq3.equals(sameRefAsEq3)
        && eq3.hashCode() == sameRefAsEq3.hashCode());
    assertTrue(eq3.equals(sameStateAsEq3)
        && eq3.hashCode() == sameStateAsEq3.hashCode());

    // Test urgent care queue
    assertTrue(ucq3.equals(sameRefAsUcq3)
        && ucq3.hashCode() == sameRefAsUcq3.hashCode());
    assertTrue(ucq3.equals(sameStateAsUcq3)
        && ucq3.hashCode() == sameStateAsUcq3.hashCode());
  }
}