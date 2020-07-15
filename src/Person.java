import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person implements Comparable<Person>{

	public String name;
	public int age;
	public int point;
	
	public Person(String name, int age, int point) {
		super();
		this.name = name;
		this.age = age;
		this.point = point;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", point=" + point + "]";
	}

	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		if(point<o.point) return -1;
		if(point>o.point) return 1;
		return 0;
		
//		return point -o.point;
	}
	
	public static void main(String[] args) {
		List<Person> pList =new ArrayList<>();
		pList.add(new Person("원영",26,96));
		pList.add(new Person("인혁",29,90));
		pList.add(new Person("백송",24,88));
		pList.add(new Person("경훈",38,100));
		Collections.sort(pList);
		System.out.println(pList);
	}

}
