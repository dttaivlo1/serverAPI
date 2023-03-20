package vn.hth.serverAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.hth.serverAPI.models.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
