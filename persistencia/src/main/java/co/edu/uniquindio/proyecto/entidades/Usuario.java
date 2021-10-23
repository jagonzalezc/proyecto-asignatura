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
    @ManyToMany
    @JoinColumn(nullable = false)
    @ToString.Exclude
    private List<Producto> productos;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad ciudadUsuario;
    @OneToMany (mappedBy = "usuarioComentario")
    private List<Comentario> comentarios;
    @OneToMany (mappedBy = "usuarioCompra")
    private List<Compra> compras;
    @OneToMany (mappedBy = "chatUsuario")
    private List<Chat> chats;
    @OneToMany (mappedBy = "usuarioSubastaUsuario")
    private List<SubastaUsuario> subastasUsuarios;

    public Usuario(){
        super();
    }

    public Usuario(String codigo, String nombre, LocalDate fechaNacimiento,  String email, List<String> telefono, Map<String, String> direccion) {
        super(codigo, nombre, fechaNacimiento);
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;

    }
}
