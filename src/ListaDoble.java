import java.util.Collections;

import javax.swing.JOptionPane;

public class ListaDoble {
	
	public static boolean Num_Check = true;
	
	Nodo Primero;
	Nodo Ultimo;
	Nodo Aux;
	Nodo Anterior;
	
	ListaDoble()
	{
		Primero = null;
		Ultimo = null;
		Anterior = null;
	}
	
	/*PRINCIPIO Empty*/
	public boolean Empty() {
		if(Primero == null) {
			return true;
		}else {
			return false;
		}
	}
	/*END Empty*/
	
	/*PRINCIPIO ListasDoble constructur e ingreso de datos*/
	public ListaDoble AddDown(int dato, String nombre, byte materias) {
		/*Si esta repetido el codigo*/
		if(CodRepetido(dato)) {
			JOptionPane.showMessageDialog(null, "Esta repetido el codigo.");
		}else {
			if(Empty()) {
				Nodo nuevo = new Nodo(dato, nombre, materias);
				Primero = nuevo;
				Primero.Siguiente = null;
				Primero.Anterior = null;
				Ultimo = Primero;
			}else {
				Nodo nuevo = new Nodo(dato, nombre, materias);
				Ultimo.Siguiente = nuevo;
				nuevo.Anterior = Ultimo;
				nuevo.Siguiente = null;
				Ultimo = nuevo;
			}
		}	
		return this;
	}
	/*END ListasDoble constructur e ingreso de datos*/
	
	public ListaDoble AddUp(int dato, String nombre, byte materias) {
		
		if(CodRepetido(dato)) {
			JOptionPane.showMessageDialog(null, "Esta repetido el codigo.");
		}else {
			if(Empty()) {
				Nodo nuevo = new Nodo(dato, nombre, materias);
				Primero = nuevo;
				Primero.Siguiente = null;
				Primero.Anterior = null;
				Ultimo = Primero;
			}else {
				Nodo nuevo = new Nodo(dato, nombre, materias);
				/*Nodo temp = Primero;
				nuevo.Siguiente = temp;
				Primero = nuevo;*/
				nuevo.Siguiente = Primero;
				nuevo.Anterior = null;
				/*if(Primero != null) {
					Primero.Anterior = nuevo;
				}*/
				Primero = nuevo;
			}
		}
		
		return this;
	}
	
	public ListaDoble AddPorPosicion(int dato, String nombre, byte materias) {
		/*int Temp = recorrido.Siguiente.dato;
		recorrido.Siguiente.dato = recorrido.dato;
		recorrido.dato = Temp;*/
		if(CodRepetido(dato)) {
			JOptionPane.showMessageDialog(null, "Esta repetido el codigo.");
		}else {
			if(Empty()) {
				Nodo nuevo = new Nodo(dato, nombre, materias);
				Primero = nuevo;
				Primero.Siguiente = null;
				Primero.Anterior = null;
				Ultimo = Primero;
			}else {
				int Cantidad = cantidad();
				int Posicion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion (" + Cantidad + ")"));
				Nodo actual = Primero;
				int j = 1;
				Nodo nuevo = new Nodo(dato, nombre, materias);
				System.out.println("Adentro");
				while(actual != null) {
					if(j == Posicion) {
						nuevo.Siguiente = actual.Siguiente;
						actual.Siguiente = nuevo;
						break;
					}
					actual = actual.Siguiente;
					System.out.println(j);
					j ++;
					/*if(j == Posicion) {
						break;
					}*/
				}
			}
		}
		return this;
	}
	
