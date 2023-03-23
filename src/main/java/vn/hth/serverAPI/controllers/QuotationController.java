package vn.hth.serverAPI.controllers;



import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import vn.hth.serverAPI.models.Index;
import vn.hth.serverAPI.models.Property;
import vn.hth.serverAPI.models.Quotation;
import vn.hth.serverAPI.repositories.IndexRepository;
import vn.hth.serverAPI.repositories.PropertyRepository;
import vn.hth.serverAPI.repositories.QuotationRepository;

import java.util.*;


@RestController
@RequestMapping(path = "/api/v1/quotation")
public class QuotationController {
    @Autowired private QuotationRepository quotationRes;
    @Autowired  private PropertyRepository propertyRes;
    @Autowired  private IndexRepository indexRepository;
    //Quotation API

        @GetMapping("/getAllQuotation")
    public ResponseEntity getAll()  {
        return  sender(quotationRes.findAll());
    }
    @CrossOrigin
    @PostMapping(value = "/create", produces = "application/json")
    public Quotation createQuestion(@RequestBody ObjectNode payload) {
        System.out.println(payload.get("userData"));
        ObjectMapper objectMapper = new ObjectMapper();
        Quotation userData = quotationRes.save(objectMapper.convertValue(payload.get("userData"), Quotation.class));
       // var properties = payload.get("propertyData") ;
        ArrayList<Index> indexes = new ArrayList<>();
        int loop1 =0;
        int loop2 = 0;
        for (JsonNode temp: payload.get("propertyData")
             ) {
            Property property = new Property();
                   property.setId(45L);
                   property.setQuotation_id(userData.getId());
                   property.setPropertyName(temp.get("name").asText());
                   property.setAddress(temp.get("address").asText());
                   property.setPlanning(temp.get("planning").asText());
                   property.setDataSource(temp.get("source").asText());//      properties.add(a);
            property =  propertyRes.save(property);
            System.out.println("mã tài sản thứ " +property.getId());
            for (JsonNode indexData: temp.get("indexData")
                 ) {
               try {
                   Index index = new Index();
                   index.setId(24534L);
                   index.setIndexName("alodoawd");
                   index.setProperty_id(property.getId());
                   index.setUnitPrice(indexData.get("unitPrice").decimalValue());
                   index.setArea(indexData.get("amount").floatValue());
                   index.setCLCL(indexData.get("quality").asInt());
                   index.setTotalPrice(indexData.get("totalPrice").decimalValue());
                   System.out.println(index.toString());
                   System.out.println("Đang tiến hành lưu vào csdl"+ index.getId().toString());
                   index = indexRepository.save(index);
                   System.out.println("Có lỗi " + index.getId());
               }
               catch (Exception e) {
                   System.out.println("Có lỗi " + e.getMessage());
               }
            }
        }
        return userData;
    }
    @GetMapping(value ="/{id}")
    public  ResponseEntity<Quotation> getQuotation(@PathVariable Long id){
        Optional<Quotation>  quotation = quotationRes.findById(id);
        return sender(quotation);
    }
    public ResponseEntity sender(Object object) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*" );
        responseHeaders.set("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        return ResponseEntity.ok().headers(responseHeaders).body(object);
    }
    //Property API

}

