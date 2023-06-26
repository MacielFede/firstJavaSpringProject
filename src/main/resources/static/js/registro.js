$(document).ready(function(){

})

async function registrarUsuario(){
    contrasena =  document.getElementById('exampleInputPassword').value
    contrasenaRepetida =  document.getElementById('exampleRepeatPassword').value
    if(contrasena !== contrasenaRepetida){
        alert("Las contraseñas difieren")
        return
    }

    let datos = {}
    datos.id = null
    datos.nombre = document.getElementById('exampleFirstName').value
    datos.apellido =  document.getElementById('exampleLastName').value
    datos.telefono =  document.getElementById('exampleInputTel').value
    datos.password =  contrasenaRepetida
    datos.email =  document.getElementById('exampleInputEmail').value
    const request = await fetch("api/usuarios",{
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    })
    window.location.href = "tables.html";
}