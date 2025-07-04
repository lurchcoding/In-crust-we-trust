INSERT INTO users (
    user_id, username, password, salutation, salutation_detail,
    firstname, surname, email, phone_number, zipcode, city, country,
    address, created_at, last_updated_at,
    is_active, is_admin
) VALUES
      (gen_random_uuid(), 'clarkzod', '1234', 'Frau', NULL, 'Hannah', 'Bukovec', 'Hannah.Bukovec@muster.at', '+43 676 1234567', '4020', 'Linz', 'Austria', 'Hauptstraße 1', now(), now(), true, false),
      (gen_random_uuid(), 'brucefox', '1234', 'Herr', NULL, 'Paul', 'Pfischer', 'Paul.Pfischer@muster.at', '+43 664 2345678', '8010', 'Graz', 'Austria', 'Eggenberger Allee 15', now(), now(), false, true),
      (gen_random_uuid(), 'diana91', '1234', 'Frau', NULL, 'Sophie', 'Schmid', 'Sophie.Schmid@muster.at', '+43 650 3456789', '5020', 'Salzburg', 'Austria', 'Getreidegasse 8', now(), now(), true, false),
      (gen_random_uuid(), 'loganx', '1234', 'Divers', 'was weiß ich', 'Monday', 'Maier', 'Tobias.Maier@muster.at', '+43 699 4567890', '2700', 'Wiener Neustadt', 'Austria', 'Neunkirchner Straße 20', now(), now(), true, false),
      (gen_random_uuid(), 'selkyle', '1234', 'Frau', NULL, 'Anna', 'Alang', 'Anna.Alang@muster.at', '+43 676 5678901', '6850', 'Dornbirn', 'Austria', 'Marktplatz 3', now(), now(), true, false),
      (gen_random_uuid(), 'parjord', '1234', 'Herr', NULL, 'Nico', 'Hofer', 'Nico.Hofer@muster.at', '+43 664 6789012', '4400', 'Steyr', 'Austria', 'Stadtplatz 12', now(), now(), true, false),
      (gen_random_uuid(), 'barryv', '1234', 'Frau', NULL, 'Lisa', 'Gruber', 'Lisa.Gruber@muster.at', '+43 650 7890123', '9500', 'Villach', 'Austria', 'Italiener Straße 25', now(), now(), false, false),
      (gen_random_uuid(), 'reeddoc', '1234', 'Herr', NULL, 'David', 'Zuccatto', 'David.Zuccatto@muster.at', '+43 699 8901234', '3430', 'Tulln', 'Austria', 'Bahnhofstraße 4', now(), now(), true, false),
      (gen_random_uuid(), 'peterb', '1234', 'Frau', NULL, 'Katharina', 'Baumhackl', 'Katharina.Baumhackl@muster.at', '+43 676 9012345', '3100', 'St. Pölten', 'Austria', 'Kremser Gasse 7', now(), now(), true, true),
      (gen_random_uuid(), 'tonystar', '1234', 'Divers', 'was weiß ich', 'Morning', 'Müller', 'Raphael.Müller@muster.at', '+43 664 0123456', '7000', 'Eisenstadt', 'Austria', 'Haydngasse 11', now(), now(), true, false),
      (gen_random_uuid(), 'steverog', '1234', 'Frau', NULL, 'Theresa', 'Chang', 'Theresa.Chang@muster.at', '+43 650 1234567', '1190', 'Wien', 'Austria', 'Grinzinger Straße 14', now(), now(), true, false),
      (gen_random_uuid(), 'natroma', '1234', 'Herr', NULL, 'Simon', 'Schuster', 'Simon.Schuster@muster.at', '+43 699 2345678', '9560', 'Feldkirchen', 'Austria', 'Hauptplatz 9', now(), now(), true, true),
      (gen_random_uuid(), 'bamwayne', '1234', 'Frau', NULL, 'Nina', 'Wiener', 'Nina.Wiener@muster.at', '+43 676 3456789', '2500', 'Baden', 'Austria', 'Helenenstraße 6', now(), now(), true, false);

UPDATE users
SET
    created_by_user_id = user_id,
    last_updated_by_user_id = user_id;
INSERT INTO allergens (abbreviation, description,
                       created_at, last_updated_at)
VALUES
    ('A', 'Glutenhaltiges Getreide', now(), now()),
    ('B', 'Krebstiere', now(), now()),
    ('C', 'Eier', now(), now()),
    ('D', 'Fisch', now(), now()),
    ('E', 'Erdnüsse', now(), now()),
    ('F', 'Soja', now(), now()),
    ('G', 'Milch (inkl. Laktose)', now(), now()),
    ('H', 'Schalenfrüchte (Nüsse)', now(), now()),
    ('L', 'Sellerie', now(), now()),
    ('M', 'Senf', now(), now()),
    ('N', 'Sesam', now(), now()),
    ('O', 'Schwefeldioxid und Sulfite', now(), now()),
    ('P', 'Lupinen', now(), now()),
    ('R', 'Weichtiere', now(), now());

