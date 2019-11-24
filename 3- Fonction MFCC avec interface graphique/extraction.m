function varargout = extraction(varargin)
% EXTRACTION M-file for extraction.fig
%      EXTRACTION, by itself, creates a new EXTRACTION or raises the existing
%      singleton*.
%
%      H = EXTRACTION returns the handle to a new EXTRACTION or the handle to
%      the existing singleton*.
%
%      EXTRACTION('CALLBACK',hObject,eventData,handles,...) calls the local
%      function named CALLBACK in EXTRACTION.M with the given input arguments.
%
%      EXTRACTION('Property','Value',...) creates a new EXTRACTION or raises the
%      existing singleton*.  Starting from the left, property value pairs are
%      applied to the GUI before extraction_OpeningFcn gets called.  An
%      unrecognized property name or invalid value makes property application
%      stop.  All inputs are passed to extraction_OpeningFcn via varargin.
%
%      *See GUI Options on GUIDE's Tools menu.  Choose "GUI allows only one
%      instance to run (singleton)".
%
% See also: GUIDE, GUIDATA, GUIHANDLES

% Edit the above text to modify the response to help extraction

% Last Modified by GUIDE v2.5 21-May-2014 23:59:32

% Begin initialization code - DO NOT EDIT
gui_Singleton = 1;
gui_State = struct('gui_Name',       mfilename, ...
                   'gui_Singleton',  gui_Singleton, ...
                   'gui_OpeningFcn', @extraction_OpeningFcn, ...
                   'gui_OutputFcn',  @extraction_OutputFcn, ...
                                   'gui_LayoutFcn',  [] , ...
                   'gui_Callback',   []);
if nargin && ischar(varargin{1})
    gui_State.gui_Callback = str2func(varargin{1});
end

if nargout
    [varargout{1:nargout}] = gui_mainfcn(gui_State, varargin{:});
else
    gui_mainfcn(gui_State, varargin{:});
end
% End initialization code - DO NOT EDIT


% --- Executes just before extraction is made visible.
function extraction_OpeningFcn(hObject, eventdata, handles, varargin)
% This function has no output args, see OutputFcn.
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
% varargin   command line arguments to extraction (see VARARGIN)

% Choose default command line output for extraction
handles.output = hObject;

% Update handles structure
guidata(hObject, handles);
set(handles.uitable1,'Visible','off');
% UIWAIT makes extraction wait for user response (see UIRESUME)
% uiwait(handles.figure1);


% --- Outputs from this function are returned to the command line.
function varargout = extraction_OutputFcn(hObject, eventdata, handles) 
% varargout  cell array for returning output args (see VARARGOUT);
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Get default command line output from handles structure
varargout{1} = handles.output;


% --- Executes on button press in extraire.
function extraire_Callback(hObject, eventdata, handles)
global l matricecoeff;
v=get(handles.radiobutton12,'Value')+get(handles.radiobutton24,'Value')*2+get(handles.radiobutton36,'Value')*3+get(handles.radiobutton48,'Value')*4+get(handles.radiobutton60,'Value')*5+get(handles.radiobutton72,'Value')*6+get(handles.radiobutton84,'Value')*7+get(handles.radiobutton96,'Value')*8+get(handles.radiobutton108,'Value')*9;
switch(v)
    case 1
        k=12 ;
    case 2 
        k=24;
    case 3 
        k=36;
    case 4
        k=48;
    case 5
        k=60;
    case 6
        k=72;
    case 7
        k=84;
    case 8
        k=96;
    case 9
        k=108;
end
kl=get(handles.edit1,'String');
kl
[s,fs]=wavread(kl);
matricecoeff=mfcc2(s,fs,k);
set(handles.uitable1,'Visible','on');

set(handles.uitable1,'Data',matricecoeff);

% --- Executes on button press in save.
function save_Callback(hObject, eventdata, handles)
global matricecoeff;
file=sauvgarder();
dlmwrite(file,matricecoeff,',');

% --- Executes on button press in Importer.
function Importer_Callback(hObject, eventdata, handles)
[f, p]=uigetfile('*.wav','Pick a Sound File','D:\0- Travaille finale\Fonction MFCC avec interface graphique');
chemin=strcat(p,f);
set(handles.edit1,'String',chemin);



function edit1_Callback(hObject, eventdata, handles)
% hObject    handle to edit1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit1 as text
%        str2double(get(hObject,'String')) returns contents of edit1 as a double


% --- Executes during object creation, after setting all properties.
function edit1_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end


% --- Executes on button press in radiobutton12.
function radiobutton12_Callback(hObject, eventdata, handles)
% hObject    handle to radiobutton12 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hint: get(hObject,'Value') returns toggle state of radiobutton12


% --- Executes on button press in radiobutton24.
function radiobutton24_Callback(hObject, eventdata, handles)
% hObject    handle to radiobutton24 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hint: get(hObject,'Value') returns toggle state of radiobutton24


% --- Executes on button press in radiobutton36.
function radiobutton36_Callback(hObject, eventdata, handles)
% hObject    handle to radiobutton36 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hint: get(hObject,'Value') returns toggle state of radiobutton36


% --- Executes on button press in radiobutton48.
function radiobutton48_Callback(hObject, eventdata, handles)
% hObject    handle to radiobutton48 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hint: get(hObject,'Value') returns toggle state of radiobutton48


% --- Executes on button press in radiobutton60.
function radiobutton60_Callback(hObject, eventdata, handles)
% hObject    handle to radiobutton60 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hint: get(hObject,'Value') returns toggle state of radiobutton60


% --- Executes on button press in radiobutton72.
function radiobutton72_Callback(hObject, eventdata, handles)
% hObject    handle to radiobutton72 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hint: get(hObject,'Value') returns toggle state of radiobutton72


% --- Executes on button press in radiobutton84.
function radiobutton84_Callback(hObject, eventdata, handles)
% hObject    handle to radiobutton84 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hint: get(hObject,'Value') returns toggle state of radiobutton84


% --- Executes on button press in radiobutton96.
function radiobutton96_Callback(hObject, eventdata, handles)
% hObject    handle to radiobutton96 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hint: get(hObject,'Value') returns toggle state of radiobutton96


% --- Executes on button press in radiobutton108.
function radiobutton108_Callback(hObject, eventdata, handles)
% hObject    handle to radiobutton108 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hint: get(hObject,'Value') returns toggle state of radiobutton108


% --- Executes during object creation, after setting all properties.
function groupebouton6_CreateFcn(hObject, eventdata, handles)
% hObject    handle to groupebouton6 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called
