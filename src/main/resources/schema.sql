create table if not exists hardwares(
                          id long generated always as identity,
                          name varchar(50) not null,
                          code varchar(50) not null,
                          price integer not null,
                          type varchar(50) not null,
                          count integer not null,
                          primary key (id)
);
create table if not exists reviews(
    review_id long generated always as identity,
    title varchar(50) not null,
    info varchar(50) not null,
    evaluation int not null,
    hardware_id long not null,
    primary key (review_id),
    foreign key (hardware_id) references hardwares(id)
);
create table if not exists user(
    id identity,
    username varchar(100) not null unique,
    password varchar(1000) not null
);
create table if not exists authority (
    id identity,
    authority_name varchar(100) not null unique
);
create table if not exists user_authority (
    user_id bigint not null,
    authority_id bigint not null,
    constraint fk_user foreign key (user_id) references user(id),
    constraint fk_authority foreign key (authority_id) references authority(id)
);