-- users
INSERT INTO users (id, first_name, last_name, nickname)
VALUES (1, 'Hrvoje', 'Horvatovic', 'HH')
on CONFLICT (id) DO NOTHING;

INSERT INTO users (id, first_name, last_name, nickname)
VALUES (2, 'Marko', 'Markovic', 'MM')
on CONFLICT (id) DO NOTHING;

-- category
INSERT INTO category (id, category)
VALUES (1, 'Grocery')
on CONFLICT (id) DO NOTHING;

INSERT INTO category (id, category)
VALUES (2, 'Credit')
on CONFLICT (id) DO NOTHING;

INSERT INTO category (id, category)
VALUES (3, 'Food')
on CONFLICT (id) DO NOTHING;

INSERT INTO category (id, category)
VALUES (4, 'Other')
on CONFLICT (id) DO NOTHING;

INSERT INTO category (id, category)
VALUES (5, 'Gas')
on CONFLICT (id) DO NOTHING;


-- mappingCategory
INSERT INTO mapping_category (id, mapper, category_id)
VALUES (5, 'PBZTINA', 5)
on CONFLICT (id) DO NOTHING;


-- spending
INSERT INTO spending (id, amount, date, user_id, mapper_id)
VALUES (1, -300, to_date('17/04/2021', 'DD/MM/YYYY'), 1, 5)
on CONFLICT (id) DO NOTHING;


