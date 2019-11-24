function [c]=mfcc2(s,fs,k)
% mfcc2: reecriture de l'algorithme MFCC
% Entrees:
%  s : signal de la parole a analyser
%  fs : frequence d'echantillionnage
%  k: nombre de coefficients a creer
% Sortie
%  c : matrice des coefficients

% variables:
% p : nombre de filtre a creer dans le banc de
%     filtres
%p=floor(3*log(fs));
p=k;
%n: taille des "frames" en échantillons optimale 
%   (une puisance de 2, generalement n=256 ou n=512
n=pow2(floor(log2(0.03*fs)));
% fl,fh: fixent le debut (fl) et la fin (fh)
% de la bande passante de fs a utiliser
fl=0;
fh=0.5; 
% w: indique la fonction de ponderation a utiliser
% ici 'M' => Hamming.
w='m';
% inc : duree de recouvrement des fenetres
%  (les fenetres se recouvrent toutes les...)
inc=floor(n/2);

% creation des frames ponderees par Hamming
z=enframe(s,hamming(n),inc);

% Premiere etape : f est la transorme rapide 
% de Fourier de z
f=fft(z.');

% creation du banc de filtre
% p : nombre de filtre a creer dans le banc de filtre
% n : taille des frames en échantillons
% fs : frequence d'echantillionnage du signal
%      d'entree
% fl, fh : fraction de fs a utiliser
% w : type de fenetre de ponderation a utiliser.
[m,a,b]=melbankm(p,n,fs,fl,fh,w);
% m: matrice du banc de filtre
% a et b sont les bornes de la partie utilisee dans f

% on applique le banc de filtre au signal f (en fait
% seulement a la partie delimitee entre a et b) par
% un produit matriciel m * f
% puis on prend le logarithme des coefficients.
y=log(m*(abs(f(a:b,:)).^2));
%y=log(m*(abs(f(a:b,:))));


% creation du cepstre en temps que tel:
% tranformee en cosinus discret reel:
c=rdct(y).';

nc=k+1;
c(:,nc+1:end)=[];
