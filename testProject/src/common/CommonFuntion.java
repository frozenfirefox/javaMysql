/**
 * 
 */
package common;

/**
 * @author Administrator
 *
 */
public class CommonFuntion {
	private static CommonFuntion instance = new CommonFuntion();
	//���췽��
	private CommonFuntion(){
	}
	
	public static CommonFuntion getInstance(){
		return instance;
	}
	
	/**
	 * �ͻ�ȡ����
	 * @param age
	 * @return
	 */
	public Integer getAge(int age){
		return age;
	}
	
	/**
	 * ��ȡ����
	 * @param name
	 * @return
	 */
	public String getName(String name){
		return name;
	}
}