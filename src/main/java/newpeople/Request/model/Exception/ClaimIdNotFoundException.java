package newpeople.Request.model.Exception;

import lombok.NonNull;

public class ClaimIdNotFoundException extends RuntimeException {
    public ClaimIdNotFoundException(@NonNull Integer id) {
        super("Claim for id = " + id + " not found.");
    }
}
