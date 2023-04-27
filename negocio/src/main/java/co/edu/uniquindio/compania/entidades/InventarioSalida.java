package co.edu.uniquindio.compania.entidades;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class InventarioSalida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    private Integer cantidad;

    private String descripcion;

    private LocalDate fechaSalida;

    @ManyToOne
    private Producto producto;

    @ManyToOne
    private Vendedor vendedor;

    @Builder
    public InventarioSalida(Integer cantidad, String descripcion, LocalDate fechaSalida) {
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.fechaSalida = fechaSalida;
    }
}
