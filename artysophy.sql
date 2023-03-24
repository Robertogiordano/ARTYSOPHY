-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Creato il: Mar 24, 2023 alle 15:12
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
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `Artist`
--
ALTER TABLE `Artist`
  ADD PRIMARY KEY (`id`);

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
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `Artist`
--
ALTER TABLE `Artist`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `Artwork`
--
ALTER TABLE `Artwork`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `Museum`
--
ALTER TABLE `Museum`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

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
