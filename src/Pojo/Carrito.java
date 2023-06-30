package Pojo;

public class Carrito {
    String nombre_Del_producto;
    String marca;
    String cantidad_En_Existencia;
    String descripcion;
    String precio;
    String departamento;

    public Carrito(String nombre_Del_producto,String marca,String cantidad_En_Existencia,String descripcion,String precio,String departamento){
        this.nombre_Del_producto = nombre_Del_producto;
        this.marca = marca;
        this.cantidad_En_Existencia = cantidad_En_Existencia;
        this.descripcion = descripcion;
        this.precio = precio;
        this.departamento = departamento;
    }
    @Override
    public String toString(){
        return nombre_Del_producto + "nombre_Del_producto" + marca + "marca" + cantidad_En_Existencia + "cantidad_En_Existencia" + descripcion + "descripcion" + precio + "precio" + departamento + "departamento";
    }

    public String getNombre_Del_producto() {
        return nombre_Del_producto;
    }

    public String getMarca() {
        return marca;
    }

    public String getCantidad_En_Existencia() {
        return cantidad_En_Existencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public String getDepartamento() {
        return departamento;
    }
}
