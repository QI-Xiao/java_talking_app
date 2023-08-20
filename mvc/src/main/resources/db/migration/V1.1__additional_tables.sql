CREATE TABLE user_relations (
    id          BIGSERIAL NOT NULL,
    user1_id    BIGINT NOT NULL,
    user2_id    BIGINT NOT NULL,
    type        INT DEFAULT 0 NOT NULL,
    register_date   date default CURRENT_DATE
);

ALTER TABLE user_relations ADD CONSTRAINT user_relations_pk PRIMARY KEY ( id );

ALTER TABLE user_relations
    ADD CONSTRAINT user1_fk FOREIGN KEY ( user1_id )
        REFERENCES users ( id );

ALTER TABLE user_relations
    ADD CONSTRAINT user2_fk FOREIGN KEY ( user2_id )
        REFERENCES users ( id );


CREATE TABLE messages (
    id          BIGSERIAL NOT NULL,
    user_id         BIGINT NOT NULL,
    receiver_id     BIGINT,
    room_id         BIGINT,
    is_room_chat    BOOLEAN not null default FALSE,
    message     VARCHAR(150),
    time        date default CURRENT_DATE
);

ALTER TABLE messages ADD CONSTRAINT messages_pk PRIMARY KEY ( id );

ALTER TABLE messages
    ADD CONSTRAINT user_fk FOREIGN KEY ( user_id )
        REFERENCES users ( id );

ALTER TABLE messages
    ADD CONSTRAINT receiver_fk FOREIGN KEY ( receiver_id )
        REFERENCES users ( id );

ALTER TABLE messages
    ADD CONSTRAINT room_fk FOREIGN KEY ( room_id )
        REFERENCES rooms ( id );
