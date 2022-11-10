
import java.sql.* ;

public class Mysql {
    //private static  String host = "localhost" ;
    //private static  String port = "3306" ;
    //private static  String database = "wildau" ;


    private static Connection con ;

    private static boolean isConnected() {

        return(con != null);

    }
    public static void connect() throws ClassNotFoundException{
        String url = "jdbc:mysql://localhost:3306/wildau";
        String user = "wildau" ;
        String password = "1234" ;
        if(!isConnected()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url,user,password);
                System.out.println("mysql verbunden");
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }

    }
    public static void disconnect() {
        if(isConnected()) {
            try {
                con.close();
                System.out.println("Verbindung geschlossen");
            } catch (SQLException e) {

                e.printStackTrace();
            }

        }

    }

    public static void update(String query) {

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.execute();
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }
    public static void print(String query) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet result = stmt.executeQuery(query);

        int columns = result.getMetaData().getColumnCount();
        System.out.println("Die Tabelle hat " + columns + " Spalten.");

        while (result.next()) {
            for (int i = 1; i <= columns; i++) {
                System.out.print(result.getString(i) + " ");
            }
            System.out.println("");
        }

        result.close();
        stmt.close();
    }

}
