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
public class Departamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    private String nombre;

    @ManyToOne
    private Pais pais;

    @ToString.Exclude
    @OneToMany (mappedBy = "departamento")
    private List<Ciudad> ciudades;
    @Builder
    public Departamento(String nombre) {
        this.nombre = nombre;
    }
}
