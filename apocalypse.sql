-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 25, 2022 at 07:11 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `apocalypse`
--

-- --------------------------------------------------------

--
-- Table structure for table `contamination`
--

CREATE TABLE `contamination` (
  `ID_contamination` int(11) NOT NULL,
  `reporter_id` int(11) NOT NULL,
  `survivor_id` int(11) NOT NULL,
  `reported_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `contamination`
--

INSERT INTO `contamination` (`ID_contamination`, `reporter_id`, `survivor_id`, `reported_at`) VALUES
(13, 3, 2, '2022-03-24 21:36:37'),
(14, 4, 2, '2022-03-25 10:42:34'),
(15, 5, 2, '2022-03-25 10:42:40'),
(16, 5, 7, '2022-03-25 10:42:48'),
(17, 1, 7, '2022-03-25 10:42:52'),
(21, 3, 19, '2022-03-25 12:36:26'),
(22, 7, 19, '2022-03-25 12:36:33'),
(23, 37, 19, '2022-03-25 12:36:57');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(24);

-- --------------------------------------------------------

--
-- Table structure for table `resource`
--

CREATE TABLE `resource` (
  `ID_resource` int(11) NOT NULL,
  `survivor_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `survivor`
--

CREATE TABLE `survivor` (
  `ID_survivor` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` varchar(255) DEFAULT NULL,
  `gender` enum('Male','Female') NOT NULL,
  `latitude` varchar(255) NOT NULL,
  `longitude` varchar(255) NOT NULL,
  `infected` varchar(255) NOT NULL,
  `date_created` varchar(255) DEFAULT current_timestamp(),
  `date_updated` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `survivor`
--

INSERT INTO `survivor` (`ID_survivor`, `name`, `age`, `gender`, `latitude`, `longitude`, `infected`, `date_created`, `date_updated`) VALUES
(8, 'fred', '10', 'Female', '993848', '488483', 'Yes', '2022-03-24 17:30:10', NULL),
(18, 'Steven', '31', 'Male', '993848', '488483', 'No', '2022-03-25 12:27:14', NULL),
(19, 'Grace', '27', 'Female', '993848', '488483', 'No', '2022-03-25 12:27:27', NULL),
(20, 'Diana', '28', 'Female', '993848', '488483', 'No', '2022-03-25 12:27:36', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contamination`
--
ALTER TABLE `contamination`
  ADD PRIMARY KEY (`ID_contamination`);

--
-- Indexes for table `resource`
--
ALTER TABLE `resource`
  ADD PRIMARY KEY (`ID_resource`);

--
-- Indexes for table `survivor`
--
ALTER TABLE `survivor`
  ADD PRIMARY KEY (`ID_survivor`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `contamination`
--
ALTER TABLE `contamination`
  MODIFY `ID_contamination` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `resource`
--
ALTER TABLE `resource`
  MODIFY `ID_resource` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `survivor`
--
ALTER TABLE `survivor`
  MODIFY `ID_survivor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
