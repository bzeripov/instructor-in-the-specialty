let fr = document.querySelectorAll('.region'),
    nr = document.querySelector('.name-region'),
    rnu = document.querySelector('.region-name-university'),
    t = 20,
    rp = document.querySelectorAll('.region-place'),
    rr = document.querySelectorAll('.region-rating');

for(let i=0; i<fr.length;i++){
    fr[i].addEventListener('click',()=>{
        nr.innerText = '';
        nameForRegion(i)
        returnToDefault();
        fr[i].style.fill = '#00b1cc';
        fr[i].style.filter = ' drop-shadow(0 0 20px #00b1cc)';
        if( i == t){
            returnToDefault();
            nr.innerText = 'Казахстан';
            rnu.innerText = 'Казахстана';
            returnRatingUniversity(region15);
        }
        t=i;
    })
}



function returnToDefault(){
    for(let i=0; i<fr.length;i++){
        fr[i].style.fill = 'rgb(241,245,254)';
        fr[i].style.filter = '';
    }
}

function nameForRegion(i){
    switch(i){
        case 0:
            nr.innerText = 'Туркестанская область';
            rnu.innerText = 'Туркестанской области';
            returnRatingUniversity(region0);
        break;
        case 1:
            nr.innerText = 'Акмолинская область';
            rnu.innerText = 'Акмолинской области';
            returnRatingUniversity(region1);
        break;
        case 2:
            nr.innerText = 'Актюбинская область';
            rnu.innerText = 'Актюбинской области';
            returnRatingUniversity(region2);
        break;
        case 3:
            nr.innerText = 'Алматинская область';
            rnu.innerText = 'Алматинской области';
            returnRatingUniversity(region3);
            break;
        case 4:
            nr.innerText = 'Атырауская область';
            rnu.innerText = 'Атырауской области';
            returnRatingUniversity(region4);
        break;
        case 5:
            nr.innerText = 'Карагандинская область';
            rnu.innerText = 'Карагандинской области';
            returnRatingUniversity(region5);
        break;
        case 6:
            nr.innerText = 'Кызылординская область';
            rnu.innerText = 'Кызылординской области';
            returnRatingUniversity(region6);
        break;
        case 7:
            nr.innerText = 'Костанайская область';
            rnu.innerText = 'Костанайской области';
            returnRatingUniversity(region7);
        break;
        case 8:
            nr.innerText = 'Мангистауская область';
            rnu.innerText = 'Мангистауской области';
            returnRatingUniversity(region8);
        break;
        case 9:
            nr.innerText = 'Павлодарская область';
            rnu.innerText = 'Павлодарской области';
            returnRatingUniversity(region9);
        break;
        case 10:
            nr.innerText = 'Северо-Казахстанская область';
            rnu.innerText = 'Северо-Казахстанской области';
            returnRatingUniversity(region10);
        break;
        case 11:
            nr.innerText = 'Восточно-Казахстанская область';
            rnu.innerText = 'Восточно-Казахстанской области';
            returnRatingUniversity(region11);
        break;
        case 13:
            nr.innerText = 'Жамбылская область';
            rnu.innerText = 'Жамбылской области';
            returnRatingUniversity(region13);
        break;
        default:
            nr.innerText = 'Западно-Казахстанская область';
            rnu.innerText = 'Западно-Казахстанской области';
            returnRatingUniversity(region14);
        break;
    }
}
/*Туркистан */
const region0 = {
    nameUniversity1 :  "Международный гуманитарно-технический университет",
    universityRating1 : "86.32",    
    nameUniversity2 :  "Международный казахско-турецкий университет имени Х. А. Яссави",
    universityRating2 : "84.56",    
    nameUniversity3 :  "Шымкентский социально-педагогический университет",
    universityRating3 : "80.64",    
    nameUniversity4 :  "Южно-Казахстанская государственная фармацевтическая академия",
    universityRating4 : "75.63",    
    nameUniversity5 :  "Южно-Казахстанский государственный университет имени М. О. Ауэзова",
    universityRating5 : "71.05",    
}
/*Акмола */
const region1 = {
    nameUniversity1 :  "Евразийский национальный университет имени Л. Н. Гумилёва",
    universityRating1 : "97.96",    
    nameUniversity2 :  "Назарбаев Университет",
    universityRating2 : "97.78",    
    nameUniversity3 :  "Казахский государственный агротехнический университет им. С.Сейфуллина",
    universityRating3 : "95.63",    
    nameUniversity4 :  "Академия пограничной службы КНБ Республики Казахстан",
    universityRating4 : "93.32",    
    nameUniversity5 :  "Казахский Гуманитарно-Юридический Университет им. М.С. Нарикбаева ",
    universityRating5 : "89.75",    
}
/*Актобе */
const region2 = {
    nameUniversity1 :  "Актюбинский региональный государственный университет им.К.Жубанова",
    universityRating1 : "79.64",    
    nameUniversity2 :  "Западно-Казахстанский государственный медицинский университет имени М. Оспанова",
    universityRating2 : "78.36",    
    nameUniversity3 :  "Военный институт сил воздушной обороны имени Т.Я. Бегелдинова",
    universityRating3 : "74.48",    
    nameUniversity4 :  "Актюбинский университет им. С. Баишева",
    universityRating4 : "67.09",    
    nameUniversity5 :  "Казахско-Русский международный университет",
    universityRating5 : "65.32",    
}
/*Алматы */
const region3 = {
    nameUniversity1 :  "Казахский национальный исследовательский технический университет имени К. И. Сатпаева",
    universityRating1 : "100.00",    
    nameUniversity2 :  "Казахский национальный университет имени аль-Фараби",
    universityRating2 : "98.97",    
    nameUniversity3 :  "Казахский национальный педагогический университет имени Абая",
    universityRating3 : "95.03",    
    nameUniversity4 :  "Казахстанско-Британский технический университет",
    universityRating4 : "93.16",    
    nameUniversity5 :  "Университет имени Сулеймана Демиреля",
    universityRating5 : "90.96",    
}
/*Атырау */
const region4 = {
    nameUniversity1 :  "Атырауский государственный университет имени Х. Досмухамедова",
    universityRating1 : "79.12",    
    nameUniversity2 :  "Атырауский университет нефти и газа",
    universityRating2 : "77.64",    
    nameUniversity3 :  "Атырауский университет нефти и газа имени Сафи Утебаева",
    universityRating3 : "73.79",    
    nameUniversity4 :  "Атырауский институт менеджмента и маркетинга",
    universityRating4 : "63.36",    
    nameUniversity5 :  "Центрально-Азиатский Университет ЦДО",
    universityRating5 : "61.57",    
}
/*Караган */
const region5 = {
    nameUniversity1 :  "Медицинский Университет Караганды",
    universityRating1 : "74.63",    
    nameUniversity2 :  "Карагандинский государственный университет им. академика Е. А. Букетова",
    universityRating2 : "71.35",    
    nameUniversity3 :  "Карагандинский экономический университет Казпотребсоюза",
    universityRating3 : "68.12",    
    nameUniversity4 :  "Карагандинский Государственный Технический Университет",
    universityRating4 : "63.52",    
    nameUniversity5 :  "Казахстанский институт менеджмента и маркетинга",
    universityRating5 : "59.74",    
}
/*Кызылорда */
const region6 = {
    nameUniversity1 :  "Кызылординский государственный университет имени Коркыт Ата",
    universityRating1 : "71.18",    
    nameUniversity2 :  "Гуманитарно-технический институт Акмешит",
    universityRating2 : "69.32",    
    nameUniversity3 :  "Казахско-Китайский институт",
    universityRating3 : "66.23",    
    nameUniversity4 :  "Университет Болашак",
    universityRating4 : "61.35",    
    nameUniversity5 :  "Кызылординский академический университет экономики, экологии и права",
    universityRating5 : "55.98",    
}
/*Костанай */
const region7 = {
    nameUniversity1 :  "Костанайский государственный педагогический университет имени У. Султангазина",
    universityRating1 : "76.84",    
    nameUniversity2 :  "Костанайский государственный университет имени А. Байтурсынова",
    universityRating2 : "74.63",    
    nameUniversity3 :  "Костанайская академия МВД Республики Казахстан им. Ш. Кабылбаева",
    universityRating3 : "70.15",    
    nameUniversity4 :  "Костанайский социально-технический университет имени З. Алдамжара",
    universityRating4 : "68.36",    
    nameUniversity5 :  "Костанайский инженерно-экономический университет им. М. Дулатова",
    universityRating5 : "61.12",    
}
/*Мангистау */
const region8 = {
    nameUniversity1 :  "Каспийский государственный университет технологий и инжиниринга им. Ш.Есенова",
    universityRating1 : "73.05",    
    nameUniversity2 :  "Мангистауский гуманитарно-технический университет",
    universityRating2 : "71.34",    
    nameUniversity3 :  "Казахстанский морской университет",
    universityRating3 : "68.12",    
    nameUniversity4 :  "Центрально-Азиатский Университет",
    universityRating4 : "64.87",    
    nameUniversity5 :  "Университет Кайнар",
    universityRating5 : "60.07",    
}
/*Палодар обл */
const region9 = {
    nameUniversity1 :  "Павлодарский государственный педагогический институт",
    universityRating1 : "65.76",    
    nameUniversity2 :  "Павлодарский государственный университет им. С. Торайгырова",
    universityRating2 : "61.74",    
    nameUniversity3 :  "Инновационный Евразийский университет",
    universityRating3 : "59.65",    
    nameUniversity4 :  "Экибастузский инженерно-технический институт имени академика К. И. Сатпаева",
    universityRating4 : "57.78",    
    nameUniversity5 :  "Павлодарский казахско-российский институт",
    universityRating5 : "50.35",    
}

