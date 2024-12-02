package org.example.chemelementsdictionary.api.controller;

import lombok.RequiredArgsConstructor;
import org.example.chemelementsdictionary.api.message.ApiMessages;
import org.example.chemelementsdictionary.model.entity.Element;
import org.example.chemelementsdictionary.model.exception.CodeDuplicatedException;
import org.example.chemelementsdictionary.model.exception.CodeFormatException;
import org.example.chemelementsdictionary.model.exception.CodeNotFoundException;
import org.example.chemelementsdictionary.model.scenario.ElementScenario;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/element")
@RequiredArgsConstructor
public class ElementController {
    private final ElementScenario elements;

    @GetMapping("")
    public List<Element> getElements() {
        return elements.listAll();
    }

    @GetMapping("{code}")
    public Element getElementByCode(@PathVariable("code") String code) {
        return elements.getByCode(code);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Element element) {
        elements.add(element);
    }

    @DeleteMapping("{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("code") String code) {
        elements.removeByCode(code);
    }

    @PatchMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Element element) {
        elements.edit(element);
    }

    @ExceptionHandler(CodeFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiMessages.ErrorMessage badRequestException(final CodeFormatException e) {
        return new ApiMessages.ErrorMessage(e.getClass().getSimpleName(), e.getMessage());
    }

    @ExceptionHandler(CodeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiMessages.ErrorMessage notFoundError(final CodeNotFoundException ex) {
        return new ApiMessages.ErrorMessage(ex.getClass().getSimpleName(), ex.getMessage());
    }

    @ExceptionHandler(CodeDuplicatedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiMessages.ErrorMessage conflictError(final CodeDuplicatedException ex) {
        return new ApiMessages.ErrorMessage(ex.getClass().getSimpleName(), ex.getMessage());
    }
}
