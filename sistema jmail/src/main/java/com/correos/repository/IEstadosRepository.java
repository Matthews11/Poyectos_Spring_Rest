package com.correos.repository;

import com.correos.entity.Estados;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstadosRepository extends JpaRepository<Estados,Long> {
}
