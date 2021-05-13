package newpeople.Request.controller;

import newpeople.Request.DTO.RequestDTO;
import newpeople.Request.model.Exception.ClaimIdNotFoundException;
import newpeople.Request.model.StatusClaim;
import newpeople.Request.api.service.RequestService;
import newpeople.Request.utils.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/request")
public class RequestController {

    final
    RequestService service;

    @Autowired
    public RequestController(RequestService service)
    {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> saveRequest(@RequestBody RequestDTO request) {
        //todo добавить проверки на входные данные по безопасности
        RequestDTO res = service.save(request);
        return new ResponseEntity(res, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Void> updateStatusClaim(@RequestBody RequestDTO request){
        //todo добавить проверки на входные данные по безопасности
        try {
            service.update(request.getId(), StatusClaim.valueOf(request.getStatusClaim()));
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (ClaimIdNotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Void> getClaims(){
        List<RequestDTO> requests = service.getAllUnprocessedRequests();
        return new ResponseEntity(requests, HttpStatus.OK);
    }

    @GetMapping(value = "/{count}")
    public ResponseEntity<Void> getClaims(@PathVariable Integer count){
        List<RequestDTO> requests = service.getUnprocessedRequests(count);
        return new ResponseEntity(requests, HttpStatus.OK);
    }
}
