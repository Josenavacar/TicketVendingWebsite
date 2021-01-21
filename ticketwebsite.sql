-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 21, 2021 at 04:13 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ticketwebsiteauth`
--

-- --------------------------------------------------------

--
-- Table structure for table `football_match`
--

CREATE TABLE `football_match` (
  `id` int(11) NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `team1` varchar(255) DEFAULT NULL,
  `team2` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `football_match`
--

INSERT INTO `football_match` (`id`, `date`, `team1`, `team2`) VALUES
(2, '18/11/2021', 'Valencia', 'Liverpool'),
(3, '18/11/2021', 'Barcelona', 'Madrid'),
(11, '22/02/2021', 'Fiorentina', 'Sassuolo'),
(12, '04/03/2021', 'Genoa', 'AC Milan'),
(13, '12/05/2021', 'Hellas Verona', 'Sampdoria'),
(14, '26/05/2021', 'Internazionale', 'Napoli'),
(15, '14/01/2021', 'AEK Athens', 'Olympiakos'),
(73, '18/04/2021', 'Celta de Vigo', 'Villarreal');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(98),
(98);

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `id` int(11) NOT NULL,
  `fanid` int(11) DEFAULT NULL,
  `match_date` varchar(255) DEFAULT NULL,
  `matchid` int(11) DEFAULT NULL,
  `match_name` varchar(255) DEFAULT NULL,
  `paid` int(11) NOT NULL,
  `price` double NOT NULL,
  `user_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ticket`
--

INSERT INTO `ticket` (`id`, `fanid`, `match_date`, `matchid`, `match_name`, `paid`, `price`, `user_name`) VALUES
(57, 11, '18/11/2021', 2, 'Valencia vs. Liverpool', 1, 25.99, 'Mark'),
(58, 11, '18/11/2021', 3, 'Barcelona vs. Madrid', 1, 25.99, 'Mark'),
(59, 11, '22/02/2021', 11, 'Fiorentina vs. Sassuolo', 1, 25.99, 'Mark'),
(60, 11, '04/03/2021', 12, 'Genoa vs. AC Milan', 1, 25.99, 'Mark'),
(61, 11, '12/05/2021', 13, 'Hellas Verona vs. Sampdoria', 1, 25.99, 'Mark'),
(62, 8, '14/01/2021', 15, 'AEK Athens vs. Olympiakos', 1, 25.99, 'Whatever'),
(63, 8, '04/03/2021', 12, 'Genoa vs. AC Milan', 1, 25.99, 'Whatever'),
(64, 8, '26/05/2021', 14, 'Internazionale vs. Napoli', 1, 25.99, 'Whatever'),
(65, 8, '18/11/2021', 2, 'Valencia vs. Liverpool', 1, 25.99, 'Whatever'),
(67, 2, '14/01/2021', 15, 'AEK Athens vs. Olympiakos', 1, 25.99, 'admin'),
(68, 2, '12/05/2021', 13, 'Hellas Verona vs. Sampdoria', 1, 25.99, 'admin'),
(74, 8, '18/04/2021', 73, 'Celta de Vigo vs. Villarreal', 1, 25.99, 'Whatever'),
(75, 8, '22/02/2021', 11, 'Fiorentina vs. Sassuolo', 1, 25.99, 'Whatever'),
(77, 14, '18/11/2021', 3, 'Barcelona vs. Madrid', 1, 25.99, 'Kiavash'),
(80, 14, '18/11/2021', 3, 'Barcelona vs. Madrid', 1, 25.99, 'Kiavash'),
(81, 15, '26/05/2021', 14, 'Internazionale vs. Napoli', 1, 25.99, 'Whatever'),
(82, 15, '18/04/2021', 73, 'Celta de Vigo vs. Villarreal', 1, 25.99, 'Whatever'),
(83, 13, '18/11/2021', 2, 'Valencia vs. Liverpool', 1, 25.99, 'testuser'),
(85, 16, '18/11/2021', 3, 'Barcelona vs. Madrid', 1, 25.99, 'RAR'),
(86, 16, '18/11/2021', 2, 'Valencia vs. Liverpool', 1, 25.99, 'RAR'),
(88, 16, '18/11/2021', 2, 'Valencia vs. Liverpool', 1, 25.99, 'RAR'),
(89, 16, '14/01/2021', 15, 'AEK Athens vs. Olympiakos', 1, 25.99, 'RAR'),
(90, 16, '18/11/2021', 2, 'Valencia vs. Liverpool', 1, 25.99, 'RAR'),
(92, 17, '18/04/2021', 73, 'Celta de Vigo vs. Villarreal', 1, 25.99, 'zip'),
(93, 17, '04/03/2021', 12, 'Genoa vs. AC Milan', 1, 25.99, 'zip'),
(94, 19, '18/11/2021', 2, 'Valencia vs. Liverpool', 1, 25.99, 'test'),
(95, 19, '18/11/2021', 3, 'Barcelona vs. Madrid', 1, 25.99, 'test'),
(96, 19, '22/02/2021', 11, 'Fiorentina vs. Sassuolo', 1, 25.99, 'test');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `username`) VALUES
(1, 'jdoe@gmail.com', '$2a$10$2gK1WqjUaVSC3rht8rDNleLFn7Toiu3rkGN4wnMZVmZ21epWDbNdi', 'John Doe'),
(2, 'admin@fontys.com', '$2a$10$8/86elbvJP.u2r3k84x/8OTEL3fU2kq6mWloVtA1s.X1HCo8pYh/e', 'admin'),
(9, 'phee@gmail.com', '$2a$10$S.FftaHjT2aGDQvrRPD.zuwsYGsS3gkBLwZCI1XB3uJGVUcZ9k/cG', 'Phee'),
(13, 'testuser@cypresstest.com', '$2a$10$IsJKG3x./7yKwgEfB2KeCeg/nS1cB5qgeQOQXA2G6r1SuTA5qZk.2', 'testuser'),
(14, 'kiavash@fontys.nl', '$2a$10$gnDr8QWHcU1no8QqC3g5v.gm6f3mEdkAVb0y1rEAxSczd7Ui.OUve', 'Kiavash'),
(15, 'whatever@fontys.nl', '$2a$10$jn9Of4OPi6ioFreSTlswmupsHJCHsJH0rCqSqIH7o0H/J0f0Wh3Re', 'Whatever'),
(17, 'rar123@gmail.com', '$2a$10$Us6mX68xYcEhZ5Iv4ulcIOqjHDj.05lmMcqZ7ACXfCVgRCzVaeAlC', 'zip');

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 1),
(2, 2),
(9, 1),
(9, 2),
(13, 1),
(14, 1),
(15, 1),
(17, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `football_match`
--
ALTER TABLE `football_match`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`),
  ADD UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
