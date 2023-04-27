package co.edu.uniquindio.compania.entidades;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class InventarioEntrada implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    private Integer cantidad;

    private String descripcion;

    private LocalDate fechaEntrada;

    @ManyToOne
    private Producto producto;

    @ManyToOne
    private Vendedor vendedor;

    @Builder
    public InventarioEntrada(Integer cantidad, String descripcion, LocalDate fechaEntrada) {
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.fechaEntrada = fechaEntrada;
    }
}
