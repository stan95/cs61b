package edu.neu.ccs.cs5004.problem3.question2;

import edu.neu.ccs.cs5004.problem2.PriorityQueue;

import java.util.Objects;

/**
 * Represents a emergency queue.
 */
class Queue implements EmergencyQueue {
  private PriorityQueue<Patient> emergencyQueue;

  /**
   * Non-argument constructor for an empty emergency queue.
   */
  public Queue() {
    emergencyQueue = PriorityQueue.createEmptyQueue();
  }

  /**
   * Constructor for an specific emergency queue.
   *
   * @param queue the input emergency queue.
   */
  public Queue(PriorityQueue<Patient> queue) {
    this.emergencyQueue = queue;
  }

  /**
   * Get the next patient.  Observer. Time complexity: O(n).
   *
   * @return the next patient.
   */
  @Override
  public Patient nextPatient() {
    int index = 0;
    for (int i = 1; i < emergencyQueue.size(); i++) {
      if (emergencyQueue.get(i).getArrivalOrder() < emergencyQueue.get(index).getArrivalOrder()) {
        index = i;
      }
    }
    return emergencyQueue.get(index);
  }

  /**
   * Removes the next patient. Producer. Time complexity: O(n).
   */
  @Override
  public void removeNext() {
    int index = 0;
    for (int i = 1; i < emergencyQueue.size(); i++) {
      if (emergencyQueue.get(i).getArrivalOrder() < emergencyQueue.get(index).getArrivalOrder()) {
        index = i;
      }
    }
    emergencyQueue.remove(index);
  }

  /**
   * Returns the patient with the highest urgency in the queue without changing the queue. Observer.
   * Time complexity: O(1).
   *
   * @return the patient with the highest urgency value.
   */
  @Override
  public Patient nextMostUrgent() {
    return emergencyQueue.front();
  }

  /**
   * Removes the most urgent patient in the queue. Producer. Time complexity: O(1).
   */
  @Override
  public void removeMostUrgent() {
    emergencyQueue.remove();
  }

  /**
   * Add a patient to the queue, based on the emergency. Producer. Time complexity: O(n).
   *
   * @param patient the patient needed to be add in the queue
   */
  @Override
  public void add(Patient patient) {
    emergencyQueue.insert(patient);
  }

  /**
   * Check if the queue is empty. Observer. Time complexity: O(1).
   *
   * @return true if the queue is empty and false otherwise
   */
  @Override
  public boolean isEmpty() {
    return emergencyQueue.isEmpty();
  }

  /**
   * Return the number of patients in the queue. Observer. Time complexity: O(1).
   *
   * @return the number of patients in the queue
   */
  @Override
  public int size() {
    return emergencyQueue.size();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Queue queue1 = (Queue) obj;
    return Objects.equals(emergencyQueue, queue1.emergencyQueue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(emergencyQueue);
  }
}
