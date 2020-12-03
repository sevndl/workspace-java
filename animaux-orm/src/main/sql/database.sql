drop table if exists PopulationSoigneur;
drop table if exists Population;
drop table if exists Soigneur;
drop table if exists Animal;
drop table if exists Espece;

create table Espece (
    id bigint not null auto_increment,
    nom varchar(255),
    primary key (id)
) engine = InnoDB;

create table Animal (
    id bigint not null auto_increment,
    nom varchar(255),
    origine varchar(255),
    description varchar(2000),
    regime enum('carnivore', 'herbivore'),
    espece_id bigint,
    primary key (id),
    foreign key fk_animal_espece(espece_id) references Espece(id)
) engine = InnoDB;

create table Population (
    id bigint not null auto_increment,
    nombreIndividus int,
    animal_id bigint,
    primary key (id),
    foreign key fk_population_animal(animal_id) references Animal(id)
) engine = InnoDB;

create table Soigneur (
    id bigint not null auto_increment,
    numero varchar(255),
    nom varchar(255),
    dateRecrutement date,
    primary key (id)
) engine = InnoDB;

create table PopulationSoigneur (
    animal_id bigint not null,
    soigneur_id bigint not null,
    primary key (animal_id, soigneur_id),
    foreign key fk_animal(animal_id) references Animal(id),
    foreign key fk_soigneur(soigneur_id) references Soigneur(id)
) engine = InnoDB;

insert into Espece (nom) values
('Félidé'),
('Équidé'),
('Artiodactyla'),
('Canidé');

insert into Animal(nom, origine, description, regime, espece_id) values
('Lion', 'Afrique', 'Le lion (Panthera leo) est une espèce de mammifères carnivores de la famille des félidés. La femelle du lion est la lionne, son petit est le lionceau.', 'carnivore', 1),
('Panthère', 'Afrique et Asie', 'Le Léopard ou Panthère (Panthera pardus) est une espèce de félins de la sous-famille des panthérinés. Ce félin présente un pelage fauve tacheté de rosettes ; une forme mélanique existe également. Excellent grimpeur et sauteur, le léopard a la particularité de hisser ses proies à la fourche d''un arbre pour les mettre hors de portée des autres prédateurs.', 'carnivore', 1),
('Zèbre', 'Afrique', 'Zèbre est un nom vernaculaire, ambigu en français, pouvant désigner plusieurs espèces différentes d''herbivores de la famille des équidés, et du genre Equus, vivant en Afrique.', 'herbivore', 2),
('Âne', 'Europe, Asie, Afrique, Amériques', 'L''Âne commun (Equus asinus ou Equus asinus asinus), appelé plus communément « Âne », est une espèce de mammifères herbivores et ongulés appartenant à la famille des équidés. Souvent comparé au cheval, l''âne a des caractéristiques morphologiques propres qui le différencient clairement de son cousin, ses longues oreilles étant son attribut le plus facilement identifiable.', 'herbivore', 2),
('Girafe', 'Afrique', 'La Girafe (Giraffa camelopardalis) est une espèce de mammifères ongulés artiodactyles, du groupe des ruminants, vivant dans les savanes africaines et répandue du Tchad jusqu''en Afrique du Sud.', 'herbivore', 3),
('Dromadaire', 'Afrique et Moyen-Orient', 'Le dromadaire (Camelus dromedarius), ou chameau d''Arabie, est une espèce de chameau, mammifère artiodactyle de la famille des camélidés. Pour cette raison, qualifier un dromadaire de « chameau » n''est pas erroné mais juste moins précis ; les espèces nommées couramment « chameau » présentent deux bosses, alors que le dromadaire n''en possède qu''une seule . Le terme dromadaire est tiré du grec dromeus qui signifie « coureur ».', 'herbivore', 3),
('Renard', 'Partout', 'Renard est un terme ambigu qui désigne le plus souvent en français les canidés du genre Vulpes, le plus commun étant le Renard roux (Vulpes vulpes). Toutefois, par similitude physique, le terme est aussi employé pour désigner des canidés appartenant à d''autres genres, comme les genres Atelocynus, Cerdocyon, Dusicyon, Otocyon, Lycalopex et Urocyon.', 'carnivore', 4),
('Guépard', 'Afrique et Moyen-Orient', 'Le guépard (Acinonyx jubatus) est un grand mammifère carnassier de la famille des félidés vivant en Afrique et en Asie de l''Ouest. Le guépard a une allure svelte et fine, avec de longues pattes élancées aux griffes non rétractiles, et une face au museau court marquée par deux traces noires partant des yeux. Son pelage est entièrement tacheté de noir sur un fond fauve à beige très clair ; les petits sont pourvus d''une courte crinière qui disparaît à l''âge adulte. Il est considéré comme l''animal terrestre le plus rapide au monde, sa vitesse à la course pouvant atteindre 112 km/h.', 'carnivore', 1),
('Bison', 'Europe et Amériques', 'Les Bisons (Bison) forment un genre de grands bovidés ruminants dont il existe deux espèces vivantes : le bison d''Europe (Bison bonasus) et le bison d''Amérique du Nord (Bison bison) qui est elle-même divisée en deux sous-espèces : le bison des bois (Bison bison athabascae) et le bison des plaines (Bison bison bison). Le bison des plaines vit essentiellement dans les steppes nord-américaines tandis que le bison des bois et le bison d''Europe occupent des habitats forestiers.', 'herbivore', 3),
('Lama', 'Amériques', 'Le lama blanc ou lama (Lama glama) est un camélidé domestique d''Amérique du Sud. Sa longévité est comprise entre 10 et 20 ans. Le terme « lama » est souvent utilisé de manière plus large pour s''appliquer aux quatre espèces animales proches qui constituent la branche sud-américaine des camélidés : le lama blanc lui-même, l''alpaga, le guanaco et la vigogne (voir le genre lama). Stricto sensu, malgré quelques croisements, le lama, animal domestique, a pour plus proche cousin le guanaco, animal sauvage, alors que l''alpaga, animal domestique, a pour plus proche cousin la vigogne, animal sauvage.', 'herbivore', 3);

insert into Soigneur(numero, nom, dateRecrutement) values
('S0001', 'Tristan', '2020-01-12'),
('S0002', 'Élodie', '2020-02-08'),
('S0003', 'Samuel', '2020-02-09'),
('S0003', 'Camille', '2020-04-24');

