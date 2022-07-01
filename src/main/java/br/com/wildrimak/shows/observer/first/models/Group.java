package br.com.wildrimak.shows.observer.first.models;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private String name;
    private final Profile owner;
    private final List<Profile> profiles;
    private final List<Post> posts;

    public Group(String name, Profile owner, List<Profile> profiles) {
        this.name = name;
        this.owner = owner;
        this.profiles = new ArrayList<>();
        this.profiles.addAll(profiles);
        this.posts = new ArrayList<>();
        this.profiles
                .forEach(profile -> profile
                        .addNotification(this.owner.getName() + " added you in " + this.name));
        this.profiles.add(owner);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.profiles
                .forEach(profile ->
                        profile.addNotification
                                (owner.getName() + " have changed group name to " + this.name));
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void addProfile(Profile profile) {
        this.profiles.add(profile);
        profile.addNotification(this.owner.getName() + " added you in " + this.name);
    }

    public void removeProfile(Profile profile) {
        this.profiles.remove(profile);
        profile.addNotification(this.owner.getName() + " removed you from " + this.name);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post) {
        this.posts.add(post);
        String notification = post.getProfile().getName() + ": " + post.getMessage();
        this.profiles
                .forEach(profile -> profile.addNotification(notification));
    }

    public void removePost(Post post) {
        this.posts.remove(post);
        String notification = post.getProfile().getName() + " removed this message from the group:" +
                " " + post.getMessage();
        this.profiles
                .forEach(profile -> profile.addNotification(notification));
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
}
