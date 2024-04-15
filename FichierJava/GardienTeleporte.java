public class GardienTeleporte extends Gardien implements Teleportable {
	private Grille grille;
	public GardienTeleporte(String nom, Grille g){
		super(nom);
		this.grille=g;
		}
	public String toString(){
		return super.toString() + " teleportable ";
		}
	public void seTeleporter(){
		
		int aleax=(int)(Math.random()*(grille.nbLignes+1));
		int aleay=(int)(Math.random()*(grille.nbColonnes+1));
		System.out.println("Le gardien id:"+super.ident+" avant la teleportation en position :("+super.getX()+", "+super.getY()+")");
		if(!grille.sontValides(aleax,aleay)){
			System.out.println("Deplacement impossible ligne "+aleax+ "n'existe pas,Deplacement impossible colonne "+aleay+" n'existe pas");
			return ;
			}
			
		try{
		if (grille.getCase(aleax,aleay) instanceof Contenu){
			System.out.println("Case deja occuper par un contenu donc le gardien ne peut pas se teleporter ici");
			return ;
			}
			}catch(CoordonneesIncorrectesException c2){
				System.out.println(c2.getMessage());
			}
		try {
			grille.setCase(aleax,aleay,this);
			System.out.println("Le gardien id:"+super.ident+"se teleporte dans ("+aleax+", "+aleay+")");
			
			}catch(CoordonneesIncorrectesException c3){
				System.out.println(c3.getMessage());
			}
	}
}