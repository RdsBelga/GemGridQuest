public class Gardien extends Contenu{
    public Gardien(String nom){
        super(nom,(int)(Math.random()*201));
    }
    public String toString(){
        return super.toString()+" point de vie= "+super.getQuantite();
    }
    public void materiel(){
    	System.out.println("Je suis un Gardien");
    	}
    
}