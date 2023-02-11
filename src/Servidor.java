import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        int numeroPuerto = 6000;  //Utilizamos el puerto 6000 para conectar Servidor con Cliente
        ServerSocket servidor = new ServerSocket(numeroPuerto);  //Asignamos el puerto 6000 al socket

        String boton="", numero="";
        System.out.println("Esperando conexion...");

        Socket clienteConectado = servidor.accept(); //Se establece con éxito la conexión entre el Servidor y el Cliente
        System.out.println("Cliente conectado...");

        // Creo flujo de salida al Cliente
        PrintWriter cadenaEnviada = new PrintWriter
                (clienteConectado.getOutputStream(),true);

        // Creo flujo de entrada del Cliente
        BufferedReader cadenaRecibida = new BufferedReader
                (new InputStreamReader(clienteConectado.getInputStream()));


        while(boton != null && numero != null) {

            boton = cadenaRecibida.readLine();
            numero = cadenaRecibida.readLine();


            switch(boton) {
                case "CJ":
                    CJ(numero);
                    cadenaEnviada.println(CJ(numero));
                    break;
                case "X":
                    cadenaEnviada.println(X(numero));
                    break;
                case "PR":
                    cadenaEnviada.println(PR(numero));
                    break;
                case "R":
                    cadenaEnviada.println(R(numero));
                    break;
                case "*":     //Si el botón recibido del Cliente es * le enviamos un END para que se cierre el Cliente, y luego procedemos a cerrar el Servidor
                    cadenaEnviada.println("END!");
                    break;
                default:
                    System.out.println("Por favor, introduzca una opción válida");
            }

            if(boton.equals("*"))
                break;

        }

        System.out.println("Cerrando conexion...");

        //Cerramos Streams y Sockets

        cadenaRecibida.close();
        cadenaEnviada.close();
        clienteConectado.close();
        servidor.close();
    }


    //Método que recibe un número en metros cuadrados y calcula a cuantos campos de fútbol equivale
    private static String CJ(String cadena){
        double resultado = Double.parseDouble(cadena)/7140;
        double resultadoFinal = Math.round(resultado*100d)/100d;
        return "La superficie en metros cuadrados introducida por usted equivale a "+String.valueOf(resultadoFinal)+" campos de fútbol.";
    }


    //Método que recibe un número de meses trabajados y calcula cuántos meses quedan por cotizar para llegar a 450 meses (que da derecho a la pensión completa)
    private static String X(String cadena){
        int meses = Integer.parseInt(cadena);
        int resultado = 0;
        if(meses<450) {
            resultado = 450 - meses;
            return "Le quedan por cotizar "+String.valueOf(resultado)+" meses.";
        }else {
            return "Usted ya puede jubilarse cobrando la pensión completa";
        }
    }


    //Método que recibe un número y lo divide entre el número total de obras de Pérez Reverte.
    private static String PR(String cadena){
        double cociente = (Double.parseDouble(cadena)/51);
        double resultado = Math.round(cociente*100d)/100d;
        String resultadoCadena = String.valueOf(resultado);

        return resultadoCadena;
    }

    //Método que recibe un precio por litro de gasolina y calcula la diferencia respecto al precio más barato de la gasolina en toda la ciudad de Vigo
    private static String R(String cadena){
        double precio = Double.parseDouble(cadena);
        double barata = 1.517;

        if(precio>barata) {
            double resultado = precio - barata;
            double resultadoFinal = Math.round(resultado * 100d) / 100d;
            return "La diferencia de precio entre la gasolina que ha pagado usted y la gasolina más barata de Vigo es " + String.valueOf(resultadoFinal) + " euros/litro";
        }
        else if(precio == barata) {
            return "El precio que usted ha pagado coincide con el precio más barato de la gasolina en Vigo";
        }
        else{
            return "El precio que usted ha introducido es erróneo, ya que está por debajo del precio más barato de la gasolina en Vigo (que es 1.517 euros/litro)";
        }

    }

}
