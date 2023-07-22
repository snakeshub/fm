import javax.swing.*;

/**
 * This is where the game starts, and a GUI will begin
 *
 * @author Nick Sullivan
 * @version 1.0
 */
public class Game
{
    // instance variables
    private JFrame frame; //frame for the game to run inside, needs import javax.swing
    
    /**
     * A main method to launch the game and it GUI
     */
    public static void main(String[] args)
    {
        System.out.println("Welcome to The Football Manager");
        //makeFrame();
    }
    
    /**
     * The opening frame
     */
    private void makeFrame()
    {
        frame = new JFrame("The Football Manager");
        
    }
}    