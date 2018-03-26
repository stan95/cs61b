package edu.neu.ccs.cs5004.problem1;

/**
 * Represents a list.
 *
 * @param <E> any reference type.
 */
public interface List<E> {
  /**
   * Create a new empty list. Time complexity: O(1).
   *
   * @param <X> the data type
   * @return a new empty list.
   */
  static <X> List<X> createEmptyList() {
    return new GenericList<>();
  }

  /**
   * Adds an element to the front of the list. Time complexity: O(1).
   *
   * @param element the element to add in the list.
   */
  void add(E element);

  /**
   * Adds an element at the specified index. Time complexity: O(n).
   *
   * @param index   the index where new element inserts at.
   * @param element new element.
   */
  void add(int index, E element);

  /**
   * Gets an element located at the specified index (the list remains unaltered).
   * Time complexity: O(n).
   *
   * @param index given index.
   * @return the element in the specific index.
   */
  E get(int index);

  /**
   * Retrieves the element in the list and returns the respective index in the list.
   * Time complexity: O(n).
   *
   * @param element the input element.
   * @return the index of this element.
   */
  int indexOf(E element);

  /**
   * Check if the list is empty. Time complexity: O(1).
   *
   * @return true if the list is empty and false otherwise.
   */
  boolean isEmpty();

  /**
   * Removes the element located at the specified index from the list. Time complexity: O(n).
   *
   * @param index the specific index.
   */
  void remove(int index);

  /**
   * Get the size of list. Time complexity: O(1).
   *
   * @return the size of the list.
   */
  int size();

  /**
   * Check if the list contains the specific element. Time complexity: O(n).
   *
   * @param element the input element.
   * @return true if the list contains the specified element, false otherwise.
   */
  boolean contains(E element);
}
