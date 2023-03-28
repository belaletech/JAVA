class DuplicateValue {
  public static void main(String[] args)
  {
    int [] arr={20,30,40,50,60,20,40,50,50,50};
    for(int i=0;i<arr.length-1;i++)
    {
      for(int j=0;i<arr.length-1;j++)
      {
        if((arr[i]==arr[j])&&(i!=j));
        {
          System.out.println("Duplicate Element is"+arr[j]);
        }
      }
    }
  }
}