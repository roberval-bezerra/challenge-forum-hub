//ForumhubApplication
package com.josetsi.api.forumhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ForumhubApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ForumhubApplication.class);
        app.run(args);
    }
}
