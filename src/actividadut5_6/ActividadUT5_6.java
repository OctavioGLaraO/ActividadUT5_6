/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadut5_6;

import java.io.File;

/**
 *
 * @author Octavio Lara
 */
public class ActividadUT5_6 {//Clase ActividadUT5_6

    private static int contTXT=0,contJAVA=0,contCLASS=0;//Declaracion de variables a usar
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {//main
        File archivoOrigen=new File("MiDir");//Instancia archivoOrigen de la clase File con la ruta del directorio MiDir
        Estadistica(archivoOrigen);//Ejecutamos el metodo Estadistica con parametro el File archivoOrigen
        System.out.println("Extensiones: .txt: "+contTXT+", .java: "+contJAVA+" y .class: "+contCLASS);//Mostramos los resultados obtenidos
    }//Cierre del main
   
    public static void Estadistica(File entrada){//Metodo Estadistica con parametro el objecto File entrada
        String []lista=entrada.list();//En un array Srting llamado lista se almacena un String obtenido por el metodo list del objecto File entrada
        for (String e : lista) {
            int index=e.lastIndexOf('.');//Se obtiene la posicion del "." atraves del metodo lastIndexOf del String e
            if("txt".equals(e.substring(index+1))){//Se compara las diferentes extensiones con el substring obtenido atraves del index+1
                contTXT++;//Por cada comparacion hay un contador de la extension correspondiente
            }else{
                if("java".equals(e.substring(index+1))){
                    contJAVA++;
                }else{
                    if("class".equals(e.substring(index+1))){
                        contCLASS++;
                    }else{
                        if(!e.contains(".")){//Todo String obtenido de la lista del File entrada que no contenga "." es un directorio
                            File temporal=new File(entrada.getAbsolutePath()+"\\"+e);//Se genera otra instancia File la cual se obtendra con la ruta conseguida con el metodo getAbsolutePath con la concatenacion de "\\" mas el substring e
                            Estadistica(temporal);//RECURSIVIDAD DEL METODO   
                        }//Cierre del if
                    }//Cierre del if-else
                }//Cierre del if-else
            }//Cierre del if-else
        }//Cierre del for
    }//Cierre del Metodo  
}//Cierre de la clase
