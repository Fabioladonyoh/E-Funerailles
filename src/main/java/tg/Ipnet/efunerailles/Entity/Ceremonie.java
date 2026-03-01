package tg.Ipnet.efunerailles.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import tg.Ipnet.efunerailles.Utils.BaseEntity;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "ceremonies")
public class Ceremonie extends BaseEntity{

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotNull
	    @Column(nullable = false)
	    private LocalDate date;

	    @NotBlank
	    @Column(nullable = false, length = 150)
	    private String lieu;

	    @ManyToOne
	    @JoinColumn(name = "defunt_id", nullable = false)
	    private Defunt defunt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public Defunt getDefunt() {
		return defunt;
	}

	public void setDefunt(Defunt defunt) {
		this.defunt = defunt;
	}
    
    
}