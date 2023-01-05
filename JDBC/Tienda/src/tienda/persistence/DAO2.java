
package tienda.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO2 {
    
    protected Connection cnt = null;
    protected ResultSet rs = null;
    protected Statement stmt = null;
    
    private final String USER = "root";
    private final String PASS = "root";
    private final String DB = "estancia";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    
    protected void connectDB() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DRIVER);
            String urlDB = "jdbc:mysql://localhost:3306/" + DB + "?useSSL=false";
            cnt = DriverManager.getConnection(urlDB, USER, PASS);
        }
        catch(ClassNotFoundException | SQLException e) {throw e;}
    }
    
    protected void disconnectDB() throws SQLException {
        try {
            if(rs != null) {rs.close();}
            if(stmt != null) {stmt.close();}
            if(cnt != null) {cnt.close();}
        }
        catch(SQLException e) {throw e;}   
    }
    
    protected void IME(String sql) throws ClassNotFoundException, SQLException {
        try {
            connectDB();
            stmt = cnt.createStatement();
            rs = stmt.executeQuery(sql);
        }
        catch(ClassNotFoundException | SQLException e) {
            cnt.rollback();
            throw e;
        }
        finally {disconnectDB();}
    } 
    
    protected void consultDB(String sql) throws ClassNotFoundException, SQLException {
        try {
            connectDB();
            stmt = cnt.createStatement();
            stmt.executeQuery(sql);
        }
        catch(ClassNotFoundException | SQLException e) {throw e;}
    }
    
}
