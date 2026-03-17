package com.example.LogiTrack.Repository;

import com.example.LogiTrack.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
