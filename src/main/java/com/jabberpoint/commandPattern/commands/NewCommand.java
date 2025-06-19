package com.jabberpoint.commandPattern.commands;

import com.jabberpoint.core.Presentation;

public class NewCommand implements Command{
    private Presentation presentation;

    public NewCommand(Presentation pres) {
        this.presentation = pres;
    }

    @Override
    public void execute() {
        presentation.clear();
    }
}
