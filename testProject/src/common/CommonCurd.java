/**
 * ��ɾ�Ĳ�������
 */
package common;

import java.util.ArrayList;
/**
 * @author Administrator
 *
 */
public class CommonCurd {

	/**
	 * ���캯��
	 */
	public CommonCurd() {
		// TODO Auto-generated constructor stub
	}
		
	/**
	 * ���Ӻ���
	 * @param data
	 * @return
	 */
	public Boolean add(int[] data){
		return true;
	}
	
	/**
	 * ��ѯ����
	 * @param where
	 * @param field
	 * @return
	 */
	public ArrayList<Object> select(ArrayList<Object> where, String field){
		return new ArrayList<Object>();
	}
	
	/**
	 * ���º���
	 * @param where
	 * @param data
	 * @return
	 */
	public Boolean update(ArrayList<Object> where, ArrayList<Object> data){
		return true;
	}
	
	/**
	 * ɾ������
	 * @param where
	 * @return
	 */
	public Boolean delete(ArrayList<Object> where){
		return true;
	}
}