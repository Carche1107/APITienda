const urlLocal = "http://localhost:8080";

function searchShopCash(){
    fetch(`${urlLocal}/Shop/Cash`, {
        method: 'GET',
        mode: 'cors'
    }).then(response => response.json())
    .then(cajas => {
        console.log(cajas);
        let Titulo = document.getElementById("Tiempo");
        Titulo.textContent = `Ganancias de cada tienda a fecha y hora: ${cajas.time}`;
        let Cuerpo = document.getElementById("TableBody");
        Cuerpo.innerHTML = '';
        cajas.shopCurrentCashDTOList.forEach(element => {
            let row = document.createElement('tr');
            row.innerHTML = 
            `<td>${element.shopName}</td>
            <td>${element.currentCash}€</td>`;
        Cuerpo.appendChild(row);
            
        }); 
    }).catch(error => console.error("Error al cargar las ganancias", error));
}

window.addEventListener("load", searchShopCash);