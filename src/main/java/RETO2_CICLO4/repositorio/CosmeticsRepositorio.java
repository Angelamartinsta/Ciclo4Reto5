/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RETO2_CICLO4.repositorio;

import RETO2_CICLO4.interfaz.InterfaceCosmetics;
import RETO2_CICLO4.modelo.Cosmetics;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ander
 */
@Repository
public class CosmeticsRepositorio {
    @Autowired
    private InterfaceCosmetics InterfaceOrder;
    
public List<Cosmetics> getAll() {
        return InterfaceOrder.findAll();
    }

    public Optional<Cosmetics> getCosmetics(String reference) {
        return InterfaceOrder.findById(reference);
    }
    public Cosmetics create(Cosmetics Cosmetics) {
        return InterfaceOrder.save(Cosmetics);
    }

    public void update(Cosmetics Cosmetics) {
        InterfaceOrder.save(Cosmetics);
    }
    
    public void delete(Cosmetics Cosmetics) {
        InterfaceOrder.delete(Cosmetics);
    }
    //Reto 5
    public List<Cosmetics> productByPrice(double precio){
        return InterfaceOrder.findByPriceLessThanEqual(precio);
    }
    //Reto 5
    public List<Cosmetics> findByDescriptionLike(String description){
        return InterfaceOrder.findByDescriptionLike(description);
    }
}
    
    
    

