Projet en ligne :
http://89.36.213.141:8080/Easyrainway

- Pour lancer le projet , vous devez changer login et mdp de votre base donne
dans le fichier persistence.xml

- Les donnees pour exemple :

INSERT INTO `billet` (`id_billet`, `date_dept`, `heure_arrive`, `heure_dept`, `nom_client`, `prix`, `type_class`, `ville_arrive`, `ville_dept`, `id_reservation`, `numero_billet`) VALUES
(1, '2016-05-22', '10:00:00', '08:00:00', '', 20, 2, 'Lyon', 'Paris', 2, NULL),
(2, '2016-05-24', '10:00:00', '08:00:00', '', 20, 2, 'Lyon', 'Paris', 3, NULL),
(3, '2016-05-24', '10:00:00', '08:00:00', '', 20, 1, 'Lyon', 'Paris', 3, NULL),
(4, '2016-05-24', '11:00:00', '09:00:00', '', 30, 2, 'Lyon', 'Paris', 3, NULL),
(8, '2016-06-07', '07:00:00', '05:00:00', '', 20, 2, 'Lyon', 'Paris', 7, NULL),
(9, '2016-06-07', '09:00:00', '07:00:00', '', 20, 2, 'Lyon', 'Paris', 7, NULL),
(10, '2016-06-07', '07:00:00', '05:00:00', '', 20, 2, 'Lyon', 'Paris', 8, NULL),
(11, '2016-06-07', '15:00:00', '13:00:00', '', 20, 2, 'Lyon', 'Paris', 8, NULL),
(12, '2016-06-07', '09:00:00', '07:00:00', '', 20, 2, 'Lyon', 'Paris', 9, NULL),
(13, '2016-06-07', '11:00:00', '09:00:00', '', 20, 2, 'Lyon', 'Paris', 9, NULL);

--
-- Contenu de la table `places`
--

