package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Adresse;


public class AdresseRepository extends Database{

    private final  String SQL_SELECT_ALL="select * from adresse a, client c where a.client_id=b.id_client" ;
    private final  String SQL_INSERT="INSERT INTO `adresse` (`ville`, `quartier`, `num_villa`) VALUES (?,?,?)";


   
        public void insertAdresse(Adresse adresse){
            openConnexion();
            try {
                initPreparedStatement(SQL_INSERT);
                statement.setString(1, adresse.getVille());
                statement.setString(2, adresse.getQuartier());
                statement.setInt(3, adresse.getNumVilla());
                int nbreLigne=executeUpdate();
            closeConnexion();
            } catch (SQLException e) {
            e.printStackTrace();
            }
        }
    
       public List<Adresse> getAllAdresses(){
            List<Adresse> adresses=new ArrayList<>();
       try {
           openConnexion();
           initPreparedStatement(SQL_SELECT_ALL);
           ResultSet rs= executeSelect();
             while (rs.next()) {
                  Adresse adresse=new Adresse();
                   adresse.setId(rs.getInt("id"));
                   adresse.setVille(rs.getString("ville"));
                   adresse.setQuartier(rs.getString("quartier"));
                   adresse.setNumVilla(rs.getInt("num_villa"));
                   adresses.add(adresse);
             }
             rs.close();
           closeConnexion();
        }
         catch (SQLException e) {
              System.out.println("Erreur de Connexion a la BD");
        }
        return  adresses;
       }


    

    
    
}
