package org.example.chemelementsdictionary.model.scenario;

import lombok.RequiredArgsConstructor;
import org.example.chemelementsdictionary.model.entity.Element;
import org.example.chemelementsdictionary.model.exception.CodeDuplicatedException;
import org.example.chemelementsdictionary.model.exception.CodeNotFoundException;
import org.example.chemelementsdictionary.model.service.ElementStorage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ElementScenario {

    private final ElementStorage storage;

    public List<Element> listAll()
    {
        return storage.getElements();
    }

    public Element getByCode(String code){
        Optional<Element> element= storage.getElementByCode(code);
        if(element.isEmpty()){
            throw new CodeNotFoundException(code);
        }
        return element.get();
    }

    public void add(Element element)
    {
        if(storage.getElements().contains(element)){
            throw new CodeDuplicatedException(element.getEnergyLvl());
        }
        storage.insert(element);
    }

    public void removeByCode(String code)
    {
        Optional<Element> element= storage.getElementByCode(code);
        if(element.isEmpty()){
            throw new CodeNotFoundException(code);
        }
        storage.delete(code);
    }

    public void edit(Element element)
    {
        if(storage.getElements().contains(element)){
            throw new CodeDuplicatedException(element.getEnergyLvl());
        }
        storage.update(element);
    }
}
