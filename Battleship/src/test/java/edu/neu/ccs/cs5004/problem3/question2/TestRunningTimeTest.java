package edu.neu.ccs.cs5004.problem3.question2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestRunningTimeTest {
 private TestRunningTime test;

  @Before
  public void setUp() throws Exception {
    test = new TestRunningTime();
  }

  @Test
  public void main() {
    test.main(new String[0]);
  }
}