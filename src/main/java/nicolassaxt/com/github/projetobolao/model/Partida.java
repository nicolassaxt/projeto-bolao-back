package nicolassaxt.com.github.projetobolao.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import nicolassaxt.com.github.projetobolao.controller.dto.PartidaCreateDTO;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "timeaid_id",nullable = false, insertable = true, updatable = false)
    private Time timeAId;

    @ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "timebid_id",nullable = false, insertable = true, updatable = false)
    private Time timeBId;

    @DateTimeFormat(style= "dd-MM-yyyy HH:mm")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern= "dd-MM-yyyy HH:mm")
    private LocalDateTime dataPartida;

    @Enumerated(EnumType.STRING)
    private StatusPartida status = StatusPartida.ND;

    private String imgUrlPartida;


    public Partida(LocalDateTime dataPartida, StatusPartida status, String imgUrlPartida) {
        this.dataPartida = dataPartida;
        this.status = status;
        this.imgUrlPartida = imgUrlPartida;
    }

    public Partida(Time timeAId, Time timeBId, LocalDateTime dataPartida, StatusPartida status, String imgUrlPartida) {
        this.timeAId = timeAId;
        this.timeBId = timeBId;
        this.dataPartida = dataPartida;
        this.status = status;
        this.imgUrlPartida = imgUrlPartida;
    }
    public Partida(PartidaCreateDTO partidaDto , LocalDateTime dataPartida, Time timeAId, Time timeBId) {
        this.timeAId = timeAId;
        this.timeBId = timeBId;
        this.dataPartida = dataPartida;
        this.status = partidaDto.getStatus();
        this.imgUrlPartida = partidaDto.getImgUrlPartida();
    }

    public Partida() {
    }

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(LocalDateTime dataPartida) {
        this.dataPartida = dataPartida;
    }

    public StatusPartida getStatus() {
        return status;
    }

    public void setStatus(StatusPartida status) {
        this.status = status;
    }

    public String getImgUrlPartida() {
        return imgUrlPartida;
    }

    public void setImgUrlPartida(String imgUrlPartida) {
        this.imgUrlPartida = imgUrlPartida;
    }

    public Time getTimeAId() {
        return timeAId;
    }

    public void setTimeAId(Time timeAId) {
        this.timeAId = timeAId;
    }

    public Time getTimeBId() {
        return timeBId;
    }

    public void setTimeBId(Time timeBId) {
        this.timeBId = timeBId;
    }
}
