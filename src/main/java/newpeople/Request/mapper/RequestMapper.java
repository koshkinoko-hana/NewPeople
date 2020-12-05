package newpeople.Request.mapper;

import newpeople.Request.DTO.RequestDTO;
import newpeople.Request.model.Attendance;
import newpeople.Request.model.Request;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RequestMapper {

    RequestMapper INSTANCE = Mappers.getMapper(RequestMapper.class);

    RequestDTO requestToRequestDTO(Request request);

    Request requestDTOToRequest(RequestDTO requestDTO);


    default Attendance toEnum(String attendance) {
        if(attendance.equals(Attendance.FULL_TIME.name())) {
            return Attendance.FULL_TIME;
        }
        if(attendance.equals(Attendance.PART_TIME.name())) {
            return Attendance.PART_TIME;
        }
        throw new RuntimeException("cannot recognize attenddance value");
    }
}
