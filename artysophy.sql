-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Creato il: Mar 25, 2023 alle 13:03
-- Versione del server: 10.4.27-MariaDB
-- Versione PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `artysophy`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `Artist`
--

CREATE TABLE `Artist` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `birthYear` int(11) NOT NULL,
  `deathYear` int(11) NOT NULL,
  `description` text NOT NULL,
  `wiki` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `Artist`
--

INSERT INTO `Artist` (`id`, `name`, `birthYear`, `deathYear`, `description`, `wiki`) VALUES
(0, 'Pablo Picasso', 18811025, 1973048, 'Pablo Ruiz y Picasso, simply known as Pablo Picasso, was a Spanish painter, sculptor and lithographer, among the most influential of the 20th century', 'https://en.wikipedia.org/wiki/Pablo_Picasso'),
(1, 'Salvador Dalí', 19040511, 19890123, 'Salvador Dalí, Marquis of Pùbol, born Salvador Domingo Felipe Jacinto Dalí i Domènech, was a Spanish painter, sculptor, writer, photographer, filmmaker, designer, screenwriter and mystic', 'https://en.wikipedia.org/wiki/Salvador_Dal%C3%AD'),
(5, 'Vincent van Gogh', 1853, 1890, 'Vincent Willem van Gogh (Dutch: [ˈvɪnsɛnt ˈʋɪləm vɑŋ ˈɣɔx] (listen);[note 1] 30 March 1853 – 29 July 1890) was a Dutch Post-Impressionist painter who posthumously became one of the most famous and influential figures in Western art history.', 'https://en.wikipedia.org/wiki/Vincent_van_Gogh');

-- --------------------------------------------------------

--
-- Struttura della tabella `Artwork`
--

CREATE TABLE `Artwork` (
  `id` int(11) NOT NULL,
  `imgPath` text NOT NULL,
  `name` varchar(50) NOT NULL,
  `year` int(11) NOT NULL,
  `autor_id` int(11) NOT NULL,
  `museum_id` int(11) NOT NULL,
  `description` text NOT NULL,
  `wiki` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `Artwork`
--

INSERT INTO `Artwork` (`id`, `imgPath`, `name`, `year`, `autor_id`, `museum_id`, `description`, `wiki`) VALUES
(2, 'img1', 'Sunflower', 1888, 5, 2, 'unflowers (original title, in French: Tournesols) is the title of two series of still life paintings by the Dutch painter Vincent van Gogh.', 'https://en.wikipedia.org/wiki/Sunflowers_(Van_Gogh_series)');

-- --------------------------------------------------------

--
-- Struttura della tabella `Museum`
--

CREATE TABLE `Museum` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `street` text NOT NULL,
  `openingHour` text NOT NULL,
  `closingHour` text NOT NULL,
  `phone` text NOT NULL,
  `description` text NOT NULL,
  `price` double NOT NULL,
  `webpageUrl` text NOT NULL,
  `wiki` text NOT NULL,
  `googleMaps` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `Museum`
--

INSERT INTO `Museum` (`id`, `name`, `street`, `openingHour`, `closingHour`, `phone`, `description`, `price`, `webpageUrl`, `wiki`, `googleMaps`) VALUES
(2, 'National gallery', 'Trafalgar Square', '10am', '6pm', '', 'The National Gallery is an art museum in Trafalgar Square in the City of Westminster, in Central London, England.', 0, 'https://www.nationalgallery.org.uk', 'https://en.wikipedia.org/wiki/National_Gallery', 'https://www.google.com/maps/place/51°30\'32.1%22N+0°07\'41.9%22W/@51.508929,-0.128299,15z/data=!4m4!3m3!8m2!3d51.508929!4d-0.128299?hl=en');

-- --------------------------------------------------------

--
-- Struttura della tabella `User`
--

CREATE TABLE `User` (
  `name` text NOT NULL,
  `surnames` text NOT NULL,
  `username` varchar(30) NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `User`
--

INSERT INTO `User` (`name`, `surnames`, `username`, `email`, `password`) VALUES
('Roberto', 'Giordano', 'rgiordano', 'rgiordano@al.uloyola.es', 'qwertyuiop');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `Artist`
--
ALTER TABLE `Artist`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_name` (`name`);

--
-- Indici per le tabelle `Artwork`
--
ALTER TABLE `Artwork`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Artwork_Artist` (`autor_id`),
  ADD KEY `fk_Artwork_Museum` (`museum_id`);

--
-- Indici per le tabelle `Museum`
--
ALTER TABLE `Museum`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_name` (`name`);

--
-- Indici per le tabelle `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`username`),
  ADD UNIQUE KEY `email` (`email`) USING HASH;

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `Artist`
--
ALTER TABLE `Artist`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT per la tabella `Artwork`
--
ALTER TABLE `Artwork`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `Museum`
--
ALTER TABLE `Museum`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `Artwork`
--
ALTER TABLE `Artwork`
  ADD CONSTRAINT `fk_Artwork_Artist` FOREIGN KEY (`autor_id`) REFERENCES `Artist` (`id`),
  ADD CONSTRAINT `fk_Artwork_Museum` FOREIGN KEY (`museum_id`) REFERENCES `Museum` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
