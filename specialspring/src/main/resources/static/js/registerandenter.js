let enter = document.getElementById('transition-enter'),
    register = document.getElementById('transition-register');


enter.addEventListener('click',()=>{
    document.querySelector('.register-form-container').style.display = 'none';
    document.querySelector('.enter-form-container').style.display = 'block';
})


register.addEventListener('click',()=>{
    document.querySelector('.register-form-container').style.display = 'block';
    document.querySelector('.enter-form-container').style.display = 'none';
})