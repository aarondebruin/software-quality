package com.jabberpoint.commandPattern;


import com.jabberpoint.Presentation;
import com.jabberpoint.SlideViewerFrame;
import com.jabberpoint.commandPattern.commands.*;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {

    public static Map<Integer, Command> createKeyCommands(Presentation presentation, SlideViewerFrame frame) {
        Map<Integer, Command> map = new HashMap<>();

        Command next = new NextCommand(presentation);
        Command prev = new PrevCommand(presentation);
        Command open = new OpenCommand(presentation, frame);
        Command save = new SaveCommand(presentation, frame);
        Command exit = new ExitCommand(presentation);
        Command newPres = new NewCommand(presentation);

        // Next slide
        map.put(KeyEvent.VK_PAGE_DOWN, next);
        map.put(KeyEvent.VK_DOWN, next);
        map.put(KeyEvent.VK_ENTER, next);
        map.put(KeyEvent.VK_PLUS, next);

        // Previous slide
        map.put(KeyEvent.VK_PAGE_UP, prev);
        map.put(KeyEvent.VK_UP, prev);
        map.put(KeyEvent.VK_MINUS, prev);

        // File actions
        map.put(KeyEvent.VK_O, open);
        map.put(KeyEvent.VK_S, save);
        map.put(KeyEvent.VK_N, newPres);
        map.put(KeyEvent.VK_Q, exit);

        return map;
    }
}
