-- create the configurations table
create table autism_vr.configurations
(
    id                 uuid primary key,
    teach_session_id   uuid
        references teach_sessions (id),
    name               varchar(255) not null,
    type               varchar(255) not null,
    description        varchar(255),
    default_value_int  integer,
    value_int          integer,
    default_value_bool boolean,
    value_bool         boolean
);