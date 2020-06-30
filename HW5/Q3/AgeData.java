
public class AgeData implements Comparable<AgeData>{
	private int age;
	protected int numOfPeople;
	
	public AgeData(int Age) {
		age = Age;
		numOfPeople = 1;
	}
	
	public int getAge() {
		return age;
	}

	@Override
	public int compareTo(AgeData o) {
		if(o.age == age) {
			return 0;
		}else if(o.age > age){
			return -1;
		}else return 1;
	}
	
	@Override
	public String toString() {
		return age + " - " + numOfPeople + "\n"; 
	}
}
