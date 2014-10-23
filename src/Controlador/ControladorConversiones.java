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

import Vista.CalcProgramador;
import Vista.Interfaz;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JRadioButton;


/**
 *
 * @author $Danny Riofrío Jiménez
 */
public class ControladorConversiones extends Controlador {
    //Iniciamos la veriable que alamacenara el valor del radio pulsado
    //al RaioButton por defecto

    private String actualRadio = "Dec";
    private CalcProgramador calcProg;

    public ControladorConversiones(Interfaz vista) {
        super(vista);
        calcProg = obtenerPanelProg();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String radio = ((JRadioButton) e.getSource()).getText();



        switch (radio) {
            case "Hex":
                actualRadio = "Hex";
                hex(actualRadio);

                break;

            case "Dec":
                dec(actualRadio);
                actualRadio = "Dec";
                break;
            case "Oct":
                oct(actualRadio);
                actualRadio = "Oct";
                break;
            case "Bin":
                bin(actualRadio);
                actualRadio = "Bin";
                break;
        }
    }

    public void dec(String actualRadio) {

        String n1 = vista.getPantalla().getText();

        switch (actualRadio) {
            case "Hex":
                //hex a dec
                hexDec(n1);

                break;

            case "Dec":

                break;
            case "Oct":
                octDec(n1);
                break;
            case "Bin":
                binDec(n1);
                break;
        }
    }

    public void hex(String actualRadio) {

        String n1 = vista.getPantalla().getText();

        double n1Double;
        try {
            n1Double = (double) vista.getPantalla().getValue();
        } catch (ClassCastException e) {
            n1Double = 0;
        }

        switch (actualRadio) {
            case "Hex":
                decHex(n1Double);
                break;

            case "Dec":

                break;
            case "Oct":

                octHex(n1);

                break;
            case "Bin":

                binHex(n1);
                break;
        }
    }

    public void oct(String actualRadio) {
        double n1Double;
        try {
            n1Double = (double) vista.getPantalla().getValue();
        } catch (ClassCastException e) {
            n1Double = 0;
        }


        String n1String = vista.getPantalla().getText();

        switch (actualRadio) {
            case "Hex":

                hexOct(n1String);

                break;

            case "Dec":
                decOc(n1Double);

                break;
            case "Oct":

                break;
            case "Bin":
                binOct(n1String);
                break;
        }
    }

    public void bin(String actualRadio) {

        double n1Double;
        try {
            n1Double = (double) vista.getPantalla().getValue();
        } catch (ClassCastException e) {
            n1Double = 0;
        }

        String n1String = vista.getPantalla().getText();

        switch (actualRadio) {
            case "Hex":

                hexBin(n1String);
                break;

            case "Dec":
                decBin(n1Double);
                break;
            case "Oct":
                octBin(n1String);
                break;
            case "Bin":

                break;
        }
    }

    public void decHex(double numero) {
        
        System.out.println(numero);
        String n1 = String.valueOf((int) numero);
        //Mostramos el resultado
        String result = calc.decimalHex(replacePoints(cutComma(n1)));
        setTextPantalla(result);
        borrarCampos();
    }

    public void decOc(double numero) {

        String n1 = String.valueOf((int) numero);
        //Mostramos el resultado
        String result = calc.decimalOctal(replacePoints(cutComma(n1)));
        setTextPantalla(result);
        borrarCampos();
    }

    public void decBin(double numero) {

        String n1 = String.valueOf((int) numero);
        //Mostramos el resultado
        String result = calc.decimalBinario(replacePoints(cutComma(n1)));
        setTextPantalla(result);
        borrarCampos();
    }

    public void hexDec(String numero) {

        
        //Mostramos el resultado
        int result = calc.hexDecimal(replacePoints(cutComma(numero)));
        setValuePantalla(result);
        borrarCampos();
    }

    public void hexOct(String numero) {

        //Mostramos el resultado
        String result = calc.hexOctal(replacePoints(cutComma(numero)));
        setTextPantalla(result);
        borrarCampos();
    }

    public void hexBin(String numero) {

        //Mostramos el resultado
        String result = calc.hexBinario(replacePoints(cutComma(numero)));
        setTextPantalla(result);
        borrarCampos();
    }

    public void octDec(String numero) {


        //Mostramos el resultado
        int result = calc.octalDecimal(replacePoints(cutComma(numero)));
        setValuePantalla(result);
        borrarCampos();
    }

    public void octHex(String numero) {

        //Mostramos el resultado
        System.out.println(numero);
        String result = calc.octalHex(replacePoints(cutComma(numero)));
        setTextPantalla(result);
        borrarCampos();
    }

    public void octBin(String numero) {

        //Mostramos el resultado
        String result = calc.octalBinario(replacePoints(cutComma(numero)));
        setTextPantalla(result);
        borrarCampos();
    }

    public void binDec(String numero) {
        System.out.println(numero);

        //Mostramos el resultado
        int result = calc.binarioDecimal(replacePoints(cutComma(numero)));
        setValuePantalla(result);
        borrarCampos();
    }

    public void binHex(String numero) {

        
        //Mostramos el resultado
        String result = calc.binarioHex(replacePoints(cutComma(numero)));
        setTextPantalla(result);
        borrarCampos();
    }

    public void binOct(String numero) {

       
        //Mostramos el resultado
        String result = calc.binarioOctal(replacePoints(cutComma(numero)));
        setTextPantalla(result);
        borrarCampos();
    }

    /**
     * 
     * @param cadena
     * @return 
     */
    public String replacePoints(String cadena) {
        return cadena.replace(".", "");
    }

    /**
     * 
     * @param cadena
     * @return 
     */
    public String cutComma(String cadena) {
        
        int coma = cadena.indexOf(",");

        String nTemp;

        if (coma == -1) {
            nTemp = cadena;
        } else {
            nTemp = cadena.substring(0, coma);
        }
        return nTemp;
    }
}
