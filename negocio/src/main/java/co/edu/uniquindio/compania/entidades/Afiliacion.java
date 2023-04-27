package co.edu.uniquindio.compania.entidades;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Afiliacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    private Integer nivel;

    private Boolean estado;

    private LocalDate fecha;

    private Double porcentaje;

    private Double descuentoCompra;

    @ToString.Exclude
    @OneToMany(mappedBy = "afiliacion")
    private List<Vendedor> vendedores;

    @Builder
    public Afiliacion(Integer nivel, Boolean estado, LocalDate fecha, Double porcentaje, Double descuentoCompra) {
        this.nivel = nivel;
        this.estado = estado;
        this.fecha = fecha;
        this.porcentaje = porcentaje;
        this.descuentoCompra = descuentoCompra;
    }
}
