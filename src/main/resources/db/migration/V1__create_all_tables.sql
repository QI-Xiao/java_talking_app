CREATE TABLE chatgroups (
                            id              BIGSERIAL NOT NULL,
                            name            VARCHAR(30),
                            notes           VARCHAR(150),
                            register_date   date default CURRENT_DATE,
                            last_active     date default CURRENT_DATE
);

ALTER TABLE chatgroups ADD CONSTRAINT chatgroup_pk PRIMARY KEY (id);

CREATE TABLE users (
                       id              BIGSERIAL NOT NULL,
                       nickname        VARCHAR(30) not null unique,
                       first_name      VARCHAR(30),
                       last_name       VARCHAR(30),
                       profile         VARCHAR(150),
                       email           VARCHAR(50),
                       address         VARCHAR(150),
                       register_date   date default CURRENT_DATE,
                       last_active     date default CURRENT_DATE
);

ALTER TABLE users ADD CONSTRAINT user_pk PRIMARY KEY ( id );

CREATE TABLE relations (
                           id             BIGSERIAL NOT NULL,
                           group_id       INTEGER NOT NULL,
                           user_id        INTEGER NOT NULL,
                           nickname       VARCHAR(30) not null,
                           join_date      date default CURRENT_DATE,
                           last_active    date default CURRENT_DATE
);

ALTER TABLE relations ADD CONSTRAINT relation_pk PRIMARY KEY ( id );

ALTER TABLE relations
    ADD CONSTRAINT relation_group_fk FOREIGN KEY ( group_id )
        REFERENCES chatgroups ( id );


ALTER TABLE relations
    ADD CONSTRAINT relation_user_fk FOREIGN KEY ( user_id )
        REFERENCES users ( id );