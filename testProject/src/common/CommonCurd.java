/**
 * 增删改查类驱动
 */
package common;

import java.util.ArrayList;
/**
 * @author Administrator
 *
 */
public class CommonCurd {

	/**
	 * 构造函数
	 */
	public CommonCurd() {
		// TODO Auto-generated constructor stub
	}
		
	/**
	 * 添加函数
	 * @param data
	 * @return
	 */
	public Boolean add(int[] data){
		return true;
	}
	
	/**
	 * 查询函数
	 * @param where
	 * @param field
	 * @return
	 */
	public ArrayList<Object> select(ArrayList<Object> where, String field){
		return new ArrayList<Object>();
	}
	
	/**
	 * 更新函数
	 * @param where
	 * @param data
	 * @return
	 */
	public Boolean update(ArrayList<Object> where, ArrayList<Object> data){
		return true;
	}
	
	/**
	 * 删除函数
	 * @param where
	 * @return
	 */
	public Boolean delete(ArrayList<Object> where){
		return true;
	}
}
