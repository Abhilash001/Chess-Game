/*
* Author: Abhilash Misra 
* Version: v1.3
* 
* Created: Tuesday, January 07, 2014, 8:22:43 PM
* Copyright (C) 2016 under the GNU General Public License. All rights reserved.
* 
*/

/*
* Update:-
* This program was made when I was in class 11(when I was just learning java), so please let go of any improper 
* program structuring, irrelevant variables declared, or non-uniform indentation that you find. Even I have no 
* idea how I made it, seeing it after 2 years. It works fine, that I guarantee.
*
*/

import java.io.*;


class Chess_Game
{
 static int c7=0;
 static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 public static void main(String args[])throws IOException
 {
 	String a[][]={{"BR1","BH1","BB1","BQ1","BK1","BB2","BH2","BR2"},
 	              {"BP1","BP2","BP3","BP4","BP5","BP6","BP7","BP8"},
 	              {"000","000","000","000","000","000","000","000"},
 	              {"000","000","000","000","000","000","000","000"},
 	              {"000","000","000","000","000","000","000","000"},
 	              {"000","000","000","000","000","000","000","000"},
 	              {"WP1","WP2","WP3","WP4","WP5","WP6","WP7","WP8"},
 	              {"WR1","WH1","WB1","WQ1","WK1","WB2","WH2","WR2"}};

  int b[][]={{0, 1, 2, 3, 4, 5, 6, 7},
             {10,11,12,13,14,15,16,17},
             {20,21,22,23,24,25,26,27},
             {30,31,32,33,34,35,36,37},
             {40,41,42,43,44,45,46,47},
             {50,51,52,53,54,55,56,57},
             {60,61,62,63,64,65,66,67},
             {70,71,72,73,74,75,76,77}};

  int n2=0,c=0,d=0,y=0,v=0,w=0,c6=2,c3=2,c8,t2=0,t3=0;
  char o='o',r='r';
  int f1[]=new int[8],f2[]=new int[8];

  System.out.println("\nINSTRUCTIONS(HOW TO PLAY):");
  System.out.println("JUST LIKE CHESS. FOLLOW ALL CHESS RULES. TO MOVE A PIECE, FIRST ENTER THE PIECE");
  System.out.println("YOU WANT TO MOVE(REFER TO KEY AFTER THESE INSTRUCTIONS). THEN ENTER THE PLACE ");
  System.out.println("WHERE YOU WANT TO MOVE IT. 'PLACE' NUMBER IS GIVEN BESIDE THE CHESS BOARD WHILE");
  System.out.println("PLAYING. REFER TO IT CAREFULLY. OBJECTIVE IS TO KILL THE OPPONENT'S KING. ");
  System.out.println("REMEMBER! THERE WILL BE NO 'CHECK!' OR 'CHECKMATE!' WARNINGS, SO KEEP YOUR EYES");
  System.out.println("OPEN AND 'KILL THE KING' TO WIN. PLEASE DON'T CHEAT BY INPUTING YOUR OPPONENT'S");
  System.out.println("CHESS PIECE OR INPUTING A PLACE WHERE YOUR PIECE CAN'T GO ACCORDING TO CHESS RULES,");
  System.out.println("BECAUSE IT CAN'T HAPPEN IN MY GAME. GOOD LUCK!!!..........AND WHITE FIRST.");
  System.out.println("KEY:");
  System.out.println("BR1(or 2)=Black Rook 1(or 2)  ;  BH1(or 2)=Black Horse(Knight) 1(or 2)     ;");
  System.out.println("BB1(or 2)=Black Bishop 1(or 2);  BQ1      =Black Queen 1                   ;");
  System.out.println("BK1      =Black King 1        ;  BP1(or 2,3,etc.)=Black Pawn 1(or 2,3,etc.);");
  System.out.println("WR1(or 2)=White Rook 1(or 2)  ;  WH1(or 2)=White Horse(Knight) 1(or 2)     ;");
  System.out.println("WB1(or 2)=White Bishop 1(or 2);  WQ1      =White Queen 1                   ;");
  System.out.println("WK1      =White King 1        ;  WP1(or 2,3,etc.)=White Pawn 1(or 2,3,etc.);");
  System.out.println("ABANDON or EXIT or QUIT =You leave the game. Opponent wins.");
  System.out.println("-------------------------------------------------------------------------------------------------");

  System.out.print("Do you want to play?(yes or no):");
  String s1=br.readLine();
  s1=s1.toLowerCase();

  if(s1.equalsIgnoreCase("yes"))
  {
   do{
  	y=0;v=0;
  	System.out.println("\n\n\n\n\n\n\n");
    for(int i=0;i<16;i++)
    {
     if(i%2==0)
     {System.out.print("|---|---|---|---|---|---|---|---|");
     }
     else
     {
      for(int j=0;j<8;j++)
      {
       String sp=(a[i/2][j].equals("000")?"   ":a[i/2][j]);
       System.out.print("|"+sp);
      }
      System.out.print("|           ");
      for(int j=0;j<8;j++)
      {
       if(i==1)
       {
        System.out.print(b[i/2][j]+"  ");
       }
       else
       {
        System.out.print(b[i/2][j]+" ");
       }
      }
     }
     System.out.println();
    }
    System.out.print("|---|---|---|---|---|---|---|---|");
    System.out.println();
    

    if(d%2==0){o='W';}
    else{o='B';}

    String n1=input_p(d,o,c,t2,a,t3,v,f1,f2),n3;
    v=0;t3=0;

    

    if(n1.equalsIgnoreCase("ABANDON")==false&&n1.equalsIgnoreCase("EXIT")==false&&n1.equalsIgnoreCase("QUIT")==false)
    {
     n2=input();
     while(n2==-1) {n1=input_p(d,o,c,t2,a,t3,v,f1,f2); n2=input();}
    }

    int m=n2/10,n=8;
    outer:
    for(int i=0;i<8;i++)
    {inner: 
     for(int j=0;j<n;j++)
     {
      if(n1.equals(a[i][j]))
      {
       if(n1.charAt(0)=='W')
       {
        v=rules('W',1,n1,n2,i,j,v,f1,a,m);
        while(v!=0)
        {
         n2=input();
         if(n2==-1) 
         {
          n1=input_p(d,o,c,t2,a,t3,v,f1,f2); 
          i=0;j=0; 
          break inner;
         }
         m=n2/10;n=8;v=0;v=rules('W',1,n1,n2,i,j,v,f1,a,m);
        }
       }
       else if(n1.charAt(0)=='B')
       {
        v=rules('B',-1,n1,n2,i,j,v,f2,a,m);
        while(v!=0)
        {
         n2=input();
         if(n2==-1) 
         {
          n1=input_p(d,o,c,t2,a,t3,v,f1,f2); 
          i=0;j=0; 
          break inner;
         }
         m=n2/10;n=8;v=0;v=rules('B',-1,n1,n2,i,j,v,f2,a,m);
        }
       }
       if(a[m][n2%10].equals("000"))
       {
        if((n1.charAt(1)=='K')&&(n2%10)==(j+2))
        {
         a[m][j+1]=a[m][j+3];
         a[m][j+3]="000";
        }
        else if((n1.charAt(1)=='K')&&(n2%10)==(j-2))
        {
         a[m][j-1]=a[m][j-4];
         a[m][j-4]="000";
        }
        String t=a[i][j];
        a[i][j]=a[m][n2%10];
        a[m][n2%10]=t;d++;n=0;
       }
       else
       {
        a[m][n2%10]=a[i][j];
        a[i][j]="000";d++;n=0;
        if((n1.charAt(1)=='P')&&((m==0)||(m==7)))
        {
         if(n1.charAt(0)=='W'){c8=c6;c6++;}
         else{c8=c3;c3++;}
         do{
          System.out.println("what do you want to be("+n1.charAt(0)+"Q"+c8+
          	                                    " or "+n1.charAt(0)+"R"+(c8+1)+
          	                                    " or "+n1.charAt(0)+"H"+(c8+1)+
          	                                    " or "+n1.charAt(0)+"B"+(c8+1)+"):");
          n3=br.readLine();
          n3=n3.toUpperCase();
         }while(n3.charAt(0)!=n1.charAt(0)||
         	      (((n3.charAt(1)=='Q'&&n3.charAt(2)==(char)(c8+48))==false)&&
         	       ((n3.charAt(1)=='H'&&n3.charAt(2)==(char)(c8+49))==false)&&
         	       ((n3.charAt(1)=='R'&&n3.charAt(2)==(char)(c8+49))==false)&&
         	       ((n3.charAt(1)=='B'&&n3.charAt(2)==(char)(c8+49))==false))||
         	      n3.length()!=3);
         a[m][n2%10]=n3;c8++;
        }
       }
      }
      else if(n1.equalsIgnoreCase("ABANDON")||n1.equalsIgnoreCase("EXIT")||n1.equalsIgnoreCase("QUIT"))
      {
       String s32=o+"K1";
       for(int e2=0;e2<8;e2++)
       {for(int e3=0;e3<8;e3++)
        {
         if(a[e2][e3].equals(s32))
         {a[e2][e3]="000";
         }
        }
       }
      }
     }
    }
    for(int i=0;i<8;i++)
    {
     for(int j=0;j<8;j++)
     {
      if(a[i][j].equals("WK1"))
      {
       y++;
       r='u';
      }
      if(a[i][j].equals("BK1"))
      {
       y++;
       r='p';
      }
     }
    }
    System.out.println();
   }while(y==2);
   if(r=='u')
   {
    System.out.println("White wins.");
   }
   else
   {
    System.out.println("Black wins.");
   }
   System.out.println("CONGRATULATIONS!");
  }
  else if(s1.equals("no"))
  {
   System.out.println("Then why did you run the program?");
  }
  else
  {
   System.out.println("Invalid input. Run program again.");
  }
 }


