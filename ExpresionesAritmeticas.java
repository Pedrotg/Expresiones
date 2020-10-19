package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpresionAritmetica {

	Stack pilaOperaciones = new Stack();
	Stack pilaFinal = new Stack();
	
	public ExpresionAritmetica() {
		separar("( 6 + 2 ) * 3 / 2 ^ 2 - 4"); //infija
	}

	private void separar(String operacion) {
		
		String prefijo = "(?=[-+*/^()])";
		String sufijo = "(?<=[-+*/^()])";
		String simbolos = "(?=[-+*/^()])|(?<=[-+*/^()])";

		String []arreglo = operacion.split(simbolos);
		
		SeparaExpresion(arreglo);
		
	}

	private void SeparaExpresion(String[] arreglo) {
		
		List cadena = new ArrayList();
		
		String cadena2 = "gwegew";
		
		//split(" ");
		//Listcadena=newArrayList();
		
		cadena2.charAt(i);
		//cadena.charAt(
		
		//arreglo
		//(,6,+,2,),*,3,/,2,^,2,-,4
		
		/*cadena
			6,2,+,3,*,2,2,^,/,4,-
		*/
		
		/*pilaOperadores
			
		*/
		
		//Recorre el arreglo que hicimos con split
		for (int i = 0; i < arreglo.length; i++) {
			
			//necesitamos saber si el String es un número
			if(isNumeric(arreglo[i])) { 
				//insertar a la pila numérica
				
				cadena.add(arreglo[i]);
				
				if (i == arreglo.length-1) {
					while(!pilaOperaciones.empty()){
						cadena.add(pilaOperaciones.peek());
						pilaOperaciones.pop();
					}
				}
				
			}else {
				//insertar a la pila Operaciones
				
				int prioridad = prioridad(arreglo[i]);
				
				switch (prioridad) {
				
				case 0:
					if(!pilaOperaciones.empty()) {
						
						int prioridadPila = prioridad((String) pilaOperaciones.peek());
					
						if(prioridadPila == prioridad) {
							cadena.add(pilaOperaciones.peek());
							
							pilaOperaciones.pop();
							
					
						}else if(prioridadPila>prioridad) {
							while(!pilaOperaciones.empty()){
								
								cadena.add(pilaOperaciones.peek());
								pilaOperaciones.pop();
							}
						}											
					}
					pilaOperaciones.push(arreglo[i]);
					
					break;
				case 1:
					
					if(!pilaOperaciones.empty()) {
						
						int prioridadPila = prioridad((String) pilaOperaciones.peek());
					
						if(prioridadPila == prioridad) {
							cadena.add(pilaOperaciones.peek());
							pilaOperaciones.pop();
					
						}else if(prioridadPila<prioridad) {
							while(!pilaOperaciones.empty()){
								
								cadena.add(pilaOperaciones.peek());
								pilaOperaciones.pop();
							}
						}
					}
					
					pilaOperaciones.push(arreglo[i]);
					break;
					
				case 2:
					pilaOperaciones.push(arreglo[i]);
					break;
					
				case 3:
					while(!pilaOperaciones.empty()){
						cadena.add(pilaOperaciones.peek());
						pilaOperaciones.pop();
					}
					break;

				default:
					break;
				}
			}
		}
		
		System.out.println(cadena);
		combierteeInsertaenPila(cadena);
	}
	
	private void combierteeInsertaenPila(List cadena) {
		
		for (int i = 0; i < cadena.size(); i++) {
			//Esta línea es para saber de qué tipo es el dato
				System.out.println(cadena.get(i)+ " es de tipo: " +  ((Object)cadena.get(i)).getClass().getSimpleName());
					
			try {
				int numero = Integer.parseInt((String) cadena.get(i));
				
				pilaFinal.push(numero);
				
				System.out.println("Numero en pila: "+pilaFinal.peek());
				
			}catch (NumberFormatException e){
				
				pilaFinal.push(cadena.get(i));
				
				System.out.println("String en pila: "+pilaFinal.peek());		
			}
			
//			realizaOperaciones();
		}
	}
	private void realizaOperaciones() {
		System.out.println("dato en pila: "+pilaFinal.peek());
		
	}

	/*// 2
	 * 
	 * for (que recorra la cadena [6, 2, +, 3, *, 2, 2, ^, /, 4, -]){
	 * 
	 *		if(cadena == numero)
	 *			guarda en pila
	 *
	 *		else  -
	 *			
	 *			-recorrió la pila 
	 *			-realiza la operación correspondiente
	 *			-borra los datos de la pila
	 *			-El resultado lo guardaba en la pila
	 *
	 *
	 *			-Realiza operación de acuerdo al operador que lea
	 *			-la condición es que siempre tomará los últimos 2 dígitos que entraron a la pila
	 *			-Sacamos esos 2 dígitos que utilizamos
	 *			-El resultado se guardará en la pila
	 * 			-Mostrar el resultado
	 * }
	 * 
	 */


	//Solamente prioridad de símboloes
	private int prioridad(String arreglo) { 
		
		if (arreglo.equals("+") || arreglo.equals("-"))
			
			return 0;
		
		else if (arreglo.equals("*") || arreglo.equals("/"))
	
			return 1; 
		
		else if (arreglo.equals("^"))
			
			return 2;
	
		else if (arreglo.equals(")"))
			
			return 3;
			
		return -1;
	} //Fin de la funcion prioridad
	
	private boolean isNumeric(String string) {
		
		try{  
			double d = Double.parseDouble(string);  
			return true;
		}catch(NumberFormatException nfe){  
			return false;  
		}  
	}
}