	public ListaDoble AddReferencia(int dato, String nombre, byte Materias) {
		if(CodRepetido(dato)) {
			JOptionPane.showMessageDialog(null, "Esta repetido el codigo.");
		}else {
			if(Empty()) {
				Nodo nuevo = new Nodo(dato, nombre, Materias);
				Primero = nuevo;
				Primero.Siguiente = null;
				Primero.Anterior = null;
				Ultimo = Primero;
			}else {
				int c = 0, error = 0;
				Aux = Primero;
				for(c = 0; Aux != null; c ++) {
					if(Aux.dato == dato) {
						break;
					}else {
						Aux = Aux.Siguiente;
					}
				}
				
				if(Aux == null) {
					do {
						int Ide = Integer.parseInt(JOptionPane.showInputDialog("Ingrese identificacion para añadir por referencia."));
						Aux = Primero;
						for(c = 0; Aux != null; c ++) {
							if(Aux.dato == Ide) {
								break;
							}else {
								Aux = Aux.Siguiente;
							}
						}
						if(Aux == null) {
							JOptionPane.showMessageDialog(null, "El id no existe","ERROR", JOptionPane.ERROR_MESSAGE);
							error=1;
						}else {
							error = 0;
							Nodo nuevo = new Nodo(dato, nombre, Materias);
							nuevo.Siguiente = Aux.Siguiente;
							Aux.Siguiente = nuevo;
							//Aux.Anterior = null;
							//Ultimo.Siguiente = null;
						}
					}while(error != 0);
					JOptionPane.showMessageDialog(null, "Correcto 119.");
				}else {
					JOptionPane.showMessageDialog(null, "Ya se encuentra registrado este ID.");
				}
				
			}
		}
		return this;
	}
	
	/*public ListaDoble AddDespuesOf() {
		
		return this;
	}
	
	public ListaDoble AddAntesOf() {
		
		return this;
	}*/
	
	public ListaDoble AddPorOrdenacion(int dato, String nombre, byte Materias) {
		JOptionPane.showMessageDialog(null, "Beta 185.");
		Nodo Aux1 = null;
		Nodo Aux2 = null;
		Nodo Temporal;
		int Contador = cantidad();
		Aux1 = Primero;
		//if(Primero != null && Ultimo != null) {
		try {
			Aux2 = Primero.Siguiente;
		}catch(NullPointerException e) {
			
		}
		//}
		int j = 0;
		while(true) {
			//try {
				
				if(Empty()) {
					Nodo nuevo = new Nodo(dato, nombre, Materias);
					Primero = nuevo;
					Primero.Siguiente = null;
					Primero.Anterior = null;
					Ultimo = Primero;
				}else {
					if(Contador > 0) {
						if(Aux1.dato > Aux2.dato) {
							
							/*Ultimo.Siguiente = nuevo;
							nuevo.Anterior = Ultimo;
							Ultimo = nuevo;
							
							nuevo.Siguiente = Primero;
							nuevo.Anterior = null;
							if(Primero != null) {
								Primero.Anterior = nuevo;
							}
							Primero = nuevo;*/
							Nodo nuevo = new Nodo(dato, nombre, Materias);
							/* -------------------- */
							Temporal = Aux1.Anterior;
							//Nodo Temporal2 = Ultimo.Anterior;
							Aux1.Siguiente = Temporal;
							Aux1.Anterior = nuevo;
							Ultimo = Temporal;
							//Temporal = Aux.Anterior;
							break;
						}else {
							Aux1 = Aux1.Siguiente;
							Aux2 = Aux2.Siguiente;
						}
					}else {
						JOptionPane.showMessageDialog(null, "Este ingreso solo sirve cuando ya hay datos en la lista.\nPero de igual manera se ingresa el primer Nodo.");
						break;
					}
				}
			//}catch(Exception e) {
				//JOptionPane.showMessageDialog(null, "Error 100");
		//	}
			j ++;
			
			if(j == Contador) {
				break;
			}
		}
		return this;
	}
	
