package edu.neu.ccs.cs5004.blackbox;

import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.problem1.List;

import static org.junit.Assert.*;

public class ListTest {
  private List<String> stringList;
  private List<String> list1;
  private List<String> sameRefList;
  private List<String> nullList;

  @Before
  public void setUp() throws Exception {
    stringList = List.createEmptyList();
    stringList.add("C");
    stringList.add("B");
    stringList.add("A");
    sameRefList = stringList;
    list1 = List.createEmptyList();
    nullList = null;
  }

  @Test
  public void createEmptyList() {
    assertTrue(List.createEmptyList().isEmpty());
    assertTrue(List.createEmptyList().size() == 0);
  }

  @Test
  public void add() {
    assertEquals(list1,List.createEmptyList());
    list1.add("3");
    list1.add("2");
    list1.add("1");
    assertEquals(3,list1.size());
    assertEquals(list1.get(0),"1");
    assertEquals(list1.get(1),"2");
    assertEquals(list1.get(2),"3");
  }

  @Test(expected = IllegalArgumentException.class)
  public void add1() {
    list1.add(0,"A");
    list1.add(1,"B");
    assertEquals(list1.get(0),"A");
    assertEquals(list1.get(1),"B");
    list1.add(5,"D");
  }

  @Test(expected = IllegalArgumentException.class)
  public void get() {
    assertEquals(stringList.get(0),"A");
    assertEquals(stringList.get(1),"B");
    assertEquals(stringList.get(2),"C");
    list1.get(1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void indexOf() {
    assertEquals(stringList.indexOf("A"),0);
    assertEquals(stringList.indexOf("B"),1);
    assertEquals(stringList.indexOf("C"),2);
    assertEquals(stringList.indexOf("D"),-1);
    stringList.indexOf(null);
  }

  @Test
  public void isEmpty() {
    assertTrue(list1.isEmpty());
    assertFalse(stringList.isEmpty());
  }

  @Test(expected = IllegalArgumentException.class)
  public void remove() {
    stringList.remove(1);
    list1.add("C");
    list1.add("A");
    assertEquals(list1,stringList);
    stringList.remove(5);
  }

  @Test
  public void size() {
    assertEquals(stringList.size(),3);
    assertEquals(list1.size(),0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void contains() {
    assertTrue(stringList.contains("B"));
    assertTrue(stringList.contains("C"));
    assertFalse(stringList.contains("D"));
    stringList.contains(null);
  }

  @Test
  public void testEquals() {
    assertFalse(list1.equals(stringList));
    list1.add("C");
    list1.add("B");
    list1.add("A");
    assertTrue(list1.equals(stringList));
    assertTrue(stringList.equals(sameRefList));
    assertFalse(stringList.equals(nullList));
    assertFalse(stringList.equals("list"));
  }

  @Test
  public void testHashCode() {
    list1.add("C");
    list1.add("B");
    list1.add("A");
    assertTrue(stringList.equals(sameRefList) && stringList.hashCode() == sameRefList.hashCode());
    assertTrue(stringList.equals(list1) && stringList.hashCode() == list1.hashCode());
  }
}