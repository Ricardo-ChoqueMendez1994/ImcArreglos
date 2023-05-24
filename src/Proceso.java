import java.util.Arrays;

import javax.swing.JOptionPane;

public class Proceso {
	
	String[] nombreArr;
	double[] estaturaArr;
	double[] pesoArr;
	double[] imcArr;
	
	String nombreIngresado;
	
	public void Iniciar() {
		
		JOptionPane.showMessageDialog(null, "Índice de masa corporal.");
		
		String menu="Calcula tu IMC \n";
		menu+="1. Llenar datos. \n";
		menu+="2. Imprimir Resultado. \n";
		menu+="3. Buscar por nombre. \n";
		menu+="4. Actualizar. \n";
		menu+="5. Eliminar persona. \n";
		menu+="6. Limpiar Lista. \n";
		menu+="7. Salir. \n";
		menu+="Ingrese una opción: \n";
		
		int opc = 0;
		
		do {
			opc=Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			validarMenu(opc);
			
		} while (opc != 7);	
	}
	
	public void validarMenu(int opc) {
		switch (opc) {
		case 1:
			PedirDatos();
			break;
		case 2:
			if (nombreIngresado != null) {
				Imc();
				imprimirResultado();
			} else {
				System.out.println("¡Debe primero llenar datos!");
			}
			break;
		case 3:
			if (nombreIngresado != null) {
				Imc();
				buscarPorNombre();
			} else {
				System.out.println("¡Debe primero llenar datos!");
			}
			break;
		case 4:
			if (nombreIngresado != null) {
				actualizar();
			} else {
				System.out.println("¡Debe primero llenar datos!");
			}
			break;
		case 5:
			if (nombreIngresado != null) {
				eliminarPersona();
			} else {
				System.out.println("¡Debe primero llenar datos!");
			}
			break;
		case 6:
			if (nombreIngresado != null) {
				limpiarLista();
			} else {
				System.out.println("¡Debe primero llenar datos!");
			}
			break;
		case 7:
			System.out.println("¡Chao parcero!");
			break;
		default:
			System.out.println("Ingrese una opción válida.");
			break;
		}
	}
	
	public void PedirDatos() {
		int cant = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de personas para realizar el proceso: "));
		nombreArr = new String[cant];
		estaturaArr = new double[cant];
		pesoArr = new double[cant];
		
		for (int i = 0; i < cant; i++) {
			nombreIngresado = JOptionPane.showInputDialog(i+1 + " Ingrese su nombre: ");
			nombreArr[i] = nombreIngresado;
			estaturaArr[i] = Double.parseDouble(JOptionPane.showInputDialog(nombreArr[i] + " Ingrese su estatura: "));
			pesoArr[i] = Double.parseDouble(JOptionPane.showInputDialog(nombreArr[i] + " Ingrese su peso: "));
		}
	}
	
	public void Imc() {
		imcArr = new double[nombreArr.length];
		for (int j = 0; j < nombreArr.length; j++) {
			imcArr[j] = pesoArr[j] / (estaturaArr[j] * estaturaArr[j]);
		}
	}
	
	public void imprimirResultado() {
		for (int i = 0; i < nombreArr.length; i++) {
			if (imcArr[i] < 18) {
				System.out.println("Usuario " + (i+1) + ") " + nombreArr[i] + "\nSu peso es: " + pesoArr[i] + " Kg\nSu estatura es: " +
						estaturaArr[i] + " cm\nPara un resultado de Anorexia\n");
			} else if (imcArr[i] >= 18 && imcArr[i] < 20) {
				System.out.println("Usuario " + (i+1) + ") " + nombreArr[i] + "\nSu peso es: " + pesoArr[i] + " Kg\nSu estatura es: " +
						estaturaArr[i] + " cm\nPara un resultado de Delgadez\n");
			} else if (imcArr[i] >= 20 && imcArr[i] < 27) {
				System.out.println("Usuario " + (i+1) + ") " + nombreArr[i] + "\nSu peso es: " + pesoArr[i] + " Kg\nSu estatura es: " +
						estaturaArr[i] + " cm\nPara un resultado de Normalidad\n");
			} else if (imcArr[i] >= 27 && imcArr[i] < 30) {
				System.out.println("Usuario " + (i+1) + ") " + nombreArr[i] + "\nSu peso es: " + pesoArr[i] + " Kg\nSu estatura es: " +
						estaturaArr[i] + " cm\nPara un resultado de Obesidad grado 1\n");
			} else if (imcArr[i] >= 30 && imcArr[i] < 35) {
				System.out.println("Usuario " + (i+1) + ") " + nombreArr[i] + "\nSu peso es: " + pesoArr[i] + " Kg\nSu estatura es: " +
						estaturaArr[i] + " cm\nPara un resultado de Obesidad grado 2\n");
			} else if (imcArr[i] >= 35 && imcArr[i] < 40) {
				System.out.println("Usuario " + (i+1) + ") " + nombreArr[i] + "\nSu peso es: " + pesoArr[i] + " Kg\nSu estatura es: " +
						estaturaArr[i] + " cm\nPara un resultado de Obesidad grado 3\n");
			} else if (imcArr[i] >= 40) {
				System.out.println("Usuario " + (i+1) + ") " + nombreArr[i] + "\nSu peso es: " + pesoArr[i] + " Kg\nSu estatura es: " +
						estaturaArr[i] + " cm\nPara un resultado de Obesidad mórbida\n");
			}
		}
	}
	