	public ListaDoble AddAntes(int dato, String nombre, byte Materias) {
		
		if(CodRepetido(dato)) {
			JOptionPane.showMessageDialog(null, "Esta repetido el codigo.");
		}else {
			if(Empty()) {
				Nodo nuevo = new Nodo(dato, nombre, Materias);
				Primero = nuevo;
				Ultimo = nuevo;
			}else {
				int posicion = 0;
				int c = 0, error = 0;
				Aux = Primero;
				for(c = 0; Aux != null; c ++) {
					if(Aux.dato == dato) {
						break;
					}else {
						Aux = Aux.Siguiente;
					}
				}
				
				if(Aux == null) {
					do {
						int Ide = Integer.parseInt(JOptionPane.showInputDialog("Ingrese identificacion para añadir por referencia."));
						Aux = Primero;
						for(c = 0; Aux != null; c ++) {
							if(Aux.dato == Ide) {
								posicion ++;
								break;
							}else {
								posicion ++;
								Aux = Aux.Siguiente;
							}
						}
						if(Aux == null) {
							JOptionPane.showMessageDialog(null, "El id no existe","ERROR", JOptionPane.ERROR_MESSAGE);
							error=1;
						}else {
							//Nodo actual = Primero;
							error = 0;
							Nodo nuevo = new Nodo(dato, nombre, Materias);
							/*nuevo.Siguiente = Aux.Anterior;
							Aux.Anterior = nuevo;*/
							//try {
								System.out.println("Antes->" + posicion);
								posicion --;
								System.out.println("Despues->" + posicion);
								if(posicion == 0) {
									nuevo.Siguiente = Primero;
									nuevo.Anterior = null;
									/*if(Primero != null) {
										Primero.Anterior = nuevo;
									}*/
									Primero = nuevo;
								}else {
									/*int j = 1;
									while(actual != null) {
										if(j == posicion) {
											nuevo.Siguiente = actual.Siguiente;
											actual.Siguiente = nuevo;
											break;
										}
										actual = actual.Siguiente;
										System.out.println(j);
										j ++;
										if(j == posicion) {
											break;
										}
									}*/
									Nodo actual = Primero;
									int j = 1;
									System.out.println("Adentro");
									while(actual != null) {
										if(j == posicion) {
											nuevo.Siguiente = actual.Siguiente;
											actual.Siguiente = nuevo;
											break;
										}
										actual = actual.Siguiente;
										System.out.println(j);
										j ++;
										/*if(j == posicion) {
											break;
										}*/
									}
								}
							//}catch(NullPointerException e) {
								
							//}
						}
					}while(error != 0);
				}else {
					JOptionPane.showMessageDialog(null, "Ya se encuentra registrado este ID.");
				}
				
			}
		}
		return this;
	}
	
	public ListaDoble AddDespues(int dato, String nombre, byte Materias) {
		if(CodRepetido(dato)) {
			JOptionPane.showMessageDialog(null, "Esta repetido el codigo.");
		}else {
			if(Empty()) {
				Nodo nuevo = new Nodo(dato, nombre, Materias);
				Primero = nuevo;
				Ultimo = nuevo;
			}else {
				int c = 0, error = 0;
				Aux = Primero;
				for(c = 0; Aux != null; c ++) {
					if(Aux.dato == dato) {
						break;
					}else {
						Aux = Aux.Siguiente;
					}
				}
				
				if(Aux == null) {
					do {
						int Ide = Integer.parseInt(JOptionPane.showInputDialog("Ingrese identificacion para añadir por referencia."));
						Aux = Primero;
						for(c = 0; Aux != null; c ++) {
							if(Aux.dato == Ide) {
								break;
							}else {
								Aux = Aux.Siguiente;
							}
						}
						if(Aux == null) {
							JOptionPane.showMessageDialog(null, "El id no existe","ERROR", JOptionPane.ERROR_MESSAGE);
							error=1;
						}else {
							error = 0;
							Nodo nuevo = new Nodo(dato, nombre, Materias);
							nuevo.Siguiente = Aux.Siguiente;
							Aux.Siguiente = nuevo;
							//Aux.Anterior = null;
							//Ultimo.Siguiente = null;
						}
					}while(error != 0);
					JOptionPane.showMessageDialog(null, "Correcto 119.");
				}else {
					JOptionPane.showMessageDialog(null, "Ya se encuentra registrado este ID.");
				}
				
			}
		}
		return this;
	}
	
