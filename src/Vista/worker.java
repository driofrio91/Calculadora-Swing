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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ResourceBundle;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Danny Riofrio Jimenez
 */
public class worker extends JFrame {

    private JProgressBar progressBar;
    private JButton buttonCalcular;
    private JPanel panel1, panel2;
    private JFrame frame;
    private JSplitPane splitPane;
    private JTextField campoNumeros;
    private JScrollPane scrollPanePanel2, scrollPaneTextArea;
    private JTextArea textArea;
    private String total = "";
    private ResourceBundle bundle;

    public worker(ResourceBundle bundle) {
        this.bundle = bundle;


        frame = new JFrame(bundle.getString("tittle_CalculodePrimos"));

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(200);


        ///////////////////////////////////////
        ///Compoeneste del panel 1/////////////
        ///////////////////////////////////////
        panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints c;
        //
        c = new GridBagConstraints();
        campoNumeros = new JTextField();
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipadx = 100;
        panel1.add(campoNumeros, c);
        //
        c = new GridBagConstraints();
        buttonCalcular = new JButton(bundle.getString("nPrimos_Button_Calcular"));
        c.gridx = 2;
        c.gridy = 1;
        c.insets = new Insets(2, 2, 2, 2);
        panel1.add(buttonCalcular, c);
        buttonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pulsarboton();
            }
        });
        //
        textArea = new JTextArea(">");
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 2;
        c.insets = new Insets(2, 2, 2, 2);
        c.ipadx = 120;
        c.ipady = 200;
        textArea.setColumns(3);
        textArea.setEditable(false);
        scrollPaneTextArea = new JScrollPane(textArea);
        panel1.add(scrollPaneTextArea, c);

        ////////////////////////////////////////////
        ////////////////Panel 2/////////////////////
        ////////////////////////////////////////////

        panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

        scrollPanePanel2 = new JScrollPane(panel2);



        splitPane.add(panel1);
        splitPane.add(scrollPanePanel2);

        frame.add(splitPane);
        frame.setVisible(true);
        //frame.pack();
        frame.setBounds(200, 200, 500, 400);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //
        informacionEntrada();

    }

    public final void informacionEntrada() {
        JOptionPane.showOptionDialog(null,
                bundle.getString("mensajes_EnesimoPrimo"),
                bundle.getString("tittle_EnesimoPrimo"),
                JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"OK"},
                "Salir");
    }

    public void mensajeErrorNumero() {
        JOptionPane.showOptionDialog(null,
                 bundle.getString("mensajes_ERRORPrimo"),
                bundle.getString("tittle_EnesimoPrimo_ERROR"),
                JOptionPane.ERROR_MESSAGE,
                JOptionPane.ERROR_MESSAGE,
                null,
                new Object[]{"OK"},
                bundle.getString("ClosedDialog_Salir"));
    }

    public void pulsarboton() {


        try {
            progressBar = new JProgressBar(0, Integer.parseInt(campoNumeros.getText()));
            progressBar.setStringPainted(true);
            progressBar.setValue(0);
            progressBar.setBackground(new java.awt.Color(51, 204, 204));
            progressBar.setForeground(new java.awt.Color(255, 255, 255));
            panel2.add(progressBar);
            frame.revalidate();


            progressWorke(progressBar);
        } catch (NumberFormatException nfe) {
            mensajeErrorNumero();
            campoNumeros.setText("");
        }

    }

    public static boolean esPrimo(int numero) {
        int contador = 2;
        boolean primo = true;
        while ((primo) && (contador != numero)) {
            if (numero % contador == 0) {
                primo = false;
            }
            contador++;
        }
        return primo;
    }

    private void progressWorke(JProgressBar bar) {

        final JProgressBar progressBar = bar;

        SwingWorker worker = new SwingWorker<Double, Double>() {
            @Override
            protected Double doInBackground() throws Exception {
                // Aquí no estoy en el hilo de gestión de eventos
                // Estoy en el hilo Worker
                // => NO puedo modificar la vista
                double acum = 0;
                //Numero de primos que vayamos a encontrar, sera lo que le pasemos 
                //a la barra de progreso
                int numeroDePrimos = 0;
                //Numero primo que primo que queremos que encuentres
                int numeroPrimo = Integer.parseInt(campoNumeros.getText());

                int nPrimo = 0;

                for (int i = 2; numeroDePrimos < numeroPrimo; i++) {
                    Thread.sleep(50);

                    boolean p = esPrimo(i);
                    if (p) {
                        numeroDePrimos++;
                        nPrimo = i;
//                        System.out.println(numeroDePrimos);
                        setProgress(numeroDePrimos);
                    }
                }
                total += ">" + nPrimo + "\n";
                textArea.setText(total);
                setProgress(100);
                return acum;
            }
        };

        worker.addPropertyChangeListener(
                new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("progress".equals(evt.getPropertyName())) {
                    int progress = (Integer) evt.getNewValue();


                    progressBar.setValue(progress);

                }
            }
        });

        // Ejecuto la tarea
        worker.execute();
    }
}
