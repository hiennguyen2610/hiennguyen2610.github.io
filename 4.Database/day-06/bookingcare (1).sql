-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 28, 2023 at 05:32 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bookingcare`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointments`
--

CREATE TABLE `appointments` (
  `id` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `doctors_id` int(11) DEFAULT NULL,
  `patient_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `appointments`
--

INSERT INTO `appointments` (`id`, `date`, `doctors_id`, `patient_id`) VALUES
(19, '2023-04-01', 8, 6),
(20, '2023-04-01', 4, 2),
(21, '2023-04-02', 9, 5),
(22, '2023-04-04', 8, 4);

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`id`, `name`, `phone`, `description`) VALUES
(1, 'Khoa Ung Bướu', '19001001', 'Là chuyên khoa quan trọng của ngoại khoa, có chức năng tầm soát, chẩn đoán, điều trị và cung cấp mọi dịch vụ y tế cần thiết cho bệnh nhân ung thư.'),
(2, 'Khoa Ngoại Tim Mạch', '19001002', 'Khoa ngoại tim mạch chuyên về điều trị các bệnh lý ngoại khoa có liên quan đến vấn đề lồng ngực - tim mạch như tim bẩm sinh, suy tim, phình động mạch, tổn thương/chấn thương thành ngực, phổi và các cơ quan trong lồng ngực.'),
(3, 'Khoa Tiết Niệu', '19001038', 'Chuyên khám, điều trị các bệnh lý về đường tiết niệu (gồm thận - niệu quản - bàng quang - niệu đạo), và các bệnh lý về tuyến tiền liệt ở nam giới theo phương pháp nội khoa. Các bệnh lý phổ biến thuộc khoa Nội Thận - Tiết niệu như: tiểu không tự chủ, ung t'),
(4, 'Phẫu thuật thẩm mỹ', '19002008', 'Là một bộ môn y học chuyên sâu, có liên quan đến rất nhiều chuyên ngành khác nhau, thực hiện những can thiệp ngoại khoa có chủ đích lên cơ thể khoẻ mạnh với mục đích làm đẹp đơn thuần, hoặc phục vụ cho những đối tượng có nhu cầu tái tạo, sửa chữa các khiế'),
(5, 'Nội Hô Hấp', '19005222', 'Khoa Nội hô hấp với chức năng điều trị tập trung theo phương pháp nội khoa bao gồm khám lâm sàng thực thể phối hợp thăm dò chức năng hô hấp theo phương pháp cận lâm sàng, trị liệu bằng thuốc dạng hít và dạng uống, xông rửa và thông chống nghẹt, chọc dò và'),
(6, 'Ngoại Hô Hấp', '19004567', 'Khoa Ngoại hô hấp giữ chức năng chẩn khám và điều trị các bệnh lý về hô hấp với các biện pháp can thiệp ngoại khoa, được thực hiện bởi các chuyên gia Lao Phổi và phẫu thuật lồng ngực. Các bệnh lý phổ biến của khoa Ngoại hô hấp như: lao phổi nặng, ung thư ');

-- --------------------------------------------------------

--
-- Table structure for table `diagnosis`
--

CREATE TABLE `diagnosis` (
  `id` int(11) NOT NULL,
  `doctors_id` int(11) DEFAULT NULL,
  `patient_id` int(11) DEFAULT NULL,
  `medication` varchar(255) DEFAULT NULL,
  `diagnosis` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `diagnosis`
--

INSERT INTO `diagnosis` (`id`, `doctors_id`, `patient_id`, `medication`, `diagnosis`) VALUES
(1, 3, 4, 'Bleomycin Sulfate, Cetuximab, Docetaxel', 'Ung thư vòm họng gđ1'),
(2, 10, 3, 'Prednisolone, Dexamethasone, Codeine', 'Viêm đường hô hấp cấp tính'),
(3, 9, 1, 'Roflumilast, Corticosteroid', 'Phổi tắc nghẽn mạn tính'),
(4, 7, 5, 'Thuốc kháng sinh, thuốc an thần', 'Nâng ngực 300cc');

-- --------------------------------------------------------

--
-- Table structure for table `doctors`
--

CREATE TABLE `doctors` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `doctors`
--

INSERT INTO `doctors` (`id`, `email`, `password`, `name`, `phone`, `address`, `department_id`) VALUES
(3, 'hungnt.ungbieu@gmail.com', 'hungungbieu', 'Nguyễn Tuấn Hùng', '0973666455', '180 Trần Cung, Nghĩa Tân, Cầu Giấy, Hà Nội', 1),
(4, 'huynhat@gmail.com', 'nhathuy77', 'Nguyễn Huy Nhật', '0326888999', '12 Nguyễn Xiển, Thanh Xuân, Hà Nội', 1),
(5, 'hoalan@gmail.com', 'lanlan', 'Phan Quỳnh Lan', '0978898989', '12 Phạm Văn Đồng, Bắc Từ Liêm, Hà Nội', 2),
(6, 'minhtu@gmail.com', 'tuminh', 'Nguyễn Minh Tú', '0987126123', '12 Hoàng Quốc Việt, Cầu Giấy, Hà Nội', 2),
(7, 'Sage@gmail.com', 'sagesss', 'Jean Clement Sage', '0129475134', 'Hoàn Kiếm, Hà Nội', 4),
(8, 'liemthanh@gmail.com', 'thanhliem12', 'Nguyễn Thanh Liêm', '0987888999', 'Trần Phú, Hà Đông, Hà Nội', 3),
(9, 'robettocarlos@gmail.com', 'monica', 'Moreyra Francisco Carlos', '0973737373', '102 Khương Trung, Thanh Xuân, Hà Nội', 5),
(10, 'PhilippeMacaire@gmail.com', 'Pmacaire', 'Philippe Macaire', '03461756988', 'Khu tập thể Đại học Bách Khoa, Hà Nội', 6);

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `id` int(11) NOT NULL,
  `patients_id` int(11) DEFAULT NULL,
  `doctors_id` int(11) DEFAULT NULL,
  `contents` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`id`, `patients_id`, `doctors_id`, `contents`) VALUES
(1, 4, 3, 'Bác sĩ vòi phong bì, làm việc không có tâm'),
(2, 1, 9, 'Cảm ơn bác sĩ đã phát hiện sớm căn bệnh ung thư giai đoạn cuối của tôi');

-- --------------------------------------------------------

--
-- Table structure for table `medicaltion`
--

CREATE TABLE `medicaltion` (
  `id` int(11) NOT NULL,
  `diagnosis_id` int(11) DEFAULT NULL,
  `doctors_id` int(11) DEFAULT NULL,
  `patient_id` int(11) DEFAULT NULL,
  `user manual` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `medicaltion`
--

INSERT INTO `medicaltion` (`id`, `diagnosis_id`, `doctors_id`, `patient_id`, `user manual`) VALUES
(5, 1, NULL, NULL, 'Mỗi loại ngày uống 2 lần sáng và tối sau khi ăn, mỗi lần 2 viên'),
(6, 2, NULL, NULL, 'Mỗi loại ngày uống 3 lần sáng và tối sau khi ăn, mỗi lần 5 viên'),
(7, 3, NULL, NULL, 'Mỗi loại ngày uống 1 lần vào buổi sáng sau khi ăn, mỗi lần 2 viên'),
(8, 4, NULL, NULL, '');

-- --------------------------------------------------------

--
-- Table structure for table `patients`
--

CREATE TABLE `patients` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `patients`
--

INSERT INTO `patients` (`id`, `email`, `password`, `name`, `phone`, `address`) VALUES
(1, 'hoanganhtu@gmail.com', 'hoanganhtu', 'Hoàng Anh Tú', '0978256336', 'Số 1 đường Cầu Giấy, Hà Nội'),
(2, 'anh@gmail.com', 'vietanh12', 'Nguyễn Việt Anh', '0327454563', '12/82 Trần Cung, Nghĩa Tân, Cầu Giấy, Hà Nội'),
(3, 'minhhang@gmail.com', 'minhhang1212', 'Trịnh Minh Hằng', '0988888322', 'BT13 H7 Khu đô thị Starlake, Tây Hồ'),
(4, 'quoccuong@gmail.com', 'cuong99', 'Nguyễn Quốc Cường', '0312489652', '128 Nguyễn Trãi, Thanh Xuân, Hà Nội'),
(5, 'yen@gmail.com', 'haiyen', 'Dương Hải Yến', '0346266366', 'RiveraPark, Thanh Xuân, Hà Nội'),
(6, 'huuminh123@gmail.com', 'satthu', 'Trần Hữu Minh', '0365255147', 'Văn Giang, Hưng Yên');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `id` int(11) NOT NULL,
  `medicaltion_id` int(11) DEFAULT NULL,
  `services_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`id`, `medicaltion_id`, `services_id`) VALUES
