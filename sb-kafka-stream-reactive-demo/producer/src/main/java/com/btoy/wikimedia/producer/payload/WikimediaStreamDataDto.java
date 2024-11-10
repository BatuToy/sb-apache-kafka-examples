package com.btoy.wikimedia.producer.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WikimediaStreamDataDto {
    private Long id;
    private Boolean bot;
    private String comment;
    private Boolean minor;
    private Integer namespace;
    private String notifyUrl;
    private String parsedComment;
    private Boolean patrolled;
    private String schema;
    private String serverName;
    private String serverScriptPath;
    private String serverUrl;
    private Long timestamp;
    private String title;
    private String titleUrl;
    private String type;
    private String user;
    private String wiki;
}
