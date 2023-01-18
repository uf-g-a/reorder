CREATE TABLE IF NOT EXISTS public.employee
(
    employee_id bigserial NOT NULL ,
    name text COLLATE pg_catalog."default" NOT NULL,
    surname text COLLATE pg_catalog."default" NOT NULL,
    patronymic text COLLATE pg_catalog."default",
    age integer NOT NULL,
    sex boolean NOT NULL,
    employment_date date NOT NULL,
    CONSTRAINT employee_pkey PRIMARY KEY (employee_id)
);

CREATE TABLE IF NOT EXISTS public.vacation_type
(
    type_id bigserial NOT NULL ,
    type_name text COLLATE pg_catalog."default" NOT NULL,
    min_vacation_len integer,
    max_vacation_len integer,
    CONSTRAINT vacation_type_pkey PRIMARY KEY (type_id)
);

CREATE TABLE IF NOT EXISTS public.vacation_list
(
    id bigserial NOT NULL ,
    type_id bigint NOT NULL,
    employee_id bigint NOT NULL,
    date_begin date NOT NULL,
    date_end date NOT NULL,
    vacation_remains integer NOT NULL,
    CONSTRAINT vacation_list_pkey PRIMARY KEY (id),
    CONSTRAINT employee FOREIGN KEY (employee_id)
        REFERENCES public.employee (employee_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT type FOREIGN KEY (type_id)
        REFERENCES public.vacation_type (type_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


insert into employee(surname, name, patronymic, age, sex, employment_date)
values 
('Осипов', 'Лев', 'Александрович',
 32, true, '2022-03-25' 
),
('Носков', 'Василий', 'Георгиевич',
 35, true, '2021-02-03' 
),
('Смирнова', 'Алёна', 'Дмитриевна',
 34, false, '2022-06-13' 
),
('Елисеева', 'Валерия', 'Александровна',
 32, false, '2020-11-07' 
),
('Титов', 'Роберт', 'Кириллович',
 25, true, '2022-08-23' 
),
('Зайцев', 'Максим', 'Павлович',
 40, true, '2018-04-11' 
);

insert into vacation_type 
(type_name, min_vacation_len, max_vacation_len)
values
('Отпуск', null, null),
('Сессионный отпуск', null, 40),
('Декрет', 140, null);