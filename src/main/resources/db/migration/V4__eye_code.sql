create table autism_vr.eye_code
(
    id uuid primary key,
    local_id text,
    answer text,
    teach_session_id uuid not null references teach_sessions(id)
);
