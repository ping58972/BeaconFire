CREATE DATABASE IF NOT EXISTS quiz;
USE quiz;

DROP TABLE IF EXISTS Address;

CREATE TABLE IF NOT EXISTS Address (
	address_id int auto_increment PRIMARY KEY,
    street varchar(255),
    city varchar(50),
    state varchar(50),
    zipcode int,
    country varchar(50)
    );

INSERT INTO Address (street, city, state, zipcode, country) VALUES 
('3626 Collins Street', 'State College', 'PA', 16801, 'USA'),
('3855 Oakdale Avenue', 'Okeechobee', 'FL', 34974, 'USA'),
('2959 Delaware Avenue', 'San Francisco', 'CA', 94143, 'USA'),
('4688 Lang Avenue', 'Park City', 'UT', 84060, 'USA'),
('4785 Little Acres Lane', 'Mattoon', 'IL', 61938, 'USA'),
('3657 Lawman Avenue', 'Reston', 'VA', 22070, 'USA'),
('4091 Glen Street', 'Madisonville', 'KY', 42431, 'USA'),
('4222 Tyler Avenue', 'Marathon', 'FL', 33050, 'USA'),
('958 Riverwood Drive', 'Soda Springs', 'CA', 95728, 'USA'),
('4392 Kelley Road', 'MC CALLSBURG', 'IA', 50154, 'USA'),
('1731 Emeral Dreams Drive', 'Chicago', 'IL', 60607, 'USA'),
('4092 Rowes Lane', 'Franklin', 'KY', 42134, 'USA'),
('2391 Simpson Square', 'Enid', 'OK', 73703, 'USA'),
('3867 Gnatty Creek Road', 'New York', 'NY', 10014, 'USA'),
('2506 Passaic Street', 'MONTGOMERY', 'AL', 36101, 'USA'),
('1854 Junkins Avenue', 'Thomasville', 'GA', 31729, 'USA'),
('1694 Big Indian', 'DEMING', 'NM', 88030, 'USA'),
('4232 Fantages Way', 'Boise', 'ID', 83704, 'USA'),
('2175 Ash Street', 'STANLEY', 'ID', 83278, 'USA'),
('2742 Diane Street', 'San Luis Obispo', 'CA', 93401, 'USA'),
('2664 Hill Haven Drive', 'Waco', 'TX', 76701, 'USA'),
('697 Moonlight Drive', 'Laurel Springs', 'NJ', 08021, 'USA'),
('1369 Bedford Street', 'Norwalk', 'CT', 06854, 'USA'),
('3768 Poe Road', 'IBERIA', 'OH', 43325, 'USA'),
('2110 Jerome Avenue', 'Edinburg', 'TX', 78539, 'USA'),
('1537 Fort Street', 'Tacoma', 'WA', 98402, 'USA'),
('3494 Clark Street', 'Chicago', 'IL', 60607, 'USA');

SELECT * FROM Address;



DROP TABLE IF EXISTS User;
CREATE TABLE IF NOT EXISTS User (
	user_id int auto_increment PRIMARY KEY,
    firstname varchar(50),
    lastname varchar(50),
    email varchar(50) not null unique,
    password varchar(50) not null,
    phone varchar(50),
    face_url varchar(255) default 
    "https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male20121086101173127.jpg",
    address_id int,
    is_active bool default true,
    is_admin bool default false);

INSERT INTO User (firstname, lastname, email, password, phone, face_url,
 address_id, is_active, is_admin) VALUES 
 ('admin', 'admin', 'admin@quiz.com', 'admin', '(999)999-9999',
 "https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male20141086150172760.jpg"
 ,24, true, true),
 ('Ping', 'Pong', 'ping@pong.com', 'pingpong', '(612)900-9999',
 "https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male2017108671042908.jpg"
 ,25, true, false),
