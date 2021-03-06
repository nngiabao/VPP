-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 01, 2020 at 12:38 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qlns`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitietgiam`
--

CREATE TABLE `chitietgiam` (
  `idsanpham` varchar(10) NOT NULL,
  `idgiam` varchar(10) NOT NULL,
  `giam` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `idhd` varchar(10) NOT NULL,
  `idsanpham` varchar(10) NOT NULL,
  `soluong` int(255) NOT NULL,
  `dongia` float NOT NULL,
  `thanhtien` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `chitietphanquyen`
--

CREATE TABLE `chitietphanquyen` (
  `idquyenhan` int(11) NOT NULL,
  `username` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `chitietphanquyen`
--

INSERT INTO `chitietphanquyen` (`idquyenhan`, `username`) VALUES
(8, 'nhanvienban'),
(9, 'nhanviennhap'),
(5, 'admin'),
(1, 'quanly'),
(2, 'quanly'),
(3, 'quanly'),
(4, 'quanly'),
(7, 'quanly'),
(10, 'quanly'),
(1, 'full'),
(2, 'full'),
(3, 'full'),
(4, 'full'),
(5, 'full'),
(7, 'full'),
(8, 'full'),
(9, 'full'),
(10, 'full');

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `idpn` varchar(10) NOT NULL,
  `idsanpham` varchar(10) NOT NULL,
  `soluong` int(255) NOT NULL,
  `gianhap` float NOT NULL,
  `thanhtien` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `chitietphieunhap`
--

INSERT INTO `chitietphieunhap` (`idpn`, `idsanpham`, `soluong`, `gianhap`, `thanhtien`) VALUES
('PN1', 'SP1', 1, 10000, 10000),
('PN2', 'SP1', 1, 10000, 10000),
('PN3', 'SP2', 10, 20000, 200000),
('PN4', 'SP13', 20, 10000, 200000),
('PN5', 'SP13', 20, 20000, 400000),
('PN6', 'SP13', 20, 10000, 200000),
('PN7', 'SP13', 20, 10000, 200000),
('PN8', 'SP1', 2, 10000, 20000),
('PN9', 'SP1', 6, 10000, 60000),
('PN10', 'SP1', 10, 10000, 100000),
('PN11', 'SP1', 20, 20000, 400000),
('PN12', 'NCC2-SP1', 2, 20000, 40000);

-- --------------------------------------------------------

--
-- Table structure for table `chitietquyen`
--

CREATE TABLE `chitietquyen` (
  `idquyenhan` int(11) NOT NULL,
  `tenquyen` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `chitietquyen`
--

INSERT INTO `chitietquyen` (`idquyenhan`, `tenquyen`) VALUES
(1, 'Qu???n l?? m??n ??n'),
(2, 'Ch????ng tr??nh gi???m'),
(3, 'Qu???n l?? kh??ch h??ng'),
(4, 'Qu???n l?? nh??n vi??n'),
(5, 'Qu???n l?? user'),
(6, 'Qu???n l?? phi???u nh???p'),
(7, 'Th???ng k??'),
(8, 'B??n h??ng'),
(9, 'Nh???p h??ng'),
(10, 'Nh?? cung c???p');

-- --------------------------------------------------------

--
-- Table structure for table `chuongtrinhgiam`
--

CREATE TABLE `chuongtrinhgiam` (
  `idgiam` varchar(10) NOT NULL,
  `tenchuongtrinh` varchar(50) NOT NULL,
  `thoigianbatdau` date NOT NULL,
  `thoigianketthuc` date NOT NULL,
  `noidunggiam` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `chuongtrinhgiam`
--

INSERT INTO `chuongtrinhgiam` (`idgiam`, `tenchuongtrinh`, `thoigianbatdau`, `thoigianketthuc`, `noidunggiam`) VALUES
('sad', 'dsadasd', '2020-06-18', '2020-06-19', 'dsadasdasddsadasdasdasdas'),
('saddas', 'sadasdas', '2020-06-18', '2020-06-19', 'dsadasdas');

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `idhd` varchar(10) NOT NULL,
  `idnv` varchar(10) NOT NULL,
  `idkh` varchar(100) NOT NULL,
  `ngaylap` date NOT NULL,
  `tongtien` float NOT NULL,
  `trangthai` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `idkh` varchar(100) NOT NULL,
  `ho` varchar(255) NOT NULL,
  `ten` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `sodienthoai` varchar(255) NOT NULL,
  `gioitinh` varchar(255) NOT NULL,
  `tongtiendamua` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`idkh`, `ho`, `ten`, `email`, `sodienthoai`, `gioitinh`, `tongtiendamua`) VALUES
('KH1', 'ho1', 'ten1', 'hello@gmail.com', '0123456789', 'Nam', 100000),
('KH2', 'le', 'n???', 'hello@gmail.com', '01234567899', 'N???', 0);

-- --------------------------------------------------------

--
-- Table structure for table `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `idloai` int(11) NOT NULL,
  `tenloai` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `loaisanpham`
--

INSERT INTO `loaisanpham` (`idloai`, `tenloai`) VALUES
(1, 'B??nh '),
(2, 'N?????c');

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `idncc` varchar(10) NOT NULL,
  `tenncc` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `trangthai` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`idncc`, `tenncc`, `email`, `phone`, `trangthai`) VALUES
('NCC1', 'ti???m g?? n?????ng', 'tgn@gmail.com', '07786542132', 0),
('NCC11', 'mirinda', 'mirinda@gmail.com', '07786542110', 0),
('NCC12', 'ph?? h????ng', 'xaxi@gmail.com', '07786542111', 1),
('NCC13', 'b??nh b??o c???i c???n', 'bbcn@gmail.com', '07786542112', 1),
('NCC14', 'th??? ph??t', 'tgn@gmail.com', '07786542113', 1),
('NCC15', 'ph??c k??', 'bmpk@gmail.com', '08786542114', 1),
('NCC16', 'nice', 'nice@gmail.com', '08186542132', 1),
('NCC17', 'ngon ngon', 'ngon@gmail.com', '07886542115', 1),
('NCC18', 'heineiken', 'hen@gmail.com', '08786542116', 1),
('NCC19', 'ph??? ngon', 'phongon@gmail.com', '07786542116', 1),
('NCC2', 'ti???m g?? n?????ng', 'tgn@gmail.com', '07786542132', 1),
('NCC20', 'g???i h???o', 'tgn@gmail.com', '08686542117', 1),
('NCC21', 'h???o h???o', 'haohao@gmail.com', '07786542118', 1),
('NCC22', 'chinsu', 'chinsu@gmail.com', '08678615686', 1),
('NCC23', 'c??m n???m s??? 1', 'comnam@gmail.com', '08678615681', 1),
('NCC24', 'strongbow', 'strongbow@gmail.com', '08678615682', 1),
('NCC25', 'sandwich24h', 'sd24@gmail.com', '08678615683', 1),
('NCC26', 'con b?? c?????i', 'conbocuoi@gmail.com', '08678615684', 1),
('NCC27', 'b??ng lan tr???ng mu???i', 'bonglan@gmail.com', '08678615685', 1),
('NCC28', 'onirigi', 'onirigi@gmail.com', '08678615687', 1),
('NCC29', 'b??nh m?? que', 'banhmique@gmail.com', '08678615688', 1),
('NCC3', 'ti???m g?? quay', 'tgq@gmail.com', '07865421111', 1),
('NCC30', 'les bons', 'lesbons@gmail.com', '08678615689', 1),
('NCC31', 'adsasd', 'dsadasdsadasda@gmail.com', '01111111111', 0),
('NCC32', 'dwqdwq', 'dqwdqw@gmail.com', '01234567890', 0),
('NCC4', 'ti???m v???t quay', 'tvq@gmail.com', '07786542134', 1),
('NCC5', 'ti???m ch??o', 'tc@gmail.com', '07786542133', 1),
('NCC6', 'pepsi', 'pep@gmail.com', '07786542135', 1),
('NCC7', 'coca', 'coca@gmail.com', '07786542136', 1),
('NCC8', 'lavie', 'lavie@gmail.com', '07786542137', 1),
('NCC9', 'ti???m g?? ngon', 'tgng@gmail.com', '07786542138', 1);

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `idnv` varchar(10) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `address` text NOT NULL,
  `ngaysinh` date DEFAULT NULL,
  `luong` varchar(20) NOT NULL,
  `trangthai` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`idnv`, `fname`, `lname`, `phone`, `email`, `address`, `ngaysinh`, `luong`, `trangthai`) VALUES
('NV1', 'Th??nh Anh', 'L??', '09876132168', 'lythanha@gmail.com', '88 nguy???n du, qu???n3', '2020-11-10', '4000000', 1),
('NV10', 'Nguy??n Gi??p', 'L??', '09687348664', 'lenguyengiap@gmail.com', '90 Nam K??? Kh???i Ngh??a, qu???n 1', '2020-11-24', '4500000', 1),
('NV11', 'Th??nh Nam', 'H???', '09687348665', 'lethanhnam@gmail.com', '88 Nam K??? Kh???i Ngh??a, qu???n 3', NULL, '4500000', 1),
('NV12', 'Ng???c H??n', 'Tr???n', '09687348666', 'ngochantran@gmail.com', '66 L?? Du???n, qu???n 1', NULL, '6000000', 1),
('NV13', 'Thanh Vy', 'Nguy???n', '09687348667', 'nguyenthanhvy@gmail.com', '78 ?????ng ??en, qu???n T??n B??nh', NULL, '4500000', 1),
('NV14', 'Ng???c Th??', 'Tr???n', '09687348669', 'tranngoctho@gmail.com', '170 L???c Long Qu??n, qu???n T??n B??nh', NULL, '5000000', 1),
('NV15', 'Ng???c V??', 'Tr???n', '09687348781', 'tranvinhquan@gmail.com', '70 V?? Th??? S??u, qu???n 3', NULL, '4500000', 1),
('NV16', 'Duy Kh??nh', 'Ph???m', '09687348782', 'phamduykhanh@gmail.com', '75 L?? T??? Tr???ng, qu???n 1', NULL, '5000000', 0),
('NV17', 'Gia B???o', 'Tr???n', '09687348783', 'trangiabao@gmail.com', '70 Th??nh Th??i, qu???n 10', NULL, '4500000', 1),
('NV18', 'Gia Huy', 'Tr???n', '09687348784', 'trangiahuy@gmail.com', '7 S?? V???n H???nh, qu???n 5', NULL, '4500000', 0),
('NV19', 'Gia Th???nh', 'T??ng', '09687348785', 'tanggiathinh@gmail.com', '760 S?? V???n H???nh, qu???n 10', NULL, '4500000', 0),
('NV2', 'Vinh Quang', 'Tr???n', '09687348668', 'tranvinhquan@gmail.com', '70 l?? th?????ng ki??t, qu???n 10', NULL, '4500000', 1),
('NV20', 'Ng???c Th???nh', 'Tr???n', '09687348785', 'tranngocthinh@gmail.com', '70 L??? Gia, qu???n 10', NULL, '4500000', 0),
('NV21', 'Qu???nh Nh??', 'H???', '09687348787', 'hoquynhnu@gmail.com', '70 Nguy???n Hu???, qu???n 1', NULL, '4500000', 1),
('NV22', 'Gia Qu???nh', 'L??', '09687348788', 'giaquynhly@gmail.com', '78 L?? Th??nh T??n, qu???n 1', NULL, '6000000', 1),
('NV23', 'Ch?? Quy???n', 'Tr????ng', '09687348789', 'tranvinhquan@gmail.com', '70 l?? th?????ng ki??t, qu???n 10', NULL, '6000000', 1),
('NV24', 'Tr???c V??n', 'L??', '09687348889', 'lytacvan@gmail.com', '70 L?? Th??i T???, qu???n 10', NULL, '5000000', 1),
('NV25', 'Ng???c Th??', 'L??m', '09687348671', 'lamngoctho@gmail.com', '167 ??i???n Bi??n Ph???, qu???n B??nh Th???nh', NULL, '4500000', 1),
('NV26', 'Ph????ng Nam', 'H???', '09687348672', 'hophuongnam@gmail.com', '700 ??i???n Bi??n Ph???, qu???n 3', NULL, '4500000', 1),
('NV27', 'Ng???c Ph????ng', 'L??', '09687348673', 'lengocphuong@gmail.com', '90 Nguy???n Thi???n Thu???t, qu???n 3', NULL, '4500000', 0),
('NV28', 'asdsadasd', 'dsadasdsad', '01234567890', '1231e12e21e@gmail.com', 'ddqwwqdwqdqdwwqd', NULL, '1000000', 0),
('NV29', 'sda', '??????', '01212121212', 'sdao@gmail.com', 'ads??d', '2020-11-01', '12312312', 1),
('NV3', 'V??n T??o', 'Nguy???n', '07892312567', 'nguyenvteo@gmail.com', '22 tr???n h??ng ?????o, qu???n 5', NULL, '3000000', 1),
('NV30', '??d', 'd??', '01212121212', 'dsa@gmail.com', 'd??', '2000-11-22', '213213', 1),
('NV4', 'T??', 'Nguy???n V??n', '09234512345', 'nv4@gmail.com', 'dfg', NULL, '2000000', 1),
('NV5', 'Ch???n Hoa', 'Ho???c', '08967459186', 'hoacchanhoa@gmail.com', '678 C??ch M???ng Th??ng T??m, qu???n 11', NULL, '6000000', 1),
('NV6', 'Th??nh ?????t', 'L??', '09876132168', 'lythanhdat@gmail.com', '60 nguy???n tr??i, qu???n1', NULL, '3500000', 1),
('NV7', 'Phi H???ng', 'Tr???n', '09687348661', 'tranvinhquan@gmail.com', '77 L?? Th?????ng Ki??t, qu???n 10', NULL, '4500000', 1),
('NV8', 'Phi H???ng', 'Ho??ng', '09687348662', 'hoangphihong@gmail.com', '135 L?? Th?????ng Ki??t, qu???n T??n B??nh', NULL, '4500000', 1),
('NV9', 'Ti???u Long', 'L??', '09687348663', 'tieulongly@gmail.com', '70 ??u c??, qu???n 10', NULL, '5000000', 1);

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `idpn` varchar(10) NOT NULL,
  `idncc` varchar(10) NOT NULL,
  `idnv` varchar(10) NOT NULL,
  `ngaynhap` date NOT NULL,
  `tongtien` float NOT NULL,
  `trangthai` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `phieunhap`
--

INSERT INTO `phieunhap` (`idpn`, `idncc`, `idnv`, `ngaynhap`, `tongtien`, `trangthai`) VALUES
('PN1', 'NCC1', 'NV2', '2020-06-18', 10000, 1),
('PN10', 'NCC13', 'NV1', '2020-06-20', 100000, 1),
('PN11', 'NCC13', 'NV1', '2020-06-20', 400000, 1),
('PN12', 'NCC2', 'NV1', '2020-11-26', 40000, 1),
('PN2', 'NCC12', 'NV4', '2020-06-19', 10000, 1),
('PN3', 'NCC13', 'NV1', '2020-06-20', 200000, 1),
('PN4', 'NCC13', 'NV1', '2020-06-20', 200000, 1),
('PN5', 'NCC12', 'NV1', '2020-06-20', 400000, 1),
('PN6', 'NCC13', 'NV1', '2020-06-20', 200000, 1),
('PN7', 'NCC14', 'NV1', '2020-06-20', 200000, 1),
('PN8', 'NCC13', 'NV1', '2020-06-20', 20000, 1),
('PN9', 'NCC13', 'NV1', '2020-06-20', 60000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `idsanpham` varchar(10) NOT NULL,
  `tensanpham` varchar(50) NOT NULL,
  `idloai` int(11) NOT NULL,
  `tonkho` int(255) NOT NULL,
  `soluongdaban` int(255) NOT NULL DEFAULT '0',
  `dongia` float NOT NULL,
  `cogiamgia` tinyint(1) NOT NULL,
  `trangthai` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`idsanpham`, `tensanpham`, `idloai`, `tonkho`, `soluongdaban`, `dongia`, `cogiamgia`, `trangthai`) VALUES
('NCC1-SP1', 'banh ca', 1, 0, 0, 0, 0, 1),
('NCC1-SP2', 'banh beo', 1, 0, 0, 0, 0, 1),
('NCC2-SP1', 'banh beo1', 1, 0, 2, 20000, 0, 1),
('NCC2-SP2', 'banh beo1', 1, 0, 0, 0, 0, 1),
('NCC2-SP3', 'banh cio', 1, 0, 0, 0, 0, 1),
('NCC3-SP12', '??d', 1, 0, 0, 0, 0, 1),
('NCC3-SP13', '??d', 1, 0, 0, 0, 0, 1),
('NCC6-SP1', '', 1, 0, 0, 0, 0, 1),
('NCC6-SP2', 'd??', 1, 0, 0, 0, 0, 1),
('SP0000', 'hello', 1, 0, 0, 0, 0, 1),
('SP1', 'B??nh b??ng lan tr???ng mu???i', 1, 50, 89, 25000, 0, 1),
('SP10', 'B??ng lan d??u', 1, 8, 7, 10000, 0, 1),
('SP11', 'B??ng lan s???u ri??ng', 1, 10, 5, 20000, 0, 1),
('SP12', 'B??nh x???p s???u ri??ng', 1, 10, 5, 20000, 0, 1),
('SP13', 'Coca', 2, 50, 30, 10000, 0, 1),
('SP2', 'Hotdog', 1, 5, 35, 15000, 0, 1),
('SP3', 'B??nh bao tr???ng mu???i', 1, 8, 7, 20000, 0, 1),
('SP4', 'B??nh m?? tr???ng', 1, 19, 7, 15000, 0, 1),
('SP5', 'B??nh bao 2 tr???ng', 1, 9, 6, 20000, 0, 1),
('SP6', 'B??nh m?? ???p la', 1, 15, 5, 15000, 0, 1),
('SP7', 'B??nh m?? g?? x??', 1, 0, 0, 20000, 0, 0),
('SP8', 'B??nh m?? th???t n?????ng', 1, 9, 6, 20000, 0, 1),
('SP9', 'B??nh m?? th???t heo', 1, 10, 5, 20000, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `thamso`
--

CREATE TABLE `thamso` (
  `lai_xuat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `thamso`
--

INSERT INTO `thamso` (`lai_xuat`) VALUES
(10);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(50) CHARACTER SET utf8 NOT NULL,
  `pass` varchar(20) NOT NULL,
  `idnv` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `pass`, `idnv`) VALUES
('admin', 'admin', 'NV2'),
('full', 'full', 'NV1'),
('nhanvienban', 'nhanvienban', 'NV4'),
('nhanviennhap', 'nhanviennhap', 'NV5'),
('quanly', 'quanly', 'NV3');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitietgiam`
--
ALTER TABLE `chitietgiam`
  ADD KEY `idmon` (`idsanpham`),
  ADD KEY `idgiam` (`idgiam`);

--
-- Indexes for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD KEY `idhd` (`idhd`),
  ADD KEY `idmon` (`idsanpham`);

--
-- Indexes for table `chitietphanquyen`
--
ALTER TABLE `chitietphanquyen`
  ADD KEY `idquyenhan` (`idquyenhan`),
  ADD KEY `chitietphanquyen_ibfk_3` (`username`);

--
-- Indexes for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD KEY `idpn` (`idpn`),
  ADD KEY `idmon` (`idsanpham`);

--
-- Indexes for table `chitietquyen`
--
ALTER TABLE `chitietquyen`
  ADD PRIMARY KEY (`idquyenhan`);

--
-- Indexes for table `chuongtrinhgiam`
--
ALTER TABLE `chuongtrinhgiam`
  ADD PRIMARY KEY (`idgiam`),
  ADD UNIQUE KEY `idgiam` (`idgiam`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`idhd`),
  ADD UNIQUE KEY `idhd` (`idhd`),
  ADD KEY `idnv` (`idnv`),
  ADD KEY `idkh` (`idkh`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`idkh`);

--
-- Indexes for table `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`idloai`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`idncc`),
  ADD UNIQUE KEY `idncc` (`idncc`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`idnv`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`idpn`),
  ADD KEY `idncc` (`idncc`),
  ADD KEY `idnv` (`idnv`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`idsanpham`),
  ADD UNIQUE KEY `idmon` (`idsanpham`),
  ADD KEY `idloai` (`idloai`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`),
  ADD KEY `idnv` (`idnv`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chitietquyen`
--
ALTER TABLE `chitietquyen`
  MODIFY `idquyenhan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `idloai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitietgiam`
--
ALTER TABLE `chitietgiam`
  ADD CONSTRAINT `FK_chitietgiam_chuongtrinhgiam` FOREIGN KEY (`idgiam`) REFERENCES `chuongtrinhgiam` (`idgiam`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_chitietgiam_monan` FOREIGN KEY (`idsanpham`) REFERENCES `sanpham` (`idsanpham`) ON UPDATE CASCADE;

--
-- Constraints for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD CONSTRAINT `FK_chitiethoadon_hoadon` FOREIGN KEY (`idhd`) REFERENCES `hoadon` (`idhd`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_chitiethoadon_monan` FOREIGN KEY (`idsanpham`) REFERENCES `sanpham` (`idsanpham`) ON UPDATE CASCADE;

--
-- Constraints for table `chitietphanquyen`
--
ALTER TABLE `chitietphanquyen`
  ADD CONSTRAINT `chitietphanquyen_ibfk_2` FOREIGN KEY (`idquyenhan`) REFERENCES `chitietquyen` (`idquyenhan`) ON UPDATE CASCADE,
  ADD CONSTRAINT `chitietphanquyen_ibfk_3` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD CONSTRAINT `FK_chitietphieunhap_phieunhap` FOREIGN KEY (`idpn`) REFERENCES `phieunhap` (`idpn`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `chitietphieunhap_ibfk_1` FOREIGN KEY (`idsanpham`) REFERENCES `sanpham` (`idsanpham`) ON UPDATE CASCADE;

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `FK_hoadon_nhanvien` FOREIGN KEY (`idnv`) REFERENCES `nhanvien` (`idnv`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`idkh`) REFERENCES `khachhang` (`idkh`) ON UPDATE CASCADE;

--
-- Constraints for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `FK_phieunhap_nhacungcap` FOREIGN KEY (`idncc`) REFERENCES `nhacungcap` (`idncc`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_phieunhap_nhanvien` FOREIGN KEY (`idnv`) REFERENCES `nhanvien` (`idnv`) ON UPDATE CASCADE;

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`idloai`) REFERENCES `loaisanpham` (`idloai`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`idnv`) REFERENCES `nhanvien` (`idnv`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
