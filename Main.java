import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author LENOVO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

     Admin mimin = new Admin();
      Buku buku = new Buku();
        AnggotaPerpustakaan member = new AnggotaPerpustakaan(new String());
        boolean lanjutenteu = false;
        String role = "";
        while (!lanjutenteu){
            boolean lanjutrole = false;
            System.out.println("Selamat datang di pusat informasi perpustakaan modern.\n1. Anggota\n2. Admin\n3. Selesai/Keluar \nMasukkan role anda : ");
            role = input.nextLine();
            if (role.equalsIgnoreCase("1")){
                member.login();
                System.out.println("Selamat datang " + member.getUserbener() + ", Berikut Operasi yang dapat dilakukan Anggota Perpustakaan Modern XYZ : ");
                System.out.println("1. Mencari Buku\n2. Meminjam Buku\n3. Mengembalikan Buku");
                System.out.println("Masukkan operasi yang kamu inginkan berdasarkan nomor urutnya ya!");
                String operasimember = input.nextLine();
                switch (operasimember) {
                    case "1" -> member.mencariBuku();
                    case "2" -> member.pinjamBuku();
                    case "3" -> member.mengembalikanBuku();
                    default -> System.out.println("Input yang anda masukkan salah!");
                }
                System.out.println("Apakah anda masih ingin melakukan tindakan lainnya? (y/n)");
                String putusanmember = "";
                boolean putusanmember1 = false;
                while (!putusanmember1){
                    putusanmember = input.nextLine();
                    switch (putusanmember){
                        case "y" -> {
                            System.out.println("\n\n");
                            putusanmember1=true;
                        }
                        case "n" -> {
                            System.out.println("Anda akan dialihkan ke role choosing menu...\n\n ");
                            putusanmember1 = true;
                        }
                        default -> {
                            System.out.println("Input yang anda masukkan salah!");
                        }
                    }
                }
            }
            else if (role.equalsIgnoreCase("2")){
                System.out.println("Memasuki menu Login Admin...\n");
                mimin.login();
                System.out.println("Selamat datang " + mimin.getNamabener() + ", Kami menyediakan opsi berikut : ");
                System.out.println("1. Kelola Anggota Perpustakaan\n2. Kelola Buku\n3. Buat Laporan Perpustakaan");
                System.out.println("Masukkan operasi yang ingin anda lakukan sesuai nomor urut diatas : ");
                String operasiadmin = input.nextLine();
                switch (operasiadmin) {
                    case "1" -> mimin.kelolaAnggota();
                    case "2" -> mimin.kelolaBuku();
                    case "3" -> System.out.println("Coming soon...");
                    default -> System.out.println("Input yang anda masukkan salah!");
                }
                System.out.println("Apakah anda masih ingin melakukan tindakan lainnya? (y/n)");
                String putusanadmin = "";
                boolean putusanadmin1 = false;
                while (!putusanadmin1){
                    putusanadmin = input.nextLine();
                    if (putusanadmin.equalsIgnoreCase("y")){
                        System.out.println("");
                    }
                    switch (putusanadmin){
                        case "y" -> {
                            System.out.println("\n\n");
                            putusanadmin1 = true;
                        }
                        case "n" -> {
                            System.out.println("Anda akan dialihkan ke role choosing menu...\n\n ");
                            putusanadmin1 = true;
                        }
                        default -> {
                            System.out.println("Input yang anda masukkan salah!");
                        }
                    }
                }
            }
            else if (role.equalsIgnoreCase("3")){
                System.out.println("Terima kasih telah menggunakan Pusat Informasi Perpustakaan Modern!\nHave a nice day!");
                lanjutenteu = true;
            } else {
            }
        }

        // TODO code application logic here
    }

}
