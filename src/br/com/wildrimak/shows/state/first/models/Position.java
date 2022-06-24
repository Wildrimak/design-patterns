package br.com.wildrimak.shows.state.first.models;

public class Position {

    private int horizontal;
    private int vertical;
    private int height;

    public Position(int horizontal, int vertical, int height) {
        this.horizontal = horizontal;
        this.vertical = vertical;
        this.height = height;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(int horizontal) {
        this.horizontal = horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    public void setVertical(int vertical) {
        this.vertical = vertical;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (getHorizontal() != position.getHorizontal()) return false;
        if (getVertical() != position.getVertical()) return false;
        return getHeight() == position.getHeight();
    }

    @Override
    public int hashCode() {
        int result = getHorizontal();
        result = 31 * result + getVertical();
        result = 31 * result + getHeight();
        return result;
    }

    @Override
    public String toString() {
        return String.format("[%d %d %d]", horizontal, vertical, height);
    }
}
