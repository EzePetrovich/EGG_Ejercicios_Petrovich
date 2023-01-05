
package tienda.persistence;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DAO {
    
    protected Connection cnt = null;
    protected ResultSet rs = null;
    protected Statement stmt = null;
    
    private final String USER = "root";
    private final String PASS = "root";
    private final String DATABASE = "tienda";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    
    protected void connectDB() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DRIVER);
            String urlDB = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
            cnt = DriverManager.getConnection(urlDB, USER, PASS);
        }
        catch(ClassNotFoundException | SQLException excConn) {throw excConn;}
    }
    
    protected void disconnectDB() throws SQLException {
        try {
            if(rs != null) {rs.close();}
            if(stmt != null) {stmt.close();}
            if(cnt != null) {cnt.close();}
        }
        catch(SQLException excDis) {throw excDis;}
    }
    
    // IME: Insertar, modificar y eliminar
    
    protected void IME(String sql) throws ClassNotFoundException, SQLException {
        try {
            connectDB();
            stmt = cnt.createStatement();
            stmt.executeUpdate(sql);
        }
        catch(ClassNotFoundException | SQLException excIME) {
            cnt.rollback();
            throw excIME;
        }
        finally {disconnectDB();}
    }
    
    protected void consultDB(String sql) throws ClassNotFoundException, SQLException {
        try {
            connectDB();
            stmt = cnt.createStatement();
            rs = stmt.executeQuery(sql);
        }
        catch(ClassNotFoundException | SQLException excCons) {throw excCons;}
    }
    
}
