import com.mysql.cj.protocol.Resultset;
import java.sql.Statement;
import java.sql.Connection;

import java.net.ConnectException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Baglanti {
    Connection myConn;
    Statement MyStat;
     ResultSet yap(String table_name){
        ResultSet myRs=null;
        try {
             myConn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mzkktm_db","root","123456");
             MyStat=(Statement) myConn.createStatement();
             myRs= MyStat.executeQuery("select * from "+table_name);
           
        } catch (Exception e) {
        e.printStackTrace();
        }
       return myRs;
    }
     void ekle(String sqlsorgu){
        try {
            MyStat.executeUpdate(sqlsorgu);
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     void guncelle(String sqlsorgu){

        try {
            MyStat.executeUpdate(sqlsorgu);
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     void sil(String Sqlsorgu) throws SQLException{
     // DELETE (özel bir yer silmek isteniyosa o değilse tüm satırsa boş) FROM WHERE koşul
     MyStat.executeUpdate(Sqlsorgu);
     }
      ResultSet ara(String sql_sorgu){
    ResultSet myRs=null;
        try {
            myRs=MyStat.executeQuery(sql_sorgu);
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return myRs;
     }
    
}
