function [] = mfcc_extract( path )
%UNTITLED2 Summary of this function goes here
%   Detailed explanation goes here
[s,fs]=wavread('path');
matricemfcc=mfcc2(s,fs,12);


end

