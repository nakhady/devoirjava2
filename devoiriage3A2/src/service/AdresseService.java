package service;

import java.util.List;

import entities.Adresse;
import repositories.AdresseRepository;

public class AdresseService {
    
    private AdresseRepository adresseRepository= new AdresseRepository();

    public void ajouterAdresse(Adresse adresse){
        adresseRepository.insertAdresse(adresse);
    }
    public List<Adresse> listerAdresse(){
        return adresseRepository.getAllAdresses();
  }
    
}
