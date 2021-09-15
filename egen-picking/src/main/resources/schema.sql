-- Drop table
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS public.item;
DROP TABLE IF EXISTS public."order";
DROP TABLE IF EXISTS public.picking;
DROP TABLE IF EXISTS public.bulk_pick;

-- Table: public.employee
CREATE TABLE IF NOT EXISTS public.employee
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name text COLLATE pg_catalog."default" NOT NULL,
    mail_id text COLLATE pg_catalog."default",
    phone text COLLATE pg_catalog."default",
    CONSTRAINT employee_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.employee
    OWNER to postgres;

-- Table: public.item
CREATE TABLE IF NOT EXISTS public.item
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    quantity integer,
    weight numeric,
    height numeric,
    width numeric,
    length numeric,
    name text COLLATE pg_catalog."default"
)

TABLESPACE pg_default;

ALTER TABLE public.item
    OWNER to postgres;

-- Table: public.order
CREATE TABLE IF NOT EXISTS public."order"
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    item_quantity integer NOT NULL,
    is_sub_allowed boolean,
    sub_item_id integer,
    item_id integer,
    CONSTRAINT order_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public."order"
    OWNER to postgres;

-- Table: public.picking
CREATE TABLE IF NOT EXISTS public.picking
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    bulk_id integer,
    date timestamp without time zone,
    emp_id integer,
    end_dt_tm timestamp without time zone,
    order_id integer,
    status integer,
    start_dt_tm timestamp without time zone,
    store character varying(255) COLLATE pg_catalog."default",
    type integer,
    warehouse_id integer,
    zone character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT picking_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.picking
    OWNER to postgres;

-- Table: public.bulk_pick

CREATE TABLE IF NOT EXISTS public.bulk_pick
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    order_ids text COLLATE pg_catalog."default" NOT NULL,
    warehouse_id integer NOT NULL,
    store text COLLATE pg_catalog."default" NOT NULL,
    zone text COLLATE pg_catalog."default" NOT NULL,
    emp_id integer NOT NULL,
    CONSTRAINT bulk_pick_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.bulk_pick
    OWNER to postgres;

-- Data

INSERT INTO public."employee"(name, mail_id, phone)
	VALUES ( 'person1', 'person1@gmail.com', '12345678'),
	( 'person2', 'person2@gmail.com', '12345678'),
	( 'person3', 'person3@gmail.com', '12345678'),
	( 'person4', 'person4@gmail.com', '12345678'),
	( 'person5', 'person5@gmail.com', '12345678'),
	( 'person6', 'person6@gmail.com', '12345678');


INSERT INTO public."order"(item_quantity, is_sub_allowed, item_id)
	VALUES (4, false, 4),
	(3, false, 5),
	(2, false, 6),
	(1, false, 6),
	(5, false, 4);

insert into item(quantity, weight, height, name)
values(4, 2, 3.1, 'watch'),
(3, 2, 3.1, 'powder'),
(2, 2, 3.1, 'clock'),
(7, 2, 3.1, 'remote'),
(25, 2, 3.1, 'desktop');