package com.cinema.equipment.exceptions;

/**
 * @author slyns
 * @version 3/7/17.
 */
public class ApplicationError extends RuntimeException {
  public ApplicationError(Exception cause) {
    super(cause);
  }

  public ApplicationError(String message, Exception cause) {
    super(message, cause);
  }
}
