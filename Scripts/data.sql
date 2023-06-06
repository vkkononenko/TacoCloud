--Insert Ingredients
INSERT INTO public.ingredient (id, date_created, date_updated, name, type) VALUES (nextval('seq_ingredient'), '2023-05-29 12:35:35.825000', null, 'Flour Tortilla', 0);
INSERT INTO public.ingredient (id, date_created, date_updated, name, type) VALUES (nextval('seq_ingredient'), '2023-05-29 12:35:35.863000', null, 'Corn Tortilla', 0);
INSERT INTO public.ingredient (id, date_created, date_updated, name, type) VALUES (nextval('seq_ingredient'), '2023-05-29 12:35:35.865000', null, 'Cheddar', 3);
INSERT INTO public.ingredient (id, date_created, date_updated, name, type) VALUES (nextval('seq_ingredient'), '2023-05-29 12:35:35.867000', null, 'Gouda', 3);
INSERT INTO public.ingredient (id, date_created, date_updated, name, type) VALUES (nextval('seq_ingredient'), '2023-05-29 12:35:35.869000', null, 'Salsa', 4);
INSERT INTO public.ingredient (id, date_created, date_updated, name, type) VALUES (nextval('seq_ingredient'), '2023-05-29 12:35:35.871000', null, 'Sour Cream', 4);
INSERT INTO public.ingredient (id, date_created, date_updated, name, type) VALUES (nextval('seq_ingredient'), '2023-05-29 12:35:35.874000', null, 'Beef', 1);
INSERT INTO public.ingredient (id, date_created, date_updated, name, type) VALUES (nextval('seq_ingredient'), '2023-05-29 12:35:35.876000', null, 'Chicken', 1);
INSERT INTO public.ingredient (id, date_created, date_updated, name, type) VALUES (nextval('seq_ingredient'), '2023-05-29 12:35:35.874000', null, 'Sliced Tomatoes', 2);
INSERT INTO public.ingredient (id, date_created, date_updated, name, type) VALUES (nextval('seq_ingredient'), '2023-05-29 12:35:35.876000', null, 'Lettuce', 2);

--Insert users
INSERT INTO public.system_user (id, date_created, date_updated, login, password, role) VALUES (nextval('seq_system_user'), '2023-06-04 17:22:46.257000', null, 'konich', '$2a$10$uCPDWLtgnCPbe0GaPBoZWeb0FWrr.4GewbOmEcLXglxTiAYthXR1i', 'ROLE_USER');