	public void delete(int codigo) {
		if(Primero != null) {
			Nodo Aux = Primero;
			Nodo Ant = null;
			while(Aux != null) {
				if(Aux.dato == codigo) {
					if(Ant == null) {
						Primero = Primero.Siguiente;
						Aux = Primero;
					}else {
						Ant.Siguiente = Aux.Siguiente;
						Aux.Siguiente = null;
						Aux = Ant.Siguiente;
					}
				}else {
					Ant = Aux;
					Aux = Aux.Siguiente;
				}
			}
		}
	}
	
	/*public ListaDoble borrar(int a) {
		
		Nodo anterior = null;
		Nodo Actual = Primero;
		while(Actual != Ultimo) {
			if(Actual.dato == num) {
				if(anterior == null) {
					Primero = Actual.Siguiente;
					Primero.Anterior = null;
				}else {
					anterior.Siguiente = Actual.Siguiente;
					Nodo Temporal;
					Temporal = Actual.Siguiente;
					Temporal.Anterior = anterior;
				}
				return true;
			}
			anterior = Actual;
			Actual = Actual.Siguiente;
			
		if(Actual == null){
			return false;
		}else{
			return true;
		}
		
	}*/
	
	public boolean CodRepetido(int dato) {
		Aux = Primero;
		while(Aux != null) {
			if(dato == Aux.dato) {
				break;
			}else {
				Aux = Aux.Siguiente;
			}
		}
		if(Aux == null) {
			Num_Check = false;
		}else {
			Num_Check = true;
		}
		//System.out.println(op);
		return Num_Check;
	}
	
	/*PRINCIPIO eliminar*/
	public boolean eliminar(int num) {
		
		Nodo anterior = null;
		Nodo Actual = Primero;
		while(Actual != Ultimo) {
			if(Actual.dato == num) {
				if(anterior == null) {
					Primero = Actual.Siguiente;
					Primero.Anterior = null;
				}else {
					anterior.Siguiente = Actual.Siguiente;
					Nodo Temporal;
					Temporal = Actual.Siguiente;
					Temporal.Anterior = anterior;
					Ultimo.Siguiente = null;
				}
				return true;
			}
			anterior = Actual;
			Actual = Actual.Siguiente;
		}
		if(num == Ultimo.dato) {
			Ultimo = Actual.Anterior;
			return true;
		}
		if(cantidad() > 0) {
			return true;
		}else {
			return false;
		}
		//return false;
	}
	/*END delete*/
	
	/*PRINCIPIO contraImp*/
	public void contraImp() { /*Impresion al reves*/
		Nodo actual;
		actual = Ultimo;
		while(actual != Primero) {
			System.out.println(actual.dato);
			actual = actual.Anterior;
		}
		System.out.println(actual.dato);
	}
	/*END contraImp*/
	
	/*PRINCIPIO imprimir*/
	public void imprimir() { /*Impresion normal*/
		//try {
			Nodo actual;
			actual = Primero;
			while(actual != null) {
				/*if(actual == null) {
					
				}*/
				JOptionPane.showMessageDialog(null, "ID: " + actual.dato + "\nNombre: " + actual.nombre + "\nCantidad de asignaturas: " + actual.C_materias);
				System.out.println("Nodo->" + actual);
				/*System.out.println(actual.dato);*/
				actual = actual.Siguiente;
			}
			/*System.out.println(actual.dato);*/
			//JOptionPane.showMessageDialog(null, "ID: " + actual.dato + "\nNombre: " + actual.nombre + "\nCantidad de asignaturas: " + actual.C_materias);
		//}catch(Exception e) {
			//JOptionPane.showMessageDialog(null, "vacio");
		//}
	}
	/*END imprimir*/
	
