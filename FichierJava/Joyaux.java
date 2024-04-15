
public class Joyaux extends Contenu{

    public Joyaux(String nom){
        super(nom,(int)(Math.random()*2000 + 1));
    }
    public Joyaux clone(){
    	return new Joyaux(super.type);
    	}
    public String toString(){
        return super.toString()+" prix= "+super.getQuantite();
    }
    public void materiel(){
    	System.out.println("Joyaux ");
    	}
}
