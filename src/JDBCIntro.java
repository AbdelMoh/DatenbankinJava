import java.sql.*;

public class JDBCIntro {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3307/wildau";
        String user = "wildau";
        String password = "wildau";

        try (Connection conn = DriverManager.getConnection(url, user, password))  {
            System.out.println("Verbindung erfolgreich");
            String query = "SELECT * FROM Persons";
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);

            int columns = result.getMetaData().getColumnCount();
            System.out.println("Die Tabelle hat " + columns + " Spalten.");

            while (result.next()) {
                for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
                    System.out.print(result.getString(i) + " ");
                }
                System.out.print("\n");
            }

            result.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
