
package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cuota {
    
    // Attributes
    
    private int n_cuota;
    private double mont_cuota;
    private boolean pagada;
    private Date fecha_venc;
    private String form_pag;
    
    // Constructors
    
    public Cuota() {}
    
    public Cuota(int n_cuota, double mont_cuota, boolean pagada, Date fecha_venc, String form_pag) {
        this.n_cuota = n_cuota;
        this.mont_cuota = mont_cuota;
        this.pagada = pagada;
        this.fecha_venc = fecha_venc;
        this.form_pag = form_pag;
    }
    
    // Getters
    
    public int getNCuota() {return n_cuota;}
    public double getMontCuota() {return mont_cuota;}
    public boolean getPagada() {return pagada;}
    public Date getFechaVenc() {return fecha_venc;}
    public String getFormPag() {return form_pag;}
    
    // Setters
    
    public void setNCuota(int n_cuota) {this.n_cuota = n_cuota;}
    public void setMontCuota(double mont_cuota) {this.mont_cuota = mont_cuota;}
    public void setPagada(boolean pagada) {this.pagada = pagada;}
    public void setFechaVenc(Date fecha_venc) {this.fecha_venc = fecha_venc;}
    public void setFormPag(String form_pag) {this.form_pag = form_pag;}
    
    // toString()
    
    @Override
    public String toString() {
        String fechaFormat = new SimpleDateFormat("dd/MM/yyyy").format(fecha_venc), pago;
        if(pagada) {pago = "Si";} else {pago = "No";}
        return "• Nº Cuota: " + n_cuota + "\n· Monto: $" + mont_cuota + "\n· Pagada: " + pago + "\n· Fecha de vencimiento: " + fechaFormat + "\n· Forma de pago: " + form_pag;
    }
}
