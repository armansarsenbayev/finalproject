INSERT INTO t_category (category) VALUES
    ('Electronics'),
    ('Clothes'),
    ('Food');

INSERT INTO t_country (code, country) VALUES
    ('KZ', 'Kazakhstan'),
    ('US', 'USA'),
    ('JP', 'Japan');

INSERT INTO t_item (name, description, price, category_id) VALUES
    ('Phone', 'Smartphone', 200000, 1),
    ('T-Shirt', 'Cotton shirt', 8000, 2),
    ('Pizza', 'Italian pizza', 6000, 3);

INSERT INTO t_item_countries (item_id, country_id) VALUES
    (1, 1),
    (1, 2),
    (2, 3),
    (3, 1);
