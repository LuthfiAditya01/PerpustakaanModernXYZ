import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class TransaksiPengembalian {
    private ArrayList<String> nama;
    private ArrayList<String> judul;
    private ArrayList<LocalDateTime> tanggalKembali;
    Buku buku = new Buku();

    public TransaksiPengembalian(ArrayList<String> nama, ArrayList<String> judul, ArrayList<LocalDateTime> tanggalKembali) {
        this.nama = nama;
        this.judul = judul;
        this.tanggalKembali = tanggalKembali;
    }

    public ArrayList<String> getNama() {
        return nama;
    }

    public void setNama(ArrayList<String> nama) {
        this.nama = nama;
    }

    public ArrayList<String> getJudul() {
        return judul;
    }

    public void setJudul(ArrayList<String> judul) {
        this.judul = judul;
    }

    public ArrayList<LocalDateTime> getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(ArrayList<LocalDateTime> tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }




}
