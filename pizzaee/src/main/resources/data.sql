insert into pizza (nom, base)
values
('Margherita', 'TOMATE'),
('Trois fromages', 'CREME'),
('Calzone', 'TOMATE');

insert into ingredient (nom)
values
('Emmenthal'),
('Fromage de chèvre'),
('Mozzarella'),
('Jambon'),
('Champignon');

insert into pizza_ingredient (pizza_id, ingredient_id)
values
(1, 3),
(2, 1),
(2, 2),
(2, 3),
(3, 4),
(3, 5);

