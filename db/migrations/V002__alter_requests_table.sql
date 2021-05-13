alter TABLE requests
    drop COLUMN attendance,
    add COLUMN created TIMESTAMP,
    add COLUMN updated TIMESTAMP,
    add COLUMN status_claim ENUM('PROCESSED', 'UNPROCESSED') NOT NULL,
    add COLUMN updater VARCHAR(50)
;
