<<<<<<< HEAD
-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 23, 2022 at 04:07 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kemahasiswaan_reihan_nasywan_mustofa_kamil_10121113`
--

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--
=======
/*
SQLyog Community v13.1.9 (64 bit)
MySQL - 10.4.24-MariaDB : Database - kemahasiswaan_reihan_nasywan_mustofa_kamil_10121113
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`kemahasiswaan_reihan_nasywan_mustofa_kamil_10121113` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `kemahasiswaan_reihan_nasywan_mustofa_kamil_10121113`;

/*Table structure for table `mahasiswa` */

DROP TABLE IF EXISTS `mahasiswa`;
>>>>>>> 006c91a13b9892a9b41dbe3b6a36a30e8fe7a823

CREATE TABLE `mahasiswa` (
  `nim` int(11) NOT NULL,
  `nama` varchar(128) NOT NULL,
  `tempat_lahir` varchar(50) NOT NULL,
  `tanggal_lahir` date NOT NULL,
<<<<<<< HEAD
  `alamat` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa_nilai`
--

CREATE TABLE `mahasiswa_nilai` (
  `nim` int(11) NOT NULL,
  `nama` varchar(128) NOT NULL,
  `no_mk` varchar(20) NOT NULL,
  `nama_mk` varchar(20) NOT NULL,
=======
  `alamat` varchar(256) NOT NULL,
  PRIMARY KEY (`nim`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `mahasiswa` */

/*Table structure for table `mahasiswa_nilai` */

DROP TABLE IF EXISTS `mahasiswa_nilai`;

CREATE TABLE `mahasiswa_nilai` (
  `nama` varchar(128) NOT NULL,
  `nim` int(11) NOT NULL,
  `nama_mk` varchar(20) NOT NULL,
  `no_mk` varchar(50) NOT NULL,
>>>>>>> 006c91a13b9892a9b41dbe3b6a36a30e8fe7a823
  `kehadiran` int(2) NOT NULL,
  `tugas_1` int(3) NOT NULL,
  `tugas_2` int(3) NOT NULL,
  `tugas_3` int(3) NOT NULL,
  `uts` int(3) NOT NULL,
  `uas` int(3) NOT NULL,
<<<<<<< HEAD
  `angkatan` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `mata_kuliah`
--

CREATE TABLE `mata_kuliah` (
  `no_mk` varchar(20) NOT NULL,
  `nama_mk` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `simulasi_nilai_akhir`
--

CREATE TABLE `simulasi_nilai_akhir` (
  `no_mk` varchar(20) NOT NULL,
  `nama_mk` varchar(50) NOT NULL,
=======
  `angkatan` int(4) NOT NULL,
  KEY `nim` (`nim`),
  KEY `no_mk` (`no_mk`),
  CONSTRAINT `mahasiswa_nilai_ibfk_1` FOREIGN KEY (`nim`) REFERENCES `mahasiswa` (`nim`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `mahasiswa_nilai_ibfk_2` FOREIGN KEY (`no_mk`) REFERENCES `mata_kuliah` (`no_mk`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `mahasiswa_nilai` */

/*Table structure for table `mata_kuliah` */

DROP TABLE IF EXISTS `mata_kuliah`;

CREATE TABLE `mata_kuliah` (
  `no_mk` varchar(20) NOT NULL,
  `nama_mk` varchar(50) NOT NULL,
  PRIMARY KEY (`no_mk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `mata_kuliah` */

/*Table structure for table `simulasi_nilai_akhir` */

DROP TABLE IF EXISTS `simulasi_nilai_akhir`;

CREATE TABLE `simulasi_nilai_akhir` (
  `nama_mk` varchar(50) NOT NULL,
  `no_mk` varchar(20) NOT NULL,
>>>>>>> 006c91a13b9892a9b41dbe3b6a36a30e8fe7a823
  `persentase_absen` int(3) NOT NULL,
  `persentase_tugas` int(3) NOT NULL,
  `persentase_uts` int(3) NOT NULL,
  `persentase_uas` int(3) NOT NULL,
  `kehadiran` int(2) NOT NULL,
  `tugas_1` int(3) NOT NULL,
  `tugas_2` int(3) NOT NULL,
  `tugas_3` int(3) NOT NULL,
  `uts` int(3) NOT NULL,
<<<<<<< HEAD
  `uas` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`nim`);

--
-- Indexes for table `mahasiswa_nilai`
--
ALTER TABLE `mahasiswa_nilai`
  ADD KEY `nim` (`nim`),
  ADD KEY `no_mk` (`no_mk`);

--
-- Indexes for table `mata_kuliah`
--
ALTER TABLE `mata_kuliah`
  ADD PRIMARY KEY (`no_mk`);

--
-- Indexes for table `simulasi_nilai_akhir`
--
ALTER TABLE `simulasi_nilai_akhir`
  ADD KEY `no_mk` (`no_mk`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `mahasiswa_nilai`
--
ALTER TABLE `mahasiswa_nilai`
  ADD CONSTRAINT `mahasiswa_nilai_ibfk_1` FOREIGN KEY (`nim`) REFERENCES `mahasiswa` (`nim`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mahasiswa_nilai_ibfk_2` FOREIGN KEY (`no_mk`) REFERENCES `mata_kuliah` (`no_mk`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `simulasi_nilai_akhir`
--
ALTER TABLE `simulasi_nilai_akhir`
  ADD CONSTRAINT `simulasi_nilai_akhir_ibfk_1` FOREIGN KEY (`no_mk`) REFERENCES `mata_kuliah` (`no_mk`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
=======
  `uas` int(3) NOT NULL,
  KEY `no_mk` (`no_mk`),
  CONSTRAINT `simulasi_nilai_akhir_ibfk_1` FOREIGN KEY (`no_mk`) REFERENCES `mata_kuliah` (`no_mk`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `simulasi_nilai_akhir` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
>>>>>>> 006c91a13b9892a9b41dbe3b6a36a30e8fe7a823
