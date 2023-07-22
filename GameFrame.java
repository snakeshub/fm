import javax.swing.*;

/**
 * This is where the game starts, and a GUI will begin
 *
 * @author Nick Sullivan
 * @version 1.0
 */
public class GameFrame extends JFrame
{
    // instance variables
    private JTextField nameField;
    private JComboBox<String> teamComboBox;
    
    /**
     * A constructor to launch the game and its GUI
     */
    public GameFrame()
    {
        setTitle("The Football Manager");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        
        JLabel nameLabel = new JLabel("Enter your name: ");
        nameField = new JTextField(20);
        
        JLabel teamLabel = new JLabel("Choose a team to manage: ");
        String[] teamOptions = {"Team1", "Team2", "Team3", "Team4"};
        teamComboBox = new JComboBox<>(teamOptions);
        
        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(e -> startGame());
        
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(teamLabel);
        panel.add(teamComboBox);
        panel.add(startButton);
        
        add(panel);
        setVisible(true);
        
    }
    
    /**
     * Start game button
     */
    private void startGame()
    {
        String playerName = nameField.getText();
        String teamName = (String) teamComboBox.getSelectedItem();
        
        // game logic goes here
        
        JOptionPane.showMessageDialog(this, "Game Over!");
        dispose();
    }
    
    /**
     * A main method to launch the game and it GUI
     */
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new GameFrame());
    }
    
}    