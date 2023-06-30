package Menu_Principal;

import Administrador.ComprobarAdministrador;
import Cliente.ConsultarProductos;
import Repartidor.ComprobarRepartidor;

import javax.swing.*;
import java.awt.*;

public class Principal extends JFrame{
    private JPanel panel1;
    private JButton administradorButton;
    private JButton repartidorButton;
    private JButton clienteButton;

    public Principal(){
        setupFrame();
        query();
        query2();
        query3();
    }
    private void setupFrame(){
        setTitle("Menu principal");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(400, 300);
        add(panel1);
    }

    private void query(){
        administradorButton.addActionListener(e -> {
            ComprobarAdministrador comprobarAdmin = new ComprobarAdministrador();
            comprobarAdmin.setVisible(true);
            this.setVisible(false);
        });
    }

    private void query2(){
        repartidorButton.addActionListener(e -> {
            ComprobarRepartidor comprobarRepartidor = new ComprobarRepartidor();
            comprobarRepartidor.setVisible(true);
            this.setVisible(false);
        });
    }


    private void query3(){
        clienteButton.addActionListener(e -> {
            ConsultarProductos consultarProductos = new ConsultarProductos();
            consultarProductos.setVisible(true);
            this.setVisible(false);
        });
    }
}
