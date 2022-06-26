package ch.bbzbl.facade;

import ch.bbzbl.dao.*;
import ch.bbzbl.entity.Person;
import ch.bbzbl.entity.User;

import java.io.Serializable;

public class UserFacade implements Serializable {

    private static final long serialVersionUID = 1L;
    private UserDAO userDAO = new UserDAO();

    public User isValidLogin(String username, String password) {
        EntityManagerHelper.beginTransaction();
            User user = userDAO.findUser(username, password);
        EntityManagerHelper.commitAndCloseTransaction();
        return user;
    }
}
