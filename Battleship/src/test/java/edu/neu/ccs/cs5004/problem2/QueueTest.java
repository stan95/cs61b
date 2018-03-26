package edu.neu.ccs.cs5004.problem2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.problem1.List;

import static org.junit.Assert.*;

public class QueueTest {
  private Queue q1;
  private Queue q2;
  private Queue q3;
  private Queue q4;
  private Queue q5;
  private Queue q6;


  @Before
  public void setUp() throws Exception {
    q1 = new Queue(List.createEmptyList());
    q1.insert(2);
    q2 = new Queue(List.createEmptyList());
    q2.insert(2);
    q3 = q2;
    q4 = new Queue(List.createEmptyList());
    q4.insert(2);
    q5 = new Queue(List.createEmptyList());
    q5.insert(7);
    q6 = new Queue(List.createEmptyList());
  }

  @Test
  public void insert() {
  }

  @Test(expected = IllegalOperationException.class)
  public void remove() {
    q6.remove();
  }

  @Test(expected = IllegalOperationException.class)
  public void front() {
    q6.front();
  }

  @Test
  public void isEmpty() {
  }

  @Test
  public void size() {
  }

  @Test
  public void equals() {
    Assert.assertTrue(q1.equals(q2));
    Assert.assertTrue(q2.equals(q1));
    Assert.assertTrue(q2.equals(q3));
    Assert.assertTrue(q2.equals(q2));
    Assert.assertTrue(q1.equals(q4));
    Assert.assertTrue(q1.equals(q2) && q2.equals(q3) && q3.equals(q4) && q1.equals(q4));
    Assert.assertFalse(q2.equals("sss"));
    Assert.assertFalse(q2.equals(q5));
    Assert.assertFalse(q2.equals(null));
    Assert.assertFalse(q5.equals(null));
  }

  @Test
  public void testhashCode() {
    Assert.assertEquals(q1.equals(q2),q1.hashCode() == q2.hashCode());
    Assert.assertEquals(q1.equals(q1), q1.hashCode() == q1.hashCode());
  }

  @Test(expected = IllegalArgumentException.class)
  public void removeAt() {
    q1.remove(10);
    q1.remove(-2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void elementAt() {
    q1.get(10);
    q1.get(-2);
  }
}