UPDATE allergens
SET
    created_by_user_id = sub.user_id,
    last_updated_by_user_id = sub.user_id
FROM (
         SELECT user_id
         FROM users
         WHERE is_admin = true
         ORDER BY random()
         LIMIT 1
     ) AS sub;



INSERT INTO products (
    product_id, product_name, product_description, main_category,
    sub_category, price, is_vegetarian, created_at, last_updated_at,
    is_active, created_by_user_id, last_updated_by_user_id
) VALUES
-- STARTERS
(gen_random_uuid(), 'Bruschetta Classica', 'Geröstetes Brot mit Tomaten, Knoblauch & Basilikum', 'STARTER', NULL, 5.90, true, '2024-03-01', '2025-01-12', true, NULL, NULL),
(gen_random_uuid(), 'Caprese mit Mozzarella di Bufala', 'Buffalomozzarella mit Tomaten & Basilikum', 'STARTER', NULL, 7.20, true, '2024-04-12', '2025-03-18', true, NULL, NULL),
(gen_random_uuid(), 'Antipasto Misto', 'Oliven, Schinken & Käse Variation', 'STARTER', NULL, 9.80, false, '2024-06-07', '2024-11-22', false, NULL, NULL),
(gen_random_uuid(), 'Knoblauchbrot', 'Knoblauchbutter auf Baguette', 'STARTER', NULL, 3.50, true, '2024-07-19', '2024-10-03', false, NULL, NULL),
(gen_random_uuid(), 'Carpaccio vom Rind', 'Dünnes Rindfleisch, Parmesan & Rucola', 'STARTER', NULL, 11.50, false, '2024-08-23', '2025-01-04', true, NULL, NULL),
(gen_random_uuid(), 'Vitello Tonnato', 'Kalbfleisch mit Thunfischcreme', 'STARTER', NULL, 10.20, false, '2024-08-30', '2025-01-08', true, NULL, NULL),
(gen_random_uuid(), 'Gegrilltes Gemüse', 'Mediterran mariniert', 'STARTER', NULL, 6.50, true, '2024-09-12', '2025-01-10', true, NULL, NULL),
(gen_random_uuid(), 'Zucchini Fritti', 'Frittierte Zucchinischeiben', 'STARTER', NULL, 5.20, true, '2024-09-22', '2025-01-15', true, NULL, NULL),
(gen_random_uuid(), 'Mozzarella in Carrozza', 'Frittierter Mozzarella', 'STARTER', NULL, 6.80, true, '2024-10-01', '2025-01-18', true, NULL, NULL),
(gen_random_uuid(), 'Oliven & Brot', 'Gemischte Oliven mit Ciabatta', 'STARTER', NULL, 4.00, true, '2024-10-15', '2025-01-20', true, NULL, NULL),

-- MAIN_COURSE PIZZA
(gen_random_uuid(), 'Pizza Margherita', 'Tomaten, Mozzarella & Basilikum', 'MAIN_COURSE', 'PIZZA', 8.90, true, '2025-01-22', '2025-05-10', true, NULL, NULL),
(gen_random_uuid(), 'Pizza Salami', 'Mit würziger Salami & Käse', 'MAIN_COURSE', 'PIZZA', 10.50, false, '2025-02-14', '2025-04-29', true, NULL, NULL),
(gen_random_uuid(), 'Pizza Funghi', 'Frische Champignons & Mozzarella', 'MAIN_COURSE', 'PIZZA', 9.90, true, '2025-03-02', '2025-04-27', true, NULL, NULL),
(gen_random_uuid(), 'Pizza Tonno', 'Thunfisch & rote Zwiebeln', 'MAIN_COURSE', 'PIZZA', 11.20, false, '2025-03-18', '2025-05-15', true, NULL, NULL),
(gen_random_uuid(), 'Pizza Quattro Formaggi', 'Vier Käsesorten', 'MAIN_COURSE', 'PIZZA', 10.90, true, '2025-03-24', '2025-05-30', true, NULL, NULL),
(gen_random_uuid(), 'Pizza Diavola', 'Scharfe Salami & Chili', 'MAIN_COURSE', 'PIZZA', 11.50, false, '2025-04-01', '2025-06-02', true, NULL, NULL),
(gen_random_uuid(), 'Pizza Prosciutto', 'Kochschinken & Mozzarella', 'MAIN_COURSE', 'PIZZA', 10.80, false, '2025-04-06', '2025-06-05', true, NULL, NULL),
(gen_random_uuid(), 'Pizza Vegetariana', 'Paprika, Zucchini, Aubergine', 'MAIN_COURSE', 'PIZZA', 9.80, true, '2025-04-10', '2025-06-10', true, NULL, NULL),
(gen_random_uuid(), 'Pizza Calzone', 'Gefüllt mit Schinken & Käse', 'MAIN_COURSE', 'PIZZA', 11.30, false, '2025-04-14', '2025-06-12', true, NULL, NULL),
(gen_random_uuid(), 'Pizza Frutti di Mare', 'Meeresfrüchte & Knoblauchöl', 'MAIN_COURSE', 'PIZZA', 12.90, false, '2025-04-18', '2025-06-14', true, NULL, NULL),

