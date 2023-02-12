package entities;

public class Student {

	public String name;
	public double grade1;
	public double grade2;
	public double grade3;

	public double finalGrade() {
		return this.grade1 + this.grade2 + this.grade3;
	}

	public String approvedOrNot() {
		if (this.finalGrade() >= 60.00) {
			return "PASS";
		}
		else
			return "FAILED\n" + String.format("MISSING %.2f ", 60 - this.finalGrade()) + "POINTS";
	}

}
