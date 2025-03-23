import java.util.HashMap;

public class Admin {
    private HashMap<String, Pelanggan1> pelangganMap;

    public Admin() {
        pelangganMap = new HashMap<>();
    }

    public void tambahPelanggan(String nomorPelanggan, String nama, double saldo, String pin) {
        if (pelangganMap.containsKey(nomorPelanggan)) {
            System.out.println("Nomor pelanggan sudah terdaftar!");
            return;
        }

        Pelanggan1 pelangganBaru = new Pelanggan1(nomorPelanggan, nama, saldo, pin);
        pelangganMap.put(nomorPelanggan, pelangganBaru);
        System.out.println("Pelanggan baru berhasil ditambahkan!");
    }

    public Pelanggan1 getPelanggan(String nomorPelanggan) {
        return pelangganMap.get(nomorPelanggan);
    }
}