 static String input_p(int d,char o,int c,int t2,String a[][],int t3,int v,int f1[],int f2[])throws IOException
 {
    String n1,n3;c=0;char n11;
    do{
     System.out.print("Please input piece to move(if white's chance don't input black piece):");
     n1=br.readLine();
     n1=n1.toUpperCase();
     t2=0;
     n11=n1.charAt(0);
     for(int e2=0;e2<8;e2++)
     {
      for(int e3=0;e3<8;e3++)
      {
       if(n1.equals(a[e2][e3]))
       {
        t2++;
       }
      }
     }

     int n2=0,m=0;
     int f3[]=new int[8],f4[]=new int[8];

     for(int i2=0;i2<8;i2++) f3[i2]=f1[i2];
     for(int i2=0;i2<8;i2++) f4[i2]=f2[i2];

     for(int i=0;i<8;i++)
     {for(int j=0;j<8;j++)
      {
       if(n1.equals(a[i][j]))
       {for(int i1=0;i1<8;i1++) 
        {for(int j1=0;j1<8;j1++) 
         {
          n2=i1*10+j1;m=n2/10;v=0;
          if(n1.charAt(0)=='W')
          {
           v=rules('W',1,n1,n2,i,j,v,f1,a,m);
           for(int i2=0;i2<8;i2++) f1[i2]=f3[i2];
           if(v==0) t3=-1;
          }
          else if(n1.charAt(0)=='B')
          {
           v=rules('B',-1,n1,n2,i,j,v,f2,a,m);
           for(int i2=0;i2<8;i2++) f2[i2]=f4[i2];
           if(v==0) t3=-1;
          }
         }
        }
       }
      }
     }
    }while((n11!=o||
    	      ((n1.charAt(1)!='P'||(n1.charAt(2)!='1'&&
    	      	                    n1.charAt(2)!='2'&&
    	      	                    n1.charAt(2)!='3'&&
    	      	                    n1.charAt(2)!='4'&&
    	      	                    n1.charAt(2)!='5'&&
    	      	                    n1.charAt(2)!='6'&&
    	      	                    n1.charAt(2)!='7'&&
    	      	                    n1.charAt(2)!='8'))&&
    	       (n1.charAt(1)!='Q'||(n1.charAt(2)!='1'&&
    	      	                    n1.charAt(2)!='2'&&
    	      	                    n1.charAt(2)!='3'&&
    	      	                    n1.charAt(2)!='4'&&
    	      	                    n1.charAt(2)!='5'&&
    	      	                    n1.charAt(2)!='6'&&
    	      	                    n1.charAt(2)!='7'&&
    	      	                    n1.charAt(2)!='8'))&&
    	       (n1.charAt(1)!='R'||(n1.charAt(2)!='1'&&
    	      	                    n1.charAt(2)!='2'&&
    	      	                    n1.charAt(2)!='3'&&
    	      	                    n1.charAt(2)!='4'&&
    	      	                    n1.charAt(2)!='5'&&
    	      	                    n1.charAt(2)!='6'&&
    	      	                    n1.charAt(2)!='7'&&
    	      	                    n1.charAt(2)!='8'))&&
    	       (n1.charAt(1)!='K'||n1.charAt(2)!='1')&&
    	       (n1.charAt(1)!='H'||(n1.charAt(2)!='1'&&
    	      	                    n1.charAt(2)!='2'&&
    	      	                    n1.charAt(2)!='3'&&
    	      	                    n1.charAt(2)!='4'&&
    	      	                    n1.charAt(2)!='5'&&
    	      	                    n1.charAt(2)!='6'&&
    	      	                    n1.charAt(2)!='7'&&
    	      	                    n1.charAt(2)!='8'))&&
    	       (n1.charAt(1)!='B'||(n1.charAt(2)!='1'&&
    	      	                    n1.charAt(2)!='2'&&
    	      	                    n1.charAt(2)!='3'&&
    	      	                    n1.charAt(2)!='4'&&
    	      	                    n1.charAt(2)!='5'&&
    	      	                    n1.charAt(2)!='6'&&
    	      	                    n1.charAt(2)!='7'&&
    	      	                    n1.charAt(2)!='8')))||n1.length()!=3||t2!=1||t3!=-1)&&
    	     (n1.equalsIgnoreCase("ABANDON")==false&&n1.equalsIgnoreCase("EXIT")==false&&n1.equalsIgnoreCase("QUIT")==false));
  
  return n1;
 }


