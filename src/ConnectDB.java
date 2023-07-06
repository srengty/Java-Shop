import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectDB {
    Connection conn = null;
    public Connection connect(){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:db/java-shop.db");
            System.out.println("Connected to database");
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
    public static void main(String[] args) {
        System.out.println("Connecting to DB...");
        ConnectDB conn = new ConnectDB();
        try(var connection = conn.connect();){
            try(Statement stmt = connection.createStatement()){
                String sql = "CREATE TABLE IF NOT EXISTS categories (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	status INTEGER\n"
                + ");";
                stmt.execute(sql);
                System.out.println("Categories table created");

                sql = "CREATE TABLE IF NOT EXISTS products (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	price REAL,\n"
                + "	category_id INTEGER);";
                stmt.execute(sql);
                System.out.println("Products table created");
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
