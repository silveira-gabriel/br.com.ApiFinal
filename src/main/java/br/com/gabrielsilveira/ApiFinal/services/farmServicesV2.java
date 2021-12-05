package br.com.gabrielsilveira.ApiFinal.services;

import br.com.gabrielsilveira.ApiFinal.model.Farm;
import br.com.gabrielsilveira.ApiFinal.repository.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Service
public class farmServicesV2 {

    @Autowired
  private  FarmRepository repository;
    @Autowired
    private EntityManager em;


    public Farm save(Farm farm){
       farm.setRegisterDate(new Date());
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
        f.setGender(farm.getGender());
        return repository.save(f);
    }
    public List<Farm> findAll(){
        return repository.findAll();
    }

    public void delete(long id) throws Exception{
        Farm f = repository.findById(id).orElseThrow(()-> new Exception("Not Found!"));
    repository.delete(f);
    }


    public List<Farm> listByName(String produto){
        String hql = "from Farm where produto like"
                + ":name order by produto";
        Query query = em.createQuery(hql);
        query.setParameter("name", produto + "%");
        List<Farm> people = query.getResultList();
        return people;
    }

}
