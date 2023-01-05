
package tienda.persistence;

import java.util.ArrayList;
import java.util.Collection;
import tienda.dominio.producto.Producto;

public final class ProductoDAO extends DAO {
    
    // Guardar en BDD
    
    public void saveProduct(Producto product) throws Exception {   
        try {
            if(product == null) {throw new Exception("ERROR: debe indicar el producto.");}
            String sql = "INSERT INTO producto(codigo, nombre, precio, codigo_fabricante)"
                    + " VALUES (" + product.getCodProd() + ", '" + product.getNombre() + "', " + product.getPrecio() + ", " + product.getCodFab() + ");";
            IME(sql);
        }
        catch(Exception e) {throw e;}   
    }
    
    // Modificar tupla en BDD
    
    public void modifyProduct(Producto product) throws Exception {   
        try {
            if(product == null) {throw new Exception("ERROR: debe indicar el producto.");}
            String sql = "UPDATE producto SET nombre = '" + product.getNombre() + "', precio = " + product.getPrecio() + ", codigo_fabricante = " + product.getCodFab() + 
                    " WHERE codigo = " + product.getCodProd() + ";";
            IME(sql);
        }
        catch(Exception e) {throw e;}   
    }
    
    public void modifyName(String nombre, int cod_prod) throws Exception {   
        try {
            String sql = "UPDATE producto SET nombre = '" + nombre + "'" +
                    " WHERE codigo = " + cod_prod + ";";
            IME(sql);
        }
        catch(Exception e) {throw e;}   
    }
    
     public void modifyPrice(double price, int cod_prod) throws Exception {   
        try {
            String sql = "UPDATE producto SET precio = " + price + 
                    " WHERE codigo = " + cod_prod + ";";
            IME(sql);
        }
        catch(Exception e) {throw e;}   
    }
    
    public void modifyCodFab(int cod_fab, int cod_prod) throws Exception {   
        try {
            String sql = "UPDATE producto SET codigo_fabricante = " + cod_fab + 
                    " WHERE codigo = " + cod_prod + ";";
            IME(sql);
        }
        catch(Exception e) {throw e;}   
    }
    
    // Eliminar tupla de BDD
    
    public void deleteProduct(int cod_prod) throws Exception {   
        try {
            String sql = "DELETE FROM producto WHERE codigo = " + cod_prod + ";";
            String sql2 = "ALTER TABLE producto AUTO_INCREMENT = 1;";
            IME(sql);
            IME(sql2);
        }
        catch(Exception e) {throw e;}   
    }
    
    // Buscar una tupla
    
    public Producto searchProductByName(String nombre) throws Exception {
        try {
            String sql = "SELECT * FROM producto"
                    + " WHERE nombre = '" + nombre + "';";
            consultDB(sql);
            Producto product = null;
            while(rs.next()) {
                product = new Producto();
                product.setCodProd(rs.getInt(1));
                product.setNombre(rs.getString(2));
                product.setPrecio(rs.getDouble(3));
                product.setCodFab(rs.getInt(4));
            }
            disconnectDB();
            return product;
        }
        catch(Exception e) {throw e;}
    }
    
    public Producto searchProductByCod(int cod_prod) throws Exception {
        try {
            String sql = "SELECT * FROM producto"
                    + " WHERE codigo = " + cod_prod + ";";
            consultDB(sql);
            Producto product = null;
            while(rs.next()) {
                product = new Producto();
                product.setCodProd(rs.getInt(1));
                product.setNombre(rs.getString(2));
                product.setPrecio(rs.getDouble(3));
                product.setCodFab(rs.getInt(4));
            }
            disconnectDB();
            return product;
        }
        catch(Exception e) {throw e;}
    }
    
    public Producto searchProductLowPrice() throws Exception {
        try {
            String sql = "SELECT * FROM producto"
                    + " WHERE precio = (SELECT MIN(precio) FROM producto);";
            consultDB(sql);
            Producto product = null;
            while(rs.next()) {
                product = new Producto();
                product.setCodProd(rs.getInt(1));
                product.setNombre(rs.getString(2));
                product.setPrecio(rs.getDouble(3));
                product.setCodFab(rs.getInt(4));
            }
            disconnectDB();
            return product;
        }
        catch(Exception e) {throw e;}
    }
    
    // Obtener tuplas en una colección
    
    public Collection<Producto> portatilesDisp() throws Exception {
        try {
            String sql = "SELECT * FROM producto "
                    + "WHERE nombre LIKE '%Portátil%';";
            consultDB(sql);
            Producto product = null;
            Collection<Producto> products = new ArrayList();
            while(rs.next()) {
                product = new Producto();
                product.setCodProd(rs.getInt(1));
                product.setNombre(rs.getString(2));
                product.setPrecio(rs.getDouble(3));
                product.setCodFab(rs.getInt(4));
                products.add(product);
            }
            disconnectDB();
            return products;
        }
        catch(Exception e) {throw e;}
    }
    
    public Collection<Producto> listProductsName() throws Exception {
        try {
            String sql = "SELECT nombre FROM producto;";
            consultDB(sql);
            Producto product = null;
            Collection<Producto> products = new ArrayList();
            while(rs.next()) {
                product = new Producto();
                product.setNombre(rs.getString(1));
                products.add(product);
            }
            disconnectDB();
            return products;
        }
        catch(Exception e) {
            e.printStackTrace();
            disconnectDB();
            throw new Exception("Error de sistema.");
        }
    }
    
    public Collection<Producto> listProductsNamePrice() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto;";
            consultDB(sql);
            Producto product = null;
            Collection<Producto> products = new ArrayList();
            while(rs.next()) {
                product = new Producto();
                product.setNombre(rs.getString(1));
                product.setPrecio(rs.getDouble(2));
                products.add(product);
            }
            disconnectDB();
            return products;
        }
        catch(Exception e) {
            e.printStackTrace();
            disconnectDB();
            throw new Exception("Error de sistema.");
        }
    }
    
    public Collection<Producto> listProductsPriceBetween() throws Exception {
        try {
            String sql = "SELECT * FROM producto "
                    + "WHERE precio BETWEEN 120 AND 202;";
            consultDB(sql);
            Producto product = null;
            Collection<Producto> products = new ArrayList();
            while(rs.next()) {
                product = new Producto();
                product.setCodProd(rs.getInt(1));
                product.setNombre(rs.getString(2));
                product.setPrecio(rs.getDouble(3));
                product.setCodFab(rs.getInt(4));
                products.add(product);
            }
            disconnectDB();
            return products;
        }
        catch(Exception e) {
            e.printStackTrace();
            disconnectDB();
            throw new Exception("Error de sistema.");
        }
    }
    
}
