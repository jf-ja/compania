package co.edu.uniquindio.compania.entidades;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    private String nombre;

    private Double precio;

    private String descripcion;

    private Integer stock;

    @ManyToOne
    private Subcategoria subCategoria;

    @ToString.Exclude
    @OneToMany(mappedBy = "producto")
    private List<InventarioEntrada> inventarioEntradas;

    @ToString.Exclude
    @OneToMany(mappedBy = "producto")
    private List<InventarioSalida> inventarioSalidas;

    @ToString.Exclude
    @OneToMany(mappedBy = "producto")
    private List<DetalleVenta> detalleVentas;

    @Builder
    public Producto(String nombre, Double precio, String descripcion, Integer stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
    }
}
