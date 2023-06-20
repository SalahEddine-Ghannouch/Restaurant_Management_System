-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 21, 2021 at 09:08 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gestion_restaurant`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `Password_User` int(20) NOT NULL,
  `User_Id` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`Password_User`, `User_Id`) VALUES
(3300, 1000),
(3301, 4400),
(3301, 7777);

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `Code_Bill` int(8) NOT NULL,
  `Price_Bill` int(10) NOT NULL,
  `Code_Request` int(10) NOT NULL,
  `Id_Customer` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`Code_Bill`, `Price_Bill`, `Code_Request`, `Id_Customer`) VALUES
(1, 200, 1, 1),
(2, 44, 1, 1),
(123, 1000, 3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Id_Customer` int(8) NOT NULL,
  `Last_Name` varchar(20) NOT NULL,
  `Frist_Name` varchar(20) NOT NULL,
  `Address_Customer` varchar(60) NOT NULL,
  `Email_Customer` varchar(30) NOT NULL,
  `Phone_Customer` varchar(20) NOT NULL,
  `Id_Manager` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Id_Customer`, `Last_Name`, `Frist_Name`, `Address_Customer`, `Email_Customer`, `Phone_Customer`, `Id_Manager`) VALUES
(1, 'test', 'test', 'test', 'test', 'test', 1),
(1234, 'test', 'test', 'test', 'test', 'test', 1),
(3300, 'TEST', 'test', 'test', 'test', 'test', 1),
(3344, 'Mohamed', 'issa', 'Hanchane', 'test', '0637373783', 1),
(7777, 'ff', 'ff', 'ff', 'fff', 'fff', 1),
(12340, 'mohamed', 'issa', 'HANCHANE', 'test', '345345', 1);

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `Id_Employee` int(8) NOT NULL,
  `Last_Name` varchar(20) NOT NULL,
  `First_Name` varchar(20) NOT NULL,
  `Address_Employee` varchar(60) NOT NULL,
  `Email_Employee` varchar(30) NOT NULL,
  `Phone_Employee` varchar(20) NOT NULL,
  `Id_Manager` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`Id_Employee`, `Last_Name`, `First_Name`, `Address_Employee`, `Email_Employee`, `Phone_Employee`, `Id_Manager`) VALUES
(2222, 'kille', 'mohamed', 'hanchane', 'test', 'test', 1),
(3321, 'motaouakkel', 'adam', 'fes', 'adam@gmail.com', '0689165610', 1),
(3355, 'mohamed', 'issa', 'hanchane', 'test', '99999', 1),
(4400, 'test', 'test', 'test', 'test', 'test', 1);

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

CREATE TABLE `manager` (
  `Id_Manager` int(8) NOT NULL,
  `Last_Name` varchar(20) NOT NULL,
  `First_Name` varchar(20) NOT NULL,
  `Address_Manager` varchar(60) NOT NULL,
  `Email_Manager` varchar(30) NOT NULL,
  `Phone_Manager` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `manager`
--

INSERT INTO `manager` (`Id_Manager`, `Last_Name`, `First_Name`, `Address_Manager`, `Email_Manager`, `Phone_Manager`) VALUES
(1, 'khalil', 'karima', 'essaouira', 'karima0gmail.com', '0607540643'),
(2, 'ghann', 'salah', 'elhanchane', 'salah@?com', '636353');

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `Code_Menu` int(8) NOT NULL,
  `Description_Menu` varchar(200) NOT NULL,
  `Content_Menu` varchar(100) NOT NULL,
  `Title_Menu` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`Code_Menu`, `Description_Menu`, `Content_Menu`, `Title_Menu`) VALUES
(1, 'vvv', 'vvv', 'vvv'),
(334, 'good', 'milk ', 'drinks');

-- --------------------------------------------------------

--
-- Table structure for table `request`
--

CREATE TABLE `request` (
  `Code_Request` int(8) NOT NULL,
  `Date_Request` date NOT NULL,
  `Content` varchar(500) NOT NULL,
  `Total_Price` varchar(20) NOT NULL,
  `Id_Customer` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `request`
--

INSERT INTO `request` (`Code_Request`, `Date_Request`, `Content`, `Total_Price`, `Id_Customer`) VALUES
(0, '2020-03-03', '', '', 1),
(2, '2001-03-03', 'test', '20', 1),
(3, '2020-03-03', '', '', 1),
(4, '2020-03-03', 'Milk', '0', 1),
(5, '2020-04-03', 'mikl', '0', 1),
(6, '2020-03-03', ' - Wine - Coffee - Iced tea - Tea - Meatball - Fish', '358', 1),
(7, '2020-01-01', ' - Milkshake', '30', 3300),
(8, '2020-01-02', ' - Milkshake - Water - Pork - Seafood', '355', 7777),
(9, '2020-01-03', ' - Lemonade - Milk - Fish', '232', 1);

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

CREATE TABLE `test` (
  `code` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `test`
--

INSERT INTO `test` (`code`) VALUES
(2234);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`User_Id`);

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`Code_Bill`),
  ADD KEY `Id_Customer` (`Id_Customer`),
  ADD KEY `bill_ibfk_1` (`Code_Request`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Id_Customer`),
  ADD KEY `Id_Manager` (`Id_Manager`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`Id_Employee`);

--
-- Indexes for table `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`Id_Manager`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`Code_Menu`);

--
-- Indexes for table `request`
--
ALTER TABLE `request`
  ADD PRIMARY KEY (`Code_Request`),
  ADD KEY `request_ibfk_1` (`Id_Customer`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`Id_Manager`) REFERENCES `manager` (`Id_Manager`);

--
-- Constraints for table `request`
--
ALTER TABLE `request`
  ADD CONSTRAINT `request_ibfk_1` FOREIGN KEY (`Id_Customer`) REFERENCES `customer` (`Id_Customer`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
