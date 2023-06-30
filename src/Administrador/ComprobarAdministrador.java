package Administrador;
import Menu_Principal.Principal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ComprobarAdministrador extends JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton verificarButton;
    private JButton cancelarButton;

    public ComprobarAdministrador(){
        setupFrame();
        query2();

    }
    private void setupFrame(){
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(400, 300);
        addActionListeners();
        add(panel1);
    }


    private void addActionListeners(){
        verificarButton.addActionListener(new EventClick());
    }
    public class EventClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            String opcion = boton.getText();

            if (opcion.equals("Verificar")) {
                String usuar = textField1.getText();
                String contra = textField2.getText();

                if(Objects.equals(usuar, "admin") && Objects.equals(contra, "admin")){
                    MenuAdministrador menuAdministrador = new MenuAdministrador();
                    menuAdministrador.setVisible(true);
                }

                textField1.setText(" ");
                textField2.setText(" ");
            }
        }
    }
    private void query2(){
        cancelarButton.addActionListener(e -> {
            Principal principal = new Principal();
            principal.setVisible(true);
            this.setVisible(false);
        });
    }
}
