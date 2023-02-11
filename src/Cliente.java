import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws IOException {

        String Host = "localhost";
        int Puerto = 6000;// puerto remoto

        Socket Cliente = new Socket(Host, Puerto);

        // CREO FLUJO DE SALIDA AL SERVIDOR
        PrintWriter cadenaEnviada = new PrintWriter(Cliente.getOutputStream(), true);
        PrintWriter cadenaEnviadaDos = new PrintWriter(Cliente.getOutputStream(), true);

        // CREO FLUJO DE ENTRADA AL SERVIDOR
        BufferedReader cadenaRecibida = new BufferedReader(new InputStreamReader(Cliente.getInputStream()));

        // FLUJO PARA ENTRADA ESTANDAR(equivale a un scanner)
        BufferedReader entradaUsuario = new BufferedReader(new InputStreamReader(System.in));

        String boton = "", numero = "", respuestaServidor = "HOLA";


        while(true){

            System.out.print("Por favor, elige una tecla o combinación de teclas de entre las siguientes: ");
            System.out.println("\n");
            System.out.println("CJ ---> Se te pedirá introducir un número en metros cuadrados y la aplicación te indicará a cuantos campos de fútbol equivale dicha superficie.");
            System.out.println("X ---> Se te pedirá introducir el número de meses que has trabajado y la aplicación te indicará cuantos meses te queda para jubilarte con el 100% de la pensión");
            System.out.println("PR ---> Se te pedirá introducir un número y la aplicación te devolverá el resultado de dividir dicho número entre el número total de obras publicadas por el famoso escritor Arturo Pérez Reverte.");
            System.out.println("R ---> Se te pedirá introducir el precio de la gasolina que has pagado (precio por litro de gasolina) y la aplicación te indicará cuanto has pagado de más con respecto a la gasolina más barata en la ciudad de Vigo.");
            System.out.println("* ---> Para finalizar la aplicación.");
            boton = entradaUsuario.readLine(); // lectura por teclado

            if(boton.equals("CJ") || boton.equals("X") || boton.equals("PR") || boton.equals("R") || boton.equals("*")) {
                break;
            }
        }

        switch(boton) {
            case "CJ":
                while(true) {
                    System.out.println("Introduce un número en metros cuadrados.");
                    numero = entradaUsuario.readLine();
                    if(contieneSoloNumeros(numero)){
                        break;
                    }
                    System.out.println("Introduce sólo caracteres numéricos.");
                }
                break;
            case "X":
                while(true) {
                    System.out.println("Introduce el número de meses que has trabajado.");
                    numero = entradaUsuario.readLine();
                    if (contieneSoloNumeros(numero)) {
                        break;
                    }
                    System.out.println("Introduce sólo caracteres numéricos.");
                }
                break;
            case "PR":
                while(true) {
                    System.out.println("Introduce un número cualquiera.");
                    numero = entradaUsuario.readLine();
                    if (contieneSoloNumeros(numero)) {
                        break;
                    }
                    System.out.println("Introduce sólo caracteres numéricos.");
                }
                break;
            case "R":
                while(true) {
                    System.out.println("Introduce el precio de gasolina por litro que has pagado.");
                    numero = entradaUsuario.readLine();
                    if (contieneSoloNumerosYPunto(numero) && esDecimal(numero)) {
                        break;
                    }
                    System.out.println("Sólo puedes introducir un número decimal.");
                }
                break;
            case "*":
                break;
            default:
                System.out.println("Por favor, introduzca una opción válida");
        }

        while (boton != null && numero != null) {
            cadenaEnviada.println(boton); // envio cadena al servidor
            cadenaEnviadaDos.println(numero);
            respuestaServidor = cadenaRecibida.readLine(); // recibo cadena del servidor
            System.out.println("RESPUESTA SERVIDOR ---> "+respuestaServidor);

            if (respuestaServidor.equals("END!")) { // si la cadena recibida del servidor es END, finaliza conexión con el Servidor y fin de clase Cliente
                break;
            }

            while(true) {
                System.out.println("\n");
                System.out.println("\n");
                System.out.print("Por favor, elige una tecla o combinación de teclas de entre las siguientes: ");
                System.out.println("\n");
                System.out.println("CJ ---> Se te pedirá introducir un número en metros cuadrados y la aplicación te indicará a cuantos campos de fútbol equivale dicha superficie.");
                System.out.println("X ---> Se te pedirá introducir el número de meses que has trabajado y la aplicación te indicará cuantos meses te queda para jubilarte con el 100% de la pensión");
                System.out.println("PR ---> Se te pedirá introducir un número y la aplicación te devolverá el resultado de dividir dicho número entre el número total de obras publicadas por el famoso escritor Arturo Pérez Reverte.");
                System.out.println("R ---> Se te pedirá introducir el precio de la gasolina que has pagado (precio por litro de gasolina) y la aplicación te indicará cuanto has pagado de más con respecto a la gasolina más barata en la ciudad de Vigo.");
                System.out.println("* ---> Para finalizar la aplicación.");

                boton = entradaUsuario.readLine(); // lectura por teclado

                if(boton.equals("CJ") || boton.equals("X") || boton.equals("PR") || boton.equals("R") || boton.equals("*")) {
                    break;
                }
            }


            switch(boton) {
                case "CJ":
                    while(true) {
                        System.out.println("Introduce un número en metros cuadrados.");
                        numero = entradaUsuario.readLine();
                        if(contieneSoloNumeros(numero)){
                            break;
                        }
                        System.out.println("Introduce sólo caracteres numéricos.");
                    }
                    break;
                case "X":
                    while(true) {
                        System.out.println("Introduce el número de meses que has trabajado.");
                        numero = entradaUsuario.readLine();
                        if (contieneSoloNumeros(numero)) {
                            break;
                        }
                        System.out.println("Introduce sólo caracteres numéricos.");
                    }
                    break;
                case "PR":
                    while(true) {
                        System.out.println("Introduce un número cualquiera.");
                        numero = entradaUsuario.readLine();
                        if (contieneSoloNumeros(numero)) {
                            break;
                        }
                        System.out.println("Introduce sólo caracteres numéricos.");
                    }
                    break;
                case "R":
                    while(true) {
                        System.out.println("Introduce el precio de gasolina por litro que has pagado.");
                        numero = entradaUsuario.readLine();
                        if (contieneSoloNumerosYPunto(numero) && esDecimal(numero)) {
                            break;
                        }
                        System.out.println("Sólo puedes introducir un número decimal.");
                    }
                    break;
                case "*":
                    break;
                default:
                    System.out.println("Por favor, introduzca una opción válida");
            }
        }

        cadenaEnviada.close();
        cadenaRecibida.close();
        System.out.println("Fin del programa... ");
        entradaUsuario.close();
        Cliente.close();
    }


    //Método que devuelve true si una cadena contiene sólo números o false en caso contrario
    public static boolean contieneSoloNumeros(String cadena) {

        return cadena.matches("[0-9]+");
    }

    //Método que es true si la cadena contiene números o puntos
    public static boolean contieneSoloNumerosYPunto(String cadena) {
        return cadena.matches("[0-9.]+");
    }

    //Método que devuelve true si la cadena es un número decimal o false en caso contrario
    public static boolean esDecimal(String cadena){
        int contador = 0;
        for (int x = 0; x < cadena.length(); x++) {
            char c = cadena.charAt(x);
            if(c=='.'){
                contador++;
            }
            if (c == '.' && x == 0) {
                return false;
            }
            if (c == '.' && x == cadena.length()-1) {
                return false;
            }
        }
        if(contador == 0){
            return false;
        }
        return true;
    }
}