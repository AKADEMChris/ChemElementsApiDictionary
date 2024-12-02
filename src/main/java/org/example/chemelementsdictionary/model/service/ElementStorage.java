package org.example.chemelementsdictionary.model.service;

import org.example.chemelementsdictionary.model.entity.Element;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ElementStorage {
    List<Element> getElements();
    Optional<Element> getElementByCode(String code);
    void insert(Element element);
    void update(Element element);
    void delete(String code);
}
