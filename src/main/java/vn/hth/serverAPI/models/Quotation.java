package vn.hth.serverAPI.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;
@Entity
@Table(name = "Quotation")
@Getter
@Setter
public class Quotation  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String cusName;
    private  String phone;
    private String requestBy;
    private  String responseBy;
    private Date createAt;



    private boolean status;

    @OneToMany(mappedBy = "quotation", cascade = CascadeType.ALL)
    private Collection<Property> properties;

}

