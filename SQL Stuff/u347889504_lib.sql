-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 01, 2018 at 12:29 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `u347889504_lib`
--

-- --------------------------------------------------------

--
-- Table structure for table `book_class`
--

CREATE TABLE `book_class` (
  `book_uid` varchar(500) NOT NULL,
  `book_name` varchar(500) NOT NULL,
  `book_author` varchar(500) NOT NULL,
  `book_rating` varchar(500) NOT NULL,
  `book_length` varchar(500) NOT NULL,
  `book_cover_url` varchar(500) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `current_shelf`
--

CREATE TABLE `current_shelf` (
  `user_uid` varchar(500) NOT NULL,
  `book_uid` varchar(500) NOT NULL,
  `added_on` varchar(500) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `fav_shelf`
--

CREATE TABLE `fav_shelf` (
  `user_uid` varchar(500) NOT NULL,
  `book_uid` varchar(500) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `read_shelf`
--

CREATE TABLE `read_shelf` (
  `user_uid` varchar(500) NOT NULL,
  `book_uid` varchar(500) NOT NULL,
  `added_on` varchar(500) NOT NULL,
  `completed_on` varchar(500) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `to_read_shelf`
--

CREATE TABLE `to_read_shelf` (
  `user_uid` varchar(500) NOT NULL,
  `book_uid` varchar(500) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_uid` varchar(500) NOT NULL,
  `user_username` varchar(500) NOT NULL,
  `user_password` varchar(500) NOT NULL,
  `user_joined_on` varchar(500) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_uid`, `user_username`, `user_password`, `user_joined_on`) VALUES
('user_Gh6dfgRKMm', 'test_username', 'test_password', '01//03/2018');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book_class`
--
ALTER TABLE `book_class`
  ADD PRIMARY KEY (`book_uid`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_uid`),
  ADD UNIQUE KEY `user_username` (`user_username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
