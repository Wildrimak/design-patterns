package br.com.wildrimak.shows.observer.second.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Profile implements Observer {

    private String name;
    private final List<Group> groups;
    private final List<Notification> notifications;

    public Profile(String name) {
        if (name.isBlank()){
            throw new IllegalArgumentException("name does not be blank or null!");
        }
        this.name = name;
        this.groups = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if (name.isBlank()){
            throw new IllegalArgumentException("name does not be blank or null!");
        }

        this.name = name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void createGroup(Group group) {
        this.groups.add(group);
    }

    public void removeGroup(Group group) {
        this.groups.remove(group);
        group.removeProfile(this, this);
    }

    public List<Notification> getNotifications() {
        return notifications
                .stream()
                .sorted(Comparator.comparing(Notification::getTime))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Notification> getNotReadNotifications() {
        return notifications
                .stream()
                .filter(Predicate.not(Notification::isRead))
                .sorted(Comparator.comparing(Notification::getTime))
                .collect(Collectors.toUnmodifiableList());
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

    @Override
    public void update(Object actionCurrent){
        Action action = (Action) actionCurrent;
        this.notifyAllExceptOwner(action);
    }

    /**
     * the owner from action not receive notification
    * */
    private void notifyAllExceptOwner(Action action){
        if (!action.getOwnerAction().equals(this)) {
            notifyDifferToSufferedAction(action);
        }
    }

    /**
     * who receives the action receive a personalized notification
     * */
    private void notifyDifferToSufferedAction(Action action){
        if (action.getSufferAction().equals(this)){
            this.notifications.add(new Notification(action.getSufferMessage(), this, action.getTime()));
        } else {
            this.notifications.add(new Notification(action.getGeneralMessage(), this, action.getTime()));

        }
    }

    public static Profile getNullProfile(){
        Profile profile = new Profile("Null");
        profile.name = "";
        return profile;
    }
}
