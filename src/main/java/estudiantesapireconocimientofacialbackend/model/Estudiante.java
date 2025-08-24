package estudiantesapireconocimientofacialbackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "estudiantes")
public class Estudiante {

    @Id
    private Integer id;  // 👈 ID entero autoincremental

    private String estudiante;
    private String codigo;
    private String email;
    private String programaTecnico;
    private String horario;
    private Estado estado;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getEstudiante() { return estudiante; }
    public void setEstudiante(String estudiante) { this.estudiante = estudiante; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getProgramaTecnico() { return programaTecnico; }
    public void setProgramaTecnico(String programaTecnico) { this.programaTecnico = programaTecnico; }

    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}