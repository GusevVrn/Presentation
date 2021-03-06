-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Апр 03 2021 г., 16:17
-- Версия сервера: 5.7.29
-- Версия PHP: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `shoponline`
--

-- --------------------------------------------------------

--
-- Структура таблицы `basket`
--

CREATE TABLE `basket` (
  `id` int(11) NOT NULL,
  `id_good` int(20) NOT NULL,
  `id_basket` int(20) NOT NULL,
  `status` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `basket`
--

INSERT INTO `basket` (`id`, `id_good`, `id_basket`, `status`) VALUES
(12, 1, 1, 'Доставлено'),
(13, 2, 1, 'Удалено'),
(14, 4, 1, 'Оплачено');

-- --------------------------------------------------------

--
-- Структура таблицы `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `img` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `category`
--

INSERT INTO `category` (`id`, `name`, `img`) VALUES
(1, 'Смартфоны и гаджеты', 'SmartAndGatgets.jpg'),
(2, 'Компьютеры', 'CompAndPeref.jpg'),
(3, 'Бытовая техника', 'Appliances.png');

-- --------------------------------------------------------

--
-- Структура таблицы `feedback`
--

CREATE TABLE `feedback` (
  `id` int(11) NOT NULL,
  `name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `text` text COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `feedback`
--

INSERT INTO `feedback` (`id`, `name`, `email`, `text`) VALUES
(2, '1', 'none@none.ru', 'text'),
(3, 'Павел', 'none@none.ru', 'testext');

-- --------------------------------------------------------

--
-- Структура таблицы `goods`
--

CREATE TABLE `goods` (
  `id` int(11) NOT NULL,
  `title` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `price` int(11) NOT NULL,
  `img` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_category` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `goods`
--

INSERT INTO `goods` (`id`, `title`, `description`, `price`, `img`, `id_category`) VALUES
(1, 'Apple iPhone SE 2020 64 ГБ', 'Смартфон Apple iPhone SE 2020 характеризуется компактными размерами и элегантным оформлением в белом цвете. Он оснащен дисплеем IPS диагональю 4.7 дюйма (1334x750 пикселей), на котором отображается детализированная картинка с реалистичной цветопередачей. Высокий уровень производительности системы достигается за счет мощного процессора A13 Bionic и 3 ГБ памяти ОЗУ. Вы сможете хранить в устройстве довольно большой массив данных благодаря 64 ГБ встроенной памяти.', 35000, 'IphoneSe.jpg', 1),
(2, 'Apple iPhone Xr 64 ГБ', 'Смартфон Apple iPhone Xr — воплощение красоты и интеллекта. Теперь у вас есть пароль, который надежно защитит ваши личные данные. Это ваше лицо. Вы можете разблокировать iPhone, заходить в приложения и оплачивать покупки буквально одним взглядом. Это очень надежная технология распознавания лица, и теперь она работает еще быстрее.\r\nМощный процессор A12 Bionic - это умный и мощный процессор с системой Neural Engine следующего поколения. Дополненная реальность станет еще реальнее. Функция «Глубина» сделает портреты еще красивее. И в целом все будет работать более быстро и плавно. Передовая камера, инновационная матрица в сочетании с процессором обработки сигнала и системой Neural Engine позволяет делать снимки непревзойденного качества.', 43000, 'IphoneXr.jpg', 1),
(3, 'Apple iPhone 11 64 ГБ', 'Смартфон Apple iPhone 11 − надежный, функциональный аппарат с диагональю экрана 6.1\' в белом металлическом корпусе. Стеклянная панель дополняет образ устройства. Защита в соответствии со стандартом IP68 говорит о том, что на корпус не повлияют никакие воздействия: вы сможете погружать смартфон даже на глубину 2 м на время до 30 мин. Долгая работа в автономном режиме обусловлена использованием аккумулятора емкостью 3110 мА·ч.', 50000, 'Iphone11.jpg', 1),
(4, 'Apple Watch Nike+ Series 3', 'Смарт-часы Apple Watch Nike+ Series 3 GPS 38mm имеют традиционную черную расцветку. На этом их сходство с классическими моделями заканчивается. Прочный корпус выполнен из алюминия со степенью водонепроницаемости 5 бар, а их ремешок изготовлен из эластомера. OLED-экран, кроме большого размера, может «похвастаться» сенсорным управлением.', 18000, 'AppleWatchNike3.jpg', 1),
(5, 'Apple Watch Series S', 'Смарт-часы Apple Watch Series SE GPS оснащены таким же большим дисплеем Retina, как Apple Watch Series 6, поэтому на экране помещается больше важного. И продвинутыми датчиками для отслеживания физической активности и тренировок. И мощными функциями, которые помогают вести здоровый образ жизни и заботятся о вашей безопасности. А приложение «Сон» позволяет настроить набор действий, необходимых вам перед сном, и помогает отслеживать, сколько вы спите. Вы также можете звонить, отвечать на сообщения и слушать музыку — прямо с запястья. У Apple Watch Series SE GPS столько всего, и все это легко доступно.', 25000, 'AppleWatchSeriesSE.jpg', 1),
(6, 'Apple Watch Nike Series 6', 'Смарт-часы Apple Watch Nike Series 6 GPS позволяют вам измерять уровень кислорода в крови с помощью передового датчика и специального приложения. Просматривайте показатели физической активности на улучшенном, всегда включенном дисплее Retina, который теперь светится в 2.5 раза ярче на улице, в неактивном режиме, когда рука с часами внизу. Настройте набор действий, необходимых вам перед сном, и отслеживайте свой режим сна. Отвечайте на звонки и сообщения прямо с запястья. Apple Watch Nike Series 6 GPS - это мощное устройство, с которым гораздо проще вести более здоровый образ жизни, быть активнее и оставаться на связи.', 37000, 'AppleWatchNikeSeries6.jpg', 1),
(7, 'Intel Core i7-9700F OEM', 'Процессор Intel Core i7-9700F OEM – продолжение ставшей, без преувеличения, легендарной линейки i7. Устройство, принадлежащее к 9-му поколению, имеет 8 ядер. Уровень производительности процессора достаточен для эффективного решения исключительного большинства задач, в том числе – профессиональных. Модель характеризуется базовой частотой 3000 МГц. Максимальная частота в турборежиме – 4700 МГц.\r\nTDP процессора Intel Core i7-9700F OEM – лишь 65 Вт. У вас не будет сложностей с выбором совместимого кулера. Помимо устройства охлаждения, вам в любом случае потребуется видеокарта, ведь графическое ядро конструкцией процессора не предусмотрено.', 23000, 'IntelCorei7-9700F.jpg', 2),
(8, 'Intel Core i7-10700F OEM', 'Процессор Intel Core i7-10700F – чип со сбалансированной производительностью. Можно использовать его для создания различных сборок. При изготовлении применялся технологический процесс 14 нм. Он позволяет добиться небольшого потребления энергии и тепловыделения. Процессор выполнен с применением архитектуры Comet Lake. Она позволила поднять производительность в сравнении с чипами прошлого поколения. Используется восемь ядер и шестнадцать потоков для обработки информации.', 24000, 'IntelCorei7-10700F.jpg', 2),
(9, 'Intel Core i7-8700 OEM', '6-ядерный процессор Intel Core i7-8700 OEM, базовая частота которого равна 3200 МГц, обеспечивает уровень производительности, не нуждающийся в дополнительных комментариях. Модель, базирующаяся на ядре Coffee Lake S, наилучшим образом подходит для использования в составе мощных игровых систем или производительных рабочих станций универсального назначения. Процессор характеризуется объемами кэш-памяти второго и третьего уровней, равными 1.5 и 12 МБ соответственно. В турборежиме частота процессора может достигать впечатляющих 4600 МГц. Одним из важных технологических преимуществ модели является наличие высокопроизводительного графического процессора Intel UHD Graphics 630, максимальная частота работы которого равна 1200 МГц.', 250000, 'IntelCorei7-8700.jpg', 2),
(10, 'GIGABYTE H310M', 'Материнская плата GIGABYTE H310M H 2.0 имеет прямоугольную форму: ее габаритные размеры составляют 226x174 мм. Плата подойдет для сборки офисной или домашней системы, которая преимущественно используется для работы с офисными программами и интернет-браузерами. Для установки видеокарты можно использовать слот PCI-E x16. Достоинством компактной платы является наличие 2 слотов PCI-E x1.', 3850, 'GIGABYTEH310M.jpg', 2),
(11, 'ASRock H310CM-DVS', 'Материнская плата ASRock H310CM-DVS совместима с процессорами Intel LGA 1151-v2. Модель, соответствующая форм-фактору Micro-ATX, базируется на широко распространенном чипсете Intel H310. Плата позиционируется производителем в роли основы системного блока офисного класса. Использовать такой компьютер можно и дома: он подойдет для работы и учебы.', 4000, 'ASRockH310CM.jpg', 2),
(12, 'ASUS PRIME H310M', 'Материнская плата ASUS PRIME H310M-K R2.0 — надежная и функциональная платформа, которая может стать основой компьютера для домашнего или офисного использования. Данная модель оснащена продуманной системой питания, технологией защиты от перепадов напряжения ASUS Overvoltage Protection, а также защитой от электростатических разрядов, что обеспечивает длительное и безопасное использование.\r\n', 4200, 'ASUSPRIMEH310M.jpg', 2),
(13, 'LG GA-B459CQWL', 'Холодильник LG GA-B459CQWL обладает небольшой шириной и глубиной, 59.5 и 68.2 см соответственно. Это значит, что место для него найдется практически на каждой кухне. Дверца модели имеет перенавешиваемую конструкцию и нулевой зазор. Благодаря этому холодильник можно вплотную приставить к стене. За счет высоты модели, составляющей 186 см, внутри удалось разместить 4 стеклянных полки, большой отсек для овощей и фруктов, а также 3 ящика в морозильной камере.', 37000, 'LGGA-B459CQWL.jpg', 3),
(14, 'LG GA-B509MMQZ', '384-литровый холодильник LG GA-B509MMQZ оборудован надежным и энергоэффективным инверторным компрессором. Дополнительным преимуществом компрессоров этого типа является малошумность. Уровень шума холодильника не превышает 36 дБ. Годовое энергопотребление модели – 255 кВт. Это очень хороший показатель для холодильников значительного объема. Устройство соответствует классу энергоэффективности A++. Климатические классы холодильника – SN и ST.', 46000, 'LGGA-B509MMQZ.jpg', 3),
(15, 'LG GA-B509MCUM', 'Холодильник LG GA-B509MCUM выполнен в стильном дизайне с металлической отделкой серого цвета и обеспечивает качественное хранение продуктов благодаря ряду фирменных технологий. Данная модель характеризуется общим полезным объемом 341 л и 2-камерной конструкцией, разделенной на независимые друг от друга морозильное и холодильное отделения. Технология FRESHConverter предусматривает возможность выбора оптимальной температуры охлаждения в зависимости от типа продуктов. Складная 2-позиционная полка позволяет управлять внутренним пространством для удобного размещения продуктов.', 60000, 'LGGA-B509MCUM.jpg', 3),
(16, 'LG F1096SDS3', 'Стиральная машина LG F1096SDS3 обладает сверхкомпактными размерами (ее ширина составляет 60 см, а глубина – 36 см), за счет чего ее можно удобно разместить даже в маленькой ванной. За раз она очищает до 4 кг белья на одной из 13 выбранных программ. При необходимости вещи можно обработать паром для выведения пятен и дезинфекции. В основе работы машины – инверторный двигатель с прямым приводом. При необходимости начать работу прибора позже можно активировать опцию отсрочки старта на период до 19 ч.+', 20000, 'LGF1096SDS3.jpg', 3),
(17, 'LG F2M5HS6S', 'Стиральная машина LG F2M5HS6S в черно-серебристом корпусе станет идеальным выбором для большой семьи за счет возможности стирать до 7 кг белья за цикл. Это позволяет одновременно очистить внутри два комплекта постельного, большое одеяло или пуховик. Модель работает за счет инверторного двигателя, обладает управлением с помощью поворотного механизма и дисплеем, на котором отображается вся необходимая пользователю информация.', 30000, 'LGF2M5HS6S.jpg', 3),
(18, 'LG F2T5HG2S', 'Стирально-сушильная машина LG F2T5HG2S выполнена в стильном серебристом корпусе и предлагает расширенный функционал для заботы о ваших вещах. Интеллектуальная система определения типа ткани AI DD, в память которой заложено около 20000 возможных сочетаний ткани, обеспечивает распознавание веса и характеристик ткани для точного определения оптимальных параметров стирки. Функция сушки обеспечивает правильный уход за состоянием ваших вещей. На выбор предлагается 3 режима сушки: стандартная, бережная и легкая. Технология LG Steam+ с помощью пара устраняет вирусы, бактерии и бытовые аллергены.', 50000, 'LGF2T5HG2S.jpg', 3),
(19, 'LG VC53202NHTR', 'Пылесос LG VC53202NHTR Kompressor в эффектном красно-сером корпусе предназначен для выполнения сухой уборки. Устройство при мощности 2000 Вт обладает интенсивностью всасывания 380 Вт. Циклонный пылесборник объемом 1.5 л сочетается с фильтром тонкой очистки. Регулятор мощности расположен на рукоятке. Телескопическая трубка в сочетании с 5-метровым сетевым шнуром обеспечивают радиус действия до 8 м, это позволяет удаляться от розетки на значительное расстояние.', 7000, 'LGVC53202NHTR.jpg', 3),
(20, 'LG VK89309H', 'Пылесос LG VK89309H будет вашим надежным помощником во время уборки на долгие годы. Классический внешний вид и серебристый корпус лаконично впишется в интерьер и удовлетворит пользователей. Обладает функцией только сухой уборкой и фильтром тонкой очистки. Требует для себя всего 2000 Вт с мощностью всасывания до 420 Вт и радиусом действия в 9.3 метра. Вмещает в себя до 1.2 литров мусора и работает от сети.', 12000, 'LGVK89309H.jpg', 3),
(21, 'LG VK-88509HUG', 'Пылесос LG VK-88509HUG предназначен для эффективной очистки ковров и других напольных покрытий. Мотор мощностью 2000 Вт обеспечивает бережный и быстрый уход. Технология Kompressor позволяет вмещать больше пыли и грязи. Специальная лопасть в контейнере собирает собранный сор в брикеты, при этом сохраняя высокую производительность даже при максимальной загрузке. Емкость пылесборника составляет 4.8 л, поэтому очистку можно осуществлять после нескольких циклов уборки.', 16000, 'LGVK-88509HUG.jpg', 3);

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(35) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(35) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_basket` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `phone`, `id_basket`) VALUES
(1, 'admin', 'admin', '84950000000', 0),
(23, 'user', 'user', '89803400730', 1);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `basket`
--
ALTER TABLE `basket`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `goods`
--
ALTER TABLE `goods`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `basket`
--
ALTER TABLE `basket`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT для таблицы `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `feedback`
--
ALTER TABLE `feedback`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `goods`
--
ALTER TABLE `goods`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT для таблицы `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
