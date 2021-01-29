/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.item;

import beans.ItemStock;
import dao.DAOConnectionInterface;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Terance Wijesuriya
 */
public interface ItemDAOInterface extends DAOConnectionInterface {

    List<ItemStock> getAllItemStocks(Session session);

    List<ItemStock> getItemsByCategory(int idCategory, Session session);

    List<ItemStock> getWarrantyItems(int warrantyStatus, Session session);

    List<ItemStock> getItemsByCategoryAndPrice(int idCatgeory, double startPrice, double endPrice, Session session);
    
    List<ItemStock> getDeliverableItems(int deliveryStatus, Session session);
    
    List<ItemStock> getItemsForCustomizations(int idCategory, int warrantyStatus, int deliveryStatus, Session session);

}
