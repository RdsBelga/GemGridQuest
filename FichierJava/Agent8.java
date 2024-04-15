//SMAALI Belgacem 28717867

import java.util.ArrayList;
public class Agent8{
    private int posX;
    private int posY;
    private ArrayList<Joyaux> sacJoyaux;
    private static final Agent8 INSTANCE=new Agent8();
    private Agent8(){
        this.posX=-1;
        this.posY=-1;
        this.sacJoyaux=new ArrayList<Joyaux>();
    }
    public static Agent8 getInstance(){
    	return INSTANCE;
    	}
    public ArrayList<Joyaux> getSac(){
    	return this.sacJoyaux;
    	}
    
    public void seDeplacer(int xnew,int ynew,Grille g)throws DeplacementIncorrecteException,CoordonneesIncorrectesException,CaseNonPleineException{
        if(!g.sontValides(xnew,ynew))throw new DeplacementIncorrecteException("Deplacement impossible ligne "+xnew+ "n'existe pas,Deplacement impossible colonne "+ynew+" n'existe pas");
        //try{
            Contenu a=g.getCase(xnew,ynew);
        //}catch(CoordonneesIncorrectesException e){
          //  System.out.println(e);
        //}
        if(a instanceof Joyaux){
            sacJoyaux.add((Joyaux)a);
            g.videCase(xnew,ynew);
            System.out.println("l'Agent tombe sur un joyaux");
        }
        else if(a instanceof Gardien){
            sacJoyaux.clear();
            System.out.println("l'Agent tombe sur un gardien et perds les joyaux");
         
        }
        this.posX=xnew;
        this.posY=ynew;

    }
    public void seDeplacer(int xnew , int ynew , int f, Grille g)throws DeplacementIncorrecteException,CoordonneesIncorrectesException,CaseNonPleineException{
        if(!g.sontValides(xnew,ynew))throw new DeplacementIncorrecteException("Deplacement impossible ligne "+xnew+ "n'existe pas,Deplacement impossible colonne "+ynew+" n'existe pas");
        //try{
            Contenu a=g.getCase(xnew,ynew);
        //}catch(CoordonneesIncorrectesException e){
          //  System.out.println(e);
        //}
        if(a instanceof Joyaux){
            sacJoyaux.add((Joyaux)a);
            g.videCase(xnew,ynew);
            System.out.println("l'Agent tombe sur un joyaux");
        }
        else if(a instanceof Gardien){
            if(a.getQuantite()<=f){
                g.videCase(xnew,ynew);
                System.out.println("L'agent de force: "+f +" se bat contre le gardient ayant "+a.getQuantite()+" point de vie");
                System.out.println("l'Agent tue le gardien");
            }
            else if(a.getQuantite()>f){
            sacJoyaux.clear();
            System.out.println("le gardien avant le combat a "+a.getQuantite());
            System.out.println("l'Agent tombe sur un gardien se bat et perds ses joyaux");
            a.setQuantite(a.getQuantite()-f);
            System.out.println("le gardien apres le combat a "+a.getQuantite());
            a.setQuantite(a.getQuantite()-f);
            }
        }
        this.posX=xnew;
        this.posY=ynew;
    }
    public int fortune(){
        int sum=0;
        for(Joyaux j :sacJoyaux){
            sum+=j.getQuantite();
        }
        return sum;
    }
    public ArrayList<Joyaux> contenuSac(){
        for(Joyaux j: sacJoyaux){
            System.out.println(j.toString());
        }
        return this.sacJoyaux;
    }
    public String toString(){
        return "L'agent posx= "+this.posX+"; posY= "+this.posY+" fortune="+this.fortune();
    }


}