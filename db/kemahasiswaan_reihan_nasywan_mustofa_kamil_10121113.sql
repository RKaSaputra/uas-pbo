-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 25 Jul 2022 pada 08.39
-- Versi server: 10.4.24-MariaDB
-- Versi PHP: 7.4.28

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
-- Struktur dari tabel `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `nim` int(11) NOT NULL,
  `nama` varchar(128) NOT NULL,
  `tempat_lahir` varchar(50) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `alamat` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `mahasiswa`
--

INSERT INTO `mahasiswa` (`nim`, `nama`, `tempat_lahir`, `tanggal_lahir`, `alamat`) VALUES
(10121112, 'Teuku Dika Saputra Zulkarnaen', 'Bandung', '2022-07-01', 'Jl.Kalijati 8');

-- --------------------------------------------------------

--
-- Struktur dari tabel `mahasiswa_nilai`
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

--
-- Dumping data untuk tabel `mahasiswa_nilai`
--

INSERT INTO `mahasiswa_nilai` (`nim`, `nama`, `no_mk`, `nama_mk`, `kehadiran`, `tugas_1`, `tugas_2`, `tugas_3`, `uts`, `uas`, `angkatan`) VALUES
(10121112, 'Teuku Dika Saputra Zulkarnaen', 'A0001', 'Pemrograman Web', 14, 90, 90, 90, 90, 90, 2021);

-- --------------------------------------------------------

--
-- Struktur dari tabel `mata_kuliah`
--

CREATE TABLE `mata_kuliah` (
  `no_mk` varchar(20) NOT NULL,
  `nama_mk` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `mata_kuliah`
--

INSERT INTO `mata_kuliah` (`no_mk`, `nama_mk`) VALUES
('A0001', 'Pemrograman Web');

-- --------------------------------------------------------

--
-- Struktur dari tabel `simulasi_nilai_akhir`
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

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `username` varchar(128) NOT NULL,
  `password` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`username`, `password`) VALUES
('admin', '21232f297a57a5a743894a0e4a801fc3'),
('erika', '21232f297a57a5a743894a0e4a801fc3');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`nim`);

--
-- Indeks untuk tabel `mahasiswa_nilai`
--
ALTER TABLE `mahasiswa_nilai`
  ADD KEY `nim` (`nim`),
  ADD KEY `no_mk` (`no_mk`);

--
-- Indeks untuk tabel `mata_kuliah`
--
ALTER TABLE `mata_kuliah`
  ADD PRIMARY KEY (`no_mk`);

--
-- Indeks untuk tabel `simulasi_nilai_akhir`
--
ALTER TABLE `simulasi_nilai_akhir`
  ADD KEY `no_mk` (`no_mk`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `mahasiswa_nilai`
--
ALTER TABLE `mahasiswa_nilai`
  ADD CONSTRAINT `mahasiswa_nilai_ibfk_1` FOREIGN KEY (`nim`) REFERENCES `mahasiswa` (`nim`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mahasiswa_nilai_ibfk_2` FOREIGN KEY (`no_mk`) REFERENCES `mata_kuliah` (`no_mk`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `simulasi_nilai_akhir`
--
ALTER TABLE `simulasi_nilai_akhir`
  ADD CONSTRAINT `simulasi_nilai_akhir_ibfk_1` FOREIGN KEY (`no_mk`) REFERENCES `mata_kuliah` (`no_mk`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
