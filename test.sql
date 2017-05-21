-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 21, 2017 at 03:43 PM
-- Server version: 5.1.37
-- PHP Version: 5.3.0

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `groupnames`
--

CREATE TABLE IF NOT EXISTS `groupnames` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `groupName` varchar(50) NOT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `groupnames`
--

INSERT INTO `groupnames` (`group_id`, `groupName`) VALUES
(1, 'A'),
(2, 'GroupA'),
(3, 'GroupB'),
(4, 'Groupc'),
(5, 'GroupD'),
(6, '2');

-- --------------------------------------------------------

--
-- Table structure for table `match_details`
--

CREATE TABLE IF NOT EXISTS `match_details` (
  `match_id` int(11) NOT NULL AUTO_INCREMENT,
  `homeTeam` varchar(50) NOT NULL,
  `awayTeam` varchar(50) NOT NULL,
  `groupName` varchar(50) NOT NULL,
  `timE` varchar(50) NOT NULL,
  `datE` varchar(50) NOT NULL,
  PRIMARY KEY (`match_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `match_details`
--

INSERT INTO `match_details` (`match_id`, `homeTeam`, `awayTeam`, `groupName`, `timE`, `datE`) VALUES
(1, 'Brazil', 'China', 'A', '23rd MARCH 2018', '1400'),
(2, 'Kenya', 'Uganda', 'A', '1500', '23rd March 2018');

-- --------------------------------------------------------

--
-- Table structure for table `match_results`
--

CREATE TABLE IF NOT EXISTS `match_results` (
  `results_id` int(11) NOT NULL AUTO_INCREMENT,
  `homeTeam` varchar(50) NOT NULL,
  `homeTeamGoals` int(11) NOT NULL,
  `awayTeam` varchar(50) NOT NULL,
  `awayTeamGoals` int(11) NOT NULL,
  PRIMARY KEY (`results_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `match_results`
--

INSERT INTO `match_results` (`results_id`, `homeTeam`, `homeTeamGoals`, `awayTeam`, `awayTeamGoals`) VALUES
(1, 'Brazil', 3, 'China', 1),
(2, 'Brazil', 2, 'Colombia', 0),
(3, 'Brazil', 3, 'Spain', 3),
(4, 'Brazil', 2, 'Colombia', 4),
(5, 'Colombia', 4, 'Spain', 3),
(6, 'spain', 2, 'china', 0),
(7, 'Brazil', 3, 'china', 1),
(8, 'brazil', 1, 'chile', 1),
(9, 'spain', 2, 'brazil', 3);

-- --------------------------------------------------------

--
-- Table structure for table `team`
--

CREATE TABLE IF NOT EXISTS `team` (
  `team_id` int(11) NOT NULL AUTO_INCREMENT,
  `countryName` varchar(50) NOT NULL,
  `groupName` varchar(50) NOT NULL,
  `seq_in_group` int(11) NOT NULL,
  `points` int(50) NOT NULL,
  `goals` int(50) NOT NULL,
  `match_played` int(50) NOT NULL,
  PRIMARY KEY (`team_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `team`
--

INSERT INTO `team` (`team_id`, `countryName`, `groupName`, `seq_in_group`, `points`, `goals`, `match_played`) VALUES
(1, 'Brazil', 'A', 1, 7, 7, 3),
(2, 'China', 'A', 2, 0, 1, 1),
(3, 'Chile', 'A', 3, 1, 1, 1),
(4, 'Spain', 'A', 4, 0, 2, 1);

-- --------------------------------------------------------



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
