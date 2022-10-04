USE `book_store`;

INSERT INTO `book`
(`title`, `author`, `genre`, `publisher`) VALUES
('Twilight of Kaus', 'Brown Dan', 'Fantasy', 'Pearson'),
('Queen of Nirvana', 'Christie Agatha', 'Science Fiction', 'Thomson Reuters'),
('Playground Bride', 'Coelho Paulo', 'Action & Adventure', 'RELX'),
('Widow of Silence', 'Follett Ken', 'Mystery', 'Pearson'),
('Smoke and the Book', 'Grisham John', 'Horror', 'Penguin Random House'),
('Claw of Fire', 'King Stephen', 'Thriller & Suspense', 'Hachette Livre'),
('The Ember in the Dust', 'Murakami Haruki', 'Historical Fiction', 'RELX'),
('The Shattered Paper', 'James Patterson', 'Romance', 'Pearson'),
('The Last Post', 'Roberts Nora', 'Biography', 'Macmillan Publishers'),
('Death of the Winged Lynx', 'Steel Danielle', 'Romance', 'Bretelsmann'),
('2938: Babilon', 'King Stephen', 'Science Fiction', 'RELX');

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
(`book_id`, `customer_id`, `isDelivered`) VALUES
(1, 8, true),
(1, 6, false),
(3, 5, true),
(4, 2, false),
(5, 12, false),
(7, 9, false),
(9, 7, true),
(9, 5, true),
(9, 3, true),
(11, 1, true);
