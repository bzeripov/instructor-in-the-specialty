let pb = document.querySelector('.profile-btn'),
    pr = document.querySelector('.profile'),
    ud = document.querySelector('.update'),
    au = document.querySelector('.ava-update'),
    ubi = document.querySelector('.user-brief-information');


document.querySelector('.update-btn').addEventListener('click',()=>{
    defaultStyle();
    ud.style.color = '#555';
    pb.style.border = '1px solid white';
    pb.style.borderBottom = '1px solid #555';
    ud.style.borderBottom = '1px solid white';
    pr.style.visibility = 'hidden';
    ud.style.visibility = 'visible';
    au.style.display = 'block';
    ubi.style.height = '450px';
})


pb.addEventListener('click',()=>{
    defaultStyle();
    pb.style.color = '#555';
    ud.style.border = '1px solid white';
    ud.style.borderBottom = '1px solid #555';
    pb.style.borderBottom = '1px solid white';
    ud.style.visibility = 'hidden';
    pr.style.visibility = 'visible';
    au.style.display = 'none';
    ubi.style.height = '370px';
})

function defaultStyle(){
    pb.style.color = '#337ab7';
    ud.style.color = '#337ab7';
    pb.style.border = '1px solid #555';
    ud.style.border = '1px solid #555';
}

