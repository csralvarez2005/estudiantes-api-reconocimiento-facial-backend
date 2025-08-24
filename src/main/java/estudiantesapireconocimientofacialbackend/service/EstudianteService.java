package estudiantesapireconocimientofacialbackend.service;

import estudiantesapireconocimientofacialbackend.dto.EstudianteDTO;

import java.util.List;

public interface EstudianteService {
    EstudianteDTO crear(EstudianteDTO dto);
    EstudianteDTO obtenerPorId(Integer id);   // 👈 Cambiado a Integer
    List<EstudianteDTO> listarTodos();
    EstudianteDTO actualizar(Integer id, EstudianteDTO dto);  // 👈 Cambiado a Integer
    void eliminar(Integer id);  // 👈 Cambiado a Integer
}
