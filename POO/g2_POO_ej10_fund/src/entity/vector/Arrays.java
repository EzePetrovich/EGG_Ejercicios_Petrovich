
package entity.vector;

public class Arrays {
    public double [] arr_A = new double[50];
    public double [] arr_B = new double[20];
    
    public Arrays() {
    }
    
    public Arrays(double [] arr_A, double [] arr_B) {
        this.arr_A = arr_A;
        this.arr_B = arr_B;
    }
    
    public void setArrA(double [] arr_A) {
        this.arr_A = arr_A;
    }
    
    public double [] getArrA() {
        return arr_A;
    }
    
    public void setArrB(double [] arr_B) {
        this.arr_B = arr_B;
    }
    
    public double [] getArrB() {
        return arr_B;
    }    
}
