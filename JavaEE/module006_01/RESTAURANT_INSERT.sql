insert into positions values 
(1, 'Director'), 
(2, 'Chief cook'), 
(3, 'Cook'), 
(4, 'Waiter'), 
(5, 'Washer'), 
(6, 'Cleaner');

insert into employee values 
(1, 'Lysyy', 'Sergey', '1990-09-14', '0978883223', 6000.0, 3),
(2, 'Guralnik', 'Vladislav', '1991-12-04', '0635553669', 4000.0, 4),
(3, 'Tyurin', 'Aleksandr', '1978-09-05', '0677773524', 12000.0, 1),
(4, 'Zhdanov', 'Daniil', '1983-02-19', '0731113212', 10000.0, 2),
(5, 'Grigorash', 'Alina', '1995-06-05', '0979993366', 3500.0, 5),
(6, 'Strilchuk', 'Olena', '1993-12-26', '0932223212', 3000.0, 6);

insert into ingredients values 
(1, 'Mutton'),
(2, 'Adygei cheese'),
(3, 'Dried mint'),
(4, 'Breadcrumbs'),
(5, 'Bulb onions'),
(6, 'Vegetable oil'),
(7, 'Salt'),
(8, 'Ground black pepper'),
(9, 'Tomato');

insert into stock values (1, 1000), (2, 200), (3, 5), (4, 30), (5, 100), (6, 200), (7, 10), (8, 2), (9, 200);

insert into dishs values (1, 'Meatballs of lamb', 'Meat', 200.0, 500, 1);

insert into menu values (1, 'Kyufta-bozbash in Baku', 1);

insert into orders values (1, 1, '2016-05-31', 1, 4);

insert into prepared_dishs values (1, '2016-05-31', 1, 1, 2);