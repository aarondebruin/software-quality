package com.jabberpoint;

import com.jabberpoint.commands.*;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

  // De GUI opzetten
  public void setupWindow(SlideViewerComponent slideViewerComponent, Presentation presentation) {
    setTitle(JABTITLE);
    addWindowListener(
            new WindowAdapter() {
              public void windowClosing(WindowEvent e) {
                System.exit(0);
              }
            });
    getContentPane().add(slideViewerComponent);

    OpenCommand openCommand = new OpenCommand(presentation, this);
    SaveCommand saveCommand = new SaveCommand(presentation, this);
    NewCommand newCommand = new NewCommand(presentation);
    NextCommand nextCommand = new NextCommand(presentation);
    PrevCommand prevCommand = new PrevCommand(presentation);
    ExitCommand exitCommand = new ExitCommand(presentation);

    KeyController keyController = new KeyController(nextCommand, prevCommand, openCommand, saveCommand, newCommand, exitCommand);
    addKeyListener(keyController);

    setMenuBar(new MenuController(this, presentation));

    setSize(new Dimension(WIDTH, HEIGHT)); // Dezelfde maten als Slide hanteert.
    setVisible(true);
  }

}
