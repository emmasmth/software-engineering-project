// SPDX-License-Identifier: MIT
package model.entity;

// imports
import javax.persistence.*;
@Entity
@Table(name = "user", schema = "blackjack")
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity
{
    @Id @Column (name = "idUser") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID = null;
    @Column (unique = true) // Login must be unique for each record in DB
    private String Login;
    private String Password;
    private int Permission;

    // keyword transient, meaning that the data member will not be serialized.
    public transient static final int USER_PERMISSION = 1;
    public transient static final int ADMIN_PERMISSION = 2;


    public User()
    {
        this.Permission = USER_PERMISSION;
    }

    public User(Integer ID, String login, String password, int permission)
    {
        this.ID = ID;
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

    public String getPermissionAsString() {

        if (Permission == USER_PERMISSION)
        {
            return "User";
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


/**
 *
 * create table user(
 *     id_user int not null auto_increment,
 *     name_user varchar(50),
 *     login varchar(30) not null,
 *     password char(60) not null,
 *     permission int not null default 1,
 *     constraint user_pk primary key(id_user),
 *     constraint user_login_uk unique key(login)
 *  );
 */