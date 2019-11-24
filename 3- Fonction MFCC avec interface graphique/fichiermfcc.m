function [ filename ] = fichiermfcc( path )
%UNTITLED Summary of this function goes here
%   Detailed explanation goes here
[s,fs]=wavread('path');
matrice=mfcc2(s,fs,12);
filemfccname=csvwrite('phonmfcc.txt');

end

