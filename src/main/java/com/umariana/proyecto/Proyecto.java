/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.umariana.proyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import mundo.Alumno;

/**
 *
 * @author Angel
 */
public class Proyecto {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        
        //esta permite leer la opcion de usuario
        Scanner lector= new Scanner(System.in);
        
        // bandera que permite terminar el programa
        boolean activo=true;
        ArrayList<Alumno> misAlumnos = new ArrayList<>();
        lecturaArchivo (misAlumnos);
        do{
            menu();
        
        int opcion= lector.nextInt();
        
        lector.nextLine();
            //se utiliza el if para seleccion de cada opcion
            switch (opcion) {
                case 1:
                    
                    meterAlumno(misAlumnos, lector);
                    escribirArchivo(misAlumnos);
                    
                    break;
                case 2:
                     eliminAlumno(misAlumnos, lector);
                     escribirArchivo(misAlumnos);
 
                    break;
                case 3:
                    
                    modificarAlumno(misAlumnos, lector);
                    escribirArchivo(misAlumnos);

                    break;
                case 4:
                    // muestra el alumno con sus datos con un for pero primero va un if que indica si no hay registros
                    
                    consultarAlumno(misAlumnos,lector);
                    escribirArchivo(misAlumnos);
                    
                    break;
                
                
                    
                case 5:
                    
                     System.out.println("= PROCESO TERMINADO =");
                    //activamos la bandera para que se termine el bucle do
                    activo = false;

                    break;
                default:
                    System.out.println("Selecciona una de las opciones que hay en el menu");
                    break;
            }
        }
        while (activo);   
    }    
        public static void menu (){
        System.out.println("------ Menu de opciones -------!");
        System.out.println("1.      Insertar alumno");
        System.out.println("2.      Eliminar alumno");
        System.out.println("3.      Modificar alumno");
        System.out.println("4.      Consultar alumno");
        System.out.println("5.      Terminar Programa");
        System.out.println("--------------------------------");
        
    }
        
        
        
    
    //caso1
    /**
    * Permite agregar un nuevo alumno a la lista de alumnos.
    * @param misAlumnos La lista de alumnos en la que se va a agregar el nuevo alumno.
    * @param lector Un objeto Scanner para leer la entrada del usuario.
    */
    public static void meterAlumno(ArrayList<Alumno> misAlumnos,Scanner lector) {
        System.out.println("Introduce la cedula del alumno");
                    float cedula= lector.nextFloat();
                    
                    System.out.println("Introduce el nombre del alumno");
                    String nombre= lector.next();
                    
                    System.out.println("Introduce el apellido del alumno");
                    String apellido= lector.next();
                    
                    System.out.println("Introduce el semestre del alumno");
                    int semestre= lector.nextInt();

                    System.out.println("Introduce el celular del alumno");
                    float celular= lector.nextFloat();
                    
                    System.out.println("Introduce el correo del alumno");
                    String correo= lector.next();
                    
                    Alumno a= new Alumno();
                    
                    //se crea un objeto para guardar la informacion de un alumno
                    a.setCedula(cedula);
                    a.setNombre(nombre);
                    a.setApellido(apellido);
                    a.setSemestre(semestre);
                    a.setCelular(celular);
                    a.setCorreo(correo);
                    
                    //se agrega el valor del objeto al listArray
                    
                    misAlumnos.add(a);
    }
    
    //2caso
    /**
    * Permite eliminar un alumno de la lista de alumnos por su numero de cedula.
    * @param misAlumnos La lista de alumnos en la que se busca y elimina el alumno.
    * @param lector Un objeto Scanner para leer la entrada del usuario.
    */
    public static void eliminAlumno(ArrayList<Alumno> misAlumnos,Scanner lector) {
        if (misAlumnos.isEmpty()){
                        System.out.println("Aun no hay alumnos registrados.");
                    }else{
                    System.out.println("Ingresa la cedula del alumno que se quiere eliminar:");
                    int cedulaDelete = lector.nextInt();
                    
                    // Variable para saber si se encontro al alumno
                    boolean alumnoEncontrado = false; 
                    
                    
                    for (Alumno alumno : misAlumnos) {
                        if (alumno.getCedula() == cedulaDelete) {
                            // Se encontro al alumno con la cedula
                            alumnoEncontrado = true; 
                            

                            // Remover el alumno del ArrayList
                            misAlumnos.remove(alumno);

                            System.out.println("El alumno fue eliminado de los registros.");
                            break; 
                            // Sale del bucle, porque se elimino al alumno
                        }
                    }
                }
    }
    
    //caso3
    /**
    * Permite modificar la infor de un alumno en la lista de alumnos por su numero de cedula.
    * @param misAlumnos La lista de alumnos en la que se busca y modifica el alumno.
    * @param lector Un objeto Scanner para leer la entrada del usuario.
    */
    public static void modificarAlumno(ArrayList<Alumno> misAlumnos,Scanner lector) {
        //el if es para verificar si no hay datos en los reportes saldra una excepcion
        if (misAlumnos.isEmpty()){
                System.out.println("Todavia no hay alumnos registrados.");
                }else{
                //se busca al alumno por su cedula
                System.out.println("Ingresa la cedula del alumno que se quiere modificar.");
                float cedulaModificar = lector.nextFloat();
                //corrobora al alumno con esa cedula se activa
                boolean alumnoEncontrado = false; 
                    

                    for (Alumno alumno : misAlumnos) {
                        if (alumno.getCedula() == cedulaModificar) {
                            
                            //encontro al alumno con la cedula entra
                            alumnoEncontrado = true; 
                            
                            // Modificar la informacion del alumno
                            
                            System.out.println("Ingrese la nueva cedula:");
                            float nuevaCedula= lector.nextFloat();
                            lector.nextLine();
                            
                            System.out.println("Ingrese el nuevo nombre:");
                            String nuevoNombre = lector.nextLine();
                            
                            
                            System.out.println("Ingrese el nuevo apellido:");
                            String nuevoApellido = lector.nextLine();
                            
                            System.out.println("Ingrese el nuevo semestre:");
                            int nuevoSemestre= lector.nextInt();
                            
                            System.out.println("Ingrese el nuevo celular:");
                            float nuevoCelular= lector.nextFloat();
                            lector.nextLine();
                            
                            System.out.println("Ingrese el nuevo correo:");
                            String nuevoCorreo = lector.nextLine();
                            
                            
                            // Actualiza la informacion del alumno
                            alumno.setCedula(nuevaCedula);
                            alumno.setNombre(nuevoNombre);
                            alumno.setApellido(nuevoApellido);
                            alumno.setSemestre(nuevoSemestre);
                            alumno.setCelular(nuevoCelular);
                            alumno.setCorreo(nuevoCorreo);
                           

                            System.out.println("La informacion del alumno ha sido modificada.");
                            break; 
                            // Salir del bucle, ya que se modifico al alumno
                        }
                    }
            }
    }
    
    //caso4
    /**
    * Muestra la información de todos los alumnos en la lista de alumnos
    * @param misAlumnos La lista de alumnos de la que se obtiene la info
    * @param lector Un objeto Scanner para leer la entrada
    */
    public static void consultarAlumno(ArrayList<Alumno> misAlumnos,Scanner lector) {
        //if que revisa si no hay alumnos
        if (misAlumnos.isEmpty()){
            System.out.println("No hay alumnos jajaj");                    
                               
            
        }else{    
            System.out.println("             Lista");                    
            // muestra el alumno con sus datos con un for                             
            for (Alumno alumno : misAlumnos){
                System.out.println("---------------------------------------"); 
                System.out.println(" Cedula: "+ alumno.getCedula());
                System.out.println(" Nombre: " + alumno.getNombre());
                System.out.println(" Apellido: "+ alumno.getApellido());
                System.out.println(" Semestre: "+ alumno.getSemestre());
                System.out.println(" Celular: "+ alumno.getCelular());
                System.out.println(" Correo: "+ alumno.getCorreo());
                System.out.println("---------------------------------------"); 
            }  
        }
    }
    
    
    public static void escribirArchivo(ArrayList<Alumno> misAlumnos) throws FileNotFoundException {
        
            try {
                //los datos se van a almacenar en esta direccion
                File archivo = new File ("./data/miReporte.txt");
                PrintWriter pluma = new PrintWriter(archivo); 

                
                    for (Alumno alumno : misAlumnos) {
                        String datosEstudiante = alumno.getCedula() + "," + alumno.getNombre() + "," + alumno.getApellido() + ","
                        + alumno.getSemestre() + "," + alumno.getCelular() + "," + alumno.getCorreo();

                        pluma.println(datosEstudiante);
                    }
                    pluma.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            
    }
    
    public static void lecturaArchivo(ArrayList<Alumno> misAlumnos) throws FileNotFoundException, IOException {
        try {
        //coge la misma direccion en la que escribe    
        File archivo = new File ("./data/miReporte.txt");
            //FileReader y BufferedReader para leer el archivo
            FileReader fr = new FileReader (archivo);
            BufferedReader lector = new BufferedReader(fr);            
            String salto;
            // Lee linea por linea del archivo y agregar los datos a la lista de alumnos y asi la puede separar con la coma
            while ((salto = lector.readLine()) != null) {
                String[] partes = salto.split(",");
                float Cedula = Float.parseFloat(partes[0]);
                String Nombre = partes[1];
                String Apellido = partes[2];
                int Semestre = Integer.parseInt(partes[3]);
                float Celular = Float.parseFloat(partes[4]);
                String Correo = partes[5];
                
                //aqui guarda los datos de los alumnos
                Alumno alumno = new Alumno (Cedula, Nombre, Apellido, Semestre, Celular, Correo);
                misAlumnos.add(alumno);
            }
            //cierre del lector
            lector.close();
            
        } catch (Exception e) {
        }
    }
}
