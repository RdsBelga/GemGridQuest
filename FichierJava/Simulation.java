public class Simulation {
    private Agent8 agent;
    private Grille terrain;
    private Contenu[] contenu;
    public Simulation(int m){
        this.agent=Agent8.getInstance();
        //this.terrain=new Grille();
        this.terrain=new Grille(5,5);
        this.contenu=new Contenu[m];
        for (int i=0;i<contenu.length;i++){
            int alea=(int)(Math.random()*6);
            if(alea==1){
                contenu[i]=new Gardien("Gardien");
            }
            else if(alea==2){
                contenu[i]=new Joyaux("Rubis");
            }
            else if(alea==3){
                contenu[i]=new Joyaux("Opale");
            }
            else if(alea==4){
            	contenu[i]=new GardienTeleporte("Gardien Teleportable",terrain);
            	}
            else{
                contenu[i]=new Joyaux("Diamant");
            }
        }
        for (int i=0;i<contenu.length;i++){
            try{
            int aleax=(int)(Math.random()*this.terrain.nbLignes);
            int aleay=(int)(Math.random()*this.terrain.nbColonnes);
            terrain.setCase(aleax,aleay,contenu[i]);
            }catch(CoordonneesIncorrectesException e2){
                System.out.println(e2.getMessage());
            }
            
        }
    }
    public String toString(){
        String res="Information sur la grille:\t"+ terrain.toString()+"\t";
        for (Contenu c: contenu){
            res+=c.toString()+"\n";
        }
        return res+"\n";
    }
    public void lance(int nbetape){
        for (int i=0;i<nbetape;i++){
            try{
                int aleax=(int)(Math.random()*this.terrain.nbLignes);
                int aleay=(int)(Math.random()*this.terrain.nbColonnes);
                if(Math.random()<0.3){
                    terrain.affiche(1);
                    System.out.println(this.toString());
                    System.out.println(agent.toString());
                    agent.seDeplacer(aleax,aleay,(int)(Math.random()*91+10),terrain); 
                    terrain.affiche(1);
                    System.out.println(this.toString());
                    System.out.println(agent.toString());
                    }
                 //Test pour GardienTeleporte
                //else if(Math.random()<0.6){
                	//terrain.affiche(1);
                   // System.out.println(this.toString());
                   // System.out.println(agent.toString());
                	//agent.seDeplacer(aleax,aleay,terrain);
                	//terrain.affiche(1);
                    //System.out.println(this.toString());
                    //System.out.println(agent.toString());
                    //for (int x=0;x<contenu.length;x++)
                		//if(contenu[x] instanceof GardienTeleporte){
                			//((GardienTeleporte)contenu[x]).seTeleporter();
                		//	}
                	
                	//}
                else{
                    terrain.affiche(1);
                    System.out.println(this.toString());
                    System.out.println(agent.toString());
                    agent.seDeplacer(aleax,aleay,terrain);
                    terrain.affiche(1);
                    System.out.println(this.toString());
                    System.out.println(agent.toString());
                }
                }catch(CoordonneesIncorrectesException e1){
                    System.out.println(e1.getMessage());
                }catch(CaseNonPleineException e2){
                    System.out.println(e2.getMessage());
                }catch(DeplacementIncorrecteException e3){
                    System.out.println(e3.getMessage());
                }
         }
        }
}
