CREATE DATABASE  IF NOT EXISTS `hangman_db`;
USE `hangman_db`;

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
    `user_id` int NOT NULL AUTO_INCREMENT,
    `name` varchar(45) NOT NULL,
    PRIMARY KEY (`user_id`),
    UNIQUE KEY `user_id_UNIQUE` (`user_id`),
    UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;


--
-- Table structure for table `words`
--

CREATE TABLE IF NOT EXISTS `words` (
                                       `word_id` int NOT NULL AUTO_INCREMENT,
                                       `value` varchar(45) NOT NULL,
                                       `difficulty` varchar(20) NOT NULL,
                                       PRIMARY KEY (`word_id`),
                                       UNIQUE KEY `word_id_UNIQUE` (`word_id`),
                                       UNIQUE KEY `value_UNIQUE` (`value`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Table structure for table `hangman_games`
--

CREATE TABLE IF NOT EXISTS `hangman_games` (
                                               `game_id` int NOT NULL AUTO_INCREMENT,
                                               `user_id` int NOT NULL,
                                               `word_id` int NOT NULL,
                                               `guessed_word` varchar(45) NOT NULL,
                                               `attempts_left` int NOT NULL,
                                               `game_won` tinyint(1) NOT NULL,
                                               `game_lost` tinyint(1) NOT NULL,
                                               PRIMARY KEY (`game_id`),
                                               UNIQUE KEY `game_id_UNIQUE` (`game_id`),
                                               FOREIGN KEY (`user_id`) REFERENCES `users`(`user_id`),
                                               FOREIGN KEY (`word_id`) REFERENCES `words`(`word_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

