DROP TABLE IF EXISTS requests;
CREATE TABLE requests (
                          id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          age INT NOT NULL,
                          phone VARCHAR(11) NOT NULL,
                          attendance ENUM('FULL_TIME', 'PART_TIME') NOT NULL,
                          name VARCHAR(255),
                          status_claim ENUM('PROCESSED', 'UNPROCESSED') NOT NULL,
                          comment VARCHAR(255)
);
