package vn.hth.serverAPI.models;

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
    private  String propertyName;
    private String address;
    private String planning;
    private String dataSource;
    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private Collection<Index> indexes;
    @ManyToOne
    @JoinColumn(name = "quotation_id") // thông qua khóa ngoại address_id
    private Quotation quotation;

}
