import java.util.ArrayList;
import java.util.List;

public class Test {
	
	List<String> value = new ArrayList<String>();
	
	public List<String> test1()
	{
		value.add("one");
		value.add("two");
		return value;
	}
	
	public static void main(String[] args) {
		
		Test obj = new Test();
		System.out.println((obj.test1()).get(0));
	}

}
