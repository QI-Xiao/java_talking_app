CREATE TABLE rooms (
                            id              BIGSERIAL NOT NULL,
                            name            VARCHAR(30),
                            notes           VARCHAR(150),
                            register_date   date default CURRENT_DATE,
                            last_active     date default CURRENT_DATE
);

ALTER TABLE rooms ADD CONSTRAINT rooms_pk PRIMARY KEY (id);

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

CREATE TABLE users_rooms (
                           id             BIGSERIAL NOT NULL,
                           room_id       BIGINT NOT NULL,
                           user_id        BIGINT NOT NULL,
                           nickname       VARCHAR(30) not null,
                           role           VARCHAR(30),
                           join_date      date default CURRENT_DATE,
                           last_active    date default CURRENT_DATE
);

ALTER TABLE users_rooms ADD CONSTRAINT users_rooms_pk PRIMARY KEY ( id );

ALTER TABLE users_rooms
    ADD CONSTRAINT room_fk FOREIGN KEY ( room_id )
        REFERENCES rooms ( id );


ALTER TABLE users_rooms
    ADD CONSTRAINT user_fk FOREIGN KEY ( user_id )
        REFERENCES users ( id );