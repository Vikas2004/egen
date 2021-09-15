DROP TABLE IF EXISTS public.last_export_date;

-- Table: public.last_export_date


CREATE TABLE IF NOT EXISTS public.last_export_date
(
    "latest_export_Date" date NOT NULL,
    id bigint NOT NULL
)

TABLESPACE pg_default;

ALTER TABLE public.last_export_date
    OWNER to postgres;



