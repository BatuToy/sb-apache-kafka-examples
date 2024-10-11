package com.btoy.wikimedia.consumer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_stream")
public class WikimediaStreamData {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "NOTIFY_URL")
        private String notifyUrl;

        @Column(name = "PARSED_COMMENT")
        private String parsedComment;

        @Column(name = "SERVER_NAME")
        private String serverName;

        @Column(name = "TITLE_URL")
        private String titleUrl;

        @Column(name = "SERVER_SCRIPT_PATH")
        private String serverScriptPath;

        @Column(name = "SERVER_URL")
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



