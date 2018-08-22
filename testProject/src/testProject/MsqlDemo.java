package testProject;

import java.sql.*;

public class MsqlDemo {

	public MsqlDemo() {
		// TODO Auto-generated constructor stub
	}
	
	// JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://192.168.04:3306/test";
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "root";
    
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");
        
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM user";
            ResultSet rs = stmt.executeQuery(sql);
            
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("username");
                String url = rs.getString("auth_key");
                String avatar = rs.getString("avatar");
    
                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 用户名: " + name);
                System.out.print(", 认证Key: " + url);
                System.out.print(", 头像: " + avatar);
                System.out.print("\n");
            }
            
            System.out.println("查询完成后，进行一下更新吧");
            
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
            
            // 展开结果集数据库
            while(rs2.next()){
                // 通过字段检索
                int id  = rs2.getInt("id");
                String name = rs2.getString("username");
                String auth_key = rs2.getString("auth_key");
                String avatar = rs2.getString("avatar");
    
                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 用户名: " + name);
                System.out.print(", 认证Key: " + auth_key);
                System.out.print(", 头像: " + avatar);
                System.out.print("\n");
            }
            
            System.out.println("查询完成后，那么结束吧");
            // 完成后关闭
            pstmt.close();
            rs.close();
            rs2.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}
