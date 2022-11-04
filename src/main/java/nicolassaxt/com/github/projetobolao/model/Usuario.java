package nicolassaxt.com.github.projetobolao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Usuario {

    @Id
    private String id;

    @Column(unique = true)
    private String user_name;

    @Column(unique = true)
    private String user_email;

    private String user_password;

    private String user_full_name;

    private LocalDateTime user_join_date;

    public Usuario(String id, String user_name, String user_email, String user_password, String user_full_name) {
        this.id = id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_full_name = user_full_name;
    }

    public Usuario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_full_name() {
        return user_full_name;
    }

    public void setUser_full_name(String user_full_name) {
        this.user_full_name = user_full_name;
    }

    public LocalDateTime getUser_join_date() {
        return user_join_date;
    }

    public void setUser_join_date(LocalDateTime user_join_date) {
        this.user_join_date = user_join_date;
    }
}
