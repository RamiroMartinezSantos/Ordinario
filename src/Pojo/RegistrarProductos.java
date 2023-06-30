package Pojo;

import java.util.ArrayList;

public class RegistrarProductos {
    public ArrayList<Producto> productos;
    public RegistrarProductos(){productos = new ArrayList<>();}
    public void ingresar(ArrayList<Producto> productos,String nombre_del_producto,String marca,String cantidad_en_existencia,String descripcion,String precio,String departamento){
        productos.add(new Producto(nombre_del_producto,marca,cantidad_en_existencia,descripcion,precio,departamento));
    }
    public ArrayList<Producto> getProductos() {
        return productos;
    }
}
