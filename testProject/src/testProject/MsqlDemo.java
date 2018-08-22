package testProject;

import java.sql.*;

public class MsqlDemo {

	public MsqlDemo() {
		// TODO Auto-generated constructor stub
	}
	
	// JDBC �����������ݿ� URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://192.168.04:3306/test";
 
    // ���ݿ���û��������룬��Ҫ�����Լ�������
    static final String USER = "root";
    static final String PASS = "root";
    
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // ע�� JDBC ����
            Class.forName("com.mysql.jdbc.Driver");
        
            // ������
            System.out.println("�������ݿ�...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // ִ�в�ѯ
            System.out.println(" ʵ����Statement����...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM user";
            ResultSet rs = stmt.executeQuery(sql);
            
            // չ����������ݿ�
            while(rs.next()){
                // ͨ���ֶμ���
                int id  = rs.getInt("id");
                String name = rs.getString("username");
                String url = rs.getString("auth_key");
                String avatar = rs.getString("avatar");
    
                // �������
                System.out.print("ID: " + id);
                System.out.print(", �û���: " + name);
                System.out.print(", ��֤Key: " + url);
                System.out.print(", ͷ��: " + avatar);
                System.out.print("\n");
            }
            
            System.out.println("��ѯ��ɺ󣬽���һ�¸��°�");
            
            String sql2 = "update user set avatar = ? where id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql2);
            int i = 1;
            while(i < 4){
            	pstmt.setInt(2, i);
                pstmt.setString(1, i + ".jpg");
                pstmt.executeUpdate();
                i++;
            }
            
            sql2 = "SELECT * FROM user";
            ResultSet rs2 = stmt.executeQuery(sql2);
            
            // չ����������ݿ�
            while(rs2.next()){
                // ͨ���ֶμ���
                int id  = rs2.getInt("id");
                String name = rs2.getString("username");
                String auth_key = rs2.getString("auth_key");
                String avatar = rs2.getString("avatar");
    
                // �������
                System.out.print("ID: " + id);
                System.out.print(", �û���: " + name);
                System.out.print(", ��֤Key: " + auth_key);
                System.out.print(", ͷ��: " + avatar);
                System.out.print("\n");
            }
            
            System.out.println("��ѯ��ɺ���ô������");
            // ��ɺ�ر�
            pstmt.close();
            rs.close();
            rs2.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
        }catch(Exception e){
            // ���� Class.forName ����
            e.printStackTrace();
        }finally{
            // �ر���Դ
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// ʲô������
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}
