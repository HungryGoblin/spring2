create table "productCategory"
(
    id          serial not null
        constraint productcategory_pk
            primary key,
    name        char   not null,
    description char
);

alter table "productCategory"
    owner to postgres;

create table "userWallet"
(
    id      serial not null
        constraint userwallet_pk
            primary key,
    balance integer
);

alter table "userWallet"
    owner to postgres;

create table "user"
(
    id             serial not null
        constraint user_pk
            primary key,
    name           char   not null,
    email          char,
    pass           char,
    "userWalletId" integer
        constraint user_userwallet_id_fk
            references "userWallet"
);

alter table "user"
    owner to postgres;

create table "order"
(
    id          serial  not null
        constraint order_pk
            primary key,
    "orderDate" date,
    "userId"    integer not null
        constraint order_user_id_fk
            references "user"
);

alter table "order"
    owner to postgres;

create table brand
(
    id          serial not null
        constraint brand_pk
            primary key,
    name        char   not null,
    description char
);

alter table brand
    owner to postgres;

create table product
(
    id                  serial  not null
        constraint product_pk
            primary key,
    name                char    not null,
    description         char,
    "brandId"           integer not null
        constraint product_brand_id_fk
            references brand,
    "productCategoryId" integer not null
        constraint product_productcategory_id_fk
            references "productCategory"
);

alter table product
    owner to postgres;

create table "productItem"
(
    id                serial  not null
        constraint productitem_pk
            primary key,
    "productStatusId" integer,
    description       char,
    "orderId"         integer not null
        constraint productitem_order_id_fk
            references "order",
    "productId"       integer not null
        constraint productitem_product_id_fk
            references product
);

alter table "productItem"
    owner to postgres;

create table "productReview"
(
    id          serial  not null
        constraint productreview_pk
            primary key,
    name        char    not null,
    description char,
    "productId" integer not null
        constraint productreview_product_id_fk
            references product
);

alter table "productReview"
    owner to postgres;

