package com.jabberpoint.commandPattern.commands;

import com.jabberpoint.core.Presentation;

public class PrevCommand implements Command{
    private Presentation presentation;

    public PrevCommand(Presentation pres) {
        this.presentation = pres;
    }

    @Override
    public void execute() {
        presentation.prevSlide();
    }
}
