package newpeople.Request.controller;

import newpeople.Request.DTO.RequestDTO;
import newpeople.Request.model.StatusClaim;
import newpeople.Request.service.RequestBotService;
import newpeople.Request.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/request")
public class RequestController {

    final
    RequestService service;
    final
    RequestBotService botService;

    @Autowired
    public RequestController(RequestService service, RequestBotService botService)
    {
        this.service = service;
        this.botService = botService;
    }

    @PostMapping
    public ResponseEntity<Void> saveRequest(@RequestBody RequestDTO request) {
        //todo добавить проверки на входные данные по безопасности
        botService.sendClaimToBot(service.save(request));
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Void> updateStatusClaim(@RequestBody RequestDTO request){
        //todo добавить проверки на входные данные по безопасности
        service.update(request.getId(), StatusClaim.valueOf(request.getStatusClaim()));
        return new ResponseEntity(HttpStatus.OK);
    }
}
