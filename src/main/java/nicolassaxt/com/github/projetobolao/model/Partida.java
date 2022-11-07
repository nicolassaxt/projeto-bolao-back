package nicolassaxt.com.github.projetobolao.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Partida {
    @Id
    private String id;

    private LocalDateTime dataPartida;

    private String vitoriaTime1;

    private String vitoriaTime2;

    private String empate;

    private String imgUrlPartida;

    public Partida(LocalDateTime dataPartida, String vitoriaTime1, String vitoriaTime2, String empate, String imgUrlPartida) {
        this.dataPartida = dataPartida;
        this.vitoriaTime1 = vitoriaTime1;
        this.vitoriaTime2 = vitoriaTime2;
        this.empate = empate;
        this.imgUrlPartida = imgUrlPartida;
    }

    public Partida() {
    }

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
