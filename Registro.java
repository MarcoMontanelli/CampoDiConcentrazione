import java.util.*;
import java.time.*;

public class Registro
{
    private HashMap <String, HashMap<String, ArrayList<Studente>>> scuole;
    public Registro(){
        this.scuole= new HashMap();
    }
    public void aggiungiScuola(String scuolap){
        if (scuole.get(scuolap)== null){
            HashMap <String, ArrayList<Studente>> temp = new HashMap();
            temp.put(null, null);
        }
        else {
            System.out.println("sei un mona, eiste già");
        }
    }
    public void aggiungiClasse(String classe, String scuola){
        if (scuole.get(scuola)== null){
            HashMap <String, ArrayList<Studente>> temp = new HashMap();
            temp.put(classe, null);
        }
        else{
           scuole.get(scuola).put(classe, null); 
        }
    }
    public void aggiungiStudente (String nomep, LocalDate nascitae, String classep, String scuolap){
        Studente temporaneo= new Studente(nomep, nascitae);
         if (scuole.get(scuolap)== null){
            HashMap <String, ArrayList<Studente>> temp = new HashMap();
            ArrayList<Studente> teemp = new ArrayList();
            teemp.add(temporaneo);
            temp.put(classep, teemp);
        }
        else if (scuole.get(scuolap) != null && scuole.get(scuolap).get(classep) == null){
            ArrayList<Studente> teemp = new ArrayList();
            teemp.add(temporaneo);
           scuole.get(scuolap).put(classep,teemp); 
        }
        else {
            ArrayList<Studente> teeemp =scuole.get(scuolap).get(classep);
            teeemp.add(temporaneo);
        }
    }
    public void aggiungiVoto (Studente s, int Voto, String classep, String scuolap, String materiap){
        
        if (scuole.get(scuolap)== null){
            HashMap <String, ArrayList<Studente>> temp = new HashMap();
            ArrayList<Studente> teemp = new ArrayList();
            teemp.add(s);
            temp.put(classep, teemp);
        }
        else if (scuole.get(scuolap) != null && scuole.get(scuolap).get(classep) == null){
            ArrayList<Studente> teemp = new ArrayList();
            teemp.add(s);
           scuole.get(scuolap).put(classep,teemp); 
        }
        else if(scuole.get(scuolap).get(classep).contains(s)==false){
            ArrayList<Studente> teeemp =scuole.get(scuolap).get(classep);
            s.aggiungiVoto(Voto, materiap);
            teeemp.add(s);
        }
        else{
            int bello=scuole.get(scuolap).get(classep).indexOf(s);
            Studente teeemp =scuole.get(scuolap).get(classep).get(bello);
            teeemp.aggiungiVoto(Voto, materiap);
            
        }
    }
}
