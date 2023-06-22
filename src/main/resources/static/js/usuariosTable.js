// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();
  $('#usuarios').DataTable();
});

async function cargarUsuarios(){

    const rawResponse = await fetch('usuarios', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-type': 'application/json'
        }
    });
    const usuarios = await rawResponse.json();

    let htmlUsers = ''
    for (let usuario of usuarios){
        htmlUsers += '<tr>'
        htmlUsers += `<td>${usuario.id}</td>`
        htmlUsers += `<td>${usuario.nombre} ${usuario.apellido}</td>`
        htmlUsers += `<td>${usuario.email}</td>`
        htmlUsers += `<td>${usuario.telefono}</td>`
        htmlUsers += '<tr>'
    }

    console.log(usuarios);

    document.querySelector('#usuarios tbody').outerHTML = htmlUsers;

}