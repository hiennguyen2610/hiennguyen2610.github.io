CREATE TABLE `registers` (
  `id` int,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `role` int,
  `created_at` timestamp,
  `updated_at` timestamp
);

CREATE TABLE `classes` (
  `id` int,
  `doctor_id` varchar(255) NOT NULL,
  `class_name` varchar(255) NOT NULL,
  `teacher_id` int,
  `infomation` varchar(255) NOT NULL,
  `created_at` timestamp,
  `updated_at` timestamp
);

CREATE TABLE `enrollments` (
  `id` int,
  `class_id` int,
  `student_id` int,
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `lectures` (
  `id` int,
  `class_id` int,
  `teacher_id` int,
  `title` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `created_at` timestamp,
  `updated_at` timestamp
);

CREATE TABLE `grades` (
  `id` int,
  `class_id` int,
  `student_id` int,
  `date` datetime,
  `score` int,
  `created_at` timestamp,
  `updated_at` timestamp
);

CREATE TABLE `attendence` (
  `id` int,
  `role_id` int,
  `date` datetime,
  `status` varchar(255) NOT NULL,
  `created_at` timestamp,
  `updated_at` timestamp
);

ALTER TABLE `enrollments` ADD FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`);

ALTER TABLE `lectures` ADD FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`);

ALTER TABLE `lectures` ADD FOREIGN KEY (`teacher_id`) REFERENCES `registers` (`role`);

ALTER TABLE `grades` ADD FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`);

ALTER TABLE `grades` ADD FOREIGN KEY (`student_id`) REFERENCES `registers` (`role`);

ALTER TABLE `attendence` ADD FOREIGN KEY (`role_id`) REFERENCES `registers` (`id`);
