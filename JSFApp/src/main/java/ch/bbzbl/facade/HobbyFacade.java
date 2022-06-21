package ch.bbzbl.facade;

import ch.bbzbl.dao.EntityManagerHelper;
import ch.bbzbl.dao.HobbyDAO;
import ch.bbzbl.entity.Hobby;

import java.io.Serializable;
import java.util.List;

public class HobbyFacade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private HobbyDAO hobbyDAO = new HobbyDAO();

	public void createHobby(Hobby hobby) {
		EntityManagerHelper.beginTransaction();
		hobbyDAO.save(hobby);
		EntityManagerHelper.commitAndCloseTransaction();
	}

	public void updateHobby(Hobby hobby) {
		EntityManagerHelper.beginTransaction();
		hobbyDAO.update(hobby);
		//Hobby persistedHobby = hobbyDAO.find(hobby.getId());
		//persistedLng.setName(hobby.getName());
		EntityManagerHelper.commitAndCloseTransaction();
	}
	
	public void deleteHobby(Hobby hobby) {
		EntityManagerHelper.beginTransaction();
		Hobby persistedLng = hobbyDAO.findReferenceOnly(hobby.getId());
		hobbyDAO.delete(persistedLng);
		EntityManagerHelper.commitAndCloseTransaction();
	}

	public Hobby findHobby(int hobbyId) {
		EntityManagerHelper.beginTransaction();
		Hobby hobby = hobbyDAO.find(hobbyId);
		EntityManagerHelper.commitAndCloseTransaction();
		return hobby;
	}

	public List<Hobby> listAll() {
		EntityManagerHelper.beginTransaction();
		List<Hobby> result = hobbyDAO.findAll();
		EntityManagerHelper.commitAndCloseTransaction();
		return result;
	}
}