INSERT INTO `places` (`id_places`, `date_dept`, `nombre_places`, `prix`, `type_class`, `id_trajet`) VALUES
(1, '2016-06-09', 100, 60, 1, 1),
(69, '2016-06-09', 100, 60, 1, 2),
(70, '2016-06-09', 100, 60, 1, 3),
(71, '2016-06-09', 100, 60, 1, 4),
(72, '2016-06-09', 100, 60, 1, 5),
(73, '2016-06-09', 100, 60, 1, 6),
(74, '2016-06-09', 100, 60, 1, 7),
(75, '2016-06-09', 100, 60, 1, 8),
(76, '2016-06-09', 100, 60, 1, 9),
(77, '2016-06-09', 100, 60, 1, 10),
(78, '2016-06-09', 100, 60, 1, 11),
(79, '2016-06-09', 100, 60, 1, 12),
(80, '2016-06-09', 100, 60, 1, 13),
(81, '2016-06-09', 100, 60, 1, 14),
(82, '2016-06-09', 100, 60, 1, 15),
(83, '2016-06-09', 100, 60, 1, 16),
(84, '2016-06-09', 100, 60, 1, 17),
(85, '2016-06-09', 100, 60, 1, 18),
(86, '2016-06-09', 100, 60, 1, 19),
(87, '2016-06-09', 100, 60, 1, 20),
(88, '2016-06-09', 100, 60, 1, 21),
(89, '2016-06-09', 100, 60, 1, 22),
(90, '2016-06-09', 100, 60, 1, 23),
(91, '2016-06-09', 100, 60, 1, 24),
(92, '2016-06-09', 100, 60, 1, 25),
(93, '2016-06-09', 100, 60, 1, 26),
(94, '2016-06-09', 100, 60, 1, 27),
(95, '2016-06-09', 100, 60, 1, 28),
(96, '2016-06-09', 100, 60, 1, 29),
(97, '2016-06-09', 100, 60, 1, 30),
(98, '2016-06-09', 100, 60, 1, 31),
(99, '2016-06-09', 100, 60, 1, 32),
(100, '2016-06-09', 100, 60, 1, 33),
(101, '2016-06-09', 100, 60, 1, 34),
(102, '2016-06-09', 100, 60, 1, 35),
(103, '2016-06-09', 100, 60, 1, 36),
(104, '2016-06-09', 100, 60, 1, 37),
(105, '2016-06-09', 100, 60, 1, 38),
(106, '2016-06-09', 100, 60, 1, 39),
(107, '2016-06-09', 100, 60, 1, 40),
(108, '2016-06-09', 100, 60, 1, 41),
(109, '2016-06-09', 100, 60, 1, 42),
(110, '2016-06-09', 100, 60, 1, 43),
(111, '2016-06-09', 100, 60, 1, 44),
(112, '2016-06-09', 100, 60, 1, 45),
(113, '2016-06-09', 100, 60, 1, 46),
(114, '2016-06-09', 100, 60, 1, 47),
(115, '2016-06-09', 100, 60, 1, 48),
(116, '2016-06-09', 100, 60, 1, 49),
(117, '2016-06-09', 100, 60, 1, 50),
(118, '2016-06-09', 100, 60, 1, 51),
(119, '2016-06-09', 100, 60, 1, 52),
(120, '2016-06-09', 100, 60, 1, 53),
(121, '2016-06-09', 100, 60, 1, 54),
(122, '2016-06-09', 100, 60, 1, 55),
(123, '2016-06-09', 100, 60, 1, 56),
(124, '2016-06-09', 100, 60, 1, 57),
(125, '2016-06-09', 100, 60, 1, 58),
(126, '2016-06-09', 100, 60, 1, 59),
(127, '2016-06-09', 100, 60, 1, 60),
(128, '2016-06-09', 100, 60, 1, 61),
(129, '2016-06-09', 100, 60, 1, 62),
(130, '2016-06-09', 100, 60, 1, 63),
(131, '2016-06-09', 100, 60, 1, 64),
(132, '2016-06-09', 100, 60, 1, 65),
(133, '2016-06-09', 100, 60, 1, 66),
(134, '2016-06-09', 100, 20, 2, 2),
(135, '2016-06-09', 100, 20, 2, 3),
(136, '2016-06-09', 100, 20, 2, 4),
(137, '2016-06-09', 100, 20, 2, 5),
(138, '2016-06-09', 100, 20, 2, 6),
(139, '2016-06-09', 100, 20, 2, 7),
(140, '2016-06-09', 100, 20, 2, 8),
(141, '2016-06-09', 100, 20, 2, 9),
(142, '2016-06-09', 100, 20, 2, 10),
(143, '2016-06-09', 100, 20, 2, 11),
(144, '2016-06-09', 100, 20, 2, 12),
(145, '2016-06-09', 100, 20, 2, 13),
(146, '2016-06-09', 100, 20, 2, 14),
(147, '2016-06-09', 100, 20, 2, 15),
(148, '2016-06-09', 100, 20, 2, 16),
(149, '2016-06-09', 100, 20, 2, 17),
(150, '2016-06-09', 100, 20, 2, 18),
(151, '2016-06-09', 100, 20, 2, 19),
(152, '2016-06-09', 100, 20, 2, 20),
(153, '2016-06-09', 100, 20, 2, 21),
(154, '2016-06-09', 100, 20, 2, 22),
(155, '2016-06-09', 100, 20, 2, 23),
(156, '2016-06-09', 100, 20, 2, 24),
(157, '2016-06-09', 100, 20, 2, 25),
(158, '2016-06-09', 100, 20, 2, 26),
(159, '2016-06-09', 100, 20, 2, 27),
(160, '2016-06-09', 100, 20, 2, 28),
(161, '2016-06-09', 100, 20, 2, 29),
(162, '2016-06-09', 100, 20, 2, 30),
(163, '2016-06-09', 100, 20, 2, 31),
(164, '2016-06-09', 100, 20, 2, 32),
(165, '2016-06-09', 100, 20, 2, 33),
(166, '2016-06-09', 100, 20, 2, 34),
(167, '2016-06-09', 100, 20, 2, 35),
(168, '2016-06-09', 100, 20, 2, 36),
(169, '2016-06-09', 100, 20, 2, 37),
(170, '2016-06-09', 100, 20, 2, 38),
(171, '2016-06-09', 100, 20, 2, 39),
(172, '2016-06-09', 100, 20, 2, 40),
(173, '2016-06-09', 100, 20, 2, 41),
(174, '2016-06-09', 100, 20, 2, 42),
(175, '2016-06-09', 100, 20, 2, 43),
(176, '2016-06-09', 100, 20, 2, 44),
(177, '2016-06-09', 100, 20, 2, 45),
(178, '2016-06-09', 100, 20, 2, 46),
(179, '2016-06-09', 100, 20, 2, 47),
(180, '2016-06-09', 100, 20, 2, 48),
(181, '2016-06-09', 100, 20, 2, 49),
(182, '2016-06-09', 100, 20, 2, 50),
(183, '2016-06-09', 100, 20, 2, 51),
(184, '2016-06-09', 100, 20, 2, 52),
(185, '2016-06-09', 100, 20, 2, 53),
(186, '2016-06-09', 100, 20, 2, 54),
(187, '2016-06-09', 100, 20, 2, 55),
(188, '2016-06-09', 100, 20, 2, 56),
(189, '2016-06-09', 100, 20, 2, 57),
(190, '2016-06-09', 100, 20, 2, 58),
(191, '2016-06-09', 100, 20, 2, 59),
(192, '2016-06-09', 100, 20, 2, 60),
(193, '2016-06-09', 100, 20, 2, 61),
(194, '2016-06-09', 100, 20, 2, 62),
(195, '2016-06-09', 100, 20, 2, 63),
(196, '2016-06-09', 100, 20, 2, 64),
(197, '2016-06-09', 100, 20, 2, 65),
(198, '2016-06-09', 100, 20, 2, 66),
(199, '2016-06-09', 100, 20, 2, 1);

