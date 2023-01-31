package details;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teacher {

	@Id
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String subject;
	@Column(nullable = false)
	private double sal;
	
	public Teacher() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}
	
	
}
