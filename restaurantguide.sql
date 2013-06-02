-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 28, 2013 at 06:51 PM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `restaurantguide`
--

-- --------------------------------------------------------

--
-- Table structure for table `hotels`
--

CREATE TABLE IF NOT EXISTS `hotels` (
  `hotel_id` int(11) NOT NULL,
  `hotel_name` varchar(30) NOT NULL,
  `hotel_address` varchar(45) NOT NULL,
  `hotel_phone` varchar(15) NOT NULL,
  `hotel_opening_time` varchar(15) NOT NULL,
  PRIMARY KEY (`hotel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hotels`
--

INSERT INTO `hotels` (`hotel_id`, `hotel_name`, `hotel_address`, `hotel_phone`, `hotel_opening_time`) VALUES
(1, 'Alice Restaurant', 'Gairidhara, Kathmandu', '01-4429207', '12 AM To 10 PM'),
(2, 'Asian Village Restaurant ', 'Lazimpat, Kathmandu', '01-4417506', '8 AM To 9 PM'),
(3, 'A Cafe & Lounge', 'Dhobighat, Lalitpur', '01-5543966', '12 AM To 11 PM'),
(4, 'Bajeko Sekuwa', 'Anamnagar, Kathmandu', '01-4224061', '9 AM To 11 PM'),
(5, 'Baithak Restaurant', 'Maitighar, Kathmandu', '01-4267346', '10 AM to 10 PM'),
(6, 'Bajeko Sekuwa', 'Battisputali, Kathmandu', ' 01-4492130', '9 AM to 11 PM'),
(7, 'Bawarchi: The Restro-Bar', 'Lainchaur/Lazimpat, Kathmandu', '01- 4436673', '11 AM to 10 PM'),
(8, ' Bok Choy Restaurant', 'Putalisadak, Kathmandu', '01-4216837', '10 AM to 9 PM'),
(9, 'Cafe De Patan', 'Patan Darbar Square, Lalitpur', '01-5537599', '8 AM to 9 PM'),
(10, 'Cafe` Olla Restaurant & Bar', 'Jamal, Kathmandu', ' 01-2010565', '9 AM to 9:30 PM');

-- --------------------------------------------------------

--
-- Table structure for table `hotel_geocode`
--

CREATE TABLE IF NOT EXISTS `hotel_geocode` (
  `hotel_id` int(11) NOT NULL,
  `latitude` decimal(8,6) NOT NULL,
  `longitude` decimal(8,6) NOT NULL,
  PRIMARY KEY (`hotel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hotel_geocode`
--

INSERT INTO `hotel_geocode` (`hotel_id`, `latitude`, `longitude`) VALUES
(1, 27.717058, 85.315948),
(2, 27.717031, 85.316078),
(3, 27.676831, 85.302057),
(4, 27.693506, 85.327563),
(5, 27.693824, 85.321409),
(6, 27.706534, 85.342773),
(7, 27.717054, 85.316055),
(8, 27.705136, 85.322791),
(9, 27.673901, 85.325414),
(10, 27.708827, 85.315276);

-- --------------------------------------------------------

--
-- Table structure for table `menu_complete`
--

CREATE TABLE IF NOT EXISTS `menu_complete` (
  `hotel_id` int(11) NOT NULL,
  `item_name` varchar(40) NOT NULL,
  `item_price` decimal(5,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `menu_complete`
--

INSERT INTO `menu_complete` (`hotel_id`, `item_name`, `item_price`) VALUES
(1, 'Nasi Gorang', 225.00),
(1, 'Nachos Chicken', 260.00),
(1, 'Chicken Buckwheat Momo', 150.00),
(1, 'Squid Chilly', 340.00),
(1, 'Salmon Sashimi', 420.00),
(1, 'Tuna Maski', 260.00),
(2, 'Sauted or Steam Corn', 105.00),
(2, 'Roast Chicken with Sezuwan Sauce', 355.00),
(2, 'Prawn Tempura', 445.00),
(2, 'Prawn Masala', 350.00),
(2, 'Chicken Titta', 225.00),
(2, 'Mixed Pizza', 275.00),
(3, 'Prawns Chilli', 398.00),
(3, 'Paneer Chatpatta', 142.00),
(3, 'Chana Chatpatta', 66.00),
(3, 'Whole Tandoori Pomfret', 319.00),
(3, 'Mutton Phadi Kabab', 310.00),
(3, 'Murg Achari', 204.00),
(4, 'Rajkhani Sekuwa', 135.00),
(4, 'Sandeko Sekuwa', 165.00),
(4, 'Fish Sekuwa', 185.00),
(4, 'Mutton Feela Sandeko', 195.00),
(4, 'Lasun Sandeko', 75.00),
(4, 'Mixed Chatamari', 175.00),
(5, 'Bandel Boiled', 320.00),
(5, 'Sukuti', 425.00),
(5, 'Chhowela Mutton', 260.00),
(5, 'Kaju Tareko', 400.00),
(5, 'Chatamari Chicken', 260.00),
(5, 'SamayBaji', 260.00),
(5, 'Sekuwa Mutton', 320.00),
(5, 'Sekuwa Vegetable', 320.00),
(6, 'Mutton Feela Sandeko', 195.00),
(6, 'Laasun Sandeko', 75.00),
(6, 'Fish Finger (Bekti)', 165.00),
(6, 'Rajkhani Sekuwa', 135.00),
(6, 'Sandeko Sekuwa', 165.00),
(6, 'Fish Sekuwa', 185.00),
(6, 'Mixed Chatamari', 175.00),
(6, 'Jhaneko Hyakula', 190.00),
(7, 'Y2K (Egg Veg) Roll', 105.00),
(7, 'Bawarchi Special Roll', 260.00),
(7, 'Arabian Tandoori Chicken', 675.00),
(7, 'Achari Fish Kabab', 380.00),
(7, 'Aloo Jeera ''W'' Peanuts', 200.00),
(7, 'Chicken Biryani', 350.00),
(7, 'Hyderabadi Mutton Biryani', 475.00),
(7, 'American Chopsuey Chicken', 320.00),
(8, 'Beijing Style Chicken Wings (Regular)', 145.00),
(8, 'Chicken Chilli (Regular)', 175.00),
(8, 'Chicken In Chain (Regular)', 195.00),
(8, 'Mutton Choyala In Chinese Style (Regular', 250.00),
(8, 'Chicken In Chain (Regular)', 195.00),
(8, 'Mutton Choyala In Chinese Style', 250.00),
(8, 'Mutton In Chain (Regular)', 250.00),
(8, 'Fish With Oyster Chilli (Regular)', 190.00),
(8, 'Pork With Chilli Corriander (Large)', 275.00),
(8, 'Golden Fried Prawn (Regular)', 295.00),
(9, 'Ginger Prawn', 380.00),
(9, 'Banana Sandwich', 110.00),
(9, '(Cafe''s Special) All Mixed Pizza', 280.00),
(9, 'Roast Chicken Sizzler', 260.00),
(9, 'Mushroom Bamboo Shoot', 180.00),
(9, 'Chicken Chatanmari', 110.00),
(9, 'Baji (Set)', 350.00),
(9, 'Musiya Palu', 60.00),
(10, 'Buff Hakka Noodles', 145.00),
(10, 'Chicken Biryani', 250.00),
(10, 'Aloo Gobi', 140.00),
(10, 'Bandel Chilly', 320.00),
(10, 'Cheese Pizza (Regular)', 260.00),
(10, 'Chicken Chowmein', 155.00),
(10, 'Chicken Burger', 175.00),
(10, 'Chicken C'' Momo (Steam)', 175.00);

-- --------------------------------------------------------

--
-- Table structure for table `menu_preview`
--

CREATE TABLE IF NOT EXISTS `menu_preview` (
  `hotel_id` int(11) NOT NULL,
  `cusine` varchar(50) NOT NULL,
  `speciality` varchar(50) NOT NULL,
  PRIMARY KEY (`hotel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `menu_preview`
--

INSERT INTO `menu_preview` (`hotel_id`, `cusine`, `speciality`) VALUES
(1, 'Japanese, Thakali, Chinese, Continental', 'Japanese, Thakali'),
(2, 'Multi-Cusine', 'Chicken Chhoyala, Sauted or Steam Corn'),
(3, 'Multi-Cusine, Continental', 'Indian'),
(4, 'Nepali, Chinese, Continental', 'Sekuwa'),
(5, 'Nepali', 'Sukuti'),
(6, 'Nepali, Chinese, Continental', 'Sekuwa'),
(7, 'Indian/Chines/Calcutta/Tangra Style Chinese', 'Biryani,Rolls & Kababs'),
(8, 'Chinese', 'Chicken In Chain, Fried Corn,Chicken'),
(9, 'Multi-cuisine (with Nepali & Newari Special)', 'Newari, Nepali Foods'),
(10, 'Indian,Chinese,Nepalese', 'Pizza,Special Chicken,Shanghai & Korean Chicken');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `foodItem` varchar(50) NOT NULL,
  `telephone` varchar(15) NOT NULL,
  `encrypted_password` varchar(80) NOT NULL,
  `salt` varchar(30) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `users`
--

