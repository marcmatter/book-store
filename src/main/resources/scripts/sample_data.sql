USE `book_store`;

TRUNCATE `author`;
INSERT INTO `author`
(`name`, `prename`) VALUES
(`Brown`, `Dan`),
(`Christie`, `Agatha`),
(`Coelho`, `Paulo`),
(`Follett`, `Ken`),
(`Grisham`, `John`),
(`King`, `Stephen`),
(`Murakami`, `Haruki`),
(`James`, `Patterson`),
(`Roberts`, `Nora`),
(`Steel`, `Danielle`);

TRUNCATE `genere`;
INSERT INTO `genere`
(`name`) VALUES
(`Fantasy`),
(`Science Fiction`),
(`Action & Adventure`),
(`Mystery`),
(`Horror`),
(`Thriller & Suspense`),
(`Historical Fiction`),
(`Romance`),
(`Biography`);

TRUNCATE `publisher`;
INSERT INTO `publisher`
(`name`) VALUES
(`Pearson`),
(`RELX`),
(`Thomson Reuters`),
(`Penguin Random House`),
(`Hachette Livre`),
(`Harper Collins`),
(`Macmillan Publishers`),
(`Bretelsmann`),
(`Scholastic Corporation`);

TRUNCATE `book`;
INSERT INTO `book`
(`title, author_id`, `genere_id`, `publisher_id`) VALUES
(`title, author_id`, `genere_id`, `publisher_id`),
(`title, author_id`, `genere_id`, `publisher_id`),
(`title, author_id`, `genere_id`, `publisher_id`),
(`title, author_id`, `genere_id`, `publisher_id`),
(`title, author_id`, `genere_id`, `publisher_id`);
