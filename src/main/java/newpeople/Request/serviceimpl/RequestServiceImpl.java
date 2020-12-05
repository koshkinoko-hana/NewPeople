package newpeople.Request.serviceimpl;

import newpeople.Request.DTO.RequestDTO;
import newpeople.Request.mapper.RequestMapper;
import newpeople.Request.model.Request;
import newpeople.Request.repository.RequestRepository;
import newpeople.Request.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {

    final RequestRepository repository;
    final RequestMapper mapper;

    @Autowired
    RequestServiceImpl(RequestRepository repository, RequestMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void save(RequestDTO dto) {
        Request model = mapper.requestDTOToRequest(dto);
        repository.save(model);
    }
}
