package vn.hth.serverAPI.models;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.sql.ast.tree.expression.Collation;

import java.util.Collection;

@Entity
@Table(name = "Property")
@Getter
@Setter
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private Long quotation_id;
    private  String propertyName;

    private String address;
    private String planning;
    private String dataSource;
    @OneToMany(mappedBy = "property_id", cascade = CascadeType.ALL)
    private Collection<Index> indexes;



    public Property() {

    }
}
