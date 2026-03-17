package com.example.LogiTrack.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movimiento_producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "movimiento_id", nullable = false)
    private Movimiento movimiento;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @Column(nullable = false)
    private Integer cantidad;

}
