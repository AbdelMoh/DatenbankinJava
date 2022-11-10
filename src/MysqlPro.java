
import java.sql.*;


public class MysqlPro {


    private static Connection conn ;

    public static boolean isconnected(){

        return (conn != null); //(if conn == null ? false : true) ;

    }
    public static void connect() throws ClassNotFoundException, SQLException {
        //jdbc:mysql://localhost:3306/wildau
        String url = "jdbc:mysql://localhost:3306/wildau";
        String username = "root";
        String password = "";
        if(!isconnected()){
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
            System.out.println("verbunden!");
        }
    }
    public static void disconnect() throws SQLException {

        if(isconnected()){
            conn.close();
            System.out.println("Verbindung ist geschlossen");
        }
    }
    public static void update(String query) throws SQLException {

        PreparedStatement ps = conn.prepareStatement(query);
        ps.execute();

    }

    public static void printdb(String query) throws SQLException {

        Statement  statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        int columns = resultSet.getMetaData().getColumnCount();
        System.out.println("die Tabelle besteht aus " + columns +"Spalten");

        while (resultSet.next()){
            System.out.println("{");
            for(int i = 1 ; i <=columns;i++){
                System.out.println(resultSet.getMetaData().getColumnLabel(i)+":"+resultSet.getString(i)+" ");
            }
            System.out.println("}");
        }
        statement.close();
        resultSet.close();
    }
    public static Person[] saveInArray(String query) throws SQLException,NullPointerException {

        Statement  statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        int columns = resultSet.getMetaData().getColumnCount();
        resultSet.next();
        int rows = resultSet.getInt(1);


        Person [] liste = new Person[rows+1];
        for (int i = 0; i < rows+1 ; i++) {
            liste[i] = new Person();
        }

      while(resultSet.next()) {
          for (int j = 0; j <rows+1; j++) {
              liste[j].setPersonId(resultSet.getInt(1));
              liste[j].setFirstName(resultSet.getString(2));
              liste[j].setLastName(resultSet.getString(3));
          }
      }
        statement.close();
        resultSet.close();
        return liste;
    }
}
