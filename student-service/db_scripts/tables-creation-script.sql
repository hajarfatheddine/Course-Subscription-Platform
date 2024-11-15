CREATE TABLE students (
                          id integer PRIMARY KEY,          -- Your internal ID
                          keycloak_id VARCHAR(255) UNIQUE NOT NULL,  -- Links to Keycloak user
                          first_name VARCHAR(100),
                          last_name VARCHAR(100),
                          email VARCHAR(255) UNIQUE
);
commit;