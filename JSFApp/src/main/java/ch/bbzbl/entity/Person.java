package ch.bbzbl.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name = "Person.findPersonByIdWithLanguages", query = "select p from Person p left join fetch p.languages where p.id = :personId")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String FIND_PERSON_BY_ID_WITH_LANGUAGES = "Person.findPersonByIdWithLanguages";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;

	@ManyToOne
	@JoinColumn(name = "hobby", foreignKey = @javax.persistence.ForeignKey(name = "hobby_fk"))
	private Hobby hobby;

	@ManyToMany
	private List<Language> languages;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public Hobby getHobby() {
		return hobby;
	}

	public void setHobby(Hobby hobby) {
		this.hobby = hobby;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person person = (Person) obj;
			return person.getId() == id;
		}

		return false;
	}
}