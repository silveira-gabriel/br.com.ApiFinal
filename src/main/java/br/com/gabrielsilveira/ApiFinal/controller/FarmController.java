package br.com.gabrielsilveira.ApiFinal.controller;

import br.com.gabrielsilveira.ApiFinal.model.Farm;
import br.com.gabrielsilveira.ApiFinal.services.farmServices;
import br.com.gabrielsilveira.ApiFinal.services.farmServicesV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people/v1")
public class FarmController {

    @Autowired
    private farmServices services;

    @PostMapping
    public Farm save(@RequestBody Farm farm){
        return services.save(farm);
    }

    @GetMapping
    public List<Farm> findAll(){
        return services.findAll();
    }

    @GetMapping("/{id}")
    public Farm findById(@PathVariable("id") long id) throws Exception{
    return services.findById(id);
    }


    @PutMapping
    public Farm update(@RequestBody Farm farm) throws Exception{
        return services.update(farm);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) throws Exception{
    services.delete(id);
    return ResponseEntity.ok().build();

    }

}

