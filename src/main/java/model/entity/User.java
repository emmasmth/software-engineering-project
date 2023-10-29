// SPDX-License-Identifier: MIT
package model.entity;

// imports
import javax.persistence.*;
@Entity
public class User extends BaseEntity
{
    @Id @Column (name = "idUser") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID = null;
    @Column (unique = true) // Login must be unique for each record in DB
    private String Login;
    private String Name;
    private String Password;
    private int Permission;
    @Column(name = "wins")
    private int wins;
    @Column(name = "losses")
    private int losses;
    @Column(name = "ties")
    private int ties;

    // keyword transient, meaning that the data member will not be serialized.
    public transient static final int USER_PERMISSION = 1;
    public transient static final int ADMIN_PERMISSION = 2;


    public User()
    {
        this.Permission = USER_PERMISSION;
    }

    public User(Integer ID, String name, String login, String password, int permission)
    {
        this.ID = ID;
        Name = name;
        Login = login;
        Password = password;
        Permission = permission;
    }

    /**
     * This function gets a User's ID.
     * @return an Integer, the User's ID.
     */
    @Override
    public Integer getID()
    {
        return ID;
    }

    /**
     * This function sets a User's ID to the argument passed in.
     * @param ID, an Integer that should be the new value of the User's ID.
     */
    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    /**
     * This function sets a User's Name to the argument passed in.
     * @param name, a String that should be the new value of the User's Name.
     */
    public void setName(String name){
        Name = name;
    }

    /**
     * This function gets a User's name.
     * @return a String, the User's name.
     */
    public String getName()
    {
        return Name;
    }

    /**
     * This function gets a User's login.
     * @return a String, the User's login.
     */
    public String getLogin()
    {
        return Login;
    }

    /**
     * This function sets a User's login to the argument passed in.
     * @param login, a String that should be the new value of the User's login.
     */
    public void setLogin(String login)
    {
        Login = login;
    }

    /**
     * This function gets a User's password.
     * @return a String, the User's password.
     */
    public String getPassword()
    {
        // FIXME : is it okay for this to be public?
        return Password;
    }

    /**
     * This function sets a User's password to be the argument passed in.
     * @param password, a String that should be the new value of the User's password.
     */
    public void setPassword(String password)
    {
        Password = password;
    }

    /**
     * This function gets a User's permission.
     * @return an int, the User's permission.
     */
    public int getPermission()
    {
        return Permission;
    }

    public void setPermission(int permission)
    {
        Permission = permission;
    }

    //getters, setters, and incrementers for the users ties, wins, and losses
    //wins
    public int getWins(){return wins;}
    public void setWins(int wins) {
        this.wins = wins;
    }
    public void incrementWins() {
        this.wins++;
    }

    //loses
    public int getLosses(){return losses;}
    public void setLosses(int losses) {
        this.losses = losses;
    }
    public void incrementLosses() {
        this.losses++;
    }

    //ties
    public int getTies(){return ties;}
    public void setTies(int ties) {
        this.ties = ties;
    }
    public void incrementTies() {
        this.ties++;
    }

    /**
     * getRecord method
     * @return a string of the users W/L/D record
     */
    public String getRecord(){
        return("Your record (W/L/D)" + getWins() + "/" + getLosses() + "/" + getTies());
    }





    @Override
    public String toString() {

        if (Permission == USER_PERMISSION)
        {
            return "Player";
        }
        else if (Permission == ADMIN_PERMISSION)
        {
            return "Admin";
        }
        else
        {
            return "Unknown";
        }

    }

}
