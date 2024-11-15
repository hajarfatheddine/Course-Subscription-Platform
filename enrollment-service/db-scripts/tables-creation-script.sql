CREATE TABLE enrollments (
                             id INTEGER PRIMARY KEY,
                             student_id INTEGER NOT NULL,
                             course_id INTEGER NOT NULL,
                             current_module_id INTEGER,
                             status VARCHAR(20),
                             enrolled_at TIMESTAMP
    -- Foreign keys become reference IDs in microservices
);

CREATE TABLE assignment_submissions (
                                        id INTEGER PRIMARY KEY,
                                        enrollment_id INTEGER NOT NULL,
                                        assignment_id INTEGER NOT NULL,
                                        submission_date TIMESTAMP,
                                        grade DECIMAL(5,2),
                                        status VARCHAR(20),
                                        FOREIGN KEY (enrollment_id) REFERENCES enrollments(id)
);
commit