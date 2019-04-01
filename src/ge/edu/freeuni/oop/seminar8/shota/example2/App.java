package ge.edu.freeuni.oop.seminar8.shota.example2;

import seminar8.shota.example2.ui.Calculator;

import javax.swing.*;

public class App {
    
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new AssertionError(e);
        }
        
        Calculator calc = new Calculator();
        calc.setVisible(true);
    }
}
