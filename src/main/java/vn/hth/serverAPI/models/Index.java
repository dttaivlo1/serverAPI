package vn.hth.serverAPI.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "Index")
@Getter
@Setter
public class Index {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String indexName;
    private BigDecimal unitPrice;
    private float area;
    private int CLCL;
    private BigDecimal totalPrice;
    private Long property_id;
}
