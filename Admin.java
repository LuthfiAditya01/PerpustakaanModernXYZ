import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author LENOVO
 */
public class Admin {
    private ArrayList<Integer> nomorAdmin;
    private ArrayList<String> nama;
    private ArrayList<String> password;
    private String namabener;
    private String usertemp;
    private String passtemp;

    Scanner input = new Scanner(System.in);
    Buku buku = new Buku();
    AnggotaPerpustakaan member = new AnggotaPerpustakaan(new String());

    public Admin() {
        this.nomorAdmin = new ArrayList<Integer>();
        this.nomorAdmin.add(1);
        this.nomorAdmin.add(2);
        this.nomorAdmin.add(3);

        this.nama = new ArrayList<String>();
        this.nama.add("Adit");
        this.nama.add("Rofif");
        this.nama.add("Heru");

        this.password = new ArrayList<String>();
        this.password.add("aditbadai");
        this.password.add("ropipkece");
        this.password.add("herukece");

        this.namabener = "";

        this.usertemp = "";

        this.passtemp = "";
    }



//    public Admin() {
//        this.nomorAdmin = new ArrayList<Integer>();
//        this.nomorAdmin.add(1);
//        this.nomorAdmin.add(2);
//        this.nomorAdmin.add(3);
//        
//        this.nama = new ArrayList<String>();
//        this.nama.add("Adit");
//        this.nama.add("Rofif");
//        this.nama.add("Heru");
//        
//        this.password = new ArrayList<String>();
//        this.password.add("aditbadai");
//        this.password.add("ropipkece");
//        this.password.add("herukece");
//        
//        this.namabener = "";
//    }



	public Buku getBuku() {
		return buku;
	}



	public void setBuku(Buku buku) {
		this.buku = buku;
	}



	public AnggotaPerpustakaan getMember() {
		return member;
	}



	public void setMember(AnggotaPerpustakaan member) {
		this.member = member;
	}



	public ArrayList<Integer> getNomorAdmin() {
        return nomorAdmin;
    }

    public void setNomorAdmin(ArrayList<Integer> nomorAdmin) {
        this.nomorAdmin = nomorAdmin;
    }

    public ArrayList<String> getNama() {
        return nama;
    }

    public void setNama(ArrayList<String> nama) {
        this.nama = nama;
    }

    public ArrayList<String> getPassword() {
        return password;
    }

    public void setPassword(ArrayList<String> password) {
        this.password = password;
    }

    public String getNamabener() {
        return namabener;
    }

    public void setNamabener(String namabener) {
        this.namabener = namabener;
    }

    public String getUsertemp(){
      return usertemp;
    }

    public void setUsertemp(String usertemp){
      this.usertemp = usertemp;
    }

    public String getPasstemp(){
      return passtemp;
    }

    public void setPasstemp(String passtemp){
      this.passtemp = passtemp;
    }


    public void login() {
        boolean betulkeniraju = false;
        while (!betulkeniraju) {
            System.out.println("Masukkan Nomor Admin anda! ");
            String usetemp = input.nextLine();
            this.usertemp = usetemp;

            int indextemp = getNomorAdmin().indexOf(Integer.parseInt(getUsertemp()));

            if (indextemp != -1) {
                System.out.println("Hi, " + getNama().get(indextemp) + ". \nMasukkan password anda! ");
                String pastemp = input.nextLine();
                this.passtemp = pastemp;

                if (getPassword().get(indextemp).equals(getPasstemp())) {
                    betulkeniraju = true;
                    System.out.println("Login berhasil!\nSelamat datang " + getNama().get(indextemp));
                    namabener = getNama().get(indextemp);
                } else {
                    System.out.println("Password anda salah!\n");
                }
            }
            else {
              System.out.println("Nomor admin anda tidak ditemukan!\n");
            }
        }
    }


