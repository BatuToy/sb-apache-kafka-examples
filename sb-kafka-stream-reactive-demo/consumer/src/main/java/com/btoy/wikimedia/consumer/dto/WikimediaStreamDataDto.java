package com.btoy.wikimedia.consumer.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Length;
import org.springframework.data.history.Revision;
import org.springframework.data.jpa.repository.Meta;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WikimediaStreamDataDto {
    private Long id;

    private String notifyUrl;

    private String parsedComment;

    private String serverName;

    private String titleUrl;

    private String serverScriptPath;

    private String serverUrl;

    private Boolean bot;

    private String comment;

    private Boolean minor;

    private Integer namespace;

    private String schema;

    private Long timestamp;

    private String title;

    private Boolean patrolled;

    private String type;

    private String wiki;


}
