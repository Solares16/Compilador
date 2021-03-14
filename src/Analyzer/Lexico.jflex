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
Caracter      =   [\'] [^\'\n] [\']
Cadena        =   [\"]([^\"\n]|(\\\"))*[\"]
Id            =   ({Letra} | "_" | "$") ({Letra} | "_" | {Digito} | "$")*


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
  //todos los simbolos anteceden S_

  "+"                   { return new Symbol(Simbolo.s_Plus,                 yyline, yycolumn, yytext());}
  "-"                   { return new Symbol(Simbolo.s_Minus,                yyline, yycolumn, yytext());}
  "*"                   { return new Symbol(Simbolo.s_Times,                yyline, yycolumn, yytext());}
  "/"                   { return new Symbol(Simbolo.s_Divide,               yyline, yycolumn, yytext());}  
  ">"                   { return new Symbol(Simbolo.s_MayQ,                 yyline, yycolumn, yytext());}
  ">="                  { return new Symbol(Simbolo.s_MayIgQ,               yyline, yycolumn, yytext());}
  "<"                   { return new Symbol(Simbolo.s_MenQ,                 yyline, yycolumn, yytext());}
  "<="                  { return new Symbol(Simbolo.s_MenIgQ,               yyline, yycolumn, yytext());}
  "=="                  { return new Symbol(Simbolo.s_IgIg,                 yyline, yycolumn, yytext());}
  "!="                  { return new Symbol(Simbolo.s_dif,                  yyline, yycolumn, yytext());}
  "&&"                  { return new Symbol(Simbolo.s_And,                 yyline, yycolumn, yytext());}
  "||"                  { return new Symbol(Simbolo.s_Or ,                 yyline, yycolumn, yytext());}
  "!"                   { return new Symbol(Simbolo.s_Not,                 yyline, yycolumn, yytext());}
  "("                   { return new Symbol(Simbolo.s_Par_Left,             yyline, yycolumn, yytext());}
  ")"                   { return new Symbol(Simbolo.s_Par_Right,            yyline, yycolumn, yytext());}
  ";"                   { return new Symbol(Simbolo.s_SemiColon,            yyline, yycolumn, yytext());}

  /*********************Lista de palabras reservadas****************************/  
  //Todas las palabras reservadas anteceden r_

  "verdadero"           { return new Symbol(Simbolo.r_Verdadero,            yyline, yycolumn, yytext());}
  "falso"               { return new Symbol(Simbolo.r_Falso,                yyline, yycolumn, yytext());}

  /*******************************Lista de macros********************************/
  //Todos los macros anteceden m_
  
  {Entero}              { return new Symbol(Simbolo.m_Entero,               yyline, yycolumn, yytext());}
  {Decimal}             { return new Symbol(Simbolo.m_Decimal,              yyline, yycolumn, yytext());}  
  {Caracter}            { return new Symbol(Simbolo.m_Caracter,             yyline, yycolumn, yytext());} 
  {Cadena}              { return new Symbol(Simbolo.m_Cadena,               yyline, yycolumn, yytext());}  
  {Id}                  { return new Symbol(Simbolo.m_Id,                   yyline, yycolumn, yytext());}

  {Espacio}             {} //No se realiza ninguna accion para ignorar los espacios 
  {COMENTUNILINEA}      {} //No se realiza ninguna accion para ignorar los comentarios 
  {COMENTMULTILINEA}    {} //No se realiza ninguna accion para ignorar los comentarios 
  .                     { return new Symbol(Simbolo.error,                yyline, yycolumn, yytext());}
}

