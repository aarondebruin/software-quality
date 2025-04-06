package com.jabberpoint.commands;

import com.jabberpoint.Accessor;
import com.jabberpoint.Presentation;
import com.jabberpoint.XMLAccessor;

import javax.swing.*;
import java.awt.*;

public class OpenCommand implements Command{
    private Presentation presentation;
    private Frame parent;

    public OpenCommand(Presentation pres, Frame parent) {
        this.presentation = pres;
        this.parent = parent;
    }

    @Override
    public void execute() {
        presentation.clear();
        Accessor xmlAccessor = new XMLAccessor();
        try {
            xmlAccessor.loadFile(presentation, "dump.xml");
            presentation.setSlideNumber(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(parent, "IO Exception: " + e, "Load Error", JOptionPane.ERROR_MESSAGE);
        }
        parent.repaint();
    }
}
