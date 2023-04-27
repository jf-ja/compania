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
public class Venta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    private LocalDate fecha;

    private String descripcion;

    private Boolean estado;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Vendedor vendedor;

    @OneToOne
    private Envio envio;

    @ToString.Exclude
    @OneToMany(mappedBy = "venta")
    private List<DetalleVenta> detalleVentas;


    @Builder
    public Venta(LocalDate fecha, String descripcion, Boolean estado) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.estado = estado;
    }
}
