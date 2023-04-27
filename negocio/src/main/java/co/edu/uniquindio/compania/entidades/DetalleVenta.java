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
public class DetalleVenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    private Integer Cantidad;

    private Double precioTotal;

    @ManyToOne
    private Venta venta;

    @ManyToOne
    private Producto producto;

    @Builder
    public DetalleVenta(Integer cantidad, Double precioTotal) {
        Cantidad = cantidad;
        this.precioTotal = precioTotal;
    }
}
