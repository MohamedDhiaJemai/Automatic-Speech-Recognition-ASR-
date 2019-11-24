package first_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class file_Conv {
	public String chemin;
	public int taille;
	double[][] mat;
	private BufferedReader in;
	private BufferedWriter out;
	public static File fileToSave;
	public static Vector<String> liste_paths = new Vector<String>();
	public Vector<Integer> taille_fichier = new Vector<Integer>();

	public file_Conv() {
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < 60; j++)
				mat[i][j] = 0;
		}
	}

	public int taillefichier(String string) {
		BufferedReader reader = null;
		String line;
		int count = 0;
		try {
			reader = new BufferedReader(new FileReader(string));

			while ((line = reader.readLine()) != null) {
				count++;

			}
		} catch (Exception e) {
			// do something
			System.out.println("erreur      :     "+e.toString());
		}
		return count;
	}

	public int recupererlegrandtaille(int nbL) {
		nbL = taille_fichier.elementAt(0);
		for (int i = 1; i < taille_fichier.size(); i++) {
			if (taille_fichier.elementAt(i) > nbL) {
				nbL = taille_fichier.elementAt(i);
			}
		}
		return nbL;
	}

	public void initialisermatrice() {
		for (int i = 0; i < liste_paths.size(); i++) {
			taille = taillefichier(liste_paths.elementAt(i));
			taille_fichier.add(taille);

		}
		int lengthfile = 0;
		for (int k = 0; k < taille_fichier.size(); k++) {
			System.out.println(taille_fichier.elementAt(k));
			 lengthfile  = recupererlegrandtaille(taille);
		}
		taille = lengthfile;

		mat = new double[taille][60];
	}

	public static void listPath(File path) throws IOException {
		File files[];
		files = path.listFiles();
		for (int j = 0, n = files.length; j < n; j++) {
			if ((files[j].getName().endsWith(".txt")) && (files[j].isFile())) {
				System.out.println(files[j].getAbsolutePath());
				liste_paths.add(files[j].getAbsolutePath());
			}
			if (files[j].isDirectory()) {
				
				System.out.println(files[j].getAbsolutePath());
			}
		}
	}

	public String lirefichierclasse() {
		JFrame parent = new JFrame();
		MonFiltre mft = new MonFiltre(new String[] { "txt", "wav" },
				"les fichiers (*.txt)(*.wav");
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(mft);
		fc.setApproveButtonText("Choix du fichier...");
		fc.setMultiSelectionEnabled(true);

		fc.setDialogTitle("choisir le fichier mfcc");

		File dir = new File("C:\\Users\\Dell\\Desktop\\base\\60");

		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fc.setCurrentDirectory(dir);

		int returnVal = fc.showOpenDialog(parent);
		if (returnVal == JFileChooser.APPROVE_OPTION) {

			File selection = fc.getSelectedFile();

			chemin = selection.toString();
		}
		return chemin;
	}

	public void filewriter(double[][] m, String fileToSave) {

		try {
			out = new BufferedWriter(new FileWriter(new File(fileToSave)));
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {
					String chain = "";
					chain = chain + (m[i][j] / liste_paths.size()) + " ";
					out.write(chain + "");
				}

				out.newLine();
			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

	}

	//public void file_Conv(String chemin,int n) {
		

	public void aff() {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < 60; j++)
				System.out.print(" " + (mat[i][j] / liste_paths.size()));

			System.out.println();
		}
	}

	public String save() {

		JFrame parentFrame = new JFrame();

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");
		File dir=new File("C:\\Users\\Dell\\Desktop\\base\\60");
		fileChooser.setCurrentDirectory(dir);
		int userSelection = fileChooser.showSaveDialog(parentFrame);
		
		
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			fileToSave = fileChooser.getSelectedFile();
			System.out.println("Save as file: " + fileToSave.getAbsolutePath());
			
		}
		
		String savefile = fileToSave.toString();
		savefile = savefile + ".txt";

		// TODO Auto-generated method stub

		return savefile;
	}

	public void file_Conv(String elementAt) {
		// TODO Auto-generated method stub
		try {

			in = new BufferedReader(new FileReader(new File(chemin)));
			String ch = "";
			int i = 0;
			while (ch != null) {
				// System.out.println("ligne "+i);
				ch = in.readLine();
				// System.out.println("ch ="+ch);
				int debut = 0;
				int fin = ch.indexOf(" ");
				// System.out.println("debut "+debut);
				// System.out.println("fin "+fin);

				for (int j = 0; j <= 59; j++) {
					String val = ch.substring(debut, fin);
					// System.out.println("val ="+ch);
					mat[i][j] = mat[i][j] + Double.parseDouble(val);
					debut = fin + 1;
					fin = ch.indexOf(" ", debut);
				}
				// mat[i][11]=Double.parseDouble(ch.substring(ch.lastIndexOf(" "),
				// ch.length()));
				i++;

			}
			in.close();

		} catch (Exception e) {
			System.out.println("erreur lecture fichier" + e);
		}
	}
		
	}


