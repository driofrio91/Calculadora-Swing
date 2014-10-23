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
import Controlador.controladorNumerico;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author $Danny Riofrío Jiménez
 */
public class CalcEstandar {
    
    private ResourceBundle bundle;
    private JButton bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, btMas, btMenos, btMulti, btDiv, btPunto, btIgual;
    private JPanel calcEstandar;
    private final controladorNumerico controladorNumerico;
    public  final Controlador controlador;

    public CalcEstandar(Interfaz interfaz, ResourceBundle bundle) {
        this.bundle = bundle;
        controladorNumerico = new controladorNumerico(interfaz);
        controlador = new Controlador(interfaz);
    }

    public JPanel consCalcEstandar() {

        calcEstandar = new JPanel();
        calcEstandar.setLayout(new GridBagLayout());
        //Constaints del layout
        GridBagConstraints c;
        //Boton 7
        bt7 = new JButton("7");
        bt7.addActionListener(controladorNumerico);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipadx = 20;
        c.ipady = 20;
        calcEstandar.add(bt7, c);

        //Boton 8
        bt8 = new JButton("8");
        bt8.addActionListener(controladorNumerico);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipadx = 20;
        c.ipady = 20;
        calcEstandar.add(bt8, c);

        //Boton 9
        bt9 = new JButton("9");
        bt9.addActionListener(controladorNumerico);
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 1;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipadx = 20;
        c.ipady = 20;
        calcEstandar.add(bt9, c);

        //Boton Division
        btDiv = new JButton("/");
        btDiv.addActionListener(controlador);
        c = new GridBagConstraints();
        c.gridx = 3;
        c.gridy = 1;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipadx = 20;
        c.ipady = 20;
        calcEstandar.add(btDiv, c);
        //Boton 4
        bt4 = new JButton("4");
        bt4.addActionListener(controladorNumerico);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipadx = 20;
        c.ipady = 20;
        calcEstandar.add(bt4, c);
        //Boton 5
        bt5 = new JButton("5");
        bt5.addActionListener(controladorNumerico);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipadx = 20;
        c.ipady = 20;
        calcEstandar.add(bt5, c);
        //Boton 6
        bt6 = new JButton("6");
        bt6.addActionListener(controladorNumerico);
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 2;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipadx = 20;
        c.ipady = 20;
        calcEstandar.add(bt6, c);
        //Boton multiplicaion
        btMulti = new JButton("*");
        btMulti.addActionListener(controlador);
        c = new GridBagConstraints();
        c.gridx = 3;
        c.gridy = 2;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipadx = 20;
        c.ipady = 20;
        calcEstandar.add(btMulti, c);
        //Boton 1
        bt1 = new JButton("1");
        bt1.addActionListener(controladorNumerico);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipadx = 20;
        c.ipady = 20;
        calcEstandar.add(bt1, c);
        //Boton 2
        bt2 = new JButton("2");
        bt2.addActionListener(controladorNumerico);
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipadx = 20;
        c.ipady = 20;
        calcEstandar.add(bt2, c);
        //Boton 3
        bt3 = new JButton("3");
        bt3.addActionListener(controladorNumerico);
        c.gridx = 2;
        c.gridy = 3;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipadx = 20;
        c.ipady = 20;
        calcEstandar.add(bt3, c);
        //Boton Menos
        btMenos = new JButton("-");
        btMenos.addActionListener(controlador);
        c.gridx = 3;
        c.gridy = 3;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipadx = 20;
        c.ipady = 20;
        calcEstandar.add(btMenos, c);
        //Boton 0
        bt0 = new JButton("0");
        bt0.addActionListener(controladorNumerico);
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipadx = 20;
        c.ipady = 20;
        calcEstandar.add(bt0, c);
        //Boton decimal
        btPunto = new JButton(".");
        btPunto.addActionListener(controlador);
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipadx = 20;
        c.ipady = 20;
        calcEstandar.add(btPunto, c);
        //Boton igual
        btIgual = new JButton("=");
        btIgual.addActionListener(controlador);
//        btIgual.addActionListener(controladorCalcCientifica);
        c.gridx = 2;
        c.gridy = 4;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipadx = 20;
        c.ipady = 20;
        calcEstandar.add(btIgual, c);
        //Boton mas
        btMas = new JButton("+");
        btMas.addActionListener(controlador);
        c.gridx = 3;
        c.gridy = 4;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipadx = 20;
        c.ipady = 20;
        calcEstandar.add(btMas, c);

        //Añadimos los atajos de telcado para los botones de la calculadora
        bt1.setMnemonic(KeyEvent.VK_1);
        bt1.setMnemonic(KeyEvent.VK_NUMPAD1);
        bt2.setMnemonic(KeyEvent.VK_2);
        bt2.setMnemonic(KeyEvent.VK_NUMPAD2);
        bt3.setMnemonic(KeyEvent.VK_3);
        bt3.setMnemonic(KeyEvent.VK_NUMPAD3);
        bt4.setMnemonic(KeyEvent.VK_4);
        bt4.setMnemonic(KeyEvent.VK_NUMPAD4);
        bt5.setMnemonic(KeyEvent.VK_5);
        bt5.setMnemonic(KeyEvent.VK_NUMPAD5);
        bt6.setMnemonic(KeyEvent.VK_6);
        bt6.setMnemonic(KeyEvent.VK_NUMPAD6);
        bt7.setMnemonic(KeyEvent.VK_7);
        bt7.setMnemonic(KeyEvent.VK_NUMPAD7);
        bt8.setMnemonic(KeyEvent.VK_8);
        bt8.setMnemonic(KeyEvent.VK_NUMPAD8);
        bt9.setMnemonic(KeyEvent.VK_9);
        bt9.setMnemonic(KeyEvent.VK_NUMPAD9);
        bt0.setMnemonic(KeyEvent.VK_0);
        bt0.setMnemonic(KeyEvent.VK_NUMPAD0);
        btMas.setMnemonic(KeyEvent.VK_ADD);
        btMenos.setMnemonic(KeyEvent.VK_MINUS);
        btMulti.setMnemonic(KeyEvent.VK_MULTIPLY);
        btDiv.setMnemonic(KeyEvent.VK_DIVIDE);
        btIgual.setMnemonic(KeyEvent.VK_ENTER);
        btPunto.setMnemonic(KeyEvent.VK_COMMA);
       
        //Añadimos Tool Tips a la calculadora
        btMas.setToolTipText(bundle.getString("ToolTip_mas"));
        btMenos.setToolTipText(bundle.getString("ToolTip_menos"));
        btMulti.setToolTipText(bundle.getString("ToolTip_multi"));
        btDiv.setToolTipText(bundle.getString("ToolTip_Div"));
        btIgual.setToolTipText(bundle.getString("ToolTip_Igual"));
        btPunto.setToolTipText(bundle.getString("ToolTip_punto"));
        
        
        return calcEstandar;

    }

