CREATE TABLE t_category (
    category_id BIGSERIAL PRIMARY KEY,
    category VARCHAR(255) NOT NULL
);

CREATE TABLE t_country (
    id BIGSERIAL PRIMARY KEY,
    code VARCHAR(10) NOT NULL,
    country VARCHAR(255) NOT NULL
);

CREATE TABLE t_item (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    price INTEGER,
    category_id BIGINT,
    CONSTRAINT fk_item_category
    FOREIGN KEY (category_id)
    REFERENCES t_category(category_id)
);

CREATE TABLE t_item_countries (
    item_id BIGINT NOT NULL,
    country_id BIGINT NOT NULL,
    PRIMARY KEY (item_id, country_id),
    CONSTRAINT fk_item
        FOREIGN KEY (item_id)
        REFERENCES t_item(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_country
        FOREIGN KEY (country_id)
        REFERENCES t_country(id)
        ON DELETE CASCADE
);
