/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg2;


import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Diego
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {

        Consultador adminPostgres = new Consultador();

        // Conecto con la base de datos
        adminPostgres.conectar();
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; // Guardo opción del usuario

        while (!salir) {

            System.out.println("1. Crear nueva tabla");
            System.out.println("2. Insertar datos en tabla");
            System.out.println("3. Listar datos tabla");
            System.out.println("4. Listar datos tabla - Filtro por ID");
            System.out.println("5. Listar datos tabla - Filtro por dato");
            System.out.println("6. Ejecutar consultas de prueba");
            System.out.println("7. Salir");

            try {

                System.out.println("Ingrese una opción: ");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("*** CREAR NUEVA TABLA ***");
                        Scanner inputDatosCrearTabla = new Scanner(System.in);
                        String datosNuevaTabla[] = new String[3];
                        System.out.println("Ingresa nombre de la nueva tabla: ");
                        datosNuevaTabla[0] = inputDatosCrearTabla.nextLine();
                        System.out.println("Ingresa nombre de clave primaria para la tabla:  ");
                        datosNuevaTabla[1] = inputDatosCrearTabla.nextLine();
                        System.out.println("Ingresa nombre del dato: ");
                        datosNuevaTabla[2] = inputDatosCrearTabla.nextLine();
                        adminPostgres.crearTablaPersonalizada(datosNuevaTabla[0], datosNuevaTabla[1], datosNuevaTabla[2]);
                        break;
                    case 2:
                        System.out.println("*** INSERTAR DATOS EN TABLA ***");
                        Scanner inputDatosInsertarEnTabla = new Scanner(System.in);
                        String datosNuevaFila[] = new String[3];
                        System.out.println("Ingresa nombre de la tabla destino: ");
                        datosNuevaFila[0] = inputDatosInsertarEnTabla.nextLine();
                        System.out.println("Ingresa nombre columna: ");
                        datosNuevaFila[1] = inputDatosInsertarEnTabla.nextLine();
                        System.out.println("Ingresa dato: ");
                        datosNuevaFila[2] = inputDatosInsertarEnTabla.nextLine();
                        adminPostgres.insertarDatosTabla(datosNuevaFila[0], datosNuevaFila[1], datosNuevaFila[2]);
                        break;
                    case 3:
                        System.out.println("*** LISTAR DATOS EN TABLA ***");
                        Scanner inputDatosListarEnTabla = new Scanner(System.in);
                        String datosListar[] = new String[3];
                        System.out.println("Ingresa nombre de la tabla: ");
                        datosListar[0] = inputDatosListarEnTabla.nextLine();
                        System.out.println("Ingresa nombre columna ID: ");
                        datosListar[1] = inputDatosListarEnTabla.nextLine();
                        System.out.println("Ingresa nombre columna dato: ");
                        datosListar[2] = inputDatosListarEnTabla.nextLine();
                        adminPostgres.listarDatosTabla(datosListar[0], datosListar[1], datosListar[2]);
                        break;
                    case 4:
                        System.out.println("*** LISTAR DATOS TABLA - FILTRO POR ID ***");
                        Scanner inputDatosFiltrarTablaId = new Scanner(System.in);
                        String datosFiltrarId[] = new String[4];
                        System.out.println("Ingresa nombre de la tabla: ");
                        datosFiltrarId[0] = inputDatosFiltrarTablaId.nextLine();
                        System.out.println("Ingresa nombre columna ID: ");
                        datosFiltrarId[1] = inputDatosFiltrarTablaId.nextLine();
                        System.out.println("Ingresa nombre columna dato: ");
                        datosFiltrarId[2] = inputDatosFiltrarTablaId.nextLine();
                        System.out.println("Ingresa clave que desea buscar: ");
                        datosFiltrarId[3] = inputDatosFiltrarTablaId.nextLine();
                        adminPostgres.filtrarTablaPorID(datosFiltrarId[0], datosFiltrarId[1], datosFiltrarId[2], datosFiltrarId[3]);
                        break;
                    case 5:
                        System.out.println("*** LISTAR DATOS TABLA - FILTRO POR DATO ***");
                        Scanner inputDatosFiltrarTablaDato = new Scanner(System.in);
                        String datosFiltrarDato[] = new String[4];
                        System.out.println("Ingresa nombre de la tabla: ");
                        datosFiltrarDato[0] = inputDatosFiltrarTablaDato.nextLine();
                        System.out.println("Ingresa nombre columna ID: ");
                        datosFiltrarDato[1] = inputDatosFiltrarTablaDato.nextLine();
                        System.out.println("Ingresa nombre columna dato: ");
                        datosFiltrarDato[2] = inputDatosFiltrarTablaDato.nextLine();
                        System.out.println("Ingresa dato que desea usar como filtro: ");
                        datosFiltrarDato[3] = inputDatosFiltrarTablaDato.nextLine();
                        adminPostgres.filtrarTablaPorID(datosFiltrarDato[0], datosFiltrarDato[1], datosFiltrarDato[2], datosFiltrarDato[3]);
                        break;
                    case 6:
                        adminPostgres.ejecutarPruebas();
                        break;
                    case 7:
                        salir = true;
                        break;
                    default:
                        System.out.println("Ingrese números entre 1 y 7");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número entre 1 y 7");
                sn.next();
            }
        }

    }
}
