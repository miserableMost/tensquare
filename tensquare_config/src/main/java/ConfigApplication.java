import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 李聪
 * @date 2020/2/19 17:01
 */
/*@EnableConfigServer不被识别*/
@SpringBootApplication

public class ConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class,args);
    }
}
