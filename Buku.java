import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Buku {
  Scanner input = new Scanner(System.in);
  private ArrayList<String> isbn;
  private ArrayList<String> pengarang;
  private ArrayList<String> judul;
  private ArrayList<Integer> stok;

  public Buku() {
    this.isbn = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
    this.pengarang = new ArrayList<>(Arrays.asList("J.K. ROWLING", "MOONSCOOP", "JKT48 OPERATION TEAM",
        "JYP ENTERTAINMENT", "KOYOHARU GOTOUGE"));
    this.judul = new ArrayList<>(Arrays.asList("HARRY POTTER", "GARAGE KIDS", "JKT48 BANZAI! PHOTOBOOK",
        "TWICE SEASON\'S GREETINGS 2023", "KIMETSU NO YAIBA VOL.23"));
    this.stok = new ArrayList<>(Arrays.asList(3, 0, 2, 1, 4));
  }

  public ArrayList<String> getIsbn() {
    return isbn;
  }

  public void setIsbn(final ArrayList<String> isbn) {
    this.isbn = isbn;
  }

  public ArrayList<String> getPengarang() {
    return pengarang;
  }

  public void setPengarang(final ArrayList<String> pengarang) {
    this.pengarang = pengarang;
  }

  public ArrayList<String> getJudul() {
    return judul;
  }

  public void setJudul(final ArrayList<String> judul) {
    this.judul = judul;
  }

  public ArrayList<Integer> getStok() {
    return stok;
  }

  public void setStok(final ArrayList<Integer> stok) {
    this.stok = stok;
  }

  // private String[][] bukuuuu;
  // private int[] stok;

  // public Buku(String[][] bukuuuu, int[] stok/*, String[] isbn, String[]
  // pengarang, String[] judul*/) {
  // this.bukuuuu = new String[][]{{"HARRY POTTER", "J.K. ROWLING", "1", "3"},
  // {"GARAGE KIDS", "MoonScoop", "2", "0"},
  // {"JKT48 BANZAI! PHOTOBOOK", "JKT48 OPERATION TEAM", "3", "0"},
  // {"TWICE SEASON\'S GREETINGS", "JYP ENTERTAINMENT", "4", "1"},
  // {"KIMETSU NO YAIBA VOL.23", "KOYOHARU GOTOUGE", "5", "2"}};
  // this.stok = new int[] {3,0,0,1,2};
  //// this.isbn = isbn;
  //// this.pengarang = pengarang;
  //// this.judul = judul;
  // }

  // public String[][] getBukuuuu() {
  // return bukuuuu;
  // }
  //
  // public void setBukuuuu(String[][] bukuuuu) {
  // this.bukuuuu = bukuuuu;
  // }
  //
  // public int[] getStok() {
  // return stok;
  // }
  //
  // public void setStok(int[] stok) {
  // this.stok = stok;
  // }
  //
  //// public String[] getIsbn() {
  //// return isbn;
  //// }
  ////
  //// public void setIsbn(String[] isbn) {
  //// this.isbn = isbn;
  //// }
  ////
  //// public String[] getPengarang() {
  //// return pengarang;
  //// }
  ////
  //// public void setPengarang(String[] pengarang) {
  //// this.pengarang = pengarang;
  //// }
  ////
  //// public String[] getJudul() {
  //// return judul;
  //// }
  ////
  //// public void setJudul(String[] judul) {
  //// this.judul = judul;
  //// }

  public void cekInformasi() {
    System.out.println(
        "Anda memasuki halaman \"Cek Informasi Buku\"\nMasukkan judul buku yang ingin anda cari dalam huruf Kapital! : ");
    int i = 0;
    boolean benergaktuh = false;
    if (!benergaktuh) {
      final String jjuudduull = input.nextLine();
      for (i = 0; i < judul.size(); i++) {
        if (judul.get(i).equalsIgnoreCase(jjuudduull)) {
          benergaktuh = true;
          break;
        }
      }
    } else if (!benergaktuh) {
      System.out.println("Pencarian dengan judul Gagal!\nMasukkan Nomor ISBN buku!");
      final String ISBN = input.nextLine();
      for (i = 0; i < isbn.size(); i++) {
        if (isbn.get(i).equals(ISBN)) {
          benergaktuh = true;
          break;
        }
      }
    } else if (!benergaktuh) {
      final String penulis = input.nextLine();
      for (i = 0; i < pengarang.size(); i++) {
        if (pengarang.get(i).equalsIgnoreCase(penulis)) {
          benergaktuh = true;
          break;
        }
      }
    } else if (benergaktuh) {
      System.out.println("Informasi buku Ditemukan!\nJudul : " + judul.get(i) +
          "\nPenulis / Penerbit : " + pengarang.get(i) +
          "\nISBN : " + isbn.get(i) +
          "\nStok buku tersedia : " + stok.get(i) + " pcs.");
    } else {
      System.out.println("Maaf, buku yang anda cari tidak ditemukan!");
    }
  }

  public void cekKetersediaan() {
    System.out.println("Anda memasuki menu \"Cek Ketersediaan Buku\"\nMasukkan judul buku : ");
    int i = 0;
    boolean cek = false;
    if (!cek) {
      final String juduul = input.nextLine();
      for (i = 0; i < judul.size(); i++) {
        if (judul.get(i).equals(juduul)) {
          cek = true;
          break;
        }
      }
    }
    if (!cek) {
      System.out.println("Pencarian dengan judul Gagal!\nMasukkan nomor ISBN buku : ");
      final String ISBN = input.nextLine();
      for (i = 0; i < isbn.size(); i++) {
        if (isbn.get(i).equals(ISBN)) {
          cek = true;
          break;
        }
      }
    }
    if (!cek) {
      System.out.println("Pencarian dengan nomor ISBN Gagal!\nMasukkan nama Penulis : ");
      final String penulis = input.nextLine();
      for (i = 0; i < pengarang.size(); i++) {
        if (pengarang.get(i).equals(penulis)) {
          cek = true;
          break;
        }
      }
    }
    if (cek) {
      System.out.println("Informasi buku Ditemukan!\nJudul : " + judul.get(i) +
          "\nPenulis / Penerbit : " + pengarang.get(i) +
          "\nISBN : " + isbn.get(i) +
          "\nStok buku tersedia : " + stok.get(i) + " pcs.");
    }
    if (!cek) {
      System.out.println("Maaf, buku yang anda cari tidak tersedia.");
    }
  }
}
