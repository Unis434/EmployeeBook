package SpringBoot.EmployeeBook.Configuration;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("app.info")
public class AppInfo {
    private String title;
    private String description;
    private String version;
    private String contactEmail;
    private String contactName;
    private String contactUrl;

}


