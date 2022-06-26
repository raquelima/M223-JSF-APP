package ch.bbzbl.dao;

import ch.bbzbl.entity.Person;
import ch.bbzbl.entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserDAO extends GenericDAO<User> {

    private static final long serialVersionUID = 1L;

    public UserDAO() {
        super(User.class);
    }

    public User findUser(String username, String password) {
        User user = super.findUser(username, password);

        return user;
    }
}
