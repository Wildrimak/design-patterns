package br.com.wildrimak.shows.observer.first.models;

import java.util.List;

public interface Notifiable {

    List<Notification> getNotifications();
    List<Notification> getNotReadNotifications();
    void addNotification(String notification);
    void readNotification(Notification notification);

}
