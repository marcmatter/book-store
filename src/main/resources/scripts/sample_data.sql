USE `book_store`;

INSERT INTO `author`
(`name`, `prename`) VALUES
('Brown', 'Dan'),
('Christie', 'Agatha'),
('Coelho', 'Paulo'),
('Follett', 'Ken'),
('Grisham', 'John'),
('King', 'Stephen'),
('Murakami', 'Haruki'),
('James', 'Patterson'),
('Roberts', 'Nora'),
('Steel', 'Danielle');

INSERT INTO `genere`
(`name`) VALUES
('Fantasy'),
('Science Fiction'),
('Action & Adventure'),
('Mystery'),
('Horror'),
('Thriller & Suspense'),
('Historical Fiction'),
('Romance'),
('Biography');

INSERT INTO `publisher`
(`name`) VALUES
('Pearson'),
('RELX'),
('Thomson Reuters'),
('Penguin Random House'),
('Hachette Livre'),
('Harper Collins'),
('Macmillan Publishers'),
('Bretelsmann'),
('Scholastic Corporation');

INSERT INTO `book`
(`title`, `author_id`, `genere_id`, `publisher_id`) VALUES
('Twilight of Kaus', 4, 6, 7),
('Queen of Nirvana', 2, 1, 7),
('Playground Bride', 5, 1, 2),
('Widow of Silence', 3, 4, 7),
('Smoke and the Book', 8, 4, 3),
('Claw of Fire', 1, 6, 2),
('The Ember in the Dust', 7, 3, 4),
('The Shattered Paper', 9, 4, 2),
('The Last Post', 4, 6, 1),
('Death of the Winged Lynx', 8, 4, 3),
('2938: Babilon', 6, 9, 5);

INSERT INTO `customer`
(`name`, `prename`) VALUES
('Ashley', 'Jackson'),
('Thompson', 'River'),
('Young', 'Scarlett'),
('Adams', 'Cole'),
('Harris', 'Alice'),
('May', 'Jax'),
('Perez', 'Maddox'),
('Bandini', 'Hudson'),
('Baker', 'Bryson'),
('Cassidy', 'Luis'),
('Bardot', 'Jeremy'),
('Smith', 'Amelia'),
('Bandini', 'Brandon'),
('Green', 'Samantha');

INSERT INTO `order`
(`book_id`, `customer_id`) VALUES
(1, 8),
(1, 6),
(3, 5),
(4, 2),
(5, 12),
(7, 9),
(9, 7),
(9, 5),
(9, 3),
(11, 1);
