import java.util.ArrayList;
import java.time.LocalDateTime;

public class TransaksiPeminjaman {
    private ArrayList<String> nama;
//    private Buku[] buku;
    private ArrayList<String> tanggalPinjamString;
    private ArrayList<LocalDateTime> tanggalPinjam;
    private ArrayList<LocalDateTime> tanggalKembali;
    private ArrayList<String> judul;
    // Buku buku = new Buku();

    public TransaksiPeminjaman(ArrayList<String> nama, ArrayList<String> tanggalPinjamString, ArrayList<LocalDateTime> tanggalPinjam, ArrayList<LocalDateTime> tanggalKembali, ArrayList<String> judul) {
        this.nama = nama;
        this.tanggalPinjamString = tanggalPinjamString;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
        this.judul = judul;
    }

    public ArrayList<String> getNama() {
        return nama;
    }

    public void setNama(ArrayList<String> nama) {
        this.nama = nama;
    }

    public ArrayList<String> getTanggalPinjamString() {
        return tanggalPinjamString;
    }

    public void setTanggalPinjamString(ArrayList<String> tanggalPinjamString) {
        this.tanggalPinjamString = tanggalPinjamString;
    }

    public ArrayList<LocalDateTime> getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(ArrayList<LocalDateTime> tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public ArrayList<LocalDateTime> getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(ArrayList<LocalDateTime> tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    public ArrayList<String> getJudul() {
        return judul;
    }

    public void setJudul(ArrayList<String> judul) {
        this.judul = judul;
    }




}
