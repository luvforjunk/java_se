package array;

public class BubbleSort {

   public static void main(String[] args) {
      int[] ar = {43, 30, 25, 78, 55};
      
      System.out.print("정렬 전 : ");
      for(int x : ar) {
         System.out.print(x+"  ");
      }
      System.out.println();
      
      //정렬 - 오름차순
      int temp;
      for(int i=0; i<ar.length-1; i++) {
         for(int j=0; j<ar.length-1-i; j++) {            
            if(ar[j] > ar[j+1]) {
               temp = ar[j];
               ar[j] =  ar[j+1];
               ar[j+1] = temp;
            }
         }
      }
      
      System.out.print("정렬 후 : ");
      for(int x : ar) {
         System.out.print(x+"  ");
      }
      System.out.println();
   }

}


