package br.com.gabrielsilveira.ApiFinal.services;

import br.com.gabrielsilveira.ApiFinal.model.Farm;
import br.com.gabrielsilveira.ApiFinal.repository.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class farmServices {

    @Autowired
   private FarmRepository repository;


    public Farm save(Farm farm){
        return repository.save(farm);
    }

    public Farm findById(long id) throws Exception{
        return repository.findById(id).orElseThrow(()-> new Exception("Not Found!"));
    }

    public Farm update(Farm farm) throws Exception{
        Farm f = repository.findById(farm.getId()).orElseThrow(()-> new Exception("Not Found!"));
        f.setProduto(farm.getProduto());
        f.setDescricao(farm.getDescricao());
        f.setValor(farm.getValor());
        return repository.save(f);
    }
    public List<Farm> findAll(){
        return repository.findAll();
    }

    public void delete(Long id) throws Exception{
        Farm f = repository.findById(id).orElseThrow(()-> new Exception("Not Found!"));
    repository.delete(f);
    }

}
