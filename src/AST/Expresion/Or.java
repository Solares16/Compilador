
package AST.Expresion;

/**
 *
 * @author Solares
 */
public class Or extends Operacion{

    public Or(Expresion Op1, Expresion Op2) {
        super(Op1, Op2);
    }

    @Override
    public Object Ejecutar() {
        Object val_Uno = this.Op1.Ejecutar();
        Object val_Dos = this.Op2.Ejecutar();

        if((val_Uno instanceof Boolean)&&(val_Dos instanceof Boolean)){
            return (boolean)val_Uno || (boolean)val_Dos;
        }else{
            System.err.println("La operacion Or solo se aplica a tipos de dato Boolean");
            return null;
            //Aqui falta definir un Objeto Error para manipular esto de mejor forma
        }        
    }
    
}
