package org.example.chemelementsdictionary.model.stub;

import org.example.chemelementsdictionary.model.entity.Element;
import org.example.chemelementsdictionary.model.service.ElementStorage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ElementStorageStub implements ElementStorage {

    private final ArrayList<Element> elements;

    public ElementStorageStub() {
        elements = new ArrayList<>();
        elements.add(new Element(
                "Hydrogen",
                1.008,
                "1",
                "H"
        ));
        elements.add(new Element(
                "Lithium",
                6.94,
                "2",
                "Li"
        ));
    }

    @Override
    public List<Element> getElements() {
        return new ArrayList<>(elements);
    }

    @Override
    public Optional<Element> getElementByCode(String code) {
        Element found = elements.stream()
                .filter(c -> c.getEnergyLvl().equals(code))
                .findFirst()
                .orElse(null);
        if(found != null) {
            return Optional.of(found);
        }
        return Optional.empty();
    }

    @Override
    public void insert(Element element) {
        elements.add(element);
    }

    @Override
    public void update(Element element) {
        delete(element.getEnergyLvl());
        insert(element);
    }

    @Override
    public void delete(String code) {
        elements.removeIf(c -> c.getEnergyLvl().equals(code));
    }
}
