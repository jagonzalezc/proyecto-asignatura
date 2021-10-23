package co.edu.uniquindio.proyecto.entidades;

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
public class Compra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    @OneToMany (mappedBy = "compraDetalleCompra")
    private List<DetalleCompra> detallesCompras;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuarioCompra;



}