--
-- Contenu de la table `reservation`
--

INSERT INTO `reservation` (`id_reservation`, `date_reservation`, `id_user`, `nombre_client`) VALUES
(5, '2016-06-06', 3, 1),
(2, '2016-05-22', 3, 1),
(3, '2016-05-24', 1, 1),
(4, '2016-05-25', 3, 1),
(6, '2016-06-07', 3, 1),
(7, '2016-06-07', 3, 1),
(8, '2016-06-07', 3, 1),
(9, '2016-06-07', 3, 1);

--
-- Contenu de la table `train`
--

INSERT INTO `train` (`id_train`, `numero_train`) VALUES
(1, 'Numero_1x'),
(2, 'Numero_2x'),
(3, 'Numero_3x'),
(4, 'Numero_4x'),
(5, 'Numero_5x'),
(6, 'Numero_6x'),
(7, 'Numero_7x'),
(8, 'Numero_8x'),
(9, 'Numero_9x'),
(10, 'Numero_Ax'),
(11, 'Numero_Ax'),
(12, 'Numero_Bx'),
(13, 'Numero_Cx'),
(14, 'Numero_Dx'),
(15, 'Numero_Ex'),
(16, 'Numero_Fx'),
(17, 'Numero_Gx'),
(18, 'Numero_AA'),
(19, 'Numero_BB'),
(20, 'Numero_CC'),
(21, 'Numero_DD'),
(22, 'Numero_EE'),
(23, 'Numero_FF'),
(24, 'Numero_JJ'),
(25, 'Numero_KK'),
(26, 'Numero_VV'),
(27, 'Numero_A1'),
(28, 'Numero_A2'),
(29, 'Numero_A3'),
(30, 'Numero_A4'),
(31, 'Numero_A5'),
(32, 'Numero_A6'),
(33, 'Numero_A7'),
(34, 'Numero_A8'),
(35, 'Numero_A9'),
(36, 'Numero_B1'),
(37, 'Numero_B2'),
(38, 'Numero_B3'),
(39, 'Numero_B4'),
(40, 'Numero_B5'),
(41, 'Numero_B6'),
(42, 'Numero_B7'),
(43, 'Numero_B8'),
(44, 'Numero_B9'),
(45, 'Numero_C1'),
(46, 'Numero_C2'),
(47, 'Numero_C3'),
(48, 'Numero_C4'),
(49, 'Numero_C5'),
(50, 'Numero_C6'),
(51, 'Numero_C7'),
(52, 'Numero_C8'),
(53, 'Numero_C9'),
(54, 'Numero_D1');

--
-- Contenu de la table `trajet`
--

