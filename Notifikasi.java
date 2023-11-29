import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class Notifikasi {
    private ArrayList<String> title;
    private String message;

    public Notifikasi(ArrayList<String> title, String message) {
        this.title = title;
        this.message = message;
    }

    public ArrayList<String> getTitle() {
        return title;
    }

    public void setTitle(ArrayList<String> title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
