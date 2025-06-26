package dev.luisghtz.platzi_market.percistence.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "clientes")
@Data
public class Cliente {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  private String nombre;

  private String apellidos;

  private Long celular;

  private String direccion;

  @Column(name = "correo_electronico")
  private String correoElectronico;

  @OneToMany(mappedBy = "cliente")
  private List<Compra> compras;
}
