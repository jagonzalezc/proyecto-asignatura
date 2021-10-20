package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString
public class Libro implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String isbn;
    private String nombre;
    private Integer unidades;
    private Integer anio;
    @ManyToMany(mappedBy = "libros")
    private List<Prestamo> prestamos;
    @ManyToMany
    @JoinColumn(nullable = false)
    private List<Autor> autores;

    public Libro(String nombre, Integer anio) {
        this.nombre = nombre;
        this.anio = anio;
    }
}
