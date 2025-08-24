package estudiantesapireconocimientofacialbackend.service.Impl;


import estudiantesapireconocimientofacialbackend.dto.EstudianteDTO;
import estudiantesapireconocimientofacialbackend.exception.NotFoundException;
import estudiantesapireconocimientofacialbackend.mapper.EstudianteMapper;
import estudiantesapireconocimientofacialbackend.model.Estudiante;
import estudiantesapireconocimientofacialbackend.repository.EstudianteRepository;
import estudiantesapireconocimientofacialbackend.service.EstudianteService;
import estudiantesapireconocimientofacialbackend.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository repository;
    private final EstudianteMapper estudianteMapper;
    private final SequenceGeneratorService sequenceGenerator;

    @Autowired
    public EstudianteServiceImpl(EstudianteRepository repository,
                                 EstudianteMapper estudianteMapper,
                                 SequenceGeneratorService sequenceGenerator) {
        this.repository = repository;
        this.estudianteMapper = estudianteMapper;
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public EstudianteDTO crear(EstudianteDTO dto) {
        Estudiante entity = estudianteMapper.toEntity(dto);

        // 👇 Generar ID entero autoincremental
        entity.setId(sequenceGenerator.generateSequence("estudiante_sequence"));

        Estudiante saved = repository.save(entity);
        return estudianteMapper.toDTO(saved);
    }

    @Override
    public EstudianteDTO obtenerPorId(Integer id) {
        Estudiante e = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Estudiante no encontrado con id: " + id));
        return estudianteMapper.toDTO(e);
    }

    @Override
    public List<EstudianteDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(estudianteMapper::toDTO)
                .toList();
    }

    @Override
    public EstudianteDTO actualizar(Integer id, EstudianteDTO dto) {
        Estudiante entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Estudiante no encontrado con id: " + id));

        entity.setEstudiante(dto.getEstudiante());
        entity.setCodigo(dto.getCodigo());
        entity.setEmail(dto.getEmail());
        entity.setProgramaTecnico(dto.getProgramaTecnico());
        entity.setHorario(dto.getHorario());
        entity.setEstado(dto.getEstado());

        Estudiante updated = repository.save(entity);
        return estudianteMapper.toDTO(updated);
    }

    @Override
    public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("No se puede eliminar. Estudiante no encontrado con id: " + id);
        }
        repository.deleteById(id);
    }
}