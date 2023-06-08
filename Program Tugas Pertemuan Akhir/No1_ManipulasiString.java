public class No1_ManipulasiString {
    public static void main(String[] args) {
        String awal = "JavaScript adalah bahasa pemrograman tingkat tinggi dan dinamis";
        
        Tampilan(awal);
    }
    
    public static void Tampilan(String awal) {
        String No1 = awal.substring(0, 36);
        String No2 = No1.toLowerCase();
        String No3 = No1.toUpperCase();
        String No4 = awal.substring(25, 36);
        String No5 = awal.substring(37);

        System.out.println("\n1.  Program dalam Java dengan  method yang sesuai  pada tampilan/kasus berikut:\n");
        System.out.println("+-----------------------------------------------------+");
        System.out.println("| String Awal | String Awal JavaScript adalah bahasa  |");
        System.out.println("|             | pemrograman tingkat tinggi dan dinamis|");
        System.out.println("+-----------------------------------------------------+");
        System.out.println("|                  Tampilkan Ke Layar                 |");               
        System.out.println("+-----------------------------------------------------+");
        System.out.println("|      1.     | " + No1 + "  |");
        System.out.println("|      2.     | " + No2 + "  |");
        System.out.println("|      3.     | " + No3 + "  |");
        System.out.println("|      4.     | " + No4 + "                           |");
        System.out.println("|      5.     | " + No5 + "            |");
        System.out.println("+-----------------------------------------------------+\n");
    }
}
