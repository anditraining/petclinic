DROP TABLE appointment IF EXISTS;

CREATE TABLE appointment (
  id          INTEGER IDENTITY PRIMARY KEY,
  appointment_date  DATE,
  description VARCHAR(8192),
  pet_id      INTEGER NOT NULL
);

CREATE INDEX appointment_pet_id ON appointment (pet_id);
