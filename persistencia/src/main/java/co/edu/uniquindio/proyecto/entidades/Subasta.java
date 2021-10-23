package co.edu.uniquindio.proyecto.entidades;

import co.edu.uniquindio.proyecto.entidades.Mensaje;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Subasta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    @Column(nullable = false)
    private LocalDate fechaLimite;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Producto productoSubasta;
    @OneToMany (mappedBy = "subastaUsuarioSubasta")
    private List<SubastaUsuario> subastasUsuarios;



}
