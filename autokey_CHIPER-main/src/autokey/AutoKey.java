/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autokey;
import java.*;

/**
 *
 * @author arya
 */
public class AutoKey {
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890~!@#$%^&*()_+?:”{}-=+;'?/.>,<";
    
    public String AutoEnkrip(String text, String key) {
        int len = text.length();
        String subkey = key + text;
        subkey = subkey.substring(0,subkey.length()-key.length());
      
        String temp = "";
            for(int x=0;x<len;x++){
                int get1 = alphabet.indexOf(text.charAt(x));
                int get2 = alphabet.indexOf(subkey.charAt(x));
                int total = (get1 + get2)%26;
                temp += alphabet.charAt(total);
            }
        return temp;
}
    public String AutoDekrip(String text,String key){
      int len = text.length();
      
      String current = key;
      String temp ="";
      
      for(int x=0;x<len;x++){
         int get1 = alphabet.indexOf(text.charAt(x));
         int get2 = alphabet.indexOf(current.charAt(x));
         
         int total = (get1 - get2)%26;
         total = (total<0)? total + 26 : total;
         temp += alphabet.charAt(total);
         
         current += alphabet.charAt(total);
      }
      return temp;
   }
}
//class main{// ga usah dipeduliin ini cuman coba - coba aja biar tau hasilnya
//    private static String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//   
//   public static void main(String[] args){
//      String text1 = "FOLLOWDIRECTION"; // ini nanti dibuat gui buat inputnya
//      String text2 = "HELLO";
//      String key1 = "P"; // ini juga buat nanti di gui inputnya
//      String key2 = "NHELL";
//      AutoKey k = new AutoKey();
//      AvalanchEffect av = new AvalanchEffect();
//      
//      if(key1.matches("[-+]?\\d*\\.?\\d+"))
//         key1 = ""+alpha.charAt(Integer.parseInt(key1));
//      
//      if(key2.matches("[-+]?\\d*\\.?\\d+"))
//         key2 = ""+alpha.charAt(Integer.parseInt(key2));
//         
//      String enc = k.AutoEnkrip(text1, key1);
//      System.out.println("Plaintext : "+text1);
//      System.out.println("Encrypted : "+enc); // ini hasilnya
//      System.out.println("Decrypted : "+k.AutoDekrip(enc, key1)); // ini hasilnya
//      
//      String temp = k.AutoEnkrip(text2, key2);
//      System.out.println("Plaintext : "+text2);
//      System.out.println("Encrypted : "+temp);
//      System.out.println("Decrypted : "+k.AutoDekrip(temp, key2));
//       System.out.println("hasil avalanche : "+av.hitAvalnche(temp, k.AutoDekrip(text2, key2))+"%");
//      // buat evaluasinya nanti ditambahin lagi tinggal dipanggil ama dirubah dikit2 mungkin ada yang salah akunya
//
//   }
//}