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
import Controlador.ControladorCalcProgramador;
import Controlador.ControladorConversiones;
import Controlador.controladorNumerico;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ResourceBundle;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author $Danny Riofrío Jiménez
 */
public class CalcProgramador extends CalcEstandar {

    private ResourceBundle bundle;
    private JPanel calcProgramador;
    private JButton btAnd, btXor, btOr, btNot, btA, btB, btC, btD, btE, btF, btIgual;
    private JRadioButton Hex, Dec, Oct, Bin;
    private final ButtonGroup ButtonGroup;
    private ControladorConversiones controlConversiones;
    private ControladorCalcProgramador controladorCalcProgramador;
    private controladorNumerico controladorNumerico;
    private Controlador controlador;

    public CalcProgramador(Interfaz interfaz, ResourceBundle bundle) {
        super(interfaz, bundle);

        this.bundle = bundle;
        ButtonGroup = new ButtonGroup();
        controlConversiones = new ControladorConversiones(interfaz);
        controladorCalcProgramador = new ControladorCalcProgramador(interfaz);

        controladorNumerico = new controladorNumerico(interfaz);
        controlador = new Controlador(interfaz);
    }

    public JPanel consCalcProgramador() {

        calcProgramador = consCalcEstandar();
        GridBagConstraints c;

        //Boton A
        btA = new JButton(bundle.getString("calcProgramador_A"));
        c = new GridBagConstraints();
        c.gridx = 4;
        c.gridy = 0;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipadx = 20;
        c.ipady = 20;
        btA.setEnabled(false);
        btA.setVisible(false);
        btA.addActionListener(controladorNumerico);
        calcProgramador.add(btA, c);

        //Boton b
        btB = new JButton(bundle.getString("calcProgramador_B"));
        c = new GridBagConstraints();
        c.gridx = 4;
        c.gridy = 1;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipadx = 20;
        c.ipady = 20;
        btB.setEnabled(false);
        btB.setVisible(false);
        btB.addActionListener(controladorNumerico);
        calcProgramador.add(btB, c);

        //Boton C
        btC = new JButton(bundle.getString("calcProgramador_C"));
        c = new GridBagConstraints();
        c.gridx = 4;
        c.gridy = 2;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipadx = 20;
        c.ipady = 20;
        btC.setEnabled(false);
        btC.setVisible(false);
        btC.addActionListener(controladorNumerico);
        calcProgramador.add(btC, c);

        //Boton D
        btD = new JButton(bundle.getString("calcProgramador_D"));
        c = new GridBagConstraints();
        c.gridx = 4;
        c.gridy = 3;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipadx = 20;
        c.ipady = 20;
        btD.setEnabled(false);
        btD.setVisible(false);
        btD.addActionListener(controladorNumerico);
        calcProgramador.add(btD, c);

        //Boton E
        btE = new JButton(bundle.getString("calcProgramador_E"));
        c = new GridBagConstraints();
        c.gridx = 4;
        c.gridy = 4;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipadx = 20;
        c.ipady = 20;
        btE.setEnabled(false);
        btE.setVisible(false);
        btE.addActionListener(controladorNumerico);
        calcProgramador.add(btE, c);

        //Boton F
        btF = new JButton(bundle.getString("calcProgramador_F"));
        c = new GridBagConstraints();
        c.gridx = 4;
        c.gridy = 5;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipadx = 20;
        c.ipady = 20;
        btF.setEnabled(false);
        btF.setVisible(false);
        btF.addActionListener(controladorNumerico);
        calcProgramador.add(btF, c);

        //boton AND
        btAnd = new JButton(bundle.getString("calcProgramador_And"));
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(2, 2, 2, 2);
        // c.ipadx = 20;
        c.ipady = 20;
        btAnd.setEnabled(false);
        btAnd.setVisible(false);
        btAnd.addActionListener(controladorCalcProgramador);
        calcProgramador.add(btAnd, c);

        //Boton XOR
        btXor = new JButton(bundle.getString("calcProgramador_Xor"));
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 5;
        c.insets = new Insets(2, 2, 2, 2);
        //c.ipadx = 20;
        c.ipady = 20;
        btXor.setEnabled(false);
        btXor.setVisible(false);
        btXor.addActionListener(controladorCalcProgramador);
        calcProgramador.add(btXor, c);

        //Boton OR
        btOr = new JButton(bundle.getString("calcProgramador_Or"));
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 5;
        c.insets = new Insets(2, 2, 2, 2);
        //c.ipadx = 20;
        c.ipady = 20;
        btOr.setEnabled(false);
        btOr.setVisible(false);
        btOr.addActionListener(controladorCalcProgramador);
        calcProgramador.add(btOr, c);

        //boton NOT
        btNot = new JButton(bundle.getString("calcProgramador_Not"));
        c = new GridBagConstraints();
        c.gridx = 3;
        c.gridy = 5;
        c.insets = new Insets(2, 2, 2, 2);
        //c.ipadx = 20;
        c.ipady = 20;
        btNot.setEnabled(false);
        btNot.setVisible(false);
        btNot.addActionListener(controladorCalcProgramador);
        calcProgramador.add(btNot, c);

        //Boton igual
        btIgual = new JButton("=");
        btIgual.addActionListener(controladorCalcProgramador);
        c.gridx = 2;
        c.gridy = 4;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipadx = 20;
        c.ipady = 20;
        btIgual.setVisible(true);
        calcProgramador.add(btIgual, c);

        //Radio buttons  Hex, Dec, Oct, Bin
        Hex = new JRadioButton(bundle.getString("calcProgramador_Hex"));
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(2, 2, 2, 2);
        Hex.addActionListener(controlConversiones);
//        Hex.addActionListener(controladorBotonesProgramador);
        Hex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activaFuncionesHex();
            }
        });

        calcProgramador.add(Hex, c);

        Dec = new JRadioButton(bundle.getString("calcProgramador_Dec"));
        Dec.setSelected(true);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(2, 2, 2, 2);
        Dec.addActionListener(controlConversiones);
