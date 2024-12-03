const urlLocal = "http://localhost:8080";
function Comprar(){
    let idTienda = document.getElementById("idTienda").value;
    let idProducto = document.getElementById("idProducto").value;
    let idColor = document.getElementById("idColor").value;
    let totalProducts = document.getElementById("totalProducts").value;
    let datetime = document.getElementById("datetime").value;

    fetch(`${urlLocal}/Sell`,
        {
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                idShop: idTienda,
                idProduct: idProducto,
                idColor: idColor,
                totalProducts: totalProducts,
                time: datetime,
                initialPrice: 0,
                incrementApplied: 0,
                discountApplied: 0,
                totalPrice: 0
            })
        }).then(response => {
            if (response.ok){
                alert("Compra Realizada")
            }else{
                alert("Error al realizar la compra")
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
        console.log(tiendas);
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
function cargarProductos(){
    fetch(`${urlLocal}/product`,
        {
            method: 'GET',
            mode: 'cors'
        }
    ).then(response => response.json())
    .then(tiendas => {
        console.log(tiendas);
        let select = document.getElementById("idProducto");
        select.innerHTML = '';
        let defaultOpt = document.createElement("option");
        defaultOpt.value = '';
        defaultOpt.textContent = "Prenda"
        defaultOpt.disabled = true;
        defaultOpt.selected = true;
        select.appendChild(defaultOpt);

        tiendas.forEach(tienda => {
            let opcion = document.createElement("option");
            opcion.value = tienda.idProduct;
            opcion.textContent = tienda.productName;
            select.appendChild(opcion);
        });
    }).catch(error => console.error("Error al cargar los productos", error));
}

function cargarColores(){
    fetch(`${urlLocal}/color`, 
        {
            method: 'GET',
            mode: 'cors'
        }
    ).then(response => response.json())
    .then(tiendas => {
        console.log(tiendas);
        let select = document.getElementById("idColor");
        select.innerHTML = '';
        let defaultOpt = document.createElement("option");
        defaultOpt.value = '';
        defaultOpt.textContent = "Color"
        defaultOpt.disabled = true;
        defaultOpt.selected = true;
        select.appendChild(defaultOpt);

        tiendas.forEach(tienda => {
            let opcion = document.createElement("option");
            opcion.value = tienda.id;
            opcion.textContent = tienda.color;
            select.appendChild(opcion);
        });
    }).catch(error => console.error("Error al cargar los colores", error));
}

window.addEventListener("load", cargarTiendas);
window.addEventListener("load", cargarProductos);
window.addEventListener("load", cargarColores);
    
    