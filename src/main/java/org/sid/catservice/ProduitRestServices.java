package org.sid.catservice;
import org.sid.catservice.dao.ProduitRepository;
import org.sid.catservice.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class ProduitRestServices {

    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping(value = "/listproduits/{id}")
    public Produit lisProduit(@PathVariable(name = "id") Long id){
        return produitRepository.findById(id).get();
    }

    @PutMapping(value = "/listproduits/{id}")
    public Produit update(@PathVariable(name = "id") Long id,@RequestBody Produit p){
        p.setId(id);
        return produitRepository.save(p);
    }

    @PostMapping(value = "/listproduits")
    public Produit save(@RequestBody Produit p){
        return produitRepository.save(p);
    }

    @DeleteMapping(value = "/listproduits/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        produitRepository.deleteById(id);
    }
}
