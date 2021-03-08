//****************************************************************************
//*************************Seccion: User Code*********************************
//****************************************************************************

package Analyzer;
import java_cup.runtime.*;

//Separador de Secciones
%%

//****************************************************************************
//**************Seccion: Options And Declatarions*****************************
//****************************************************************************

%class Scanner     //Le dice a JFlex cual será el nombre de la clase generada.  En este caso será Scanner.java

%cupsym Simbolo    
                   //Especifica el nombre de la clase generada por CUP que contiene los nombres de los tokens,
                   //Si no se especifica la clase por default es sym.java
                   //Debe escribirse antes de la opcion %cup

%public            //Hace publica la clase generada por Jflex 

%cup               //Habilita la compatibilidad con CUP 

%unicode           //Set de caracteres usado para leer archivos de texto. para mas info leer sobre Enconding 

%ignorecase        //habilita el modo case insensitive keywords 

%line              //habilita la variable yyline y contiene el numero de lineas desde el inicio de la entrada
                   //hasta el inicio del token actual(la variable empieza a contar desde 0)

%column            //habilita la variable yycolumn y contiene el numero de caracteres desde el inicio de la
                   //linea actual hasta el inicio del token actual

//El codigo encerrado entre %init{ ... %init}  es copiado literalmente al constructor de la clase generada
%init{
  yycolumn=1;
  yyline=1;
%init}


//Expresiones Regulares para los tipos de datos
Digito        =   [0-9]
Letra         =   [a-zA-Z]
Entero        =   {Digito}+
Decimal       =   ("+"|"-")?{Entero}("."{Entero})?



//Comentarios y Espacios entre tokens 
Espacio          =   (" " | \r | \n | \t | \f)+
COMENTUNILINEA   =   ("//".*\r\n)|("//".*\n)|("//".*\r)
COMENTMULTILINEA =   "/*""/"*([^*/]|[^*]"/"|"*"[^/])*"*"*"*/"

//Separador de Secciones
%%

//****************************************************************************
//********************Seccion:  Lexical Rules*********************************
//****************************************************************************

<YYINITIAL>{
  /*********************Listado de simbolos*************************************/

  "+"                   { return new Symbol(Simbolo.Plus,                 yyline, yycolumn, yytext());}
  "-"                   { return new Symbol(Simbolo.Minus,                yyline, yycolumn, yytext());}
  "*"                   { return new Symbol(Simbolo.Times,                yyline, yycolumn, yytext());}
  "/"                   { return new Symbol(Simbolo.Divide,               yyline, yycolumn, yytext());}

  "("                   { return new Symbol(Simbolo.Par_Left,             yyline, yycolumn, yytext());}
  ")"                   { return new Symbol(Simbolo.Par_Right,            yyline, yycolumn, yytext());}


  /*********************Lista de palabras reservadas****************************/
  

  /*******************************Lista de macros********************************/
  
  {Entero}              { return new Symbol(Simbolo.Entero,           yyline, yycolumn, new Double(yytext()));}
  {Decimal}             { return new Symbol(Simbolo.Decimal,          yyline, yycolumn, new Double(yytext()));}  
  {Espacio}             {} //No se realiza ninguna accion para ignorar los espacios 
  {COMENTUNILINEA}      {} //No se realiza ninguna accion para ignorar los comentarios 
  {COMENTMULTILINEA}    {} //No se realiza ninguna accion para ignorar los comentarios 
  .                     { return new Symbol(Simbolo.error,          yyline, yycolumn, yytext());}
}

