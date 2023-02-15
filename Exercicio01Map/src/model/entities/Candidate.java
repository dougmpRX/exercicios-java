package model.entities;

import java.util.Objects;

public class Candidate {
	
	private String name;
	private Integer score;
	
	public Candidate(String name, Integer score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
	
	public Integer getTotals(Integer votes) {
		return score += votes;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidate other = (Candidate) obj;
		return Objects.equals(name, other.name);
	}
	
}
