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

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;
import javax.swing.ButtonGroup;
import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;

/**
 *
 * @author $Danny Riofrío Jiménez
 */
public class barraDeMenu {

    ////////////////////////////////
    /////////////////////////////////
    Interfaz calc;
    private JMenuBar menuBar;
    private JColorChooser selectorColor;
    private undoRedo undoRedo;
    private worker worker;
    private ResourceBundle bundle;

    ;
    public barraDeMenu(Interfaz calc) {
        this.calc = calc;

    }

    public JMenuBar consMenu() {
        bundle = calc.getBundle();
        //Los dos submenus y menus del MenuBar
        JMenu subMenuColores, tiposFuente, menuEdicion, menuVer, MenuIdioma;
        //los itenms de los submenus
        JMenuItem camniarFuente, cambiarFondo, salir, copy, paste, cut, undo, redo, nPrimoWorker, español, ingles;
        //RadioButtons
        JRadioButtonMenuItem rbCalcCientifica, rbCalcEstandar, rbCalcProgramador, rbFontSerif, rbFuente2, rbFuente3;
        menuBar = new JMenuBar();









        //Opciones de menu
        //Primera opcion del menu
        menuEdicion = new JMenu(bundle.getString("manuBar_Edicion"));
        menuEdicion.setMnemonic(KeyEvent.VK_Q);
        menuBar.add(menuEdicion);


        //copy paste cut
        cut = new JMenuItem(new DefaultEditorKit.CutAction());
        cut.setText(bundle.getString("manuBar_cortar"));
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));

        copy = new JMenuItem(new DefaultEditorKit.CopyAction());
        copy.setText(bundle.getString("manuBar_copiar"));
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));

        paste = new JMenuItem(new DefaultEditorKit.PasteAction());
        paste.setText(bundle.getString("manuBar_pegar"));
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));

        menuEdicion.add(cut);
        menuEdicion.add(copy);
        menuEdicion.add(paste);


        menuEdicion.addSeparator();

        //UndoRedo
        undo = new JMenuItem(bundle.getString("manuBar_Deshacer"));
        undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
        redo = new JMenuItem(bundle.getString("manuBar_Rehacer"));
        redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        undoRedo = new undoRedo(calc.getPantalla(), undo, redo);


        menuEdicion.add(undo);
        menuEdicion.add(redo);


        menuEdicion.addSeparator();


        //Menu de cambiar colores de fuente y fondo

        subMenuColores = new JMenu(bundle.getString("manuBar_CambiarColor"));
        subMenuColores.setMnemonic(KeyEvent.VK_Q);
        menuEdicion.add(subMenuColores);

        //Opcion de cambiar la fuente
        camniarFuente = new JMenuItem(bundle.getString("manuBar_ColorFuente"));
        camniarFuente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, Event.CTRL_MASK));
        camniarFuente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                selectorColor = new JColorChooser();
                Color color = JColorChooser.showDialog(null, bundle.getString("coolorChooser_Fuente"), selectorColor.getColor());
                calc.getPantalla().setForeground(color);
            }
        });

        //opcion de cambiar el fondo del text field
        cambiarFondo = new JMenuItem("Color de fondo");
        cambiarFondo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectorColor = new JColorChooser();
                Color color = JColorChooser.showDialog(null, bundle.getString("coolorChoser_Fondo"), selectorColor.getColor());
                calc.getPantalla().setBackground(color);
            }
        });



        MenuIdioma = new JMenu(bundle.getString("manuBar_Idioma"));
        menuEdicion.add(MenuIdioma);

        español = new JMenuItem(bundle.getString("manuBar_Espanol"));
        MenuIdioma.add(español);
        español.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calc.lenguajeActual(new String[]{"es", "ES"});
                mensajeCambiarIdioma();
            }
        });

        ingles = new JMenuItem(bundle.getString("manuBar_Ingles"));
        MenuIdioma.add(ingles);
        ingles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                calc.lenguajeActual(new String[]{"en", "EN"});
                mensajeCambiarIdioma();
            }
        });



        salir = new JMenuItem(bundle.getString("manuBar_Salir"));
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calc.closedDialog();

            }
        });


        //Añadimos las opciones al menu configuracion
        subMenuColores.add(camniarFuente);
        subMenuColores.add(cambiarFondo);

        //Añadimos otro submenu para que salgan los radio butons en un submenu
        tiposFuente = new JMenu(bundle.getString("manuBar_Fuente"));
        tiposFuente.setMnemonic(KeyEvent.VK_F);
        menuEdicion.add(tiposFuente);
        menuEdicion.addSeparator();

        menuEdicion.add(salir);


        //Grupo de opciones para cambiar la fuente
        ButtonGroup grupoFuente = new ButtonGroup();

        rbFontSerif = new JRadioButtonMenuItem(bundle.getString("manuBar_Serif"));
        rbFontSerif.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, Event.ALT_MASK));
        //listener del JRadioButtonMenuItem
        rbFontSerif.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                calc.getPantalla().setFont(new Font(Font.SERIF, Font.PLAIN, 33));
            }
        });

        rbFuente2 = new JRadioButtonMenuItem(bundle.getString("manuBar_CSans"));
        rbFuente2.setSelected(true);
        rbFuente2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, Event.ALT_MASK));
        rbFuente2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                calc.getPantalla().setFont(new Font("ComicSans", Font.BOLD, 33));
            }
        });




        rbFuente3 = new JRadioButtonMenuItem(bundle.getString("manuBar_Dialog"));
        rbFuente3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.ALT_MASK));
        rbFuente3.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                calc.getPantalla().setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 33));
            }
        });

        //añadimos los botones de cambiar la fuente al grupo de fuentes
        grupoFuente.add(rbFontSerif);
        grupoFuente.add(rbFuente2);
        grupoFuente.add(rbFuente3);

        //añadimos el grupo al menuBar
        tiposFuente.add(rbFontSerif);
        tiposFuente.add(rbFuente2);
        tiposFuente.add(rbFuente3);





        ///////////////////////////////////////////
        /////////Segunda opcion del menu//////////
        ///////////////////////////////////////////

        menuVer = new JMenu(bundle.getString("manuBar_ver"));
        //GRUPO DE BOTONES que pertenecen al grupo configuracion
        ButtonGroup grupoModo = new ButtonGroup();
        rbCalcEstandar = new JRadioButtonMenuItem(bundle.getString("manuBar_CalcEstandar"));
        //Establezco el acelerador para el radio button que tiene que ser de tipo 
        //JRadioButtonMenuItem que es lo que se le puede poner aceleradores
        rbCalcEstandar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK));
        rbCalcEstandar.setSelected(true);
        rbCalcEstandar.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                ((CardLayout) calc.getPanelNumeros().getLayout()).show(calc.getPanelNumeros(), "calculadoraEstandar");
                calc.desactivarBotonesCientifica();
                calc.desactivarBotonesProgramador();
            }
        });
        rbCalcCientifica = new JRadioButtonMenuItem(bundle.getString("manuBar_CalcCientifica"));
        rbCalcCientifica.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                ((CardLayout) calc.getPanelNumeros().getLayout()).show(calc.getPanelNumeros(), "calculadoraCientifica");
                calc.activarbotonesCientifica();
                calc.desactivarBotonesProgramador();
            }
        });

        rbCalcProgramador = new JRadioButtonMenuItem(bundle.getString("manuBar_CalcProgramador"));
        rbCalcProgramador.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                ((CardLayout) calc.getPanelNumeros().getLayout()).show(calc.getPanelNumeros(), "calculadoraProgramador");
                calc.desactivarBotonesCientifica();
                calc.activarBotonesProgramador();
            }
        });

        grupoModo.add(rbCalcEstandar);
        grupoModo.add(rbCalcCientifica);
        grupoModo.add(rbCalcProgramador);

        menuVer.add(rbCalcEstandar);
        menuVer.add(rbCalcCientifica);
        menuVer.add(rbCalcProgramador);

        menuVer.addSeparator();


        nPrimoWorker = new JMenuItem(bundle.getString("manuBar_nPrimos"));
        nPrimoWorker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                worker = new worker(bundle);

            }
        });

        menuVer.add(nPrimoWorker);


        menuBar.add(menuEdicion);
        menuBar.add(menuVer);



        return menuBar;

    }
    
    public final void mensajeCambiarIdioma() {
        JOptionPane.showOptionDialog(null,
                bundle.getString("mensajes_CambiarIdioma"),
                null,
                JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{bundle.getString("mensajes_OK")},
                "Salir");
    }
}
