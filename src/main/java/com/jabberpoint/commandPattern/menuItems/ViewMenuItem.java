package com.jabberpoint.commandPattern.menuItems;

import com.jabberpoint.core.Presentation;
import com.jabberpoint.commandPattern.commands.Command;
import com.jabberpoint.commandPattern.commands.GoToCommand;
import com.jabberpoint.commandPattern.commands.NextCommand;
import com.jabberpoint.commandPattern.commands.PrevCommand;

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