(1, 5, 1),
(2, 7, 7);

-- --------------------------------------------------------

--
-- Table structure for table `services`
--

CREATE TABLE `services` (
  `id` int(11) NOT NULL,
  `department_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `services`
--

INSERT INTO `services` (`id`, `department_id`, `name`, `price`) VALUES
(1, 1, 'Xét nghiệm tầm soát ung thư', '3.500.000 VNĐ'),
(2, 1, 'Xạ trị', '12.000.000 VNĐ'),
(3, 3, 'Siêu âm sỏi thận', '180.000 VNĐ'),
(4, 3, ' Tán sỏi thận bằng sóng siêu âm', '6.500.000 VNĐ'),
(5, 3, 'Nội soi đại tràng gây mê', '1.500.000 VNĐ'),
(6, 2, 'Xét nghiệm máu', '2.000.000 VNĐ'),
(7, 2, 'Phẫu thuật phình động mạch', '18.000.000 VNĐ'),
(8, 4, 'Nâng ngực', '40.000.000 VNĐ'),
(9, 4, 'Nâng mũi', '30.000.000 VNĐ'),
(10, 6, 'Phẫu thuật tràn dịch màng phổi', '13.000.000 VNĐ'),
(11, 6, 'Viêm phổi', '1.000.000 VNĐ'),
(12, 1, 'Ghép tế bào gốc', '200.000.000 VNĐ');

-- --------------------------------------------------------

--
-- Table structure for table `time_slots`
--

CREATE TABLE `time_slots` (
  `id` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `doctors_id` int(11) DEFAULT NULL,
  `is_available` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `time_slots`
--

INSERT INTO `time_slots` (`id`, `date`, `doctors_id`, `is_available`) VALUES
(1, '2023-03-29', 3, NULL),
(2, '2023-03-29', 4, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointments`
--
ALTER TABLE `appointments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `doctors_id` (`doctors_id`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `diagnosis`
--
ALTER TABLE `diagnosis`
  ADD PRIMARY KEY (`id`),
  ADD KEY `patient_id` (`patient_id`),
  ADD KEY `doctors_id` (`doctors_id`);

--
-- Indexes for table `doctors`
--
ALTER TABLE `doctors`
  ADD PRIMARY KEY (`id`),
  ADD KEY `department_id` (`department_id`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`id`),
  ADD KEY `doctors_id` (`doctors_id`),
  ADD KEY `patients_id` (`patients_id`);

--
-- Indexes for table `medicaltion`
--
ALTER TABLE `medicaltion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `patient_id` (`patient_id`),
  ADD KEY `diagnosis_id` (`diagnosis_id`),
  ADD KEY `doctors_id` (`doctors_id`);

--
-- Indexes for table `patients`
--
ALTER TABLE `patients`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `services_id` (`services_id`),
  ADD KEY `medicaltion_id` (`medicaltion_id`);

--
-- Indexes for table `services`
--
ALTER TABLE `services`
  ADD PRIMARY KEY (`id`),
  ADD KEY `department_id` (`department_id`);

--
-- Indexes for table `time_slots`
--
ALTER TABLE `time_slots`
  ADD PRIMARY KEY (`id`),
  ADD KEY `doctors_id` (`doctors_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointments`
--
ALTER TABLE `appointments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `diagnosis`
--
ALTER TABLE `diagnosis`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `doctors`
--
ALTER TABLE `doctors`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `medicaltion`
--
ALTER TABLE `medicaltion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `patients`
--
ALTER TABLE `patients`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `services`
--
ALTER TABLE `services`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `time_slots`
--
ALTER TABLE `time_slots`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointments`
--
ALTER TABLE `appointments`
  ADD CONSTRAINT `appointments_ibfk_1` FOREIGN KEY (`doctors_id`) REFERENCES `doctors` (`id`);

--
-- Constraints for table `diagnosis`
--
ALTER TABLE `diagnosis`
  ADD CONSTRAINT `diagnosis_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`),
  ADD CONSTRAINT `diagnosis_ibfk_2` FOREIGN KEY (`doctors_id`) REFERENCES `doctors` (`id`);

--
-- Constraints for table `doctors`
--
ALTER TABLE `doctors`
  ADD CONSTRAINT `doctors_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`);

--
-- Constraints for table `feedback`
--
ALTER TABLE `feedback`
  ADD CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`patients_id`) REFERENCES `patients` (`id`),
  ADD CONSTRAINT `feedback_ibfk_2` FOREIGN KEY (`doctors_id`) REFERENCES `doctors` (`id`),
  ADD CONSTRAINT `feedback_ibfk_3` FOREIGN KEY (`patients_id`) REFERENCES `patients` (`id`);

--
-- Constraints for table `medicaltion`
--
ALTER TABLE `medicaltion`
  ADD CONSTRAINT `medicaltion_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`),
  ADD CONSTRAINT `medicaltion_ibfk_2` FOREIGN KEY (`diagnosis_id`) REFERENCES `diagnosis` (`id`),
  ADD CONSTRAINT `medicaltion_ibfk_3` FOREIGN KEY (`doctors_id`) REFERENCES `doctors` (`id`),
  ADD CONSTRAINT `medicaltion_ibfk_4` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`),
  ADD CONSTRAINT `medicaltion_ibfk_5` FOREIGN KEY (`diagnosis_id`) REFERENCES `diagnosis` (`id`),
  ADD CONSTRAINT `medicaltion_ibfk_6` FOREIGN KEY (`doctors_id`) REFERENCES `doctors` (`id`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`services_id`) REFERENCES `services` (`id`),
  ADD CONSTRAINT `payment_ibfk_2` FOREIGN KEY (`medicaltion_id`) REFERENCES `medicaltion` (`id`);

--
-- Constraints for table `services`
--
ALTER TABLE `services`
  ADD CONSTRAINT `services_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`);

--
-- Constraints for table `time_slots`
--
ALTER TABLE `time_slots`
  ADD CONSTRAINT `time_slots_ibfk_1` FOREIGN KEY (`doctors_id`) REFERENCES `doctors` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
