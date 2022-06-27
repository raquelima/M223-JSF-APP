package ch.bbzbl.bean;

import ch.bbzbl.entity.Person;
import ch.bbzbl.entity.User;
import ch.bbzbl.facade.PersonFacade;
import ch.bbzbl.facade.UserFacade;
import com.sun.faces.context.flash.ELFlash;

import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@SessionScoped
@ManagedBean(name = "userBean")
public class UserBean implements Serializable {


    public static final String DI_NAME = "#{userBean}";
    private static final long serialVersionUID = 1L;
    private User user;

    private UserFacade userFacade;


    public boolean isAdmin() {
        return getUser().isAdmin();
    }

    public boolean isDefaultUser() {
        return user.isUser();
    }

    public String logOut() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/pages/public/login.xhtml";
    }

    public void switchMode() {
        UserFacade userFacade = new UserFacade();
        getUser().setDarkMode(!getUser().getDarkMode());
        userFacade.updateUser(getUser());
    }

    public User getUser() {
        if (user == null) {
            user = new User();
            Object user = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
            this.user = (User) user;
        }
        return this.user;
    }

    public UserFacade getUserFacade() {
        if (userFacade == null) {
            userFacade = new UserFacade();
        }

        return userFacade;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
