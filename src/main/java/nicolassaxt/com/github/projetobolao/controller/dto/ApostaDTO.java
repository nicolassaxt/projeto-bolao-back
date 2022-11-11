package nicolassaxt.com.github.projetobolao.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import nicolassaxt.com.github.projetobolao.model.Partida;
import nicolassaxt.com.github.projetobolao.model.StatusAposta;
import nicolassaxt.com.github.projetobolao.model.Usuario;

import java.time.LocalDateTime;

public class ApostaDTO {

    private Long id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataAposta;
    private StatusAposta status;

    private Long partidaId;

    private Long usuarioId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataAposta() {
        return dataAposta;
    }

    public void setDataAposta(LocalDateTime dataAposta) {
        this.dataAposta = dataAposta;
    }

    public StatusAposta getStatus() {
        return status;
    }

    public void setStatus(StatusAposta status) {
        this.status = status;
    }

    public Long getPartidaId() {
        return partidaId;
    }

    public void setPartidaId(Long partidaId) {
        this.partidaId = partidaId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
