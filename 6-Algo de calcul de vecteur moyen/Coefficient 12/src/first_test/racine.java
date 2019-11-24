package first_test;

import java.io.File;
import java.io.IOException;


public class racine {
public static String s;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		file_Conv f=new file_Conv();
		s = f. lirefichierclasse();
		File v = new File(s);
		f.listPath(v.getParentFile());
		f.initialisermatrice();
		for(int i=0;i<f.liste_paths.size();i++){
			f.file_Conv(f.liste_paths.elementAt(i));
		}
		
		f.aff();
		String savefile = null;
		
savefile=f.save();
		f.filewriter(f.mat, savefile);
	}

}
