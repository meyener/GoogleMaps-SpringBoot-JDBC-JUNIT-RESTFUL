CREATE TABLE IF NOT EXISTS restaurant (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    lat DOUBLE,
    lng DOUBLE,
    restaurant_id VARCHAR(255),
    name VARCHAR(255),
    types VARCHAR(255),
    vicinity VARCHAR(255),
    is_deleted BOOLEAN
    );
