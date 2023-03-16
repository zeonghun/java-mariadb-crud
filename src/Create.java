import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @brief Insert
 * 
 * @author zeonghun
 * @since 230316
 */
public class Create {
    public void insert() {
        Scanner sc = new Scanner(System.in);
        try {
            // Load JDBC Class
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
            // Connection 정보 설정 "jdbc:mysql://{Host 정보}/{DB Name}", "{ID}", "{PWD}"
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc_test", "root", "1234");
            // 실행할 Query 설정
            PreparedStatement stmt = con.prepareStatement("INSERT INTO user(id, password) VALUES(?, ?)");) {
            System.out.print("추가할 아이디: ");
            String id = sc.next();
            System.out.print("추가할 패스워드: ");
            String pwd = sc.next();
            // parameter 설정
            stmt.setString(1, id);
            stmt.setString(2, pwd);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
