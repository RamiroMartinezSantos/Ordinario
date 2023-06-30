package Administrador;

import Pojo.Producto;
import Pojo.RegistrarProductos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegistrarProducto extends JFrame{
    RegistrarProductos registrarProductos = new RegistrarProductos();
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton agregarButton;
    private JButton cancelarButton;
    private static final ArrayList<Producto> lista = new ArrayList<>();

    public RegistrarProducto(){
        setupFrame();
        query1();
    }

    private void setupFrame(){
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(500, 400);
        addActionListeners();
        add(panel1);
    }

    private void addActionListeners(){
        agregarButton.addActionListener(new EventClick());
    }

    public class EventClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            String opcion = boton.getText();

            if (opcion.equals("Agregar")) {
                String nombre_del_producto = textField1.getText();
                String marca = textField2.getText();
                String cantidad_en_experiencia = textField3.getText();
                String descripcion = textField4.getText();
                String precio = textField5.getText();
                String departamento = textField6.getText();

                lista.add(new Producto(nombre_del_producto,marca,cantidad_en_experiencia,descripcion,precio,departamento));

                registrarProductos.ingresar(registrarProductos.getProductos(),nombre_del_producto,marca,cantidad_en_experiencia,descripcion,precio,departamento);

                textField1.setText(" ");
                textField2.setText(" ");
                textField3.setText(" ");
                textField4.setText(" ");
                textField5.setText(" ");
                textField6.setText(" ");
            }
        }
    }

    private void query1(){
        cancelarButton.addActionListener(e -> {
            MenuAdministrador menuAdministrador = new MenuAdministrador();
            menuAdministrador.setVisible(true);
            this.setVisible(false);
        });
    }

    public static ArrayList<Producto> getElemento(){
        return lista;
    }
}
