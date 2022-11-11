package nicolassaxt.com.github.projetobolao.controller.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import nicolassaxt.com.github.projetobolao.model.StatusPartida;
import nicolassaxt.com.github.projetobolao.model.Time;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class PartidaCreateDTO {


    private String dataPartida;

    //passar valor padrao
    private StatusPartida status;

    private String imgUrlPartida;

    private Long timeAId;

    private Long timeBId;

//    public LocalDateTime getDataPartida() {
//        return dataPartida;
//    }
//
//    public void setDataPartida(LocalDateTime dataPartida) {
//        this.dataPartida = dataPartida;
//    }


    public String getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(String dataPartida) {
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

    public Long getTimeAId() {
        return timeAId;
    }

    public void setTimeAId(Long timeAId) {
        this.timeAId = timeAId;
    }

    public Long getTimeBId() {
        return timeBId;
    }

    public void setTimeBId(Long timeBId) {
        this.timeBId = timeBId;
    }
}
