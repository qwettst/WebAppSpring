package dev.qwett.webappspring.entities.model;

public class State {

    private String stateAbbr;

    private String stateName;

    public State(String stateAbbr, String stateName) {

        this.stateAbbr = stateAbbr;
        this.stateName = stateName;

    }

    public String getStateAbbr() {
        return stateAbbr;
    }

    public void setStateAbbr(String stateAbbr) {
        this.stateAbbr = stateAbbr;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String toString() {

        return getStateAbbr();

    }


}