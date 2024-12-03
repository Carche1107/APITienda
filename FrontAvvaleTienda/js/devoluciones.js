const urlLocal = "http://localhost:8080";
function BuscarVentas(){
    let idTienda = document.getElementById("idTienda").value;
    let NombreDia = document.getElementById("dia").value;
    let Hora = document.getElementById("hora").value;
    let Minuto = document.getElementById("minuto").value;

    fetch (`${urlLocal}/Sell?shop=${idTienda}&Day=${NombreDia}&Hour=${Hora}&Minute=${Minuto}`,
    {
        method: 'GET',
        mode: 'cors'
    })
    .then(response => response.json())
    .then(data => {
        console.log(data)
        ListarVentas(data);
    }).catch(error => console.error('Error al buscar las ventas realizadas', error));
}

function ListarVentas(sales){
    let Cuerpo = document.getElementById("TableBody");
    Cuerpo.innerHTML = '';
    sales.forEach(element => {
        let row = document.createElement('tr');
        row.innerHTML = 
        `<td>${element.shopName}</td>
        <td>${element.productName}</td>
        <td>${element.colorName}</td>
        <td>${element.price}€</td>
        <td>${element.totalProducts}</td>
        <td>${element.time}</td>
        <td>${element.dayType}</td>
        <td><button onclick="crearDevolucion(${element.saleId})" class="formbold-btn">Devolver</button></td>`;
        Cuerpo.appendChild(row);
    });
}

function crearDevolucion(saleId){
    fetch(`${urlLocal}/Return?saleId=${saleId}`, 
    {
        method: 'POST', 
        mode: 'cors'
    }).then(response => {
            if (response.ok){
                alert("Devolución realizada con éxito")
                BuscarVentas();
            }else{
                alert("Error al realizar la devolucion")
            }
        }).catch(error => console.error('Error', error));
}

function cargarTiendas(){
    fetch(`${urlLocal}/Shop`, 
        {
            method: 'GET',
            mode: 'cors'
        }
    ).then(response => response.json())
    .then(tiendas => {
        let select = document.getElementById("idTienda");
        select.innerHTML = '';
        let defaultOpt = document.createElement("option");
        defaultOpt.value = '';
        defaultOpt.textContent = "Tienda"
        defaultOpt.disabled = true;
        defaultOpt.selected = true;
        select.appendChild(defaultOpt);

        tiendas.forEach(tienda => {
            let opcion = document.createElement("option");
            opcion.value = tienda.shopId;
            opcion.textContent = tienda.shopName;
            select.appendChild(opcion);
        });
    }).catch(error => console.error("Error al cargar las tiendas", error));
    }   

    window.onload = cargarTiendas;
