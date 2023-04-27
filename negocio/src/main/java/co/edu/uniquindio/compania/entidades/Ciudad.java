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
public class Ciudad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    private String nombre;

    @ManyToOne
    private Departamento departamento;

    @ToString.Exclude
    @OneToMany (mappedBy = "ciudad")
    private List<Direccion> direcciones;

    @Builder
    public Ciudad(String nombre) {
        this.nombre = nombre;
    }
}

