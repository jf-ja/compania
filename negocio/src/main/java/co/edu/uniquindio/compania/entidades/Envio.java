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
public class Envio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @ToString.Exclude
    @OneToMany(mappedBy = "envio")
    private List<Venta> ventas;

    @ManyToOne
    private Direccion direccion;

    @ManyToOne
    private Transportador transportador;


}
