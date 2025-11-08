-- changeset gabriel:admin-user
-- liquibase formatted sql

-- changeset gabriel:roles-default
INSERT INTO roles (id, role, description)
VALUES
    ('11111111-1111-1111-1111-111111111111', 'ADMIN', 'Administrador del sistema'),
    ('22222222-2222-2222-2222-222222222222', 'USER', 'Usuario regular del sistema');


INSERT INTO employees (
    id, name, surname, email, password,
    address, phone, roles_id
) VALUES (
             '33333333-3333-3333-3333-333333333333',
             'System',
             'Administrator',
             'admin@system.com',
             '$2a$10$oQkRyOt0CFJ/B2PSDqokhOe5.5AFbF2Qg96cdlNi2xBiPSrDX5Ha6', -- holamundo
             'San Salvador',
             '7000-0000',
             '11111111-1111-1111-1111-111111111111' -- Rol ADMIN
         );
