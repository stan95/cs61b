package edu.neu.ccs.cs5004.problem2;

import edu.neu.ccs.cs5004.problem1.List;

import java.util.Comparator;


/**
 * Represents a generic priority queue.
 */
public interface PriorityQueue<X extends Comparable> {
  /**
   * Get an empty priority queue.
   *
   * @param <X> the type parameter
   * @return a new empty queue
   */
  static <X extends Comparable<X>> PriorityQueue<X> createEmptyQueue() {
    return new Queue<>(List.createEmptyList());
  }

  /**
   * Get an empty priority queue where elements are in arrival order.
   *
   * @param comparator the input comparator
   * @param <X> the type parameter
   * @return a new empty queue
   */
  static <X extends Comparable<X>> PriorityQueue<X> createEmptyFiFoQueue(Comparator<X> comparator) {
    return new Queue<>(List.createEmptyList(),comparator);
  }

  /**
   * Given an element prepending to the priority queue.
   *
   * @param element the element we want to insert
   */
  void insert(X element);

  /**
   * Removes the object from the front.
   */
  void remove();

  /**
   * Remove the element at assigned index. O(N).
   *
   * @param index the index of element we want to remove
   */
  void remove(int index);

  /**
   * Returns the object at the front without changing the Priority Queue.
   *
   * @return the object at the front
   */
  X front();

  /**
   * Check if the queue is empty.
   *
   * @return true if the queue is empty and false otherwise
   */
  boolean isEmpty();

  /**
   * Return the number of elements in the queue.
   *
   * @return the number of elements in the queue
   */
  int size();

  /**
   * Retrieve the element at the assigned index.
   *
   * @param index the index of element we want to retrieve
   * @return the element at the assigned index
   */
  X get(int index);
}
