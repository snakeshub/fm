import java.util.Objects;

/**
 * The Player class represents an object of interest to the FootballTeam 
 * class, it will create player objects that can then be used in FootballTeam
 * 
 * @author Nicholas Sullivan
 * @version 1.0
 */

public class Player implements Comparable<Player>
{
    // Variables
    private String name;
    private int age;
    private int salary;

    /**
     * Constructor to create a Player objects with their name, age and salary
     * 
     * @param name String of the players name.
     * @param age int of the players age.
     * @param salary int of the players salary.
     */
    public Player(String name, int age, int salary)
    {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    
    /**
     * Setter method for a player name
     *
     * @param    String of the Player name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Setter method for a player age
     *
     * @param    int of the Player age
     */
    public void setAge(int age)
    {
        this.age = age;
    }
    
    /**
     * Setter method for a player salary
     *
     * @param    int of the Player salary
     */
    public void setSalary(int salary)
    {
        this.salary = salary;
    }
    
    /**
     * Getter method for a player name
     *
     * @return    String of the Player name is returned
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Getter method for a player age
     *
     * @return    int of the Player age is returned
     */
    public int getAge()
    {
        return age;
    }
    
    /**
     * Getter method for a player salary
     *
     * @return    int of the Player salary is returned
     */
    public int getSalary()
    {
        return salary;
    }
    
    /**
     * Generate a string representing the football player, dispays the name
     * , age and salary
     * 
     * @return text A string showing the fields of a player
     */    
    @Override
    public String toString()
    {
        String text = ("Name: "+ name + " Age: "+ age + 
        " Salary: £"+ salary);
        return text;
    }
    
    /**
     * Takes the return value from toString() and prints to the terminal 
     */
    public void display()
    {
        System.out.println(toString());
    }
    
    /**
     * Overrides the Object class equals method to return true if the
     * name and age are the same as this object's and false otherwise
     * 
     * @return true if the name and age are the same as the object
     */
    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) 
        {
            return true;
        }
        if(!(obj instanceof Player))
        {
            return false; //not a Player object
        }
        Player other = (Player) obj;
        return name.equals(other.name) &&
            age == other.age;
    }
    
    /**
     * Overrides the Object class hashCode method by passing it the
     * player name and age
     * 
     * @return A hashcode based on name and age
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(name, age);
    }
    
    /**
     * Compare the current player with a given player to sort alphabetically
     * 
     * @param otherPlayer Another Player object
     */
    public int compareTo(Player otherPlayer)
    {
        return name.compareTo(otherPlayer.name);
    }
    
}
