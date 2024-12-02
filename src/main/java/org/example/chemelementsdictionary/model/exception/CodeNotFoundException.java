package org.example.chemelementsdictionary.model.exception;

public class CodeNotFoundException extends RuntimeException {
    public CodeNotFoundException(String code) {
        super("'" + code + "' is not found");
    }
}
