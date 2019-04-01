package ge.edu.freeuni.oop.seminar9.shota;

import ge.edu.freeuni.oop.seminar9.shota.ui.TableFrame;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class App {
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(NimbusLookAndFeel.class.getName());
        } catch (Exception e) {
            throw new AssertionError(e);
        }
        
        TableFrame frame = new TableFrame();
        frame.setVisible(true);
    }
}