	/*PRINCIPIO modificar */
	public void modificar(int num) {
		Aux = Primero;
		for(int i = 0; true; i ++) {
			if(num == Aux.dato) {
				break;
			}else {
				Aux = Aux.Siguiente;
			}
		}
		
		if(Aux == null) {
			JOptionPane.showMessageDialog(null, "No existe el codigo");
		}else {
			while(true) {
				String io = JOptionPane.showInputDialog(null, "1. ID: " + Aux.dato + "\n2. Nombre: " + Aux.nombre + "\n3. Cantidad de asignaturas: " + Aux.C_materias);
				if(io.equals("1")) {
					int NumID = Integer.parseInt(JOptionPane.showInputDialog("Ingrese codigo a modificar"));
					Aux.dato = NumID;
					JOptionPane.showMessageDialog(null, "Se cambio correctamente");
				}else if(io.equals("2")) {
					String name = JOptionPane.showInputDialog("Ingrese nombre a modificar");
					Aux.nombre = name;
				}else if(io.equals("3")) {
					byte mat = Byte.parseByte(JOptionPane.showInputDialog("Ingrese materias a modificar"));
					Aux.C_materias = mat;
				}else {
					//JOptionPane.showMessageDialog(null, "Error 930");
					break;
				}
			}
		}
	}
	/*END modificar*/
	
	/*PRINCIPIO cantidad*/
	public int cantidad() {
		int C = 0;
		Nodo recorrer = Primero;
		while(recorrer != null) {
			recorrer = recorrer.Siguiente;
			C ++;
		}
		return C;
	}
	/*END cantidad*/
	
	/*PRINCIPIO ordenar_menor_a_mayor*/
	public void ordenar_menor_a_mayorID() {
		int contador = cantidad();
		Nodo recorrido = Primero;
		int j = 0;
				/*try {
				for(int i = 0; i < contador - 1; i ++) {
					for(int j = i + 1; j < contador; j ++) {
						if(recorrido.dato > recorrido.Siguiente.dato) {
							String Temp2 = recorrido.Siguiente.nombre;
							recorrido.Siguiente.nombre = recorrido.nombre;
							recorrido.nombre = Temp2;
							int Temp = recorrido.Siguiente.dato;
							recorrido.Siguiente.dato = recorrido.dato;
							recorrido.dato = Temp;
							byte Temp3 = recorrido.Siguiente.C_materias;
							recorrido.Siguiente.C_materias = recorrido.C_materias;
							recorrido.C_materias = Temp3;
						}
					recorrido = recorrido.Siguiente;
					}
				}
			}catch(NullPointerException e) {
				//recorrido = recorrido.Siguiente;
			}*/
		
		while(true) {
			try {
				if(recorrido.Siguiente == null) {
				//	System.out.println("NULL POINTER SIG PUNTERO E970");
				}else {
					if(recorrido.dato > recorrido.Siguiente.dato) {
						int Temp = recorrido.Siguiente.dato;
						recorrido.Siguiente.dato = recorrido.dato;
						recorrido.dato = Temp;
						String Temp2 = recorrido.Siguiente.nombre;
						recorrido.Siguiente.nombre = recorrido.nombre;
						recorrido.nombre = Temp2;
						byte Temp3 = recorrido.Siguiente.C_materias;
						recorrido.Siguiente.C_materias = recorrido.C_materias;
						recorrido.C_materias = Temp3;
					}
				}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Error 585.");
			}
			j ++;
			recorrido = recorrido.Siguiente;
			if(j == contador) {
				break;
			}
		}
		recorrido = Primero;
	}
	/*END ordenar_menor_a_mayorID*/
	
