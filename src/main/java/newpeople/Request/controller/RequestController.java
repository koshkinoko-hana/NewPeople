package newpeople.Request.controller;

import newpeople.Request.DTO.RequestDTO;
import newpeople.Request.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/request")
public class RequestController {

    final
    RequestService service;

    @Autowired
    public RequestController(RequestService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> saveRequest(@RequestBody RequestDTO request) {
        service.save(request);
        return new ResponseEntity(HttpStatus.OK);
    }
}
