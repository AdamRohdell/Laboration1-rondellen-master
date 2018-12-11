package main.views;

import main.IRenderable;
import main.model.vehicles.cars.Car;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {


    ArrayList<IRenderable> renderables;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.white);

        // Print an error message in case file is not found with a try/catch block

            // You can remove the "src\\pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            // Linux users need to modify \ to / in path string

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(renderables != null){
            renderables.forEach(r -> {
                g.drawImage(getImage(r), r.getPosition().x, r.getPosition().y, null); // see javadoc for more info on the parameters
            });
        }
    }

    public void render(ArrayList<? extends IRenderable> renderables){
        this.renderables = (ArrayList<IRenderable>) renderables;
        repaint();

    }

    public BufferedImage getImage(IRenderable r){
            String path = "";
            try {
                return ImageIO.read(new File("src" + File.separator + "pics" + File.separator + r.getClass().getSimpleName() + ".jpg"));
            }catch (Exception e){

            }
            return null;

    }
}