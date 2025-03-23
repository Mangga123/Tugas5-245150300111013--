public class Transaksi {
    public static void pembelian(Pelanggan1 pelanggan, double jumlahPembelian) {
        if (pelanggan.getSaldo() < jumlahPembelian) {
            System.out.println("Saldo tidak mencukupi!");
            return;
        }

        double cashback = hitungCashback(pelanggan.getNomorPelanggan(), jumlahPembelian);
        pelanggan.setSaldo(pelanggan.getSaldo() - jumlahPembelian + cashback);
        System.out.println("Pembelian berhasil! Cashback Rp" + cashback);
        System.out.println("Saldo sekarang: Rp" + String.format("%,.0f", pelanggan.getSaldo()));
    }

    public static void topUp(Pelanggan1 pelanggan, double jumlahTopUp) {
        pelanggan.setSaldo(pelanggan.getSaldo() + jumlahTopUp);
        System.out.println("Top-up berhasil! Saldo sekarang: Rp" + pelanggan.getSaldo());
    }

    private static double hitungCashback(String nomorPelanggan, double jumlahPembelian) {
        double cashback = 0;
        String kodeJenis = nomorPelanggan.substring(0, 2);

        if (jumlahPembelian > 1000000) {
            if (kodeJenis.equals("38")) cashback = jumlahPembelian * 0.05;
            if (kodeJenis.equals("56")) cashback = jumlahPembelian * 0.07;
            if (kodeJenis.equals("74")) cashback = jumlahPembelian * 0.10;
        } else {
            if (kodeJenis.equals("56")) cashback = jumlahPembelian * 0.02;
            if (kodeJenis.equals("74")) cashback = jumlahPembelian * 0.05;
        }
        return cashback;
    }
}