-- MAIN_COURSE PASTA
(gen_random_uuid(), 'Spaghetti Aglio e Olio', 'Knoblauch, Olivenöl & Chili', 'MAIN_COURSE', 'PASTA', 8.50, true, '2025-03-28', '2025-06-02', true, NULL, NULL),
(gen_random_uuid(), 'Tagliatelle al Ragù', 'Bandnudeln mit Fleischragù', 'MAIN_COURSE', 'PASTA', 12.80, false, '2025-04-04', '2025-06-08', true, NULL, NULL),
(gen_random_uuid(), 'Penne Arrabiata', 'Scharfe Tomatensauce', 'MAIN_COURSE', 'PASTA', 9.10, true, '2025-04-12', '2025-06-10', true, NULL, NULL),
(gen_random_uuid(), 'Lasagne al Forno', 'Schichtweise mit Hack & Bechamel', 'MAIN_COURSE', 'PASTA', 13.20, false, '2025-04-20', '2025-06-15', true, NULL, NULL),
(gen_random_uuid(), 'Gnocchi Gorgonzola', 'In cremiger Käsesauce', 'MAIN_COURSE', 'PASTA', 10.50, true, '2025-04-24', '2025-06-17', true, NULL, NULL),
(gen_random_uuid(), 'Linguine Frutti di Mare', 'Mit Meeresfrüchten', 'MAIN_COURSE', 'PASTA', 14.30, false, '2025-04-28', '2025-06-20', true, NULL, NULL),
(gen_random_uuid(), 'Spaghetti Carbonara', 'Mit Speck & Ei', 'MAIN_COURSE', 'PASTA', 11.00, false, '2025-05-01', '2025-06-22', true, NULL, NULL),
(gen_random_uuid(), 'Penne Pesto', 'Basilikumpesto & Parmesan', 'MAIN_COURSE', 'PASTA', 9.70, true, '2025-05-05', '2025-06-24', true, NULL, NULL),

-- MAIN_COURSE BOWLS
(gen_random_uuid(), 'Veggie Buddha Bowl', 'Reis, Kichererbsen, Gemüse & Tahini', 'MAIN_COURSE', 'BOWL', 11.90, true, '2025-03-10', '2025-05-08', true, NULL, NULL),
(gen_random_uuid(), 'Steak Bowl', 'Rind, Avocado & BBQ-Salat', 'MAIN_COURSE', 'BOWL', 15.30, false, '2025-03-16', '2025-05-11', true, NULL, NULL),
(gen_random_uuid(), 'Falafel Bowl', 'Humus, Falafel, Couscous', 'MAIN_COURSE', 'BOWL', 10.80, true, '2025-03-22', '2025-05-15', true, NULL, NULL),
(gen_random_uuid(), 'Chicken Teriyaki Bowl', 'Reis, Huhn, Sesam & Gemüse', 'MAIN_COURSE', 'BOWL', 13.90, false, '2025-03-27', '2025-05-20', true, NULL, NULL),

-- DESSERT
(gen_random_uuid(), 'Tiramisu', 'Mit Espresso & Mascarpone', 'DESSERT', NULL, 6.20, true, '2025-03-20', '2025-06-12', true, NULL, NULL),
(gen_random_uuid(), 'Panna Cotta', 'Mit Erdbeersauce', 'DESSERT', NULL, 5.80, true, '2025-03-25', '2025-06-15', true, NULL, NULL),
(gen_random_uuid(), 'Profiteroles', 'Gefüllt mit Vanillecreme', 'DESSERT', NULL, 5.90, true, '2025-03-28', '2025-06-18', true, NULL, NULL),
(gen_random_uuid(), 'Gelato Misto', 'Gemischtes Eis', 'DESSERT', NULL, 4.50, true, '2025-04-02', '2025-06-21', true, NULL, NULL),
(gen_random_uuid(), 'Käsekuchen', 'Hausgemacht mit Himbeeren', 'DESSERT', NULL, 5.70, true, '2025-04-08', '2025-06-24', true, NULL, NULL),

