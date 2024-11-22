package br.com.api.advmanager.repository;

import br.com.api.advmanager.models.Feriado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeriadoRepository extends JpaRepository<Feriado, Long> {
}
