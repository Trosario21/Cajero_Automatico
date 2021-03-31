package com.senati.eti;
import java.util.Scanner;

public class Caso_CajeroA {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arrClave = {"210900", "005686", "657800","008513"};
		String[] arrUsuario = {"Rosario Ttito", "Maria Rodriguez", "Anthony Urrutia","David Arango"};
		float[] arrSaldo = {2800, 2500, 800, 1000};
		float[] arrAgua = {540, 250, 170, 50};
		float[] arrLuz = {480, 270, 150, 30};
		float[] arrInternet = {780, 220, 110, 90};
		

		        // posicion
		int p = -1;  

		// contador intentos
		       
		int in = 0, nr = 0;

		System.out.println("BIENVENIDO");
		System.out.println("\n********************");
		System.out.println("*Banco de la Nación*");
		System.out.println("********************");
		System.out.println("\nIntroduzca tarjeta");
		System.out.print("Ingrese clave de tarjeta....: ");
		String clave = sc.nextLine();
		

		while (p == -1 && in < 3) {

		for (int i = 0; i < arrClave.length; i++) {
		if(clave.equals(arrClave[i])) {
		p = i;
		
		
		}
		} //FIN for

		if (p < 0) {
		if ( in < 2) {
		System.out.println("\n<<<Clave incorrecta>>>");
		System.out.print("Ingrese clave de tarjeta....: ");
		clave = sc.nextLine();
		}else{
		System.out.println("\n<<<Tarjeta bloqueada>>>");
		System.out.println("\nNumero maximo de intentos utilizados (3)");
		System.out.println("GRACIAS POR USAR NUESTRO CAJERO, HASTA PRONTO");
		sc.nextLine();
		break;
		}
        
		in++;
		
		}
		
		} //FIN While

		String continuar = "S";

		while(continuar.equals("S") || continuar.equals("s")) {

		if(p != -1){
		System.out.println("\n*************************************");
		System.out.println("Bienvenido(a) " + "<<< " + arrUsuario[p] + " >>>");
		System.out.println("*************************************");
		System.out.println("\nPor favor eliga una opcion:");
		System.out.println("\n[1] Consulta de saldo");
		System.out.println("[2] Hacer retiro");
		System.out.println("[3] Transferencia");
		System.out.println("[4] Deposito en efectivo");
		System.out.println("[5] Pago de servicios");
		System.out.println("[6] Salir");
		System.out.print("Opcion: ");
		int opcion = sc.nextInt();

		float saldo = 0, monto = 0, nuevo_saldo = 0;
	
		switch (opcion) {

		case 1:
		    saldo = arrSaldo[p];
		    System.out.println("-----------------");
		    System.out.println("Consulta de Saldo");
		    System.out.println("-----------------");
		    System.out.println("Su saldo es: " + saldo);

		    break;
		case 2:    
		    System.out.println("-----------");
		    System.out.println("R E T I R O");
		    System.out.println("-----------");
		    System.out.println("¿Cuanto desea retirar?");    
		    monto = sc.nextInt();

		    //if (arrSaldo[p] == 0) {
		        //System.out.println("Saldo Insuficiente");
		    //break;
		    //}
		    if (monto % 10 != 0) {
		    	System.out.println("No es posible operar esa cantidad");
		    	System.out.println("¡Solo se permiten billetes!");
		    break;
		    }

		    if (arrSaldo[p] < monto) {
		        System.out.println("Saldo insuficiente");
		    break;
		    }
		    if (monto > 1000) {
		        System.out.println("No excederse de 1000");
		    break;
		    }
		    if (monto <= arrSaldo[p]) {
		        System.out.println("Saldo: " + arrSaldo[p]);
		        System.out.println("Retiro con exito: " + monto);
		        nuevo_saldo = arrSaldo[p] - monto;
		        System.out.println("Nuevo saldo: " + nuevo_saldo);
		        arrSaldo[p] = nuevo_saldo;
		    break;
		    }
		    break;
		case 3:
		    System.out.println("-------------------------");
		    System.out.println("T R A N S F E R E N C I A");
		    System.out.println("-------------------------");  
		    System.out.print("Ingrese la cuenta del usuario a transferir: ");
		    String cuenta = sc.nextLine();
		    
		    sc.nextLine();
		    
		    System.out.print("Ingrese monto: ");
		    monto = sc.nextInt();

		    //if (arrSaldo[p] == 0) {
		        //System.out.println("Saldo Insuficiente");
		    //break;
		    //}
		    if (monto % 10 != 0) {
		    	System.out.println("No es posible operar esa cantidad");
		    	System.out.println("¡Solo se permiten billetes!");
		    break;
		    }

		    if (arrSaldo[p] < monto) {
		        System.out.println("Saldo insuficiente");
		    break;
		    }
		    if (monto > 1600) {
		        System.out.println("No excederse de 1600");
		    break;
		    }
		    if (monto <= arrSaldo[p]) {
		        System.out.println("\nSaldo antiguo: " + arrSaldo[p]);
		        System.out.println("Transferencia con exito: " + monto);
		        nuevo_saldo = arrSaldo[p] - monto;
		        System.out.println("Nuevo saldo: " + nuevo_saldo);
		        arrSaldo[p] = nuevo_saldo;
		    break;
		    }
		    break;

		case 4:
		    System.out.println("---------------");
		    System.out.println("D E P O S I T O");
		    System.out.println("---------------");
		    System.out.println("¿Cuanto desea depositar?: ");
		    int deposito = sc.nextInt();
		    if (deposito % 10 != 0) {
		    	System.out.println("No es posible operar esa cantidad");
		    	System.out.println("¡Solo se permiten billetes!");
		    break;
		    }
		    if (deposito % 10 == 0) {
		    nuevo_saldo = arrSaldo[p] + deposito;
		    System.out.println("Nuevo saldo es: " + nuevo_saldo);
		    arrSaldo[p] = nuevo_saldo;
		    break;
		    }
		    break;
		case 5: 
			
		    System.out.println("-----------------");
		    System.out.println("PAGO DE SERVICIOS");
		    System.out.println("-----------------");
		    System.out.println("Tipo de servicio que pagará[1-A/2-L/3-I]: ");
		    int servicio = sc.nextInt();
		
		    String nom_ser = "";
		    monto = 0;
		
		    switch (servicio) {
		    
		    case 1:
			    nom_ser = "Agua";
			    monto = arrAgua[p];
			    break;
		    case 2:
			    nom_ser = "Luz";
			    monto = arrLuz[p];
			    break;
		    case 3:
			    nom_ser = "Internet";
			    monto = arrInternet[p];
			    break;
		    default:
			    nom_ser = "Servicio no encontrado";
			    monto = 0;
		    }
		    
		    System.out.println("\nSe realizo su Servicio de Pago con EXITO");
		    System.out.println("Servicio: " + nom_ser);
		    System.out.println("Saldo: " + arrSaldo[p]);
		    System.out.println("Monto a pagar: " + monto);
		    System.out.println("--------------------------------------");
		    nuevo_saldo = arrSaldo[p]- monto ;
		    System.out.println("Su saldo actual será: " + nuevo_saldo);
		    arrSaldo[p] = nuevo_saldo;
		    break;
		case 6:
		    System.out.println("====SALIR====");
		
		    System.out.println("\nGRACIAS POR USAR NUESTRO CAJERO");
			System.out.println("Hasta pronto");
			sc.nextLine();
		    break;
		    
		default:
		    System.out.println("Opcion no valida");
		}
		
		}
		
		sc.nextLine();
		System.out.println("***************************************");
		System.out.println("¿Desea realizar otra operacion? <S/N>: ");
		continuar = sc.nextLine();


		} 

		System.out.println("GRACIAS POR USAR NUESTRO CAJERO");
		System.out.println("Hasta pronto");
	}

	}