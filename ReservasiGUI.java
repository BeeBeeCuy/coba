import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservasiGUI {
    private InterfaceReservasi sistemReservasi;
    private JFrame frame;
    private JTextField namaField;
    private JTextField alamatField;
    private JTextField emailField;
    private JButton buatReservasiButton;
    private JButton batalkanReservasiButton;

    public ReservasiGUI(InterfaceReservasi sistemReservasi) {
        this.sistemReservasi = sistemReservasi;
        initialize();
    }

    private void initialize() {
        // Create the main frame
        frame = new JFrame("Reservasi Hotel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Create a panel for input fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        // Create labels and text fields
        inputPanel.add(new JLabel("Nama:"));
        namaField = new JTextField();
        inputPanel.add(namaField);

        inputPanel.add(new JLabel("Alamat:"));
        alamatField = new JTextField();
        inputPanel.add(alamatField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        // Create buttons
        buatReservasiButton = new JButton("Buat Reservasi");
        batalkanReservasiButton = new JButton("Batalkan Reservasi");

        // Add action listeners to buttons
        buatReservasiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buatReservasi();
            }
        });

        batalkanReservasiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                batalkanReservasi();
            }
        });

        // Add components to the frame
        frame.add(inputPanel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(buatReservasiButton);
        buttonPanel.add(batalkanReservasiButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Set frame visibility
        frame.setVisible(true);
    }

    private void buatReservasi() {
        String nama = namaField.getText();
        String alamat = alamatField.getText();
        String email = emailField.getText();

        if (!nama.isEmpty() && !alamat.isEmpty() && !email.isEmpty()) {
            Pelanggan pelanggan = new Pelanggan("123","erik","123","oi","Erik@gmail.com");
            sistemReservasi.buatReservasi(); // You may want to pass the pelanggan object to this method
            JOptionPane.showMessageDialog(frame, "Reservasi atas nama " + nama + " telah dibuat.");
        } else {
            JOptionPane.showMessageDialog(frame, "Silakan isi semua field.");
        }
    }

    private void batalkanReservasi() {
        String nama = JOptionPane.showInputDialog(frame, "Masukkan nama untuk membatalkan reservasi:");
        if (nama != null && !nama.isEmpty()) {
            sistemReservasi.batalkanReservasi(); // Implement logic to cancel reservation
            JOptionPane.showMessageDialog(frame, "Reservasi atas nama " + nama + " telah dibatalkan.");
        } else {
            JOptionPane.showMessageDialog(frame, "Nama tidak boleh kosong.");
        }
    }
}