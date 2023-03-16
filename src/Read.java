import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @brief Read
 * 
 * @author zeonghun
 * @since 230316
 */
public class Read {
    public void read() {
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
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM user");
            // Query 실행
            ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                System.out.println(String.format("ID: %s, PASSWORD: %s", rs.getString("id"), rs.getString("password")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