-- DRINKS
(gen_random_uuid(), 'Coca-Cola', NULL, 'DRINK', 'ALCOHOL_FREE', 2.90, true, '2025-04-01', '2025-06-20', true, NULL, NULL),
(gen_random_uuid(), 'Fanta', NULL, 'DRINK', 'ALCOHOL_FREE', 2.90, true, '2025-04-03', '2025-06-21', true, NULL, NULL),
(gen_random_uuid(), 'Sprite', NULL, 'DRINK','ALCOHOL_FREE', 2.90, true, '2025-04-05', '2025-06-22', true, NULL, NULL),
(gen_random_uuid(), 'Mineralwasser', NULL, 'DRINK', 'ALCOHOL_FREE', 2.40, true, '2025-04-06', '2025-06-23', true, NULL, NULL),
(gen_random_uuid(), 'Hauswein Rot', NULL, 'DRINK', 'WINE', 3.90, true, '2025-04-10', '2025-06-24', true, NULL, NULL),
(gen_random_uuid(), 'Hauswein Weiß', NULL, 'DRINK', 'WINE', 3.90, true, '2025-04-12', '2025-06-25', true, NULL, NULL),
(gen_random_uuid(), 'Aperol Spritz', NULL, 'DRINK', 'WINE', 5.90, true, '2025-04-15', '2025-06-26', true, NULL, NULL),
(gen_random_uuid(), 'Espresso', NULL, 'DRINK', 'COFFEE', 1.90, true, '2025-04-18', '2025-06-27', true, NULL, NULL),
(gen_random_uuid(), 'Cappuccino', NULL, 'DRINK', 'COFFEE', 2.80, true, '2025-04-20', '2025-06-28', true, NULL, NULL),
(gen_random_uuid(), 'Latte Macchiato', NULL, 'DRINK', 'COFFEE', 3.10, true, '2025-04-22', '2025-06-29', true, NULL, NULL),
(gen_random_uuid(), 'Grappa', NULL, 'DRINK', 'SPIRIT', 3.50, true, '2025-04-24', '2025-06-30', true, NULL, NULL),
(gen_random_uuid(), 'Limoncello', NULL, 'DRINK', 'SPIRIT', 3.20, true, '2025-04-26', '2025-07-01', true, NULL, NULL),
(gen_random_uuid(), 'Campari Orange', NULL, 'DRINK', 'SPIRIT', 5.20, true, '2025-04-28', '2025-07-02', true, NULL, NULL),
(gen_random_uuid(), 'Ottakringer Helles', NULL, 'DRINK', 'BEER', 4.80, true, '2025-04-26', '2025-07-01', true, NULL, NULL),
(gen_random_uuid(), 'Ottakringer Zwickl', NULL, 'DRINK', 'BEER', 4.80, true, '2025-04-26', '2025-07-01', true, NULL, NULL),
(gen_random_uuid(), 'Ottakringer Pils', NULL, 'DRINK', 'BEER', 4.80, true, '2025-04-26', '2025-07-01', true, NULL, NULL);

UPDATE products
SET
    created_by_user_id = sub.user_id,
    last_updated_by_user_id = sub.user_id
FROM (
         SELECT user_id
         FROM users
         WHERE is_admin = true
         ORDER BY random()
         LIMIT 1
     ) AS sub;

INSERT INTO products_allergens (product_id, allergen_abbreviation)
SELECT
    p.product_id,
    a.abbreviation
FROM
    products p
        JOIN LATERAL (
        SELECT abbreviation
        FROM allergens
        ORDER BY random()
        LIMIT floor(random() * 4 + 1)::int
        ) AS a ON TRUE;

DO $$
    DECLARE
        i INT := 1;
        product_count INT;
        product RECORD;
        rand_quantity INT;
        rand_order_id UUID;
    BEGIN
        WHILE i <= 30 LOOP
                rand_order_id := gen_random_uuid();
                product_count := FLOOR(random() * 5 + 1); -- 1 bis 5 Produkte

                FOR product IN
                    SELECT p.product_id, p.product_name, p.price AS unit_price
                    FROM products p
                    ORDER BY random()
                    LIMIT product_count
                    LOOP
                        rand_quantity := FLOOR(random() * 4 + 1); -- 1 bis 4

                        INSERT INTO order_item (order_id, product_id, quantity, product_name, price)
                        VALUES (
                                   rand_order_id,
                                   product.product_id,
                                   rand_quantity,
                                   product.product_name,
                                   product.unit_price * rand_quantity
                               );
                    END LOOP;

                i := i + 1;
            END LOOP;
    END $$;