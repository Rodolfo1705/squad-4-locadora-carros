package org.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.system.entity.Aluguel;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {}