package br.com.wildrimak.shows.state.second.models.states;

import br.com.wildrimak.shows.state.second.models.Player;
import br.com.wildrimak.shows.state.second.models.ActionState;

public class JumpingActionState extends ActionState {

    public JumpingActionState(Player player) {
        super("Jumping", player, 10);
    }

    @Override
    public void right() {
        this.getPlayer().moveHorizontal(this.getIntensity());
        this.getPlayer().setState(new RunningActionState(this.getPlayer()));
    }

    @Override
    public void left() {
        this.getPlayer().moveHorizontal(this.getIntensity() * (-1));
        this.getPlayer().setState(new RunningActionState(this.getPlayer()));
    }

    @Override
    public void front() {
        this.getPlayer().moveVertical(this.getIntensity());
        this.getPlayer().setState(new RunningActionState(this.getPlayer()));
    }

    @Override
    public void back() {
        this.getPlayer().moveVertical(this.getIntensity() * (-1));
        this.getPlayer().setState(new RunningActionState(this.getPlayer()));
    }

    @Override
    public void up() {
    }

    @Override
    public void down() {
        this.getPlayer().setState(new IdleActionState(this.getPlayer()));
    }
}
