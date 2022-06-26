package ch.bbzbl.bean;

import ch.bbzbl.entity.Person;
import ch.bbzbl.entity.User;
import ch.bbzbl.facade.UserFacade;

import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@SessionScoped
@ManagedBean(name="userBean")
public class UserBean implements Serializable {
    public static final String DI_NAME = "#{userBean}";
    private static final long serialVersionUID = 1L;
    private User user;
    public boolean isAdmin() {
        return user.isAdmin();
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
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest)

                context.getExternalContext().getRequest();

        User name = request.getSession().getAttribute("user");
        userFacade.updateUser(name);
        name.setDarkMode(!name.getDarkMode());

    }
    public User getUser() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
