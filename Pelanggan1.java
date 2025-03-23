public class Pelanggan1 {
    // Variabel instance bersifat private (Encapsulation)
    private String nomorPelanggan;
    private String nama;
    private double saldo;
    private String pin;
    private boolean isBlocked;  // Untuk mengecek apakah akun diblokir

    // Constructor untuk menginisialisasi objek pelanggan
    public Pelanggan1(String nomorPelanggan, String nama, double saldo, String pin) {
        this.nomorPelanggan = nomorPelanggan;
        this.nama = nama;
        this.saldo = saldo;
        this.pin = pin;
        this.isBlocked = false;  // Awalnya akun tidak diblokir
    }

    // Getter untuk nomor pelanggan
    public String getNomorPelanggan() {
        return nomorPelanggan;
    }

    // Getter untuk nama pelanggan
    public String getNama() {
        return nama;
    }

    // Getter saldo (Encapsulation)
    public double getSaldo() {
        return saldo;
    }

    // Setter saldo (Encapsulation)
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Metode untuk verifikasi PIN pelanggan (Blokir akun setelah 3x salah)
    public boolean verifikasiPin(String inputPin) {
        if (isBlocked) {
            System.out.println("Akun ini telah diblokir!");
            return false;
        }

        int percobaan = 0;
        while (!inputPin.equals(pin)) {
            percobaan++;
            if (percobaan >= 3) {
                isBlocked = true;  // Akun diblokir setelah 3x salah PIN
                System.out.println("Akun telah diblokir karena 3x kesalahan PIN.");
                return false;
            }
            System.out.print("PIN salah! Coba lagi: ");
            return false;
        }
        return true;
    }
}
