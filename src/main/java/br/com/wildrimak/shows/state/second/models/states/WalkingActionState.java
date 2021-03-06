package br.com.wildrimak.shows.state.second.models.states;

import br.com.wildrimak.shows.state.second.models.Player;
import br.com.wildrimak.shows.state.second.models.ActionState;

public class WalkingActionState extends ActionState {

    public WalkingActionState(Player player) {
        super("Walking", player, 3);
    }

    @Override
    public void right() {
        this.getPlayer().moveHorizontal(this.getIntensity());
    }

    @Override
    public void left() {
        this.getPlayer().moveHorizontal(this.getIntensity() * (-1));
    }

    @Override
    public void front() {
        this.getPlayer().moveVertical(this.getIntensity());
    }

    @Override
    public void back() {
        this.getPlayer().moveVertical(this.getIntensity() * (-1));
    }

    @Override
    public void up() {
        this.getPlayer().moveHeight(this.getIntensity());
        this.getPlayer().setState(new FlyingActionState(this.getPlayer()));
    }

    @Override
    public void down() {
        this.getPlayer().setState(new IdleActionState(this.getPlayer()));
    }
}
