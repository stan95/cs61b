package edu.neu.ccs.cs5004.problem3.question2;

import edu.neu.ccs.cs5004.problem2.PriorityQueue;

import java.util.Objects;

/**
 * Represents an urgent care queue of patients whose positions are based on arrival order.
 */
class UrgentCareQueue implements EmergencyQueue{
  private PriorityQueue<Patient> queue;

  /**
   * Non-argument constructor for an urgent care queue.
   */
  public UrgentCareQueue() {
    queue =  PriorityQueue.createEmptyFiFoQueue(new ArrivalOrderOfPatients());
  }

  /**
   * Constructor for an specific urgent care queue.
   *
   * @param queue the input urgent care queue.
   */
  public UrgentCareQueue(PriorityQueue<Patient> queue) {
    this.queue = queue;
  }

  /**
   * Get the next patient.  Observer. Time complexity: O(1).
   *
   * @return the next patient.
   */
  @Override
  public Patient nextPatient() {
    return queue.front();
  }

  /**
   * Removes the next patient. Producer. Time complexity: O(1).
   */
  @Override
  public void removeNext() {
    queue.remove();
  }

  /**
   * Returns the patient with the highest urgency in the queue without changing the queue. Observer.
   * Time complexity: O(n).
   *
   * @return the patient with the highest urgency value.
   */
  @Override
  public Patient nextMostUrgent() {
    int index = 0;
    for (int i = 1; i < queue.size(); i++) {
      if (queue.get(i).getUrgency().getValue() > queue.get(index).getUrgency().getValue()) {
        index = i;
      }
    }
    return queue.get(index);
  }

  /**
   * Removes the most urgent patient in the queue. Producer. Time complexity: O(n).
   */
  @Override
  public void removeMostUrgent() {
    int index = 0;
    for (int i = 1; i < queue.size(); i++) {
      if (queue.get(i).getUrgency().getValue() > queue.get(index).getUrgency().getValue()) {
        index = i;
      }
    }
    queue.remove(index);
  }

  /**
   * Add a patient to the queue, based on the arrival order. Producer. Time complexity: O(n)
   *
   * @param patient the patient needed to be add in the queue.
   */
  @Override
  public void add(Patient patient) {
    queue.insert(patient);
  }

  /**
   * Check if the queue is empty. Observer. Time complexity: O(1).
   *
   * @return true if the queue is empty and false otherwise
   */
  @Override
  public boolean isEmpty() {
    return queue.isEmpty();
  }

  /**
   * Return the number of patients in the queue. Observer. Time complexity: O(1).
   *
   * @return the number of patients in the queue
   */
  @Override
  public int size() {
    return queue.size();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    UrgentCareQueue that = (UrgentCareQueue) obj;
    return Objects.equals(queue, that.queue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(queue);
  }
}
