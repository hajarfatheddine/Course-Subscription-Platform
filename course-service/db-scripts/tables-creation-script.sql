CREATE TABLE courses (
                         id INTEGER PRIMARY KEY,
                         title VARCHAR(255) NOT NULL,
                         description VARCHAR2(255),
                         status VARCHAR(20),
                         created_at TIMESTAMP,
                         updated_at TIMESTAMP
);

CREATE TABLE modules (
                         id INTEGER PRIMARY KEY,
                         course_id INTEGER NOT NULL,
                         title VARCHAR(255) NOT NULL,
                         description VARCHAR2(255),
                         order_index INT NOT NULL,
                         FOREIGN KEY (course_id) REFERENCES courses(id)
);

CREATE TABLE assignments (
                             id INTEGER PRIMARY KEY,
                             module_id INTEGER NOT NULL,
                             title VARCHAR(255) NOT NULL,
                             description VARCHAR2(255),
                             max_grade DECIMAL(5,2),
                             FOREIGN KEY (module_id) REFERENCES modules(id)
);

commit;