package com.jabberpoint.menuItems;

import com.jabberpoint.Presentation;
import com.jabberpoint.commands.*;
import com.jabberpoint.XMLAccessor;

import java.awt.*;

public class FileMenuItem extends Menu {
    public FileMenuItem(Frame parent, Presentation pres) {
        super("File");

        add(createMenuItem("Open", new OpenCommand(pres, parent, new XMLAccessor())));
        add(createMenuItem("New", new NewCommand(pres)));
        add(createMenuItem("Save", new SaveCommand(pres, parent)));
        addSeparator();
        add(createMenuItem("Exit", new ExitCommand(pres)));
    }

    private MenuItem createMenuItem(String name, Command command) {
        MenuItem menuItem = new MenuItem(name);
        menuItem.addActionListener(e -> command.execute());
        return menuItem;
    }
}