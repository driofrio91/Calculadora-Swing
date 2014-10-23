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
package Controlador;

import Modelo.Calc;
import Vista.CalcProgramador;
import Vista.Interfaz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author $Danny Riofrío Jiménez
 */
public class Controlador implements ActionListener {

    public final Interfaz vista;
    public Calc calc;
    private double numero1;
    private double numero2;
    //Variable con la que comparamos que operacion vamos a relaizar.
    private  int valor;
    private double total = 0;
    //VAriable para saber si tenemos un numetro decimal
    private boolean decimal = false;
    //Valor para almacenar los numeros que usaremos en la clase controladorNumerico
    public static String valorNumeros = "";
    //Constantes para realizar las operaciones
    private static final int op_SUMA = 1;
    private static final int op_RESTA = 2;
    private static final int op_MULTIPLICAION = 3;
    private static final int op_DIVISION = 4;
    private static final int op_RAIZ = 5;
    private static final int op_POTENCIA = 6;
    private static final int op_SENO = 7;
    private static final int op_COSENO = 8;
    private static final int op_TANGENTE = 9;
    ////////////////////////////////////////
    private static final String raiz = "√";
    private static final String potencia = "^";
    private static final String seno = "Sin";
    private static final String cos = "Cos";
    private static final String tan = "Tan";
    private static final String sum = "+";
    private static final String res = "-";
    private static final String mul = "*";
    private static final String div = "/";

    public Controlador(Interfaz vista) {
        this.vista = vista;
        calc = new Calc();

    }

    public void setSigno(int valor, String text) {

        this.valor= valor;
        
        try {
            setNumero1(((Number) vista.getPantalla().getValue()).doubleValue());
            vista.getPantalla().setText(text);
            restValor();
            decimal = false;
            
        } catch (Exception e) {
            setNumero1(0);
            vista.getPantalla().setText(text);
            restValor();
            decimal = false;
        }
        
    }

    public void getResultadoFinal() {

        setNumero2(((Number) vista.getPantalla().getValue()).doubleValue());

        if (valor == op_SUMA) {

            suma();

        } else if (valor == op_RESTA) {

            resta();

        } else if (valor == op_MULTIPLICAION) {

            multiplicacion();

        } else if (valor == op_DIVISION) {

            division();

        }
        if (valor == op_RAIZ) {

            restRaiz(numero1);

        } else if (valor == op_POTENCIA) {

            restPow(numero1, numero2);

        } else if (valor == op_SENO) {

            restSin(numero1);

        } else if (valor == op_COSENO) {

            restCos(numero1);

        } else if (valor == op_TANGENTE) {

            resTan(numero1);
        }
        borrarCampos();
    }

    public void restValor() {
        valorNumeros = "";
    }

    public double getNumero1() {
        return numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    public void setNumero1(double numero1) {
        this.numero1 = numero1;
    }

    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }

    public void setValuePantalla(double valor) {
        vista.getPantalla().setValue(valor);
        decimal = false;
    }

    public double getValuePantalla() {
        return (double) (vista.getPantalla().getValue());
    }

    public void setTextPantalla(String text) {
        vista.getPantalla().setText(text);
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void borrarCampos() {
        valorNumeros = "";
        numero1 = 0;
        numero2 = 0;
        decimal = false;
    }

    private void suma() {

        double n1 = numero1;
        double n2 = numero2;
        total = calc.suma(n1, n2);
        setValuePantalla(total);
        restValor();
    }

    private void resta() {

        double n1 = numero1;
        double n2 = numero2;
        total = calc.resta(n1, n2);
        setValuePantalla(total);
        restValor();
    }

    private void multiplicacion() {

        double n1 = numero1;
        double n2 = numero2;
        total = calc.multiplicacion(n1, n2);
        setValuePantalla(total);
        restValor();
    }

    private void division() {

        double n1 = numero1;
        double n2 = numero2;

        try {
            total = Double.parseDouble(calc.division(n1, n2));
            setValuePantalla(total);
            restValor();
        } catch (NumberFormatException nfe) {
            setTextPantalla(calc.division(n1, n2));
            restValor();
        }
    }

    public void setDecimal(boolean valor) {

        if (!isDecimal()) {

            if (valorNumeros.equals("")) {
                valorNumeros = "0.";
                setValuePantalla(Double.parseDouble(valorNumeros));
            } else {
                valorNumeros += ".";
                setValuePantalla(Double.parseDouble(valorNumeros));
            }

            decimal = valor;
        }
    }

    public boolean isDecimal() {
        return decimal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button = ((JButton) e.getSource()).getText();

        switch (button) {
            case sum:
               
                setSigno(op_SUMA, button);
                break;
            case res:
               
                setSigno(op_RESTA, button);
                break;
            case mul:
               
                setSigno(op_MULTIPLICAION, button);
                break;
            case div:
                
                setSigno(op_DIVISION, button);
                break;
            case "=":
                
                getResultadoFinal();
                break;
            case ".":
                setDecimal(true);
                break;
            case raiz:
                
                setSigno(op_RAIZ, button);
                break;
            case potencia:
                
                
                
                setSigno(op_POTENCIA, button);
                break;
            case seno:
               
                setSigno(op_SENO, button);
                break;
            case cos:
                
                setSigno(op_COSENO, button);
                break;
            case tan:
               
                setSigno(op_TANGENTE, button);
                break;

            default:

        }

    }

    public CalcProgramador obtenerPanelProg() {
        return vista.calcProg();
    }

    private void restRaiz(double n1) {

        double result = calc.raiz(n1);
        
        setValuePantalla(result);
        restValor();
    }

    private void restPow(double n1, double n2) {

        double result = calc.potencia(n1, n2);
        
        setValuePantalla(result);
        restValor();
    }

    private void restSin(double n1) {

        setValuePantalla(calc.seno(n1));
        restValor();
    }

    private void restCos(double n1) {
        setValuePantalla(calc.coseno(n1));
        restValor();
    }

    private void resTan(double n1) {
        setValuePantalla(calc.tangente(n1));
        restValor();
    }
}
