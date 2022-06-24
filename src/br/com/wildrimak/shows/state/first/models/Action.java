package br.com.wildrimak.shows.state.first.models;

public enum Action {

    IDLE(2),
    WALKING(3),
    RUNNING(5),
    JUMPING(10),
    FLYING(25);

    private int intensity;

    Action(int intensity){
        this.intensity = intensity;
    }

    public int getIntensity() {
        return intensity;
    }
}
