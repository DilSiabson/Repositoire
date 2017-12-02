/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employe;

/**
 *
 * @author Prime_Optimus2
 */
public abstract class Employe{
    private String matricule,
                   nom,
                   prenom;
    private int entre_service,
                age;
    public final double SalaireBasique=110000;
    
   public Employe(String matricule,String nom,String prenom,int age,int anneeRecrutement){
       this.matricule=matricule;
       this.nom=nom;
       this.prenom=prenom;
       this.age=age;
       entre_service=anneeRecrutement;
    }
    public String getNom(){
       return "l'employe "+nom+" "+prenom;
   }
     public double CalculerSalaire(){
       return SalaireBasique ;
   }
    public String getMatricule(){
        return matricule;
    }
    public int getAge(){
        return age;
    }
    public int getAnneeRecrutement(){
        return entre_service;
    }
}   
   
abstract class Commerciaux extends Employe{
    protected final double taux=0.2;
    private double ChiffreAffaire;
    public Commerciaux(String matricule,String nom,String prenom,
                        int age,int anneeRecrutement,double ChiffreAffaire){
        super(matricule,nom,prenom,age,anneeRecrutement);
        this.ChiffreAffaire=ChiffreAffaire;
    }
        
        public double CalculerSalaire(){
        return super.CalculerSalaire()+ChiffreAffaire*taux;
    }
    }
    

class Vendeur extends Commerciaux{
    public final int bonusVendeur=100;
    public Vendeur(String matricule,String nom,String prenom,
                    int age,int anneeRecrutement,double ChiffreAffaire){
      super(matricule,nom,prenom,age,anneeRecrutement,ChiffreAffaire);
    }
    public double CalculerSalaire(){
        return super.CalculerSalaire()+bonusVendeur;
    }
}
    
class Representant extends Commerciaux{
    protected final int bonusRepresentant=200;
    public Representant(String matricule,String nom,String prenom,
                        int age,int anneeRecrutement,double ChiffreAffaire){
        super(matricule,nom,prenom,age,anneeRecrutement,ChiffreAffaire);
    }
    public double CalculerSalaire(){
        return super.CalculerSalaire()+bonusRepresentant;
    }
}

class Producteur extends Employe{
    private int nbreProduit;
    public final int prixUnite=5;
    public Producteur(String matricule,String nom,String prenom,
                        int age,int anneeRecrutement,int nbreProduit){
        super(matricule,nom,prenom,age,anneeRecrutement);
        this.nbreProduit=nbreProduit;
    }
    public double CalculerSalaire(){
        return super.CalculerSalaire()+nbreProduit*prixUnite;
    }
}

class Manutentionnaire extends Employe{
    private int heuresTravail;
    public final int salaireHeure=65;
    public Manutentionnaire(String matricule,String nom,String prenom,
                        int age,int anneeRecrutement,int heuresTravail){
        super(matricule,nom,prenom,age,anneeRecrutement);
        this.heuresTravail=heuresTravail;
    }
    public double CalculerSalaire(){
        return super.CalculerSalaire()+heuresTravail*salaireHeure;
    }
}
    
interface TravailRisque{
   final int primeRisque=25000;
}

class ProducteurDeRisque extends Producteur implements TravailRisque{
    public ProducteurDeRisque(String matricule,String nom,String prenom,
                        int age,int anneeRecrutement,int nbreProduit){
        super(matricule,nom,prenom,age,anneeRecrutement,nbreProduit);
    }
    public double CalculerSalaire(){
        return super.CalculerSalaire()+primeRisque;
    }
}
class ManutentionnaireDeRisque extends Manutentionnaire implements TravailRisque{
    public ManutentionnaireDeRisque(String matricule,String nom,String prenom,
                        int age,int anneeRecrutement,int heuresTravail){
        super(matricule,nom,prenom,age,anneeRecrutement,heuresTravail);
    }
    public double CalculerSalaire(){
        return super.CalculerSalaire()+primeRisque;
    }
}
 
class Personnel{
    private Employe[]staff;
    private int nbreEmploye;
    private final static int MaxEmploye=7;
    public Personnel(){
        staff=new Employe[MaxEmploye];
        nbreEmploye=0;
    }
    public void AjoutEmploye(Employe e){
        ++nbreEmploye;
        if(nbreEmploye<=MaxEmploye){
            staff[nbreEmploye-1]=e;
        }
        else{
            System.out.println("ajout impossible car limite de "+MaxEmploye+" places pour les employes atteinte");
        }
    }
    public void Salaire_Moyen(){
        double moyenne=0;
        for(int i=0;i<nbreEmploye;i++){
        moyenne+=staff[i].CalculerSalaire();
    }
        System.out.println("le salaire moyen des employes est de "+moyenne/nbreEmploye+" Fcfa");
    }
    public void calculer_salaires(){
        for(int i=0;i<nbreEmploye;i++){
            System.out.println(staff[i].getNom()+", a un salaire de "+staff[i].CalculerSalaire()+"Fcfa");
        }
    }
    public void Age_Moyen(){
        double moyenne=0;
        for(int i=0;i<nbreEmploye;i++){
             moyenne+=staff[i].getAge();
        }
        System.out.println("l'age moyen des employes est de "+moyenne/nbreEmploye+" ans");
    }
    public void Infos_Personnel(){
        for(int i=0;i<nbreEmploye;i++){
         System.out.println(staff[i].getNom()+", matricule "+staff[i].getMatricule()+
              " age(e) de "+staff[i].getAge()+" ans,a ete recrute en "+staff[i].getAnneeRecrutement());
        }
    }
}