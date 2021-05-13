package newpeople.Request.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity(name="requests")
public class Request {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private Integer age;
    private String phone;

//    @Enumerated(EnumType.STRING)
//    @MapKeyColumn(name = "attendance")
//    private Attendance attendance;
    private String name;
    @Enumerated(EnumType.STRING)
    @MapKeyColumn(name = "status_claim")
    private StatusClaim statusClaim;
    private String comment;
    private Date created;
    private Date updated;
    private String updater;

}
