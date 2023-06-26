// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();
  $('#usuarios').DataTable();
});

async function cargarUsuarios(){

    const rawResponse = await fetch('api/usuarios', {
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
        htmlUsers += '<td><a href="#" onclick="eliminarUsuario('+ usuario.id +')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td>'
        htmlUsers += '<tr>'
    }

    console.log(usuarios);

    document.querySelector('#usuarios tbody').outerHTML = htmlUsers;

}

async function eliminarUsuario(id){
    if(confirm('Desea eliminar el usuario seleccionado?')){
        const deletion = await fetch(`api/usuarios/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-type': 'application/json'
                }});
        location.reload()
    }
}