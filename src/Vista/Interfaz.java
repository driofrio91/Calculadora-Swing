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

import Controlador.controladorNumerico;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author $Danny Riofrío Jiménez
 */
public final class Interfaz {

    private static final String LANG = "lang";
    private static final String COUNTRY = "country";
    // Preferencias para la clase
    static final Preferences preferencias =
            Preferences.userRoot().node(Interfaz.class.getName());
    ResourceBundle bundle;
    private barraDeMenu menuBar;
    private JFrame jFrame;
    private JRootPane rootPanel;
    private JButton botonC;
    private JFormattedTextField pantalla;
    private JPanel panelSuperior;
    private NumberFormat formatoPantalla = new DecimalFormat();
    private double valor;
    private controladorNumerico controladorNumerico;
    //Decalracion de las distintas calculadoras
    private CalcEstandar calculadora;
    private CalcCientifica CalcCientifica;
    private CalcProgramador CalProgramador;
    private JPanel panelNumeros, calcEstandar, calcCientifica, calcProgramador;

    public Interfaz() {
        controladorNumerico = new controladorNumerico(this);
        cargarLenguaje();
        panelSuperior();
        panelNumerico();
        consVentana();

    }

    /**
     * Metodo en el que construiremos la ventana.
     */
    public void consVentana() {


        menuBar = new barraDeMenu(this);

        jFrame = new JFrame(bundle.getString("tittle_Calculadora"));
        jFrame.setLayout(new BorderLayout());
        jFrame.setJMenuBar(menuBar.consMenu());
        jFrame.add(panelSuperior, BorderLayout.PAGE_START);
        jFrame.add(panelNumeros, BorderLayout.CENTER);

        //jFrame.setBounds(400, 400, 300, 300);
        rootPanel = jFrame.getRootPane();
        rootPanel.setDefaultButton(calculadora.getBtIgual());
        jFrame.pack();
        jFrame.setResizable(false);

        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        jFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closedDialog();
            }
        });
    }

    public JFrame getFrame() {
        return jFrame;
    }

    /**
     * Metodo en el que construiremos nuestro panel superior que consta de un
     * JFormattedTextField y un boton de borrar.
     *
     * @return
     */
    private JPanel panelSuperior() {
        //añadimos un jPanel para el panel de la pantalla
        panelSuperior = new JPanel();

        panelSuperior.setLayout(new GridBagLayout());
        GridBagConstraints c;
        //Instanciamos el formato de pantalla
        formatoPantalla = DecimalFormat.getInstance();
        //iniciamos el JFormattedField pasandole el formato que hemos creado
        pantalla = new JFormattedTextField(formatoPantalla);
        pantalla.setValue(0);
        formatoPantalla.setMinimumFractionDigits(1);

        pantalla.addPropertyChangeListener("value", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                Object source = evt.getSource();
                if (source == pantalla && pantalla.getValue() != null) {

                    valor = ((Number) pantalla.getValue()).doubleValue();

                    pantalla.setValue(valor);
                }
            }
        });

        //JTextField
        // pantalla = new JTextField();
        pantalla.setFont(new Font("ComicSans", Font.BOLD, 33));
        pantalla.setBackground(new Color(255, 255, 255));
        pantalla.setEditable(false);
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipadx = GridBagConstraints.BASELINE;
        c.weightx = 1;

        panelSuperior.add(pantalla, c);
        //JButton
        botonC = new JButton(bundle.getString("buttonCE"));
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipady = 20;
        c.weightx = 1;

        botonC.addActionListener(controladorNumerico);

        panelSuperior.add(botonC, c);

        panelSuperior.setBorder(BorderFactory.createLoweredBevelBorder());

        return panelSuperior;
    }

    /**
     * Metodo en el que se construye el panel numerico y se añaden al card
     * layout
     */
    private void panelNumerico() {
        panelNumeros = new JPanel();

        calculadora = new CalcEstandar(this, bundle);
        calcEstandar = calculadora.consCalcEstandar();

        CalcCientifica = new CalcCientifica(this, bundle);
        calcCientifica = CalcCientifica.consCalcCientifica();

        CalProgramador = new CalcProgramador(this, bundle);
        calcProgramador = CalProgramador.consCalcProgramador();

        panelNumeros.setLayout(new CardLayout());

        panelNumeros.add(calcEstandar, "calculadoraEstandar");
        panelNumeros.add(calcCientifica, "calculadoraCientifica");
        panelNumeros.add(calcProgramador, "calculadoraProgramador");

        panelNumeros.setBorder(BorderFactory.createRaisedBevelBorder());

    }

    /**
     * Activa los botones de la calculadora cientifica y ajustamos el tamaño de
     * la ventana.
     */
    public void activarbotonesCientifica() {
        if (CalcCientifica != null) {
            CalcCientifica.activarBotones();
            jFrame.pack();
        }
    }

    /**
     * Desactivamos loc botones de la calculadora cientifica y ajutamos el
     * tamaño de la ventana.
     */
    public void desactivarBotonesCientifica() {
        if (CalcCientifica != null) {
            CalcCientifica.desactivarBotones();
            jFrame.pack();
        }
    }

    public void activarBotonesProgramador() {
        if (CalProgramador != null) {

            CalProgramador.activarBotones();

            jFrame.pack();
        }

    }

    public void desactivarBotonesProgramador() {
        if (CalProgramador != null) {

            CalProgramador.desactivarBotones();

            jFrame.pack();
        }
    }

    /**
     *
     * @return
     */
    public CalcProgramador calcProg() {


        return CalProgramador;

    }

    public JFormattedTextField getPantalla() {
        return pantalla;
    }

    public void closedDialog() {
        int panelQ = JOptionPane.showOptionDialog(jFrame,
                bundle.getString("mensajes_ClosedDialog"),
                bundle.getString("tittle_ClosedDialog"),
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{bundle.getString("ClosedDialog_Salir"), bundle.getString("ClosedDialog_Cancelar")},
                "Salir");
        if (panelQ == 0) {
            jFrame.dispose();
        }
    }

    public JPanel getPanelNumeros() {
        return panelNumeros;
    }

    public void cargarLenguaje() {
        Locale currentLocale = lenguajeActual(new String[]{""});
        bundle = ResourceBundle.getBundle("resources/lenguaje", currentLocale);

    }

    public Locale lenguajeActual(String[] args) {
        String language;
        String country;

        // Si no se pasa por argumento, intenta obtenerlo
        // del fichero de propiedades
        if (args.length != 2) {
            language = preferencias.get(LANG, "en");
            country = preferencias.get(COUNTRY, "EN");
        } else {
            language = new String(args[0]);
            country = new String(args[1]);

            // Si se ha pasado como argumento, 
            // lo guarda en el fichero de propiedades
            preferencias.put(LANG, language);
            preferencias.put(COUNTRY, country);
        }

        return new Locale(language, country);
    }

    public ResourceBundle getBundle() {
        return bundle;
    }
}
