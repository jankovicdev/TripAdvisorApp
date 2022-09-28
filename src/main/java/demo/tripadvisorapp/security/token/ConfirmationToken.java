package demo.tripadvisorapp.security.token;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

public class ConfirmationToken {

    @Id
    private String id;
    private String token;
    private LocalDateTime createdAt;
    private LocalDateTime expiredAt;
    private LocalDateTime confirmedAt;

    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiredAt, LocalDateTime confirmedAt) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
        this.confirmedAt = confirmedAt;
    }
}
