package com.jabberpoint.commandPattern.commands;

import com.jabberpoint.core.Presentation;

import javax.swing.*;

public class GoToCommand implements Command {
    private final Presentation presentation;
    private String input; // Toegevoegd voor testbaarheid

    public GoToCommand(Presentation pres) {
        this(pres, null);
    }

    public GoToCommand(Presentation pres, String input) {
        this.presentation = pres;
        this.input = input;
    }

    @Override
    public void execute() {
        String pageNumberStr = (input != null) ? input : JOptionPane.showInputDialog("Page number?");
        try {
            int pageNumber = Integer.parseInt(pageNumberStr);
            presentation.setSlideNumber(pageNumber - 1);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}