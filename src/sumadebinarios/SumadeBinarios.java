/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumadebinarios;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Soledad Moraga
 */
public class SumadeBinarios {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<String> Sumatorias= new ArrayList();
    public static void main(String[] args) 
    {
        //INGRESO DE BINARIOS
        Scanner Lector=new Scanner(System.in);
        System.out.println("Ingrese cantidad de números binarios a ingresar");
        int cantidad = Lector.nextInt();
        ArrayList<String> binario = new ArrayList<String>();
        for(int i=0;i<cantidad;i++)
        {
            System.out.println("Ingrese número");
            String numero = Lector.next();
            binario.add(numero);
        }
        //Muestra valores totales
        int decimal = Sumatoria(binario);     
        System.out.println(Sumatorias);
        System.out.println("Total:  " + decimal);
    }
    
    public static int Sumatoria( ArrayList<String> numeros )
    {    
        ArrayList<Integer> valores = new ArrayList<Integer>();
        ArrayList<Integer> valoresFinales = new ArrayList();
        int valorFinal=0;
        
        for (int i = 0; i < numeros.size(); i++) 
        {
            String cadena = numeros.get(i);
            int valor=0;
            int decimal =0;
            int potencia=0; 
            int SumatoriaBinario = 0;
            //INVERTIR CADENA / CONVERSIÓN A ENTERO
            //Se utiliza el método length() -1 porque las cadenas son numeradas desde 0 a N
            for (int x=cadena.length()-1;x>=0;x--)
            {
                decimal=0;
                valor = Integer.parseInt("" + cadena.charAt(x));
                if(valor!=0){
                    decimal =(int)Math.pow((valor*2),potencia);
                }
                valores.add(decimal);
                potencia++;
            }
            //SUMA DE VALORES DE LA CADENA[i]
            for (int z=0;z<valores.size();z++)
            {
                 SumatoriaBinario= SumatoriaBinario + valores.get(z);
            }
            //AGREGAR TOTAL DE SUMATORIA DE CADENA DE VALOR i
            Sumatorias.add(""+SumatoriaBinario);
            valoresFinales.add(SumatoriaBinario);    
            valores.clear();
        }
        //SUMA DE TODOS LOS VALORES DE TODAS LAS CADENAS
        for (int z=0;z<valoresFinales.size();z++)
        {
             valorFinal=valorFinal + valoresFinales.get(z);
        }
        return valorFinal;   
    }
}
