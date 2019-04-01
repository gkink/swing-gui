package ge.edu.freeuni.oop.seminar8.shota.example1.ui;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class HelloJMenuBar extends JFrame {
    
    private final JTextArea textField = new JTextArea("Hello");

    private void setUpMenu(){
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("File");
        menu.setFont(new Font("Times New Roman", Font.ITALIC, 28));

        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem newItem = new JMenuItem("New");
        menu.add(openItem);
        menu.add(newItem);

        openItem.addActionListener(new OpenAction());

        newItem.addActionListener(actionEvent -> textField.setText("New JMenu item clicked"));
        menuBar.add(menu);

        this.setJMenuBar(menuBar);
    }


    private void setUpScrollable(){

        textField.setFont(new Font("Times New Roman", Font.ITALIC, 28));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout());

        JScrollPane scroll = new JScrollPane(textField,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(scroll);

        MyUglyButton button = new MyUglyButton("CLICK ME!");
        panel.add(button);

        this.add(panel);
    }


    public HelloJMenuBar() {

        setUpMenu();
        setUpScrollable();

    }
    
    private class OpenAction implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fc = new JFileChooser();
            
            FileNameExtensionFilter filter 
                = new FileNameExtensionFilter("Only txt & java files", "txt", "java");
            
            fc.setFileFilter(filter);
            
            int rv = fc.showOpenDialog(HelloJMenuBar.this);
            
            if (rv == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                try {
                    String str = new String(Files.readAllBytes(file.toPath()));
                    textField.setText(str);
                } catch (IOException ex) {
                    throw new AssertionError(ex);
                }
            }
        }
    }
    
    public class MyUglyButton extends JButton {
        
        public MyUglyButton(String text) {
            super(text);

            //It is up to the look and feel to honor this property, some may choose to ignore it.

            //the color of the background area
            this.setBackground(new Color(60, 120, 150));

            //the color used to draw the text in a component
            this.setForeground(Color.WHITE);

            this.setFont(new Font("Tahoma", Font.BOLD, 30));
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawOval(5, 5, this.getWidth() - 10, this.getHeight() - 10);
        }
    }
}
