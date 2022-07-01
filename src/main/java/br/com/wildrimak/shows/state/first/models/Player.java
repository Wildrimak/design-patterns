package br.com.wildrimak.shows.state.first.models;

public class Player {

    private String name;
    private Position position;
    private Action action;

    public Player(String name, Position position) {
        this.name = name;
        this.position = position;
        this.action = Action.IDLE;
    }

    public Position getPosition() {
        return position;
    }

    public Action getAction() {
        return action;
    }

    public void right() {

        if (action.equals(Action.IDLE)) {
            this.position.setHorizontal(this.position.getHorizontal() + action.getIntensity());
            this.action = Action.WALKING;
            return;
        }
        if (action.equals(Action.WALKING)) {
            this.position.setHorizontal(this.position.getHorizontal() + action.getIntensity());
            return;
        }
        if (action.equals(Action.RUNNING)) {
            this.position.setHorizontal(this.position.getHorizontal() + action.getIntensity());
            return;
        }
        if (action.equals(Action.JUMPING)) {
            this.position.setHorizontal(this.position.getHorizontal() + action.getIntensity());
            this.action = Action.RUNNING;
            return;
        }
        if (action.equals(Action.FLYING)) {
            this.position.setHorizontal(this.position.getHorizontal() + action.getIntensity());
            return;
        }

    }

    public void left() {

        if (action.equals(Action.IDLE)) {
            this.position.setHorizontal(this.position.getHorizontal() - action.getIntensity());
            this.action = Action.WALKING;
            return;
        }
        if (action.equals(Action.WALKING)) {
            this.position.setHorizontal(this.position.getHorizontal() - action.getIntensity());
            return;
        }
        if (action.equals(Action.RUNNING)) {
            this.position.setHorizontal(this.position.getHorizontal() - action.getIntensity());
            this.action = Action.WALKING;
            return;
        }
        if (action.equals(Action.JUMPING)) {
            this.position.setHorizontal(this.position.getHorizontal() - action.getIntensity());
            this.action = Action.RUNNING;
            return;
        }
        if (action.equals(Action.FLYING)) {
            this.position.setHorizontal(this.position.getHorizontal() - action.getIntensity());
            return;
        }

    }

    public void front() {

        if (action.equals(Action.IDLE)) {
            this.position.setVertical(this.position.getVertical() + action.getIntensity());
            this.action = Action.WALKING;
            return;
        }
        if (action.equals(Action.WALKING)) {
            this.position.setVertical(this.position.getVertical() + action.getIntensity());
            return;
        }
        if (action.equals(Action.RUNNING)) {
            this.position.setVertical(this.position.getVertical() + action.getIntensity());
            this.action = Action.WALKING;
            return;
        }
        if (action.equals(Action.JUMPING)) {
            this.position.setVertical(this.position.getVertical() + action.getIntensity());
            this.action = Action.RUNNING;
            return;
        }
        if (action.equals(Action.FLYING)) {
            this.position.setVertical(this.position.getVertical() + action.getIntensity());
            return;
        }

    }

    public void back() {

        if (action.equals(Action.IDLE)) {
            this.position.setVertical(this.position.getVertical() - action.getIntensity());
            this.action = Action.WALKING;
            return;
        }
        if (action.equals(Action.WALKING)) {
            this.position.setVertical(this.position.getVertical() - action.getIntensity());
            return;
        }
        if (action.equals(Action.RUNNING)) {
            this.position.setVertical(this.position.getVertical() - action.getIntensity());
            this.action = Action.WALKING;
            return;
        }
        if (action.equals(Action.JUMPING)) {
            this.position.setVertical(this.position.getVertical() - action.getIntensity());
            this.action = Action.RUNNING;
            return;
        }
        if (action.equals(Action.FLYING)) {
            this.position.setVertical(this.position.getVertical() - action.getIntensity());
            return;
        }

    }

    public void up() {

        if (action.equals(Action.IDLE)) {
            this.position.setHeight(this.position.getHeight() + action.getIntensity());
            this.action = Action.FLYING;
            return;
        }
        if (action.equals(Action.WALKING)) {
            this.position.setHeight(this.position.getHeight() + action.getIntensity());
            this.action = Action.FLYING;
            return;
        }
        if (action.equals(Action.RUNNING)) {
            this.position.setHeight(this.position.getHeight() + action.getIntensity());
            this.action = Action.JUMPING;
            return;
        }

        if (action.equals(Action.FLYING)) {
            this.position.setHeight(this.position.getHeight() + action.getIntensity());
            return;
        }

    }

    public void down() {

        if (action.equals(Action.FLYING)) {
            if (this.position.getHeight() - action.getIntensity() > 0) {
                this.position.setHeight(this.position.getHeight() - action.getIntensity());
            } else {
                this.position.setHeight(0);
                this.action = Action.IDLE;
            }
            return;
        }

    }

    public void fly() {
        this.action = Action.FLYING;
    }

    public void run() {
        this.action = Action.RUNNING;
    }

    public void idle() {
        this.action = Action.IDLE;
    }

    public void jump() {
        this.action = Action.JUMPING;
    }

    @Override
    public String toString() {
        return String.format("%s is %s in %s", this.name, this.action.toString(), this.position);
    }
}
