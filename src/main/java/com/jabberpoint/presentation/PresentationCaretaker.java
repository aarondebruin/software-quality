package com.jabberpoint.presentation;

import com.jabberpoint.Caretaker;

import java.util.Stack;

public class PresentationCaretaker implements Caretaker<PresentationMemento> {
    private Stack<PresentationMemento> history = new Stack<>();

    public void saveMemento(PresentationMemento memento) {
        history.push(memento);
    }

    public PresentationMemento getLastMemento() {
        return history.isEmpty() ? null : history.pop();
    }
}

