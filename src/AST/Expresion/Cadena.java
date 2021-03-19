
package AST.Expresion;

/**
 *
 * @author Solares
 */
public class Cadena extends Terminal{

    public Cadena(Object value) {
        super(value);
    }

    @Override
    public Object Ejecutar() {
        return  (String)this.value;
    }
    
}
