package com.structures; 
  
 import java.util.ArrayList; 
  
 public class Chess { 
         int player; 
         int nrmutari=0; 
         int[][]tablainitiala; 
         int[][] matRege=new int[8][8]; 
         boolean check=false; 
         boolean checkmate=false; 
         Coordonata pozitRege; 
         ArrayList<String> piesemutabile=new ArrayList<String>(); 
         private Board gBoard; 
         public Chess(int player,Board gBoard) 
         { 
                 this.player=player; 
                 this.tablainitiala=gettabla(gBoard.configBoard); 
                 this.pozitRege=getPozRege(); 
                 this.gBoard=gBoard; 
                 this.matRege=gBoard.mat[this.pozitRege.x][this.pozitRege.y].posibleMove(tablainitiala[this.pozitRege.x][this.pozitRege.y],this.pozitRege.x,this.pozitRege.y,tablainitiala); 
                 verifica(Checkmat()); 
         } 
         public int[][] Checkmat()//construieste matricea cu toate mutarile adversarului 
         { 
  
                 int[][] tabla=this.tablainitiala; 
                 tabla[this.pozitRege.x][this.pozitRege.y]=0; 
                 int[][] matinitial=new int[8][8]; 
                 for(int i=0;i<8;i++) 
                         for(int j=0;j<8;j++) 
                                 if(this.tablainitiala[i][j]/10==otherplayer()){ 
                                         if (this.tablainitiala[i][j]%10==1) matinitial=puneinmatrice(matinitial,pionmove(this.gBoard.mat[i][j].posibleMove(tabla[i][j],i,j,tabla),i,j)); 
                                         else matinitial=puneinmatrice(matinitial,this.gBoard.mat[i][j].posibleMove(tabla[i][j],i,j,tabla)); 
  
                                 } 
                 tabla[this.pozitRege.x][this.pozitRege.y]=this.player*10+9; 
                 this.tablainitiala=tabla; 
                 //afisare(matinitial); 
                 return matinitial; 
         } 
         public void afisare(int[][] matchess) 
         { 
                 for(int i=0;i<8;i++) 
                 { 
                         for(int j=0;j<8;j++) 
                                 System.out.print(matchess[i][j]+" "); 
                         System.out.println(); 
                 } 
                 System.out.println(); 
         } 
         public int[][] puneinmatrice(int[][] mat1,int[][] mat2)//pune in matricea reuniuni mutarilor adversarului 
         { 
                 for(int i=0;i<8;i++) 
                         for(int j=0;j<8;j++) 
                                 if(mat2[i][j]!=0) mat1[i][j]=mat2[i][j]; 
                 return mat1; 
         } 
         private int otherplayer()//returneaza id-ul adversarului 
         { 
                 if (this.player==1) return 2; 
                 else return 1; 
         } 
         private Coordonata getPozRege()//returneaza pozitia regelui 
         { 
                 for(int i=0;i<8;i++) 
                         for(int j=0;j<8;j++) 
                                 if(this.tablainitiala[i][j]==this.player*10+9)return new Coordonata(i,j); 
                 return new Coordonata(0,0);      
         } 
  
         public void verifica(int[][] mat2){ 
                 if(mat2[this.pozitRege.x][this.pozitRege.y]==1){ this.check=true; 
                 //System.out.println("ESTI IN SAH!"); 
                 mutariposibile(mat2); 
                 getpiesemutabile(); 
                 if(this.nrmutari==0&&this.piesemutabile.size()==0) { 
                         this.checkmate=true; 
  
  
                 } 
                 } 
         } 
         public int[][] mutariposibile(int[][] mat2)//returneaza matricea mutarilor posibile pt rege 
         { 
                 int[][] mat1=this.matRege; 
                 for(int i=0;i<8;i++) 
                         for(int j=0;j<8;j++) 
                                 if(mat1[i][j]!=0) if(mat2[i][j]==1) mat1[i][j]=0; 
                                 else this.nrmutari++; 
  
                // System.out.println("MUTARI POSIBILE REGE"); 
                 //afisare(mat1); 
                 return mat1; 
         } 
         private void matmorf(int i,int j) 
         { 
                 int[][] mat1=this.gBoard.mat[i][j].posibleMove(tablainitiala[j][i],i,j,tablainitiala); 
                 for(int x=0;x<8;x++) 
                         for(int y=0;y<8;y++) 
                                 if(x!=this.pozitRege.x&&y!=this.pozitRege.y) 
                                         if(mat1[x][y]!=0) tablainitiala[x][y]=tablainitiala[i][j]; 
  
         } 
         public ArrayList<String> getpiesemutabile()//returneaza un vector cu piesele care se pot muta in caz de sah 
         { 
        	 piesemutabile=new ArrayList<String>();
                 for(int i=0;i<8;i++) 
                         for(int j=0;j<8;j++) 
                                 if(tablainitiala[i][j]/10==this.player) 
                                 { 
                                         int[][] cfgBoard=gettabla(this.tablainitiala); 
                                         matmorf(i,j); 
                                         int[][] mati=Checkmat(); 
                                         if(mati[this.pozitRege.x][this.pozitRege.y]==0) 
                                         { 
                                                 piesemutabile.add(i+""+j); 
  
                                         } 
                                        this.tablainitiala=gettabla(cfgBoard); 
  
                                 } 
                 return piesemutabile;
         } 
         private int[][] gettabla(int[][] tabla) 
         { 
                 int[][] tablainit=new int[8][8]; 
                 for(int i=0;i<8;i++) 
                         for(int j=0;j<8;j++) 
                                 tablainit[i][j]=tabla[i][j]; 
                 return tablainit; 
         } 
         private int[][] pionmove(int[][] tabla,int i,int j) 
         { 
                 if(i+1<8) if(tabla[i+1][j]==1) { tabla[i+1][j]=0; 
                 if(j-1>0) tabla[i+1][j-1]=1; 
                 if(j+1<8) tabla[i+1][j+1]=1; 
                 if(i+2<8) tabla[i+2][j]=0; 
                 } 
                 if(i-1>0) if(tabla[i-1][j]==1) { tabla[i-1][j]=0; 
                 if(j-1>0) tabla[i-1][j-1]=1; 
                 if(j+1<8) tabla[i-1][j+1]=1; 
                 if(i-2<8) tabla[i-2][j]=0; 
                 } 
                 return tabla; 
  
         } 
  
  
 } 
 class Coordonata{ 
         public int x,y; 
         public Coordonata(int x,int y) 
         { 
                 this.x=x; 
                 this.y=y; 
         } 
  
  
 } 
 