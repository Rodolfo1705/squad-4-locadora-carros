package org.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.system.model.Motorista;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, Long> {}
