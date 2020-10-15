package Main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner leer = new Scanner(System.in);
		
		boolean continuar = true;
		int opcion;
		
		while(continuar) {
			System.out.println("");
			System.out.println("********************");
			System.out.println("1.- Expresión aritmética");
			System.out.println("2.- Expresión lógica");
			System.out.println("3.- Expresión lógica V2");
			System.out.println("4.- Salir");
			opcion = leer.nextInt();
			
			switch (opcion) {
			case 1:
				ExpresionAritmetica inst = new ExpresionAritmetica();
				//Aquí vamos a mandar a llamar el método de expresión aritmética
				break;

			case 2:
				ExpresionLogica insta = new ExpresionLogica();
				
				insta.expresion("[(p->q)^p]->q");
				/*
				 * 
				 * [(p->q)^p]->q
				 * [a^p]->q
				 * b->q
				 * 
				 * Método de insertar a arreglo correspondiente
				 * [a^p]->q
				 * b->q
				 * 
				 * p q	(p->q)	^	p	->	q
				 * V V	V		V		V	V
				 * V F	F		F		V	F
				 * F V	V		F		V	V
				 * F F	V		F		V	F
				 * 
				 */
				//Aquí vamos a mandar a llamar el método de expresión lógica
				break;

			case 3:
				
				/*
				 * "gh9j385ht49h2h4982hr27f2938fh249fh"
				 * 
				 *SOUT("Las letras en la cadena son las siguientes:")
				 *  jkdjdfnwefnwfnewofwen
				 *  
				 *  SOUT("y son " X " cantidad de caracteres")
				 *  
				 *  SOUT("Los números en la cadena son los siguientes:")
				 *  9837983759837958
				 *  SOUT("y son " X " cantidad de números")
				 *  
				 */
				
				//Aquí vamos a mandar a llamar el método de expresión lógica v2
				break;
			
			case 4:
				continuar = false;
				break;
	
			default:
				System.out.println("La opción que elegiste no es la correcta, favor de verificar.");
				break;
			}
			
		}
	}

}
