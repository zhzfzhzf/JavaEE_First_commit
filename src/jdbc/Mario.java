package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mario {
	private String url = "jdbc:mysql://localhost:3306/javaeefirst?useUnicode=true&characterEncoding=utf-8";
	private String driver = "com.mysql.jdbc.Driver";
    private String username = "root";
    private String password = "4835036";
    private Connection conn = null;
    private Statement statement = null;

    public Mario()
    {
        try
        {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            statement = conn.createStatement();
        } 
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("数据连接失败");
        } 
        
    }
    
  //查询
    public ResultSet executeQuery(String s) {
        ResultSet rs = null;
        System.out.print("--执行语句:"+s+"\n");
        try {
            rs = statement.executeQuery(s);
        } catch (Exception ex) {
            System.out.println("ִ查询发生错误");
        }
        return rs;
    }
    
    //修改
    public int executeUpdate(String s) {
        int a = 0 ;
        System.out.print("--执行语句:"+s+"\n");
        try {
            a = statement.executeUpdate(s);
        } catch (Exception ex) {
            System.out.println("ִ修改发生错误");
        }
        return a;
    }
    //关闭数据库连�?
  	public void closeConnection () {
  		if(conn!=null) {
  			try {
  				conn.close();
  			} catch (SQLException e) {
  				e.printStackTrace();
  			}
  		}
  	}
}
