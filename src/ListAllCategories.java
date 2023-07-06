import java.sql.ResultSet;
import java.sql.Statement;

public class ListAllCategories {
    public static void main(String[] args) {
        ConnectDB conn = new ConnectDB();
        try(var connection = conn.connect()){
            try(Statement stmt = connection.createStatement()){
                String sql = "SELECT * FROM categories";
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getInt("status"));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
