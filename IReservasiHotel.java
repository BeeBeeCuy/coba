import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class IReservasiHotel implements InterfaceReservasi {
    List<Pelanggan> daftarPelanggan = new ArrayList<>();
    List<Reservasi> daftarReservasi = new ArrayList<>();

    @Override
    public void buatReservasi() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan nama untuk reservasi:");
        String nama = scanner.nextLine();
        System.out.println("Masukkan alamat:");
        String alamat = scanner.nextLine();
        System.out.println("Masukkan email:");
        String email = scanner.nextLine();
        Pelanggan pelanggan = new Pelanggan("123","erik","123","oi","Erik@gmail.com");
        daftarPelanggan.add(pelanggan);
        System.out.println("Reservasi atas nama " + nama + " telah dibuat.");
    }

    @Override
    public void batalkanReservasi() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan nama untuk membatalkan reservasi:");
        String nama = scanner.nextLine();
        // Logika untuk membatalkan reservasi
    }
}
