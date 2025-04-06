package com.jabberpoint.commands;

import com.jabberpoint.Accessor;
import com.jabberpoint.Presentation;
import com.jabberpoint.XMLAccessor;

import javax.swing.*;
import java.awt.*;

public class SaveCommand implements Command{
    private Presentation presentation;
    private Frame parent;

    public SaveCommand(Presentation pres, Frame parent) {
        this.presentation = pres;
        this.parent = parent;
    }

    @Override
    public void execute() {
        Accessor xmlAccessor = new XMLAccessor();
        try {
            xmlAccessor.saveFile(presentation, "dump.xml");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(parent, "IO Exception: " + e, "Save Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
