package com.jabberpoint.commandPattern.commands;

import com.jabberpoint.core.Presentation;

public class ExitCommand implements Command{
    private Presentation presentation;

    public ExitCommand(Presentation pres) {
        this.presentation = pres;
    }

    @Override
    public void execute() {
        presentation.exit(0);
    }
}
