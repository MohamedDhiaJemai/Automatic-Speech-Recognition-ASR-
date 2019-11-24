import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String chemin="C:\\Users\\Dell\\Desktop\\des exemples de tests";//chemin des fichier à tester
		int colonne=12;//nombre des colonnes 
		String ch="C:\\Users\\Dell\\Desktop\\vecteurs moyens";// chemin des vecteurs moyennes 
		Critères c=new Critères(colonne,ch);		
		File file = new File(chemin);// ouvrir dossier 
        File[] files = file.listFiles();// sélection des fichier du chemin
        for(File f:files)
        {
        	int ligne = nombre_Ligne(f.getAbsolutePath());        
        	double[][] mat=new double[ligne][colonne];
        	mat=file_Conv(f.getAbsolutePath(),ligne,colonne);
        	double d_min=999999999; int indice_classe=-1;
        	for(int i=0;i<c.VM.size();i++)
        	{
        	if(c.VM.elementAt(i).length == ligne)	
        	{
        		double dist=c.euclidienne_Matrice(mat,c.VM.elementAt(i));
        		
        		if(d_min>dist)
        		{
        			d_min=dist;
        			indice_classe=i+1;
        		}
        		System.out.println("Phonème "+f.getName()+" Appartient à la classe "+indice_classe);
        	}
        	
        	}
        }

	}
	// chercher le nombre des lignes dans une fichier 
	public static int nombre_Ligne(String chemin){
			int nl=0;
			try {
				BufferedReader in;
				in = new BufferedReader(new FileReader(new File(chemin)));
				 nl=0;			
				while(in.readLine() != null)
					nl++;
			}catch(Exception e){
				System.out.println("Erreur calcule nombre des ligne dans un fichier");
			}
			return (nl);
	    }
	// convertir fichier en matrice 
		public static double[][] file_Conv(String chemin,int ligne,int colonne)
			{
			    BufferedReader in;
			    double[][] mat=new double[ligne][colonne];	
				try {
				in = new BufferedReader(new FileReader(new File(chemin)));
				String ch = "";
				int i = 0;
				while (ch != null) { 
					ch = in.readLine();
					int debut = 0;
					int fin = ch.indexOf(" ");
					for (int j = 0; j <= (colonne-1); j++) {
						String val = ch.substring(debut, fin);
						mat[i][j] = Double.parseDouble(val);				
						debut = fin + 1;
						fin = ch.indexOf(" ", debut);
					}
					i++;
				}
				in.close();
			       } catch (Exception e) { }
				
				return(mat);
				
		      }
}