    /**
     * 
     */
    public void funcionesOct() {
        bt8.setEnabled(false);
        bt9.setEnabled(false);
        bt1.setEnabled(true);
        bt2.setEnabled(true);
        bt3.setEnabled(true);
        bt4.setEnabled(true);
        bt5.setEnabled(true);
        bt6.setEnabled(true);
        bt7.setEnabled(true);

    }
    
    /**
     * 
     */

    public void desactivarPuntoIgual() {
        btPunto.setEnabled(false);
        btIgual.setEnabled(false);
    }
    
    /**
     * 
     */

    public void funcionesBin() {
        bt9.setEnabled(false);
        bt8.setEnabled(false);
        bt7.setEnabled(false);
        bt6.setEnabled(false);
        bt5.setEnabled(false);
        bt4.setEnabled(false);
        bt3.setEnabled(false);
        bt2.setEnabled(false);
        btPunto.setEnabled(false);

    }

    /**
     * 
     */
    public void funciondesDecimal() {
        bt9.setEnabled(true);
        bt8.setEnabled(true);
        bt7.setEnabled(true);
        bt6.setEnabled(true);
        bt5.setEnabled(true);
        bt4.setEnabled(true);
        bt3.setEnabled(true);
        bt2.setEnabled(true);
        btPunto.setEnabled(true);

    }

    /**
     * 
     */
    public void desactivarIgual() {
        btIgual.setVisible(false);
        btIgual.setEnabled(false);
    }

    /**
     * 
     */
    public void activarbotonIgual() {
        btIgual.setVisible(true);
        btIgual.setEnabled(true);
    }

    /**
     * 
     */
    public void desactivarOperaciones() {
        btMas.setEnabled(false);
        btMenos.setEnabled(false);
        btMulti.setEnabled(false);
        btDiv.setEnabled(false);
    }

    /**
     * 
     */
    public void activarOperaciones() {
        btMas.setEnabled(true);
        btMenos.setEnabled(true);
        btMulti.setEnabled(true);
        btDiv.setEnabled(true);


    }

    /**
     * 
     */
    public void activarNumeros() {

        bt1.setEnabled(true);
        bt2.setEnabled(true);
        bt3.setEnabled(true);
        bt4.setEnabled(true);
        bt5.setEnabled(true);
        bt6.setEnabled(true);
        bt7.setEnabled(true);
        bt8.setEnabled(true);
        bt9.setEnabled(true);
    }

    /**
     * 
     * @return 
     */
    public JButton getBtIgual() {
       return btIgual;
    }
}
