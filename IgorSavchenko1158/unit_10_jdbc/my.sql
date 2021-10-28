select * from locations;

select * from routes;

select * from problems;

select * from solutions;

select l.name, l2.name, r.cost from locations l inner join routes r on l.location_id=r.to_id inner join locations l2 on l2.location_id=r.from_id;

insert into locations (name)
values ('Gdansk'),
('Bydgoszcz'),
('Torun'),
('Warszawa');

insert into routes (to_id, from_id, cost)
values ((select location_id from locations where name='Gdansk'), (select location_id from locations where name='Bydgoszcz'), 1),
((select location_id from locations where name='Gdansk'), (select location_id from locations where name='Torun'), 3),
((select location_id from locations where name='Bydgoszcz'), (select location_id from locations where name='Torun'), 1),
((select location_id from locations where name='Bydgoszcz'), (select location_id from locations where name='Warszawa'), 4),
((select location_id from locations where name='Torun'), (select location_id from locations where name='Warszawa'), 1);

insert into problems (to_id, from_id)
values ((select location_id from locations where name='Gdansk'), (select location_id from locations where name='Warszawa')),
((select location_id from locations where name='Bydgoszcz'), (select location_id from locations where name='Warszawa'));