package edu.neu.ccs.cs5004.problem3.question2;

/**
 * Measure the time complexity of EmergencyQueue's methods.
 */
public class TestRunningTime {

  /**
   * Measure the time complexity.
   *
   * @param args input arguments.
   */
  public static void main(String[] args) {

    EmergencyQueue eq1 = EmergencyQueue.createEmptyEmergencyQueue();
    long startTime = System.nanoTime();
    eq1.isEmpty();
    System.out.println("Average running time of Emergency Queue's isEmpty() method is "
        + (System.nanoTime() - startTime) / 2.0 / 100);

    EmergencyQueue ucq = EmergencyQueue.createEmptyUrgentCareQueue();
    startTime = System.nanoTime();
    ucq.isEmpty();
    System.out.println("Average running time of Urgent Care Queue's isEmpty() method is "
        + (System.nanoTime() - startTime) / 2.0 / 100 + "\n");

    startTime = System.nanoTime();
    eq1.size();
    System.out.println("Average running time of Emergency Queue's size() method is "
        + (System.nanoTime() - startTime) / 4.0 / 100);

    startTime = System.nanoTime();
    ucq.size();
    System.out.println("Average running time of Urgent Care Queue's size() method is "
        + (System.nanoTime() - startTime) / 4.0 / 100 + "\n");

    Patient patient1 = new Patient(new Name("James","White"),new Urgency(10),1);
    Patient patient2 = new Patient(new Name("Zach","Lewis"),new Urgency(100),2);
    Patient patient3 = new Patient(new Name("Dickson","Cater"),new Urgency(100),3);
    Patient patient4 = new Patient(new Name("Anthony","Green"),new Urgency(1),4);

    eq1.add(patient1);
    eq1.add(patient2);
    eq1.add(patient3);
    eq1.add(patient4);
    System.out.println("Average running time of Emergency Queue's add(Patient patient) method is "
        + (System.nanoTime() - startTime) / 4.0 / 100);

    startTime = System.nanoTime();
    ucq.add(patient1);
    ucq.add(patient2);
    ucq.add(patient3);
    ucq.add(patient4);
    System.out.println("Average running time of Urgent Care Queue's add(Patient patient) method is "
        + (System.nanoTime() - startTime) / 4.0 / 100 + "\n");

    startTime = System.nanoTime();
    eq1.nextPatient();
    eq1.nextPatient();
    eq1.nextPatient();
    eq1.nextPatient();
    System.out.println("Average running time of Emergency Queue's nextPatient() method is "
        + (System.nanoTime() - startTime) / 4.0 / 100);

    startTime = System.nanoTime();
    ucq.nextPatient();
    ucq.nextPatient();
    ucq.nextPatient();
    ucq.nextPatient();
    System.out.println("Average running time of Urgent Care Queue's nextPatient() method is "
        + (System.nanoTime() - startTime) / 4.0 / 100 + "\n");

    startTime = System.nanoTime();
    eq1.nextMostUrgent();
    eq1.nextMostUrgent();
    eq1.nextMostUrgent();
    eq1.nextMostUrgent();
    System.out.println("Average running time of Emergency Queue's nextMostUrgent() method is "
        + (System.nanoTime() - startTime) / 4.0 / 100);

    startTime = System.nanoTime();
    ucq.nextMostUrgent();
    ucq.nextMostUrgent();
    ucq.nextMostUrgent();
    ucq.nextMostUrgent();
    System.out.println("Average running time of Urgent Care Queue's nextMostUrgent() method is "
        + (System.nanoTime() - startTime) / 4.0 / 100 + "\n");

    startTime = System.nanoTime();
    eq1.removeNext();
    eq1.removeNext();
    eq1.removeNext();
    eq1.removeNext();
    System.out.println("Average running time of Emergency Queue's removeNext() method is "
        + (System.nanoTime() - startTime) / 4.0 / 100);

    startTime = System.nanoTime();
    ucq.removeNext();
    ucq.removeNext();
    ucq.removeNext();
    ucq.removeNext();
    System.out.println("Average running time of Urgent Care Queue's removeNext() method is "
        + (System.nanoTime() - startTime) / 4.0 / 100 + "\n");

    eq1.add(patient1);
    eq1.add(patient2);
    eq1.add(patient3);
    eq1.add(patient4);
    startTime = System.nanoTime();
    eq1.removeMostUrgent();
    eq1.removeMostUrgent();
    eq1.removeMostUrgent();
    eq1.removeMostUrgent();
    System.out.println("Average running time of Emergency Queue's removeMostUrgent() method is "
        + (System.nanoTime() - startTime) / 4.0 / 100);

    ucq.add(patient1);
    ucq.add(patient2);
    ucq.add(patient3);
    ucq.add(patient4);
    startTime = System.nanoTime();
    ucq.removeMostUrgent();
    ucq.removeMostUrgent();
    ucq.removeMostUrgent();
    ucq.removeMostUrgent();
    System.out.println("Average running time of Urgent Care Queue's removeMostUrgent() method is "
        + (System.nanoTime() - startTime) / 4.0 / 100 + "\n");
  }
}
