package simpletypes;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Person2 {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "surname")
	private String surname;
	@Column(name = "age")
	private int age;
	@Column(name = "salary")
	private int salary;
	@Column(name = "job")
	@Enumerated(EnumType.STRING)
	private JobEnum job;
	@Column(name = "dateofbirth")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	@Column(name = "nowdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar nowDate;
	@Lob
	@Column(name = "picture")
	private byte[] picture;

	public Person2() {
		super();
	}

	public Person2(int id, String name, String surname, int age, int salary,
			JobEnum job, Date dateOfBirth, Calendar nowDate, byte[] picture) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.salary = salary;
		this.job = job;
		this.dateOfBirth = dateOfBirth;
		this.nowDate = nowDate;
		this.picture = picture;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public JobEnum getJob() {
		return job;
	}

	public void setJob(JobEnum job) {
		this.job = job;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Calendar getNowDate() {
		return nowDate;
	}

	public void setNowDate(Calendar nowDate) {
		this.nowDate = nowDate;
	}

	@Override
	public String toString() {
		return "Person2 [id=" + id + ", name=" + name + ", surname=" + surname
				+ ", age=" + age + ", salary=" + salary + ", job=" + job
				+ ", dateOfBirth=" + dateOfBirth + ", nowDate=" + nowDate
				+ ", picture=" + Arrays.toString(picture) + "]";
	}

}