//        Dec.addActionListener(controladorBotonesProgramador);
        Dec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activarFuncionesDecimal();
            }
        });

        calcProgramador.add(Dec, c);

        Oct = new JRadioButton(bundle.getString("calcProgramador_Oct"));
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 0;
        c.insets = new Insets(2, 2, 2, 2);
        Oct.addActionListener(controlConversiones);
//        Oct.addActionListener(controladorBotonesProgramador);
        Oct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activarFuncionesOct();
            }
        });

        calcProgramador.add(Oct, c);

        Bin = new JRadioButton(bundle.getString("calcProgramador_Bin"));
        c = new GridBagConstraints();
        c.gridx = 3;
        c.gridy = 0;
        c.insets = new Insets(2, 2, 2, 2);
        Bin.addActionListener(controlConversiones);
//        Bin.addActionListener(controladorBotonesProgramador);
        Bin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activarFuncionesBinarias();
            }
        });

        calcProgramador.add(Bin, c);

        ButtonGroup.add(Hex);
        ButtonGroup.add(Dec);
        ButtonGroup.add(Oct);
        ButtonGroup.add(Bin);

        //TolTips
        btAnd.setToolTipText(bundle.getString("ToolTip_And"));
        btOr.setToolTipText(bundle.getString("ToolTip_Or"));
        btXor.setToolTipText(bundle.getString("ToolTip_Xor"));
        btNot.setToolTipText(bundle.getString("ToolTip_Not"));
        Bin.setToolTipText(bundle.getString("ToolTip_Bin"));
        Dec.setToolTipText(bundle.getString("ToolTip_Dec"));
        Hex.setToolTipText(bundle.getString("ToolTip_Hex"));
        Oct.setToolTipText(bundle.getString("ToolTip_Oct"));
        btIgual.setToolTipText(bundle.getString("ToolTip_Igual"));



        return calcProgramador;

    }

    public void activarBotones() {
        btA.setVisible(true);
        btB.setVisible(true);
        btC.setVisible(true);
        btD.setVisible(true);
        btE.setVisible(true);
        btF.setVisible(true);
        btAnd.setVisible(true);
        btXor.setVisible(true);
        btOr.setVisible(true);
        btNot.setVisible(true);
        btIgual.setVisible(true);
        super.desactivarIgual();
    }

    public void desactivarBotones() {
        btA.setVisible(false);
        btB.setVisible(false);
        btC.setVisible(false);
        btD.setVisible(false);
        btE.setVisible(false);
        btF.setVisible(false);
        btAnd.setVisible(false);
        btXor.setVisible(false);
        btOr.setVisible(false);
        btNot.setVisible(false);
        btIgual.setVisible(false);
        super.activarbotonIgual();
    }

    /**
     * Metodo que activa las funciones para trabajar en Hexadecimal, y desactiva
     * las funciones que no son de decimal
     */
    public void activaFuncionesHex() {
        desactivarOperaciones();
        desactivarFuncionesBinarias();
        activarNumeros();
        btA.setEnabled(true);
        btB.setEnabled(true);
        btC.setEnabled(true);
        btD.setEnabled(true);
        btE.setEnabled(true);
        btF.setEnabled(true);

        super.desactivarPuntoIgual();
    }

    /**
     * Desactivar funciones exadecimales.
     */
    public void desacticarFuncionesHex() {
        desactivarOperaciones();
        btA.setEnabled(false);
        btB.setEnabled(false);
        btC.setEnabled(false);
        btD.setEnabled(false);
        btE.setEnabled(false);
        btF.setEnabled(false);
    }

    /**
     *
     */
    public void activarFuncionesOct() {
        desactivarOperaciones();
        desacticarFuncionesHex();
        desactivarFuncionesBinarias();
        //Llamo al metodo funcionesOct qu desactiva los botnoes 8 y 9 y activas los demas
        super.funcionesOct();
        super.desactivarPuntoIgual();
    }

    /**
     *
     */
    public void activarFuncionesDecimal() {
        desacticarFuncionesHex();

        desactivarFuncionesBinarias();
        super.funciondesDecimal();


    }

    /**
     * Metodo que activara las funciones de las tabla de verdad y desacticara
     * las demas funciones
     */
    public void activarFuncionesBinarias() {
        desactivarOperaciones();
        desacticarFuncionesHex();
        super.funcionesBin();
        super.desactivarPuntoIgual();
        btAnd.setEnabled(true);
        btNot.setEnabled(true);
        btXor.setEnabled(true);
        btOr.setEnabled(true);
    }

    /**
     * Metodo que desactivara los botones de las tablas de verdad
     */
    public void desactivarFuncionesBinarias() {
        btAnd.setEnabled(false);
        btNot.setEnabled(false);
        btXor.setEnabled(false);
        btOr.setEnabled(false);

    }
}
