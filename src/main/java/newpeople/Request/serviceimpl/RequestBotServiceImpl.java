package newpeople.Request.serviceimpl;

import newpeople.Request.DTO.RequestDTO;
import newpeople.Request.service.RequestBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestBotServiceImpl implements RequestBotService {

    @Autowired
    RequestBotServiceImpl() {

    }
    @Override
    public void sendClaimToBot(RequestDTO request) {
        // todo хочу здесь дергать как-то бота и пихать ему данные из DTO
        System.out.println(request.toString());

    }

}
