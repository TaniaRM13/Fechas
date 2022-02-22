/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fechas;

import java.util.Scanner;

/**
 *
 * @author Tania
 */
public class Fechas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num = getNumero();
        int mes = getMes();
        diaValido(num,mes);
        int ano = getAno();
        String numero = unDigito(num);
        String month = unDigito(mes);
        
        System.out.println("La fecha ingresada es: "+numero+"/"+month+"/"+ano);
    }
    
    public static int getNumero(){
        Scanner get = new Scanner(System.in);
        System.out.println("Ingrese el número de día:");
        int num = get.nextInt();
        return num;
    }
    
    public static String unDigito(int num){
        String numS = String.valueOf(num);
        if(numS.length()==1){
            numS = "0"+numS;
        }
        return numS;
    }
    
    public static int getMes(){
        int mesNum = 0;
        Scanner get = new Scanner(System.in);
        System.out.println("Ingrese el mes:");
        String mes = get.next();
        mes = mes.toLowerCase();
        if(numerico(mes)){
            mesNum = Integer.parseInt(mes);
        }else{
            mesNum = convertirMes(mes);
        }
        if(mesNum<1 || mesNum>12){
            throw new ArithmeticException("El mes que ingresaste no existe o tiene alguna falta de ortografía.");
        }
        return mesNum;
    }
    
    public static int getAno(){
        Scanner get = new Scanner(System.in);
        System.out.println("Ingrese el año:");
        int ano = get.nextInt();
        return ano;
    }
    
    public static boolean numerico(String mes){
        if(mes==null){
            return false;
        }
        try{
            double x = Double.parseDouble(mes);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    
    public static int convertirMes(String mes){
        int mesNum = 0;
        switch(mes){
            case "enero":
                mesNum = 1;
                break;
            case "febrero":
                mesNum = 2;
                break;
            case "marzo":
                mesNum = 3;
                break;
            case "abril":
                mesNum = 4;
                break;
            case "mayo":
                mesNum = 5;
                break;
            case "junio":
                mesNum = 6;
                break;
            case "julio":
                mesNum = 7;
                break;
            case "agosto":
                mesNum = 8;
                break;
            case "septiembre":
                mesNum = 9;
                break;
            case "octubre":
                mesNum = 10;
                break;
            case "noviembre":
                mesNum = 11;
                break;
            case "diciembre":
                mesNum = 12;
                break;
        }
        return mesNum;
    }
    
    public static void diaValido(int num, int mes){
        if(mes==2){
            if(num<1 || num>28){
                throw new ArithmeticException("La fecha ingresada no existe");
            }
        }else if(mes==4 || mes==6 || mes==9 || mes==11){
            if(num<1 || num>30){
                throw new ArithmeticException("La fecha ingresada no existe");
            }
        }else{
            if(num<1 || num>31){
                throw new ArithmeticException("La fecha ingresada no existe");
            }
        }
    }
}
