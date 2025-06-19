package com.jabberpoint.mementoPattern;

public interface Caretaker<T> {
    void saveMemento(T memento);
    T getLastMemento();
}
