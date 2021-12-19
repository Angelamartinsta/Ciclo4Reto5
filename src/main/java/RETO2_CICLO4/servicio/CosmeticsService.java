/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RETO2_CICLO4.servicio;

import RETO2_CICLO4.modelo.Cosmetics;
import RETO2_CICLO4.repositorio.CosmeticsRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author ander
 */
@Service
public class CosmeticsService {
    
    @Autowired
    private CosmeticsRepositorio cosmeticsRepository;
    
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Cosmetics> getAll() {
        return cosmeticsRepository.getAll();
    }

   public Optional<Cosmetics> getCosmetics(String reference) {
        return cosmeticsRepository.getCosmetics(reference);
    }

    public Cosmetics create(Cosmetics Cosmetics) {
        if (Cosmetics.getReference() == null) {
            return Cosmetics;
        } else {
            return cosmeticsRepository.create(Cosmetics);
        }
    }

    public Cosmetics update(Cosmetics Cosmetics) {

        if (Cosmetics.getReference() != null) {
            Optional<Cosmetics> CosmeticsDb = cosmeticsRepository.getCosmetics(Cosmetics.getReference());
            if (CosmeticsDb.isPresent()) {
                
                if (Cosmetics.getBrand()!= null) {
                    CosmeticsDb.get().setBrand(Cosmetics.getBrand());
                }
                
                if (Cosmetics.getCategory() != null) {
                    CosmeticsDb.get().setCategory(Cosmetics.getCategory());
                }

                if (Cosmetics.getName() != null) {
                    CosmeticsDb.get().setName(Cosmetics.getName());
                }

               
                if (Cosmetics.getDescription() != null) {
                    CosmeticsDb.get().setDescription(Cosmetics.getDescription());
                }
                if (Cosmetics.getPrice() != 0.0) {
                    CosmeticsDb.get().setPrice(Cosmetics.getPrice());
                }
                if (Cosmetics.getQuantity() != 0) {
                    CosmeticsDb.get().setQuantity(Cosmetics.getQuantity());
                }
                if (Cosmetics.getPhotography() != null) {
                    CosmeticsDb.get().setPhotography(Cosmetics.getPhotography());
                }
                
                CosmeticsDb.get().setAvailability(Cosmetics.isAvailability());
                cosmeticsRepository.update(CosmeticsDb.get());
                return CosmeticsDb.get();
            } else {
                return Cosmetics;
            }
        } else {
            return Cosmetics;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getCosmetics(reference).map(Cosmetics -> {
            cosmeticsRepository.delete(Cosmetics);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    //Reto 5
    public List<Cosmetics> productByPrice(double price) {
        return cosmeticsRepository.productByPrice(price);
    }

    //Reto 5
    public List<Cosmetics> findByDescriptionLike(String description) {
        return cosmeticsRepository.findByDescriptionLike(description);
    }
    
}
