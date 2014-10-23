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
import Vista.Interfaz;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 *
 * @author $Danny Riofrío Jiménez
 */
public class ControladorCalcProgramador extends Controlador {

    private final static String  AND = "AND";
    private final static String XOR = "XOR";
    private final static String OR = "OR";
    private final static String NOT = "NOT";
    //valor booleano para los campos de verdad
    private boolean primerBoolena;
    private boolean segundoBoolean;
    //Valor del operacion
    private String valorOperacion = "";

    public ControladorCalcProgramador(Interfaz vista) {
        super(vista);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String valor = ((JButton) e.getSource()).getText();

        switch (valor) {
            case "=":
                resultado();
                break;
            default:
                valorOperacion = valor;
                primerValor();

        }
    }

    public void primerValor() {
        int n1 = (int) super.getValuePantalla();
        if (n1 == 0) {
            primerBoolena = false;
        } 
        if (n1 == 1){
            primerBoolena = true;
        }
        super.borrarCampos();
        super.setTextPantalla("");

    }

    public void resultado() {
        
        int n2 = (int) super.getValuePantalla();
        if (n2 == 0) {
            segundoBoolean = false;
        } 
        if(n2 == 1){
            segundoBoolean = true;
        }

        switch (valorOperacion) {
            case AND:
                and(primerBoolena, segundoBoolean);
                break;
            case XOR:

                xor(primerBoolena, segundoBoolean);
                break;
            case OR:
                or(primerBoolena, segundoBoolean);
                break;
            case NOT:
                not(primerBoolena);
                break;
            default:
        }
    }

    public void and(boolean n1, boolean n2) {

        boolean result = calc.and(n1, n2);

        super.setTextPantalla(String.valueOf(result));
    }

    public void xor(boolean n1, boolean n2) {

        boolean result = calc.xor(n1, n2);
        System.out.println(result);
        super.setTextPantalla(String.valueOf(result));
    }

    public void or(boolean n1, boolean n2) {
        boolean result = calc.or(n1, n2);

        super.setTextPantalla(String.valueOf(result));
    }

    public void not(boolean n1) {

        boolean result = calc.not(n1);

        super.setTextPantalla(String.valueOf(result));
    }
}
