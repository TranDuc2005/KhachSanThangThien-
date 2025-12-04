package DuAn2;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class KhachSanThangThienApplication extends SpringBootServletInitializer {

	@PostConstruct
    public void init(){
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+7"));   // It will set UTC timezone
    }
	
	public static void main(String[] args) {
		SpringApplication.run(KhachSanThangThienApplication.class, args);
	}
}
