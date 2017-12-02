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
public class Salary {
    
    public static void main(String[]args){
        Personnel p=new Personnel();
        p.AjoutEmploye(new Vendeur("16A000EN","tamo","benoit",20,2016,1000));
        p.AjoutEmploye(new Representant("16A111EN","toto","paul",33,2009,2000));
        p.AjoutEmploye(new Producteur("16B000EN","tata","nicole",44,2003,200));
        p.AjoutEmploye(new Manutentionnaire("16B111EN","titi","vincent",29,2010,20));
        p.AjoutEmploye(new ProducteurDeRisque("16C000EN","pepe","jean",48,2000,100));
        p.AjoutEmploye(new ManutentionnaireDeRisque("16C111EN","tito","franc",25,2014,10));
        
       
        p.Infos_Personnel();
    }
}