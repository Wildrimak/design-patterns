package br.com.wildrimak.shows.observer.second.models;

import java.time.OffsetDateTime;

public class Post {

    private Group group;
    private Profile profile;
    private OffsetDateTime dateTime;
    private String message;

    public Post(Group group, Profile profile, String message){
        this.group = group;
        this.profile = profile;
        this.dateTime = OffsetDateTime.now();
        this.message = message;
    }

    public Group getGroup() {
        return group;
    }

    public Profile getProfile() {
        return profile;
    }

    public OffsetDateTime getDateTime() {
        return dateTime;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (!group.equals(post.group)) return false;
        if (!profile.equals(post.profile)) return false;
        if (!dateTime.equals(post.dateTime)) return false;
        return message.equals(post.message);
    }

    @Override
    public int hashCode() {
        int result = group.hashCode();
        result = 31 * result + profile.hashCode();
        result = 31 * result + dateTime.hashCode();
        result = 31 * result + message.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Post{" +
                "group=" + group +
                ", dateTime=" + dateTime +
                ", profile=" + profile +
                ", message='" + message + '\'' +
                '}';
    }
}
