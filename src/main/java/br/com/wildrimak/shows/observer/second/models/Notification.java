package br.com.wildrimak.shows.observer.second.models;

import java.time.OffsetDateTime;

public class Notification {

    private String notification;
    private Object owner;
    private OffsetDateTime time;
    private boolean read;

    public Notification(String notification, Object owner){
        this.notification = notification;
        this.owner = owner;
        this.time = OffsetDateTime.now();
        this.read = false;
    }

    public Notification(String notification, Object owner, OffsetDateTime time){
        this.notification = notification;
        this.owner = owner;
        this.time = time;
        this.read = false;
    }

    public String getNotification() {
        return notification;
    }

    public OffsetDateTime getTime() {
        return time;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notification that = (Notification) o;

        if (read != that.read) return false;
        if (!notification.equals(that.notification)) return false;
        if (!owner.equals(that.owner)) return false;
        return time.equals(that.time);
    }

    @Override
    public int hashCode() {
        int result = notification.hashCode();
        result = 31 * result + owner.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + (read ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notification='" + notification + '\'' +
                ", owner=" + owner +
                ", time=" + time +
                ", read=" + read +
                '}';
    }
}
