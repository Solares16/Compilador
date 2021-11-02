package AST.Expresion;

/**
 *
 * @author Solares
 */
public class MenorIgualQue extends Operacion {

    public MenorIgualQue(Expresion Op1, Expresion Op2) {
        super(Op1, Op2);
    }

    @Override
    public Object Ejecutar() {
        // La tabla de combinaciones esta en la clase MayorQue
        Object val_Uno = this.Op1.Ejecutar();
        Object val_Dos = this.Op2.Ejecutar();

        if ((val_Uno instanceof Double) && (val_Dos instanceof Double)) {
            return (double) val_Uno <= (double) val_Dos;
        } else if ((val_Uno instanceof Character) && (val_Dos instanceof Character)) {
            return (int) ((char) val_Uno) <= (int) ((char) val_Dos);
        } else if ((val_Uno instanceof Boolean) && (val_Dos instanceof Boolean)) {
            int valBool_Uno = (boolean) val_Uno ? 1 : 0;
            int valBool_Dos = (boolean) val_Dos ? 1 : 0;
            return valBool_Uno <= valBool_Dos;
        } else if ((val_Uno instanceof Character) && (val_Dos instanceof Double)) {
            return (int) ((char) val_Uno) <= (double) val_Dos;
        } else if ((val_Uno instanceof Double) && (val_Dos instanceof Character)) {
            return (double) val_Uno <= (int) ((char) val_Dos);
        } else if ((val_Uno instanceof Boolean) && (val_Dos instanceof Double)) {
            int valBool_Uno = (boolean) val_Uno ? 1 : 0;
            return valBool_Uno <= (double) val_Dos;
        } else if ((val_Uno instanceof Double) && (val_Dos instanceof Boolean)) {
            int valBool_Dos = (boolean) val_Dos ? 1 : 0;
            return (double) val_Uno <= valBool_Dos;
        } else if ((val_Uno instanceof Boolean) && (val_Dos instanceof Character)) {
            int valBool_uno = (boolean) val_Uno ? 1 : 0;
            return valBool_uno <= (int) ((char) val_Dos);
        } else if ((val_Uno instanceof Character) && (val_Dos instanceof Boolean)) {
            int valBool_Dos = (boolean) val_Dos ? 1 : 0;
            return (int) ((char) val_Uno) <= valBool_Dos;
        } else {
            System.err.println("Error: Tipo de dato incorrecto");
            return null;
            //Aqui falta definir un Objeto Error para manipular esto de mejor forma
        }
    }

}
