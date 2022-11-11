package nicolassaxt.com.github.projetobolao.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import nicolassaxt.com.github.projetobolao.controller.dto.ApostaDTO;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Aposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Partida partidaId;

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuarioId;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataAposta;
    @Enumerated(EnumType.STRING)
    private StatusAposta status = StatusAposta.ND;

    public Aposta(Partida partidaId, Usuario usuarioId, StatusAposta status) {
        this.partidaId = partidaId;
        this.usuarioId = usuarioId;
        this.status = status;
    }

    public Aposta(ApostaDTO dto, Usuario usuario, Partida partida){
        this.dataAposta = dto.getDataAposta();
        this.usuarioId = usuario;
        this.partidaId = partida;
        this.status = dto.getStatus();
    }

    public Aposta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusAposta getStatus() {
        return status;
    }

    public void setStatus(StatusAposta status) {
        this.status = status;
    }

    public Partida getPartidaId() {
        return partidaId;
    }

    public void setPartidaId(Partida partidaId) {
        this.partidaId = partidaId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public LocalDateTime getDataAposta() {
        return dataAposta;
    }

    public void setDataAposta(LocalDateTime dataAposta) {
        this.dataAposta = dataAposta;
    }
}
