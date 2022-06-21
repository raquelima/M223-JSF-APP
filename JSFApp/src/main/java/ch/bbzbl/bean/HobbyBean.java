package ch.bbzbl.bean;

import ch.bbzbl.entity.Hobby;
import ch.bbzbl.facade.HobbyFacade;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@ManagedBean(name="hobbyBean")
public class HobbyBean extends AbstractBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Hobby hobby;
	private List<Hobby> hobbies;
	private HobbyFacade hobbyFacade;

	public HobbyFacade getHobbyFacade() {
		if (hobbyFacade == null) {
			hobbyFacade = new HobbyFacade();
		}

		return hobbyFacade;
	}

	public Hobby getHobby() {
		if (hobby == null) {
			hobby = new Hobby();
		}

		return hobby;
	}

	public void setHobby(Hobby hobby) {
		this.hobby = hobby;
	}

	public void createHobby() {
		try {
			getHobbyFacade().createHobby(hobby);
			closeDialog();
			displayInfoMessageToUser("Created with success");
			loadHobbies();
			resetHobby();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while saving. Try again later");
			e.printStackTrace();
		}
	}
	
	public void updateHobby() {
		try {
			getHobbyFacade().updateHobby(hobby);
			closeDialog();
			displayInfoMessageToUser("Updated with success");
			loadHobbies();
			resetHobby();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while updating. Try again later");
			e.printStackTrace();
		}
	}
	
	public void deleteHobby() {
		try {
			getHobbyFacade().deleteHobby(hobby);
			closeDialog();
			displayInfoMessageToUser("Deleted with success");
			loadHobbies();
			resetHobby();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while removing. Try again later");
			e.printStackTrace();
		}
	}

	public List<Hobby> getAllHobbies() {
		if (hobbies == null) {
			loadHobbies();
		}

		return hobbies;
	}

	private void loadHobbies() {
		hobbies = getHobbyFacade().listAll();
	}

	public void resetHobby() {
		hobby = new Hobby();
	}
}