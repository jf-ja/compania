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
public class Vendedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    private String nombre;

    private String apellido;

    private String correo;

    private String telefono;

    private Double salario;

    private String contrasena;


    private Boolean estado_afiliacion;

    @ToString.Exclude
    @OneToMany(mappedBy = "vendedor")
    private List<InventarioEntrada> inventarioEntradas;

    @ToString.Exclude
    @OneToMany(mappedBy = "vendedor")
    private List<InventarioSalida> inventarioSalidas;

    @ManyToOne
    private Afiliacion afiliacion;

    @ManyToOne
    private Direccion direccion;

    @ToString.Exclude
    @OneToMany (mappedBy = "vendedor")
    private List<Venta> ventas;

    @ManyToOne
    private Vendedor vendedorJefe;

    @Builder
    public Vendedor(String nombre, String apellido, String correo, String telefono, Double salario, String contrasena, Boolean estado_afiliacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.salario = salario;
        this.contrasena = contrasena;
        this.estado_afiliacion = estado_afiliacion;
    }
}
