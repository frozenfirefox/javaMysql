/**
 * 
 */
package testProject;
import common.CommonFuntion;
import common.CommonCurd;

/**
 * @author Administrator
 *
 */
public class MainClass {
	
	private static CommonFuntion common = CommonFuntion.getInstance();
	private static CommonCurd curd = new CommonCurd();
	/**
	 * 
	 */
	public MainClass() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("You are stupid!!!!");
		Integer age = common.getAge(20);
		System.out.println(age);
		String name = common.getName("Alpha");
		System.out.println(name);
		int[] data = {1,2,3,4};
		Boolean addre = curd.add(data);
		System.out.println(addre);
	}

}
