package checkIn;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class PostAuthUserPojo {
    String email;
    String password;
    String name;

}
