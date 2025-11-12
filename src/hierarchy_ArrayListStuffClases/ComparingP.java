package hierarchy_ArrayListStuffClases;

public class ComparingP implements Comparable<ComparingP> {
	private String dept;
	private String nameP;
	private int num;

	public ComparingP() {
		this.dept = "";
		this.nameP = "";
		this.num = 0;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getNameP() {
		return nameP;
	}

	public void setNameP(String nameP) {
		this.nameP = nameP;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public int compareTo(ComparingP p) {
		int diff;
		diff = p.getNum() - num;
		if (diff == 0) {
			diff = nameP.compareToIgnoreCase(p.getNameP());
		}

		return diff;
	}
}
