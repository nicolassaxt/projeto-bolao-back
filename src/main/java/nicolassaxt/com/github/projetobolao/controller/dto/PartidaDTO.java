package nicolassaxt.com.github.projetobolao.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import nicolassaxt.com.github.projetobolao.model.StatusPartida;
import nicolassaxt.com.github.projetobolao.model.Time;


import java.time.LocalDateTime;

public class PartidaDTO {

    private String id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataPartida;
    private StatusPartida status;
    private String imgUrlPartida;

    private Time timeAId;

    private Time timeBId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
