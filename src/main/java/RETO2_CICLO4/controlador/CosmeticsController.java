/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RETO2_CICLO4.controlador;

import RETO2_CICLO4.modelo.Cosmetics;
import RETO2_CICLO4.servicio.CosmeticsService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ander
 */
@RestController
@RequestMapping("/api/cosmetics")
@CrossOrigin("*")
public class CosmeticsController {
    
    @Autowired
    private CosmeticsService cosmeticsService;
       
     @GetMapping("/all")
    public List<Cosmetics> getAll() {
        return cosmeticsService.getAll();
    }
    
    @GetMapping("/{reference}")
    public Optional<Cosmetics> getFootwears(@PathVariable("reference") String reference) {
        return cosmeticsService.getCosmetics(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Cosmetics create(@RequestBody Cosmetics gadget) {
        return cosmeticsService.create(gadget);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cosmetics update(@RequestBody Cosmetics gadget) {
        return cosmeticsService.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return cosmeticsService.delete(reference);
    } 
    
    @GetMapping("/price/{price}")
    public List<Cosmetics> productByPrice(@PathVariable("price") double precio) {
        return cosmeticsService.productByPrice(precio);
    }

    //Reto 5
    @GetMapping("/description/{description}")
    public List<Cosmetics> findByDescriptionLike(@PathVariable("description") String description) {
        return cosmeticsService.findByDescriptionLike(description);
    }
    
    
}
