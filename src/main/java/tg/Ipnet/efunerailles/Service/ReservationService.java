package tg.Ipnet.efunerailles.Service;

import java.util.List;

import tg.Ipnet.efunerailles.Entity.Reservation;

public interface ReservationService {
	
	 Reservation saveReservation(Reservation reservation);

	    Reservation updateReservation(Long id, Reservation reservation);

	    void deleteReservation(Long id);

	    Reservation getReservationById(Long id);

	    List<Reservation> getAllReservations();
}
