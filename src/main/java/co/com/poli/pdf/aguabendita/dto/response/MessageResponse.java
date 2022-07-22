package co.com.poli.pdf.aguabendita.dto.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class MessageResponse {

    public HttpStatus status;
    public String message;
}
