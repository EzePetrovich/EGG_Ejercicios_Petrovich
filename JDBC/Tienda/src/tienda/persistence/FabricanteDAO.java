
package tienda.persistence;

import java.util.ArrayList;
import java.util.Collection;
import tienda.dominio.fabricante.Fabricante;

public final class FabricanteDAO extends DAO {
    
    public void saveFabricante(Fabricante fabricante) throws Exception {   
        try {
            if(fabricante == null) {throw new Exception("ERROR: debe indicar el fabricante.");}
            String sql = "INSERT INTO fabricante(nombre)"
                    + "VALUES ('" + fabricante.getNombre() + "');";
            IME(sql);
        }
        catch(Exception e) {throw e;}   
    }
    
    public void modifyFabricante(Fabricante fabricante) throws Exception {   
        try {
            if(fabricante == null) {throw new Exception("ERROR: debe indicar el fabricante.");}
            String sql = "UPDATE fabricante SET"
                    + "nombre = '" + fabricante.getNombre() + "'"
                    + "WHERE codigo = " + fabricante.getCodFab() + ";";
            IME(sql);
        }
        catch(Exception e) {throw e;}   
    }
    
    public void deleteFabricante(int cod_fab) throws Exception {   
        try {
            String sql = "DELETE FROM fabricante WHERE codigo = " + cod_fab + ";";
            String sql2 = "ALTER TABLE fabricante AUTO_INCREMENT = 1;";
            IME(sql);
            IME(sql2);
        }
        catch(Exception e) {throw e;}   
    }
    
    public Fabricante searchFabricante(String nombre) throws Exception {
        try {
            String sql = "SELECT * FROM fabricante "
                    + "WHERE nombre = '" + nombre + "';";
            consultDB(sql);
            Fabricante fabricante = null;
            while(rs.next()) {
                fabricante = new Fabricante();
                fabricante.setCodFab(rs.getInt(1));
                fabricante.setNombre(rs.getString(2));
            }
            disconnectDB();
            return fabricante;
        }
        catch(Exception e) {throw e;}
    }
    
    public Collection<Fabricante> listFabricantes() throws Exception {
        try {
            String sql = "SELECT codigo, nombre FROM fabricante;";
            consultDB(sql);
            Fabricante fabricante = null;
            Collection<Fabricante> fabricantes = new ArrayList();
            while(rs.next()) {
                fabricante = new Fabricante();
                fabricante.setCodFab(rs.getInt(1));
                fabricante.setNombre(rs.getString(2));
                fabricantes.add(fabricante);
            }
            
            disconnectDB();
            return fabricantes;
        }
        catch(Exception e) {
            e.printStackTrace();
            disconnectDB();
            throw new Exception("Error de sistema.");
        }
    }
    
}