	public ListaDoble OrdenarPorCantidadMaterias() {
		int Contador = cantidad();
		Nodo recorrido = Primero;
		int j = 0;
		
		while(true) {
			try {
				if(recorrido.Siguiente == null) {
				//	System.out.println("NULL POINTER SIG PUNTERO E970");
				}else {
					if(recorrido.C_materias > recorrido.Siguiente.C_materias) {
						int Temp = recorrido.Siguiente.dato;
						recorrido.Siguiente.dato = recorrido.dato;
						recorrido.dato = Temp;
						String Temp2 = recorrido.Siguiente.nombre;
						recorrido.Siguiente.nombre = recorrido.nombre;
						recorrido.nombre = Temp2;
						byte Temp3 = recorrido.Siguiente.C_materias;
						recorrido.Siguiente.C_materias = recorrido.C_materias;
						recorrido.C_materias = Temp3;
					}
				}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Error 428.");
			}
			j ++;
			recorrido = recorrido.Siguiente;
			if(j == Contador) {
				break;
			}
		}
		recorrido = Primero;
		return this;
	}
	
	public ListaDoble OrdenarPorNombre() {
		int contador = cantidad();
		Nodo recorrido = Primero;
		System.out.println(recorrido.dato + " Sig " + recorrido.Siguiente.dato);
		//Nodo Temporal = recorrido.Siguiente;
		//int j = 0;
		for(int i = 0; i < contador - 1; i ++) {
			for(int j = i + 1; j < contador; j ++) {
				try {
					if(recorrido.nombre.compareToIgnoreCase(recorrido.Siguiente.nombre) > 0) {
						String Temp2 = recorrido.Siguiente.nombre;
						recorrido.Siguiente.nombre = recorrido.nombre;
						recorrido.nombre = Temp2;
						int Temp = recorrido.Siguiente.dato;
						recorrido.Siguiente.dato = recorrido.dato;
						recorrido.dato = Temp;
						byte Temp3 = recorrido.Siguiente.C_materias;
						recorrido.Siguiente.C_materias = recorrido.C_materias;
						recorrido.C_materias = Temp3;
					}
					recorrido = recorrido.Siguiente;
				}catch(NullPointerException e) {
					//recorrido = recorrido.Siguiente;
				}
			}
		}
		
		return this;
	}
	
	/*PRINCIPIO camino_mas_corto_cabeza*/
	public int camino_mas_corto_cabeza(int Num_Busquedad) {
		int C = 0;
		int Ch = 0;
		Nodo recorrido = Primero;
		while(recorrido != null) {
			if(Num_Busquedad == recorrido.dato) {
				if(C == 0) { Ch = 1; } 
				C ++;
				break;
			}else {
				recorrido = recorrido.Siguiente;
				C ++;
			}
		}
		
		if(recorrido == null) {
			JOptionPane.showMessageDialog(null, "No se encontro " + Num_Busquedad);
			//C = -1;
		}else {
			if(Ch == 1) {
				JOptionPane.showMessageDialog(null, "Si se encontro " + Num_Busquedad);
			}
			Ch = 0;
		}
		return C;
	}
	/*END camino_mas_corto_cabeza*/
	
	
	public int camino_mas_corto_cola(int Num_Busquedad) {
		int C = 0;
		Nodo Aux2;
		int Ch = 0;
		Aux2 = Ultimo;
		while(Aux2 != Primero) {
			if(Aux2.Anterior == null) {
				
			}else {
				if(Num_Busquedad == Aux2.dato) {
					Ch = 1;
					C ++;
					break;
				}else {
					Aux2 = Aux2.Anterior;
					C ++;
				}
			}
		}
		
		if(Aux2.dato == Num_Busquedad) {
			if(Ch == 1) {
				//JOptionPane.showMessageDialog(null, "Si se encontro el codigo " + Num_Busquedad);
			}
			Ch = 0;
		}else {
			//JOptionPane.showMessageDialog(null, "No se encontro " + Num_Busquedad);
			//C = -1;
		}
		return C;	
	}
}
