package edu.neu.ccs.cs5004.problem2.blackbox;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.problem2.PriorityQueue;

public class PriorityQueueTest {
  private PriorityQueue p1;
  private PriorityQueue p2;
  private PriorityQueue p3;
  private PriorityQueue p4;
  private PriorityQueue p5;



  @Before
  public void setUp() throws Exception {
    p1 = PriorityQueue.createEmptyQueue();
    p2 = PriorityQueue.createEmptyQueue();
    p3 = PriorityQueue.createEmptyQueue();
    p4 = PriorityQueue.createEmptyQueue();
    p5 = PriorityQueue.createEmptyQueue();
    p1.insert(5);
    p1.insert(7);
    p1.insert(5);
    p4.insert(5);
    p4.insert(5);
  }

  @Test
  public void insert() {
    p4.insert(7);
    Assert.assertEquals(p1,p4);
    p3.insert(5);
    p3.insert(7);
    p3.insert(5);
    Assert.assertEquals(p3,p4);

  }

  @Test
  public void remove() {
    p1.remove();
    Assert.assertEquals(p4,p1);
  }

  @Test
  public void front() {
    Assert.assertEquals(7,p1.front());
  }

  @Test
  public void isEmpty() {
    Assert.assertTrue(p5.isEmpty());
   Assert.assertFalse(p1.isEmpty());
  }

  @Test
  public void size() {
    Assert.assertEquals(2,p4.size());
    Assert.assertEquals(3,p1.size());
    Assert.assertEquals(0,p3.size());
  }

  @Test
  public void removeAt() {
    p3.insert(7);
    p3.insert(5);
    p1.remove(2);
    Assert.assertEquals(p3,p1);

  }

  @Test
  public void elementAt() {
    Assert.assertEquals(5,p1.get(2));
    Assert.assertEquals(7,p1.get(0));
  }

}