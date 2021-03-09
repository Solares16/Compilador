
package AST;

/**
 *
 * @author Solares
 */
public class Decimal extends Aritmetica{
    
    private double value;

    public Decimal(double value) {
        this.value = value;
    }

    @Override
    public Object Ejecutar() {
        return this.value;
    }
    
    
}
