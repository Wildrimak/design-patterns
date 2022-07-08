package br.com.wildrimak.shows.state.second.models.states;

import br.com.wildrimak.shows.state.second.models.Player;
import br.com.wildrimak.shows.state.second.models.ActionState;

public class FlyingActionState extends ActionState {

    public FlyingActionState(Player player){
        super("Flying", player, 25);
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
    }


    @Override
    public void down() {

        if (this.getPlayer().getPosition().getHeight() - this.getIntensity() > 0) {
            this.getPlayer().moveHeight(this.getIntensity() * (-1));
        } else {
            this.getPlayer().getPosition().setHeight(0);
            this.getPlayer().setState(new IdleActionState(this.getPlayer()));
        }

    }
}
