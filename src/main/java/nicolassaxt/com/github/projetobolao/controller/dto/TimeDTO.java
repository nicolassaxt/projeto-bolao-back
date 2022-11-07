package nicolassaxt.com.github.projetobolao.controller.dto;

public class TimeDTO {

    private String id;

    private String nomeTime;

    private String imgUrlTime;

    private String grupo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getNomeTime() {
        return nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }
}
