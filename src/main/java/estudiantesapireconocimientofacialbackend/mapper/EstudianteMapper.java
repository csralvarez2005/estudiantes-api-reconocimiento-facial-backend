package estudiantesapireconocimientofacialbackend.mapper;


import estudiantesapireconocimientofacialbackend.dto.EstudianteDTO;
import estudiantesapireconocimientofacialbackend.model.Estudiante;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring") // permite inyectarlo como @Autowired
public interface EstudianteMapper {

    EstudianteMapper INSTANCE = Mappers.getMapper(EstudianteMapper.class);

    Estudiante toEntity(EstudianteDTO dto);

    EstudianteDTO toDTO(Estudiante entity);
}
