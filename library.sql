# Host: localhost  (Version: 5.7.3-m13-log)
# Date: 2014-06-30 18:12:37
# Generator: MySQL-Front 5.3  (Build 4.128)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "book"
#

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) NOT NULL DEFAULT '',
  `book_author` varchar(255) NOT NULL DEFAULT '',
  `book_publisher` varchar(255) NOT NULL DEFAULT '',
  `book_state` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

#
# Data for table "book"
#

INSERT INTO `book` VALUES (27,'算法','max','人民出版社',0),(28,'java','jason','清华',0),(29,'windows编程','finoa','新华',1),(30,'linux','jack','新华',1),(31,'unix','michael','邮电',0),(32,'数据结构','kevin','工业出版社',0),(33,'c++','谭浩强','清华出版社',1);

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL DEFAULT '',
  `password` varchar(45) NOT NULL,
  `type` varchar(2) NOT NULL,
  `email` varchar(100) NOT NULL DEFAULT '',
  `state` int(2) unsigned NOT NULL DEFAULT '0',
  `user_account` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'杰克逊','111111','4','test1@g.com',0,'test11'),(2,'test2','123456','4','g@c.com',1,'test22'),(4,'刘德华','123456','4','d@c.c',1,'test33'),(9,'周杰伦','123456','4','d@d.cm',1,'test44'),(10,'emonkr','123456','3','d@d.com',0,'test55'),(12,'administrator','123456','1','123@g.com',0,'admin'),(13,'dd','123456','4','dsa@cc.cc',0,'test77'),(14,'asdfghjk','123456','2','asd@123.com',0,'test88');

#
# Structure for table "orderbook"
#

DROP TABLE IF EXISTS `orderbook`;
CREATE TABLE `orderbook` (
  `order_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `book_id` int(10) unsigned NOT NULL,
  `order_date` date NOT NULL,
  `return_date` date DEFAULT NULL,
  `ifreturn` varchar(2) NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `user_id` (`user_id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

#
# Data for table "orderbook"
#

INSERT INTO `orderbook` VALUES (21,12,28,'2014-06-30','2014-06-30','1'),(22,12,33,'2014-06-30',NULL,'0'),(23,1,29,'2014-06-30',NULL,'0'),(24,1,30,'2014-06-30',NULL,'0');