('Kristine', 'Littrell', 'kelsi_volkm@gmail.com', 'moH2sah9ai', '(215)577-7142',
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/female/female20171026073158722.jpg"
, 1, true, false),
('Constance', 'Davis', 'myles1971@yahoo.com', 'Hie4Ogh8sah', '(620)862-1366',
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/female/female20091023350549774.jpg"
 ,2, true, false),
('Yvonne', 'Crouch', 'lionel2008@hotmail.com', 'iGahToo3', '(814)324-2232',
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/female/female1021539468536.jpg"
 ,3, true, false),
('Justin', 'Latham', 'leland1970@hotmail.com', 'Vusah9kie', '(469)464-4443',
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male1085276822998.jpg"
 ,4, true, false),
('Joan', 'West', 'alycia2007@gmail.com', 'ueNer3ei', '(330)998-4183',
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male1085276822998.jpg"
, 5, true, false),
('Marsha', 'McDuffie', 'carol.barte@gmail.com', 'vuseeG2oh', '(214)607-5805',
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male1084271781463.jpg"
 ,6, true, false),
('Ira', 'Smail', 'katrine1991@gmail.com', 'ooc6eeWei2e', '(817)953-8511', 
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male20151086245966491.jpg"
,7, true, false),
('Joshua', 'Moore', 'audie.waelc@hotmail.com', 'eeneiKoo3', '(804)340-0032', 
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male20151086245966491.jpg"
, 8, true, false),
('Michael', 'Hardy', 'eloy2007@hotmail.com', 'ahQu9lahb', '(405)635-0190', 
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male20151086245966491.jpg"
, 9, true, false),
('Keith', 'Broussard', 'darrick_how10@gmail.com', 'voGoh7ko2ei', '(518)594-6990', 
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male20151086245966491.jpg"
, 10, true, false),
('Cornelia', 'Nevius', 'amy_christians@yahoo.com', 'Hee7nebeovie', '(802)812-8541',  
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male20151086245966491.jpg"
,11, true, false),
('Jonathan', 'Davis', 'tavares1995@hotmail.com', 'Chai3zahghoh', '(810)396-2016',  
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male20151086245966491.jpg"
,12, true, false),
('Robert', 'Fuller', 'drew2000@hotmail.com', 'WiTao3Moh', '(256)330-6296',  
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male20151086245966491.jpg"
,13, true, false),
('Inez', 'Brooks', 'louie1981@gmail.com', 'Ua9Foo2sie', '(517)623-9998',  
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male20151086245966491.jpg"
,14, true, false),
('Ronald', 'Camacho', 'mariana_kri10@hotmail.com', 'ooghuSo0sh', '(386)252-3468',  
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male20151086245966491.jpg"
,15, true, false),
('Homer', 'Green', 'marjory1976@hotmail.com', 'eekuphahP2', '(585)757-9396', 
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male20151086245966491.jpg"
, 16, true, false),
('Maryann', 'Kim', 'tanner_bechtel@gmail.com', 'xai3OoLeegh', '(516)921-9033',  
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male20151086245966491.jpg"
,17, true, false),
('Robert', 'Humphrey', 'vita2011@gmail.com', 'Daec5Eiy9Io', '(951)587-9335',  
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male20151086245966491.jpg"
,18, true, false),
('Tiffany', 'Cervantes', 'lura1994@hotmail.com', 'ahQuoo4Phoh', '(318)737-8390',  
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male20151086245966491.jpg"
,19, true, false),
('Yolanda', 'Drayton', 'gregg1996@hotmail.com', 'chu6iebe0K', '(817)310-0022',  
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male20151086245966491.jpg"
,20, true, false),
('Lula', 'McCurdy', 'herta1972@gmail.com', 'gae6aiS6u', '(256)224-8175',  
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male20151086245966491.jpg"
,21, true, false),
('Dung', 'Dunn', 'elvis.haa1@hotmail.com', 'Iephien6Ei', '(505)827-5168',  
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male20151086245966491.jpg"
,22, true, false),
('Cheryl', 'Lonergan', 'alexandro1972@hotmail.com', 'eiZie9Eiqu', '(936)679-7033',  
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male20151086245966491.jpg"
,23, true, false),
('Dale', 'Rogers', 'anibal1976@yahoo.com', 'eiZie9Eiqu', '(908)897-8269',  
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male20151086245966491.jpg"
,24, true, false),
('Karen', 'Rayburn', 'allene1972@hotmail.com', 'eevee1aeBei', '(215)901-0094',  
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male20151086245966491.jpg"
,25, true, false),
('Ericka', 'Beasley', 'rosalee.volkm@gmail.com', 'Queu0Nai', '(303)920-2719',  
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male20151086245966491.jpg"
,26, true, false),
('Arthur', 'Garrison', 'kathlyn2006@yahoo.com', 'naSheig9ei', '(317)690-0730',  
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male20151086245966491.jpg"
,27, true, false),
('Ruth', 'Lindo', 'niko.toy2009@gmail.com', 'Eicee9ijae', '(908)583-3403',  
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male20151086245966491.jpg"
,22, true, false),
('James', 'Barrow', 'rickey1999@hotmail.com', 'sae5rein8K', '(239)851-1647',  
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male20151086245966491.jpg"
,12, true, false),
('Anthony', 'Avent', 'margarete2004@hotmail.com', 'SaaHei8Fai', '(817)349-5993',  
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male20151086245966491.jpg"
,17, true, false),
('Angela', 'Brown', 'fritz.ondric@hotmail.com', 'laph8Cahyuh', '(419)369-9212',  
"https://fakeperson-face.oss-us-west-1.aliyuncs.com/Face/male/male20151086245966491.jpg"
,6, true, false);