/*Северо казах */
const region10 = {
    nameUniversity1 :  "Северо-Казахстанский государственный университет имени М. Козыбаева",
    universityRating1 : "63.5",    
    nameUniversity2 :  "Военный институт Национальной гвардии Республики Казахстан",
    universityRating2 : "61.32",    
    nameUniversity3 :  "Северо-Казахстанская юридическая академия",
    universityRating3 : "58.46",    
    nameUniversity4 :  "Северо-Казахстанский проектный институт",
    universityRating4 : "51.78",    
    nameUniversity5 :  "Центрально-Азиатский Университет",
    universityRating5 : "46.94",    
}
/*Восток казах */
const region11 = {
    nameUniversity1 :  "Восточно-Казахстанский государственный университет имени С. Аманжолова",
    universityRating1 : "81.63",    
    nameUniversity2 :  "Восточно-Казахстанский государственный технический университет имени Д. Серикбаева",
    universityRating2 : "78.12",    
    nameUniversity3 :  "Государственный медицинский университет города Семей",
    universityRating3 : "74.31",    
    nameUniversity4 :  "Восточно-Казахстанский региональный университет",
    universityRating4 : "65.96",    
    nameUniversity5 :  "Казахская финансово-экономическая академия",
    universityRating5 : "59.83",    
}
/*Жамбыл */
const region13 = {
    nameUniversity1 :  "Таразский государственный университет имени М. Х. Дулати",
    universityRating1 : "83.02",    
    nameUniversity2 :  "Жамбылский гуманитарно-технический университет",
    universityRating2 : "79.52",    
    nameUniversity3 :  "Таразский инновационно-гуманитарный университет ",
    universityRating3 : "76.58",    
    nameUniversity4 :  "Таразский технический институт",
    universityRating4 : "69.21",    
    nameUniversity5 :  "Таразский государственный педагогический институт",
    universityRating5 : "65.01",    
}
/*Запад */
const region14 = {
    nameUniversity1 :  "Западно-Казахстанский государственный университет имени М. Утемисова",
    universityRating1 : "75.8",    
    nameUniversity2 :  "Западно-Казахстанский аграрно-технический университет имени Жангир хана",
    universityRating2 : "69.28",    
    nameUniversity3 :  "Западно-Казахстанский инженерно-гуманитарный университет",
    universityRating3 : "67.13",    
    nameUniversity4 :  "Западно-Казахстанский инновационно-технологический университет",
    universityRating4 : "63.17",    
    nameUniversity5 :  "Казахстанский институт информационных технологий и управления",
    universityRating5 : "59.67",    
}
/*Казахстан */
const region15 = {
    nameUniversity1 :  "Казахский национальный университет им. Аль-Фараби",
    universityRating1 : "99.87",    
    nameUniversity2 :  "Евразийский национальный университет имени Л.Н.Гумилева",
    universityRating2 : "95.58",    
    nameUniversity3 :  "Южно-Казахстанский Государственный Университет Имени М.Ауезова",
    universityRating3 : "62.05",    
    nameUniversity4 :  "Казахский национальный аграрный университет",
    universityRating4 : "59.02",    
    nameUniversity5 :  "Казахский педагогический университет имени Абая",
    universityRating5 : "54.72",    
}

function returnRatingUniversity(s){
    rp[0].innerText = s.nameUniversity1;
    rp[1].innerText = s.nameUniversity2;
    rp[2].innerText = s.nameUniversity3;
    rp[3].innerText = s.nameUniversity4;
    rp[4].innerText = s.nameUniversity5;
    rr[0].innerText = s.universityRating1;
    rr[1].innerText = s.universityRating2;
    rr[2].innerText = s.universityRating3;
    rr[3].innerText = s.universityRating4;
    rr[4].innerText = s.universityRating5;
}