package ch.bbzbl.bean;

import ch.bbzbl.entity.User;
import ch.bbzbl.facade.UserFacade;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@RequestScoped
@ManagedBean(name="loginBean")
public class LoginBean extends AbstractBean {
    @ManagedProperty(value = UserBean.DI_NAME)
    private UserBean userBean; //1
    private User user; //2

    private String password;

    public UserBean getUserBean() {
        return userBean;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() { //3
        UserFacade userFacade = new UserFacade(); //4
        User user = userFacade.isValidLogin(this.user.getName(), this.user.getPassword()); //5
        if(user != null){
            userBean.setUser(user); //6
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest)

                    context.getExternalContext().getRequest();

            request.getSession().setAttribute("user", user); //7
            return "/pages/protected/index.xhtml"; //8
        }
        displayErrorMessageToUser("Check username and/or password");
        return null;
    }
    public void setUserBean(UserBean userBean) { //9
        this.userBean = userBean;
    }
}
