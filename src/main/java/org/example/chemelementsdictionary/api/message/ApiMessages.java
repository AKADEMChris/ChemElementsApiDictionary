package org.example.chemelementsdictionary.api.message;

public class ApiMessages {
    public record StringMessage(String message) {}
    public record ErrorMessage(String code, String details) {}
}
