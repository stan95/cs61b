package edu.neu.ccs.cs5004.problem3.question2;

/**
 * Represents an emergency queue.
 */
public interface EmergencyQueue {
  /**
   * Create an empty emergency queue.
   *
   * @return an empty emergency queue.
   */
  static EmergencyQueue createEmptyEmergencyQueue() {
    return new Queue();
  }

  /**
   * Create an empty urgent care queue.
   *
   * @return an empty urgent care queue.
   */
  static EmergencyQueue createEmptyUrgentCareQueue() {
    return new UrgentCareQueue();
  }
  /**
   * Get the next patient.  Observer.
   *
   * @return the next patient.
   */
  Patient nextPatient();

  /**
   * Removes the next patient. Producer.
   */
  void removeNext();

  /**
   * Returns the patient with the highest urgency in the queue without changing the queue. Observer.
   *
   * @return the patient with the highest urgency value.
   */
  Patient nextMostUrgent();

  /**
   * Removes the most urgent patient in the queue. Producer.
   */
  void removeMostUrgent();

  /**
   * Add a patient to the queue, based on the emergency. Producer.
   *
   * @param patient the patient needed to be add in the queue
   */
  void add(Patient patient);

  /**
   * Check if the queue is empty. Observer.
   *
   * @return true if the queue is empty and false otherwise
   */
  boolean isEmpty();

  /**
   * Return the number of patients in the queue. Observer.
   *
   * @return the number of patients in the queue
   */
  int size();
}
