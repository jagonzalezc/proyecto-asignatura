package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Usuario extends Persona implements Serializable{

    @Column(length = 155, nullable = false)
    private String email;
    @ElementCollection
    private List<String> telefono;
    @ElementCollection
    private Map<String, String> direccion;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad ciudad;
    @OneToMany (mappedBy = "usuarioPrestamo")
    private List<Prestamo> prestamos;

    public Usuario(){
        super();
    }
}
