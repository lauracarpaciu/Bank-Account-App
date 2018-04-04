-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 03, 2018 at 07:59 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `banca`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `id` bigint(20) NOT NULL,
  `created_at` bigint(20) DEFAULT NULL,
  `last_modified` bigint(20) DEFAULT NULL,
  `account_number` varchar(255) DEFAULT NULL,
  `default_account` bit(1) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `addresses`
--

CREATE TABLE `addresses` (
  `id` bigint(20) NOT NULL,
  `created_at` bigint(20) DEFAULT NULL,
  `last_modified` bigint(20) DEFAULT NULL,
  `address_type` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `street1` varchar(255) DEFAULT NULL,
  `street2` varchar(255) DEFAULT NULL,
  `zip_code` int(11) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bankaccounts`
--

CREATE TABLE `bankaccounts` (
  `type_cpte` varchar(2) NOT NULL,
  `account_name` varchar(255) NOT NULL,
  `created_at` bigint(20) DEFAULT NULL,
  `last_modified` bigint(20) DEFAULT NULL,
  `balance` double NOT NULL,
  `taxes` double DEFAULT NULL,
  `discovered` double DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `cart_events`
--

CREATE TABLE `cart_events` (
  `id` bigint(20) NOT NULL,
  `created_at` bigint(20) DEFAULT NULL,
  `last_modified` bigint(20) DEFAULT NULL,
  `cart_event_type` varchar(255) DEFAULT NULL,
  `product_id` varchar(255) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `category_id` bigint(20) NOT NULL,
  `created_at` bigint(20) DEFAULT NULL,
  `last_modified` bigint(20) DEFAULT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `photo` longblob,
  `photo_name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `categories_products`
--

CREATE TABLE `categories_products` (
  `category_category_id` bigint(20) NOT NULL,
  `products_product_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `id` bigint(20) NOT NULL,
  `created_at` bigint(20) DEFAULT NULL,
  `last_modified` bigint(20) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `identity_card` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `employee_code` bigint(20) NOT NULL,
  `created_at` bigint(20) DEFAULT NULL,
  `last_modified` bigint(20) DEFAULT NULL,
  `employee_name` varchar(255) DEFAULT NULL,
  `employee_sup_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employees_groupes`
--

CREATE TABLE `employees_groupes` (
  `employee_employee_code` bigint(20) NOT NULL,
  `groupes_group_number` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `groups`
--

CREATE TABLE `groups` (
  `group_number` bigint(20) NOT NULL,
  `created_at` bigint(20) DEFAULT NULL,
  `last_modified` bigint(20) DEFAULT NULL,
  `group_name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `groups_employees`
--

CREATE TABLE `groups_employees` (
  `group_group_number` bigint(20) NOT NULL,
  `employees_employee_code` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `line_items`
--

CREATE TABLE `line_items` (
  `id` bigint(20) NOT NULL,
  `created_at` bigint(20) DEFAULT NULL,
  `last_modified` bigint(20) DEFAULT NULL,
  `price` double NOT NULL,
  `quantity` int(11) NOT NULL,
  `tax` double NOT NULL,
  `order_id` varchar(255) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `operation`
--

CREATE TABLE `operation` (
  `dtype` varchar(2) NOT NULL,
  `operation_number` bigint(20) NOT NULL,
  `created_at` bigint(20) DEFAULT NULL,
  `last_modified` bigint(20) DEFAULT NULL,
  `amount` double NOT NULL,
  `bank_account_id` varchar(255) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `order_id` varchar(255) NOT NULL,
  `created_at` bigint(20) DEFAULT NULL,
  `last_modified` bigint(20) DEFAULT NULL,
  `order_status` int(11) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  `address_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `order_events`
--

CREATE TABLE `order_events` (
  `id` varchar(255) NOT NULL,
  `created_at` bigint(20) DEFAULT NULL,
  `last_modified` bigint(20) DEFAULT NULL,
  `order_id` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `product_id` bigint(20) NOT NULL,
  `created_at` bigint(20) DEFAULT NULL,
  `last_modified` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `in_stock` bit(1) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `selected` bit(1) NOT NULL,
  `unit_price` double NOT NULL,
  `category_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id_role` bigint(20) NOT NULL,
  `name_role` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL,
  `created_at` bigint(20) DEFAULT NULL,
  `last_modified` bigint(20) DEFAULT NULL,
  `actived` bit(1) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `addresses`
--
ALTER TABLE `addresses`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKaf33clpk1s4svpok3x9egrvji` (`account_id`);

--
-- Indexes for table `bankaccounts`
--
ALTER TABLE `bankaccounts`
  ADD PRIMARY KEY (`account_name`),
  ADD KEY `FKb1n1yr25r9i5pppexl7910pwa` (`account_id`),
  ADD KEY `FK5lf98lyduf3rnjivnks7gs23x` (`customer_id`),
  ADD KEY `FKm3gn2fw56qon1xnepka0w4fe2` (`employee_id`);

--
-- Indexes for table `cart_events`
--
ALTER TABLE `cart_events`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_CART_EVENT_USER` (`id`,`user_id`);

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `categories_products`
--
ALTER TABLE `categories_products`
  ADD UNIQUE KEY `UK_g1g4fl8pt4xsutvejxvt02sqp` (`products_product_id`),
  ADD KEY `FK6aweqa9namwcbfpy2nc123g7x` (`category_category_id`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKor0fx9fttvasr4grtaqnltyrl` (`account_id`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`employee_code`),
  ADD KEY `FK7t6r7boyi3kj2rd4gee10f7qo` (`employee_sup_id`);

--
-- Indexes for table `employees_groupes`
--
ALTER TABLE `employees_groupes`
  ADD KEY `FK6tjh8biwae6uxg3kh2aikn231` (`groupes_group_number`),
  ADD KEY `FKls7g7xoue5h3ddehuhb7di4yy` (`employee_employee_code`);

--
-- Indexes for table `groups`
--
ALTER TABLE `groups`
  ADD PRIMARY KEY (`group_number`);

--
-- Indexes for table `groups_employees`
--
ALTER TABLE `groups_employees`
  ADD KEY `FKipceajh6li0ocxrq7c71eg87d` (`employees_employee_code`),
  ADD KEY `FKrpj6emfg4d7t50gn9kngqlor9` (`group_group_number`);

--
-- Indexes for table `line_items`
--
ALTER TABLE `line_items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcfmx8jqmqu18hhasfdf3w1m9u` (`order_id`),
  ADD KEY `FKb3hu7cw8o38248a3pr3o1aety` (`product_id`);

--
-- Indexes for table `operation`
--
ALTER TABLE `operation`
  ADD PRIMARY KEY (`operation_number`),
  ADD KEY `FKtdc3nirmiwwkcww3w5njmfs69` (`bank_account_id`),
  ADD KEY `FKfltgmsxwjb4g2ryd2qi69kuak` (`employee_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `FKagh5svlor3slbay6tq5wqor1o` (`account_id`),
  ADD KEY `FKhlglkvf5i60dv6dn397ethgpt` (`address_id`);

--
-- Indexes for table `order_events`
--
ALTER TABLE `order_events`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `FKog2rp4qthbtt2lfyhfo32lsw9` (`category_id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id_role`),
  ADD KEY `FK97mxvrajhkq19dmvboprimeg1` (`user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accounts`
--
ALTER TABLE `accounts`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `addresses`
--
ALTER TABLE `addresses`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `cart_events`
--
ALTER TABLE `cart_events`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `category_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `employee_code` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `groups`
--
ALTER TABLE `groups`
  MODIFY `group_number` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `line_items`
--
ALTER TABLE `line_items`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `operation`
--
ALTER TABLE `operation`
  MODIFY `operation_number` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `product_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `id_role` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
