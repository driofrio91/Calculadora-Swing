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

import static Controlador.Controlador.valorNumeros;
import Vista.Interfaz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author $Danny Riofrío Jiménez
 */
public class controladorNumerico extends Controlador implements ActionListener {

    private Interfaz vista;
    String valorFinal = "";

    public controladorNumerico(Interfaz vista) {
        super(vista);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String button = ((JButton) e.getSource()).getText();

        if (button.equals("CE")) {
            setValuePantalla(0);
            borrarCampos();

        } else if (button.equalsIgnoreCase("A")) {
            valorNumeros += button;
            setTextPantalla(valorNumeros);
        } else if (button.equalsIgnoreCase("B")) {
            valorNumeros += button;
            setTextPantalla(valorNumeros);
        } else if (button.equalsIgnoreCase("C")) {
            valorNumeros += button;
            setTextPantalla(valorNumeros);
        } else if (button.equalsIgnoreCase("D")) {
            valorNumeros += button;
            setTextPantalla(valorNumeros);
        } else if (button.equalsIgnoreCase("E")) {
            valorNumeros += button;
            setTextPantalla(valorNumeros);
        } else if (button.equalsIgnoreCase("F")) {
            valorNumeros += button;
            setTextPantalla(valorNumeros);
        } else {

            valorNumeros += button;
            try {
                setValuePantalla(Double.parseDouble(valorNumeros));
            } catch (NumberFormatException nfe) {
                setTextPantalla(valorNumeros);
            }
            


        }


        //setNumero1(super.get);


    }
}
