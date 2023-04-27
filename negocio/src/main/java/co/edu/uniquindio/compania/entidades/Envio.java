package co.edu.uniquindio.compania.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Envio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @OneToOne
    private Venta venta;

    @ManyToOne
    private Direccion direccion;

    @ManyToOne
    private Transportador transportador;


}
