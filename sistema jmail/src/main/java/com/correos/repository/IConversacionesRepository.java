package com.correos.repository;

import com.correos.entity.Conversaciones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConversacionesRepository extends JpaRepository<Conversaciones, Long> {
}
