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
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    private String nombre;

    @ToString.Exclude
    @OneToMany (mappedBy = "categoria")
    private List<Subcategoria> subcategorias;

    @Builder
    public Categoria(String nombre) {
        this.nombre = nombre;
    }
}
