public class Nodo {
	int dato;
	String nombre;
	byte C_materias;
	Nodo Siguiente;
	Nodo Anterior;
	
	Nodo(int Num, String Name, byte materias){
		this.dato = Num;
		this.nombre = Name;
		this.C_materias = materias;
		this.Siguiente = null;
		this.Anterior = null;
	}
}
