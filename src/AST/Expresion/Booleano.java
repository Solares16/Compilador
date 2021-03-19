package AST.Expresion;

/**
 *
 * @author Solares
 */
public class Booleano extends Terminal{

    public Booleano(Object value) {
        super(value);
    }    

    @Override
    public Object Ejecutar() {
        
        String valor =  (String)this.value;
        if ( valor.toLowerCase().equals("verdadero") ) {
            return true;
        }else if (valor.toLowerCase().equals("falso")) {
            return false;     
        }else{
            return null; // De hecho hay que definir un Objeto Error y manipular mejor los errores.
        }
    }
    
    
}
