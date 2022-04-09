package com.seleniumexpress.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "students")
@NamedQuery(name = "allstudents", query = "from Student")
@NamedQuery(name = "allstudents.age", query = "from Student where age =:AGE")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // value type

	@Column(name = "name", length = 70, nullable = false)
	private String name;

	@Column(name = "contact_no", length = 15)
	private long mobileNo;

	@Column(name = "age", length = 45, nullable = false)
	private int age;

	@Column(name = "country", length = 45, nullable = false)
	private String country;

	@OrderColumn // this order maintains the order of nicknames in a new col called varName_ORDER
	@ElementCollection
	@CollectionTable(name = "nick_names", joinColumns = @JoinColumn(name = "stud_id"))
	@Column(name = "nick_name")
	@MapKey(name = "nameType")  // Used when inserting key-value pair , but here we are using set instead of map
								// therefore it will not work here
	private Set<String> nickNames = new HashSet<String>();

	@ElementCollection
	@CollectionTable(name = "student_address", joinColumns = { @JoinColumn(name = "stud_id") })
	@AttributeOverrides({ @AttributeOverride(name = "country", column = @Column(name = "student_country")) })
	@Embedded
	private List<Address> addresses = new ArrayList<Address>();

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<String> getNickNames() {
		return nickNames;
	}

	public void setNickNames(Set<String> nickNames) {
		this.nickNames = nickNames;
	}

	public int getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void addNickName(String name) {

		if (nickNames == null) {
			nickNames = new HashSet<String>();
		}
		nickNames.add(name);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mobileNo=" + mobileNo + ", age=" + age + ", country="
				+ country + "]";
	}

}
