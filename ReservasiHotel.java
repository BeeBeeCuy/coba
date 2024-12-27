import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

class ReservasiHotel {
    List<Kamar> daftarKamar = new ArrayList<>();
    List<Pelanggan> daftarPelanggan = new ArrayList<>();
    List<Reservasi> daftarReservasi = new ArrayList<>();

    public void tambahKamar(Kamar kamar) {
        daftarKamar.add(kamar);
    }

    public List<Kamar> getDaftarKamarTersedia() {
        List<Kamar> kamarTersedia = new ArrayList<>();
        for (Kamar kamar : daftarKamar) {
            if (kamar.cekKetersediaan()) {
                kamarTersedia.add(kamar);
            }
        }
        return kamarTersedia;
    }

    public void buatReservasi(String nama, String alamat, String email, Kamar kamar) {
        Pelanggan pelanggan = new Pelanggan("123","agus","0123","tuban","agus@gmail.com");
        LocalDate checkin = LocalDate.now(); // Example check-in date
        LocalDate checkout = checkin.plusDays(1); // Example check-out date
        Reservasi reservasi = new Reservasi(pelanggan, kamar, checkin, checkout);
        daftarReservasi.add(reservasi);
        kamar.updateStatus("Tidak Tersedia"); // Update room status
    }

    public void batalkanReservasi(String nama) {
        for (Reservasi reservasi : daftarReservasi) {
            if (reservasi.pelanggan.getNama().equals(nama)) {
                reservasi.statusReservasi = "Dibatalkan";
                reservasi.kamar.updateStatus("Tersedia"); // Update room status back to available
                JOptionPane.showMessageDialog(null, "Reservasi atas nama " + nama + " telah dibatalkan.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Tidak ditemukan reservasi atas nama " + nama);
    }
}