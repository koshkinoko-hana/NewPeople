package newpeople.Request.api.mapper;

import newpeople.Request.DTO.RequestDTO;
import newpeople.Request.model.Attendance;
import newpeople.Request.model.Exception.UnExpectedEnumValueException;
import newpeople.Request.model.Request;
import newpeople.Request.model.StatusClaim;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RequestMapper {

    RequestMapper INSTANCE = Mappers.getMapper(RequestMapper.class);

    RequestDTO requestToRequestDTO(Request request);

    Request requestDTOToRequest(RequestDTO requestDTO);

//    default Attendance toEnumAttendance(String attendance) {
//        if (Attendance.FULL_TIME.name().equals(attendance)) {
//            return Attendance.FULL_TIME;
//        }
//        if (Attendance.PART_TIME.name().equals(attendance)) {
//            return Attendance.PART_TIME;
//        }
//        return Attendance.PART_TIME;
////        throw new UnExpectedEnumValueException("attendance");
//    }

    default StatusClaim toEnumStatus(String statusClaim) {
        if (statusClaim == null || StatusClaim.UNPROCESSED.name().equals(statusClaim)) {
            return StatusClaim.UNPROCESSED;
        }
        if (StatusClaim.PROCESSED.name().equals(statusClaim)) {
            return StatusClaim.PROCESSED;
        }
        throw new UnExpectedEnumValueException("statusClaim");
    }
}
