package vn.hth.serverAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.hth.serverAPI.models.Index;

public interface IndexRepository extends JpaRepository<Index, Long> {
}
