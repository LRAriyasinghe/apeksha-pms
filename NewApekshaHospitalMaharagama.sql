-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 06, 2018 at 07:40 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 5.6.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `NewApekshaHospitalMaharagama`
--

-- --------------------------------------------------------

--
-- Table structure for table `Admin`
--

CREATE TABLE `Admin` (
  `emp_id` int(11) NOT NULL,
  `grade` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Admin`
--

INSERT INTO `Admin` (`emp_id`, `grade`) VALUES
(1, NULL),
(5, 'A'),
(7, 'A');

-- --------------------------------------------------------

--
-- Table structure for table `adminMessage`
--

CREATE TABLE `adminMessage` (
  `id` int(11) NOT NULL,
  `message` varchar(100) NOT NULL,
  `date` datetime NOT NULL,
  `Employee_emp_Id` int(11) NOT NULL,
  `status` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `adminMessage`
--

INSERT INTO `adminMessage` (`id`, `message`, `date`, `Employee_emp_Id`, `status`) VALUES
(1, 'Forgot My Password', '2017-12-12 00:00:00', 1, 'Read'),
(2, 'sknkf', '2017-12-05 00:00:00', 2, 'Read'),
(3, 'Forgot Password', '2017-12-06 00:00:00', 3, 'Read'),
(4, 'Forgote pw', '2017-12-12 00:00:00', 1, 'Read'),
(5, 'Forgot my passsword', '2017-12-12 00:00:00', 1, 'Read'),
(6, 'forgor my pw', '2017-12-12 00:00:00', 1, 'Unread'),
(7, 'Forgot My Pw', '2017-12-13 00:00:00', 2, 'Read');

-- --------------------------------------------------------

--
-- Table structure for table `bonemarrow_report`
--

CREATE TABLE `bonemarrow_report` (
  `id` int(11) NOT NULL,
  `TestID` int(11) NOT NULL,
  `Patient_Id` int(11) NOT NULL,
  `BMBx` varchar(45) DEFAULT NULL,
  `TrepchineBMBx` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bonemarrow_report`
--

INSERT INTO `bonemarrow_report` (`id`, `TestID`, `Patient_Id`, `BMBx`, `TrepchineBMBx`) VALUES
(1, 1, 1, '23', '23');

-- --------------------------------------------------------

--
-- Table structure for table `Chest`
--

CREATE TABLE `Chest` (
  `chest_Id` int(11) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `examination_Exam_Id` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Consult`
--

CREATE TABLE `Consult` (
  `exam_Id` varchar(30) NOT NULL,
  `patient_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Consultant`
--

CREATE TABLE `Consultant` (
  `specialise_Area` varchar(250) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `emp_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Consultant`
--

INSERT INTO `Consultant` (`specialise_Area`, `emp_Id`) VALUES
(NULL, 3);

-- --------------------------------------------------------

--
-- Table structure for table `c_reactiveprotein_report`
--

CREATE TABLE `c_reactiveprotein_report` (
  `id` int(11) NOT NULL,
  `Testid` int(11) NOT NULL,
  `Patient_Id` int(11) NOT NULL,
  `c_reactive` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Employee`
--

CREATE TABLE `Employee` (
  `emp_Id` int(11) NOT NULL,
  `title` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `door_No` varchar(15) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `district` varchar(45) NOT NULL,
  `nic_No` varchar(20) NOT NULL,
  `contact_No` varchar(15) DEFAULT NULL,
  `bank` varchar(100) DEFAULT NULL,
  `Branch` varchar(100) DEFAULT NULL,
  `department` varchar(150) DEFAULT NULL,
  `type` varchar(100) NOT NULL,
  `dob` date NOT NULL,
  `bank_acc_no` varchar(20) DEFAULT NULL,
  `grade` varchar(45) DEFAULT NULL,
  `address` varchar(60) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `Date_Joined` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `state` varchar(45) DEFAULT '1',
  `reson` varchar(45) DEFAULT NULL,
  `del_date_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Employee`
--

INSERT INTO `Employee` (`emp_Id`, `title`, `firstName`, `lastName`, `door_No`, `street`, `city`, `district`, `nic_No`, `contact_No`, `bank`, `Branch`, `department`, `type`, `dob`, `bank_acc_no`, `grade`, `address`, `gender`, `Date_Joined`, `state`, `reson`, `del_date_time`) VALUES
(1, 'Mr', 'Saman', 'Kumara', '003', 'Kolonna', 'Embilipitiya', 'Ratnapura', '920230420V', '0715916091', 'Peoples Bank', 'embilipitiya', 'Dental', 'Admin', '2017-12-01', '232432', 'A', 'Medawathhtha, Pitakanda, Bulutota', 'Male', '2017-12-11 20:33:38', '1', NULL, NULL),
(2, 'Mr', 'Thilina', 'Chamika', '001', 'Bella', 'Kahawaththa', 'Colombo', '3176453', '63897684968', 'BOC', 'Kahawaththa', 'Nurse', 'Register Doctor', '2017-12-03', '364531', 'B', 'Bulutota', 'Male', '2017-12-11 20:36:28', '1', NULL, NULL),
(3, 'Mrs', 'Sayer', 'Hansamali', '002', 'Wijerama', 'Colombo', 'Colombo', '23443254', '3425445', 'Commercial', 'Nugegoda', 'Head', 'Consultant Doctor', '2017-12-06', '3465723', 'B', 'Kolonna,Panamura', 'Female', '2017-12-11 20:38:37', '1', NULL, NULL),
(4, 'Miss', 'Hans ini', 'Inrdachapa', '004', 'Kuttigala', 'Padalangala', 'Galle', '256463523', '234656725', 'Peoples Bank', 'Kahawaththa', 'Medicin', 'Lab Assistant', '2017-11-06', '34586573', 'C', 'Kohila Pitiya', 'Female', '2017-12-11 20:41:05', '1', NULL, NULL),
(5, 'Mr', 'Sampath', 'Chathuranga', 'afds', 'Pitakanda', 'Embilipitiya', 'Ratnapura', '940230420V', '0715916092', 'BOC', 'Embilipitiya', 'Dental', 'Admin', '2017-12-05', '83645473745', 'A', 'Medawaththa, Pitakanda,Bulutota.', 'Male', '2017-12-12 02:09:06', '1', NULL, NULL),
(6, 'Mr', 'Saman', 'Kumara', 'wede', 'Kolonna', 'Embilipitiya', 'Ratnapura', '345678976V', '0715916091', 'BOC', 're', 'Dental', 'Register Doctor', '2017-12-11', '34555', 'A', 'Kolonna', 'Male', '2017-12-12 14:00:37', '1', NULL, NULL),
(7, 'Mr', 'Saman', 'Kumara', 'sede', 'kolonna', 'Embilipitiya', 'Ratnapura', '940230420V', '0715916091', 'BOC', 'Embiliptiya', 'Dental', 'Admin', '2017-12-05', '876543', 'A', 'Medawaththa', 'Male', '2017-12-13 15:41:35', '1', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `Examination`
--

CREATE TABLE `Examination` (
  `exam_Id` varchar(30) NOT NULL,
  `examType` varchar(45) NOT NULL,
  `consultant_emp_Id` varchar(30) NOT NULL,
  `patient_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Examine`
--

CREATE TABLE `Examine` (
  `test_Id` int(11) NOT NULL,
  `Consultant_emp_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `fullblood_report`
--

CREATE TABLE `fullblood_report` (
  `id` int(11) NOT NULL,
  `Testid` int(11) NOT NULL,
  `Patient_Id` int(11) NOT NULL,
  `WBC` varchar(45) DEFAULT NULL,
  `NE` varchar(45) DEFAULT NULL,
  `Himoglobin` varchar(45) DEFAULT NULL,
  `Platlets` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `General`
--

CREATE TABLE `General` (
  `general_Id` int(11) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `examination_exam_Id` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `LabAssistaant`
--

CREATE TABLE `LabAssistaant` (
  `grade` varchar(50) DEFAULT NULL,
  `emp_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `LabAssistaant`
--

INSERT INTO `LabAssistaant` (`grade`, `emp_Id`) VALUES
(NULL, 4);

-- --------------------------------------------------------

--
-- Table structure for table `lipidprofile_report`
--

CREATE TABLE `lipidprofile_report` (
  `id` int(11) NOT NULL,
  `Testid` int(11) NOT NULL,
  `Patient_ID` int(11) NOT NULL,
  `Serum_Cholostrol` varchar(45) DEFAULT NULL,
  `Serum_Triglycer` varchar(45) DEFAULT NULL,
  `HDL` varchar(45) DEFAULT NULL,
  `LDL` varchar(45) DEFAULT NULL,
  `VLDL` varchar(45) DEFAULT NULL,
  `CHOL` varchar(45) DEFAULT NULL,
  `LDLHDL` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `liverfunction_report`
--

CREATE TABLE `liverfunction_report` (
  `id` int(11) NOT NULL,
  `Testid` int(11) NOT NULL,
  `Patient_ID` int(11) NOT NULL,
  `Serum_Bilrubin` varchar(45) DEFAULT NULL,
  `SGPT` varchar(45) DEFAULT NULL,
  `SGOT` varchar(45) DEFAULT NULL,
  `Serum_Alkaline` varchar(45) DEFAULT NULL,
  `Serum_Creatinine` varchar(45) DEFAULT NULL,
  `Serum_Calcium` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE `messages` (
  `id` int(11) NOT NULL,
  `message` varchar(200) NOT NULL,
  `sendDate` datetime NOT NULL,
  `status` varchar(15) NOT NULL,
  `workedstatus` varchar(100) DEFAULT NULL,
  `receivedDate` datetime NOT NULL,
  `Consultant_emp_Id` int(11) NOT NULL,
  `patient_Id` int(11) NOT NULL,
  `labAssistant_emp_id` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `messages`
--

INSERT INTO `messages` (`id`, `message`, `sendDate`, `status`, `workedstatus`, `receivedDate`, `Consultant_emp_Id`, `patient_Id`, `labAssistant_emp_id`) VALUES
(3, 'dkshndfhbs', '2017-12-11 00:00:00', 'Read', 'Check', '2017-12-13 00:00:00', 3, 1, '4'),
(4, 'efedf', '2017-12-09 00:00:00', 'Read', 'checked', '2017-12-12 00:00:00', 3, 1, '23'),
(5, 'yes', '2017-12-13 00:00:00', 'Read', 'ok', '2017-12-13 00:00:00', 3, 1, '4'),
(6, 'check', '2017-12-13 00:00:00', 'Unread', '', '0000-00-00 00:00:00', 3, 1, '');

-- --------------------------------------------------------

--
-- Table structure for table `NonSystemEmployee`
--

CREATE TABLE `NonSystemEmployee` (
  `id` int(11) NOT NULL,
  `type` varchar(100) DEFAULT NULL,
  `emp_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Organ`
--

CREATE TABLE `Organ` (
  `oragan_ID` int(11) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `examination_exam_Id` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Patient`
--

CREATE TABLE `Patient` (
  `patient_Id` int(11) NOT NULL,
  `title` varchar(500) DEFAULT NULL,
  `first_name` varchar(60) DEFAULT NULL,
  `last_name` varchar(60) DEFAULT NULL,
  `nic_No` varchar(15) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `gender` varchar(10) NOT NULL,
  `occupation` varchar(100) DEFAULT NULL,
  `civil_Status` varchar(500) DEFAULT NULL,
  `contact_No` varchar(15) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `district` varchar(60) DEFAULT NULL,
  `additional_Details` varchar(800) DEFAULT NULL,
  `state` int(11) NOT NULL DEFAULT '1',
  `reson` varchar(45) DEFAULT NULL,
  `del_date_time` datetime DEFAULT NULL,
  `Date_Joined` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `cancer_type` varchar(45) DEFAULT NULL,
  `RegisterDoctor_emp_Id` int(11) NOT NULL,
  `Consultant_emp_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Patient`
--

INSERT INTO `Patient` (`patient_Id`, `title`, `first_name`, `last_name`, `nic_No`, `dob`, `gender`, `occupation`, `civil_Status`, `contact_No`, `address`, `city`, `district`, `additional_Details`, `state`, `reson`, `del_date_time`, `Date_Joined`, `cancer_type`, `RegisterDoctor_emp_Id`, `Consultant_emp_Id`) VALUES
(1, 'Mr', 'Thilina', 'Chamika', '940230420V', '2017-12-03', 'Male', 'Student', 'Married', '0715916092', 'Medawaththa,Pitakanda,Bulutota', 'Embilipitiya', 'Vavuniya', 'No', 1, NULL, NULL, '2017-12-12 01:08:48', NULL, 2, 3),
(2, 'Mr', 'Saman', 'Kumara', '930230420V', '2017-12-02', 'Male', 'Farmer', 'Married', '0715916092', 'Medawaththa,Pitakanda,Bulutota', 'Rathnapura', 'Colombo', 'No', 1, NULL, NULL, '2017-12-12 01:10:09', NULL, 2, 3),
(4, 'Mr', 'lasagnahgh', 'saman', '333333333V', '2017-12-12', 'Male', 'ni', 'married', '987656423', 'sfcsd', 'sfsfcs', 'Colombo', 'sd', 1, 'sc', '2015-12-14 00:00:00', '2017-12-12 13:19:51', 'Lung', 2, 3),
(206, 'Mr', 'sampath', 'yanaka', '930230420V', '2017-12-13', 'Female', 'Student', 'Single', '0778952135', 'Medawaththa', 'Embilipitiya', 'Ratnapura', 'no', 1, '', '0000-00-00 00:00:00', '2017-12-13 00:00:00', 'Lung', 6, 3),
(207, 'Mr', 'sman', 'Pishpa', '234567865V', '2017-12-12', 'Male', 'Farmer', 'Single', '0778952135', 'Kolonna', 'Nugegoda', 'Colombo', 'Null', 1, '', '0000-00-00 00:00:00', '2017-12-13 00:00:00', 'Lung', 6, 3),
(410, 'Honorable', 'nimal', 'kureee', '0333564294', '2017-06-30', 'Male', 'teacher', 'single', '756-627-3630', '2,ain street kohuwala', 'kaduruwa', 'Colombo', 'father cancered', 1, NULL, NULL, '2017-01-12 00:00:00', 'bladder', 2, 3),
(411, 'Mrs', 'kamal', 'perera', '8732182651', '2017-08-02', 'Female', 'driver', 'married', '299-499-9021', 'no3,brown street nugegode', 'Matara', 'Kurunegala', 'chewing beetle', 1, NULL, NULL, '2016-06-13 00:00:00', 'Breast', 2, 3),
(412, 'Ms', 'kamal', 'silva', '6997382940', '2017-06-15', 'Male', 'teacher', 'married', '618-800-0547', 'attanayakegoda, bandarawela', 'nuwara', 'Matara', 'father cancered', 1, NULL, NULL, '2017-03-30 00:00:00', 'bladder', 2, 3),
(413, 'Honorable', 'suneera', 'dissanayake', '7217394813', '2017-05-07', 'Female', 'watcher', 'single', '679-794-1284', '2,ain street kohuwala', 'Matara', 'Matara', 'mother cancered', 1, NULL, NULL, '2016-09-21 00:00:00', 'leukaemia', 2, 3),
(414, 'Dr', 'wasana', 'kureee', '0894049836', '2017-11-17', 'Male', 'nurse', 'married', '744-478-9978', '2,ain street kohuwala', 'yatiyana', 'Colombo', 'mother cancered', 1, NULL, NULL, '2016-04-02 00:00:00', 'prostate', 2, 3),
(415, 'Honorable', 'saman', 'kureee', '5153093182', '2017-01-02', 'Male', 'nurse', 'married', '280-603-0165', '2,ain street kohuwala', 'seeduwa', 'Colombo', 'long smoking', 1, NULL, NULL, '2016-04-24 00:00:00', 'prostate', 2, 3),
(416, 'Rev', 'thameera', 'silva', '4274646483', '2017-01-31', 'Male', 'teacher', 'married', '903-479-6310', 'attanayakegoda, bandarawela', 'Colombo', 'Colombo', 'long smoking', 1, NULL, NULL, '2016-11-09 00:00:00', 'lung.oral', 2, 3),
(417, 'Mr', 'nimal', 'silva', '4025217236', '2017-07-01', 'Male', 'teacher', 'married', '479-107-9581', 'no3,brown street nugegode', 'kaduruwa', 'Matara', 'long smoking', 1, NULL, NULL, '2015-06-09 00:00:00', 'leukaemia', 2, 3),
(418, 'Mrs', 'suneera', 'guruge', '2368191666', '2017-11-15', 'Female', 'cleaner', 'single', '303-343-4308', 'attanayakegoda, bandarawela', 'yatiyana', 'Matara', 'chewing beetle', 1, NULL, NULL, '2016-12-07 00:00:00', 'Breast', 2, 3),
(419, 'Rev', 'sigith', 'guruge', '3515067191', '2017-04-04', 'Female', 'cleaner', 'single', '392-632-2701', '2,ain street kohuwala', 'Matara', 'Matara', 'chewing beetle', 1, NULL, NULL, '2017-08-25 00:00:00', 'thyroid', 2, 3),
(420, 'Ms', 'sigith', 'perera', '4439121772', '2017-10-08', 'Male', 'driver', 'married', '900-575-6291', 'attanayakegoda, bandarawela', 'Matara', 'Matara', 'father cancered', 1, NULL, NULL, '2015-10-22 00:00:00', 'Breast', 2, 3),
(421, 'Honorable', 'thameera', 'nimantha', '0941383709', '2017-05-06', 'Female', 'teacher', 'single', '751-694-1946', '2,ain street kohuwala', 'Matara', 'Matara', 'mother cancered', 1, NULL, NULL, '2016-07-30 00:00:00', 'prostate', 2, 3),
(422, 'Ms', 'sigith', 'guruge', '6328099460', '2017-01-25', 'Male', 'nurse', 'single', '670-307-3566', 'attanayakegoda, bandarawela', 'nuwara', 'Matara', 'father cancered', 1, NULL, NULL, '2017-11-13 00:00:00', 'prostate', 2, 3),
(423, 'Honorable', 'thameera', 'guruge', '7751888415', '2017-03-01', 'Male', 'nurse', 'married', '143-314-5773', '2,ain street kohuwala', 'Matara', 'Matara', 'father cancered', 1, NULL, NULL, '2015-02-26 00:00:00', 'thyroid', 2, 3),
(424, 'Mrs', 'suneera', 'dissanayake', '0138930414', '2017-10-01', 'Female', 'teacher', 'married', '564-546-8830', 'no3,brown street nugegode', 'Colombo', 'Matara', 'father cancered', 1, NULL, NULL, '2017-09-18 00:00:00', 'thyroid', 2, 3),
(425, 'Mr', 'thameera', 'kureee', '2117905773', '2017-01-31', 'Male', 'teacher', 'married', '677-110-4507', 'no3,brown street nugegode', 'nuwara', 'Matara', 'mother cancered', 1, NULL, NULL, '2015-11-17 00:00:00', 'thyroid', 2, 3),
(426, 'Honorable', 'sigith', 'guruge', '9636193908', '2017-11-02', 'Male', 'watcher', 'married', '191-501-1579', 'attanayakegoda, bandarawela', 'Matara', 'Matara', 'long smoking', 1, NULL, NULL, '2016-07-14 00:00:00', 'colon', 2, 3),
(427, 'Rev', 'saman', 'gamage', '8205213216', '2017-11-08', 'Male', 'nurse', 'married', '798-747-6813', 'no3,brown street nugegode', 'nuwara', 'Matara', 'chewing beetle', 1, NULL, NULL, '2017-07-02 00:00:00', 'bladder', 2, 3),
(428, 'Rev', 'saman', 'silva', '0596345194', '2017-02-24', 'Female', 'cleaner', 'single', '894-516-8217', '2,ain street kohuwala', 'seeduwa', 'Matara', 'long smoking', 1, NULL, NULL, '2016-08-26 00:00:00', 'prostate', 2, 3),
(429, 'Mrs', 'saman', 'kureee', '6714987528', '2017-02-18', 'Female', 'driver', 'married', '590-270-0249', 'no3,brown street nugegode', 'Matara', 'Galle', 'mother cancered', 1, NULL, NULL, '2016-02-19 00:00:00', 'prostate', 2, 3),
(430, 'Mrs', 'sigith', 'gamage', '1114309060', '2017-02-22', 'Female', 'teacher', 'single', '621-280-6945', 'no3,brown street nugegode', 'nuwara', 'Galle', 'chewing beetle', 1, NULL, NULL, '2017-02-25 00:00:00', 'bladder', 2, 3),
(431, 'Mrs', 'saman', 'dissanayake', '6240664316', '2017-06-07', 'Female', 'driver', 'married', '219-355-1082', 'attanayakegoda, bandarawela', 'wanguwa', 'Galle', 'mother cancered', 1, NULL, NULL, '2016-05-16 00:00:00', 'Breast', 2, 3),
(432, 'Rev', 'nimal', 'kureee', '3560860067', '2017-11-30', 'Female', 'nurse', 'single', '315-133-3667', '2,ain street kohuwala', 'Matara', 'Galle', 'long smoking', 1, NULL, NULL, '2017-11-05 00:00:00', 'leukaemia', 2, 3),
(433, 'Mr', 'thameera', 'guruge', '9547221329', '2017-01-28', 'Male', 'watcher', 'married', '682-309-2170', 'no3,brown street nugegode', 'seeduwa', 'Galle', 'father cancered', 1, NULL, NULL, '2015-08-01 00:00:00', 'thyroid', 2, 3),
(434, 'Rev', 'kamal', 'perera', '0228826810', '2017-08-28', 'Female', 'teacher', 'single', '271-966-3683', 'attanayakegoda, bandarawela', 'Matara', 'Galle', 'long smoking', 1, NULL, NULL, '2016-04-06 00:00:00', 'lung.oral', 2, 3),
(435, 'Mr', 'wasana', 'gamage', '1374393754', '2017-10-15', 'Female', 'cleaner', 'single', '681-696-6484', '2,ain street kohuwala', 'nuwara', 'Colombo', 'father cancered', 1, NULL, NULL, '2017-10-19 00:00:00', 'thyroid', 2, 3),
(436, 'Ms', 'suneera', 'nimantha', '2376979072', '2017-09-13', 'Female', 'driver', 'single', '484-813-9027', 'no3,brown street nugegode', 'Colombo', 'Colombo', 'long smoking', 1, NULL, NULL, '2015-09-26 00:00:00', 'prostate', 2, 3),
(437, 'Mr', 'suneera', 'gamage', '6581623695', '2017-08-30', 'Male', 'teacher', 'married', '844-207-1451', 'no3,brown street nugegode', 'wanguwa', 'Colombo', 'chewing beetle', 1, NULL, NULL, '2015-01-28 00:00:00', 'colon', 2, 3),
(438, 'Ms', 'wasana', 'gamage', '3559298997', '2017-09-30', 'Male', 'teacher', 'single', '321-292-4803', '2,ain street kohuwala', 'nuwara', 'Colombo', 'long smoking', 1, NULL, NULL, '2015-09-04 00:00:00', 'lung.oral', 2, 3),
(439, 'Rev', 'nimal', 'dissanayake', '3042432378', '2017-08-15', 'Male', 'watcher', 'married', '173-157-8618', 'attanayakegoda, bandarawela', 'Matara', 'Colombo', 'long smoking', 1, NULL, NULL, '2017-02-17 00:00:00', 'leukaemia', 2, 3),
(440, 'Mrs', 'sigith', 'silva', '8967761805', '2017-09-28', 'Male', 'driver', 'married', '956-260-0241', 'attanayakegoda, bandarawela', 'kaduruwa', 'Galle', 'chewing beetle', 1, NULL, NULL, '2015-11-24 00:00:00', 'leukaemia', 2, 3),
(441, 'Rev', 'kamal', 'nimantha', '6425086998', '2017-10-22', 'Female', 'driver', 'single', '656-532-5997', 'attanayakegoda, bandarawela', 'kaduruwa', 'Galle', 'chewing beetle', 1, NULL, NULL, '2015-02-04 00:00:00', 'lung.oral', 2, 3),
(442, 'Rev', 'sigith', 'nimantha', '4211365002', '2017-04-15', 'Male', 'cleaner', 'single', '212-158-6629', 'no3,brown street nugegode', 'seeduwa', 'Galle', 'chewing beetle', 1, NULL, NULL, '2016-02-17 00:00:00', 'bladder', 2, 3),
(443, 'Ms', 'kamal', 'dissanayake', '1894206770', '2017-01-09', 'Male', 'teacher', 'single', '628-873-7538', '2,ain street kohuwala', 'yatiyana', 'Galle', 'father cancered', 1, NULL, NULL, '2016-11-28 00:00:00', 'bladder', 2, 3),
(444, 'Mr', 'suneera', 'perera', '5162853623', '2017-01-13', 'Male', 'watcher', 'single', '361-158-7329', 'attanayakegoda, bandarawela', 'seeduwa', 'Galle', 'chewing beetle', 1, NULL, NULL, '2016-08-27 00:00:00', 'thyroid', 2, 3),
(445, 'Mrs', 'suneera', 'dissanayake', '8402488366', '2016-12-29', 'Male', 'teacher', 'married', '856-989-6935', '2,ain street kohuwala', 'yatiyana', 'Galle', 'mother cancered', 1, NULL, NULL, '2016-05-30 00:00:00', 'prostate', 2, 3),
(446, 'Honorable', 'suneera', 'dissanayake', '9790998414', '2017-02-19', 'Female', 'teacher', 'single', '186-342-2837', 'no3,brown street nugegode', 'Matara', 'Colombo', 'chewing beetle', 1, NULL, NULL, '2016-05-22 00:00:00', 'Breast', 2, 3),
(447, 'Dr', 'nimal', 'kureee', '1191876578', '2017-08-03', 'Female', 'cleaner', 'single', '833-664-1462', '2,ain street kohuwala', 'Matara', 'Colombo', 'chewing beetle', 1, NULL, NULL, '2017-02-28 00:00:00', 'colon', 2, 3),
(448, 'Rev', 'suneera', 'nimantha', '5739360978', '2017-05-01', 'Male', 'cleaner', 'married', '803-862-8276', 'no3,brown street nugegode', 'Colombo', 'Galle', 'long smoking', 1, NULL, NULL, '2015-09-23 00:00:00', 'leukaemia', 2, 3),
(449, 'Mrs', 'wasana', 'silva', '6544862789', '2017-02-02', 'Female', 'watcher', 'single', '639-873-5318', 'attanayakegoda, bandarawela', 'yatiyana', 'Colombo', 'father cancered', 1, NULL, NULL, '2015-09-25 00:00:00', 'colon', 2, 3),
(450, 'Mr', 'kamal', 'guruge', '7759352751', '2017-06-07', 'Male', 'cleaner', 'married', '150-419-2357', '2,ain street kohuwala', 'wanguwa', 'Galle', 'chewing beetle', 1, NULL, NULL, '2015-04-12 00:00:00', 'thyroid', 2, 3),
(451, 'Rev', 'sigith', 'gamage', '0065556968', '2017-10-11', 'Male', 'cleaner', 'single', '228-453-4324', 'no3,brown street nugegode', 'nuwara', 'Colombo', 'father cancered', 1, NULL, NULL, '2015-02-18 00:00:00', 'leukaemia', 2, 3),
(452, 'Mrs', 'thameera', 'gamage', '6519807354', '2017-03-26', 'Male', 'cleaner', 'married', '685-633-1914', 'attanayakegoda, bandarawela', 'Matara', 'Galle', 'father cancered', 1, NULL, NULL, '2016-08-28 00:00:00', 'prostate', 2, 3),
(453, 'Ms', 'sigith', 'perera', '7911609926', '2017-01-22', 'Female', 'nurse', 'married', '617-550-0945', 'attanayakegoda, bandarawela', 'nuwara', 'Colombo', 'mother cancered', 1, NULL, NULL, '2015-08-24 00:00:00', 'lung.oral', 2, 3),
(454, 'Dr', 'saman', 'guruge', '5994507466', '2017-08-13', 'Female', 'teacher', 'married', '189-344-8024', 'attanayakegoda, bandarawela', 'nuwara', 'Colombo', 'chewing beetle', 1, NULL, NULL, '2015-01-08 00:00:00', 'lung.oral', 2, 3),
(455, 'Mr', 'saman', 'guruge', '3022107781', '2016-12-15', 'Female', 'teacher', 'married', '504-386-2826', 'no3,brown street nugegode', 'Colombo', 'Colombo', 'mother cancered', 1, NULL, NULL, '2016-01-24 00:00:00', 'bladder', 2, 3),
(456, 'Mrs', 'saman', 'gamage', '1987848047', '2017-12-02', 'Male', 'teacher', 'single', '402-926-3790', 'no3,brown street nugegode', 'Matara', 'Colombo', 'chewing beetle', 1, NULL, NULL, '2017-07-31 00:00:00', 'prostate', 2, 3),
(457, 'Ms', 'wasana', 'nimantha', '8360329370', '2017-11-16', 'Male', 'driver', 'married', '853-470-0575', 'attanayakegoda, bandarawela', 'wanguwa', 'Colombo', 'chewing beetle', 1, NULL, NULL, '2016-04-18 00:00:00', 'lung.oral', 2, 3),
(458, 'Rev', 'thameera', 'guruge', '2615423371', '2016-12-19', 'Male', 'cleaner', 'married', '972-345-7971', '2,ain street kohuwala', 'kaduruwa', 'Gampaha', 'father cancered', 1, NULL, NULL, '2015-07-04 00:00:00', 'colon', 2, 3),
(459, 'Ms', 'wasana', 'gamage', '4709000859', '2017-06-14', 'Male', 'nurse', 'single', '643-918-9626', '2,ain street kohuwala', 'yatiyana', 'Gampaha', 'mother cancered', 1, NULL, NULL, '2017-06-22 00:00:00', 'leukaemia', 2, 3),
(460, 'Rev', 'wasana', 'nimantha', '6764087695', '2017-01-28', 'Male', 'cleaner', 'single', '640-509-2465', 'attanayakegoda, bandarawela', 'Colombo', 'Gampaha', 'long smoking', 1, NULL, NULL, '2017-09-07 00:00:00', 'prostate', 2, 3),
(461, 'Mr', 'nimal', 'kureee', '3817132247', '2017-08-17', 'Male', 'watcher', 'married', '763-262-3891', 'attanayakegoda, bandarawela', 'wanguwa', 'Gampaha', 'long smoking', 1, NULL, NULL, '2015-02-14 00:00:00', 'lung.oral', 2, 3),
(462, 'Rev', 'wasana', 'silva', '5294717581', '2017-11-06', 'Male', 'teacher', 'married', '649-716-5943', 'attanayakegoda, bandarawela', 'kaduruwa', 'Gampaha', 'father cancered', 1, NULL, NULL, '2015-10-04 00:00:00', 'bladder', 2, 3),
(463, 'Rev', 'wasana', 'dissanayake', '0242907431', '2017-01-28', 'Male', 'nurse', 'single', '814-553-0947', '2,ain street kohuwala', 'yatiyana', 'Gampaha', 'chewing beetle', 1, NULL, NULL, '2015-03-04 00:00:00', 'colon', 2, 3),
(464, 'Mrs', 'suneera', 'kureee', '4704954765', '2017-08-02', 'Female', 'driver', 'married', '697-308-7736', '2,ain street kohuwala', 'nuwara', 'Gampaha', 'mother cancered', 1, NULL, NULL, '2015-06-13 00:00:00', 'bladder', 2, 3),
(465, 'Ms', 'suneera', 'guruge', '0681959487', '2017-07-17', 'Male', 'nurse', 'single', '144-460-9479', 'attanayakegoda, bandarawela', 'kaduruwa', 'Gampaha', 'long smoking', 1, NULL, NULL, '2017-06-07 00:00:00', 'bladder', 2, 3),
(466, 'Mrs', 'suneera', 'silva', '5604908185', '2017-11-10', 'Male', 'watcher', 'single', '758-360-7673', 'attanayakegoda, bandarawela', 'Matara', 'Gampaha', 'father cancered', 1, NULL, NULL, '2016-05-18 00:00:00', 'prostate', 2, 3),
(467, 'Mrs', 'suneera', 'nimantha', '4466485437', '2017-09-21', 'Male', 'driver', 'single', '269-734-4426', '2,ain street kohuwala', 'yatiyana', 'Gampaha', 'mother cancered', 1, NULL, NULL, '2015-10-12 00:00:00', 'prostate', 2, 3),
(468, 'Rev', 'thameera', 'perera', '2630423735', '2017-04-02', 'Female', 'watcher', 'married', '961-701-3846', '2,ain street kohuwala', 'Matara', 'Gampaha', 'chewing beetle', 1, NULL, NULL, '2015-07-14 00:00:00', 'leukaemia', 2, 3),
(469, 'Mr', 'suneera', 'nimantha', '3898003868', '2017-01-15', 'Female', 'cleaner', 'married', '580-298-6526', 'no3,brown street nugegode', 'nuwara', 'Gampaha', 'mother cancered', 1, NULL, NULL, '2016-05-30 00:00:00', 'leukaemia', 2, 3),
(470, 'Dr', 'wasana', 'guruge', '6900931243', '2017-01-24', 'Female', 'teacher', 'single', '109-148-9077', 'attanayakegoda, bandarawela', 'Matara', 'Gampaha', 'mother cancered', 1, NULL, NULL, '2015-05-25 00:00:00', 'bladder', 2, 3),
(471, 'Honorable', 'thameera', 'silva', '5858486274', '2017-07-06', 'Female', 'teacher', 'married', '447-737-8027', 'attanayakegoda, bandarawela', 'Matara', 'Gampaha', 'chewing beetle', 1, NULL, NULL, '2015-06-11 00:00:00', 'bladder', 2, 3),
(472, 'Mr', 'suneera', 'guruge', '5835970005', '2017-11-17', 'Female', 'nurse', 'married', '655-578-1945', 'no3,brown street nugegode', 'seeduwa', 'Gampaha', 'mother cancered', 1, NULL, NULL, '2015-03-25 00:00:00', 'leukaemia', 2, 3),
(473, 'Dr', 'suneera', 'guruge', '2493237676', '2017-06-18', 'Male', 'cleaner', 'married', '362-304-2564', 'attanayakegoda, bandarawela', 'seeduwa', 'Gampaha', 'father cancered', 1, NULL, NULL, '2017-06-07 00:00:00', 'leukaemia', 2, 3),
(474, 'Ms', 'saman', 'guruge', '5182626711', '2017-01-27', 'Female', 'nurse', 'married', '358-594-2690', 'attanayakegoda, bandarawela', 'Matara', 'Gampaha', 'chewing beetle', 1, NULL, NULL, '2015-09-09 00:00:00', 'Breast', 2, 3),
(475, 'Honorable', 'kamal', 'nimantha', '7426384888', '2017-09-25', 'Female', 'cleaner', 'married', '103-236-3426', '2,ain street kohuwala', 'kaduruwa', 'Gampaha', 'father cancered', 1, NULL, NULL, '2015-02-13 00:00:00', 'leukaemia', 2, 3),
(476, 'Dr', 'thameera', 'silva', '6722125777', '2017-11-24', 'Female', 'driver', 'single', '970-685-4748', 'no3,brown street nugegode', 'nuwara', 'Kalutara', 'father cancered', 1, NULL, NULL, '2017-04-22 00:00:00', 'colon', 2, 3),
(477, 'Dr', 'saman', 'dissanayake', '4936311936', '2017-04-01', 'Male', 'cleaner', 'single', '325-955-4528', '2,ain street kohuwala', 'seeduwa', 'Kalutara', 'mother cancered', 1, NULL, NULL, '2015-04-06 00:00:00', 'leukaemia', 2, 3),
(478, 'Mrs', 'saman', 'perera', '8054917309', '2017-07-06', 'Male', 'cleaner', 'married', '384-535-7695', 'no3,brown street nugegode', 'Matara', 'Kalutara', 'chewing beetle', 1, NULL, NULL, '2015-09-17 00:00:00', 'prostate', 2, 3),
(479, 'Ms', 'wasana', 'gamage', '7467957920', '2017-08-04', 'Female', 'watcher', 'single', '718-512-9520', 'no3,brown street nugegode', 'seeduwa', 'Kalutara', 'father cancered', 1, NULL, NULL, '2017-10-04 00:00:00', 'thyroid', 2, 3),
(480, 'Dr', 'sigith', 'gamage', '1627637060', '2017-01-09', 'Female', 'cleaner', 'married', '526-808-0064', 'attanayakegoda, bandarawela', 'yatiyana', 'Kalutara', 'chewing beetle', 1, NULL, NULL, '2017-11-05 00:00:00', 'bladder', 2, 3),
(481, 'Rev', 'thameera', 'guruge', '9008287617', '2017-09-30', 'Female', 'cleaner', 'single', '785-160-2698', 'attanayakegoda, bandarawela', 'nuwara', 'Kalutara', 'mother cancered', 1, NULL, NULL, '2015-03-04 00:00:00', 'lung.oral', 2, 3),
(482, 'Mr', 'sigith', 'kureee', '5867263320', '2017-05-22', 'Female', 'nurse', 'single', '968-830-7271', 'no3,brown street nugegode', 'seeduwa', 'Kalutara', 'father cancered', 1, NULL, NULL, '2016-06-12 00:00:00', 'colon', 2, 3),
(483, 'Ms', 'kamal', 'nimantha', '7787881534', '2017-06-09', 'Male', 'driver', 'married', '146-796-2721', 'attanayakegoda, bandarawela', 'yatiyana', 'Kalutara', 'long smoking', 1, NULL, NULL, '2015-05-04 00:00:00', 'thyroid', 2, 3),
(484, 'Ms', 'saman', 'perera', '4121897471', '2017-05-21', 'Female', 'watcher', 'married', '357-796-6009', 'no3,brown street nugegode', 'yatiyana', 'Kalutara', 'father cancered', 1, NULL, NULL, '2016-10-08 00:00:00', 'leukaemia', 2, 3),
(485, 'Ms', 'sigith', 'gamage', '5601861870', '2017-10-25', 'Female', 'driver', 'single', '833-700-7938', 'no3,brown street nugegode', 'Colombo', 'Kalutara', 'chewing beetle', 1, NULL, NULL, '2016-04-06 00:00:00', 'colon', 2, 3),
(486, 'Rev', 'kamal', 'kureee', '3160508277', '2017-01-08', 'Male', 'nurse', 'single', '927-258-1457', 'no3,brown street nugegode', 'seeduwa', 'Kalutara', 'father cancered', 1, NULL, NULL, '2016-09-07 00:00:00', 'leukaemia', 2, 3),
(487, 'Ms', 'saman', 'gamage', '3255450241', '2017-07-08', 'Male', 'driver', 'married', '839-931-3289', 'no3,brown street nugegode', 'nuwara', 'Kalutara', 'father cancered', 1, NULL, NULL, '2016-11-01 00:00:00', 'bladder', 2, 3),
(488, 'Mrs', 'suneera', 'silva', '3666721559', '2017-12-06', 'Male', 'cleaner', 'single', '901-424-1248', 'attanayakegoda, bandarawela', 'Colombo', 'Kalutara', 'long smoking', 1, NULL, NULL, '2015-05-08 00:00:00', 'Breast', 2, 3),
(489, 'Mrs', 'saman', 'perera', '5272303342', '2017-03-31', 'Female', 'driver', 'single', '677-675-6785', '2,ain street kohuwala', 'nuwara', 'Kalutara', 'mother cancered', 1, NULL, NULL, '2015-07-30 00:00:00', 'colon', 2, 3),
(490, 'Mrs', 'saman', 'kureee', '9306531583', '2017-05-18', 'Male', 'cleaner', 'married', '892-667-6958', '2,ain street kohuwala', 'wanguwa', 'Kalutara', 'long smoking', 1, NULL, NULL, '2017-07-14 00:00:00', 'Breast', 2, 3),
(491, 'Honorable', 'thameera', 'dissanayake', '5148105321', '2017-07-07', 'Female', 'cleaner', 'married', '372-246-1459', '2,ain street kohuwala', 'wanguwa', 'Kalutara', 'long smoking', 1, NULL, NULL, '2017-01-28 00:00:00', 'leukaemia', 2, 3),
(492, 'Rev', 'kamal', 'kureee', '3084369534', '2017-02-10', 'Male', 'driver', 'married', '879-478-3254', 'attanayakegoda, bandarawela', 'Colombo', 'Kalutara', 'long smoking', 1, NULL, NULL, '2016-01-21 00:00:00', 'leukaemia', 2, 3),
(493, 'Honorable', 'thameera', 'gamage', '1751120295', '2017-08-10', 'Female', 'watcher', 'married', '235-967-2146', 'attanayakegoda, bandarawela', 'nuwara', 'Kalutara', 'chewing beetle', 1, NULL, NULL, '2015-05-26 00:00:00', 'bladder', 2, 3),
(494, 'Honorable', 'saman', 'dissanayake', '0789688158', '2017-09-08', 'Female', 'cleaner', 'married', '968-424-9227', 'attanayakegoda, bandarawela', 'yatiyana', 'Kalutara', 'mother cancered', 1, NULL, NULL, '2017-05-08 00:00:00', 'Breast', 2, 3),
(495, 'Ms', 'wasana', 'nimantha', '5758505757', '2017-01-14', 'Female', 'cleaner', 'single', '612-766-1622', 'no3,brown street nugegode', 'seeduwa', 'Kalutara', 'mother cancered', 1, NULL, NULL, '2015-05-24 00:00:00', 'prostate', 2, 3),
(496, 'Rev', 'saman', 'nimantha', '2743847468', '2017-01-31', 'Female', 'driver', 'single', '911-456-8065', 'no3,brown street nugegode', 'nuwara', 'Kalutara', 'chewing beetle', 1, NULL, NULL, '2017-04-24 00:00:00', 'leukaemia', 2, 3),
(497, 'Rev', 'kamal', 'nimantha', '4612899741', '2016-12-14', 'Male', 'nurse', 'single', '716-286-8832', 'no3,brown street nugegode', 'yatiyana', 'Kalutara', 'mother cancered', 1, NULL, NULL, '2016-06-09 00:00:00', 'lung.oral', 2, 3),
(498, 'Mrs', 'thameera', 'silva', '9127239861', '2017-03-09', 'Female', 'nurse', 'single', '476-316-7509', '2,ain street kohuwala', 'yatiyana', 'Kalutara', 'long smoking', 1, NULL, NULL, '2016-07-30 00:00:00', 'leukaemia', 2, 3),
(499, 'Mrs', 'wasana', 'dissanayake', '7895519522', '2017-04-10', 'Male', 'driver', 'married', '725-343-6065', 'no3,brown street nugegode', 'Matara', 'Kalutara', 'chewing beetle', 1, NULL, NULL, '2015-01-06 00:00:00', 'thyroid', 2, 3),
(500, 'Ms', 'sigith', 'silva', '0550288929', '2017-10-05', 'Female', 'nurse', 'married', '219-239-1680', 'no3,brown street nugegode', 'seeduwa', 'Kalutara', 'mother cancered', 1, NULL, NULL, '2016-07-15 00:00:00', 'prostate', 2, 3),
(501, 'Mr', 'thameera', 'gamage', '8221711241', '2017-11-19', 'Male', 'driver', 'married', '195-900-2013', 'attanayakegoda, bandarawela', 'seeduwa', 'Kalutara', 'mother cancered', 1, NULL, NULL, '2015-10-04 00:00:00', 'colon', 2, 3),
(502, 'Dr', 'saman', 'guruge', '4785704519', '2017-10-15', 'Male', 'cleaner', 'single', '440-863-8409', '2,ain street kohuwala', 'nuwara', 'Kalutara', 'father cancered', 1, NULL, NULL, '2017-01-10 00:00:00', 'bladder', 2, 3),
(503, 'Rev', 'kamal', 'perera', '6070981723', '2017-02-20', 'Male', 'cleaner', 'single', '939-216-7406', 'attanayakegoda, bandarawela', 'Colombo', 'Kalutara', 'father cancered', 1, NULL, NULL, '2015-06-17 00:00:00', 'bladder', 2, 3),
(504, 'Dr', 'wasana', 'gamage', '1383403848', '2017-02-14', 'Female', 'cleaner', 'single', '416-465-8144', 'no3,brown street nugegode', 'wanguwa', 'Rathnapura', 'mother cancered', 1, NULL, NULL, '2017-02-22 00:00:00', 'colon', 2, 3),
(505, 'Mr', 'suneera', 'gamage', '7519720233', '2017-08-28', 'Male', 'watcher', 'married', '618-535-9665', 'attanayakegoda, bandarawela', 'kaduruwa', 'Rathnapura', 'chewing beetle', 1, NULL, NULL, '2015-11-02 00:00:00', 'colon', 2, 3),
(506, 'Dr', 'thameera', 'guruge', '6836859834', '2016-12-29', 'Male', 'watcher', 'single', '270-526-1207', 'no3,brown street nugegode', 'Colombo', 'Rathnapura', 'long smoking', 1, NULL, NULL, '2016-09-22 00:00:00', 'lung.oral', 2, 3),
(507, 'Mr', 'kamal', 'gamage', '7574212570', '2017-08-21', 'Male', 'watcher', 'married', '962-361-1846', 'no3,brown street nugegode', 'wanguwa', 'Rathnapura', 'chewing beetle', 1, NULL, NULL, '2017-03-25 00:00:00', 'bladder', 2, 3),
(508, 'Ms', 'wasana', 'nimantha', '7404152402', '2017-02-27', 'Male', 'nurse', 'single', '356-553-4238', 'attanayakegoda, bandarawela', 'Matara', 'Rathnapura', 'chewing beetle', 1, NULL, NULL, '2017-02-07 00:00:00', 'prostate', 2, 3),
(509, 'Rev', 'thameera', 'silva', '7985537384', '2017-02-06', 'Female', 'watcher', 'single', '698-188-9152', 'attanayakegoda, bandarawela', 'kaduruwa', 'Rathnapura', 'chewing beetle', 1, NULL, NULL, '2015-09-29 00:00:00', 'leukaemia', 2, 3),
(510, 'Mrs', 'saman', 'guruge', '6527170483', '2017-11-30', 'Female', 'watcher', 'married', '524-325-3337', 'no3,brown street nugegode', 'seeduwa', 'Rathnapura', 'father cancered', 1, NULL, NULL, '2016-07-29 00:00:00', 'leukaemia', 2, 3),
(511, 'Rev', 'sigith', 'silva', '0921785631', '2017-05-12', 'Male', 'teacher', 'single', '908-146-7146', 'no3,brown street nugegode', 'yatiyana', 'Rathnapura', 'chewing beetle', 1, NULL, NULL, '2016-04-24 00:00:00', 'lung.oral', 2, 3),
(512, 'Rev', 'kamal', 'nimantha', '9960112462', '2017-04-12', 'Female', 'teacher', 'married', '284-184-0855', 'attanayakegoda, bandarawela', 'Colombo', 'Rathnapura', 'chewing beetle', 1, NULL, NULL, '2017-01-21 00:00:00', 'Breast', 2, 3),
(513, 'Ms', 'suneera', 'dissanayake', '5704663362', '2017-11-19', 'Female', 'driver', 'single', '716-800-6206', 'attanayakegoda, bandarawela', 'nuwara', 'Rathnapura', 'long smoking', 1, NULL, NULL, '2016-12-29 00:00:00', 'leukaemia', 2, 3),
(514, 'Honorable', 'sigith', 'guruge', '0849279658', '2016-12-11', 'Male', 'teacher', 'single', '421-736-8155', '2,ain street kohuwala', 'wanguwa', 'Rathnapura', 'chewing beetle', 1, NULL, NULL, '2017-07-14 00:00:00', 'lung.oral', 2, 3),
(515, 'Dr', 'wasana', 'perera', '2421068371', '2017-05-01', 'Male', 'driver', 'married', '270-535-6373', 'no3,brown street nugegode', 'nuwara', 'Rathnapura', 'father cancered', 1, NULL, NULL, '2017-06-23 00:00:00', 'leukaemia', 2, 3),
(516, 'Rev', 'sigith', 'guruge', '4476011446', '2016-12-18', 'Male', 'watcher', 'single', '308-633-5939', 'no3,brown street nugegode', 'wanguwa', 'Rathnapura', 'mother cancered', 1, NULL, NULL, '2016-08-02 00:00:00', 'bladder', 2, 3),
(517, 'Ms', 'sigith', 'nimantha', '3105901450', '2017-03-21', 'Male', 'driver', 'married', '798-924-2732', '2,ain street kohuwala', 'yatiyana', 'Rathnapura', 'mother cancered', 1, NULL, NULL, '2017-11-30 00:00:00', 'prostate', 2, 3),
(518, 'Mrs', 'thameera', 'dissanayake', '6220990900', '2017-08-18', 'Male', 'teacher', 'married', '564-366-5671', 'no3,brown street nugegode', 'Matara', 'Rathnapura', 'father cancered', 1, NULL, NULL, '2014-12-28 00:00:00', 'thyroid', 2, 3),
(519, 'Mrs', 'suneera', 'kureee', '3129454535', '2017-04-18', 'Male', 'watcher', 'married', '356-881-7856', 'attanayakegoda, bandarawela', 'Matara', 'Rathnapura', 'mother cancered', 1, NULL, NULL, '2015-04-18 00:00:00', 'lung.oral', 2, 3),
(520, 'Honorable', 'kamal', 'guruge', '9118641962', '2017-02-12', 'Female', 'cleaner', 'single', '634-661-8101', '2,ain street kohuwala', 'seeduwa', 'Colombo', 'long smoking', 1, NULL, NULL, '2015-05-29 00:00:00', 'Breast', 2, 3),
(521, 'Mr', 'saman', 'kureee', '2086001894', '2017-03-14', 'Male', 'teacher', 'married', '636-373-2280', '2,ain street kohuwala', 'Colombo', 'Colombo', 'father cancered', 1, NULL, NULL, '2017-11-14 00:00:00', 'colon', 2, 3),
(522, 'Mrs', 'thameera', 'kureee', '7910099509', '2017-07-10', 'Male', 'teacher', 'single', '930-175-7455', 'no3,brown street nugegode', 'Matara', 'Colombo', 'mother cancered', 1, NULL, NULL, '2016-07-14 00:00:00', 'bladder', 2, 3),
(523, 'Dr', 'sigith', 'silva', '2296631681', '2017-04-09', 'Male', 'nurse', 'married', '127-507-1910', 'no3,brown street nugegode', 'yatiyana', 'Colombo', 'long smoking', 1, NULL, NULL, '2017-09-27 00:00:00', 'prostate', 2, 3),
(524, 'Mr', 'kamal', 'dissanayake', '1714264335', '2017-04-06', 'Male', 'driver', 'married', '456-983-9521', 'no3,brown street nugegode', 'Colombo', 'Colombo', 'mother cancered', 1, NULL, NULL, '2017-05-07 00:00:00', 'thyroid', 2, 3),
(525, 'Dr', 'suneera', 'dissanayake', '9594148551', '2017-03-01', 'Female', 'cleaner', 'single', '851-878-6046', 'no3,brown street nugegode', 'nuwara', 'Rathnapura', 'father cancered', 1, NULL, NULL, '2016-03-27 00:00:00', 'leukaemia', 2, 3),
(526, 'Honorable', 'suneera', 'perera', '1339398915', '2017-03-21', 'Female', 'driver', 'married', '989-410-9287', '2,ain street kohuwala', 'Colombo', 'Rathnapura', 'mother cancered', 1, NULL, NULL, '2015-08-31 00:00:00', 'thyroid', 2, 3),
(527, 'Mr', 'saman', 'nimantha', '6885803871', '2017-11-26', 'Female', 'cleaner', 'married', '919-261-3538', 'no3,brown street nugegode', 'kaduruwa', 'Rathnapura', 'mother cancered', 1, NULL, NULL, '2017-04-09 00:00:00', 'leukaemia', 2, 3),
(528, 'Mrs', 'thameera', 'silva', '8481777269', '2017-09-15', 'Female', 'watcher', 'single', '137-286-5690', '2,ain street kohuwala', 'yatiyana', 'Rathnapura', 'father cancered', 1, NULL, NULL, '2016-01-08 00:00:00', 'colon', 2, 3),
(529, 'Dr', 'saman', 'guruge', '3313559174', '2017-07-18', 'Male', 'cleaner', 'single', '477-350-8048', 'attanayakegoda, bandarawela', 'nuwara', 'Rathnapura', 'long smoking', 1, NULL, NULL, '2015-12-30 00:00:00', 'Breast', 2, 3),
(530, 'Ms', 'nimal', 'nimantha', '0524064849', '2017-09-13', 'Male', 'cleaner', 'married', '520-431-0144', 'no3,brown street nugegode', 'wanguwa', 'Jaffna', 'father cancered', 1, NULL, NULL, '2015-02-09 00:00:00', 'bladder', 2, 3),
(531, 'Mr', 'sigith', 'perera', '7050393479', '2017-03-08', 'Male', 'driver', 'married', '916-248-7137', '2,ain street kohuwala', 'Matara', 'Jaffna', 'father cancered', 1, NULL, NULL, '2015-03-20 00:00:00', 'lung.oral', 2, 3),
(532, 'Mr', 'nimal', 'perera', '3744537870', '2017-04-02', 'Female', 'teacher', 'single', '659-868-6589', 'no3,brown street nugegode', 'Colombo', 'Jaffna', 'mother cancered', 1, NULL, NULL, '2016-10-24 00:00:00', 'prostate', 2, 3),
(533, 'Mrs', 'nimal', 'perera', '7159314328', '2017-04-08', 'Male', 'cleaner', 'single', '849-446-6986', '2,ain street kohuwala', 'yatiyana', 'Jaffna', 'chewing beetle', 1, NULL, NULL, '2015-01-15 00:00:00', 'bladder', 2, 3),
(534, 'Mr', 'kamal', 'dissanayake', '8292025804', '2017-02-18', 'Female', 'cleaner', 'single', '609-596-7675', '2,ain street kohuwala', 'nuwara', 'Colombo', 'mother cancered', 1, NULL, NULL, '2015-09-03 00:00:00', 'thyroid', 2, 3),
(535, 'Honorable', 'saman', 'dissanayake', '7289661478', '2016-12-26', 'Female', 'driver', 'single', '189-546-0192', 'no3,brown street nugegode', 'wanguwa', 'Colombo', 'mother cancered', 1, NULL, NULL, '2015-10-02 00:00:00', 'lung.oral', 2, 3),
(536, 'Ms', 'saman', 'nimantha', '7804801416', '2017-10-22', 'Male', 'nurse', 'single', '826-831-4739', 'no3,brown street nugegode', 'kaduruwa', 'Colombo', 'long smoking', 1, NULL, NULL, '2016-12-21 00:00:00', 'colon', 2, 3),
(537, 'Mrs', 'sigith', 'perera', '9193847661', '2017-09-17', 'Male', 'teacher', 'married', '861-456-1077', '2,ain street kohuwala', 'Matara', 'Colombo', 'long smoking', 1, NULL, NULL, '2017-06-28 00:00:00', 'lung.oral', 2, 3),
(538, 'Mr', 'thameera', 'perera', '9018930563', '2017-05-30', 'Male', 'teacher', 'married', '349-794-2553', 'attanayakegoda, bandarawela', 'Colombo', 'Colombo', 'father cancered', 1, NULL, NULL, '2016-05-09 00:00:00', 'prostate', 2, 3),
(539, 'Mrs', 'kamal', 'dissanayake', '0720980569', '2017-03-02', 'Male', 'watcher', 'married', '869-256-7186', 'attanayakegoda, bandarawela', 'Matara', 'Colombo', 'chewing beetle', 1, NULL, NULL, '2016-01-18 00:00:00', 'prostate', 2, 3),
(540, 'Ms', 'kamal', 'silva', '9296482704', '2017-12-09', 'Female', 'cleaner', 'married', '486-588-7040', 'attanayakegoda, bandarawela', 'seeduwa', 'Colombo', 'long smoking', 1, NULL, NULL, '2016-09-23 00:00:00', 'prostate', 2, 3),
(541, 'Ms', 'suneera', 'perera', '5469735109', '2017-05-07', 'Female', 'cleaner', 'single', '716-291-3088', 'no3,brown street nugegode', 'nuwara', 'Jaffna', 'mother cancered', 1, NULL, NULL, '2015-01-01 00:00:00', 'lung.oral', 2, 3),
(542, 'Mr', 'kamal', 'silva', '0451579917', '2017-12-03', 'Male', 'watcher', 'single', '329-700-7409', 'no3,brown street nugegode', 'seeduwa', 'Jaffna', 'chewing beetle', 1, NULL, NULL, '2015-12-02 00:00:00', 'Breast', 2, 3),
(543, 'Dr', 'wasana', 'perera', '7752406791', '2017-04-09', 'Male', 'teacher', 'single', '227-954-3529', '2,ain street kohuwala', 'seeduwa', 'Jaffna', 'long smoking', 1, NULL, NULL, '2017-08-09 00:00:00', 'prostate', 2, 3),
(544, 'Ms', 'wasana', 'nimantha', '7158213595', '2017-11-15', 'Female', 'watcher', 'married', '933-777-4146', '2,ain street kohuwala', 'nuwara', 'Jaffna', 'long smoking', 1, NULL, NULL, '2015-03-27 00:00:00', 'colon', 2, 3),
(545, 'Mrs', 'nimal', 'gamage', '3733387864', '2017-04-18', 'Male', 'nurse', 'married', '104-399-5245', 'no3,brown street nugegode', 'nuwara', 'Jaffna', 'long smoking', 1, NULL, NULL, '2015-04-04 00:00:00', 'prostate', 2, 3),
(546, 'Dr', 'wasana', 'gamage', '2262339074', '2017-05-31', 'Male', 'teacher', 'married', '519-271-9248', '2,ain street kohuwala', 'kaduruwa', 'Jaffna', 'father cancered', 1, NULL, NULL, '2016-07-19 00:00:00', 'colon', 2, 3),
(547, 'Rev', 'kamal', 'silva', '6295316220', '2017-02-04', 'Male', 'watcher', 'single', '729-980-9027', 'no3,brown street nugegode', 'wanguwa', 'Colombo', 'father cancered', 1, NULL, NULL, '2017-10-10 00:00:00', 'bladder', 2, 3),
(548, 'Mrs', 'wasana', 'perera', '1403612528', '2017-12-10', 'Male', 'driver', 'married', '503-293-5320', 'no3,brown street nugegode', 'Colombo', 'Colombo', 'long smoking', 1, NULL, NULL, '2016-10-06 00:00:00', 'colon', 2, 3),
(549, 'Mrs', 'thameera', 'gamage', '3382443384', '2016-12-30', 'Male', 'cleaner', 'single', '701-939-7683', 'no3,brown street nugegode', 'yatiyana', 'Colombo', 'long smoking', 1, NULL, NULL, '2016-08-19 00:00:00', 'bladder', 2, 3),
(550, 'Dr', 'sigith', 'perera', '2077975385', '2017-01-27', 'Male', 'teacher', 'single', '163-185-7022', 'attanayakegoda, bandarawela', 'nuwara', 'Colombo', 'chewing beetle', 1, NULL, NULL, '2015-03-31 00:00:00', 'prostate', 2, 3),
(551, 'Honorable', 'saman', 'guruge', '2883582041', '2017-08-28', 'Male', 'teacher', 'married', '678-606-0841', 'no3,brown street nugegode', 'Colombo', 'Colombo', 'long smoking', 1, NULL, NULL, '2016-03-18 00:00:00', 'Breast', 2, 3),
(552, 'Rev', 'thameera', 'perera', '9543874883', '2017-03-25', 'Female', 'nurse', 'married', '826-345-6451', 'no3,brown street nugegode', 'wanguwa', 'Colombo', 'mother cancered', 1, NULL, NULL, '2015-04-01 00:00:00', 'lung.oral', 2, 3),
(553, 'Rev', 'saman', 'guruge', '2993042106', '2017-08-18', 'Female', 'teacher', 'single', '411-212-3336', 'no3,brown street nugegode', 'Matara', 'Colombo', 'long smoking', 1, NULL, NULL, '2017-11-30 00:00:00', 'bladder', 2, 3),
(554, 'Ms', 'wasana', 'silva', '1593830068', '2017-03-17', 'Female', 'watcher', 'married', '214-909-6672', '2,ain street kohuwala', 'nuwara', 'Jaffna', 'chewing beetle', 1, NULL, NULL, '2017-11-11 00:00:00', 'thyroid', 2, 3),
(555, 'Mr', 'thameera', 'nimantha', '8935249351', '2016-12-25', 'Male', 'watcher', 'married', '133-758-2831', 'attanayakegoda, bandarawela', 'Matara', 'Jaffna', 'chewing beetle', 1, NULL, NULL, '2015-08-30 00:00:00', 'bladder', 2, 3),
(556, 'Rev', 'kamal', 'silva', '3098145897', '2017-07-30', 'Male', 'cleaner', 'single', '762-776-8218', 'attanayakegoda, bandarawela', 'nuwara', 'Jaffna', 'mother cancered', 1, NULL, NULL, '2015-06-14 00:00:00', 'thyroid', 2, 3),
(557, 'Dr', 'nimal', 'nimantha', '2169417095', '2017-07-13', 'Male', 'driver', 'single', '496-775-7533', '2,ain street kohuwala', 'Matara', 'Jaffna', 'chewing beetle', 1, NULL, NULL, '2016-07-05 00:00:00', 'thyroid', 2, 3),
(558, 'Mrs', 'thameera', 'perera', '0232581363', '2017-10-15', 'Female', 'driver', 'single', '137-994-2896', '2,ain street kohuwala', 'yatiyana', 'Jaffna', 'long smoking', 1, NULL, NULL, '2015-11-14 00:00:00', 'bladder', 2, 3),
(559, 'Mr', 'sigith', 'guruge', '3961177309', '2017-05-03', 'Female', 'teacher', 'single', '305-887-1407', 'attanayakegoda, bandarawela', 'Matara', 'Jaffna', 'chewing beetle', 1, NULL, NULL, '2016-09-17 00:00:00', 'thyroid', 2, 3),
(560, 'Dr', 'saman', 'kureee', '0023681527', '2017-08-01', 'Male', 'driver', 'single', '387-955-6418', 'no3,brown street nugegode', 'kaduruwa', 'Jaffna', 'mother cancered', 1, NULL, NULL, '2017-06-08 00:00:00', 'prostate', 2, 3),
(561, 'Ms', 'nimal', 'silva', '9916219176', '2017-10-20', 'Male', 'driver', 'single', '117-107-6771', 'no3,brown street nugegode', 'yatiyana', 'Jaffna', 'chewing beetle', 1, NULL, NULL, '2017-07-08 00:00:00', 'Breast', 2, 3),
(562, 'Dr', 'sigith', 'guruge', '2771836718', '2017-05-01', 'Male', 'teacher', 'married', '872-103-4103', 'attanayakegoda, bandarawela', 'Colombo', 'Jaffna', 'mother cancered', 1, NULL, NULL, '2016-03-19 00:00:00', 'thyroid', 2, 3),
(563, 'Mr', 'sigith', 'nimantha', '4844194259', '2017-02-13', 'Male', 'teacher', 'single', '502-214-8518', 'no3,brown street nugegode', 'seeduwa', 'Jaffna', 'long smoking', 1, NULL, NULL, '2016-05-08 00:00:00', 'colon', 2, 3),
(564, 'Mr', 'nimal', 'gamage', '2561671747', '2017-06-07', 'Female', 'cleaner', 'single', '438-178-9363', 'attanayakegoda, bandarawela', 'Colombo', 'Ampara', 'father cancered', 1, NULL, NULL, '2017-07-18 00:00:00', 'Breast', 2, 3),
(565, 'Mr', 'thameera', 'perera', '1018134743', '2017-09-26', 'Female', 'teacher', 'single', '327-186-4291', 'no3,brown street nugegode', 'seeduwa', 'Ampara', 'father cancered', 1, NULL, NULL, '2016-01-01 00:00:00', 'Breast', 2, 3),
(566, 'Rev', 'suneera', 'perera', '7890931093', '2017-01-23', 'Female', 'teacher', 'single', '159-727-9090', '2,ain street kohuwala', 'Colombo', 'Ampara', 'long smoking', 1, NULL, NULL, '2016-01-07 00:00:00', 'prostate', 2, 3),
(567, 'Mrs', 'saman', 'nimantha', '1123673616', '2017-05-15', 'Female', 'cleaner', 'single', '524-423-8844', '2,ain street kohuwala', 'kaduruwa', 'Ampara', 'chewing beetle', 1, NULL, NULL, '2016-06-18 00:00:00', 'colon', 2, 3),
(568, 'Mr', 'suneera', 'kureee', '6391245045', '2017-02-06', 'Female', 'nurse', 'married', '851-263-8487', 'attanayakegoda, bandarawela', 'Colombo', 'Ampara', 'long smoking', 1, NULL, NULL, '2015-08-19 00:00:00', 'lung.oral', 2, 3),
(569, 'Dr', 'sigith', 'gamage', '0663454247', '2017-09-29', 'Female', 'watcher', 'single', '351-915-6416', '2,ain street kohuwala', 'nuwara', 'Ampara', 'long smoking', 1, NULL, NULL, '2016-12-31 00:00:00', 'lung.oral', 2, 3),
(570, 'Honorable', 'suneera', 'dissanayake', '3614583260', '2017-07-11', 'Female', 'cleaner', 'single', '987-608-7853', 'attanayakegoda, bandarawela', 'Matara', 'Ampara', 'mother cancered', 1, NULL, NULL, '2016-05-03 00:00:00', 'lung.oral', 2, 3),
(571, 'Mr', 'wasana', 'guruge', '9943806818', '2017-11-18', 'Male', 'teacher', 'married', '244-553-9754', '2,ain street kohuwala', 'Matara', 'Ampara', 'chewing beetle', 1, NULL, NULL, '2015-08-25 00:00:00', 'bladder', 2, 3),
(572, 'Mr', 'kamal', 'perera', '2587277000', '2017-01-12', 'Male', 'nurse', 'single', '398-584-3825', 'no3,brown street nugegode', 'kaduruwa', 'Ampara', 'mother cancered', 1, NULL, NULL, '2016-02-09 00:00:00', 'lung.oral', 2, 3),
(573, 'Mr', 'sigith', 'kureee', '9852043331', '2017-01-21', 'Female', 'cleaner', 'married', '233-363-0935', 'attanayakegoda, bandarawela', 'nuwara', 'Ampara', 'mother cancered', 1, NULL, NULL, '2017-07-15 00:00:00', 'thyroid', 2, 3),
(574, 'Mrs', 'suneera', 'kureee', '8298241371', '2017-10-22', 'Male', 'driver', 'single', '800-322-5892', 'attanayakegoda, bandarawela', 'Colombo', 'Ampara', 'father cancered', 1, NULL, NULL, '2017-05-04 00:00:00', 'prostate', 2, 3),
(575, 'Rev', 'saman', 'silva', '9944576891', '2017-07-04', 'Female', 'teacher', 'single', '256-801-1667', 'no3,brown street nugegode', 'Colombo', 'Ampara', 'long smoking', 1, NULL, NULL, '2017-05-29 00:00:00', 'prostate', 2, 3),
(576, 'Ms', 'thameera', 'gamage', '1694923398', '2017-03-07', 'Female', 'watcher', 'married', '211-688-3438', 'no3,brown street nugegode', 'wanguwa', 'Ampara', 'mother cancered', 1, NULL, NULL, '2015-03-09 00:00:00', 'colon', 2, 3),
(577, 'Ms', 'wasana', 'gamage', '9755166998', '2017-05-03', 'Female', 'watcher', 'married', '693-709-8180', 'no3,brown street nugegode', 'wanguwa', 'Ampara', 'chewing beetle', 1, NULL, NULL, '2017-12-07 00:00:00', 'lung.oral', 2, 3),
(578, 'Dr', 'wasana', 'kureee', '0004872061', '2017-02-11', 'Male', 'nurse', 'single', '407-399-4422', 'no3,brown street nugegode', 'wanguwa', 'Ampara', 'chewing beetle', 1, NULL, NULL, '2016-08-16 00:00:00', 'thyroid', 2, 3),
(579, 'Mr', 'kamal', 'dissanayake', '1140343343', '2017-01-09', 'Female', 'teacher', 'single', '645-735-9211', 'no3,brown street nugegode', 'yatiyana', 'Ampara', 'long smoking', 1, NULL, NULL, '2017-04-29 00:00:00', 'colon', 2, 3),
(580, 'Ms', 'nimal', 'gamage', '2046445090', '2017-11-14', 'Male', 'nurse', 'married', '519-174-2822', '2,ain street kohuwala', 'seeduwa', 'Kurunegala', 'long smoking', 1, NULL, NULL, '2016-02-14 00:00:00', 'Breast', 2, 3),
(581, 'Mrs', 'nimal', 'nimantha', '9107055994', '2017-10-25', 'Male', 'teacher', 'single', '641-631-2949', 'attanayakegoda, bandarawela', 'seeduwa', 'Kurunegala', 'father cancered', 1, NULL, NULL, '2017-07-07 00:00:00', 'leukaemia', 2, 3),
(582, 'Ms', 'kamal', 'guruge', '5167543274', '2017-04-27', 'Male', 'teacher', 'single', '186-561-0129', '2,ain street kohuwala', 'wanguwa', 'Kurunegala', 'father cancered', 1, NULL, NULL, '2015-01-06 00:00:00', 'Breast', 2, 3),
(583, 'Honorable', 'sigith', 'nimantha', '1874625638', '2017-08-04', 'Male', 'watcher', 'single', '929-164-7604', 'no3,brown street nugegode', 'seeduwa', 'Kurunegala', 'father cancered', 1, NULL, NULL, '2016-05-16 00:00:00', 'bladder', 2, 3),
(584, 'Honorable', 'kamal', 'guruge', '6050677670', '2017-05-28', 'Female', 'nurse', 'single', '816-575-1752', 'attanayakegoda, bandarawela', 'wanguwa', 'Kurunegala', 'long smoking', 1, NULL, NULL, '2016-04-25 00:00:00', 'leukaemia', 2, 3),
(585, 'Ms', 'kamal', 'nimantha', '8892499173', '2016-12-22', 'Female', 'teacher', 'married', '765-514-7814', 'attanayakegoda, bandarawela', 'Colombo', 'Kurunegala', 'mother cancered', 1, NULL, NULL, '2016-09-25 00:00:00', 'leukaemia', 2, 3),
(586, 'Mr', 'thameera', 'guruge', '5173412836', '2017-07-31', 'Male', 'watcher', 'single', '611-283-3166', '2,ain street kohuwala', 'seeduwa', 'Kurunegala', 'long smoking', 1, NULL, NULL, '2015-10-19 00:00:00', 'Breast', 2, 3),
(587, 'Honorable', 'thameera', 'guruge', '3052209833', '2017-02-02', 'Male', 'driver', 'single', '534-247-6143', '2,ain street kohuwala', 'Matara', 'Kurunegala', 'long smoking', 1, NULL, NULL, '2016-10-22 00:00:00', 'lung.oral', 2, 3),
(588, 'Ms', 'kamal', 'nimantha', '9018827614', '2017-02-15', 'Female', 'nurse', 'married', '918-565-9742', 'attanayakegoda, bandarawela', 'Colombo', 'Kurunegala', 'father cancered', 1, NULL, NULL, '2017-06-25 00:00:00', 'bladder', 2, 3),
(589, 'Dr', 'sigith', 'silva', '3848648865', '2017-08-22', 'Female', 'nurse', 'married', '786-230-0847', 'attanayakegoda, bandarawela', 'kaduruwa', 'Colombo', 'long smoking', 1, NULL, NULL, '2015-09-23 00:00:00', 'thyroid', 2, 3),
(590, 'Mrs', 'sigith', 'guruge', '4621753185', '2017-10-23', 'Male', 'watcher', 'married', '933-519-0428', '2,ain street kohuwala', 'nuwara', 'Colombo', 'chewing beetle', 1, NULL, NULL, '2015-07-06 00:00:00', 'leukaemia', 2, 3),
(591, 'Mrs', 'sigith', 'gamage', '5654596268', '2017-05-16', 'Female', 'watcher', 'married', '411-274-7844', '2,ain street kohuwala', 'seeduwa', 'Colombo', 'father cancered', 1, NULL, NULL, '2017-04-24 00:00:00', 'leukaemia', 2, 3),
(592, 'Dr', 'suneera', 'gamage', '6884780967', '2017-07-02', 'Female', 'nurse', 'married', '228-622-4220', '2,ain street kohuwala', 'Matara', 'Colombo', 'mother cancered', 1, NULL, NULL, '2016-03-27 00:00:00', 'prostate', 2, 3),
(593, 'Rev', 'sigith', 'kureee', '5396812567', '2017-04-15', 'Female', 'nurse', 'single', '606-921-1323', 'no3,brown street nugegode', 'wanguwa', 'Colombo', 'long smoking', 1, NULL, NULL, '2016-07-08 00:00:00', 'thyroid', 2, 3),
(594, 'Honorable', 'nimal', 'dissanayake', '9045950421', '2017-02-16', 'Female', 'driver', 'single', '856-592-2668', '2,ain street kohuwala', 'nuwara', 'Colombo', 'father cancered', 1, NULL, NULL, '2015-10-30 00:00:00', 'bladder', 2, 3),
(595, 'Dr', 'nimal', 'perera', '1842632558', '2017-08-03', 'Female', 'nurse', 'single', '209-792-1759', 'attanayakegoda, bandarawela', 'nuwara', 'Colombo', 'chewing beetle', 1, NULL, NULL, '2015-01-02 00:00:00', 'Breast', 2, 3),
(596, 'Dr', 'sigith', 'perera', '7321006433', '2017-05-28', 'Male', 'watcher', 'married', '502-560-5861', 'no3,brown street nugegode', 'kaduruwa', 'Colombo', 'mother cancered', 1, NULL, NULL, '2015-01-31 00:00:00', 'leukaemia', 2, 3),
(597, 'Mrs', 'wasana', 'nimantha', '1069139548', '2016-12-19', 'Female', 'driver', 'single', '270-431-1816', 'attanayakegoda, bandarawela', 'kaduruwa', 'Colombo', 'mother cancered', 1, NULL, NULL, '2017-01-01 00:00:00', 'leukaemia', 2, 3),
(598, 'Mrs', 'suneera', 'silva', '0088978656', '2017-02-17', 'Male', 'teacher', 'single', '515-606-1569', 'no3,brown street nugegode', 'seeduwa', 'Colombo', 'father cancered', 1, NULL, NULL, '2017-09-24 00:00:00', 'colon', 2, 3),
(599, 'Mrs', 'sigith', 'kureee', '2402541288', '2017-03-09', 'Female', 'teacher', 'married', '702-494-5217', 'attanayakegoda, bandarawela', 'kaduruwa', 'Colombo', 'long smoking', 1, NULL, NULL, '2016-11-16 00:00:00', 'prostate', 2, 3),
(600, 'Mrs', 'saman', 'kureee', '2931921122', '2017-11-11', 'Female', 'driver', 'single', '731-796-5733', 'no3,brown street nugegode', 'kaduruwa', 'Colombo', 'chewing beetle', 1, NULL, NULL, '2016-02-10 00:00:00', 'colon', 2, 3),
(601, 'Ms', 'saman', 'silva', '1424666937', '2017-06-10', 'Male', 'driver', 'single', '840-759-8585', 'attanayakegoda, bandarawela', 'nuwara', 'Colombo', 'father cancered', 1, NULL, NULL, '2016-10-08 00:00:00', 'leukaemia', 2, 3),
(602, 'Mr', 'suneera', 'kureee', '1888845864', '2017-12-08', 'Male', 'watcher', 'married', '166-643-6343', 'attanayakegoda, bandarawela', 'yatiyana', 'Colombo', 'chewing beetle', 1, NULL, NULL, '2015-07-12 00:00:00', 'Breast', 2, 3),
(603, 'Dr', 'sigith', 'kureee', '6455178246', '2017-04-21', 'Male', 'driver', 'married', '920-929-4271', 'no3,brown street nugegode', 'Colombo', 'Colombo', 'chewing beetle', 1, NULL, NULL, '2017-08-20 00:00:00', 'bladder', 2, 3),
(604, 'Mrs', 'kamal', 'gamage', '5807007123', '2017-06-02', 'Male', 'driver', 'single', '961-820-4503', 'attanayakegoda, bandarawela', 'wanguwa', 'Colombo', 'chewing beetle', 1, NULL, NULL, '2017-08-06 00:00:00', 'lung.oral', 2, 3),
(605, 'Mr', 'thameera', 'silva', '9717047030', '2017-09-30', 'Male', 'nurse', 'married', '813-828-1801', '2,ain street kohuwala', 'seeduwa', 'Colombo', 'chewing beetle', 1, NULL, NULL, '2017-08-10 00:00:00', 'Breast', 2, 3),
(606, 'Mrs', 'saman', 'guruge', '6101795020', '2017-05-11', 'Female', 'cleaner', 'single', '399-917-9040', 'attanayakegoda, bandarawela', 'seeduwa', 'Colombo', 'chewing beetle', 1, NULL, NULL, '2016-10-21 00:00:00', 'colon', 2, 3),
(607, 'Dr', 'nimal', 'dissanayake', '4237013308', '2017-02-13', 'Female', 'driver', 'single', '353-885-1349', 'no3,brown street nugegode', 'nuwara', 'Colombo', 'mother cancered', 1, NULL, NULL, '2017-10-30 00:00:00', 'colon', 2, 3),
(608, 'Ms', 'nimal', 'dissanayake', '8735711272', '2017-03-19', 'Male', 'driver', 'married', '873-754-9468', 'attanayakegoda, bandarawela', 'Colombo', 'Colombo', 'mother cancered', 1, NULL, NULL, '2017-10-15 00:00:00', 'Breast', 2, 3),
(609, 'Dr', 'nimal', 'guruge', '1185586709', '2017-07-07', 'Male', 'watcher', 'single', '503-578-4040', 'no3,brown street nugegode', 'yatiyana', 'Colombo', 'father cancered', 1, NULL, NULL, '2015-06-16 00:00:00', 'bladder', 2, 3),
(610, 'Mr', 'Kumara', 'Sampath', '123456789V', '2017-12-05', 'Male', 'Student', 'Single', '0778952135', 'Kolonna', 'Nugegoda', 'Colombo', 'No', 1, '', '0000-00-00 00:00:00', '2017-12-06 00:00:00', 'Lung', 6, 3);

-- --------------------------------------------------------

--
-- Table structure for table `PatientHistory`
--

CREATE TABLE `PatientHistory` (
  `id` int(11) NOT NULL,
  `patient_Id` int(11) NOT NULL,
  `present_Complaint` varchar(800) DEFAULT NULL,
  `surgical_History` varchar(500) DEFAULT NULL,
  `allegi_History` varchar(500) DEFAULT NULL,
  `social_History` varchar(500) DEFAULT NULL,
  `family_History` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `PatientHistory`
--

INSERT INTO `PatientHistory` (`id`, `patient_Id`, `present_Complaint`, `surgical_History`, `allegi_History`, `social_History`, `family_History`) VALUES
(4, 610, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `RegisterDoctor`
--

CREATE TABLE `RegisterDoctor` (
  `grade` varchar(50) DEFAULT NULL,
  `emp_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `RegisterDoctor`
--

INSERT INTO `RegisterDoctor` (`grade`, `emp_Id`) VALUES
(NULL, 2),
('A', 6);

-- --------------------------------------------------------

--
-- Table structure for table `serumprotein_report`
--

CREATE TABLE `serumprotein_report` (
  `id` int(11) NOT NULL,
  `Testid` int(11) NOT NULL,
  `Patient_ID` int(11) NOT NULL,
  `Albumin` varchar(45) DEFAULT NULL,
  `Alpha1` varchar(45) DEFAULT NULL,
  `Alpha2` varchar(45) DEFAULT NULL,
  `Beta` varchar(45) DEFAULT NULL,
  `Gamma` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `serum_calcium_report`
--

CREATE TABLE `serum_calcium_report` (
  `id` int(11) NOT NULL,
  `Testid` int(11) NOT NULL,
  `Patient_ID` int(11) NOT NULL,
  `Free_calcium` varchar(45) DEFAULT NULL,
  `Total_calcium` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `serum_electrolytes`
--

CREATE TABLE `serum_electrolytes` (
  `id` int(11) NOT NULL,
  `Testid` int(11) NOT NULL,
  `Patient_ID` int(11) NOT NULL,
  `Sodium` varchar(45) DEFAULT NULL,
  `Potassium` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `SystemEmployee`
--

CREATE TABLE `SystemEmployee` (
  `type` varchar(45) DEFAULT NULL,
  `emp_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `SystemEmployee`
--

INSERT INTO `SystemEmployee` (`type`, `emp_Id`) VALUES
('Admin', 1),
('Register Doctor', 2),
('Consultant Doctor', 3),
('Lab Assistant', 4),
('Admin', 5),
('Register Doctor', 6),
('Admin', 7);

-- --------------------------------------------------------

--
-- Table structure for table `TestReport`
--

CREATE TABLE `TestReport` (
  `test_Id` int(11) NOT NULL,
  `patient_Id` int(11) NOT NULL,
  `patient_name` varchar(45) DEFAULT NULL,
  `date` datetime(6) NOT NULL,
  `type` varchar(45) NOT NULL,
  `emp_Id` int(11) NOT NULL,
  `remarks` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `TestReport`
--

INSERT INTO `TestReport` (`test_Id`, `patient_Id`, `patient_name`, `date`, `type`, `emp_Id`, `remarks`) VALUES
(1, 1, 'Thilina', '2017-12-07 00:00:00.000000', 'BoneMarrow', 4, 're');

-- --------------------------------------------------------

--
-- Table structure for table `thyroid_report`
--

CREATE TABLE `thyroid_report` (
  `id` int(11) NOT NULL,
  `Testid` int(11) NOT NULL,
  `Patient_ID` int(11) NOT NULL,
  `TSH` varchar(45) DEFAULT NULL,
  `FreeT4` varchar(45) DEFAULT NULL,
  `FreeT3` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Treatment`
--

CREATE TABLE `Treatment` (
  `treat_Id` varchar(30) NOT NULL,
  `patient_Id` int(11) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `date` datetime(6) NOT NULL,
  `type` varchar(45) NOT NULL,
  `venue` varchar(45) DEFAULT NULL,
  `Consultant_emp_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `ufr_report`
--

CREATE TABLE `ufr_report` (
  `id` int(11) NOT NULL,
  `Testid` int(11) NOT NULL,
  `Patient_ID` int(11) NOT NULL,
  `Apperance` varchar(45) DEFAULT NULL,
  `Reaction` varchar(45) DEFAULT NULL,
  `Albumin` varchar(45) DEFAULT NULL,
  `Sugar` varchar(45) DEFAULT NULL,
  `Bile` varchar(45) DEFAULT NULL,
  `Urobilin` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `urine_for_bence_jones_report`
--

CREATE TABLE `urine_for_bence_jones_report` (
  `id` int(11) NOT NULL,
  `Testid` int(11) NOT NULL,
  `Patient_ID` int(11) NOT NULL,
  `Urine_Albumine` varchar(45) DEFAULT NULL,
  `Urine_For_Bence_Jones` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `UsernamePassword`
--

CREATE TABLE `UsernamePassword` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `SystemEmployee_emp_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `UsernamePassword`
--

INSERT INTO `UsernamePassword` (`username`, `password`, `SystemEmployee_emp_Id`) VALUES
('ucsc@123', '123', 1),
('ucsc@1234', '1234', 2),
('ucsc@12345', '12345', 3),
('ucsc@123456', '123456', 4);

-- --------------------------------------------------------

--
-- Table structure for table `ward`
--

CREATE TABLE `ward` (
  `ward_id` int(11) NOT NULL,
  `ward_name` varchar(45) DEFAULT NULL,
  `Description` varchar(45) DEFAULT NULL,
  `Max_patients` varchar(45) DEFAULT NULL,
  `Gender_acceptence` varchar(45) DEFAULT NULL,
  `Supervisor` varchar(45) DEFAULT NULL,
  `del_date_time` datetime DEFAULT NULL,
  `state` int(11) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ward`
--

INSERT INTO `ward` (`ward_id`, `ward_name`, `Description`, `Max_patients`, `Gender_acceptence`, `Supervisor`, `del_date_time`, `state`) VALUES
(1, 'Emergency', 'gwg', '100', 'Male', 'Sayer', NULL, 1),
(7, 'Demo', 'gdgd', '70', 'Female', 'Sayer', NULL, 1),
(8, 'ggg', 'yfyf', '120', 'Female', 'Sayer', NULL, 1),
(5436, 'gdhj', 'fg4rze454', 'gfhgfh', 'Male', 'Sayer', NULL, 1),
(87878, 'ffh', 'gdht', 'rget54', 'Male', 'Sayer', NULL, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Admin`
--
ALTER TABLE `Admin`
  ADD PRIMARY KEY (`emp_id`),
  ADD KEY `fk_Admin_SystemEmployee1_idx` (`emp_id`);

--
-- Indexes for table `adminMessage`
--
ALTER TABLE `adminMessage`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_adminMessage_Employee1_idx` (`Employee_emp_Id`);

--
-- Indexes for table `bonemarrow_report`
--
ALTER TABLE `bonemarrow_report`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_bonemarrow_report_Patient1_idx` (`Patient_Id`),
  ADD KEY `fk_bonemarrow_report_TestReport1_idx` (`TestID`);

--
-- Indexes for table `Chest`
--
ALTER TABLE `Chest`
  ADD PRIMARY KEY (`chest_Id`,`examination_Exam_Id`),
  ADD KEY `fk_Chest_Examination1_idx` (`examination_Exam_Id`);

--
-- Indexes for table `Consult`
--
ALTER TABLE `Consult`
  ADD PRIMARY KEY (`exam_Id`,`patient_Id`),
  ADD KEY `fk_Examination_has_Patient_Patient1_idx` (`patient_Id`),
  ADD KEY `fk_Examination_has_Patient_Examination1_idx` (`exam_Id`);

--
-- Indexes for table `Consultant`
--
ALTER TABLE `Consultant`
  ADD PRIMARY KEY (`emp_Id`),
  ADD KEY `fk_Consultant_SystemEmployee1_idx` (`emp_Id`);

--
-- Indexes for table `c_reactiveprotein_report`
--
ALTER TABLE `c_reactiveprotein_report`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_c_reactiveprotein_report_Patient1_idx` (`Patient_Id`),
  ADD KEY `fk_c_reactiveprotein_report_TestReport1_idx` (`Testid`);

--
-- Indexes for table `Employee`
--
ALTER TABLE `Employee`
  ADD PRIMARY KEY (`emp_Id`);

--
-- Indexes for table `Examination`
--
ALTER TABLE `Examination`
  ADD PRIMARY KEY (`exam_Id`),
  ADD KEY `fk_Examination_Patient1_idx` (`patient_Id`);

--
-- Indexes for table `Examine`
--
ALTER TABLE `Examine`
  ADD KEY `fk_Examine_TestReport1_idx` (`test_Id`),
  ADD KEY `fk_Examine_Consultant1_idx` (`Consultant_emp_Id`);

--
-- Indexes for table `fullblood_report`
--
ALTER TABLE `fullblood_report`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_fullblood_report_Patient1_idx` (`Patient_Id`),
  ADD KEY `fk_fullblood_report_TestReport1_idx` (`Testid`);

--
-- Indexes for table `General`
--
ALTER TABLE `General`
  ADD PRIMARY KEY (`general_Id`,`examination_exam_Id`),
  ADD KEY `fk_General_Examination1_idx` (`examination_exam_Id`);

--
-- Indexes for table `LabAssistaant`
--
ALTER TABLE `LabAssistaant`
  ADD PRIMARY KEY (`emp_Id`),
  ADD KEY `fk_LabAssistaant_SystemEmployee1_idx` (`emp_Id`);

--
-- Indexes for table `lipidprofile_report`
--
ALTER TABLE `lipidprofile_report`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_lipidprofile_report_Patient1_idx` (`Patient_ID`),
  ADD KEY `fk_lipidprofile_report_TestReport1_idx` (`Testid`);

--
-- Indexes for table `liverfunction_report`
--
ALTER TABLE `liverfunction_report`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_liverfunction_report_Patient1_idx` (`Patient_ID`),
  ADD KEY `fk_liverfunction_report_TestReport1_idx` (`Testid`);

--
-- Indexes for table `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_messages_Consultant1_idx` (`Consultant_emp_Id`),
  ADD KEY `fk_messages_Patient1_idx` (`patient_Id`);

--
-- Indexes for table `NonSystemEmployee`
--
ALTER TABLE `NonSystemEmployee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_NonSystemEmployee_Employee1_idx` (`emp_Id`);

--
-- Indexes for table `Organ`
--
ALTER TABLE `Organ`
  ADD PRIMARY KEY (`oragan_ID`,`examination_exam_Id`),
  ADD KEY `fk_Organ_Examination1_idx` (`examination_exam_Id`);

--
-- Indexes for table `Patient`
--
ALTER TABLE `Patient`
  ADD PRIMARY KEY (`patient_Id`),
  ADD KEY `fk_Patient_RegisterDoctor1_idx` (`RegisterDoctor_emp_Id`),
  ADD KEY `fk_Patient_Consultant1_idx` (`Consultant_emp_Id`);

--
-- Indexes for table `PatientHistory`
--
ALTER TABLE `PatientHistory`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_PatientHistory_Patient1_idx` (`patient_Id`);

--
-- Indexes for table `RegisterDoctor`
--
ALTER TABLE `RegisterDoctor`
  ADD PRIMARY KEY (`emp_Id`),
  ADD KEY `fk_RegisterDoctor_SystemEmployee1_idx` (`emp_Id`);

--
-- Indexes for table `serumprotein_report`
--
ALTER TABLE `serumprotein_report`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_serumprotein_report_Patient1_idx` (`Patient_ID`),
  ADD KEY `fk_serumprotein_report_TestReport1_idx` (`Testid`);

--
-- Indexes for table `serum_calcium_report`
--
ALTER TABLE `serum_calcium_report`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_serum_calcium_report_Patient1_idx` (`Patient_ID`),
  ADD KEY `fk_serum_calcium_report_TestReport1_idx` (`Testid`);

--
-- Indexes for table `serum_electrolytes`
--
ALTER TABLE `serum_electrolytes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_serum_electrolytes_Patient1_idx` (`Patient_ID`),
  ADD KEY `fk_serum_electrolytes_TestReport1_idx` (`Testid`);

--
-- Indexes for table `SystemEmployee`
--
ALTER TABLE `SystemEmployee`
  ADD PRIMARY KEY (`emp_Id`),
  ADD KEY `fk_SystemEmployee_Employee1_idx` (`emp_Id`);

--
-- Indexes for table `TestReport`
--
ALTER TABLE `TestReport`
  ADD PRIMARY KEY (`test_Id`),
  ADD KEY `fk_TestReport_Patient1_idx` (`patient_Id`),
  ADD KEY `fk_TestReport_LabAssistaant1_idx` (`emp_Id`);

--
-- Indexes for table `thyroid_report`
--
ALTER TABLE `thyroid_report`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_thyroid_report_Patient1_idx` (`Patient_ID`),
  ADD KEY `fk_thyroid_report_TestReport1_idx` (`Testid`);

--
-- Indexes for table `Treatment`
--
ALTER TABLE `Treatment`
  ADD PRIMARY KEY (`treat_Id`),
  ADD KEY `fk_Treatment_Patient1_idx` (`patient_Id`),
  ADD KEY `fk_Treatment_Consultant1_idx` (`Consultant_emp_Id`);

--
-- Indexes for table `ufr_report`
--
ALTER TABLE `ufr_report`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_ufr_report_Patient1_idx` (`Patient_ID`),
  ADD KEY `fk_ufr_report_TestReport1_idx` (`Testid`);

--
-- Indexes for table `urine_for_bence_jones_report`
--
ALTER TABLE `urine_for_bence_jones_report`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_urine_for_bence_jones_report_Patient1_idx` (`Patient_ID`),
  ADD KEY `fk_urine_for_bence_jones_report_TestReport1_idx` (`Testid`);

--
-- Indexes for table `UsernamePassword`
--
ALTER TABLE `UsernamePassword`
  ADD PRIMARY KEY (`SystemEmployee_emp_Id`),
  ADD KEY `fk_UsernamePassword_SystemEmployee1_idx` (`SystemEmployee_emp_Id`);

--
-- Indexes for table `ward`
--
ALTER TABLE `ward`
  ADD PRIMARY KEY (`ward_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adminMessage`
--
ALTER TABLE `adminMessage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `bonemarrow_report`
--
ALTER TABLE `bonemarrow_report`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `Chest`
--
ALTER TABLE `Chest`
  MODIFY `chest_Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `c_reactiveprotein_report`
--
ALTER TABLE `c_reactiveprotein_report`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Employee`
--
ALTER TABLE `Employee`
  MODIFY `emp_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `fullblood_report`
--
ALTER TABLE `fullblood_report`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `General`
--
ALTER TABLE `General`
  MODIFY `general_Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `lipidprofile_report`
--
ALTER TABLE `lipidprofile_report`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `liverfunction_report`
--
ALTER TABLE `liverfunction_report`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `messages`
--
ALTER TABLE `messages`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `NonSystemEmployee`
--
ALTER TABLE `NonSystemEmployee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Organ`
--
ALTER TABLE `Organ`
  MODIFY `oragan_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Patient`
--
ALTER TABLE `Patient`
  MODIFY `patient_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=611;

--
-- AUTO_INCREMENT for table `PatientHistory`
--
ALTER TABLE `PatientHistory`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `serumprotein_report`
--
ALTER TABLE `serumprotein_report`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `serum_calcium_report`
--
ALTER TABLE `serum_calcium_report`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `serum_electrolytes`
--
ALTER TABLE `serum_electrolytes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `TestReport`
--
ALTER TABLE `TestReport`
  MODIFY `test_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `thyroid_report`
--
ALTER TABLE `thyroid_report`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ufr_report`
--
ALTER TABLE `ufr_report`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `urine_for_bence_jones_report`
--
ALTER TABLE `urine_for_bence_jones_report`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ward`
--
ALTER TABLE `ward`
  MODIFY `ward_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=87879;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Admin`
--
ALTER TABLE `Admin`
  ADD CONSTRAINT `fk_Admin_SystemEmployee1` FOREIGN KEY (`emp_id`) REFERENCES `SystemEmployee` (`emp_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `adminMessage`
--
ALTER TABLE `adminMessage`
  ADD CONSTRAINT `fk_adminMessage_Employee1` FOREIGN KEY (`Employee_emp_Id`) REFERENCES `Employee` (`emp_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `bonemarrow_report`
--
ALTER TABLE `bonemarrow_report`
  ADD CONSTRAINT `fk_bonemarrow_report_Patient1` FOREIGN KEY (`Patient_Id`) REFERENCES `Patient` (`patient_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_bonemarrow_report_TestReport1` FOREIGN KEY (`TestID`) REFERENCES `TestReport` (`test_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Chest`
--
ALTER TABLE `Chest`
  ADD CONSTRAINT `fk_Chest_Examination1` FOREIGN KEY (`examination_Exam_Id`) REFERENCES `Examination` (`exam_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Consult`
--
ALTER TABLE `Consult`
  ADD CONSTRAINT `fk_Examination_has_Patient_Examination1` FOREIGN KEY (`exam_Id`) REFERENCES `Examination` (`exam_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Examination_has_Patient_Patient1` FOREIGN KEY (`patient_Id`) REFERENCES `Patient` (`patient_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Consultant`
--
ALTER TABLE `Consultant`
  ADD CONSTRAINT `fk_Consultant_SystemEmployee1` FOREIGN KEY (`emp_Id`) REFERENCES `SystemEmployee` (`emp_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `c_reactiveprotein_report`
--
ALTER TABLE `c_reactiveprotein_report`
  ADD CONSTRAINT `fk_c_reactiveprotein_report_Patient1` FOREIGN KEY (`Patient_Id`) REFERENCES `Patient` (`patient_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_c_reactiveprotein_report_TestReport1` FOREIGN KEY (`Testid`) REFERENCES `TestReport` (`test_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Examination`
--
ALTER TABLE `Examination`
  ADD CONSTRAINT `fk_Examination_Patient1` FOREIGN KEY (`patient_Id`) REFERENCES `Patient` (`patient_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Examine`
--
ALTER TABLE `Examine`
  ADD CONSTRAINT `fk_Examine_Consultant1` FOREIGN KEY (`Consultant_emp_Id`) REFERENCES `Consultant` (`emp_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Examine_TestReport1` FOREIGN KEY (`test_Id`) REFERENCES `TestReport` (`test_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `fullblood_report`
--
ALTER TABLE `fullblood_report`
  ADD CONSTRAINT `fk_fullblood_report_Patient1` FOREIGN KEY (`Patient_Id`) REFERENCES `Patient` (`patient_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_fullblood_report_TestReport1` FOREIGN KEY (`Testid`) REFERENCES `TestReport` (`test_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `General`
--
ALTER TABLE `General`
  ADD CONSTRAINT `fk_General_Examination1` FOREIGN KEY (`examination_exam_Id`) REFERENCES `Examination` (`exam_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `LabAssistaant`
--
ALTER TABLE `LabAssistaant`
  ADD CONSTRAINT `fk_LabAssistaant_SystemEmployee1` FOREIGN KEY (`emp_Id`) REFERENCES `SystemEmployee` (`emp_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `lipidprofile_report`
--
ALTER TABLE `lipidprofile_report`
  ADD CONSTRAINT `fk_lipidprofile_report_Patient1` FOREIGN KEY (`Patient_ID`) REFERENCES `Patient` (`patient_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_lipidprofile_report_TestReport1` FOREIGN KEY (`Testid`) REFERENCES `TestReport` (`test_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `liverfunction_report`
--
ALTER TABLE `liverfunction_report`
  ADD CONSTRAINT `fk_liverfunction_report_Patient1` FOREIGN KEY (`Patient_ID`) REFERENCES `Patient` (`patient_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_liverfunction_report_TestReport1` FOREIGN KEY (`Testid`) REFERENCES `TestReport` (`test_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `messages`
--
ALTER TABLE `messages`
  ADD CONSTRAINT `fk_messages_Consultant1` FOREIGN KEY (`Consultant_emp_Id`) REFERENCES `Consultant` (`emp_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_messages_Patient1` FOREIGN KEY (`patient_Id`) REFERENCES `Patient` (`patient_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `NonSystemEmployee`
--
ALTER TABLE `NonSystemEmployee`
  ADD CONSTRAINT `fk_NonSystemEmployee_Employee1` FOREIGN KEY (`emp_Id`) REFERENCES `Employee` (`emp_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Organ`
--
ALTER TABLE `Organ`
  ADD CONSTRAINT `fk_Organ_Examination1` FOREIGN KEY (`examination_exam_Id`) REFERENCES `Examination` (`exam_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Patient`
--
ALTER TABLE `Patient`
  ADD CONSTRAINT `fk_Patient_Consultant1` FOREIGN KEY (`Consultant_emp_Id`) REFERENCES `Consultant` (`emp_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Patient_RegisterDoctor1` FOREIGN KEY (`RegisterDoctor_emp_Id`) REFERENCES `RegisterDoctor` (`emp_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `PatientHistory`
--
ALTER TABLE `PatientHistory`
  ADD CONSTRAINT `fk_PatientHistory_Patient1` FOREIGN KEY (`patient_Id`) REFERENCES `Patient` (`patient_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `RegisterDoctor`
--
ALTER TABLE `RegisterDoctor`
  ADD CONSTRAINT `fk_RegisterDoctor_SystemEmployee1` FOREIGN KEY (`emp_Id`) REFERENCES `SystemEmployee` (`emp_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `serumprotein_report`
--
ALTER TABLE `serumprotein_report`
  ADD CONSTRAINT `fk_serumprotein_report_Patient1` FOREIGN KEY (`Patient_ID`) REFERENCES `Patient` (`patient_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_serumprotein_report_TestReport1` FOREIGN KEY (`Testid`) REFERENCES `TestReport` (`test_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `serum_calcium_report`
--
ALTER TABLE `serum_calcium_report`
  ADD CONSTRAINT `fk_serum_calcium_report_Patient1` FOREIGN KEY (`Patient_ID`) REFERENCES `Patient` (`patient_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_serum_calcium_report_TestReport1` FOREIGN KEY (`Testid`) REFERENCES `TestReport` (`test_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `serum_electrolytes`
--
ALTER TABLE `serum_electrolytes`
  ADD CONSTRAINT `fk_serum_electrolytes_Patient1` FOREIGN KEY (`Patient_ID`) REFERENCES `Patient` (`patient_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_serum_electrolytes_TestReport1` FOREIGN KEY (`Testid`) REFERENCES `TestReport` (`test_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `SystemEmployee`
--
ALTER TABLE `SystemEmployee`
  ADD CONSTRAINT `fk_SystemEmployee_Employee1` FOREIGN KEY (`emp_Id`) REFERENCES `Employee` (`emp_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `TestReport`
--
ALTER TABLE `TestReport`
  ADD CONSTRAINT `fk_TestReport_LabAssistaant1` FOREIGN KEY (`emp_Id`) REFERENCES `LabAssistaant` (`emp_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_TestReport_Patient1` FOREIGN KEY (`patient_Id`) REFERENCES `Patient` (`patient_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `thyroid_report`
--
ALTER TABLE `thyroid_report`
  ADD CONSTRAINT `fk_thyroid_report_Patient1` FOREIGN KEY (`Patient_ID`) REFERENCES `Patient` (`patient_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_thyroid_report_TestReport1` FOREIGN KEY (`Testid`) REFERENCES `TestReport` (`test_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Treatment`
--
ALTER TABLE `Treatment`
  ADD CONSTRAINT `fk_Treatment_Consultant1` FOREIGN KEY (`Consultant_emp_Id`) REFERENCES `Consultant` (`emp_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Treatment_Patient1` FOREIGN KEY (`patient_Id`) REFERENCES `Patient` (`patient_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `ufr_report`
--
ALTER TABLE `ufr_report`
  ADD CONSTRAINT `fk_ufr_report_Patient1` FOREIGN KEY (`Patient_ID`) REFERENCES `Patient` (`patient_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_ufr_report_TestReport1` FOREIGN KEY (`Testid`) REFERENCES `TestReport` (`test_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `urine_for_bence_jones_report`
--
ALTER TABLE `urine_for_bence_jones_report`
  ADD CONSTRAINT `fk_urine_for_bence_jones_report_Patient1` FOREIGN KEY (`Patient_ID`) REFERENCES `Patient` (`patient_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_urine_for_bence_jones_report_TestReport1` FOREIGN KEY (`Testid`) REFERENCES `TestReport` (`test_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `UsernamePassword`
--
ALTER TABLE `UsernamePassword`
  ADD CONSTRAINT `fk_UsernamePassword_SystemEmployee1` FOREIGN KEY (`SystemEmployee_emp_Id`) REFERENCES `SystemEmployee` (`emp_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
