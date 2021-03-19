package AST.Expresion;

/**
 *
 * @author Solares
 */
public class Numerico extends Terminal{

    public Numerico(Object value) {
        super(value);
    }    
    
    @Override
    public Object Ejecutar() {
        return  Double.parseDouble((String)this.value);
    }

    
}
