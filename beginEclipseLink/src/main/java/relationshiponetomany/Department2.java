package relationshiponetomany;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department2 {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String name;
	@OneToMany(mappedBy = "department")
	private Collection<Person6> persons;

	public Department2() {
		super();
	}

	public Department2(String name) {
		super();
		this.name = name;
	}

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

	public Collection<Person6> getPersons() {
		return persons;
	}

	public void setPersons(Collection<Person6> persons) {
		this.persons = persons;
	}

}
