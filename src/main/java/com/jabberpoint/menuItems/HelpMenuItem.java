package com.jabberpoint.menuItems;

import com.jabberpoint.commands.AboutCommand;
import com.jabberpoint.commands.Command;

import java.awt.*;

public class HelpMenuItem extends Menu {
    public HelpMenuItem(Frame parent) {
        super("Help");
        add(createMenuItem("About", new AboutCommand(parent)));
    }

    private MenuItem createMenuItem(String name, Command command) {
        MenuItem menuItem = new MenuItem(name);
        menuItem.addActionListener(e -> command.execute());
        return menuItem;
    }
}
