/*
 *Copyright [2013] [Danny Riofrio Jimenez]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package Modelo;

/**
 *
 * @author $Danny Riofrio Jimenez
 * @version 1.0
 *
 * Clase Calc donde estaran los metodos que realizen las operaciones
 * aritmeticas
 */
public class Calc {
    //Variable de tipo calculadora
    private static Calc instancia;
    /**
     * Constructor de Calc
     */
    public Calc() {
    }
    /**
     * Metodo que crea una instancia
     * 
     * Metodo que comprueba que no haya ninguna estancia de calculadora
     * para poder crear una nueva y asi devolver la instancia.
     * 
     * @return instancia
     */
    public static Calc getInstancia() {
        if (instancia == null) {
            instancia = new Calc();
        }
        return instancia;
    }

    /**
     * método que suma dos numeros.
     *
     * @param numero1 el primer valor introducido en el método
     * @param numero2 el segundo valor introducido en el método
     * @return nos devolverá el resultado de sumar numero1 y numero2
     */
    public double suma(double numero1, double numero2) {
        return numero1 + numero2;
        
    }

    /**
     * método que resta dos números.
     *
     * @param numero1 el primer valor introducido en el método
     * @param numero2 el segundo valor introducido en el método
     * @return nos devolverá el resultado de restar numero1 y numero2
     */
    public double resta(double numero1, double numero2) {
        return numero1 - numero2;
        
    }

    /**
     * método que multiplicara dos números.
     *
     * @param numero1 el primer valor introducido en el método
     * @param numero2 el segundo valor introducido en el método
     * @return nos devolverá el resultado de multiplicar numero1 y numero2
     */
    public double multiplicacion(double numero1, double numero2) {
        return numero1 * numero2;
        
    }

    /**
     * método que dividira dos números.
     *
     * @param numero1 el primer valor introducido en el método
     * @param numero2 el segundo valor introducido en el método
     * @return nos devolverá el resultado de dividir numero1 y numero2
     */
    public String division(double numero1, double numero2) {

        if (numero2==0) {
            return "no se puede dividir por 0";
        } else {
            double result = numero1 / numero2;
            return String.valueOf(result);
        }
    }

    /**
     * método que elevara el primer numero introducido al segundo.
     *
     * @param numero1 el primer valor introducido en el método, es el numero
     * base
     * @param numero2 el segundo valor introducido en el método, es el exponente
     * @return el resutado de elevar el primero numero introducido al metodo al
     * segundo a traves de la clase Math.
     * @see Math
     */
    public double potencia(double numero1, double numero2) {
        return Math.pow(numero1, numero2);
    }

    /**
     * método que elevara el primer numero introducido al segundo.
     *
     * @param numero numero que se sacara la razi de el
     * @return devuelve el resultado de sacar la raiz de numero1
     */
    public double raiz(double numero) {
        return Math.sqrt(numero);
        
    }

    /**
     * Metodo que nos sacara el seno del valor introducido
     *
     * @param numero valor del que se sacara el seno
     * @return Seno del numero introducido
     */
    public double seno(double numero) {
        return Math.sin(numero);
    }

    /**
     * Metodo que nos sacara el coseno del valor introducido
     *
     * @param numero valor del que se sacara el coseno
     * @return Coseno del valor introducido
     */
    public double coseno(double numero) {
        return Math.cos(numero);
    }

    /**
     * Metodo que nos sacara la tangente de valor introducido
     *
     * @param numero valor del que se obtendra la tangente
     * @return Tangente del valor introducidos
     */
    public double tangente(double numero) {
        return Math.tan(numero);
    }

    /**
     * Metodo que convierte un numero decimal a binario.
     *
     * Metodo en el que pasando un numero decimal en una cadena de texto nos
     * devolvera una cadena de texto con el numero convertido en binario.
     *
     * @param numero valor introducido que queremos convertir en binario.
     * @return valor introducido transformado a binario.
     */
    public String decimalBinario(String numero) {
        
        return Integer.toBinaryString(Integer.parseInt(numero));
        
    }

    /**
     * Metodo que convierte un numero decimal a Hexadecimal.
     *
     * Metodo en el que se le pasara un numero decimal en un cadena de texto y
     * nos devolvera una cadena de texto con nuestro numero convertido en
     * hexadecimal.
     *
     * @param numero valor introducido que queremos convertir en hexadecimal
     * @return valor introducido convertido en hexadecimal
     */
    public String decimalHex(String numero) {
        
        return Integer.toHexString(Integer.parseInt(numero));
    }

    /**
     * Metodo que convertir un numero decimal a octal.
     *
     * Metodo que se le pasara un numero decimal en una cadena de texto y nos
     * devolvera una cadena de texto con nuestro numero convertido en octal
     *
     * @param numero valor introducido que queremos convertir en octal
     * @return valor introducido convertido a octal
     */
    public String decimalOctal(String numero) {
        
        return Integer.toOctalString(Integer.parseInt(numero));
    }

