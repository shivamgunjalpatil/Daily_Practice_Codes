package entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Quation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int q_id;
	String quation;
	@OneToOne(cascade = CascadeType.ALL)
	Answer ans;
	
	public int getQ_id() {
		return q_id;
	}
	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}
	public String getQuation() {
		return quation;
	}
	public void setQuation(String quation) {
		this.quation = quation;
	}
	public Answer getAns() {
		return ans;
	}
	public void setAns(Answer ans) {
		this.ans = ans;
	}
	public Quation(int q_id, String quation, Answer ans) {
		super();
		this.q_id = q_id;
		this.quation = quation;
		this.ans = ans;
	}
	public Quation() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Quation [q_id=" + q_id + ", quation=" + quation + ", ans=" + ans + "]";
	}
	
}
