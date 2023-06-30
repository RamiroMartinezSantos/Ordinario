package Administrador;
import Pojo.Producto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ActualizarOEliminar extends JFrame{

    private JPanel panelContainer,panelTabla,panelBotones,panelDatos,panel1,panel2,panel3,panel4;
    private JLabel titulo,nombre,marca,cantidad,descripcion,precio,departamaneto;
    private JTextField nombreEntrada,marcaEntrada,cantidadEntrada,descripcionEntrada,precioEntrada,departamentoEntrada;
    private JList<Producto> lista;
    private DefaultListModel<Producto> elementos;
    private JButton eliminar,actualizar,regresar;
    private JLabel vacio1;

        public ActualizarOEliminar(){
        initControl();
        configFrame();
        configLista();
        setControl();
        configPanel();
        acciones();
    }

    private void configFrame(){
        setTitle("Consultar");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(600, 400);
    }

    private void configLista(){
        elementos = new DefaultListModel<>();
        for (Producto elemento : RegistrarProducto.getElemento()) {
            elementos.addElement(elemento);
        }
        lista.setModel(elementos);
    }

    private void initControl(){
        lista = new JList<>();

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

        panelContainer = new JPanel();
        panelTabla = new JPanel();
        panelBotones = new JPanel();
        panelDatos = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();

        eliminar = new JButton();
        actualizar = new JButton();
        regresar = new JButton();
    }

    private void setControl(){
        titulo.setText("VACANTES PUBLICADAS");
        eliminar.setText("Eliminar");
        actualizar.setText("Actualizar");
        regresar.setText("Regresar");

        nombre.setText("Nombre completo");
        marca.setText("Marca");
        cantidad.setText("Cantidad");
        descripcion.setText("Descripcion");
        precio.setText("precio");
        departamaneto.setText("Departamento");

    }

    private void configPanel(){
        //Se ingresa la lista dentro de un panel
        panelTabla.setLayout(new GridLayout(1,1));
        panelTabla.setPreferredSize(new Dimension(350,100));
        panelTabla.add(lista);

        panelBotones.setLayout(new FlowLayout());
        panelBotones.add(eliminar);
        panelBotones.add(actualizar);
        panelBotones.add(regresar);

        panel1.setLayout(new GridLayout(3,1));
        panel1.add(nombre);
        panel1.add(marca);
        panel1.add(cantidad);

        panel2.setLayout(new GridLayout(3,1));
        panel2.add(nombreEntrada);
        panel2.add(marcaEntrada);
        panel2.add(cantidadEntrada);

        panel3.setLayout(new GridLayout(3,1));
        panel3.add(descripcion);
        panel3.add(precio);
        panel3.add(departamaneto);

        panel4.setLayout(new GridLayout(3,1));
        panel4.add(descripcionEntrada);
        panel4.add(precioEntrada);
        panel4.add(departamentoEntrada);

        panelDatos.setLayout(new GridLayout(1,4));
        panelDatos.add(panel1);
        panelDatos.add(panel2);
        panelDatos.add(panel3);
        panelDatos.add(panel4);

        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));
        panelContainer.add(panelTabla);
        panelContainer.add(vacio1);
        panelContainer.add(panelBotones);
        panelContainer.add(panelDatos);

        add(panelContainer);
    }

    private void acciones(){

        lista.addListSelectionListener(e -> {
            consulta();
        });

        regresar.addActionListener(e -> {
            MenuAdministrador menuAdministrador = new MenuAdministrador();
            menuAdministrador.setVisible(true);
            this.setVisible(false);
        });

        actualizar.addActionListener(e -> {
            Actualizar actualizar1 = new Actualizar();
            actualizar1.setVisible(true);
            this.setVisible(false);
        });

        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = lista.getSelectedIndex();
                if(x != -1){
                    elementos.remove(x);
                    lista.remove(x);
                }
            }
        });
    }

    public void consulta(){
        int x =lista.getSelectedIndex();

        nombreEntrada.setText(RegistrarProducto.getElemento().get(x).getNombre_Del_producto());
        marcaEntrada.setText(RegistrarProducto.getElemento().get(x).getMarca());
        cantidadEntrada.setText(RegistrarProducto.getElemento().get(x).getCantidad_En_Existencia());
        descripcion.setText(RegistrarProducto.getElemento().get(x).getDescripcion());
        precioEntrada.setText(RegistrarProducto.getElemento().get(x).getPrecio());
        departamentoEntrada.setText(RegistrarProducto.getElemento().get(x).getDepartamento());
    }
}
