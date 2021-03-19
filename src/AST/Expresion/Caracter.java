
package AST.Expresion;

/**
 *
 * @author Solares
 */
public class Caracter extends Terminal{

    public Caracter(Object value) {
        super(value);
    }

    @Override
    public Object Ejecutar() {
        return ((String)this.value).charAt(0);
    }
    
}
