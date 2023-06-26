$(document).ready(function(){
})

async function iniciarSesion(){
    let datos = {}
    datos.password =  document.getElementById('exampleInputPassword').value
    datos.email =  document.getElementById('exampleInputEmail').value
    datos.id = null
    datos.nombre = null
    datos.apellido =  null
    datos.telefono =  null
    console.log(JSON.stringify(datos));
    const request = await fetch("api/login",{
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    })
    const respuesta = await request.text()
    console.log(respuesta);
    if(respuesta == "OK") window.location.href = "tables.html";
    else alert("email o contraseña incorrectos")
}