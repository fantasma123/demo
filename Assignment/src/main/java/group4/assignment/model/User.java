package group4.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="USER1")
public class User {
	@Id
	@Column(name="ID")
	private String id;
	@Column(name="GROUP_ID")
	private String groupID;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="PW")
	private String passWord;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGroupID() {
		return groupID;
	}
	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public User(String id, String groupID, String firstName, String lastName, String passWord) {
		super();
		this.id = id;
		this.groupID = groupID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.passWord = passWord;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
