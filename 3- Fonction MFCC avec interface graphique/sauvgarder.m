function [f]=sauvgarder( )
[file,directory]=uiputfile('test.txt','Enregistrer sous');
if isequal(file,0) || isequal(directory,0)
       disp('User pressed cancel')
else
      %faire ici la proc�dure de sauvegarde (une simple copie a priori ici)
end
f=strcat(directory,file);
f=char(f);
end

