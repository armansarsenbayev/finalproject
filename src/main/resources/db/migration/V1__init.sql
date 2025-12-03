CREATE TABLE t_category (
    category_id BIGSERIAL PRIMARY KEY,
    category VARCHAR(255) NOT NULL
);


CREATE TABLE t_country (
    id BIGSERIAL PRIMARY KEY,
    country VARCHAR(255) NOT NULL,
    code VARCHAR(10) NOT NULL
    );

CREATE TABLE t_item (
        id BIGSERIAL PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        description VARCHAR(255),
        price INTEGER NOT NULL,
        category_id BIGINT,
        CONSTRAINT fk_item_category
        FOREIGN KEY (category_id) REFERENCES t_category(category_id)
);

CREATE TABLE t_item_countries (
    item_id BIGINT NOT NULL,
    countries_id BIGINT NOT NULL,
    PRIMARY KEY (item_id, countries_id),
    CONSTRAINT fk_item_country_item
    FOREIGN KEY (item_id) REFERENCES t_item(id),
    CONSTRAINT fk_item_country_country
    FOREIGN KEY (countries_id) REFERENCES t_country(id
);