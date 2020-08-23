create table blog_post (
    id char(36) primary key,
    title varchar(255) not null,
    summary text not null,
    content text not null,
    date_time timestamp not null
)