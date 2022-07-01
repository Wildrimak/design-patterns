package br.com.wildrimak.shows.observer.second.models;

public interface Observable {

    void addSubscriber(Observer observer);
    void removeSubscriber(Observer observer);
    void notifySubscribers(Action action);

}
