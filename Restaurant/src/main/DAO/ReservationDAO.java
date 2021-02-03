package main.DAO;

import java.util.List;
import main.entity.Reservation;

public interface ReservationDAO {

	public Reservation getReservation(int id);
	public List<Reservation> getReservationList();
	public void saveReservation(Reservation reservation);
	public void deleteReservation(int id);
	public long getUnreadResCount();
}
