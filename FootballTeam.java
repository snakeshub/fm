import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * The FootballTeam class represents a football team and will hold a map
 * of the players and of the amount of goals they have scored.
 *
 * @author Nicholas Sullivan
 * @version 1.0
 */
public class FootballTeam
{
    // variables
    private static int playerID = 1; 
    private HashMap<Integer, Player> squad; 
    private HashMap<Integer, Integer> goals; 
    

    /**
     * Constructor for objects of class FootballTeam
     */
    public FootballTeam()
    {
        squad = new HashMap<>();
        goals = new HashMap<>();
    }

    /**
     * Populate the squad HashMap with 5 players and update the goals
     *  HashMap using the same unique playerID, this is very manual and will
     *  be replaced by imported data, just using for testing
     */
    public void populate()
    {
        squad.put(playerID, new Player("Nick", 25, 1000));
        goals.put(playerID, 3);
        playerID++;
        squad.put(playerID, new Player("Nat", 19, 10000));
        goals.put(playerID, 10);
        playerID++;
        squad.put(playerID, new Player("Lila", 30, 2000));
        goals.put(playerID, 20);
        playerID++;
        squad.put(playerID, new Player("Ethan", 15, 100));
        goals.put(playerID, 15);
        playerID++;
        squad.put(playerID, new Player("Bruce", 35, 90000));
        goals.put(playerID, 0);
        playerID++;
        
    }
    
    /**
     * Return the number of goals scored when given the players unique ID
     * 
     * @param playerNumber an int of the player number
     * @return number of goals scored by a given player
     */
    
    public int goalsScored(int playerNumber)
    {
        int goalsScored = goals.get(playerNumber);
        return goalsScored;
    }
    
    /**
     * Alter the number of goals scored stored in the numeric map when given 
     * a players ID and the new number of goals, if the player ID isn't in
     * the goals HashMap then it will do nothing
     * 
     * @param playerNumber an int of the player number
     * @param newGoals an int of the new number of goals
     */
    
    public void changeGoals(int playerNumber, int newGoals)
    {
        if(goals.containsKey(playerNumber))
        {
            goals.put(playerNumber, newGoals);
        }
    }
    
    /**
     * Return a total wage bill for the team by taking the salary from the
     * Player objects and adding them together
     * 
     * @return total an int of the total of the players salaries 
     */
    public int wageBill()
    {
        int total = 0; //initialise the local variable
        for(Player player : squad.values())
        {
            total = total + player.getSalary();
        }
        return total;
    }
    
    /**
     * Return the average salary of the players
     * 
     * @return total an int of the average of the players salaries 
     */
    public int averageSalary()
    {
        int total = 0; //initialise local variable
        for(Player player : squad.values())
        {
            total = total + player.getSalary();
        }
        return total / squad.size();
    }
    
    /**
     * Display a summary of the team salary, including the players individual
     * information, the total wage bill and the average salary. Printed to 
     * terminal
     */
    public void displaySummary()
    {
        System.out.println("**** Team  Salary Details ****");
        System.out.println("******************************");
        System.out.println("*   Name       *   Salary    *");
        for(Player player : squad.values())
        {
            System.out.println("*  "+ player.getName() +"     *     £"
            + player.getSalary()+" *");
        }
        System.out.println("******************************");
        System.out.println("*Average Salary  **** £"+averageSalary()+"*");
        System.out.println("*Total Wage Bill **** £"+wageBill()+"*");
        System.out.println("******************************");
    }
    
    /**
     * Clear all entries from the sqaud and goals maps
     */
    public void clear()
    {
        squad.clear();
        goals.clear();
    }
    
    /**
     * Read a CSV file when given the file path, and use this to populate
     * the squad map with objects of interest, and goals map with the goals
     * scored linked to the player ID
     * 
     * @param filename a String of the CSV file to be read
     */
    public boolean readCSVFile(String filename)
    {
        boolean fileRead = false;
        this.clear(); //empty the collections
        File userData = new File(filename);
        try
            (Scanner reader = new Scanner(userData))
            {
                while (reader.hasNextLine())
                {
                    // scan all 4 fields, add the first 3 to Player, and
                    // the last one to goals
                    Scanner lineScanner = new Scanner(reader.nextLine());
                    lineScanner.useDelimiter(",");
                    String name = lineScanner.next();
                    int age = lineScanner.nextInt();
                    int salary = lineScanner.nextInt();
                    int goalsScored = lineScanner.nextInt();
                    squad.put(playerID, new Player(name, age, salary));
                    goals.put(playerID, goalsScored);
                    playerID++;
                }
                return fileRead = true;
            }
        catch (FileNotFoundException e) 
        //return false if the filename is invalid
        {
            System.out.println("File not found: "+ filename);
            return fileRead = false;
        }
    }
}
