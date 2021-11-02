package AST.Expresion;

/**
 *
 * @author Solares
 */
public class Not extends Operacion {

    public Not(Expresion Op1) {
        super(Op1);
    }

    @Override
    public Object Ejecutar() {

        Object val_Uno = this.Op1.Ejecutar();

        if(val_Uno instanceof Boolean){
            return  !(boolean)val_Uno;
        }else{
            System.err.println("La operacion Not solo se aplica a tipos de dato Boolean");
            return null;
            //Aqui falta definir un Objeto Error para manipular esto de mejor forma
        }        
    }

}
