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
public class Direccion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    private String direccion;

    private String tipo;

    @ManyToOne
    private Ciudad ciudad;

    @ToString.Exclude
    @OneToMany (mappedBy = "direccion")
    private List<Vendedor> vendedores;

    @ToString.Exclude
    @OneToMany (mappedBy = "direccion")
    private List<Cliente> clientes;

    @ToString.Exclude
    @OneToMany (mappedBy = "direccion")
    private List<Envio> envios;

    @Builder
    public Direccion(String direccion, String tipo) {
        this.direccion = direccion;
        this.tipo = tipo;
    }
}
