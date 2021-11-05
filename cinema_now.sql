-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 05, 2021 at 08:18 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cinema_now`
--

-- --------------------------------------------------------

--
-- Table structure for table `complaint`
--

CREATE TABLE `complaint` (
  `id` varchar(36) NOT NULL,
  `container` varchar(255) DEFAULT NULL,
  `send_date` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `sender_id` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `complaint`
--

INSERT INTO `complaint` (`id`, `container`, `send_date`, `title`, `sender_id`) VALUES
('33aed6dc-3e2c-409e-8475-34f1f8b99fdd', 'Dear Sir/Madam, From tomorrow vaccination will be required, can I enter with a PCR test?', '25/05/2021', 'Vaccine required', 'aefe4e1c-c605-4217-bfba-17cfc3dc3f69'),
('85d63deb-a463-4e9d-a56a-6d2c11d3cca6', 'Dear Sir/Madam, From tomorrow vaccination will be required, can I enter with a PCR test?', '25/05/2021', 'Vaccine required', 'aefe4e1c-c605-4217-bfba-17cfc3dc3f69'),
('9ed49556-2689-4d1c-8560-4269213a1677', 'Dear Sir/Madam, From tomorrow vaccination will be required, can I enter with a PCR test?', '25/05/2021', 'Vaccine required', 'aefe4e1c-c605-4217-bfba-17cfc3dc3f69');

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE `movie` (
  `id` varchar(36) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `director` varchar(255) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `format` int(11) DEFAULT NULL,
  `genre` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `release_date` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `news`
--

CREATE TABLE `news` (
  `id` varchar(36) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `posted_at` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `news`
--

INSERT INTO `news` (`id`, `description`, `posted_at`, `title`) VALUES
('58dc9418-a722-43cf-886e-311a9af32250', 'asdasd', '26/06/2021', 'asdsadasd'),
('5dd3d47c-4009-44fc-8fff-9ebd45dcd1d5', 'asdasd', NULL, 'asdsadasd');

-- --------------------------------------------------------

--
-- Table structure for table `tickets`
--

CREATE TABLE `tickets` (
  `id` varchar(36) NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `holder_id` varchar(36) DEFAULT NULL,
  `movie_id` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` varchar(36) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `address`, `age`, `email`, `first_name`, `last_name`) VALUES
('aefe4e1c-c605-4217-bfba-17cfc3dc3f69', NULL, 0, 'a.sindrilaru@gmail.com', 'Andreea', 'Sindrilaru');

-- --------------------------------------------------------

--
-- Table structure for table `users_complaints`
--

CREATE TABLE `users_complaints` (
  `user_id` varchar(36) NOT NULL,
  `complaints_id` varchar(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `users_tickets`
--

CREATE TABLE `users_tickets` (
  `user_id` varchar(36) NOT NULL,
  `tickets_id` varchar(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `complaint`
--
ALTER TABLE `complaint`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4yk63qvlxmnuh64vu5932ojne` (`sender_id`);

--
-- Indexes for table `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tickets`
--
ALTER TABLE `tickets`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsm74pl1xpnyg918510539ar77` (`holder_id`),
  ADD KEY `FKoefv8syreryp96qam54mooam2` (`movie_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users_complaints`
--
ALTER TABLE `users_complaints`
  ADD UNIQUE KEY `UK_122txncy2rv8ambe620hftwhx` (`complaints_id`),
  ADD KEY `FKt3km2aiumukj4c3u8f4ipolny` (`user_id`);

--
-- Indexes for table `users_tickets`
--
ALTER TABLE `users_tickets`
  ADD UNIQUE KEY `UK_iav98afxo2e0xfofpmsc2r745` (`tickets_id`),
  ADD KEY `FKlgived6l1svgc49t3c8db4f02` (`user_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `complaint`
--
ALTER TABLE `complaint`
  ADD CONSTRAINT `FK4yk63qvlxmnuh64vu5932ojne` FOREIGN KEY (`sender_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `tickets`
--
ALTER TABLE `tickets`
  ADD CONSTRAINT `FKoefv8syreryp96qam54mooam2` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`),
  ADD CONSTRAINT `FKsm74pl1xpnyg918510539ar77` FOREIGN KEY (`holder_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `users_complaints`
--
ALTER TABLE `users_complaints`
  ADD CONSTRAINT `FKnjrq3pfdyphyjnh5hfbipwgfb` FOREIGN KEY (`complaints_id`) REFERENCES `complaint` (`id`),
  ADD CONSTRAINT `FKt3km2aiumukj4c3u8f4ipolny` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `users_tickets`
--
ALTER TABLE `users_tickets`
  ADD CONSTRAINT `FKbc2abl00uhgxid597yy5aq4cq` FOREIGN KEY (`tickets_id`) REFERENCES `tickets` (`id`),
  ADD CONSTRAINT `FKlgived6l1svgc49t3c8db4f02` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
