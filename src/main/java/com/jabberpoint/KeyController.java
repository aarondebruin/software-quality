package com.jabberpoint;

import com.jabberpoint.commands.Command;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
  private Command nextCommand;
  private Command prevCommand;
  private Command openCommand;
  private Command saveCommand;
  private Command newCommand;
  private Command exitCommand;

  public KeyController(Command nextCommand, Command prevCommand, Command openCommand,
                       Command saveCommand, Command newCommand, Command exitCommand) {
    this.nextCommand = nextCommand;
    this.prevCommand = prevCommand;
    this.openCommand = openCommand;
    this.saveCommand = saveCommand;
    this.newCommand = newCommand;
    this.exitCommand = exitCommand;
  }

  @Override
  public void keyPressed(KeyEvent keyEvent) {
    switch (keyEvent.getKeyCode()) {
      case KeyEvent.VK_PAGE_DOWN:
      case KeyEvent.VK_DOWN:
      case KeyEvent.VK_ENTER:
      case '+':
        nextCommand.execute();
        break;
      case KeyEvent.VK_PAGE_UP:
      case KeyEvent.VK_UP:
      case '-':
        prevCommand.execute();
        break;
      case 'o':
      case 'O':
        openCommand.execute();
        break;
      case 's':
      case 'S':
        saveCommand.execute();
        break;
      case 'n':
      case 'N':
        newCommand.execute();
        break;
      case 'q':
      case 'Q':
        exitCommand.execute();
        break;
      default:
        break;
    }
  }
}
