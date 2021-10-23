package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String nombre;
    private Integer unidades;
    private String descripcion;
    private float precio;
    @Column(nullable = false)
    private LocalDate fechaLimite;
    private float descuento;

    @ManyToMany(mappedBy = "productos")
    private List<Usuario> usuarios;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad ciudadProducto;
    @OneToMany (mappedBy = "productoComentario")
    private List<Comentario> comentarios;
    @OneToMany (mappedBy = "productoDetalleCompra")
    private List<DetalleCompra> detallesCompras;
    @OneToMany (mappedBy = "productoSubasta")
    private List<Subasta> subastasProductos;
    @OneToMany (mappedBy = "productoEstimacion")
    private List<Estimacion> estimaciones;

    @Enumerated(EnumType.STRING)
    private CategoriaProducto categoriaProducto;
    @ElementCollection
    private Map<String, String> imagen;


}
