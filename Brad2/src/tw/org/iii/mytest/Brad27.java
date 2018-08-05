package tw.org.iii.mytest;

public class Brad27 {
	public static void main(String[] args) {
		int a = 10;
		System.out.println(a);
		String str1 = new String("Brad");
		System.out.println(str1);
		Brad271 obj1 = new Brad271();
		System.out.println(obj1);
		Brad271 obj2 = new Brad271();
		System.out.println(obj2);
		System.out.println(obj1 == obj2);
		System.out.println(obj1.equals(obj2));
	}
}
class Brad271 {
	@Override
	public String toString() {
		return "Brad";
	}
}
