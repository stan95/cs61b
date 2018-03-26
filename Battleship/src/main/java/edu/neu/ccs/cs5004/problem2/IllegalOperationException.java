package edu.neu.ccs.cs5004.problem2;

/**
 * Represents an illegal operation exception.
 */
class IllegalOperationException extends RuntimeException {
  /**
   * Return message.
   *
   * @param string the massage
   */
  public IllegalOperationException(String string) {
    super(string);
  }
}
