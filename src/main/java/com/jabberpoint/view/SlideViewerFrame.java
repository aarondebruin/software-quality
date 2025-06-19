package com.jabberpoint.view;

import com.jabberpoint.commandPattern.CommandRegistry;
import com.jabberpoint.commandPattern.KeyController;
import com.jabberpoint.commandPattern.commands.Command;
import com.jabberpoint.core.Presentation;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;
import javax.swing.JFrame;

/**
 * Het applicatiewindow voor een slideviewcomponent
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class SlideViewerFrame extends JFrame {
  private static final long serialVersionUID = 3227L;

  private static final String JABTITLE = "Jabberpoint 1.6 - OU";
  public static final int WIDTH = 1200;
  public static final int HEIGHT = 800;

  public SlideViewerFrame(String title, Presentation presentation) {
    super(title);
    SlideViewerComponent slideViewerComponent = new SlideViewerComponent(presentation, this);
    presentation.setShowView(slideViewerComponent);
    setupWindow(slideViewerComponent, presentation);
  }

  public SlideViewerFrame(String title, Presentation presentation, boolean testMode) {
    super(title);
    SlideViewerComponent slideViewerComponent = new SlideViewerComponent(presentation, this);
    presentation.setShowView(slideViewerComponent);
    if (!testMode) {
      setupWindow(slideViewerComponent, presentation);
    } else {
      // Setup zonder setVisible en zonder window listener, alleen basics
      setTitle(JABTITLE);
      getContentPane().add(slideViewerComponent);
      setSize(new Dimension(WIDTH, HEIGHT));
    }
  }


  // De GUI opzetten
  public void setupWindow(SlideViewerComponent slideViewerComponent, Presentation presentation) {
    setTitle(JABTITLE);

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    getContentPane().add(slideViewerComponent);

    Map<Integer, Command> keyCommands = CommandRegistry.createKeyCommands(presentation, this);
    KeyController keyController = new KeyController(keyCommands);
    addKeyListener(keyController);

    setMenuBar(new MenuController(this, presentation));

    setSize(new Dimension(WIDTH, HEIGHT));
    setVisible(true);
  }


}
