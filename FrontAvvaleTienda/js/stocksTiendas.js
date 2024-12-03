const urlLocal = "http://localhost:8080";

function searchStocksShop(){
    fetch(`${urlLocal}/Stock`, {
        method: 'GET',
        mode: 'cors'
    }).then(response => response.json())
    .then(stocks => {
        console.log(stocks);
        let Cuerpo = document.getElementById("TableBody");
        Cuerpo.innerHTML = '';
        stocks.forEach(element => {
            let row = document.createElement('tr');
            row.innerHTML = 
            `<td>${element.shopName}</td>
            <td>${element.productName}</td>
            <td>${element.color}</td>
            <td>${element.priceWithTax}€</td>
            <td>${element.priceWithDiscounts}€</td>
            <td>${element.stockAmount}</td>`;
        Cuerpo.appendChild(row);
            
        }); 
    }).catch(error => console.error("Error al cargar las ganancias", error));
}

window.addEventListener("load", searchStocksShop);