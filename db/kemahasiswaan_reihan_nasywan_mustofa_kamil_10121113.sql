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

CREATE TABLE `mahasiswa` (
  `nim` int(11) NOT NULL,
  `nama` varchar(128) NOT NULL,
  `tempat_lahir` varchar(50) NOT NULL,
  `tanggal_lahir` date NOT NULL,
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
  `kehadiran` int(2) NOT NULL,
  `tugas_1` int(3) NOT NULL,
  `tugas_2` int(3) NOT NULL,
  `tugas_3` int(3) NOT NULL,
  `uts` int(3) NOT NULL,
  `uas` int(3) NOT NULL,
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
  `persentase_absen` int(3) NOT NULL,
  `persentase_tugas` int(3) NOT NULL,
  `persentase_uts` int(3) NOT NULL,
  `persentase_uas` int(3) NOT NULL,
  `kehadiran` int(2) NOT NULL,
  `tugas_1` int(3) NOT NULL,
  `tugas_2` int(3) NOT NULL,
  `tugas_3` int(3) NOT NULL,
  `uts` int(3) NOT NULL,
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
