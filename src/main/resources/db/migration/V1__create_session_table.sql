create schema if not exists autism_vr;

create table autism_vr.students
(
    id         uuid primary key,
    code       text      not null,
    name       text,
    created_at timestamp not null default now(),
    updated_at timestamp not null default now()
);


create table autism_vr.teach_sessions
(
    id         uuid primary key,
    student_id uuid references students (id),
    code       text,
    created_at timestamp not null default now(),
    updated_at timestamp not null default now()
);
