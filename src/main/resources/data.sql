-- Witcher Weapons
INSERT INTO weapon (name, category, damage, effects, weight, price) VALUES
-- Silver Swords (for monsters)
('Aerondight', 'Silver Sword', 450, 'Increases critical hit damage by 100%, gains permanent damage boost', 3, 5000),
('Gesheft', 'Silver Sword', 320, '+30% Sign intensity, +15% Chance to cause burning', 3, 2200),
('Moonblade', 'Silver Sword', 280, '+20% Critical hit chance against monsters at night', 2, 1800),

-- Steel Swords (for humans and non-magical creatures)
('Winter''s Blade', 'Steel Sword', 310, '+15% Chance to freeze, +10% Critical hit damage', 3, 2000),
('Iris', 'Steel Sword', 290, 'Special strong attack consumes health but deals massive damage', 3, 2500),
('Tir Tochair', 'Steel Sword', 270, '+10% Chance to cause bleeding, +5% Adrenaline point gain', 2, 1500),

-- Unique Witcher School Swords
('Feline Steel Sword (Mastercrafted)', 'Steel Sword', 330, '+50% Critical hit damage, +10% Fast attack damage', 2, 3200),
('Griffin Silver Sword (Grandmaster)', 'Silver Sword', 380, '+20% Sign intensity, +10% Yrden sign intensity', 4, 4200),
('Ursine Steel Sword (Superior)', 'Steel Sword', 350, '+30% Strong attack damage, +5% Chance to stagger', 5, 2800),
('Wolven Silver Sword (Enhanced)', 'Silver Sword', 300, '+15% Critical hit chance, +5% Adrenaline point gain', 3, 1900),
('Manticore Steel Sword', 'Steel Sword', 325, '+50% Critical hit damage, +15% Poison chance', 3, 3100),

-- Relic Swords
('Harambe''s Axe', 'Steel Sword', 285, '+20% Chance to cause bleeding, +15% Armor piercing', 4, 1700),
('Black Unicorn', 'Silver Sword', 360, '+15% Critical hit chance during storms', 3, 2900),
('Teigr', 'Steel Sword', 295, '+25% Aard sign intensity, Chance to knock down', 3, 2100),

-- Crossbows
('Feline Crossbow', 'Crossbow', 180, '+15% Critical hit chance, Quick reload', 4, 850),
('Ursine Crossbow', 'Crossbow', 220, 'High stagger chance, Can penetrate shields', 6, 1200),
('Bloodbath', 'Crossbow', 200, '+30% Damage against bleeding targets', 5, 950),

-- Special Weapons
('Caretaker''s Spade', 'Shovel', 260, 'Steals vitality from enemies with each hit', 5, 1500),
('Hjalmar''s Sword', 'Steel Sword', 340, '+25% Strong attack damage, High stagger chance', 5, 2700),
('Ofieri Saber', 'Steel Sword', 275, '+20% Fast attack damage, +10% Attack power', 2, 1600),
('Viper Silver Sword', 'Silver Sword', 290, '+40% Poison damage, Chance to poison on hit', 3, 2300);