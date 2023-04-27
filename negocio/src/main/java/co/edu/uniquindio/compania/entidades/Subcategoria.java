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
public class Subcategoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    private String nombre;

    @ManyToOne
    private Categoria categoria;

    @ToString.Exclude
    @OneToMany(mappedBy = "subCategoria")
    private List<Producto> productos;


    @Builder
    public Subcategoria(String nombre) {
        this.nombre = nombre;
    }
}
