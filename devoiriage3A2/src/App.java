import java.util.List;
import java.util.Scanner;

import entities.Adresse;
import entities.Client;
import entities.adresse;
import service.AdresseService;
import service.ClientService;

public class App {
    public static void main(String[] args) throws Exception {
        int choix;
        Scanner sc=new Scanner(System.in);
        AdresseService adresseService=new AdresseService();
        ClientService clientService=new ClientService();
       
        do {
            System.out.println("1-Créer un client");
            System.out.println("2-Lister les clients"); 
            System.out.println("3-Ajouter une adresse et lui associer un client"); 
            System.out.println("4-Lister les adresses en ajoutant le nom du client");
            System.out.println("5-Quitter"); 
             choix=sc.nextInt();
             sc.nextLine();
             switch (choix) {
                case 1:
                     System.out.println("Entrer le nom du client");
                     String nomComplet=sc.nextLine(); 
                     System.out.println("Entrer le téléphone du client");
                     int telephone=sc.nextInt(); 
                     System.out.println("Entrer le mail du client");
                     String email=sc.nextLine(); 
                     Client client=new Client();
                     client.setNomComplet(nomComplet);
                     client.setTelephone(telephone);
                     client.setEmail(email);
                      clientService.ajouterClient(client);
                    break;
                case 2:
                    List<Client> clients= clientService.listerClient();
                    for (Client cl : clients) {
                        System.out.println("ID : "+cl.getId() ); 
                        System.out.println("NOM : "+cl.getNomComplet() );     
                        System.out.println("Telephone : "+cl.getTelephone() );  
                        System.out.println("Email : "+cl.getEmail() );  
                    }
                  
                    break; 
                    
              case 3:
                     System.out.println("Entrer le nom de la ville");
                     String nom=sc.nextLine(); 
                     System.out.println("Entrer le quartier");
                     String quartier=sc.nextLine(); 
                     System.out.println("Entrer le numero de la villa");
                     int numero=sc.nextInt(); 
                     adresses= adresseService.ajouterAdresse(); 
                        for (adresse ad : adresses) {
                            System.out.println(ad.getId()+"-"+ad.getVille()+ad.getQuartier()+ad.getNumVilla());   
                        }
                       System.out.println("Entrer Id d'un client");
                       int id_client=sc.nextInt();
                       client=new Client();
                       client.setId(id_client);
                       Adresse adresse=new Adresse();
                       adresse.setVille(ville);
                       adresse.setQuartier(quartier);
                       adresse.setNumVilla(numVilla);;
                       adresse.setClient(client);
                       adresseService.ajouterAdresse(adresse);
                   break;

                   case 4:
                   List<Adresse> adresses= adresseService.listerAdresse();
                   for (Adresse ad : adresses) {
                       System.out.println("ID : "+ad.getId() ); 
                       System.out.println("Ville : "+ad.getVille() ); 
                       System.out.println("Quartier : "+ad.getQuartier() ); 
                       System.out.println("Numero villa : "+ad.getNumVilla());   
                       System.out.println("client : "+ad.getClient().getNomComplet() ); 
                       System.out.println("------------------------------------");      
                   }
                 
                   break; 
                    
            }
          } while (choix!=5);
    }
    }

