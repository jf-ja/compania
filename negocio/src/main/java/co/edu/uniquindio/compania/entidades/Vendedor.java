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

    public Vendedor(Integer codigo, String nombre, String apellido, String correo, String telefono, Double salario, String contrasena) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.salario = salario;
        this.contrasena = contrasena;
    }


}
