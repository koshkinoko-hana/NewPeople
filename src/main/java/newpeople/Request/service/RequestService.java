package newpeople.Request.service;

import newpeople.Request.DTO.RequestDTO;
import newpeople.Request.model.StatusClaim;

import java.util.List;

public interface RequestService {
    /*
        Сохранение заявки в таблице, возвращается "дозаполненная" с id и значениями по умолчанию
     */
    RequestDTO save(RequestDTO dto);
    /*
       Обновление в базе статуса заявки
     */
    void update(Integer id, StatusClaim statusClaim);
    /*
        Получение заявки по id
     */
    RequestDTO getRequest(Integer id);
    /*
        Получение всех не обработанных заявок
     */
    List<RequestDTO> getAllUnprocessedRequests();

}
