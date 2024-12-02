package org.example.chemelementsdictionary.model.exception;

public class CodeDuplicatedException extends RuntimeException {
    public CodeDuplicatedException(String code) {
        super("'" + code + "' is duplicated");
    }
}
