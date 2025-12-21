package DuAn2.Common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Đăng ký Encoder dưới dạng Spring Bean — thực tế dùng Decorator pattern.
 * Bean này sẽ được inject vào controller/service cần encode.
 */
@Configuration
public class EncoderConfig {

    @Bean
    public Encoder encoder() {
        // Base encoder = Base64; Decorator thêm logging
        return new LoggingEncoderDecorator(new Base64Encoder());
    }
}
