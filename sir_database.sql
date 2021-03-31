-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 31 mars 2021 à 20:03
-- Version du serveur :  8.0.21
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `sir_database`
--

-- --------------------------------------------------------

--
-- Structure de la table `board`
--

DROP TABLE IF EXISTS `board`;
CREATE TABLE IF NOT EXISTS `board` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `myProject_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKldejglarawmiaa7notigwf2vq` (`myProject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `board`
--

INSERT INTO `board` (`id`, `description`, `name`, `myProject_id`) VALUES
(7, 'le premier tableau de notre projet', 'mon tableau', 6),
(10, 'le premier tableau de notre projet', 'mon tableau', 9),
(13, 'le premier tableau de notre projet', 'mon tableau', 12);

-- --------------------------------------------------------

--
-- Structure de la table `card`
--

DROP TABLE IF EXISTS `card`;
CREATE TABLE IF NOT EXISTS `card` (
  `id` bigint NOT NULL,
  `endDate` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `timeToDO` int NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `affectedUser_mail` varchar(255) DEFAULT NULL,
  `myBoard_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhvuaa0ne9ssh4nv7wdxp0d01q` (`affectedUser_mail`),
  KEY `FKarwr4c0fbvlah9b25hjsrvy6p` (`myBoard_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `card`
--

INSERT INTO `card` (`id`, `endDate`, `name`, `note`, `status`, `timeToDO`, `url`, `affectedUser_mail`, `myBoard_id`) VALUES
(8, NULL, 'Implémenter les querry', 'il faut finir toute les querry pour passer a l\'étape suivante', 'TODO', 2, NULL, 'theo@mail.com', 7),
(11, NULL, 'Implémenter les querry', 'il faut finir toute les querry pour passer a l\'étape suivante', 'TODO', 2, NULL, NULL, 10),
(14, NULL, 'Implémenter les querry', 'il faut finir toute les querry pour passer a l\'étape suivante', 'TODO', 2, NULL, 'aaaaaaa@mail.com', 13),
(15, NULL, 'finir le projet', 'rendre le projet fini', 'DOING', 2, NULL, NULL, NULL),
(16, NULL, 'finir le projet', 'rendre le projet fini', 'DOING', 5, NULL, NULL, NULL),
(17, NULL, 'finir le projet', 'rendre le projet fini', 'DOING', 5, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `card_tags`
--

DROP TABLE IF EXISTS `card_tags`;
CREATE TABLE IF NOT EXISTS `card_tags` (
  `Card_id` bigint NOT NULL,
  `tags` varchar(255) DEFAULT NULL,
  KEY `FKmb4xrgbtvtfv8pudv0phcqlyw` (`Card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(18),
(18),
(18);

-- --------------------------------------------------------

--
-- Structure de la table `project`
--

DROP TABLE IF EXISTS `project`;
CREATE TABLE IF NOT EXISTS `project` (
  `DTYPE` varchar(31) NOT NULL,
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `beginDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `project`
--

INSERT INTO `project` (`DTYPE`, `id`, `name`, `beginDate`, `endDate`) VALUES
('Project', 6, 'le project', NULL, NULL),
('Project', 9, 'le project', NULL, NULL),
('Project', 12, 'le project', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `mail` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`mail`, `name`) VALUES
('aaaaaaa@mail.com', 'aaaa'),
('Hua@mail.com', 'hua'),
('jean@mail.com', 'jean'),
('t@mail.com', 't'),
('theo@mail.com', 'theo');

-- --------------------------------------------------------

--
-- Structure de la table `user_board`
--

DROP TABLE IF EXISTS `user_board`;
CREATE TABLE IF NOT EXISTS `user_board` (
  `users_mail` varchar(255) NOT NULL,
  `myBoards_id` bigint NOT NULL,
  KEY `FK3ssd1u2micjufm7y0vsr2i6md` (`myBoards_id`),
  KEY `FK9vwfhkh2xr7ukg6qdxmbmnfxw` (`users_mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user_board`
--

INSERT INTO `user_board` (`users_mail`, `myBoards_id`) VALUES
('theo@mail.com', 7),
('aaaaaaa@mail.com', 13);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `board`
--
ALTER TABLE `board`
  ADD CONSTRAINT `FKldejglarawmiaa7notigwf2vq` FOREIGN KEY (`myProject_id`) REFERENCES `project` (`id`);

--
-- Contraintes pour la table `card`
--
ALTER TABLE `card`
  ADD CONSTRAINT `FKarwr4c0fbvlah9b25hjsrvy6p` FOREIGN KEY (`myBoard_id`) REFERENCES `board` (`id`),
  ADD CONSTRAINT `FKhvuaa0ne9ssh4nv7wdxp0d01q` FOREIGN KEY (`affectedUser_mail`) REFERENCES `user` (`mail`);

--
-- Contraintes pour la table `card_tags`
--
ALTER TABLE `card_tags`
  ADD CONSTRAINT `FKmb4xrgbtvtfv8pudv0phcqlyw` FOREIGN KEY (`Card_id`) REFERENCES `card` (`id`);

--
-- Contraintes pour la table `user_board`
--
ALTER TABLE `user_board`
  ADD CONSTRAINT `FK3ssd1u2micjufm7y0vsr2i6md` FOREIGN KEY (`myBoards_id`) REFERENCES `board` (`id`),
  ADD CONSTRAINT `FK9vwfhkh2xr7ukg6qdxmbmnfxw` FOREIGN KEY (`users_mail`) REFERENCES `user` (`mail`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
