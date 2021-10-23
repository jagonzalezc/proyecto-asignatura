package co.edu.uniquindio.proyecto.entidades;

import co.edu.uniquindio.proyecto.entidades.Persona;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Estimacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private float valorEstimado;
    @Column(nullable = false)
    private LocalDate fechaEstimacion;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Moderador moderadorEstimacion;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Producto productoEstimacion;


}
