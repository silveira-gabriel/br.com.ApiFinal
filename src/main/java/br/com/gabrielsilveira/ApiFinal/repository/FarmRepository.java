package br.com.gabrielsilveira.ApiFinal.repository;

import br.com.gabrielsilveira.ApiFinal.model.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {

}
