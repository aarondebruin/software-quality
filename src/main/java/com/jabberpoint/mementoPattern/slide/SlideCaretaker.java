package com.jabberpoint.mementoPattern.slide;

import com.jabberpoint.mementoPattern.Caretaker;

import java.util.Stack;

public class SlideCaretaker implements Caretaker<SlideMemento> {
    private Stack<SlideMemento> history = new Stack<>();

    public void saveMemento(SlideMemento memento) {
        history.push(memento);
    }

    public SlideMemento getLastMemento() {
        return history.isEmpty() ? null : history.pop();
    }
}
