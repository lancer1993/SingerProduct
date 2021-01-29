/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import beans.ItemStock;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import rest.filter.Secured;
import service.ItemService;

/**
 *
 * @author Terance Wijesuriya
 */
@Path("/itemStock")
public class ItemJSOnService {

    @GET
    @Secured
    @Path("/getAllItemStocks")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<ItemStock> getAllItemStocks() {
        ItemService itemService = new ItemService();
        List<ItemStock> list = itemService.getAllItemStocks();
        return list;
    }

    @GET
    @Secured
    @Path("/getItemsByCategory/{idCategory}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<ItemStock> getItemsByCategory(@PathParam("idCategory") int idCategory) {
        ItemService itemService = new ItemService();
        List<ItemStock> list = itemService.getItemsByCategory(idCategory);
        return list;
    }

    @GET
    @Secured
    @Path("/getWarrantyItems/{warrantyStatus}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<ItemStock> getWarrantyItems(@PathParam("warrantyStatus") int warrantyStatus) {
        ItemService itemService = new ItemService();
        List<ItemStock> list = itemService.getWarrantyItems(warrantyStatus);
        return list;
    }

    @GET
    @Secured
    @Path("/getItemsByCategoryAndPrice/{idCatgeory}/{startPrice}/{endPrice}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<ItemStock> getItemsByCategoryAndPrice(@PathParam("idCatgeory") int idCatgeory,
            @PathParam("startPrice") double startPrice, @PathParam("endPrice") double endPrice) {
        ItemService itemService = new ItemService();
        List<ItemStock> list = itemService.getItemsByCategoryAndPrice(idCatgeory, startPrice, endPrice);
        return list;
    }

    @GET
    @Secured
    @Path("/getDeliverableItems/{deliveryStatus}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<ItemStock> getDeliverableItems(@PathParam("deliveryStatus") int deliveryStatus) {
        ItemService itemService = new ItemService();
        List<ItemStock> list = itemService.getDeliverableItems(deliveryStatus);
        return list;
    }
    
    @GET
    @Secured
    @Path("/getItemsForCustomizations/{idCategory}/{warrantyStatus}/{deliveryStatus}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<ItemStock> getItemsForCustomizations(@PathParam("idCategory")int idCategory, @PathParam("warrantyStatus")int warrantyStatus, @PathParam("deliveryStatus")int deliveryStatus) {
        ItemService itemService = new ItemService();
        List<ItemStock> list = itemService.getItemsForCustomizations(idCategory, warrantyStatus, deliveryStatus);
        return list;
    }
}
