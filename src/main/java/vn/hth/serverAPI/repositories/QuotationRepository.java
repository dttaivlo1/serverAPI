package vn.hth.serverAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.hth.serverAPI.models.Property;
import vn.hth.serverAPI.models.Quotation;

import java.util.List;

public interface QuotationRepository  extends JpaRepository<Quotation, Long> {
}