	public void buscarPorNombre() {
		System.out.println("Buscar por nombre");
		
		int contador = 0;
		
		String nombreBuscar = JOptionPane.showInputDialog("Ingrese el nombre a buscar");
		
		for (int i = 0; i < nombreArr.length; i++) {
			if (nombreArr[i].equalsIgnoreCase(nombreBuscar)) {
				System.out.println("Se encontró a " + nombreBuscar + " en la posición " + (i+1));
				contador++;
			}
			}
		
		if (contador > 0) {
			System.out.println("Encontró a " + nombreBuscar + " " + contador + " veces");
		} else {
			System.out.println("La persona " + nombreBuscar + " no fue registrada");
		}
	}
	
	public void actualizar() {
		String name = JOptionPane.showInputDialog("Ingrese el usuario que desea actualizar");
		String nombre;
		double peso, altura;
		boolean encontrado = false;
		
		for (int i = 0; i < nombreArr.length; i++) {
			if (nombreArr[i].equalsIgnoreCase(name)) {
				encontrado = true;
				nombre = JOptionPane.showInputDialog("Ingresar nombre: ");
				nombreArr[i] = nombre;
				peso = Double.parseDouble(JOptionPane.showInputDialog("Ingresar peso: "));
				pesoArr[i] = peso;
				altura = Double.parseDouble(JOptionPane.showInputDialog("Ingresar altura: "));
				estaturaArr[i] = altura;
				imcArr[i] = peso / (altura * altura);
			}
		}
		
		if (!encontrado) {
			JOptionPane.showMessageDialog(null, "No se encontró un usuario con dicho nombre");
		}
	}
	
	public void eliminarPersona() {
		String name = JOptionPane.showInputDialog("Ingrese el nombre del usuario que desea eliminar");
		boolean encontrado = false;
		
		for (int i = 0; i < nombreArr.length; i++) {
			if (nombreArr[i].equalsIgnoreCase(name)) {
				encontrado = true;
				for (int j = i; j < nombreArr.length - 1; j++) {
					nombreArr[j] = nombreArr[j+1];
					pesoArr[j] = pesoArr[j+1];
					estaturaArr[j] = estaturaArr[j+1];
					imcArr[j] = imcArr[j+1];
				}
				break;
			}
		}
		
		if (!encontrado) {
			JOptionPane.showMessageDialog(null, "No se encontró el usuario ingresado");
		} else {
			// Redimensionar los arreglos
			nombreArr = Arrays.copyOf(nombreArr, nombreArr.length - 1);
			pesoArr = Arrays.copyOf(pesoArr, pesoArr.length - 1);
			estaturaArr = Arrays.copyOf(estaturaArr, estaturaArr.length - 1);
			imcArr = Arrays.copyOf(imcArr, imcArr.length - 1);
			
			System.out.println("Usuario eliminado correctamente");
		}
	}
	
	public void limpiarLista() {
		nombreArr = new String[0];
		pesoArr = new double[0];
		estaturaArr = new double[0];
		imcArr = new double[0];
		
		System.out.println("Lista limpiada correctamente");
	}
}
