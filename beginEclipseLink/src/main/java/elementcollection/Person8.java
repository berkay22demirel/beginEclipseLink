package elementcollection;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person8 {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String name;
	private String surname;
	private int age;
	@ElementCollection
	private List<Phone> phones;
	
	public Person8() {
		super();
	}

	public Person8(String name, String surname, int age) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	@Override
	public String toString() {
		return "Person8 [id=" + id + ", name=" + name + ", surname=" + surname
				+ ", age=" + age + ", phones=" + phones + "]";
	}

}
