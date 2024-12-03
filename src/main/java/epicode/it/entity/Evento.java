package epicode.it.entity;

import epicode.it.enums.TipoEvento;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "eventi")
@Data
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String titolo;

    @Column(nullable = false, name = "data_evento")
    private LocalDate dataEvento;

    @Column(nullable = false)
    private String descrizione;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "tipo_evento")
    private TipoEvento tipoEvento;







}
