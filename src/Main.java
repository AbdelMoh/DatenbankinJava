import java.sql.* ;
public class Main {


        public static void main(String[] args) throws ClassNotFoundException, SQLException {

            MysqlPro.connect();
            //MysqlPro.update("insert into persons values(1,'Abdul','Alkarbu');");

            Person [] liste = MysqlPro.saveInArray("select * from persons");
            MysqlPro.printdb("select * from persons");

            /*for (int i = 0; i < liste.length ; i++) {
                liste[i].printPerson();
            }*/
            MysqlPro.disconnect();

        }//end class
}
