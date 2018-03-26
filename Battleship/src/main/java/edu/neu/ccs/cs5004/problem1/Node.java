package edu.neu.ccs.cs5004.problem1;

import java.util.Objects;

/**
 * Represents a node.
 *
 * @param <E> any reference type.
 */
class Node<E> {
  private E element;
  private Node<E> prev;
  private Node<E> next;

  /**
   * None parameter constructor for node.
   */
  public Node() {
    element = null;
  }

  /**
   * Node constructor for one parameter.
   *
   * @param element the internal value of the node.
   */
  public Node(E element) {
    this.element = element;
  }

  /**
   * Getter for the field 'element'.
   *
   * @return the field 'element'.
   */
  public E getElement() {
    return element;
  }

  /**
   * Setter for the field 'element'.
   *
   * @param element the input value.
   */
  public void setElement(E element) {
    this.element = element;
  }

  /**
   * Getter for the field 'prev'.
   *
   * @return the previous node.
   */
  public Node<E> getPrev() {
    return prev;
  }

  /**
   * Setter for the field 'prev'.
   *
   * @param prev the input node.
   */
  public void setPrev(Node<E> prev) {
    this.prev = prev;
  }

  /**
   * Getter for the field 'next'.
   *
   * @return the next node.
   */
  public Node<E> getNext() {
    return next;
  }

  /**
   * Setter for the fiedl 'next'.
   *
   * @param next the input node.
   */
  public void setNext(Node<E> next) {
    this.next = next;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Node<?> node = (Node<?>) obj;
    return Objects.equals(element, node.element);
  }

  @Override
  public int hashCode() {
    return Objects.hash(element);
  }
}
