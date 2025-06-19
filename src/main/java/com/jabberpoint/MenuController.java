package com.jabberpoint;

import com.jabberpoint.commandPattern.menuItems.FileMenuItem;
import com.jabberpoint.commandPattern.menuItems.ViewMenuItem;
import com.jabberpoint.commandPattern.menuItems.HelpMenuItem;

import java.awt.Frame;
import java.awt.MenuBar;

/**
 * De controller voor het menu
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class MenuController extends MenuBar {
    private Frame parent;
    private Presentation presentation;

    public MenuController(Frame frame, Presentation pres) {
        this.parent = frame;
        this.presentation = pres;
        add(new FileMenuItem(parent, presentation));
        add(new ViewMenuItem(presentation));
        setHelpMenu(new HelpMenuItem(parent));
    }
}