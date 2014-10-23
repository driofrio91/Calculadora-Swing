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
package Vista;

import Controlador.Controlador;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author $Danny Riofrío Jiménez
 */
public class CalcCientifica extends CalcEstandar {

    private ResourceBundle bundle;
    private JPanel calcCientifica;
    private JButton btPotencia, btRaiz, btSeno, btCoseno, btTangente;
   

    public CalcCientifica(Interfaz interfaz, ResourceBundle bundle) {
        super(interfaz, bundle);
        this.bundle = bundle;
        
        
       
    }

    public JPanel consCalcCientifica() {

        calcCientifica = consCalcEstandar();
        //Como ya tengo un layout definido en la calculadora estandar no le establezcon en esta
        GridBagConstraints c;

        btPotencia = new JButton(bundle.getString("calcCientifica_Pow"));
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipadx = 20;
        c.ipady = 20;
        btPotencia.setVisible(false);
        calcCientifica.add(btPotencia, c);
        btPotencia.addActionListener(controlador);
        

        btRaiz = new JButton(bundle.getString("calcCientifica_Raiz"));
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 5;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipady = 20;
        btRaiz.setVisible(false);
        calcCientifica.add(btRaiz, c);
        btRaiz.addActionListener(controlador);

        btSeno = new JButton(bundle.getString("calcCientifica_Sin"));
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 5;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipady = 20;
        btSeno.setVisible(false);
        calcCientifica.add(btSeno, c);
        btSeno.addActionListener(controlador);

        btCoseno = new JButton(bundle.getString("calcCientifica_Cos"));
        c = new GridBagConstraints();
        c.gridx = 3;
        c.gridy = 5;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipady = 20;
        btCoseno.setVisible(false);
        calcCientifica.add(btCoseno, c);
        btCoseno.addActionListener(controlador);

        btTangente = new JButton(bundle.getString("calcCientifica_Tan"));
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 6;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipady = 20;
        btTangente.setVisible(false);
        calcCientifica.add(btTangente, c);
        btTangente.addActionListener(controlador);
        
        
        btCoseno.setToolTipText(bundle.getString("ToolTip_Cos"));
        btPotencia.setToolTipText(bundle.getString("ToolTip_pow"));
        btRaiz.setToolTipText(bundle.getString("ToolTip_Raiz"));
        btTangente.setToolTipText(bundle.getString("ToolTip_Tan"));
        btSeno.setToolTipText(bundle.getString("ToolTip_Sin"));
        

        return calcCientifica;

    }

    public void activarBotones() {
        btPotencia.setVisible(true);
        btRaiz.setVisible(true);
        btSeno.setVisible(true);
        btCoseno.setVisible(true);
        btTangente.setVisible(true);
//        super.desactivarIgual();
    }

    public void desactivarBotones() {
        btPotencia.setVisible(false);
        btRaiz.setVisible(false);
        btSeno.setVisible(false);
        btCoseno.setVisible(false);
        btTangente.setVisible(false);
//        super.desactivarIgual();
    }
}