    /**
     * Metodo que convertira un numero binario a decimal.
     *
     * Metodo que se le pasara un numero binario en una cadena de texto y nos
     * devolvera una cadena de texto con nuestro numero convertido en decimal.
     *
     * @param numero valor introducido que queremos convertir.
     * @return valor introducido convertido en decimal
     */
    public int binarioDecimal(String numero) {
        
        return Integer.parseInt(numero, 2);
    }

    /**
     * Metodo que convertira un numero binario a octal.
     *
     * Metodo que se le pasara un numero binario en una cadena de texto y nos
     * devolvera una cadena de texto con nuestro numero convertido en octal.
     *
     * @param numero valor introducido que queremos convertir.
     * @return valor introducido convertido en octal
     */
    public String binarioOctal(String numero) {
        
        return Integer.toOctalString(Integer.parseInt(numero, 2));
    }

    /**
     * Metodo que convertira un numero binario a hexadecimal.
     *
     * Metodo que se le pasara un numero binario en una cadena de texto y nos
     * devolvera una cadena de texto con nuestro numero convertido en
     * hexadecimal.
     *
     * @param numero valor introducido que queremos convertir.
     * @return valor introducido convertido en hexadecimal.
     */
    public String binarioHex(String numero) {
        
        return Integer.toHexString(Integer.parseInt(numero, 2));
    }

    /**
     * Metodo que convertira un numero octal a decimal.
     *
     * Metodo que se le pasara un numero octal en una cadena de texto y nos
     * devolvera una cadena de texto con nuestro numero convertido en decimal.
     *
     * @param numero valor introducido que queremos convertir.
     * @return valor introducido convertido en decimal
     */
    public int octalDecimal(String numero) {
        
        return Integer.parseInt(numero, 8);
    }

    /**
     * Metodo que convertira un numero octal a binario.
     *
     * Metodo que se le pasara un numero octal en una cadena de texto y nos
     * devolvera una cadena de texto con nuestro numero convertido en binario.
     *
     * @param numero valor introducido que queremos convertir.
     * @return valor introducido convertido en binario
     */
    public String octalBinario(String numero) {
        
        return Integer.toBinaryString(Integer.parseInt(numero, 8));
    }

    /**
     * Metodo que convertira un numero octal a hexadecimal.
     *
     * Metodo que se le pasara un numero octal en una cadena de texto y nos
     * devolvera una cadena de texto con nuestro numero convertido en
     * hexadecimal.
     *
     * @param numero valor introducido que queremos convertir.
     * @return valor introducido convertido en hexadecimal
     */
    public String octalHex(String numero) {
        
        return Integer.toHexString(Integer.parseInt(numero, 8));
    }

    /**
     * Metodo que convertira un numero hexadecimal a decimal.
     *
     * Metodo que se le pasara un numero hexadecimal en una cadena de texto y
     * nos devolvera una cadena de texto con nuestro numero convertido en
     * decimal.
     *
     * @param numero valor introducido que queremos convertir.
     * @return valor introducido convertido en decimal
     */
    public int hexDecimal(String numero) {
        
        return Integer.parseInt(numero, 16);
    }

    /**
     * Metodo que convertira un numero hexadecimal a binario.
     *
     * Metodo que se le pasara un numero hexadecimal en una cadena de texto y
     * nos devolvera una cadena de texto con nuestro numero convertido en
     * binario.
     *
     * @param numero valor introducido que queremos convertir.
     * @return valor introducido convertido en binario
     */
    public String hexBinario(String numero) {
        
        return Integer.toBinaryString(Integer.parseInt(numero, 16));
    }

    /**
     * Metodo que convertira un numero hexadecimal a octal.
     *
     * Metodo que se le pasara un numero hexadecimal en una cadena de texto y
     * nos devolvera una cadena de texto con nuestro numero convertido en octal.
     *
     * @param numero valor introducido que queremos convertir.
     * @return valor introducido convertido en octal
     */
    public String hexOctal(String numero) {
        
        return Integer.toOctalString(Integer.parseInt(numero, 16));
    }

    /**
     * Metodo que nos devolvera un booleano.
     *
     * Metodo que nos vevolvera un true si los dos parametros introducidos son
     * true
     *
     * @param a boolean
     * @param b boolean
     * @return Resultado booleano True | False
     */
    public boolean and(boolean a, boolean b) {
        return a && b;
    }

    /**
     * Metodo que nos devolvera un booleano.
     *
     * Metodo que nos devolvera un true si una de las dos variables introducidas
     * es true.
     *
     * @param a boolean
     * @param b boolean
     * @return Resultado booleano True | False
     */
    public boolean or(boolean a, boolean b) {
        return a || b;
    }

    /**
     * Metodo que nos devolvera un booleano
     *
     * Metodo que nos devolvera un true si los valores introducidos son
     * diferentes entre si
     *
     * @param a boolean
     * @param b boolean
     * @return Resultado booleano True | False
     */
    public boolean xor(boolean a, boolean b) {
        return a ^ b;
    }

    /**
     * Metodo que nos devolvera un booleano
     *
     * Metodo que nos devolvera un booleano contrario al introducido
     *
     * @param a boolean
     * @return Resultado booleano True | False
     */
    public boolean not(boolean a) {
        return !a;
    }
}
