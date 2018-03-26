package edu.neu.ccs.cs5004.problem2;

import edu.neu.ccs.cs5004.problem1.List;

import java.util.Comparator;
import java.util.Objects;


/**
 * Represents a priority queue.
 *
 * @param <X> the type parameter
 */
class Queue<X extends Comparable> extends AQueue<X> {
  private List<X> list;
  private Comparator<X> comparator;

  /**
   * Construct a priority queue where elements are in natural order.
   *
   * @param list the queue
   */
  public Queue(List<X> list) {
    this.list = list;
  }

  /**
   * Construct a priority queue where elements are in alternate order.
   *
   * @param list the input queue
   * @param comparator the input comparator
   */
  public Queue(List<X> list, Comparator<X> comparator) {
    this.list = list;
    this.comparator = comparator;
  }

  /**
   * Given an element prepending to the priority queue. O(N^2).
   *
   * @param element the element we want to insert
   */
  public void insert(X element) {
    if (this.list.size() == 0) {
      this.list.add(element);
      return;
    }
    if (comparator == null) {  // use natural order
      for (int i = 0; i < this.list.size(); i++) {
        if (this.list.get(i).compareTo(element) < 0) {
          this.list.add(i, element);
          break;//Need to break, otherwise it will be an infinite loop for adding the element.
        }
        if (this.list.get(i).compareTo(element) == 0) {
          this.list.add(i + 1, element);
          break;
        }
        if (this.list.get(i).compareTo(element) > 0 && this.list.size() == i + 1
            || this.list.get(i + 1).compareTo(element) < 0) {
          this.list.add(i + 1, element);
          break;
        }
      }
    } else {  // use alternate order
      for (int i = 0; i < this.list.size(); i++) {
        if (comparator.compare(list.get(i),element) < 0) {
          this.list.add(i, element);
          break;//Need to break, otherwise it will be an infinite loop for adding the element.
        }
        if (comparator.compare(list.get(i),element) == 0) {
          this.list.add(i + 1, element);
          break;
        }
        if (comparator.compare(list.get(i),element) > 0 && this.list.size() == i + 1
            || comparator.compare(list.get(i),element) < 0) {
          this.list.add(i + 1, element);
          break;
        }
      }
    }

  }

  /**
   * Removes the object from the front. O(1).
   */
  public void remove() {
    if (this.list.size() == 0) {
      throw new IllegalOperationException("Cannot remove on an empty queue!");
    } else {
      this.list.remove(0);
    }
  }


  @Override
  public void remove(int index) {
    if (index < 0 || index >= this.list.size()) {
      throw new IllegalArgumentException("Index out of bound!");
    }
    this.list.remove(index);
  }

  /**
   * Returns the object at the front without changing the Priority Queue. O(N).
   *
   * @return the object at the front
   */
  public X front() {
    if (this.list.size() == 0) {
      throw new IllegalOperationException("Cannot get the front element on an empty queue!");
    } else {
      return this.list.get(0);
    }
  }

  /**
   * Check if the queue is empty.
   *
   * @return true if the queue is empty and false otherwise
   */
  public boolean isEmpty() {
    if (this.list.size() == 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Return the number of elements in the queue. O(1).
   *
   * @return the number of elements in the queue
   */
  public int size() {
    return this.list.size();
  }


  @Override
  public X get(int index) {
    if (index < 0 || index >= this.list.size()) {
      throw new IllegalArgumentException("Index out of bound!");
    }
    return this.list.get(index);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Queue<?> queue = (Queue<?>) obj;
    return Objects.equals(list, queue.list);
  }

  @Override
  public int hashCode() {
    return Objects.hash(list);
  }
}
