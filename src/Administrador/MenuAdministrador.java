package Administrador;

import Menu_Principal.Principal;

import javax.swing.*;
import java.awt.*;

public class MenuAdministrador extends JFrame{
    private JPanel panel1;
    private JButton registrarButton;
    private JButton eliminarButton;
    private JButton editarButton;
    private JButton regresarButton;

    public MenuAdministrador(){
        setupFrame();
        query1();
        query2();
        query3();
        query4();

    }
    private void setupFrame(){
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(400, 300);
        add(panel1);
    }

    private void query1(){
        registrarButton.addActionListener(e -> {
            RegistrarProducto registrarProducto = new RegistrarProducto();
            registrarProducto.setVisible(true);
            this.setVisible(false);
        });
    }

    private void query2(){
        eliminarButton.addActionListener(e -> {
            ActualizarOEliminar actualizarOEliminar = new ActualizarOEliminar();
            actualizarOEliminar.setVisible(true);
            this.setVisible(false);
        });
    }

    private void query3(){
        editarButton.addActionListener(e -> {
            ActualizarOEliminar actualizarOEliminar = new ActualizarOEliminar();
            actualizarOEliminar.setVisible(true);
            this.setVisible(false);
        });
    }
    private void query4(){
        regresarButton.addActionListener(e -> {
            Principal principal = new Principal();
            principal.setVisible(true);
            this.setVisible(false);
        });
    }
}
