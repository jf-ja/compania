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
public class Transportador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    private String nombre;

    private String apellido;

    private Double salario;

    private String vehiculo;

    private String placa;

    @ToString.Exclude
    @OneToMany(mappedBy = "transportador")
    private List<Envio> envios;

    @Builder
    public Transportador(String nombre, String apellido, Double salario, String vehiculo, String placa) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
        this.vehiculo = vehiculo;
        this.placa = placa;
    }
}
