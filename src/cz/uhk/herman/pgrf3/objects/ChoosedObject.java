/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.uhk.herman.pgrf3.objects;

/**
 *
 * @author Vladimír Herman
 */
public enum ChoosedObject {

    CUBE("Kostka"),
    SNAKE("Had"),
    SPHERE("Koule"),
    ALIEN("Vetřelec"),
    JUICER("Odšťavňovač"),
    CROOKED_PIPE("Zalomená roura");

    private String object;

    private ChoosedObject(String object) {
        this.object = object;
    }

    /**
     * Return title of state
     *
     * @return State stav
     */
    public String getChoosedObject() {
        return object;
    }
}
