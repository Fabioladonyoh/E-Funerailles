package tg.Ipnet.efunerailles.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tg.Ipnet.efunerailles.Entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
