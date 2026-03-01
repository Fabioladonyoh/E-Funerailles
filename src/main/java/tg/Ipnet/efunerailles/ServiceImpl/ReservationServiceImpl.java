package tg.Ipnet.efunerailles.ServiceImpl;

import org.springframework.stereotype.Service;

import tg.Ipnet.efunerailles.Entity.Reservation;
import tg.Ipnet.efunerailles.Exceptions.ResourceNotFoundException;
import tg.Ipnet.efunerailles.Repository.ReservationRepository;
import tg.Ipnet.efunerailles.Service.ReservationService;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Long id, Reservation reservation) {
        Reservation existing = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation non trouvée avec id : " + id));
        
        existing.setDateDebut(reservation.getDateDebut());
        existing.setDateFin(reservation.getDateFin());
        existing.setTypeReservation(reservation.getTypeReservation());
        existing.setDefunt(reservation.getDefunt());
        existing.setCorbillard(reservation.getCorbillard());

        return reservationRepository.save(existing);
    }

    @Override
    public void deleteReservation(Long id) {
        Reservation existing = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation non trouvée avec id : " + id));
        reservationRepository.delete(existing);
    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation non trouvée avec id : " + id));
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}