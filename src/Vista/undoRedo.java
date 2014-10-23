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

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuItem;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

/**
 *
 * @author alvaro
 */
public class undoRedo {

    //undo helpers
    protected UndoAction undoAction;
    protected RedoAction redoAction;
    //Undo managet
    protected UndoManager undoManager = new UndoManager();
    //FormatedText Filed que la igualaremos en el constructos
    private JFormattedTextField textField;

    /**
     * Contructor de la clase undoRedo a la que le pasaremos el TextField, y 
     * los item de menu que ejecutan el undo y redo.
     * 
     * @param textField
     * @param undo
     * @param redo 
     */
    public undoRedo(JFormattedTextField textField, JMenuItem undo, JMenuItem redo) {

        this.textField = textField;
        undoAction = new UndoAction();
        redoAction = new RedoAction();

        textField.getDocument().addUndoableEditListener(new MyUndoableEditListener());

        undo.addActionListener(undoAction);
        redo.addActionListener(redoAction);

    }
/**
 * Clase RedAction
 */
    class RedoAction extends AbstractAction {

        public RedoAction() {
            super("Redo");
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //Ejecutaremos la accion dos veces para que no se quede la pantalla 
            //en blanco
            try {
                undoManager.redo();
                undoManager.redo();

            } catch (CannotRedoException ex) {
            }
            updateRedoState();
            undoAction.updateUndoState();
        }

        protected void updateRedoState() {
            if (undoManager.canRedo()) {
                setEnabled(true);
                putValue(Action.NAME, undoManager.getRedoPresentationName());
            } else {
                setEnabled(false);
                putValue(Action.NAME, "Redo");
            }
        }
    }

    //This one listens for edits that can be undone.
    protected class MyUndoableEditListener
            implements UndoableEditListener {

        @Override
        public void undoableEditHappened(UndoableEditEvent e) {
            //Remember the edit and update the menus.
            undoManager.addEdit(e.getEdit());
            undoAction.updateUndoState();
            redoAction.updateRedoState();
        }
    }

    class UndoAction extends AbstractAction {

        public UndoAction() {
            super("Undo");
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //Ejecutaremos la accion undo dos veces para que la pantalla 
            //no se nos quede vacia
            try {
                undoManager.undo();
                undoManager.undo();
            } catch (CannotUndoException ex) {
            }
            updateUndoState();

            redoAction.updateRedoState();
        }

        protected void updateUndoState() {
            if (undoManager.canUndo()) {
                setEnabled(true);
                putValue(Action.NAME, undoManager.getUndoPresentationName());
            } else {
                setEnabled(false);
                putValue(Action.NAME, "Undo");
            }
        }
    }
}
