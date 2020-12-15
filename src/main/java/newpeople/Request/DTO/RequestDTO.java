package newpeople.Request.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RequestDTO {

    private Integer id;
    private Integer age;
    private String phone;
    private String attendance;
    private String name;
    private String statusClaim;
    private String comment;
    private Date created;
    private Date updated;
    private String updater;

    @Override
    public String toString() {
        return "{\"id\": \"" + id + "\", "
                + "\"age\": \"" + age + "\", "
                + "\"phone\": \"" + phone + "\", "
                + "\"attendance\": \"" + attendance + "\", "
                + "\"name\": \"" + name + "\", "
                + "\"statusClaim\": \"" + statusClaim + "\", "
                + "\"created\": \"" + created.toString() + "\", "
                + "\"updated\": \"" + updated.toString() + "\", "
                + "\"updater\": \"" + updater + "\", "
                + "\"comment\": \"" + comment + "\"}";
    }
}
