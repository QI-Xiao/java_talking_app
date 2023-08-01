CREATE TABLE user_relations (
    id          BIGSERIAL NOT NULL,
    user1_id    BIGINT NOT NULL,
    user2_id    BIGINT NOT NULL,
    register_date   date default CURRENT_DATE
);

ALTER TABLE user_relations ADD CONSTRAINT user_relations_pk PRIMARY KEY ( id );

ALTER TABLE user_relations
    ADD CONSTRAINT user1_fk FOREIGN KEY ( user1_id )
        REFERENCES users ( id );

ALTER TABLE user_relations
    ADD CONSTRAINT user2_fk FOREIGN KEY ( user2_id )
        REFERENCES users ( id );


CREATE TABLE user_messages (
    id          BIGSERIAL NOT NULL,
    message     VARCHAR(150),
    time        date default CURRENT_DATE,
    user_relation_id        BIGINT NOT NULL,
    is_use1_send      Boolean DEFAULT TRUE
);

ALTER TABLE user_messages ADD CONSTRAINT user_messages_pk PRIMARY KEY ( id );

ALTER TABLE user_messages
    ADD CONSTRAINT user_relation_fk FOREIGN KEY ( user_relation_id )
        REFERENCES user_relations ( id );


CREATE TABLE room_messages (
    id          BIGSERIAL NOT NULL,
    room_id    BIGINT NOT NULL,
    time        date default CURRENT_DATE,
    user_id     BIGINT NOT NULL,
    message     VARCHAR(150)
);

ALTER TABLE room_messages ADD CONSTRAINT room_messages_pk PRIMARY KEY ( id );

ALTER TABLE room_messages
    ADD CONSTRAINT room_fk FOREIGN KEY ( room_id )
        REFERENCES rooms ( id );

ALTER TABLE room_messages
    ADD CONSTRAINT user_fk FOREIGN KEY ( user_id )
        REFERENCES users ( id );
