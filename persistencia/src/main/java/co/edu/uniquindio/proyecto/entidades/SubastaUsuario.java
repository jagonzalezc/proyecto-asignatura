package co.edu.uniquindio.proyecto.entidades;

import co.edu.uniquindio.proyecto.entidades.Compra;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString
public class SubastaUsuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;
    private float valor;
    private LocalDate fechaSubasta;
    private String medioPago;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Subasta subastaUsuarioSubasta;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuarioSubastaUsuario;

}
