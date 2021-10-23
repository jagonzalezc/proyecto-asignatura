package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Moderador extends Persona implements Serializable{

    @Positive
    @Max(9999)
    @Column(nullable = false)
    private Integer reputacion;
    @OneToMany (mappedBy = "moderadorEstimacion")
    private List<Estimacion> estimaciones;


}
