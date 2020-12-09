package newpeople.Request.serviceimpl;

import newpeople.Request.DTO.RequestDTO;
import newpeople.Request.mapper.RequestMapper;
import newpeople.Request.model.Request;
import newpeople.Request.model.StatusClaim;
import newpeople.Request.repository.RequestRepository;
import newpeople.Request.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public RequestDTO save(RequestDTO dto) {
       Request model = mapper.requestDTOToRequest(dto);
       return mapper.requestToRequestDTO(repository.save(model));

    }

    @Override
    public void update(Integer id,  StatusClaim statusClaim) {
        repository.findById(id).ifPresent(a ->{a.setStatusClaim(statusClaim);
        repository.save(a);});
    }

    @Override
    public RequestDTO getRequest(Integer id) {
        return mapper.requestToRequestDTO(repository.findById(id).orElseThrow(()-> new RuntimeException("Не найдена заявка с id = " + id)));
    }

    @Override
    public List<RequestDTO> getAllUnprocessedRequests() {
        List result = new ArrayList<>();
        repository.findAll().forEach(request ->
        {if (request.getStatusClaim() == StatusClaim.UNPROCESSED)
                    {result.add(mapper.requestToRequestDTO(request));}});
        return result;
    }
}
