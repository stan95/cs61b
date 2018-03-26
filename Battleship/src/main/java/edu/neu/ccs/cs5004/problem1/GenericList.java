package edu.neu.ccs.cs5004.problem1;

import java.util.Objects;

/**
 * Represents a list of nodes.
 * @param <E> any reference type.
 */
class GenericList<E> implements List<E> {
  private Node<E> sentinel;     // represents a sentinel node in the list
  private int numberOfNodes;

  /**
   * Constructor for the empty GenericList.
   */
  public GenericList() {
    sentinel = new Node();
    sentinel.setNext(sentinel);
    sentinel.setPrev(sentinel);
    numberOfNodes = 0;
  }

  /**
   * Adds an element to the front of the list.
   *
   * @param element the element to add in the list.
   */
  @Override
  public void add(E element) {
    Node<E> newNode = new Node<>(element);
    newNode.setPrev(sentinel);
    newNode.setNext(sentinel.getNext());

    sentinel.getNext().setPrev(newNode);
    sentinel.setNext(newNode);
    numberOfNodes++;
  }

  /**
   * Adds an element at the specified index.
   *
   * @param index   the index where new element inserts at.
   * @param element new element.
   */
  @Override
  public void add(int index, E element) {
    numberOfNodes++;
    if (index < 0 || index >= numberOfNodes) {
      throw new IllegalArgumentException("Index out of bound!");
    }
    Node<E> current = sentinel;
    int num = 0;
    while (num <= index - 1) {
      current = current.getNext();
      num++;
    }

    Node<E> newNode = new Node<>(element);
    newNode.setPrev(current);
    newNode.setNext(current.getNext());
    current.getNext().setPrev(newNode);
    current.setNext(newNode);
  }

  /**
   * Gets an element located at the specified index (the list remains unaltered).
   *
   * @param index given index.
   * @return the element in the specific index.
   */
  @Override
  public E get(int index) {
    if (index < 0 || index >= numberOfNodes) {
      throw new IllegalArgumentException("Index out of bound!");
    }
    Node<E> current = sentinel;
    int num = 0;
    while (num <= index) {
      current = current.getNext();
      num++;
    }
    return current.getElement();
  }

  /**
   * Retrieves the element in the list and returns the respective index in the list.
   *
   * @param element the input element.
   * @return the index of this element.
   */
  @Override
  public int indexOf(E element) {
    if (element == null) {
      throw new IllegalArgumentException("Input element is null!");
    }

    Node<E> current = sentinel.getNext();
    int index = 0;
    while (current != sentinel && !element.equals(current.getElement())) {
      current = current.getNext();
      index++;
    }
    if (element.equals(current.getElement())) {
      return index;
    }
    return -1;    // represents the element is not in the list.
  }

  /**
   * Check if the list is empty.
   *
   * @return true if the list is empty and false otherwise.
   */
  @Override
  public boolean isEmpty() {
    return numberOfNodes == 0;
  }

  /**
   * Removes the element located at the specified index from the list.
   *
   * @param index the specific index.
   */
  @Override
  public void remove(int index) {
    if (index < 0 || index >= numberOfNodes) {
      throw new IllegalArgumentException("Index out of bound!");
    }
    Node<E> current = sentinel;
    int num = 0;
    while (num <= index) {
      current = current.getNext();
      num++;
    }
    current.getPrev().setNext(current.getNext());
    current.getNext().setPrev(current.getPrev());
    current.setPrev(null);
    current.setNext(null);
    numberOfNodes--;
  }

  /**
   * Get the size of the list.
   *
   * @return the numberOfNodes of the list.
   */
  @Override
  public int size() {
    return numberOfNodes;
  }

  /**
   * Check if the list contains the specific element.
   *
   * @param element the input element.
   * @return true if the list contains the specified element, false otherwise.
   */
  @Override
  public boolean contains(E element) {
    if (element == null) {
      throw new IllegalArgumentException("Input element is null!");
    }
    Node<E> current = sentinel.getNext();
    while (current != sentinel && !element.equals(current.getElement())) {
      current = current.getNext();
    }
    if (element.equals(current.getElement())) {
      return true;
    }
    return false;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    GenericList<E> listNode = (GenericList<E>) obj;

    if (numberOfNodes != listNode.numberOfNodes) {
      return false;
    }
    Node<E> thisNode = this.sentinel.getNext();
    Node<E> thatNode = listNode.sentinel.getNext();
    while (thisNode.getElement() != null && thatNode.getElement() != null) {
      if (!thisNode.getElement().equals(thatNode.getElement())) {
        return false;
      }
      thisNode = thisNode.getNext();
      thatNode = thatNode.getNext();
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(sentinel, numberOfNodes);
  }
}
