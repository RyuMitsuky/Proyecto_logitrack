package com.example.LogiTrack.Repository;
import com.example.LogiTrack.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
