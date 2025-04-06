package com.jabberpoint.commands;

import com.jabberpoint.Presentation;

import javax.swing.*;

public class GoToCommand implements Command{
    private Presentation presentation;

    public GoToCommand(Presentation pres) {
        this.presentation = pres;
    }

    @Override
    public void execute() {
        String pageNumberStr = JOptionPane.showInputDialog("Page number?");
        try {
            int pageNumber = Integer.parseInt(pageNumberStr);
            presentation.setSlideNumber(pageNumber - 1);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