SELECT * FROM User;


 DROP TABLE IF EXISTS Feedback;
CREATE TABLE IF NOT EXISTS Feedback (
	feedback_id int auto_increment PRIMARY KEY,
    user_id int,
    message varchar(500),
    rating int not null,
    feedback_time timestamp not null DEFAULT CURRENT_TIMESTAMP, 
	constraint FK_User_id foreign key(user_id) references User(user_id)
    on delete cascade
    );

INSERT INTO Feedback (user_id, message, rating, feedback_time) VALUES 
 (3, "We were treated like royalty. It's just amazing.", 4,'2020-01-01 00:00:01' ),
 (4, "Needless to say we are extremely satisfied with the results. I don't know what else to say.",
 5,'2020-03-12 06:00:01' ),
 (5, "Great job, I will definitely be ordering again! It's exactly 
 what I've been looking for. Wow what great service, I love it! 
 Thank you for making it painless, pleasant and most of all hassle free!",
 4,'2022-01-05 10:07:01' ),
 (6, "If you aren't sure, always go for Quiz.",
 3,'2020-03-12 06:00:01' ),
 (2, "It really saves me time and effort. 
 Quiz is exactly what our business has been lacking. We've seen amazing results already.",
 5,'2021-04-12 09:00:01' );
SELECT * FROM Feedback;

DROP TABLE IF EXISTS Contact;
CREATE TABLE IF NOT EXISTS Contact (
	contact_id int auto_increment PRIMARY KEY,
    firstname varchar(50),
    lastname varchar(50),
    subject varchar(100),
    message varchar(500)
    );

