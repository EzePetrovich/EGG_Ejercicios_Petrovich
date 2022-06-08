/*numeroCuenta (entero), el DNI del cliente (entero largo) y el saldo actual (entero).*/

package Entity.Banco;

public class Cuenta {
    private int numCuenta;
    private long DNI_Cli;
    private int saldo;
    private int interes;
    public Cuenta() {
    }
    public Cuenta(int numCuenta, long DNI_Cli, int saldo, int interes) {
        this.numCuenta = numCuenta;
        this.DNI_Cli = DNI_Cli;
        this.saldo = saldo;
        this.interes = interes;
    }
    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }
    public int getNumCuenta() {
        return numCuenta;
    }
    public void setDNI(long DNI) {
        this.DNI_Cli = DNI;
    }
    public long getDNI() {
        return DNI_Cli;
    }
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    public int getSaldo() {
        return saldo;
    }
    public void setInteres(int interes) {
        this.interes = interes;
    }
    public int getInteres() {
        return interes;
    }
}
