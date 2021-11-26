-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 26, 2021 at 05:34 PM
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
-- Table structure for table `complaints`
--

CREATE TABLE `complaints` (
  `id` varchar(36) NOT NULL,
  `container` varchar(255) DEFAULT NULL,
  `send_date` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `sender_id` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `movies`
--

CREATE TABLE `movies` (
  `id` varchar(36) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `director` varchar(255) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `format` int(11) DEFAULT NULL,
  `genre` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `release_date` varchar(255) DEFAULT NULL,
  `room_room_id` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `movies`
--

INSERT INTO `movies` (`id`, `description`, `director`, `duration`, `format`, `genre`, `name`, `release_date`, `room_room_id`) VALUES
('968dc56b-f2a1-47bf-bc30-77ff3eea706e', 'test', 'test', 180, 0, 10, 'Cars', '26/06/2021', NULL);

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
('26c358d6-012d-4843-9d34-8e07679c6889', 'test', '26/05/2021', 'test');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id` varchar(36) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
('32ec83f0-06bc-4406-ad3d-8a7f0274364a', 'ROLE_USER'),
('f9272125-77b6-4aa2-a4b4-c7f28a19f12b', 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE `rooms` (
  `room_id` varchar(36) NOT NULL,
  `capacity` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `movie_id` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `rooms_tickets`
--

CREATE TABLE `rooms_tickets` (
  `room_room_id` varchar(36) NOT NULL,
  `tickets_id` varchar(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tickets`
--

CREATE TABLE `tickets` (
  `id` varchar(36) NOT NULL,
  `amount_of_people` int(11) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `holder_id` varchar(36) DEFAULT NULL,
  `movie_id` varchar(36) DEFAULT NULL,
  `room_room_id` varchar(36) DEFAULT NULL
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
  `is_loyal` bit(1) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `address`, `age`, `email`, `first_name`, `is_loyal`, `last_name`, `password`, `username`) VALUES
('2f5182bf-cc5c-4497-8dd4-b51368883eb6', NULL, 0, 'm.zavaroanu@gmail.com', 'Maria', b'0', 'Oancea', '$2a$10$pZzauI4qDyKnFBqa61.YFe1kXubmEkLoqW9kh4kZhFXb7IhAB6VBq', 'oanceaa'),
('6c36e09f-1196-4bdc-b7ad-abc487b1cb0d', NULL, 0, 'm.zavaroanu@gmail.com', 'Puya', b'0', 'Oancea', '$2a$10$m4ArNCHq5SBWpkiyUUjmROoZOtHUEY0Ak.k/3JvkAfajF/qrgOJ1.', 'puyaeboss'),
('ff571a82-341c-4aff-af94-12525309d6df', NULL, 0, 'm.zavaroanu@gmail.com', 'Maria', b'0', 'Zavaranu', '$2a$10$e2q8MT.nK3MdgxPmMuCGceNWRW0dIsMFYmoW7X1GbyPGC4skyMagS', 'mari');

-- --------------------------------------------------------

--
-- Table structure for table `users_complaints`
--

CREATE TABLE `users_complaints` (
  `app_user_id` varchar(36) NOT NULL,
  `complaints_id` varchar(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `users_roles`
--

CREATE TABLE `users_roles` (
  `app_user_id` varchar(36) NOT NULL,
  `roles_id` varchar(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users_roles`
--

INSERT INTO `users_roles` (`app_user_id`, `roles_id`) VALUES
('ff571a82-341c-4aff-af94-12525309d6df', '32ec83f0-06bc-4406-ad3d-8a7f0274364a'),
('2f5182bf-cc5c-4497-8dd4-b51368883eb6', 'f9272125-77b6-4aa2-a4b4-c7f28a19f12b');

-- --------------------------------------------------------

--
-- Table structure for table `users_tickets`
--

CREATE TABLE `users_tickets` (
  `app_user_id` varchar(36) NOT NULL,
  `tickets_id` varchar(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `complaints`
--
ALTER TABLE `complaints`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKl1vcrywkets119kk6rpmm1fhm` (`sender_id`);

--
-- Indexes for table `movies`
--
ALTER TABLE `movies`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKht554chmfnej0v89mg2r5ovl7` (`room_room_id`);

--
-- Indexes for table `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`room_id`),
  ADD KEY `FK359wvp8xc1u8hsq70vkjl74yh` (`movie_id`);

--
-- Indexes for table `rooms_tickets`
--
ALTER TABLE `rooms_tickets`
  ADD UNIQUE KEY `UK_1htcyndpten0b3w2a67l51ui0` (`tickets_id`),
  ADD KEY `FKp99egxkj82xox8mht5ly3i75h` (`room_room_id`);

--
-- Indexes for table `tickets`
--
ALTER TABLE `tickets`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsm74pl1xpnyg918510539ar77` (`holder_id`),
  ADD KEY `FKorolxf50nkk7qbxuextweuhrh` (`movie_id`),
  ADD KEY `FK9xayjeq6jfenkuw5vcryqg19f` (`room_room_id`);

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
  ADD KEY `FKt8cchbs9xwg96urenritswhe3` (`app_user_id`);

--
-- Indexes for table `users_roles`
--
ALTER TABLE `users_roles`
  ADD KEY `FKa62j07k5mhgifpp955h37ponj` (`roles_id`),
  ADD KEY `FKar2y0lww0xn3x3aoqfg9qsgr5` (`app_user_id`);

--
-- Indexes for table `users_tickets`
--
ALTER TABLE `users_tickets`
  ADD UNIQUE KEY `UK_iav98afxo2e0xfofpmsc2r745` (`tickets_id`),
  ADD KEY `FKfc665sse45kvnvq3wodqxgca6` (`app_user_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `complaints`
--
ALTER TABLE `complaints`
  ADD CONSTRAINT `FKl1vcrywkets119kk6rpmm1fhm` FOREIGN KEY (`sender_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `movies`
--
ALTER TABLE `movies`
  ADD CONSTRAINT `FKht554chmfnej0v89mg2r5ovl7` FOREIGN KEY (`room_room_id`) REFERENCES `rooms` (`room_id`);

--
-- Constraints for table `rooms`
--
ALTER TABLE `rooms`
  ADD CONSTRAINT `FK359wvp8xc1u8hsq70vkjl74yh` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`);

--
-- Constraints for table `rooms_tickets`
--
ALTER TABLE `rooms_tickets`
  ADD CONSTRAINT `FK4khqd43gdjf418tg56oqdu19l` FOREIGN KEY (`tickets_id`) REFERENCES `tickets` (`id`),
  ADD CONSTRAINT `FKp99egxkj82xox8mht5ly3i75h` FOREIGN KEY (`room_room_id`) REFERENCES `rooms` (`room_id`);

--
-- Constraints for table `tickets`
--
ALTER TABLE `tickets`
  ADD CONSTRAINT `FK9xayjeq6jfenkuw5vcryqg19f` FOREIGN KEY (`room_room_id`) REFERENCES `rooms` (`room_id`),
  ADD CONSTRAINT `FKorolxf50nkk7qbxuextweuhrh` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`),
  ADD CONSTRAINT `FKsm74pl1xpnyg918510539ar77` FOREIGN KEY (`holder_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `users_complaints`
--
ALTER TABLE `users_complaints`
  ADD CONSTRAINT `FKcsn4tdkbexo34yce2f4wj1ehm` FOREIGN KEY (`complaints_id`) REFERENCES `complaints` (`id`),
  ADD CONSTRAINT `FKt8cchbs9xwg96urenritswhe3` FOREIGN KEY (`app_user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `users_roles`
--
ALTER TABLE `users_roles`
  ADD CONSTRAINT `FKa62j07k5mhgifpp955h37ponj` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `FKar2y0lww0xn3x3aoqfg9qsgr5` FOREIGN KEY (`app_user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `users_tickets`
--
ALTER TABLE `users_tickets`
  ADD CONSTRAINT `FKbc2abl00uhgxid597yy5aq4cq` FOREIGN KEY (`tickets_id`) REFERENCES `tickets` (`id`),
  ADD CONSTRAINT `FKfc665sse45kvnvq3wodqxgca6` FOREIGN KEY (`app_user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
