package com.jabberpoint.menuItems;

import com.jabberpoint.Presentation;
import com.jabberpoint.commands.Command;
import com.jabberpoint.commands.GoToCommand;
import com.jabberpoint.commands.NextCommand;
import com.jabberpoint.commands.PrevCommand;

import java.awt.*;

public class ViewMenuItem extends Menu {
    public ViewMenuItem(Presentation pres) {
        super("View");

        add(createMenuItem("Next", new NextCommand(pres)));
        add(createMenuItem("Prev", new PrevCommand(pres)));
        add(createMenuItem("Go to", new GoToCommand(pres)));
    }

    private MenuItem createMenuItem(String name, Command command) {
        MenuItem menuItem = new MenuItem(name);
        menuItem.addActionListener(e -> command.execute());
        return menuItem;
    }
}
