package com.jabberpoint.commandPattern.commands;

import com.jabberpoint.core.Presentation;

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
