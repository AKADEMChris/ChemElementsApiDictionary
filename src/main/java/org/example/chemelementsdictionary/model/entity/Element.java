package org.example.chemelementsdictionary.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Element {
    private String name;
    private Double weight;
    private String energyLvl;
    private String chemSymbol;
}
