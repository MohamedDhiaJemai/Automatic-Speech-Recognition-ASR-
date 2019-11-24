import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;


public class Critères {

	int nombre_colonnes;
	Vector<double[][]> VM = new Vector();
	//Constructeur
	public Critères(int nbc,String chemin)
	{
		this.nombre_colonnes=nbc;
		this.Remplissage_matrices(chemin);
	}
	
	//Remplissage du variable matrices
	public void Remplissage_matrices(String chemin){
			
		   
			File file = new File(chemin);// ouvrir dossier 
	        File[] files = file.listFiles();// sélection des fichier du chemin	
	        for(File f:files)
	        {
	        	int ligne=nombre_Ligne(f.getAbsolutePath());
	        	VM.addElement(file_Conv(f.getAbsolutePath(), ligne, this.nombre_colonnes));	        	
	        }
	         
	     }
		
	// chercher le nombre des lignes dans une fichier 
	public int nombre_Ligne(String chemin){
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
	public double[][] file_Conv(String chemin,int ligne,int colonne)
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
	//distance euclidienne 
	public double euclidienne_Matrice(double[][] m1,double[][] m2)
	{
		double[] v1=new double[nombre_colonnes];
		double[] v2=new double[nombre_colonnes];
		double somme=0;
		for(int i=0;i<m1.length;i++)
		{
			for(int j=0;j<this.nombre_colonnes;j++)
			{
			   v1[i]=m1[i][j];
			   v2[i]=m2[i][j];
			}
			somme+=euclidienne_Vecteur(v1, v2);
		}
		somme=somme/m1.length;
	return(somme);
		
	}
	public double euclidienne_Vecteur(double[] v1,double[] v2)
	{
		double somme=0;
		for(int i=0;i<v1.length;i++)
		{
			somme+=(Math.pow(v2[i]-v1[i],2));
		}
	return(Math.sqrt(somme));
		
	}

	//distance Minkowski 	 
	public double Minkowski_Matrice(double[][] m1,double[][] m2)
		{
			double[] v1=new double[nombre_colonnes];
			double[] v2=new double[nombre_colonnes];
			double somme=0;
			for(int i=0;i<m1.length;i++)
			{
				for(int j=0;j<this.nombre_colonnes;j++)
				{
				   v1[i]=m1[i][j];
				   v2[i]=m2[i][j];
				}
				somme+=Minkowski_Vecteur(v1, v2);
			}
			somme=somme/m1.length;
		return(somme);
			
		}
	public double Minkowski_Vecteur(double[] v1,double[] v2)
		{
			double somme=0;
			for(int i=0;i<v1.length;i++)
			{
				somme+=(Math.pow(v2[i]-v1[i],3));
			}
		return(Math.pow(somme,1/3));
			
		}
	
	//distance manhatten 
	public double manhatten_Matrice(double[][] m1,double[][] m2)
		{
			double[] v1=new double[nombre_colonnes];
			double[] v2=new double[nombre_colonnes];
			double somme=0;
			for(int i=0;i<m1.length;i++)
			{
				for(int j=0;j<this.nombre_colonnes;j++)
				{
				   v1[i]=m1[i][j];
				   v2[i]=m2[i][j];
				}
				somme+=manhatten_Vecteur(v1, v2);
			}
			somme=somme/m1.length;
		return(somme);
			
		}
	public double manhatten_Vecteur(double[] v1,double[] v2)
		{
			double somme=0;
			for(int i=0;i<v1.length;i++)
			{
				somme+=(Math.abs(v2[i]-v1[i]));
			}
		return(somme);
			
		}

	//distance tchyb
	public double tchyb_Matrice(double[][] m1,double[][] m2)
				{
					double[] v1=new double[nombre_colonnes];
					double[] v2=new double[nombre_colonnes];
					double somme=0;
					for(int i=0;i<m1.length;i++)
					{
						for(int j=0;j<this.nombre_colonnes;j++)
						{
						   v1[i]=m1[i][j];
						   v2[i]=m2[i][j];
						}
						somme+=tchyb_Vecteur(v1, v2);
					}
					somme=somme/m1.length;
				return(somme);
					
				}
	public double tchyb_Vecteur(double[] v1,double[] v2)
				{
					double max=-1;
					for(int i=0;i<v1.length;i++)
					{
						if(Math.abs(v2[i]-v1[i])>max)
						{
							max=Math.abs(v2[i]-v1[i]);
						}
					}
				return(max);
					
				}
	
	//
}
