package nicolassaxt.com.github.projetobolao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeTime;

    private String imgUrlTime;

    private String grupo;

    public Time(String nomeTime, String imgUrlTime, String grupo) {
        this.nomeTime = nomeTime;
        this.imgUrlTime = imgUrlTime;
        this.grupo = grupo;
    }

    public Time() {
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

    public String getNomeTime() {
        return nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    public String getImgUrlTime() {
        return imgUrlTime;
    }

    public void setImgUrlTime(String imgUrlTime) {
        this.imgUrlTime = imgUrlTime;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}
