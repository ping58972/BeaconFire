DROP TABLE question;

CREATE TABLE question (
  id int NOT NULL AUTO_INCREMENT,
  question varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE choice;

CREATE TABLE choice (
  id int NOT NULL AUTO_INCREMENT,
  choice varchar(255) DEFAULT NULL,
  question_id int DEFAULT NULL,
  PRIMARY KEY (id),
  KEY `FKcg3lwu4bb512atumed94toojf` (question_id),
  CONSTRAINT `FKcg3lwu4bb512atumed94toojf` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

