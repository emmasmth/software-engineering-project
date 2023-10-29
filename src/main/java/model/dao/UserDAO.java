// SPDX-License-Identifier: MIT

package model.dao;

import model.entity.User;

public class UserDAO extends GenericDAO<User>
{
    public UserDAO(){
        super(User.class);
    }


}
