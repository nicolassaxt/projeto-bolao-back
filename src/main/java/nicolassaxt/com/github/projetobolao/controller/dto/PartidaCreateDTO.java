package nicolassaxt.com.github.projetobolao.controller.dto;


import java.time.LocalDateTime;

public class PartidaCreateDTO {


    private LocalDateTime dataPartida;

    //passar valor padrao
    private String vitoriaTime1;

    //passar valor padrao
    private String vitoriaTime2;

    //passar valor padrao
    private String empate;

    private String imgUrlPartida;

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
