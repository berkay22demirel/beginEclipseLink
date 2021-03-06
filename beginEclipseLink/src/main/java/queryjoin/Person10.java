package queryjoin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Person10 {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String surname;
	private int age;
	@ManyToOne
	private Department3 department;
	
	public Person10() {
		super();
	}

	public Person10(String name, String surname, int age) {
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

	public Department3 getDepartment() {
		return department;
	}

	public void setDepartment(Department3 department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Person10 [id=" + id + ", name=" + name + ", surname=" + surname
				+ ", age=" + age + ", department=" + department + "]";
	}

}
