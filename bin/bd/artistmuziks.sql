-- phpMyAdmin SQL Dump
-- version 4.4.15.9
-- https://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Sam 28 Avril 2018 à 21:32
-- Version du serveur :  5.7.19-log
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `artistmuziks`
--

-- --------------------------------------------------------

--
-- Structure de la table `album`
--

CREATE TABLE IF NOT EXISTS `album` (
  `id` int(11) NOT NULL,
  `titre` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `genre` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prix` double NOT NULL,
  `imgCover` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `distributeur` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `anneSortie` int(4) NOT NULL,
  `numArtist` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `album`
--

INSERT INTO `album` (`id`, `titre`, `genre`, `prix`, `imgCover`, `distributeur`, `anneSortie`, `numArtist`) VALUES
(1, 'I am glad', 'pop', 70, '1', 'David LaChapelle Studio Inc.PRO.', 2002, 1),
(2, 'Bad', 'Pop', 80, '2', 'Epic Records ', 1987, 2),
(3, 'Something Special', 'Pop', 87, '3', 'Shop Vinyl and CDs', 1981, 3),
(4, 'Classic Series', 'Pop', 67, '4', 'Q-Zone Records', 2006, 4);

-- --------------------------------------------------------

--
-- Structure de la table `artiste`
--

CREATE TABLE IF NOT EXISTS `artiste` (
  `idArtiste` int(11) NOT NULL,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `membre` tinyint(1) NOT NULL,
  `photo` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2335 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `artiste`
--

INSERT INTO `artiste` (`idArtiste`, `nom`, `membre`, `photo`) VALUES
(1, 'Jennifer Lopez', 1, 1),
(2, 'Michael Jackson', 0, 2),
(3, 'Kool and The Gang', 1, 3),
(4, 'Selena Gomez', 1, 4),
(5, 'Miley Cyrus', 1, 5),
(6, 'LL Cool J', 1, 6),
(7, 'The FuGees', 1, 7),
(8, 'Elvis Presley', 0, 8),
(9, 'Prince Rogers Nelson', 0, 9),
(10, 'Wanda Johnson', 1, 10),
(11, 'Helen Folasade Adu', 1, 11),
(12, 'Terri Clark', 1, 12),
(2334, 'GGGGGGGGGDFJ', 0, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `idUser` int(11) NOT NULL,
  `userName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `oldPassword` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`idUser`, `userName`, `password`, `date`, `oldPassword`) VALUES
(1, 'admin', 'admin', '2018-04-12 22:51:15', ''),
(2, 'user', 'user', '2018-04-12 22:51:30', ''),
(3, 'vlad', 'vlad', '2018-04-12 22:51:43', '');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`id`),
  ADD KEY `artistAlbumDex` (`numArtist`);

--
-- Index pour la table `artiste`
--
ALTER TABLE `artiste`
  ADD PRIMARY KEY (`idArtiste`),
  ADD UNIQUE KEY `photo` (`photo`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`idUser`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `album`
--
ALTER TABLE `album`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `artiste`
--
ALTER TABLE `artiste`
  MODIFY `idArtiste` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2335;
--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `album`
--
ALTER TABLE `album`
  ADD CONSTRAINT `album_ibfk_1` FOREIGN KEY (`numArtist`) REFERENCES `artiste` (`idArtiste`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
