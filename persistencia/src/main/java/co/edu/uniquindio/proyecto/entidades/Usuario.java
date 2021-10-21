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
@AllArgsConstructor
@ToString(callSuper = true)
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
    @ToString.Exclude
    private List<Prestamo> prestamos;

    public Usuario(){
        super();
    }

    public Usuario(String codigo, String nombre, LocalDate fechaNacimiento, GeneroPersona generoPersona, String email, List<String> telefono, Map<String, String> direccion, Ciudad ciudad) {
        super(codigo, nombre, fechaNacimiento, generoPersona);
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }
}
