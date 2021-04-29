package ua.com.nix;


 public class Who {
     public static void main(String[] args) {
         Man man = new Man();
         Animal animal = new Animal();
         String string1 = man.sayWhoYou();
         String string12 = animal.sayWhoYou();
         String string1_Upp = StringUtils.upperCase(string1);
         String string2_Upp = StringUtils.upperCase(string2);
         System.out.println("Big: " + string1 + "\n" + string12);

     }
 }


