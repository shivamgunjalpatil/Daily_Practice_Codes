package entity2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Courses {
	
	@Id
	int courseId;
	String courseName;
	
	@ManyToOne
	@JoinColumn(name="trainerId")
	Trainer trainer;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Courses(int courseId, String courseName, Trainer trainer) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.trainer = trainer;
	}

	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Courses [courseId=" + courseId + ", courseName=" + courseName + ", trainer=" + trainer + "]";
	}

}
