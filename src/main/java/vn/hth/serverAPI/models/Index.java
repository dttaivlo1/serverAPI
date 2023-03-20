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
    private String id;
    private String indexName;
    private BigDecimal unitPrice;
    private int area;
    private int CLCL;
    private BigDecimal totalPrice;
    @ManyToOne
    @JoinColumn(name = "property_id") // thông qua khóa ngoại address_id
    private Property property;
}
