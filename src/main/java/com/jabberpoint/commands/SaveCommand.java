package com.jabberpoint.commands;

import com.jabberpoint.Accessor;
import com.jabberpoint.Presentation;
import com.jabberpoint.XMLAccessor;

import javax.swing.*;
import java.awt.*;

public class SaveCommand implements Command {
    private final Presentation presentation;
    private final Frame parent;
    private final Accessor accessor;

    public SaveCommand(Presentation pres, Frame parent, Accessor accessor) {
        this.presentation = pres;
        this.parent = parent;
        this.accessor = accessor;
    }

    public SaveCommand(Presentation pres, Frame parent) {
        this(pres, parent, new XMLAccessor());
    }

    @Override
    public void execute() {
        try {
            accessor.saveFile(presentation, "dump.xml");
        } catch (java.io.IOException e) {
            JOptionPane.showMessageDialog(parent, "IO Exception: " + e, "Save Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}