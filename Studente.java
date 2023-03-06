import java.time.*;
import java.util.*;

public class Studente
{
    private HashMap<String, ArrayList<Integer>> voti;
    private LinkedList<String> note;
    private int numero = 0;
    private LocalDate nascita;
    private String nome;
    public Studente(String nomep, LocalDate datapBella)
    {
       this.voti=new HashMap();
       this.note=new LinkedList();
       this.nascita= datapBella;
       this.nome= nomep;
    }

    public void aggiungiVoto (int voto, String materia){
        Integer votoger= Integer.valueOf(voto);
        if(voti.get(materia) ==null){
            ArrayList<Integer> temp = new ArrayList();
            temp.add(votoger);
            voti.put(materia, temp);            
        }
        else{
          ArrayList<Integer> temp = voti.get(materia);
          temp.add(votoger);
        }
    }
    
    public void aggiungiVotiArray (ArrayList<Integer> votip, String materia){
        if(voti.get(materia) ==null){  
            voti.put(materia, votip);            
        }
        else{
          ArrayList<Integer> temp = voti.get(materia);
          temp.addAll(votip);
        }
    }
    
    public void aggiungiNota (String nota){
        note.add(nota);
    }
    
    public void aggiungiNoteArray (LinkedList<String> notep){
        note.addAll(notep);
    }
    
    public ArrayList<Integer> getVotiMateria (String materia) throws MarkDoesntExistException{
        ArrayList<Integer> votip =new ArrayList();
        votip=voti.get(materia);
        if(votip.size()==0){
            throw new MarkDoesntExistException();
        }
        Iterator <Integer> i = votip.iterator();
        while(i.hasNext()){
           Integer temp=i.next();
           votip.add (temp);
        } 
        return votip;
    }
    
    public Integer getVoto (int index, String materia) throws MarkDoesntExistException{
        Integer votoBello=0;
        ArrayList<Integer> votip =new ArrayList();
        votip=voti.get(materia);
        if(votip.size()==0){
            throw new MarkDoesntExistException();
        }
        for (int i=0; i<index;i++){
            votoBello=votip.get(i);
        }
        return votoBello;
    }
    
    public String getNota (int index){
        String nota =this.note.get(index);
        return nota;
    }
    
    public LinkedList<String> getNote (){
        LinkedList<String> notep=new LinkedList();
        Iterator <String> i = this.note.iterator();
        while(i.hasNext()){
           String temp=i.next();
           notep.add (temp);
        }
        return notep;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public LocalDate getNascita(){
        return this.nascita;
    }
    
    public int getNumero(){
        return this.numero;
    }
}
