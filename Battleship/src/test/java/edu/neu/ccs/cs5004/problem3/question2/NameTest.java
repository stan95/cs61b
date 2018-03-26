package edu.neu.ccs.cs5004.problem3.question2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameTest {
  private Name name;
  private Name sameRefAsName;
  private Name sameStateAsName;
  private Name anotherSameName;
  private Name nullName;

  @Before
  public void setUp() throws Exception {
    name = new Name("James","White");
    sameRefAsName = name;
    sameStateAsName = new Name("James","White");
    anotherSameName = new Name("James","White");
    nullName = null;
  }

  @Test
  public void getFirst() {
    assertEquals(name.getFirst(),"James");
  }

  @Test
  public void setFirst() {
    name.setFirst("Zach");
    assertEquals(name.getFirst(),"Zach");
  }

  @Test
  public void getLast() {
    assertEquals(name.getLast(),"White");
  }

  @Test
  public void setLast() {
    name.setLast("Lewis");
    assertEquals(name.getLast(),"Lewis");
  }

  @Test
  public void testEquals() {
    assertEquals(name,sameRefAsName);
    assertEquals(name,sameStateAsName);
    assertEquals(name.equals(anotherSameName),
        anotherSameName.equals(sameStateAsName) && sameStateAsName.equals(name));
    assertFalse(name.equals("name"));
    assertFalse(name.equals(nullName));
  }

  @Test
  public void testHashCode() {
    assertTrue(name.equals(sameRefAsName)
        && name.hashCode() == sameRefAsName.hashCode());
    assertTrue(name.equals(sameStateAsName)
        && name.hashCode() == sameStateAsName.hashCode());
  }
}