DROP DATABASE IF EXISTS `classManagerDB`;

CREATE DATABASE IF NOT EXISTS `classManagerDB`
DEFAULT CHARACTER SET utf8;

USE `classManagerDB`;

DROP TABLE IF EXISTS `User`;
-- ------------------------------------------------
CREATE TABLE IF NOT EXISTS `User` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);
-- ------------------------------------------------
DROP TABLE IF EXISTS `Teacher`;

CREATE TABLE IF NOT EXISTS `Teacher` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) NULL DEFAULT NULL,
  `lastName` varchar(255) NULL DEFAULT NULL,
  `userID` int(11) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`userID`) REFERENCES `user` (`id`)
);
-- ------------------------------------------------
DROP TABLE IF EXISTS `Weekday`;

CREATE TABLE IF NOT EXISTS `Weekday` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NULL DEFAULT NULL,
  `startTime` varchar(255) NULL DEFAULT NULL,
  `endTime` varchar(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);
-- ------------------------------------------------
DROP TABLE IF EXISTS `Class`;

CREATE TABLE IF NOT EXISTS `Class` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NULL DEFAULT NULL,
  `teacherID` int(11) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`teacherID`) REFERENCES `teacher` (`id`)
);
-- ------------------------------------------------
DROP TABLE IF EXISTS `ClassSchedule`;

CREATE TABLE IF NOT EXISTS `ClassSchedule` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `weekDayID` int(11) UNSIGNED NULL DEFAULT NULL,
  `ClassID` int(11) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`weekDayID`) REFERENCES `Weekday` (`id`),
  FOREIGN KEY (`ClassID`) REFERENCES `Class` (`id`)
);
-- ------------------------------------------------
DROP TABLE IF EXISTS `Grade`;

CREATE TABLE IF NOT EXISTS `Grade` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `level` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);
-- ------------------------------------------------
DROP TABLE IF EXISTS `Student`;

CREATE TABLE IF NOT EXISTS `Student` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) NULL DEFAULT NULL,
  `lastName` varchar(255) NULL DEFAULT NULL,
  `classID` int(11) UNSIGNED NULL DEFAULT NULL,
  `gradeID` int(11) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`classID`) REFERENCES `class` (`id`),
  FOREIGN KEY (`gradeID`) REFERENCES `grade` (`id`)
);
-- ------------------------------------------------
DROP TABLE IF EXISTS `Role`;

CREATE TABLE IF NOT EXISTS `Role` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NULL DEFAULT NULL,
  `description` varchar(255) NULL DEFAULT NULL,
  `isCurrent` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`)
);
-- ------------------------------------------------
DROP TABLE IF EXISTS `Student_Role`;

CREATE TABLE IF NOT EXISTS `Student_Role` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `studentID` int(11) UNSIGNED NULL DEFAULT NULL,
  `roleID` int(11) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`studentID`) REFERENCES `student` (`id`),
  FOREIGN KEY (`roleID`) REFERENCES `role` (`id`)
);
-- ------------------------------------------------
-- DROP/CREATE USER
DROP USER 'classManager'@'localhost';
CREATE USER 'classManager'@'localhost' IDENTIFIED BY 'class';
-- Set Permissions
GRANT SELECT, INSERT, UPDATE, DELETE ON `classManagerDB`.* TO 'classManager'@'localhost';
-- ------------------------------------------------
-- Test Data Inserts
START TRANSACTION;

USE `classManagerDB`;
INSERT INTO `User` (`id`, `username`, `password`) VALUES
  (1, 'teacherlady', 'pass1'),
  (2, 'teacherman', 'pass1');

INSERT INTO `Teacher` (`id`, `firstName`, `lastName`, `userID`) VALUES
  (1, 'Annie', 'Anners', 1),
  (2, 'Eddie', 'Eddison', 2);

INSERT INTO `Class` (`id`, `name`,`teacherID`) VALUES
  (1, 'Spanish', 1),
  (2, 'History', 2);


INSERT INTO `Grade` (`id`, `level`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 11),
(12, 12);

INSERT INTO `Student` (`id`, `firstName`, `lastName`, `gradeID`, `classID`) VALUES
  (1, 'Lil Bobbie', 'Bobberson', 6, 1),
  (2, 'Big Bobbie', 'Bobberson', 8, 2),
  (3, 'A-A', 'Aron', 7, 1),
  (4, 'Daisy', 'Mae', 8, 2),
  (5, 'Bugs', 'Bunny', 8, 2),
  (6, 'Lola', 'Bunny', 7, 1);

INSERT INTO `Role` (`id`, `name`, `description`, `isCurrent`) VALUES
  (1, 'Hall Monitor', 'Walk it like you own it', 1),
  (2, 'Room Clean Up', 'Kids are dirty', 1),
  (3, 'Room Setup', 'Get ready to learn!', 1),
  (4, 'Door Holder', 'Be a gentleman', 1),
  (5, 'Sneeze Blesser', 'Bless you', 1),
  (6, 'Taco Maker', 'You gotta be a native speaker', 1);

  INSERT INTO `Student_Role` (`id`, `studentID`, `roleID`) VALUES
  (1, 1, 1),
  (2, 2, 2),
  (3, 3, 3),
  (4, 4, 4),
  (5, 5, 5),
  (6, 6, 6);

  INSERT INTO `Weekday` (`id`, `name`, `startTime`, `endTime`) VALUES
    (1, 'Monday', '8am', '9am'),
    (2, 'Tuesday', '10am', '11am'),
    (3, 'Wednesday', '2pm', '3pm'),
    (4, 'Thursday', '12pm', '1pm'),
    (5, 'Friday', '1pm', '2pm');

  INSERT INTO `ClassSchedule` (`id`, `weekDayID`, `classID`) VALUES
    (1, 1, 1),
    (2, 3, 1),
    (3, 2, 2),
    (4, 4, 2);


  COMMIT;
  -- ----------------------------------------------
