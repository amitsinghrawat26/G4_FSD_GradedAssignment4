package com.greatlearning.EmployeeManagementApplicationSecurity.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
	
	@Id
<<<<<<< HEAD
	@GeneratedValue(strategy= GenerationType.IDENTITY)
=======
	@GeneratedValue(strategy = GenerationType.IDENTITY)
>>>>>>> master
	@Column(name="role_id")
	private int id;
	
	@Column(name="role_name")
<<<<<<< HEAD
	private String name;

	
=======
	private String roleName;

>>>>>>> master
	public Role() {
		super();
	}

<<<<<<< HEAD
	public Role(int id, String name) {
		super();
		this.id = id;
		this.name = name;
=======
	public Role(int id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
>>>>>>> master
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

<<<<<<< HEAD
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
=======
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
>>>>>>> master
}
