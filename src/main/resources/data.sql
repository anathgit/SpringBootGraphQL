-- Create the profile table
CREATE TABLE profile (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Create the entitlement table
CREATE TABLE entitlement (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    profile_id BIGINT,
    name VARCHAR(255),
    FOREIGN KEY (profile_id) REFERENCES profile (id)
);

-- Insert profiles
INSERT INTO profile (name) VALUES ('ADMIN');
INSERT INTO profile (name) VALUES ('USER');
INSERT INTO profile (name) VALUES ('SUPERVISOR');

-- Insert entitlements for ADMIN
INSERT INTO entitlement (profile_id, name) VALUES (1, 'ADMIN_PRIVILEGE');
INSERT INTO entitlement (profile_id, name) VALUES (1, 'READ_PRIVILEGE');
INSERT INTO entitlement (profile_id, name) VALUES (1, 'WRITE_PRIVILEGE');

-- Insert entitlements for USER
INSERT INTO entitlement (profile_id, name) VALUES (2, 'READ_PRIVILEGE');

-- Insert entitlements for SUPERVISOR
INSERT INTO entitlement (profile_id, name) VALUES (3, 'READ_PRIVILEGE');
INSERT INTO entitlement (profile_id, name) VALUES (3, 'WRITE_PRIVILEGE');
