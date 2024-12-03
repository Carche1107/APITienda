package com.avvale.API.APITienda.Services;


import com.avvale.API.APITienda.DTO.DiscountPriceDTO;
import com.avvale.API.APITienda.DTO.StockDetailsDTO;
import com.avvale.API.APITienda.DTO.StockListWithPrice;
import com.avvale.API.APITienda.Models.StockModel;
import com.avvale.API.APITienda.Respositories.ColorRepository;
import com.avvale.API.APITienda.Respositories.StockRepository;
import com.avvale.API.APITienda.Respositories.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockService {

    @Autowired
    StockRepository stockRepository;

    @Autowired
    TiendaRepository tiendaRepository;

    @Autowired
    ColorRepository colorRepository;

    @Autowired
    DiscountService discountService;

    public Integer findStocksByShopProductAndColor(Long shopProduct, Long color, Long tienda) {

        Integer stocksAmount = stockRepository.getAmountByShopProductAndColor(shopProduct, color, tienda);

        return stocksAmount;

    }

    public void updateStockAmount(Long shopProduct, Long color, Long tienda, Integer amount) {

        StockModel stockModel = stockRepository.findStock(shopProduct, color, tienda);
        if (stockModel == null){
            throw new RuntimeException("No existe el stock de lo que se pide");
        } else if ((stockModel.getAmount() - amount) <= 0) {
            throw new RuntimeException("No Existe suficiente stock en la tienda");
        } else {
            stockModel.setAmount(stockModel.getAmount() - amount);
            stockRepository.save(stockModel);
        }
    }
    public void updateStockAmountReturns(Long shopProduct, Long color, Long tienda, Integer amount) {

        StockModel stockModel = stockRepository.findStock(shopProduct, color, tienda);
        if (stockModel == null){
            throw new RuntimeException("No existe el stock de lo que se pide");
        } else {
            stockModel.setAmount(stockModel.getAmount() + amount);
            stockRepository.save(stockModel);
        }
    }

    //PUNTO 5: DEVOLVER EL STOCK DE UN PRODUCTO Y COLOR DADO DE CADA TIENDA
    public List<StockDetailsDTO> findStockByProductAndColor(Long product, Long color) {

        List<Object[]> stocks = stockRepository.findByProductAndColor(product, color);
        return stocks.stream().map(row -> new StockDetailsDTO((String) row[0], (String) row[1], (String) row[2], (Integer) row[3])).collect(Collectors.toList());

    }
    //Obtener listado de stock de productos y colores con el precio con descuento y sin descuento
    public List<StockListWithPrice> getPrices(){
        List<Object[]> stocks = stockRepository.ListStocks();
        List<StockListWithPrice> stockListWithPrices = stocks.stream().map(row -> new StockListWithPrice((String) row[0], (String) row[1], (String) row[2], (Integer) row[3], new BigDecimal(row[4].toString()), null)).collect(Collectors.toList());
        //Iteramos sobre cada Stock y calculamos el precio con descuentos y sin descuento
        for (StockListWithPrice stockListWithPrice : stockListWithPrices) {
            //Obtener el incremento de la tienda
            double ShopIncrement = tiendaRepository.incrementCash(stockListWithPrice.getShopName());
            stockListWithPrice.setPriceWithTax(stockListWithPrice.getPriceWithTax().setScale(2, RoundingMode.HALF_UP).multiply(((BigDecimal.valueOf(ShopIncrement)).add(BigDecimal.ONE))));
            //Obtener el incremento por color
            String incrementType = colorRepository.getColorIncrementType(stockListWithPrice.getColor());
            double colorIncrement = colorRepository.getColorIncrement(stockListWithPrice.getColor());
            //Se calcula por Porcentaje o por Valor fijo en funcion del tipo de incremento
            switch (incrementType){
                case "M" -> {
                    stockListWithPrice.setPriceWithTax(stockListWithPrice.getPriceWithTax().setScale(2, RoundingMode.HALF_UP).add(BigDecimal.valueOf(colorIncrement).setScale(2, RoundingMode.HALF_UP)));
                }
                case "P" -> {
                    stockListWithPrice.setPriceWithTax(stockListWithPrice.getPriceWithTax().setScale(2, RoundingMode.HALF_UP).multiply((BigDecimal.valueOf(colorIncrement).setScale(2, RoundingMode.HALF_UP).add(BigDecimal.ONE))));
                }
            }
            //Agregamos a cada DTO los precios calculados en la función de discountService
            List<DiscountPriceDTO> discounts = discountService.findDiscountsByDayAndTime(LocalDateTime.now().getDayOfWeek().toString(), LocalDateTime.now().getHour(), stockListWithPrice.getPriceWithTax());
            stockListWithPrice.setPriceWithTax(stockListWithPrice.getPriceWithTax().setScale(2, RoundingMode.HALF_UP));
            stockListWithPrice.setPriceWithDiscounts(discounts.getFirst().getDiscountPrice().setScale(2, RoundingMode.HALF_UP));
        }
        //Ordenamos la lista de forma alfabetica por tienda, por Producto y despues de menor precio a mayor precio el precio con descuento
        stockListWithPrices.sort(Comparator
                .comparing(StockListWithPrice::getShopName)       // Primero por nombre de la tienda
                .thenComparing(StockListWithPrice::getProductName) // Luego por nombre del producto// Luego por color del producto
                .thenComparing(stock -> stock.getPriceWithDiscounts().setScale(2, RoundingMode.HALF_UP))); // Finalmente por precio

        return stockListWithPrices;
    }



}
