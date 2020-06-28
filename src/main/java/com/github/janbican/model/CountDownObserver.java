package com.github.janbican.model;

public interface CountDownObserver {
    void update(int seconds);
    void timeIsUp();
}
