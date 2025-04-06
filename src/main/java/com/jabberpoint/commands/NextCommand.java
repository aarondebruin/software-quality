package com.jabberpoint.commands;

import com.jabberpoint.Presentation;

public class NextCommand implements Command{
    private Presentation presentation;

    public NextCommand(Presentation pres) {
        this.presentation = pres;
    }

    @Override
    public void execute() {
        presentation.nextSlide();
    }
}
