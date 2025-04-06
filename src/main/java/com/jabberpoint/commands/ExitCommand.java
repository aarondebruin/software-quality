package com.jabberpoint.commands;

import com.jabberpoint.Presentation;

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
