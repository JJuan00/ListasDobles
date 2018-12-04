import java.util.Collections;

import javax.swing.JOptionPane;

public class Main {
	static int Contador = 0;
	public static void main(String[] args) {/*START*/
		//try {
			ListaDoble list = new ListaDoble();
			while(true) {
				String op = JOptionPane.showInputDialog("1. Ingresar.\n2. Modificar.\n3. Mostrar todo.\n4. Eliminar.\n5. Metodos de ordenamiento.\n0. Salir");
				switch(op) {
				case "1":
					int Num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero ID"));
					String Name = JOptionPane.showInputDialog("Ingrese nombre");
					byte Cantidad_Materias = Byte.parseByte(JOptionPane.showInputDialog("Ingrese la cantidad de materias"));
					String ingreso = JOptionPane.showInputDialog("1. Ingresar cabeza\n2. Ingresar cola\n3. Ingreso por ordenamiento(beta)\n4. Ingresar por referencia.\n5. Ingreso por posicion.\n6. Añadir antes de (referencia).\n7. Añadir despues de (referencia).");
					switch(ingreso) {
					case "1":
						list.AddUp(Num, Name, Cantidad_Materias); //Ya esta
						break;
					case "2":
						list.AddDown(Num, Name, Cantidad_Materias); //Ya esta
						break;
					case "3":
						list.AddPorOrdenacion(Num, Name, Cantidad_Materias);
						break;
					case "4":
						list.AddReferencia(Num, Name, Cantidad_Materias); //Ya esta
						break;
					case "5":
						list.AddPorPosicion(Num, Name, Cantidad_Materias); //ya esta
						break;
					case "7":
						list.AddDespues(Num, Name, Cantidad_Materias);
						break;
					case "6":
						list.AddAntes(Num, Name, Cantidad_Materias);
						break;
					default:
						JOptionPane.showMessageDialog(null, "Ingrese una opcion valida.");
						break;
					}
				break;
				
				case "2":
					if(list.Empty()) {
						JOptionPane.showMessageDialog(null, "Lista vacia.");
					}else {
						int Nums = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero ID"));
						if(list.CodRepetido(Nums)) {
							list.modificar(Nums);
						}else {
							JOptionPane.showMessageDialog(null,"No existe el codigo " + Nums);
						}
					}
				break;
				
				case "3":
					if(list.Empty()) {
						JOptionPane.showMessageDialog(null, "Lista vacia.");
					}else {
						if(list.cantidad() > 0) {
							list.imprimir();
						}else {
							//JOptionPane.showMessageDialog(null, "Lista vacia.");
						}
					}
				break;
				
				case "4":
					if(list.Empty()) {
						JOptionPane.showMessageDialog(null, "Lista vacia.");
					}else {
						if(list.cantidad() > 0) {
							int Code = Integer.parseInt(JOptionPane.showInputDialog("Ingrese codigo de la persona que desea eliminar."));
							if(list.CodRepetido(Code)) {
								list.delete(Code);
								JOptionPane.showMessageDialog(null, "Se elimino correctamente.");
							}else {
								JOptionPane.showMessageDialog(null, "No existe el codigo " + Code);
							}
						}else {
							//JOptionPane.showMessageDialog(null, "Lista vacia.");
						}
					}
				break;
				
				case "5":
					String op2 = JOptionPane.showInputDialog("1. Ordenamiento por ID (menor a mayor).\n2. Ordenamiento por cantidad de materias.\n3. Ordenamiento por nombres. (A - Z)");
					switch(op2) {
					case "1":
						int C = 0;
						if(list.Empty()) {
							JOptionPane.showMessageDialog(null, "Lista vacia.");
						}else {
							while(true) {
								list.ordenar_menor_a_mayorID();
								C ++;
								if(list.cantidad() == C) {
									break;
								}
							}
							JOptionPane.showMessageDialog(null, "Ordenamiento hecho.");
						}
					case "3":
						C = 0;
						if(list.Empty()) {
							JOptionPane.showMessageDialog(null, "Lista vacia.");
						}else {
							while(true) {
								list.OrdenarPorNombre();
								C ++;
								if(list.cantidad() + 2 == C) {
									break;
								}
							}
							JOptionPane.showMessageDialog(null, "Ordenamiento hecho.");
						}
					break;
					case "2":
						if(list.Empty()) {
							JOptionPane.showMessageDialog(null, "Lista vacia.");
						}else {
							list.OrdenarPorCantidadMaterias();
							JOptionPane.showMessageDialog(null, "Ordenamiento hecho.");
						}
					}
				break;
				
				case "6":
					if(list.Empty()) {
						JOptionPane.showMessageDialog(null, "Lista vacia.");
					}else {
						System.out.println(list.cantidad());
						int CodeB = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero a buscar\nDetermina el camino mas corto.\nCabeza o cola."));
						if(list.camino_mas_corto_cabeza(CodeB) != -1 || list.camino_mas_corto_cola(CodeB) != -1) {
							if(list.camino_mas_corto_cabeza(CodeB) < list.camino_mas_corto_cola(CodeB)) {
								JOptionPane.showMessageDialog(null, "La cabeza es el camino mas rapido");
							}else if(list.camino_mas_corto_cola(CodeB) < list.camino_mas_corto_cabeza(CodeB)){
								JOptionPane.showMessageDialog(null, "La cola es el camino mas rapido");
							}else if(list.camino_mas_corto_cola(CodeB) == list.camino_mas_corto_cabeza(CodeB)) {
								JOptionPane.showMessageDialog(null, "Es igual el recorrido.");
							}
						}
						System.out.println(list.camino_mas_corto_cabeza(CodeB) + "--- " + list.camino_mas_corto_cola(CodeB));
					}
				break;
				
				case "0":
				break;
				
				default:
					JOptionPane.showMessageDialog(null, "Ingrese opcion valida.");
				}
				
				if(op.equals("0")) {
					break;
				}
			}
		//}catch(Exception e) {
			//JOptionPane.showMessageDialog(null, "Adios.");
		//}
	}/*END*/
}
