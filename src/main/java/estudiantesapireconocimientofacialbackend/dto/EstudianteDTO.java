package estudiantesapireconocimientofacialbackend.dto;


import estudiantesapireconocimientofacialbackend.model.Estado;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EstudianteDTO {

    private Integer id; // 👈 ahora coincide con el modelo

    @NotBlank(message = "El nombre del estudiante es obligatorio")
    @Size(max = 120)
    private String estudiante;

    @NotBlank(message = "El código es obligatorio")
    @Size(max = 40)
    private String codigo;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Formato de email inválido")
    @Size(max = 120)
    private String email;

    @NotBlank(message = "El programa técnico es obligatorio")
    private String programaTecnico;

    @NotBlank(message = "El horario es obligatorio")
    private String horario;

    @NotNull(message = "El estado es obligatorio")
    private Estado estado; // 👈 Enum directamente

    public EstudianteDTO() { }

    // Getters & Setters
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

    public Estado getEstado() { return estado; }   // ✅ ahora devuelve Estado
    public void setEstado(Estado estado) { this.estado = estado; } // ✅ recibe Estado
}