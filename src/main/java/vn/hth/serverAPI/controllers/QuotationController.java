package vn.hth.serverAPI.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import vn.hth.serverAPI.models.Quotation;
import vn.hth.serverAPI.repositories.QuotationRepository;
import javax.validation.Valid;


import java.io.Console;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


@RestController
@RequestMapping(path = "/api/v1/quotation")
public class QuotationController {
    @Autowired
    private QuotationRepository quotationRes;
    @GetMapping("/getAll")
    public List<Quotation> getQuestions(Pageable pageable) {
        return quotationRes.findAll();
    }
    @PostMapping(value = "/new", consumes = "application/json", produces = "application/json")
    public String createQuestion(@RequestBody Quotation quotation) {
           quotation =     quotationRes.save(quotation);
           var a = quotationRes.findById(quotation.getId());
       return a.get().getId().toString();
    }

}

