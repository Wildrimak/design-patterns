package br.com.wildrimak.shows.state.second.models;

public abstract class ActionState {

    private String actionName;
    private Player player;
    private int intensity;

    protected ActionState(String actionName, Player player, int intensity) {
        this.actionName = actionName;
        this.player = player;
        this.intensity = intensity;
    }

    public String getActionName() {
        return actionName;
    }

    public Player getPlayer() {
        return player;
    }

    public int getIntensity() {
        return intensity;
    }

    public abstract void right();
    public abstract void left();
    public abstract void front();
    public abstract void back();
    public abstract void up();
    public abstract void down();

}
