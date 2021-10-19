package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@ToString
public class Persona implements Serializable{

    @Id
    @EqualsAndHashCode.Include
    private String cedula;
    private String nombre;
    private String email;
    @ElementCollection
    private List<String> telefono;
    @ElementCollection
    private Map<String, String> direccion;
    @Enumerated(EnumType.STRING)
    private GeneroPersona generoPersona;

    public Persona(){
        super();
    }
}
