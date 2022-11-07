package nicolassaxt.com.github.projetobolao.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class PartidaDTO {

    private String id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataPartida;

    private String vitoriaTime1;

    private String vitoriaTime2;

    private String empate;

    private String imgUrlPartida;

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

    public String getVitoriaTime1() {
        return vitoriaTime1;
    }

    public void setVitoriaTime1(String vitoriaTime1) {
        this.vitoriaTime1 = vitoriaTime1;
    }

    public String getVitoriaTime2() {
        return vitoriaTime2;
    }

    public void setVitoriaTime2(String vitoriaTime2) {
        this.vitoriaTime2 = vitoriaTime2;
    }

    public String getEmpate() {
        return empate;
    }

    public void setEmpate(String empate) {
        this.empate = empate;
    }

    public String getImgUrlPartida() {
        return imgUrlPartida;
    }

    public void setImgUrlPartida(String imgUrlPartida) {
        this.imgUrlPartida = imgUrlPartida;
    }
}
