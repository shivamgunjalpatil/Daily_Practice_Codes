package entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Roles {
	
	@Id
	int rollId;
	String name;
	
	@ManyToMany(mappedBy = "roles",cascade = CascadeType.ALL)
	List<User> users;

	public int getRollId() {
		return rollId;
	}

	public void setRollId(int rollId) {
		this.rollId = rollId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Roles(int rollId, String name, List<User> users) {
		super();
		this.rollId = rollId;
		this.name = name;
		this.users = users;
	}

	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Roles [rollId=" + rollId + ", name=" + name + ", users=" + users + "]";
	}
	
	
}
