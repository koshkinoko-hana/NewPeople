package newpeople.Request.serviceimpl;

import newpeople.Request.DTO.RequestDTO;
import newpeople.Request.api.mapper.RequestMapper;
import newpeople.Request.model.Exception.ClaimIdNotFoundException;
import newpeople.Request.model.Request;
import newpeople.Request.model.StatusClaim;
import newpeople.Request.repository.RequestRepository;
import newpeople.Request.api.service.RequestService;
import newpeople.Request.utils.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
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
    public void update(Integer id, StatusClaim statusClaim) {
            repository.findById(id).map(a -> {
                a.setStatusClaim(statusClaim);
                a.setUpdated(new Date());
                a.setUpdater("anonymous");
                return repository.save(a);}).orElseThrow( () -> new ClaimIdNotFoundException(id));

    }

    @Override
    public RequestDTO getRequest(Integer id) {
        return mapper.requestToRequestDTO(repository.findById(id).orElseThrow(() -> new ClaimIdNotFoundException(id)));
    }

    @Override
    public List<RequestDTO> getAllUnprocessedRequests() {
        List<RequestDTO> result = new ArrayList<>();
        repository.findAll().forEach(request ->
        {
            if (request.getStatusClaim() == StatusClaim.UNPROCESSED) {
                result.add(mapper.requestToRequestDTO(request));
            }
        });
        return result;
    }

    @Override
    public HttpStatus sendToBotService() {
        RestTemplate restTemplate = new RestTemplate();

        return HttpStatus.OK ;// restTemplate.getForObject(ServiceUtils.getProperty(), HttpStatus.class);

    }

}