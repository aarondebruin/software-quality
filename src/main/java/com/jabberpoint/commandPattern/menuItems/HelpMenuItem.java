package com.jabberpoint.commandPattern.menuItems;

import com.jabberpoint.commandPattern.commands.AboutCommand;
import com.jabberpoint.commandPattern.commands.Command;

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
