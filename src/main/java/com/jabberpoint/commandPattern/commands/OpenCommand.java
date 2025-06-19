package com.jabberpoint.commandPattern.commands;

import com.jabberpoint.Accessor;
import com.jabberpoint.Presentation;
import com.jabberpoint.XMLAccessor;

import javax.swing.*;
import java.awt.*;

public class OpenCommand implements Command {
    private final Presentation presentation;
    private final Frame parent;
    private final Accessor accessor;

    public OpenCommand(Presentation pres, Frame parent, Accessor accessor) {
        this.presentation = pres;
        this.parent = parent;
        this.accessor = accessor;
    }

    public OpenCommand(Presentation pres, Frame parent) {
        this(pres, parent, new XMLAccessor());
    }

    @Override
    public void execute() {
        presentation.clear();
        try {
            accessor.loadFile(presentation, "dump.xml");
            presentation.setSlideNumber(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(parent, "IO Exception: " + e, "Load Error", JOptionPane.ERROR_MESSAGE);
        }
        parent.repaint();
    }
}