  public void kelolaBuku() {
      System.out.println("Berikut adalah daftar buku yang ada di Perpustakaan Modern XYZ: ");
      int panjangbaris = buku.getJudul().size();

      for (int i = 0; i < panjangbaris; i++) {
          System.out.println((i + 1) + ".");
          System.out.println("Judul : " + buku.getJudul().get(i));
          System.out.println("Penulis/Penerbit : " + buku.getPengarang().get(i));
          System.out.println("ISBN : " + buku.getIsbn().get(i));
          System.out.println("Stok Buku : " + buku.getStok().get(i) + " pcs");
          System.out.println("");
      }

      System.out.println("Masukkan Perubahan Stok pada buku yang ada : ");
      int stokbaru = input.nextInt();
      System.out.println("Masukkan nomor urut buku yang ingin anda ubah : ");
      int nourut = input.nextInt();

      // Validate that nourut is within bounds
      if (nourut >= 1 && nourut <= panjangbaris) {
          buku.getStok().set(nourut - 1, buku.getStok().get(nourut - 1) + stokbaru);

          System.out.println("Stok buku yang telah di-update adalah : ");
          for (int i = 0; i < panjangbaris; i++) {
              System.out.println((i + 1) + ".");
              System.out.println("Judul : " + buku.getJudul().get(i));
              System.out.println("Penulis/Penerbit : " + buku.getPengarang().get(i));
              System.out.println("ISBN : " + buku.getIsbn().get(i));
              System.out.println("Stok Buku : " + buku.getStok().get(i) + " pcs");
              System.out.println("");
          }
      } else {
          System.out.println("Nomor urut buku tidak valid.");
      }
  }
    public void kelolaAnggota(){
        System.out.println("Anda Memasuki menu Kelola Anggota, Masukkan nomor tindakan yang ingin anda lakukan : ");
        System.out.println("1. Menambah Anggota Baru\n2. Mengubah Informasi Anggota\n3. Menghapus Anggota");
        int operasi = input.nextInt();
        if (operasi==1){
            System.out.println("Anda akan menambahkan anggota baru.\nMasukkan nama anda : ");
            input.nextLine();
            String namaaa = input.nextLine();
            member.getNama().add(namaaa);
            System.out.println("Masukkan alamat anda : ");
            String Alamaaat = input.nextLine();
            member.getAlamat().add(Alamaaat);
            int nomoranggotabaru = member.getNomorAnggota().size()+1;
            member.getNomorAnggota().add(nomoranggotabaru);
            System.out.println("Masukkan Password anda!");
            String passtemp = input.nextLine();
            member.getPassword().add(passtemp);
            System.out.println("Selamat Datang " + namaaa +"!,\nBerikut detil Informasi anda yang baru saja ditambahkan!");
            System.out.println("Nama : " + namaaa);
            System.out.println("Alamat : " + Alamaaat);
            System.out.println("Nomor Anggota : " + nomoranggotabaru);
            System.out.println("Dimohon untuk mengingat selalu Nomor Anggota anda.\n");
            System.out.println("Proses penambahan anggota baru selesai.");
        }
        if (operasi==2){
            System.out.println("Anda akan mengubah informasi data diri anda, masukkan Nomor Anggota anda : ");
            int nomoranggota = input.nextInt();
            input.nextLine();
//            int ukuran = member.getNomorAnggota().size();
            boolean ketemu = member.getNomorAnggota().contains(nomoranggota);
            int index = member.getNomorAnggota().indexOf(nomoranggota);
            if(ketemu){
                System.out.println("Data ditemukan!");
                System.out.println("Nama : " + member.getNama().get(index));
                System.out.println("Alamat : " + member.getAlamat().get(index));
                System.out.println("Pilihlah nomor operasi yang ingin anda lakukan!");
                System.out.println("1. Mengubah nama\n2. Mengubah Alamat");
                int tindakan = input.nextInt();
                if(tindakan==1){
                    System.out.println("Masukkan nama anda : ");
                    input.nextLine();
                    String namabaru = input.nextLine();
                    member.getNama().set(index, namabaru);
                    System.out.println("Nama telah diubah!");
                    System.out.println("Nama : " + member.getNama().get(index));

                }
                if(tindakan==2){
                    System.out.println("Masukkan Alamat anda : ");
                    input.nextLine();
                    String alamatt = input.nextLine();
                    member.getAlamat().set(index, alamatt);
                    System.out.println("Alamat telah diubah!");
                    System.out.println("Alamat : " + member.getAlamat().get(index));

                }
            }
        }
        if(operasi==3){
            System.out.println("Anda memasuki halaman untuk menghapus anggota.");
            System.out.println("Masukkan nomor anggota anda : ");
            int nomorAnggota = input.nextInt();
            boolean ketemunggak = member.getNomorAnggota().contains(nomorAnggota);
            int indexhapus = member.getNomorAnggota().indexOf(nomorAnggota);
            if (ketemunggak){
                System.out.println("Informasi didapatkan!");
                System.out.println("Nama : " + member.getNama().get(indexhapus));
                System.out.println("Alamat : " + member.getAlamat().get(indexhapus));
                System.out.println("Nomor Anggota : " + member.getNomorAnggota().get(indexhapus));
                System.out.println("Apakah anda ingin menghapus Keanggotaan? (y/t)");
                input.nextLine();
                String keputusan = input.nextLine();
                switch (keputusan) {
                    case "y" -> {
                        member.getNama().remove(indexhapus);
                        member.getAlamat().remove(indexhapus);
                        member.getNomorAnggota().remove(indexhapus);
                        System.out.println("Keanggotaan berhasil dihapus.");
                    }
                    case "t" -> System.out.println("Tindakan Dibatalkan.");
                    default -> System.out.println("Wrong input, Terminating Process...");
                }
            }
        }

    }  
}
