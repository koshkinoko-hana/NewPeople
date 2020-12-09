package newpeople.Request.DTO;

import lombok.Getter;
import lombok.Setter;

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

    @Override
    public String toString() {
        return "{\"id\": \"" + id + "\", "
                + "\"age\": \"" + age + "\", "
                + "\"phone\": \"" + phone + "\", "
                + "\"attendance\": \"" + attendance + "\", "
                + "\"name\": \"" + name + "\", "
                + "\"statusClaim\": \"" + statusClaim + "\", "
                + "\"comment\": \"" + comment + "\"}";
    }
}
