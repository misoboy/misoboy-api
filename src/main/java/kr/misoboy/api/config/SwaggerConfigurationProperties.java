package kr.misoboy.api.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import springfox.documentation.service.TokenEndpoint;
import springfox.documentation.service.TokenRequestEndpoint;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "swagger")
public class SwaggerConfigurationProperties {
    private boolean enabled;
    private String includePatterns = "";
    private String title = "API";
    private String description = "API documentation";
    private String version = "0.0.1";
    private String termsOfServiceUrl;
    private String contactName;
    private String contactUrl;
    private String contactEmail;
    private String license;
    private String licenseUrl;
    private boolean enableTryOutMethods;
    private Security security;
    private Protocol protocol;

    @Data
    public static class ClientCredentialsFlow { // aka application
        private String tokenEndpointUrl;
        private String clientSecret;
        private String clientId;
    }

    @Data
    public static class ResourceOwnerPasswordFlow { // aka password
        private String tokenEndpointUrl;
        private String clientSecret;
        private String clientId;
    }

    @Data
    public static class AuthorizationCodeFlow { // aka accessCode
        private TokenEndpoint tokenEndpoint;
        private TokenRequestEndpoint tokenRequestEndpoint;
    }

    @Data
    public static class ImplicitFlow { // aka implicit
        private String authorizationEndpointUrl;
        private String clientSecret = "LEFT_EMPTY_INTENTIONALLY";
        private String clientId;
    }

    @Data
    public static class Security {
        private boolean enabled = Boolean.FALSE;
        private String realm = "/";
        private String apiName = "api-documentations";
        private String apiKey = "api-documentations-key";
        private List<Scope> globalScopes;
        private String flow = "implicit";
        private ClientCredentialsFlow clientCredentialsFlow;
        private ResourceOwnerPasswordFlow resourceOwnerPasswordFlow;
        private AuthorizationCodeFlow authorizationCodeFlow;
        private ImplicitFlow implicitFlow;
    }

    @Data
    public static class Scope {
        private String name;
        private String description;
    }

    @Data
    public static class Protocol {
        private boolean httpOnly = false;
    }
}
