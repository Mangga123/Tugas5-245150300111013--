import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();

        // Menambahkan pelanggan awal
        admin.tambahPelanggan("3812345678", "Budi", 500000, "1234");
        admin.tambahPelanggan("5612345678", "Angga", 2000000, "5678");
        admin.tambahPelanggan("7412345678", "Citra", 3000000, "9101");

        // Meminta input nomor pelanggan
        System.out.print("Masukkan nomor pelanggan: ");
        String nomorPelanggan = scanner.nextLine();

        Pelanggan1 pelanggan = admin.getPelanggan(nomorPelanggan);
        if (pelanggan == null) {
            System.out.println("Nomor pelanggan tidak ditemukan!");
            return;
        }

        // Loop transaksi hingga pengguna memilih exit
        boolean running = true;
        while (running) {
            System.out.println("\n===== Menu Transaksi =====");
            System.out.println("1. Pembelian");
            System.out.println("2. Top-Up");
            System.out.println("3. Cek Saldo");
            System.out.println("4. Keluar");
            System.out.print("Pilihan: ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan jumlah pembelian: Rp");
                    double jumlahPembelian = scanner.nextDouble();
                    Transaksi.pembelian(pelanggan, jumlahPembelian);
                    break;
                case 2:
                    System.out.print("Masukkan jumlah top-up: Rp");
                    double jumlahTopUp = scanner.nextDouble();
                    Transaksi.topUp(pelanggan, jumlahTopUp);
                    break;
                case 3:
                    System.out.println("Saldo Anda: Rp" + pelanggan.getSaldo());
                    break;
                case 4:
                    running = false;
                    System.out.println("Terima kasih! Program selesai.");
                    break;
            }
        }

        scanner.close();
    }
}