 static int input()throws IOException
 {
  int m;int n2;
  do{
   System.out.print("Please input place where you want to move(-1 to go back):");
   n2=Integer.parseInt(br.readLine());m=n2/10;
  }while((((m>=0&&m<8)==false)||(((n2%10)>=-1&&(n2%10)<8)==false)));
  return n2;
 }


 static int rules(char g,int n4,String n1,int n2,int i,int j,int v,int f1[],String a[][],int m)
 {
  if(n1.charAt(1)=='P')
       {
        if(n2!=((i-(n4*1))*10+j))
        {
         if(n2!=((i-(n4*1))*10+j)+1&&n2!=((i-(n4*1))*10+j)-1)
         {
          if(n2!=((i-(n4*2))*10+j))
          {
           v++;
          }
          else if(f1[n1.charAt(2)-49]!=0)
          {
           v++;
          }
         }
         else if(n2==((i-(n4*1))*10+j)+1||n2==((i-(n4*1))*10+j)-1)
         {
          if(j!=0&&j!=7)
          {
           if(a[i-(n4*1)][j+1].equals("000")&&a[i-(n4*1)][j-1].equals("000"))
           {
            v++;
           }
          }
          else if(j==0)
          {
           if(a[i-(n4*1)][j+1].equals("000"))
           {
            v++;
           }
          }
          else if(j==7)
          {
           if(a[i-(n4*1)][j-1].equals("000"))
           {
            v++;
           }
          }
         }
        }
        else if(n2==((i-(n4*1))*10+j)&&a[m][n2%10].charAt(0)!='0')
        {
         v++;
        }
        if(n2==((i-(n4*2))*10)+j&&(a[i-(n4*1)][j].equals("000")==false||a[i-(n4*2)][j].equals("000")==false))
        {
         v++;
        }

        if(v==0)
        {f1[n1.charAt(2)-49]++;
        }
       }
       else if(n1.charAt(1)=='K')
       {
        if(n2!=((i-1)*10+j)&&
       	   n2!=((i+1)*10+j)&&
       	   n2!=(i*10+(j-1))&&
       	   n2!=(i*10+(j+1))&&
       	   n2!=((i-1)*10+(j-1))&&
       	   n2!=((i-1)*10+(j+1))&&
       	   n2!=((i+1)*10+(j-1))&&
       	   n2!=((i+1)*10+(j+1)))
        {
         if(n2!=(i*10+(j-2))&&n2!=(i*10+(j+2)))
         {
          v++;
         }
         else if(c7!=0)
         {
          v++;
         }
         else if(n2%10==(j+2))
         {
          if(a[i][j+1]!="000"||a[i][j+2]!="000")
          {
           v++;
          }
         }
         else if(n2%10==(j-2))
         {
          if(a[i][j-1]!="000"||a[i][j-2]!="000"||a[i][j-3]!="000")
          {
           v++;
          }
         }
        }
        else if(n2==((i-1)*10+j)||
        	      n2==((i+1)*10+j)||
        	      n2==(i*10+(j-1))||
        	      n2==(i*10+(j+1))||
        	      n2==((i-1)*10+(j-1))||
        	      n2==((i-1)*10+(j+1))||
        	      n2==((i+1)*10+(j-1))||
        	      n2==((i+1)*10+(j+1)))
        {
         if(a[m][n2%10].charAt(0)==g)
         {
          v++;
         }
        }
        if(v==0)
        {c7++;
        }
       }
       else if(n1.charAt(1)=='R')
       {
        if(i!=m&&j!=(n2%10))
        {
         v++;
        }
        else if(i==m)
        {
         if(j<(n2%10))
         {for(int k=j+1;k<(n2%10);k++)
          {
           if(a[i][k].charAt(0)!='0')
           {
            v++;
           }
          }
         }
         else if(j>(n2%10))
         {for(int k=j-1;k>(n2%10);k--)
          {
           if(a[i][k].charAt(0)!='0')
           {
            v++;
           }
          }
         }
         if(a[m][n2%10].charAt(0)==g)
         {
          v++;
         }
        }
        else if(j==(n2%10))
        {
         if(i<m)
         {for(int k=i+1;k<m;k++)
          {
           if(a[k][j].charAt(0)!='0')
           {
            v++;
           }
          }
         }
         else if(i>m)
         {for(int k=i-1;k>m;k--)
          {
           if(a[k][j].charAt(0)!='0')
           {
            v++;
           }
          }
         }
         if(a[m][n2%10].charAt(0)==g)
         {
          v++;
         }
        }
       }
       else if(n1.charAt(1)=='H')
       {
        if(n2!=(((i+2)*10+j)+1)&&
       	   n2!=(((i+2)*10+j)-1)&&
       	   n2!=(((i-2)*10+j)+1)&&
       	   n2!=(((i-2)*10+j)-1)&&
       	   n2!=((i+1)*10)+(j+2)&&
       	   n2!=(i-1)*10+(j+2)&&
       	   n2!=(i+1)*10+(j-2)&&
       	   n2!=(i-1)*10+(j-2))
        {
         v++;
        }
        else if(n2==(((i+2)*10+j)+1)||
        	       n2==(((i+2)*10+j)-1)||
        	       n2==(((i-2)*10+j)+1)||
        	       n2==(((i-2)*10+j)-1)||
        	       n2==((i+1)*10)+(j+2)||
        	       n2==(i-1)*10+(j+2)||
        	       n2==(i+1)*10+(j-2)||
        	       n2==(i-1)*10+(j-2))
        {
         if(a[m][n2%10].charAt(0)==g)
         {
          v++;
         }
        }
       }
       else if(n1.charAt(1)=='B')
       {
        if((i+j)!=(m+(n2%10))&&(i-j)!=(m-(n2%10)))
        {
         v++;
        }
        else if((i+j)==(m+(n2%10)))
        {
         if(i<m)
         {for(int k=i+1,l=j-1;k<m;k++,l--)
          {
           if(a[k][l].charAt(0)!='0')
           {
            v++;
           }
          }
         }
         else if(i>m)
         {for(int k=i-1,l=j+1;k>m;k--,l++)
          {
           if(a[k][l].charAt(0)!='0')
           {
            v++;
           }
          }
         }
         if(a[m][n2%10].charAt(0)==g)
         {
          v++;
         }
        }
        else if((i-j)==(m-(n2%10)))
        {
         if(i<m)
         {for(int k=i+1,l=j+1;k<m;k++,l++)
          {
           if(a[k][l].charAt(0)!='0')
           {
            v++;
           }
          }
         }
         else if(i>m)
         {for(int k=i-1,l=j-1;k>m;k--,l--)
          {
           if(a[k][l].charAt(0)!='0')
           {
            v++;
           }
          }
         }
         if(a[m][n2%10].charAt(0)==g)
         {
          v++;
         }
        }
       }
       else if(n1.charAt(1)=='Q')
       {
        if(i!=m&&j!=(n2%10)&&(i+j)!=(m+(n2%10))&&(i-j)!=(m-(n2%10)))
        {
         v++;
        }
        else if(i==m)
        {
         if(j<(n2%10))
         {for(int k=j+1;k<(n2%10);k++)
          {
           if(a[i][k].charAt(0)!='0')
           {
            v++;
           }
          }
         }
         else if(j>(n2%10))
         {for(int k=j-1;k>(n2%10);k--)
          {
           if(a[i][k].charAt(0)!='0')
           {
            v++;
           }
          }
         }
         if(a[m][n2%10].charAt(0)==g)
         {
          v++;
         }
        }
        else if(j==(n2%10))
        {
         if(i<m)
         {for(int k=i+1;k<m;k++)
          {
           if(a[k][j].charAt(0)!='0')
           {
            v++;
           }
          }
         }
         else if(i>m)
         {for(int k=i-1;k>m;k--)
          {
           if(a[k][j].charAt(0)!='0')
           {
            v++;
           }
          }
         }
         if(a[m][n2%10].charAt(0)==g)
         {
          v++;
         }
        }
        else if((i+j)==(m+(n2%10)))
        {
         if(i<m)
         {for(int k=i+1,l=j-1;k<m;k++,l--)
          {
           if(a[k][l].charAt(0)!='0')
           {
            v++;
           }
          }
         }
         else if(i>m)
         {for(int k=i-1,l=j+1;k>m;k--,l++)
          {
           if(a[k][l].charAt(0)!='0')
           {
            v++;
           }
          }
         }
         if(a[m][n2%10].charAt(0)==g)
         {
          v++;
         }
        }
        else if((i-j)==(m-(n2%10)))
        {
         if(i<m)
         {for(int k=i+1,l=j+1;k<m;k++,l++)
          {
           if(a[k][l].charAt(0)!='0')
           {
            v++;
           }
          }
         }
         else if(i>m)
         {for(int k=i-1,l=j-1;k>m;k--,l--)
          {
           if(a[k][l].charAt(0)!='0')
           {
            v++;
           }
          }
         }
         if(a[m][n2%10].charAt(0)==g)
         {
          v++;
         }
        }
       }
  return v;
 }
}