package ch.bbzbl.facade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import ch.bbzbl.dao.EntityManagerHelper;
import ch.bbzbl.dao.HobbyDAO;
import ch.bbzbl.dao.LanguageDAO;
import ch.bbzbl.dao.PersonDAO;
import ch.bbzbl.entity.Hobby;
import ch.bbzbl.entity.Language;
import ch.bbzbl.entity.Person;

public class PersonFacade implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private PersonDAO personDAO = new PersonDAO();
	private LanguageDAO languageDAO = new LanguageDAO();

	private HobbyDAO hobbyDAO = new HobbyDAO();

	public void createPerson(Person person) {
		EntityManagerHelper.beginTransaction();
		personDAO.save(person);
		EntityManagerHelper.commitAndCloseTransaction();
	}

	public void updatePerson(Person person) {
		EntityManagerHelper.beginTransaction();
		personDAO.update(person);
		//Person persistedPerson = personDAO.find(person.getId());
		//persistedPerson.setName(person.getName());
		EntityManagerHelper.commitAndCloseTransaction();
	}
	
	public void deletePerson(Person person){
		EntityManagerHelper.beginTransaction();
		Person persistedPersonWithIdOnly = personDAO.findReferenceOnly(person.getId());
		personDAO.delete(persistedPersonWithIdOnly);
		EntityManagerHelper.commitAndCloseTransaction();
		
	}

	public Person findPerson(int personId) {
		EntityManagerHelper.beginTransaction();
		Person person = personDAO.find(personId);
		EntityManagerHelper.commitAndCloseTransaction();
		return person;
	}

	public List<Person> listAll() {
		EntityManagerHelper.beginTransaction();
		List<Person> result = personDAO.findAll();
		EntityManagerHelper.commitAndCloseTransaction();

		return result;
	}

	public Person findPersonWithAllLanguages(int personId) {
		EntityManagerHelper.beginTransaction();
		Person person = personDAO.findPersonWithAllLanguages(personId);
		EntityManagerHelper.commitAndCloseTransaction();
		return person;
	}

	public Person findPersonWithAllHobbies(int personId) {
		EntityManagerHelper.beginTransaction();
		Person person = personDAO.findPersonWithAllLanguages(personId);
		EntityManagerHelper.commitAndCloseTransaction();
		return person;
	}

	public void addLanguageToPerson(int languageId, int personId) {
		EntityManagerHelper.beginTransaction();
		Language language = languageDAO.find(languageId);
		Person person = personDAO.find(personId);
		person.getLanguages().add(language);
		language.getPersons().add(person);
		EntityManagerHelper.commitAndCloseTransaction();
	}

	public void removeLanguageFromPerson(int languageId, int personId) {
		EntityManagerHelper.beginTransaction();
		Language language = languageDAO.find(languageId);
		Person person = personDAO.find(personId);
		person.getLanguages().remove(language);
		language.getPersons().remove(person);
		EntityManagerHelper.commitAndCloseTransaction();
	}

	public void addHobbyToPerson(int hobbyId, int personId) {
		EntityManagerHelper.beginTransaction();
		Hobby hobby = hobbyDAO.find(hobbyId);
		Person person = personDAO.find(personId);
		person.setHobby(hobby);
		EntityManagerHelper.commitAndCloseTransaction();
	}

	public void removeHobbyFromPerson(int personId) {
		EntityManagerHelper.beginTransaction();
		Person person = personDAO.find(personId);
		person.setHobby(null);
		EntityManagerHelper.commitAndCloseTransaction();
	}
}