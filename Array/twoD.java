class TwoDArray {
  public static void main(String[] args)
  {
    int towD [][]=new int [4][5];
    int i,j,k=0;
    for(i=0;i<4;i++)
    for(j=0;j<5;j++)
    {
      towD[i][j]=k;
      k++;
    }
    for(i=0;i<4;i++)
    for(j=0;j<5;j++)
    {
      System.out.println("Array="+towD[i][j]);
      System.out.println('Git Branch merge');
      k++;
    }
  }
}