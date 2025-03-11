CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE IF NOT EXISTS event(
    id UUID  DEFAULT gen_random_uuid() PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    description_ VARCHAR(500) NOT NULL,
    remote_ BOOLEAN NOT NULL,
    img_url     VARCHAR(200) NOT NULL,
    event_url VARCHAR(200) NOT NULL,
    date_ TIMESTAMP NOT NULL
);