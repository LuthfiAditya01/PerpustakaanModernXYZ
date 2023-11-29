import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.time.LocalDateTime;

/**
 *
 * @author LENOVO
 */
public class AnggotaPerpustakaan {
    Scanner input = new Scanner(System.in);
    private ArrayList<Integer> nomorAnggota;
    private ArrayList<String> nama;
    private ArrayList<String> alamat;
    private ArrayList<String> password;
//    private String loginuser;
    private String userbener;
//    private ArrayList<TransaksiPeminjaman> sejarahPeminjaman;
    Buku buku = new Buku();
    TransaksiPeminjaman pinjam = new TransaksiPeminjaman(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
    TransaksiPengembalian balik = new TransaksiPengembalian(new ArrayList<>(),new ArrayList<>(),new ArrayList<>());

    public AnggotaPerpustakaan(String userbener) {
        this.nomorAnggota = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        this.nama = new ArrayList<>(Arrays.asList("Aditya Wimbledon", "Ropip Ramadhan", "Muhammad Hewru", "Anya", "Adzana Shaliha Alifyaa", "Mutiara Azzahra Umandana"));
        this.alamat = new ArrayList<>(Arrays.asList("Tangerang", "Bandar Lampung", "Bandar Lampung", "Ostenia", "Tangerang", "Tangerang"));
        this.password = new ArrayList<>(Arrays.asList("aditganteng123", "ropipganteng123", "heruganteng123", "anyacantik123", "acelcantik123", "muthecantik123"));
//        this.loginuser = loginuser;
        this.userbener = userbener;
    }

    public ArrayList<Integer> getNomorAnggota() {
        return nomorAnggota;
    }

    public void setNomorAnggota(ArrayList<Integer> nomorAnggota) {
        this.nomorAnggota = nomorAnggota;
    }

    public ArrayList<String> getNama() {
        return nama;
    }

    public void setNama(ArrayList<String> nama) {
        this.nama = nama;
    }

    public ArrayList<String> getAlamat() {
        return alamat;
    }

    public void setAlamat(ArrayList<String> alamat) {
        this.alamat = alamat;
    }

//    public String getLoginuser() {
//        return loginuser;
//    }
//
//    public void setLoginuser(String loginuser) {
//        this.loginuser = loginuser;
//    }

    public ArrayList<String> getPassword() {
        return password;
    }

    public void setPassword(ArrayList<String> password) {
        this.password = password;
    }

    public String getUserbener() {
        return userbener;
    }

    public void setUserbener(String userbener) {
        this.userbener = userbener;
    }



  public void login() {
      boolean betulkeniraju = false;
      while (!betulkeniraju) {
          System.out.println("Masukkan Nomor Anggota anda! ");
          int usertemp = input.nextInt();

          // Iterate through the list to find the user
          int indextemp = -1;
          for (int i = 0; i < getNomorAnggota().size(); i++) {
              if (getNomorAnggota().get(i).equals(usertemp)) {
                  indextemp = i;
                  break;
              }
          }

          if (indextemp != -1) {
              System.out.println("Hi, " + getNama().get(indextemp) + ". \nMasukkan password anda! ");
              input.nextLine();
              String passtemp = input.nextLine();

              if (getPassword().get(indextemp).equals(passtemp)) {
                  this.userbener = getNama().get(indextemp);
                  betulkeniraju = true;
                  System.out.println("Login berhasil!\nSelamat datang " + getNama().get(indextemp));
              } else {
                  System.out.println("Password anda salah!\n");
              }
          } else {
              System.out.println("Nomor Anggota tidak ditemukan!\n");
          }
      }
  }


    public void pinjamBuku(){
        System.out.println("Anda Memasuki menu Peminjaman Buku\n Daftar Buku yang ada di Perpustakaan Modern XYZ adalah : ");
        int panjangbaris = buku.getJudul().size();
        for (int i=0; i<panjangbaris; i++){
                System.out.println((i+1) + ".");
                System.out.println("Judul : " + buku.getJudul().get(i));
                System.out.println("Penulis/Penerbit : " + buku.getPengarang().get(i));
                System.out.println("ISBN : " + buku.getIsbn().get(i));
                System.out.println("Stok Buku : " + buku.getStok().get(i) + " pcs");
                System.out.println("");
        }
        System.out.println("Masukkan nomor urut buku yang ingin anda pinjam : ");
        int nourut = input.nextInt();
          if (buku.getStok().get(nourut-1) > 0) {
              System.out.println("Proses berhasil!");
              System.out.println("Anda telah meminjam buku " + buku.getJudul().get(nourut-1));

              // Update stock
              buku.getStok().set(nourut-1, buku.getStok().get(nourut-1) - 1);
              System.out.println("Stok buku setelah peminjaman: " + buku.getStok().get(nourut-1));

              // Assuming pinjam is an object with a getJudul() method
            pinjam.getJudul().add(buku.getJudul().get(nourut - 1));
            pinjam.getNama().add(this.userbener);
            pinjam.getTanggalPinjam().add(LocalDateTime.now(/*ZoneId.of("Asia/Jakarta")*/));

            // Add 7 days to each LocalDateTime in the list
            LocalDateTime tanggalPinjam = pinjam.getTanggalPinjam().get(pinjam.getTanggalPinjam().size() - 1);
            LocalDateTime tanggalKembali = tanggalPinjam.plusDays(7);
            pinjam.getTanggalKembali().add(tanggalKembali);
          } 
          else if (buku.getStok().get(nourut-1)<=0){
            System.out.println("Proses peminjaman Gagal!");
          }
    }
    public void mengembalikanBuku(){
            System.out.println("Anda memasuki menu Pengembalian Buku Pinjaman!");
            int panjangbaris = buku.getJudul().size();
            for (int i=0; i<panjangbaris; i++){
                System.out.println((i+1) + ".");
                System.out.println("Judul : " + buku.getJudul().get(i));
                System.out.println("Penulis/Penerbit : " + buku.getPengarang().get(i));
                System.out.println("ISBN : " + buku.getIsbn().get(i));
                System.out.println("Stok Buku : " + buku.getStok().get(i) + " pcs");
                System.out.println("");
            }
            System.out.println("Masukkan nomor urut buku yang ingin anda kembalikan : ");
            int nourut = input.nextInt();
            buku.getStok().set(nourut-1, buku.getStok().get(nourut-1) + 1);
            System.out.println("Proses berhasil!\n" +"Anda telah mengembalikan buku " + buku.getJudul().get(nourut-1));
        }

    public void mencariBuku(){
        System.out.println("Anda memasuki menu Pencarian Buku!");
        boolean adagaktuh = false;
        int panjangbaris = buku.getJudul().size();
        int i = 0;
        if (adagaktuh == false){
            System.out.println("Anda memasuki pencarian buku dengan judul lengkap!\nMasukkan judul buku dengan huruf kapital semua !");
            String namaaa = input.nextLine();
            for (i=0; i<panjangbaris; i++){
                if (buku.getJudul().get(i).equalsIgnoreCase(namaaa)){
                    adagaktuh = true;
                    break;
                }
            }
        }
        if (adagaktuh == false){
            System.out.println("Pencarian dengan nama tidak ditemukan! masukkan ISBN dari buku yang anda cari!");
            String nomor = input.nextLine();
            for (i=0; i<panjangbaris; i++){
                if (buku.getIsbn().get(i).equals(nomor)){
                    adagaktuh = true;
                    break;
                }
            }
        }
        if (adagaktuh == false){
            System.out.println("Pencarian dengan ISBN gagal, masukkan nama penulis dengan penulisan huruf kapital semua : ");
            String penulis = input.nextLine();
            for (i=0; i<panjangbaris; i++){
                if (buku.getPengarang().get(i).equalsIgnoreCase(penulis)){
                    adagaktuh = true;
                    break;
                }
            }
        }
        if (adagaktuh){
            System.out.println("Pencarian Berhasil!");
            System.out.println("Judul Buku : " + buku.getJudul().get(i));
            System.out.println("Penulis : " + buku.getPengarang().get(i));
            System.out.println("ISBN : " + buku.getIsbn().get(i));
            System.out.println("Stok Tersedia : " + buku.getStok().get(i));
        }
        else {
            System.out.println("Maaf, Pencarian Gagal.");
        }
    }

    public static void main (String[] args){
        AnggotaPerpustakaan member = new AnggotaPerpustakaan(new String());
        member.pinjamBuku();
        System.out.println("");
        System.out.println("\n\n");
        member.mengembalikanBuku();
        System.out.println("");
        member.mencariBuku();
    }
}
