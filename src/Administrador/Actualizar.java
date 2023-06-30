package Administrador;
import Pojo.Producto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Actualizar extends JFrame  {
    private JPanel panelContainer,panelDatos,panel1,panel2,panelBotones;
    private JButton regUsuario,regresar;
    private JLabel vacio1,titulo,nombre,marca,cantidad,descripcion,precio,departamaneto;
    private JTextField nombreEntrada,marcaEntrada,cantidadEntrada,descripcionEntrada,precioEntrada,departamentoEntrada;
    public static ArrayList<Producto> listaUsuarios =new ArrayList<>();
    EventClick eventClick = new EventClick();
    public Actualizar(){
        configFrame();
        initControl();
        setControl();
        configPanel();
        acciones();
    }

    private void configFrame(){
        setTitle("Actualizar");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(500, 300);
    }

    private void initControl(){
        panelContainer = new JPanel();
        panelBotones = new JPanel();
        panelDatos = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();

        vacio1 = new JLabel(" ");
        titulo = new JLabel();
        nombre = new JLabel();
        marca = new JLabel();
        cantidad = new JLabel();
        descripcion = new JLabel();
        precio = new JLabel();
        departamaneto = new JLabel();

        nombreEntrada = new JTextField();
        marcaEntrada = new JTextField();
        cantidadEntrada = new JTextField();
        descripcionEntrada = new JTextField();
        precioEntrada = new JTextField();
        departamentoEntrada = new JTextField();

        regUsuario = new JButton();
        regresar = new JButton();
    }

    private void setControl(){
        regUsuario.setText("Actualizar usuario");
        regresar.setText("Regresar");
        titulo.setText("ACTUALIZAR NUEVO USUARIO");

        nombre.setText("Nombre completo");
        marca.setText("Marca");
        cantidad.setText("Cantidad");
        descripcion.setText("Descripcion");
        precio.setText("precio");
        departamaneto.setText("Departamento");
    }

    private void configPanel(){

        panel1.setLayout(new GridLayout(6,1));
        panel1.add(nombre);
        panel1.add(marca);
        panel1.add(cantidad);
        panel1.add(descripcion);
        panel1.add(precio);
        panel1.add(departamaneto);

        panel2.setLayout(new GridLayout(6,1));
        panel2.add(nombreEntrada);
        panel2.add(marcaEntrada);
        panel2.add(cantidadEntrada);
        panel2.add(descripcionEntrada);
        panel2.add(precioEntrada);
        panel2.add(departamentoEntrada);

        panelDatos.setLayout(new GridLayout(1,3));
        panelDatos.add(panel1);
        panelDatos.add(vacio1);
        panelDatos.add(panel2);

        panelBotones.setLayout(new FlowLayout());
        panelBotones.add(regUsuario);
        regUsuario.addActionListener(eventClick);
        panelBotones.add(regresar);


        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));
        panelContainer.add(titulo);
        panelContainer.add(panelDatos);
        panelContainer.add(panelBotones);

        add(panelContainer);
    }

    private void acciones(){
        regresar.addActionListener(e -> {
            ActualizarOEliminar actualizarOEliminar = new ActualizarOEliminar();
            actualizarOEliminar.setVisible(true);
            this.setVisible(false);
        });
    }

    public class EventClick implements ActionListener {
        public EventClick(){listaUsuarios = new ArrayList<>();}
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre = nombreEntrada.getText();
            String marca = marcaEntrada.getText();
            String cantidad = cantidadEntrada.getText();
            String descripcion = descripcionEntrada.getText();
            String precio = precioEntrada.getText();
            String departamento = departamentoEntrada.getText();


            listaUsuarios.add(new Producto(nombre,marca,cantidad,descripcion,precio,departamento));

            nombreEntrada.setText(" ");
            marcaEntrada.setText(" ");
            cantidadEntrada.setText(" ");
            descripcionEntrada.setText(" ");
            precioEntrada.setText(" ");
            departamentoEntrada.setText(" ");

        }
    }

    public static ArrayList<Producto> getElemento(){
        return listaUsuarios;
    }
}
