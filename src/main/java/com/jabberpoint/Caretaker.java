package com.jabberpoint;

public interface Caretaker<T> {
    void saveMemento(T memento);
    T getLastMemento();
}
