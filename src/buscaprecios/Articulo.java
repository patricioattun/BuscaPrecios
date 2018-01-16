
package buscaprecios;


public class Articulo {
    private String barras;
    private String descripcion;
    private Double precio;
    private Double precioOriginal;
    private Integer seccion;
    private String seccionNombre;
    private Promocion promocion;
    private Integer codigoInt;

    public String getSeccionNombre() {
        return seccionNombre;
    }

    public void setSeccionNombre(String seccionNombre) {
        this.seccionNombre = seccionNombre;
    }
 
    public Integer getCodigoInt() {
        return codigoInt;
    }

    public void setCodigoInt(Integer codigoInt) {
        this.codigoInt = codigoInt;
    }
    
    
    public Double getPrecioOriginal() {
        return precioOriginal;
    }

    public void setPrecioOriginal(Double precioPos) {
        this.precioOriginal = precioPos;
    }

    
    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    
    public Integer getSeccion() {
        return seccion;
    }

    public void setSeccion(Integer seccion) {
        this.seccion = seccion;
    }
    

    public String getBarras() {
        return barras;
    }

    public void setBarras(String barras) {
        this.barras = barras;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
}
