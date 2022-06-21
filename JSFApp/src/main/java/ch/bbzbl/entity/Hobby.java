package ch.bbzbl.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Hobby implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String FIND_PERSON_BY_ID_WITH_LANGUAGES = "Person.findPersonByIdWithLanguages";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String hobby;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "hobby_id")
	private List<Person> persons = null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Hobby) {
			Hobby person = (Hobby) obj;
			return person.getId() == id;
		}

		return false;
	}
	public void addPerson(Person p) {
		if (persons == null) {
			persons = new ArrayList<Person>();
		}
		persons.add(p);
	}
}