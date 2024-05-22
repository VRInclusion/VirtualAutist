create table autism_vr.scenes
(
    id uuid primary key,
    name varchar(255) not null,
    local_id int not null,
    teach_session_id uuid not null references teach_sessions(id)
);

create table autism_vr.results
(
    id uuid primary key,
    results text not null,
    teach_session_id uuid not null references teach_sessions(id)
);
