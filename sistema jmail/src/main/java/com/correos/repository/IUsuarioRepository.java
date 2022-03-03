package com.correos.repository;

import com.correos.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuarios, Long> {



}
