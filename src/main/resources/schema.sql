create table if not exists photos (
    id bigint GENERATED ALWAYS AS IDENTITY  primary key,
    file_name varchar(255),
    content_type varchar(255),
    description varchar(255),
    raw_data bytea
);