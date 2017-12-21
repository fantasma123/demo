package group4.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GROUP1")
public class Group {

	@Id
	@Column(name="ID")
	private String id;
	@Column(name="GROUP_NAME")
	private String groupName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Group(String id, String groupName) {
		super();
		this.id = id;
		this.groupName = groupName;
	}
	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
