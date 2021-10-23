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
public class Comentario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String mensaje;
    private String respuesta;
    @Column(nullable = false)
    private LocalDate fechaComentario;
    private Integer calificacion;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Producto productoComentario;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuarioComentario;


}
