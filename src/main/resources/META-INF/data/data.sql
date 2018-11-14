INSERT INTO roles (roleName) VALUES ('admin');
INSERT INTO roles (roleName) VALUES ('teacher');
INSERT INTO roles (roleName) VALUES ('user');
INSERT INTO techniques (techniqueName) VALUES ('Salsa Cubana');
INSERT INTO techniques (techniqueName) VALUES ('Salsa LA');
INSERT INTO techniques (techniqueName) VALUES ('Salsa on2');
INSERT INTO techniques (techniqueName) VALUES ('Rueda de Casino');
INSERT INTO techniques (techniqueName) VALUES ('Zouk');
INSERT INTO techniques (techniqueName) VALUES ('Bachata');
INSERT INTO techniques (techniqueName) VALUES ('Kizomba');
INSERT INTO techniques (techniqueName) VALUES ('UrbanKizz');
INSERT INTO users (firstName, lastName, email, note, password, tokens) VALUES ('Dawid', 'Przybyło', 'dawid@dawid.pl', 'SAM ON', 'haselko', 100);
INSERT INTO users (firstName, lastName, email, note, password, tokens) VALUES ('Admin', 'Admin', 'admin@admin.pl', 'Administrator', 'admin', 100);
INSERT INTO users_roles (User_id, roles_id) VALUES (1,1), (1,2), (1,3),(2,1), (2,2);
INSERT INTO users_techniques (User_id, techniques_id) VALUES (1,1), (1,2), (1,3), (1,5), (1,6), (1,7), (1,8), (2,1), (2,4);


