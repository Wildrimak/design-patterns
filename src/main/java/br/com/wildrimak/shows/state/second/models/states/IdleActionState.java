package br.com.wildrimak.shows.state.second.models.states;

import br.com.wildrimak.shows.state.second.models.Player;
import br.com.wildrimak.shows.state.second.models.ActionState;

public class IdleActionState extends ActionState {

    public IdleActionState(Player player) {
        super("Idle", player, 2);
    }

    @Override
    public void right() {
        this.getPlayer().moveHorizontal(this.getIntensity());
        this.getPlayer().setState(new WalkingActionState(this.getPlayer()));
    }

    @Override
    public void left() {
        this.getPlayer().moveHorizontal(this.getIntensity() * (-1));
        this.getPlayer().setState(new WalkingActionState(this.getPlayer()));
    }

    @Override
    public void front() {
        this.getPlayer().moveVertical(this.getIntensity());
        this.getPlayer().setState(new WalkingActionState(this.getPlayer()));
    }

    @Override
    public void back() {
        this.getPlayer().moveVertical(this.getIntensity() * (-1));
        this.getPlayer().setState(new WalkingActionState(this.getPlayer()));
    }

    @Override
    public void up() {
        this.getPlayer().moveHeight(this.getIntensity());
        this.getPlayer().setState(new FlyingActionState(this.getPlayer()));
    }

    @Override
    public void down() {
    }
}
