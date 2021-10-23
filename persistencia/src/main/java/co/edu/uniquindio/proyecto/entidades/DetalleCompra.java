package co.edu.uniquindio.proyecto.entidades;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString
public class DetalleCompra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;
    private LocalDate fechaPrestamo;
    private Integer unidades;
    private float precio;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Compra compraDetalleCompra;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Compra productoDetalleCompra;

}
