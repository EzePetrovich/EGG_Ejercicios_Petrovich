
package tienda.dominio.fabricante;

import tienda.persistence.FabricanteDAO;
import tienda.utilites.Tools;

public final class FabricanteService implements Tools {
    
    private FabricanteDAO dao;
    
    public FabricanteService() {dao = new FabricanteDAO();}
    
    public void addFabricanteBDD() throws Exception {
        try {
                Fabricante fabricante = new Fabricante();
                System.out.println("FABRICANTE\n");
                System.out.print("» Nombre de fabricante: ");
                fabricante.setNombre(read.next());
                if(dao.searchFabricante(fabricante.getNombre()) != null) {throw new Exception("ERROR: el fabricante ya existe.");}
                dao.saveFabricante(fabricante);
            } catch(Exception e) {throw e;}
    }
    
    public void removeFabricante() throws Exception {
        try {
            System.out.print("» Ingrese el codigo de fabricante a remover: ");
            int cod_fab = read.nextInt();
            dao.deleteFabricante(cod_fab);
        } catch(Exception e) {throw e;}
    }
    
}

