
CREATE TABLE IF NOT EXISTS coupon (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    dicount INTEGER NOT NULL,
    code VARCHAR(50) UNIQUE NOT NULL,
    valid TIMESTAMP NOT NULL,
    event_id UUID NOT NULL,
    FOREIGN KEY (event_id) REFERENCES event(id) ON DELETE CASCADE
);