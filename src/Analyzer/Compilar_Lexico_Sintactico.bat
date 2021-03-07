@echo off
color 30 
@echo =================================================
@echo == Lexico Jflex - Calculadora simple de consola==
@echo =================================================

del Scanner.java
java -jar jflex-full-1.8.2.jar Lexico.jflex


echo ===================================================
@echo == Sintactico Cup - Calculadora simple de consola==
@echo ===================================================

del Parser.java Simbolo.java
java -jar java-cup-11b.jar -parser Parser -symbols Simbolo Sintactico.cup

pause
