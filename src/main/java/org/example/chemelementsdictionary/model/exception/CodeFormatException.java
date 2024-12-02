package org.example.chemelementsdictionary.model.exception;

public class CodeFormatException extends RuntimeException {
  public CodeFormatException(String code) {
    super("'"+ code + "' is invalid");
  }
  public CodeFormatException(String code, String details) {
    super("'"+ code + "' is invalid: " + details);
  }
}