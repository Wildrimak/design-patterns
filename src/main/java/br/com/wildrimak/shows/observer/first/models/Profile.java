package br.com.wildrimak.shows.observer.first.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Profile implements Notifiable {

    private String name;
    private List<Group> groups;
    private List<Notification> notifications;

    public Profile(String name) {
        this.name = name;
        this.groups = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group) {
        this.groups.add(group);
    }

    public void removeGroup(Group group) {
        this.groups.remove(group);
    }

    public List<Notification> getNotifications() {
        return Collections
                .unmodifiableList(
                        notifications
                                .stream()
                                .sorted(Comparator.comparing(Notification::getTime).reversed())
                                .collect(Collectors.toList())
                );
    }

    public List<Notification> getNotReadNotifications() {
        return Collections
                .unmodifiableList(
                        notifications
                                .stream()
                                .filter(Predicate.not(Notification::isRead))
                                .sorted(Comparator.comparing(Notification::getTime).reversed())
                                .collect(Collectors.toList())
                );
    }

    public void addNotification(String notification) {
        this.notifications.add(new Notification(notification, this));
    }

    public void readNotification(Notification notification) {
        this.notifications.remove(notification);
        notification.setRead(true);
        this.notifications.add(notification);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Profile profile = (Profile) o;

        return name.equals(profile.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                '}';
    }
}
