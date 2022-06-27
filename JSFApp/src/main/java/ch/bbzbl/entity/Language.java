package ch.bbzbl.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Language implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;


	@Version
	private long version;
	@ManyToMany(mappedBy="languages")
	private List<Person> persons;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		if (obj instanceof Language) {
			Language language = (Language) obj;
			return language.getId() == id;
		}

		return false;
	}
	
	@Override
	public String toString() {
		return name;
	}
}