-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 27, 2022 at 05:46 PM
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

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`nim`, `nama`, `tempat_lahir`, `tanggal_lahir`, `alamat`) VALUES
(10121109, ' bilal ', ' kutub ', '2022-07-15', ' antartika '),
(10121113, ' reihan nasywan', 'Serang', '2022-07-01', ' samudra pasifik');

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa_nilai`
--

CREATE TABLE `mahasiswa_nilai` (
  `id` int(11) NOT NULL,
  `nim` int(8) NOT NULL,
  `nama` varchar(128) NOT NULL,
  `no_mk` varchar(10) NOT NULL,
  `nama_mk` varchar(30) NOT NULL,
  `kehadiran` int(2) NOT NULL,
  `tugas_1` int(3) NOT NULL,
  `tugas_2` int(3) NOT NULL,
  `tugas_3` int(3) NOT NULL,
  `uts` int(3) NOT NULL,
  `uas` int(3) NOT NULL,
  `angkatan` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mahasiswa_nilai`
--

INSERT INTO `mahasiswa_nilai` (`id`, `nim`, `nama`, `no_mk`, `nama_mk`, `kehadiran`, `tugas_1`, `tugas_2`, `tugas_3`, `uts`, `uas`, `angkatan`) VALUES
(13, 10121109, ' bilal ', 'A0002', ' jepang ', 1, 2, 3, 4, 5, 6, 7);

-- --------------------------------------------------------

--
-- Table structure for table `mata_kuliah`
--

CREATE TABLE `mata_kuliah` (
  `no_mk` varchar(20) NOT NULL,
  `nama_mk` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mata_kuliah`
--

INSERT INTO `mata_kuliah` (`no_mk`, `nama_mk`) VALUES
('A0002', ' jepang '),
('A0003', ' web '),
('A0004', 'algoritma ');

-- --------------------------------------------------------

--
-- Table structure for table `simulasi_nilai`
--

CREATE TABLE `simulasi_nilai` (
  `id` int(11) NOT NULL,
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
-- Dumping data for table `simulasi_nilai`
--

INSERT INTO `simulasi_nilai` (`id`, `no_mk`, `nama_mk`, `persentase_absen`, `persentase_tugas`, `persentase_uts`, `persentase_uas`, `kehadiran`, `tugas_1`, `tugas_2`, `tugas_3`, `uts`, `uas`) VALUES
(3, 'A0004', 'algoritma ', 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
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
  ADD PRIMARY KEY (`id`),
  ADD KEY `nim` (`nim`),
  ADD KEY `no_mk` (`no_mk`);

--
-- Indexes for table `mata_kuliah`
--
ALTER TABLE `mata_kuliah`
  ADD PRIMARY KEY (`no_mk`);

--
-- Indexes for table `simulasi_nilai`
--
ALTER TABLE `simulasi_nilai`
  ADD PRIMARY KEY (`id`),
  ADD KEY `no_mk` (`no_mk`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mahasiswa_nilai`
--
ALTER TABLE `mahasiswa_nilai`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `simulasi_nilai`
--
ALTER TABLE `simulasi_nilai`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

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
-- Constraints for table `simulasi_nilai`
--
ALTER TABLE `simulasi_nilai`
  ADD CONSTRAINT `simulasi_nilai_ibfk_1` FOREIGN KEY (`no_mk`) REFERENCES `mata_kuliah` (`no_mk`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
