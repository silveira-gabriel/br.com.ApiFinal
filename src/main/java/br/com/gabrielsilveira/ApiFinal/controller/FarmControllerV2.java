package br.com.gabrielsilveira.ApiFinal.controller;

import br.com.gabrielsilveira.ApiFinal.model.Farm;
import br.com.gabrielsilveira.ApiFinal.services.farmServices;
import br.com.gabrielsilveira.ApiFinal.services.farmServicesV2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(value = "Farm Endpoint V2", tags = {"Farm", "Model", "Endepoint"})
@RestController
@RequestMapping("/people/v2")
public class FarmControllerV2 {

    @Autowired
    private farmServicesV2 services;
    @ApiOperation(value = "Persist an Farm", response = Farm.class)
    @PostMapping
    public Farm save(@RequestBody Farm farm){
        return services.save(farm);
    }

    @ApiOperation(value = "Find all people from database", response = List.class)
    @GetMapping
    public List<Farm> findAll(){
        return services.findAll();
    }

    @ApiOperation(value = "Find a Person by id", response = Farm.class)
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

    @GetMapping("/query/{produto}")
    public List<Farm> listByName(@PathVariable("produto") String produto){
        return services.listByName(produto);
    }

}