INSERT INTO `trajet` (`id_trajet`, `id_ville_dept`, `id_ville_arrive`, `id_train`, `heure_dept`, `heure_arrive`, `typeDate`) VALUES
(1, 1, 2, 1, '05:00:00', '07:00:00', '0,1,2'),
(2, 1, 2, 2, '07:00:00', '09:00:00', '0,1'),
(3, 1, 2, 3, '10:00:00', '12:00:00', '0,1,2'),
(4, 1, 2, 4, '09:00:00', '11:00:00', '0,2'),
(5, 1, 2, 5, '13:00:00', '15:00:00', '0,1'),
(6, 1, 2, 6, '14:00:00', '16:00:00', '0'),
(7, 1, 2, 7, '17:00:00', '19:00:00', '0,1,2'),
(8, 1, 2, 8, '19:00:00', '21:00:00', '0,1,2'),
(9, 1, 2, 9, '22:00:00', '00:00:00', '0,1,2'),
(10, 1, 3, 10, '05:00:00', '07:00:00', '0,1,2'),
(11, 1, 3, 11, '07:00:00', '09:00:00', '0,1'),
(12, 1, 3, 12, '10:00:00', '12:00:00', '0,1,2'),
(13, 1, 3, 13, '09:00:00', '11:00:00', '0,2'),
(14, 1, 3, 14, '13:00:00', '15:00:00', '0,1'),
(15, 1, 3, 15, '14:00:00', '16:00:00', '0'),
(16, 1, 3, 16, '17:00:00', '19:00:00', '0,1,2'),
(17, 1, 3, 17, '19:00:00', '21:00:00', '0,1,2'),
(18, 1, 3, 18, '22:00:00', '00:00:00', '0,1,2'),
(19, 1, 4, 19, '05:00:00', '15:00:00', '0,1,2'),
(20, 1, 4, 20, '10:00:00', '20:00:00', '0'),
(21, 1, 4, 21, '17:00:00', '03:00:00', '0,1,2'),
(22, 1, 5, 22, '05:00:00', '07:00:00', '0,1,2'),
(23, 1, 5, 23, '07:00:00', '09:00:00', '0,1'),
(24, 1, 5, 24, '10:00:00', '12:00:00', '0,1,2'),
(25, 1, 5, 25, '09:00:00', '11:00:00', '0,2'),
(26, 1, 5, 26, '13:00:00', '15:00:00', '0,1'),
(27, 1, 5, 27, '14:00:00', '16:00:00', '0'),
(28, 1, 5, 28, '17:00:00', '19:00:00', '0,1,2'),
(29, 1, 5, 29, '19:00:00', '21:00:00', '0,1,2'),
(30, 1, 5, 30, '22:00:00', '00:00:00', '0,1,2'),
(31, 1, 6, 31, '05:00:00', '07:00:00', '0,1,2'),
(32, 1, 6, 32, '07:00:00', '09:00:00', '0,1'),
(33, 1, 6, 33, '10:00:00', '12:00:00', '0,1,2'),
(34, 1, 6, 34, '09:00:00', '11:00:00', '0,2'),
(35, 1, 6, 35, '13:00:00', '15:00:00', '0,1'),
(36, 1, 6, 36, '14:00:00', '16:00:00', '0'),
(37, 1, 6, 37, '17:00:00', '19:00:00', '0,1,2'),
(38, 1, 6, 38, '19:00:00', '21:00:00', '0,1,2'),
(39, 1, 6, 39, '22:00:00', '00:00:00', '0,1,2'),
(40, 1, 7, 40, '05:00:00', '07:00:00', '0,1,2'),
(41, 1, 7, 41, '07:00:00', '09:00:00', '0,1'),
(42, 1, 7, 42, '10:00:00', '12:00:00', '0,1,2'),
(43, 1, 7, 43, '13:00:00', '15:00:00', '0,1'),
(44, 1, 7, 44, '14:00:00', '16:00:00', '0'),
(45, 1, 7, 45, '17:00:00', '19:00:00', '0,1,2'),
(46, 1, 7, 46, '22:00:00', '00:00:00', '0,1,2'),
(47, 1, 9, 47, '05:00:00', '10:00:00', '0,1,2'),
(48, 1, 9, 48, '07:00:00', '12:00:00', '0,1'),
(49, 1, 9, 49, '10:00:00', '15:00:00', '0,1,2'),
(50, 1, 9, 50, '14:00:00', '19:00:00', '0'),
(51, 1, 9, 51, '17:00:00', '22:00:00', '0,1,2'),
(52, 1, 8, 52, '05:00:00', '15:00:00', '0,1,2'),
(53, 1, 8, 53, '10:00:00', '20:00:00', '0'),
(54, 1, 8, 54, '17:00:00', '03:00:00', '0,1,2'),
(55, 1, 10, 55, '05:00:00', '08:00:00', '0,1,2'),
(56, 1, 10, 56, '07:00:00', '10:00:00', '0,1'),
(57, 1, 10, 57, '10:00:00', '13:00:00', '0,1,2'),
(58, 1, 10, 59, '13:00:00', '14:00:00', '0,1'),
(59, 1, 10, 60, '14:00:00', '17:00:00', '0'),
(60, 1, 10, 61, '19:00:00', '22:00:00', '0,1,2'),
(61, 1, 12, 62, '05:00:00', '08:30:00', '0,1,2'),
(62, 1, 12, 63, '07:00:00', '10:30:00', '0,1'),
(63, 1, 12, 64, '10:00:00', '13:30:00', '0,1,2'),
(64, 1, 12, 66, '13:00:00', '16:30:00', '0,1'),
(65, 1, 12, 68, '17:00:00', '20:30:00', '0,1,2'),
(66, 1, 12, 69, '19:00:00', '21:30:00', '0,1,2');

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id_user`, `name`, `email`, `role`, `password`, `url_img`) VALUES
(2, 'Nguyen ThanhVinh', 'vinh.lkn@gmail.com', 1, '', 'https://graph.facebook.com/974572865942714/picture'),
(3, 'Vinh', '214712@supinfo.com', 1, '087235016af3f8234b7b39c22379390b', NULL),
(1, 'Vinh', 'luong.kimngan@live.fr', 1, '087235016af3f8234b7b39c22379390b', ''),
(18, 'vinh nguy�n', 'vinh.lkn@gmail.com', 0, '', 'https://lh4.googleusercontent.com/-namwKpGj0hg/AAAAAAAAAAI/AAAAAAAAAHA/14CeXiHfJfI/photo.jpg?sz=50');

--
-- Contenu de la table `ville`
--

INSERT INTO `ville` (`id_ville`, `name_ville`, `pays`) VALUES
(1, 'Paris', 'France'),
(2, 'Lyon', 'France'),
(3, 'Le Havre', 'France'),
(4, 'Berlin', 'Allemagne'),
(5, 'Lille', 'France'),
(6, 'Orleans', 'France'),
(7, 'Grenoble', 'France'),
(8, 'Londre', 'Anglais'),
(9, 'Nice', 'France'),
(10, 'Nantes', 'France'),
(12, 'Bordeaux', 'France'),
(13, 'Montpellier', 'France'),
(14, 'Tours', 'France'),
(15, 'Marseille', 'France'),
(16, 'Strasbourg', 'France'),
(17, 'Rennes', 'France'),
(18, 'Reims', 'France'),
(19, 'Valenciennes', 'France'),
(20, 'La Rochelle', 'France'),
(21, 'Carcasonne', 'France'),
(22, 'Nimes', 'France'),
(23, 'Albi', 'France'),
(24, 'Vannes', 'France'),
(25, 'Blois', 'France'),
(26, 'Bourgognes', 'France'),
(27, 'Limoges', 'France'),
(28, 'Toulon', 'France'),
(29, 'Dijon', 'France'),
(30, 'Annecy', 'France'),
(31, 'Le Mans', 'France'),
(32, 'Angers', 'France'),
(33, 'Metz', 'France'),
(34, 'Nancy', 'France'),
(35, 'Caen', 'France'),
(36, 'Rouen', 'France'),
(37, 'Avignon', 'France'),
(38, 'Poitiers', 'France'),
(39, 'Cannes', 'France'),
(40, 'Troyes', 'France'),
(41, 'Perpignan', 'France'),
(42, 'Amien', 'France'),
(43, 'Barcelone', 'Espagne'),
(44, 'Madrid', 'Espagne');
