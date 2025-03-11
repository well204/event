CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE IF NOT EXISTS address(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    city VARCHAR(70) NOT NULL,
    uf VARCHAR(2) NOT NULL,
    event_id UUID NOT NULL,
    Foreign Key (event_id) REFERENCES event(id) ON DELETE CASCADE
);