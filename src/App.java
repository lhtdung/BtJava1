import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class App {
	private static String DB_URL = "jdbc:mysql://localhost:3306/dbdemo";
	private static String USER_NAME = "root";
	private static String PASSWORD = "";

	public static void main(String[] args) throws Exception {
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			Statement stmt = null;
            stmt = conn.createStatement();
            String sql1 = "insert into student(full_name,score) values('Dung',23)";
            stmt.executeUpdate(sql1);
            String sql2 = "insert into student(full_name,score) values('Thang',25)";
            stmt.executeUpdate(sql2);
            String sql3 = "update student set full_name='Tai' where id_student=1";
            stmt.executeUpdate(sql3);
            String sql4 = "delete from student where id_student=1";
            stmt.executeUpdate(sql4);
            String sql = "select * from student";
            PreparedStatement pr = conn.prepareStatement(sql);
            ResultSet r1 = pr.executeQuery();
			while(r1.next()) {
				System.out.print(r1.getInt("id_student")+"/");
				System.out.print(r1.getString("full_name")+"/");
				System.out.print(r1.getInt("score")+"\n");
			}
    }
    catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
}