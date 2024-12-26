public class Main {
    public static void main(String[] args) {
        IReservasiHotel reservasiHotel = new IReservasiHotel();
        ReservasiGUI gui = new ReservasiGUI(reservasiHotel);
    }
}