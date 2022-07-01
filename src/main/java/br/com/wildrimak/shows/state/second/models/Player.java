package br.com.wildrimak.shows.state.second.models;

import br.com.wildrimak.shows.state.second.models.states.FlyingActionState;
import br.com.wildrimak.shows.state.second.models.states.IdleActionState;
import br.com.wildrimak.shows.state.second.models.states.JumpingActionState;
import br.com.wildrimak.shows.state.second.models.states.RunningActionState;

public class Player {

    private String name;
    private Position position;
    private ActionState actionState;

    public Player(String name, Position position) {
        this.name = name;
        this.position = position;
        this.actionState = new IdleActionState(this);
    }

    public Position getPosition() {
        return position;
    }

    public void setState(ActionState actionState) {
        this.actionState = actionState;
    }

    public void right() {
        actionState.right();
    }

    public void left() {
        actionState.left();
    }

    public void front() {
        actionState.front();
    }

    public void back() {
        actionState.back();
    }

    public void up() {
        actionState.up();
    }

    public void down() {
        actionState.down();
    }

    public void fly() {
        this.actionState = new FlyingActionState(this);
    }

    public void run() {
        this.actionState = new RunningActionState(this);
    }

    public void idle() {
        this.actionState = new IdleActionState(this);
    }

    public void jump() {
        this.actionState = new JumpingActionState(this);
    }

    public void moveHorizontal(int move){
        this.position.setHorizontal(this.position.getHorizontal() + move);
    }

    public void moveVertical(int move){
        this.position.setVertical(this.position.getVertical() + move);
    }

    public void moveHeight(int move){
        this.position.setHeight(this.position.getHeight() + move);
    }

    @Override
    public String toString() {
        return String.format("%s is %s in %s", this.name, this.actionState.getActionName(), this.position);
    }
}
