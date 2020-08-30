create table if not exists scrap
(
    key text
        constraint scrap_pk
        primary key,
    value text default null
);

