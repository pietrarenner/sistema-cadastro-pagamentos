package pietra.apigateway;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/fallback")
public class FallbackController {
    @GetMapping("/currency-conversion")
    public ResponseEntity<String> currencyConversionFallback() {
        return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("Serviços temporariamente indisponíveis. Tente novamente.");
    }
}

