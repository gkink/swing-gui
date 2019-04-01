package ge.edu.freeuni.oop.seminar8.shota.example1;

import com.sun.deploy.association.AssociationException;
import seminar8.shota.example1.ui.HelloJMenuBar;

import javax.swing.*;


public class App {
    
    public static void main(String[] args) throws AssociationException {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new AssociationException();
        }

        HelloJMenuBar hello = new HelloJMenuBar();
        
        hello.setVisible(true);
        hello.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hello.setSize(800, 600);
    }
}