INSERT INTO Contact (firstname, lastname, subject, message) VALUES 
 ("Arthur",'Beasley',"Hello", "Without hello, we would have gone bankrupt by now. 
 Hello is great. Hello has got everything I need. The best on the net!"),
  ('Lula','McCurdy',"Dog", "Definitely worth the investment. Keep up the excellent work. 
  I was amazed at the quality of Dog. I would gladly pay over 600 dollars for Dog."),
  ('Dale','Green',"Cat", "Needless to say we are extremely satisfied with the results. 
  I wish I would have thought of it first.");

 SELECT * FROM Contact;

DROP TABLE IF EXISTS Category;
CREATE TABLE IF NOT EXISTS Category (
	category_id int auto_increment PRIMARY KEY,
    name varchar(50),
    image_url varchar(255)
    );

INSERT INTO Category (name, image_url) VALUES 
 ("Sport", "https://www.wrl.org/wp-content/uploads/2021/12/various-sports-accessories-pic.jpg"),
 ("Travel", "https://indepthnh.org/wp-content/uploads/2017/09/Travel-Picture.jpg"),
 ("Movie","https://facts.net/wp-content/uploads/2021/05/istockphoto-1191001701-612x612.jpg");

 SELECT * FROM Category;
 

DROP TABLE IF EXISTS Question;
CREATE TABLE IF NOT EXISTS Question (
	question_id int auto_increment PRIMARY KEY,
    category_id int,
    description varchar(255),
    type varchar(50),
    is_active bool default true,
    constraint FK_Category foreign key(category_id) 
    references Category(category_id) on delete cascade
    );

INSERT INTO Question (question_id, category_id, description, type, is_active) VALUES 
 (1, 1, "After how many Year’s FIFA World Cup is held?", "MULTIPLE_CHOICE", true),
 (2, 1, "Which Country won the first FIFA World Cup?", "MULTIPLE_CHOICE", true),
 (3, 1, "Who won the first ICC World Cup?", "MULTIPLE_CHOICE", true),
 (4, 1, "Who won the first T20 World Cup?", "MULTIPLE_CHOICE", true),
 (5, 1, "Who is known as the Flying Sikh?", "MULTIPLE_CHOICE", true),
 (6, 1, "Who has the Highest Number of Gold Medals in Olympic History?", "MULTIPLE_CHOICE", true),
 (7, 1, "What is the 100m World Record of Usain Bolt?", "MULTIPLE_CHOICE", true),
 (8, 1, "What is the Women’s World Record of the 100-Meter Dash?", "MULTIPLE_CHOICE", true),
 (9, 1, "Where is the Famous Boxer Mary Kom from?", "MULTIPLE_CHOICE",  true),
 (10, 1, "How many FIFA World Cup has been played till 2018?", "MULTIPLE_CHOICE",true),
 (11, 1, "How many times has India won the Men’s Hockey World Cup in the Olympics?","MULTIPLE_CHOICE",  true),
 (12, 1, "Which Female has the Most Olympic Gold Medals in Olympic History?","MULTIPLE_CHOICE",  true),
 (13, 1, "Who is known as `The Baltimore Bullet`?","MULTIPLE_CHOICE",  true),
 (14, 1,  "Who is the first Indian Badminton Player to win an Olympic Medal?", "MULTIPLE_CHOICE", true),
 (15, 1,  "Which Sport is Performed by the Legend (Muhammad Ali)?","MULTIPLE_CHOICE",  true),
 (16, 1,  "When was the first FIFA World Cup held?", "MULTIPLE_CHOICE", true),
 (17, 1,  "When did Cristiano Ronaldo join Juventus Football Club?", "MULTIPLE_CHOICE", true),
 (18, 1,  "Which Country has Won the Most World Snooker Championship?","MULTIPLE_CHOICE",  true),
 (19, 1,  "Who holds the World Record for Solving Rubik’s Cube at 3.47 Seconds?", "MULTIPLE_CHOICE", true),
 (20, 1,  "Who won the FIFA World Cup in 2018?", "MULTIPLE_CHOICE", true),
 (21, 1,  "What sport is best known as the ‘king of sports’?", "SHORT_ANSWER", true),
 (22, 1,  "What do you call it when a bowler makes three strikes in a row?", "SHORT_ANSWER", true),
 (23, 1,  "What’s the national sport of Canada?", "SHORT_ANSWER", true),
 (24, 1,  "How many dimples does an average golf ball have?", "SHORT_ANSWER", true),
 (25, 1,  "In the 1971 Olympics, Nadia Comaneci was the first gymnast to score a perfect score. What country was she representing?", "SHORT_ANSWER", true),
 (26, 2,  "What county has the most natural lakes?", "MULTIPLE_CHOICE",  true),
 (27, 2,  "What country is not part of the Scandinavian Peninsula?", "MULTIPLE_CHOICE",  true),
 (28, 2,  "Which US state has the nickname `Land of 10,000 Lakes`?", "MULTIPLE_CHOICE",  true),
 (29, 2,  "The avocado tree is thought to originate in which country?", "MULTIPLE_CHOICE",  true),
 (30, 2,  "What is the population of India?", "MULTIPLE_CHOICE",  true),
 (31, 2,  "What is the world’s largest continent?", "MULTIPLE_CHOICE",  true),
 (32, 2,  "Which country is the largest in South America?", "MULTIPLE_CHOICE",  true),
 (33, 2,  "What is the only major city located on two continents?", "MULTIPLE_CHOICE",  true),
 (34, 2,  "Which Australian city has the world’s largest natural harbour?", "MULTIPLE_CHOICE",  true),
 (35, 2,  "The Faroe Islands are a territory of what country?", "MULTIPLE_CHOICE",  true),
 (36, 2,  "Which African nation has the most pyramids?", "MULTIPLE_CHOICE",  true),
 (37, 2,  "What percentage of the Nile River is in Egypt?", "MULTIPLE_CHOICE",  true),
 (38, 2,  "What is the least populated US state?", "MULTIPLE_CHOICE",  true),
 (39, 2,  "Which European country has the longest coastline?", "MULTIPLE_CHOICE",  true),
 (40, 2,  "What is the only continent with land in all four hemispheres?", "MULTIPLE_CHOICE",  true),
 (41, 2,  "Which US state has the motto `Live free or die` on their license plate?", "MULTIPLE_CHOICE",  true),
 (42, 2,  "Which Canadian province has the world’s longest freshwater beach?", "MULTIPLE_CHOICE",  true),
 (43, 2,  "Which continent is the flattest?", "MULTIPLE_CHOICE",  true),
 (44, 2,  "What is the currency of Mongolia?", "MULTIPLE_CHOICE",  true),
 (45, 2,  "What is the oldest city in the world?", "MULTIPLE_CHOICE",  true),
 (46, 2,  "Tasmania is an isolated island state belonging to which country?", "SHORT_ANSWER",  true),
 (47, 2,  "What country is home to the ancient city of Petra?", "SHORT_ANSWER",  true),
 (48, 2,  "How many red stripes are on a US flag?", "SHORT_ANSWER",  true),
 (49, 2,  "Which country is home to the largest statue in the world, the Spring Temple Buddha?", "SHORT_ANSWER",  true),
 (50, 2,  "How many time zones are there in Russia?", "SHORT_ANSWER",  true),
 (51, 3,  "The code in The Matrix comes from what food recipes?", "MULTIPLE_CHOICE",  true),
 (52, 3,  "What’s the name of Meatloaf’s character in The Rocky Horror Picture Show?", "MULTIPLE_CHOICE",  true),
 (53, 3,  "Who actually drew the sketch of Rose in Titanic?", "MULTIPLE_CHOICE",  true),
 (54, 3,  "Who voices Joy in Pixar’s Inside Out?", "MULTIPLE_CHOICE",  true),
 (55, 3,  "Where were The Lord of the Rings movies filmed?", "MULTIPLE_CHOICE",  true),
 (56, 3,  "Which country does Forrest Gump travel to as part of the All-American Ping-Pong Team?", "MULTIPLE_CHOICE",  true),
 (57, 3,  "Which famous Pulp Fiction scene was filmed backward?", "MULTIPLE_CHOICE",  true),
 (58, 3,  "Which actor was in the following movies: The Outsiders, Wayne’s World, and Tommy Boy?", "MULTIPLE_CHOICE",  true),
 (59, 3,  "Who was the first Black person to win an Oscar?", "MULTIPLE_CHOICE",  true),
 (60, 3,  "Which is not the name of a child selected to tour the Wonka factory in Willy Wonka and the Chocolate Factory?", "MULTIPLE_CHOICE",  true),
 (61, 3,  "Freddy Krueger wears a striped sweater that is which colors?", "MULTIPLE_CHOICE",  true),
 (62, 3,  "Who did the cat in The Godfather belong to?", "MULTIPLE_CHOICE",  true),
 (63, 3,  "What is the name of the fictional land where Frozen takes place?", "MULTIPLE_CHOICE",  true),
 (64, 3,  "What score did Elle Woods get on her LSAT in Legally Blonde?", "MULTIPLE_CHOICE",  true),
 (65, 3,  "What was the top-grossing movie of 2014?", "MULTIPLE_CHOICE",  true),
 (66, 3,  "How old was Stockard Channing when she played high school student Rizzo in Grease?", "MULTIPLE_CHOICE",  true),
 (67, 3,  "Who directed the hit 2017 movie Get Out?", "MULTIPLE_CHOICE",  true),
 (68, 3,  "What item is in every Fight Club scene?", "MULTIPLE_CHOICE",  true),
 (69, 3,  "If you watch the Marvel movies in chronological order, which movie would you watch first?", "MULTIPLE_CHOICE",  true),
 (70, 3,  "Which is the first movie in the Austin Powers franchise?", "MULTIPLE_CHOICE",  true),
 (71, 3,  "Some of the velociraptor noises in Jurassic Park are actually which animals mating?", "SHORT_ANSWER",  true),
 (72, 3,  "Which actor hasn’t played the Joker?", "SHORT_ANSWER",  true),
 (73, 3,  "Which country was the 2017 movie Call Me By Your Name filmed?", "SHORT_ANSWER",  true),
 (74, 3,  "How many Oscars has Halle Berry won?", "SHORT_ANSWER",  true),
 (75, 3,  "Which movie is this quote from: `What’s in the box?`", "SHORT_ANSWER",  true);

DROP TABLE IF EXISTS Choice;
CREATE TABLE IF NOT EXISTS Choice (
	choice_id int auto_increment PRIMARY KEY,
    question_id int,
    choice_description varchar(255) not null,
    is_correct bool not null,
    constraint FK_Question foreign key(question_id) 
    references Question(question_id) on delete cascade
    );

INSERT INTO Choice (question_id, choice_description, is_correct) VALUES 
(1, "2 Years", false),(1, "3 Years", false),(1, "4 Years", true),(1, "Every Years", false),
(2, "Argentina", false),(2, "Uruguay", true),(2, "Italy", false),(2, "Brazil", false),
(3, "India", false),(3, "West Indies", true),(3, "England", false),(3, "Australia", false),
(4, "India", true),(4, "West Indies", false),(4, "England", false),(4, "Sri Lanka", false),
(5, "Michael Johnson", false),(5, "Usain Bolt", false),(5, "Milkha Sing", true),(5, "Carl Lewis", false),
(6, "Larisa Latynina", false),(6, "Mark Spitz", false),(6, "Michael Phelps", true),(6, "Saina Nehwal", false),
(7, "14.35 Sec", false),(7, "9.58 Sec", true),(7, "9.05 Sec", false),(7, "10.12 Sec", false),
(8, "12.35 Sec", false),(8, "10.45 Sec", false),(8, "9.55 Sec", false),(8, "10.49 Sec", true),
(9, "Manipur", true),(9, "Mizoram", false),(9, "Nagaland", false),(9, "Tripura", false),
(10, "29", false),(10, "52", false),(10, "21", true),(10, "14", false),
(11, "3", false),(11, "2", false),(11, "1", true),(11, "0", false),
(12, "Birgit Fischer", false),(12, "Marit Bjørgen", false),(12, "Larisa Latynina", true),(12, "Jenny Thompson", false),
(13, "Roger Federer", false),(13, "Usain Bolt", false),(13, "Michael Phelps", true),(13, "Michael Jordan", false),
(14, "Srikanth Kidambi", false),(14, "P.V. Sindhu", false),(14, "P.V. Nehwal", false),(14, "Saina Nehwal", true),
(15, "Weight Lifting", false),(15, "Swiming", false),(15, "Boxing", true),(15, "Shooting", false),
(16, "1930", true),(16, "1925", false),(16, "1934", false),(16, "1818", false),
(17, "2017", false),(17, "2018", true),(17, "2019", false),(17, "2016", false),
(18, "Wales", false),(18, "Scotland", false),(18, "England", true),(18, "Australia", false),
(19, "Feliks Zemdegs", false),(19, "Yusheng Du", true),(19, "Patrick Ponce", false),(19, "Max Park", false),
(20, "France", true),(20, "Germany", false),(20, "Portugal", false),(20, "Uraguay", false),
(21, "Soccer", true), (22, "Turkey", true), (23, "Lacrosse", true),(24, "336", true),(25, "Romania", true),
(26, "Canada", true),(26, "USA", false),(26, "India", false),(26, "Australia", false),
(27, "Denmark", true),(27, "Finland", false),(27, "Sweden", false),(27, "Norway", false),
(28, "Minnesota", true),(28, "New York", false),(28, "Oregon", false),(28, "Washington State", false),
(29, "Greece", false),(29, "Colombia", false),(29, "Mexico", true),(29, "Brazil", false),
(30, "1.2 Billion", true),(30, "2 Billion", false),(30, "1 Billion", false),(30, "870 Million", false),
(31, "Europe", true),(31, "Asia", false),(31, "Antarctica", false),(31, "Africa", false),
(32, "Brazil", true),(32, "Argentina", false),(32, "Peru", false),(32, "Chile", false),
(33, "New Delhi", false),(33, "London", false),(33, "Rome", false),(33, "Istanbul", true),
(34, "Perth", false),(34, "Melbourne", false),(34, "Brisbane", false),(34, "Sydney", true),
(35, "Denmark", true),(35, "Greenland", false),(35, "Iceland", false),(35, "Norway", false),
(36, "Egypt", false),(36, "Algeria", false),(36, "Libya", false),(36, "Sudan", true),
(37, "10%", false),(37, "22%", true),(37, "83%", false),(37, "100%", false),
(38, "Delaware", false),(38, "Montana", false),(38, "Rhode Island", false),(38, "Wyoming", true),
(39, "Sweden", false),(39, "Norway", true),(39, "Croatia", false),(39, "Italy", false),
(40, "Australia", false),(40, "Asia", false),(40, "Antarctica", false),(40, "Africa", true),
(41, "Michigan", false),(41, "New Hampshire", true),(41, "Texas", false),(41, "Missouri", false),
(42, "Ontario", true),(42, "British Columbia", false),(42, "Alberta", false),(42, "Quebec", false),
(43, "Antarctica", false),(43, "Australia", true),(43, "Alberta", false),(43, "Quebec", false),
(44, "Yena", false),(44, "Kirgin", false),(44, "Topchok", false),(44, "Tugrik", true),
(45, "Athens", false),(45, "Damascus", true),(45, "Jerusalem", false),(45, "Jericho", false),
(46, "Australia", true), (47, "Jordan", true),(48, "7", true),(49, "China", true), (50, "11", true),
(51, "Sushi recipes", true),(51, "Dumpling recipes", false),(51, "Stir-fry recipes", false),(51, "Pad thai recipes", false),
(52, "Henry", false),(52, "Eddie", true),(52, "Chuck", false),(52, "Al", false),
(53, "Leonardo DiCaprio", false),(53, "Billy Zane", false),(53, "James Cameron", true),(53, "Kathy Bates", false),
(54, "Tina Fey", false),(54, "Kathryn Hahn", false),(54, "Ellen DeGeneres", false),(54, "Amy Poehler", true),
(55, "Ireland", false),(55, "Iceland", false),(55, "New Zealand", true),(55, "Australia", false),
(56, "Vietnam", false),(56, "China", true),(56, "Sweden", false),(56, "France", false),
(57, "Vincent and Mia’s dance scene", false),(57, "Mia’s overdose scene", true),(57, "The royale with cheese scene", false),(57, "The Ezekiel 25:17 scene", false),
(58, "Tom Cruise", false),(58, "Matt Dillon", false),(58, "Rob Lowe", true),(58, "C. Thomas Howell", false),
(59, "Hattie McDaniel", true),(59, "Sidney Poitier", false),(59, "Dorothy Dandridge", false),(59, "James Earl Jones", false),
(60, "Billy Warp", true),(60, "Veruca Salt", false),(60, "Mike Teavee", false),(60, "Charlie Bucket", false),
(61, "Red and blue", false),(61, "Orange and green", false),(61, "Red and green", true),(61, "Orange and brown", false),
(62, "Francis Ford Coppola", false),(62, "Diane Keaton", false),(62, "Al Pachino", false),(62, "No one—the cat was a stray", true),
(63, "Arendelle", true),(63, "Naples", false),(63, "Florin", false),(63, "Grimm", false),
(64, "155", false),(64, "166", false),(64, "170", false),(64, "179", true),
(65, "The Hunger Games: Mockingjay Part 1", false),(65, "The Lego Movie", false),(65, "Captain America: The Winter Soldier", false),(65, "Guardians of the Galaxy", true),
(66, "27", false),(66, "33", true),(66, "35", false),(66, "20", false),
(67, "James Wan", false),(67, "Jordan Peele", true),(67, "Guillermo del Toro", false),(67, "Tim Story", false),
(68, "A Coca-Cola can", false),(68, "A Starbucks cup", true),(68, "A Dunkin’ donut", false),(68, "A Pepsi bottle", false),
(69, "Iron Man", false),(69, "Captain America: The First Avenger", true),(69, "Doctor Strange", false),(69, "Captain Marvel", false),
(70, "Spy of the World", false),(70, "The Spy Who Shagged Me", false),(70, "International Man of Mystery", true),(70, "in Goldmember", false),
(71, "Tortoises", true), (72, "Sean Penn", true), (73, "Italy", true),(74, "1", true),(75, "Se7en", true);



DROP TABLE IF EXISTS Quiz;
CREATE TABLE IF NOT EXISTS Quiz (
	quiz_id int auto_increment PRIMARY KEY,
    user_id int,
    category_id int,
    start_time timestamp default current_timestamp,
    end_time timestamp,
    quiz_name varchar(50),
    constraint FK_UserQuiz foreign key(user_id) 
    references User(user_id) on delete cascade,
    constraint FK_CategoryQuiz foreign key(category_id) 
    references Category(category_id)
    );

INSERT INTO Quiz (user_id, category_id, start_time, end_time, quiz_name) VALUES 
 (2, 1, '2022-05-15 06:00:00', '2022-05-15 06:10:00', "Ping-Sport");

 SELECT * FROM Quiz;


DROP TABLE IF EXISTS Quiz_Question;
CREATE TABLE IF NOT EXISTS Quiz_Question (
	qq_id int auto_increment PRIMARY KEY,
	quiz_id int,
    question_id int,
    user_choice_id int default 0,
    user_short_answer varchar(255) default 'N/A',
    order_num int default 0,
    is_marked bool default false,
    constraint FK_QuizQQ foreign key(quiz_id) 
    references Quiz(quiz_id) on delete cascade,
    constraint FK_QuestionQQ foreign key(question_id) 
    references Question(question_id) on delete cascade);
    
INSERT INTO Quiz_Question (quiz_id, question_id, user_choice_id, 
user_short_answer, order_num, is_marked) VALUES 
 (1, 1, 2, 'N/A', 1, true), (1, 4, 13, 'N/A', 2, true), (1, 3, 11, 'N/A', 3, true),
 (1, 5, 19, 'N/A', 4, true), (1, 7, 27, 'N/A', 5, true), (1, 2, 6, 'N/A', 6, true),
 (1, 8, 32, 'N/A', 7, true), (1, 11, 42, 'N/A', 8, true), (1, 22, 0, 'Turkey', 9, true),
 (1, 24, 0, '339', 10, true);
 SELECT * FROM Quiz_Question;
 
