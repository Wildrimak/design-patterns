package br.com.wildrimak.shows.observer.second.models;

import java.util.ArrayList;
import java.util.List;

public class Group implements Observable {

    private String name;
    private final Profile owner;
    private final List<Profile> profiles;
    private final List<Post> posts;
    private List<Observer> observers;

    public Group(String name, Profile owner, List<Profile> profiles) {
        this.name = name;
        this.owner = owner;
        this.observers = new ArrayList<>();
        this.profiles = new ArrayList<>();
        this.profiles.addAll(profiles);
        this.profiles.add(owner);
        this.profiles.forEach(profile -> this.addSubscriber(profile));
        this.posts = new ArrayList<>();
        String message = this.owner.getName() + " added you in " + this.name;
        Action action = new Action(message, owner);
        this.notifySubscribers(action);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
        String message = owner.getName() + " have changed group name to " + this.name;
        Action action = new Action(message, owner);
        this.notifySubscribers(action);

    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void addProfile(Profile profile) {

        this.profiles.add(profile);
        this.observers.add(profile);
        String message = this.owner.getName() + " added " + profile.getName() + " in " + this.name;
        String sufferMessage = this.owner.getName() + " added you in " + this.name;
        Action action = new Action(message, owner, sufferMessage, profile);
        this.notifySubscribers(action);

    }

    public void removeProfile(Profile profileToBeRemoved, Profile remover) {

        if (this.profiles.contains(profileToBeRemoved)) {
            this.profiles.remove(profileToBeRemoved);
        }
        if (profileToBeRemoved.getGroups().contains(this)) {
            profileToBeRemoved.removeGroup(this);
        }

        Action action;

        if (profileToBeRemoved.equals(remover)){
            String generalMessage = remover.getName() + " exit!";
            action = new Action(generalMessage, owner);
        } else {
            String generalMessage = remover.getName() + " removed " + profileToBeRemoved.getName();
            String sufferMessage = remover.getName() + " removed you!";
            action = new Action(generalMessage, remover, sufferMessage, profileToBeRemoved);
        }

        this.notifySubscribers(action);
        this.removeSubscriber(profileToBeRemoved);

    }

    public List<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post) {

        this.posts.add(post);
        String message = post.getProfile().getName() + ": " + post.getMessage();
        Action action = new Action(message, post.getProfile());
        this.notifySubscribers(action);

    }

    public void removePost(Post post) {

        this.posts.remove(post);
        String notification = post.getProfile().getName() + " removed this message from the group:" +
                " " + post.getMessage();
        Action action = new Action(notification, post.getProfile());
        this.notifySubscribers(action);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (!name.equals(group.name)) return false;
        return owner.equals(group.owner);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + owner.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", owner=" + owner +
                '}';
    }

    @Override
    public void addSubscriber(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeSubscriber(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifySubscribers(Action action) {
        observers.forEach(observer -> {
            observer.update(action);
        });
    }
}
