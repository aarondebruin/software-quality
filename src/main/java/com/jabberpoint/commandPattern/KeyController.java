package com.jabberpoint.commandPattern;

import com.jabberpoint.commandPattern.commands.Command;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Map;

/**
 * This is the KeyController (KeyListener)
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */


public class KeyController extends KeyAdapter {

  private final Map<Integer, Command> keyCommandMap;

  public KeyController(Map<Integer, Command> keyCommandMap) {
    this.keyCommandMap = keyCommandMap;
  }

  @Override
  public void keyPressed(KeyEvent e) {
    Command command = keyCommandMap.get(e.getKeyCode());
    if (command != null) {
      command.execute();
    }
  }
}