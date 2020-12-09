alter table requests add column
    status_claim ENUM('PROCESSED', 'UNPROCESSED') NOT NULL default 'UNPROCESSED';
